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
				portIdentifier = CommPortIdentifier.getPortIdentifier(portName);//포트 사용가능 여부 확인.
				System.out.printf("Port Connect : %s\n", portName);//커넥트
				
				connectSerial(); //실행
				// Serial Initialization ....
				(new Thread(new SerialWriter())).start(); //Send Thread 비슷, can 네트워크에 들어간다는 뜻
				
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
				//살아있으면 포트 생성
				//시리얼 포트 = 소켓과 같음
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // 통신속도
						SerialPort.DATABITS_8, // 데이터 비트
						SerialPort.STOPBITS_1, // stop 비트
						SerialPort.PARITY_NONE); // 패리티
				//포트 생성후
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
			this.data = ":G11A9\r"; // 최초에 보내는 메세지. 참여하겠다는 메세지. 시작은 : 끝은 \r. 이 규칙을 지켜야만 메세지를 받을 수 있음.
		}

		public SerialWriter(String serialData) {
			// CheckSum Data 생성
			this.data = sendDataFormat(serialData);
			// : serial data + checksum \r 로 데이터를 생성한다.
		}

		public String sendDataFormat(String serialData) {
			serialData = serialData.toUpperCase();
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc; //각각 잘라낸 문자열을 더함
			}
			cdata = (cdata & 0xFF); //checksum. 간단한 암호화

			String returnData = ":";
			//원 Serial data 에 Checksum을 더한다.
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}

		public void run() {
			try {

				byte[] inputData = data.getBytes();
				//G11A9을 아웃풋에 던짐-> CAN 통신에 참여할 것이다.
				//참여한다는 것은? 자동차안의 ECU간은 선으로 연결되어 있다.
				//CAN BUS에 연결된 ECU들의 데이터를 IoT장비에 던지려면 참여하고 있어야 한다.
				out.write(inputData); 
										
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	

	
	// Asynchronized Receive Data
	// --------------------------------------------------------

	public void serialEvent(SerialPortEvent event) { //CAN 장비에서 데이터가 발생하면 받는다.
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
				// 받은 데이터 중, 데이터에 해당하는 영역만 남긴다.앞의 세개 뺴고 16개만이 데이터

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	

	

	public void close() throws IOException { //프로그램이 끝날때 close 한다.
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

		SendAndReceiveSerial ss = new SendAndReceiveSerial("COM8", true);//true는 크게 신경쓰지 않을 것. 내 장치중 어떤 포트를 이용하겠다.
		ss.sendSerial("W2810003B010000000000005011", "10003B01"); //CAN에 보낼 메세지와 ID. 데이터를 보낼 수 있는 칸은 10칸으로 정해져있음. 16진수를 사용.
		//ss.close();

	}

}





