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
			// 데이터를 json 형식 값으로 보낸다.
			// 예제로 간략하게 만들었습니다만 Gson을 이용하면 변환할 수 있습니다.
			String param = "{\"param\":\"" + parameter + "\"} ";
			// url를 인스턴스를 만든다.
			URL uri = new URL(url);
			// HttpURLConnection 인스턴스를 가져온다.
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			// Web Method는 Post 타입
			connection.setRequestMethod("GET");
			// Json 형식으로 보내고
			//connection.setRequestProperty("ContentType", "application/json");
			// Header 밑에 값을 보내기 위한 스트립을 받는다.
//			connection.setDoOutput(true);
//			try (DataOutputStream output = new DataOutputStream(connection.getOutputStream())) {
//				output.writeBytes(param);
//				output.flush();
//			}
			// 요청한다. 200이면 정상이다.
			int code = connection.getResponseCode();
			if (code == 200) {
				// 응답 온 body 내용의 stream을 받는다.
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
