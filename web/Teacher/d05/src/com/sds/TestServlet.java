package com.sds;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/TestServlet", "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?serviceKey=NuvoUrkE7SSIULP315eGuE9WgDLpDXwL3jkfiG9ftsOB63tR6TPYmNT45fOg%2FKSOSN6n%2BWYJp1dE7bHXzQyfzg%3D%3D&pageNo=1&numOfRows=10&dataType=XML&dataCd=ASOS&dateCd=DAY&startDt=20100101&endDt=20100601&stnIds=108&";
		String str = getRequest(url, "");
		System.out.println(str);
		response.setContentType("text/xml;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println(str);
	}

	public static String getRequest(String url, String parameter) {
		try {
			// �����͸� json ���� ������ ������.
			// ������ �����ϰ� ��������ϴٸ� Gson�� �̿��ϸ� ��ȯ�� �� �ֽ��ϴ�.
			String param = "{\"param\":\"" + parameter + "\"} ";
			// url�� �ν��Ͻ��� �����.
			URL uri = new URL(url);
			// HttpURLConnection �ν��Ͻ��� �����´�.
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			// Web Method�� Post Ÿ��
			connection.setRequestMethod("GET");
			// Json �������� ������
			//connection.setRequestProperty("ContentType", "application/json");
			// Header �ؿ� ���� ������ ���� ��Ʈ���� �޴´�.
//			connection.setDoOutput(true);
//			try (DataOutputStream output = new DataOutputStream(connection.getOutputStream())) {
//				output.writeBytes(param);
//				output.flush();
//			}
			// ��û�Ѵ�. 200�̸� �����̴�.
			int code = connection.getResponseCode();
			if (code == 200) {
				// ���� �� body ������ stream�� �޴´�.
				try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String line;
					StringBuffer buffer = new StringBuffer();
					while ((line = input.readLine()) != null) {
						buffer.append(line);
					}
					return buffer.toString();
				}
			}
			return code + "";
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
