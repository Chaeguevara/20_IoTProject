package com.can;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SendAndReceiveSerial implements SerialPortEventListener {
	private BufferedInputStream bin;
	private InputStream in;
	private OutputStream out;
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private String result;
	private String rawCanID, rawTotal;
	// private boolean start = false;

	public SendAndReceiveSerial(String portName, boolean mode) {

		try {
			if (mode == true) {
				portIdentifier = CommPortIdentifier.getPortIdentifier(portName);//��Ʈ ��밡�� ���� Ȯ��.
				System.out.printf("Port Connect : %s\n", portName);//Ŀ��Ʈ
				
				connectSerial(); //����
				// Serial Initialization ....
				(new Thread(new SerialWriter())).start(); //Send Thread ���, can ��Ʈ��ũ�� ���ٴ� ��
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void connectSerial() throws Exception {

		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 5000);
			if (commPort instanceof SerialPort) {
				//��������� ��Ʈ ����
				//�ø��� ��Ʈ = ���ϰ� ����
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // ��żӵ�
						SerialPort.DATABITS_8, // ������ ��Ʈ
						SerialPort.STOPBITS_1, // stop ��Ʈ
						SerialPort.PARITY_NONE); // �и�Ƽ
				//��Ʈ ������
				//in stream
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
				//out stream
				out = serialPort.getOutputStream();
			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	public void sendSerial(String rawTotal, String rawCanID) {
		this.rawTotal = rawTotal; //ID + data
		this.rawCanID = rawCanID;
		// System.out.println("send: " + rawTotal);
		try {
			// Thread.sleep(50);
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread sendTread = 
				new Thread(new SerialWriter(rawTotal));
		sendTread.start();
	}

	private class SerialWriter implements Runnable {
		String data;

		public SerialWriter() {
			this.data = ":G11A9\r"; // ���ʿ� ������ �޼���. �����ϰڴٴ� �޼���. ������ : ���� \r. �� ��Ģ�� ���Ѿ߸� �޼����� ���� �� ����.
		}

		public SerialWriter(String serialData) {
			// CheckSum Data ����
			this.data = sendDataFormat(serialData);
			// : serial data + checksum \r �� �����͸� �����Ѵ�.
		}

		public String sendDataFormat(String serialData) {
			serialData = serialData.toUpperCase();
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc; //���� �߶� ���ڿ��� ����
			}
			cdata = (cdata & 0xFF); //checksum. ������ ��ȣȭ

			String returnData = ":";
			//�� Serial data �� Checksum�� ���Ѵ�.
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}

		public void run() {
			try {

				byte[] inputData = data.getBytes();
				//G11A9�� �ƿ�ǲ�� ����-> CAN ��ſ� ������ ���̴�.
				//�����Ѵٴ� ����? �ڵ������� ECU���� ������ ����Ǿ� �ִ�.
				//CAN BUS�� ����� ECU���� �����͸� IoT��� �������� �����ϰ� �־�� �Ѵ�.
				out.write(inputData); 
										
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	

	
	// Asynchronized Receive Data
	// --------------------------------------------------------

	public void serialEvent(SerialPortEvent event) { //CAN ��񿡼� �����Ͱ� �߻��ϸ� �޴´�.
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[128];

			try {

				while (bin.available() > 0) {
					int numBytes = bin.read(readBuffer);
				}

				String ss = new String(readBuffer);
				System.out.println("Receive Low Data:" + ss + "||");
				// ���� ������ ��, �����Ϳ� �ش��ϴ� ������ �����.���� ���� ���� 16������ ������

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	

	

	public void close() throws IOException { //���α׷��� ������ close �Ѵ�.
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (in != null) {
			in.close();
		}
		if (out != null) {
			out.close();
		}
		if (commPort != null) {
			commPort.close();
		}

	}

	

	public static void main(String args[]) throws IOException {

		SendAndReceiveSerial ss = new SendAndReceiveSerial("COM8", true);//true�� ũ�� �Ű澲�� ���� ��. �� ��ġ�� � ��Ʈ�� �̿��ϰڴ�.
		ss.sendSerial("W2810003B010000000000005011", "10003B01"); //CAN�� ���� �޼����� ID. �����͸� ���� �� �ִ� ĭ�� 10ĭ���� ����������. 16������ ���.
		//ss.close();

	}

}




