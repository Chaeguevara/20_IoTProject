package com.sds;

import java.io.BufferedReader;
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

@WebServlet({ "/WeatherServlet", "/weather" })
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       String urlstr = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?serviceKey=NuvoUrkE7SSIULP315eGuE9WgDLpDXwL3jkfiG9ftsOB63tR6TPYmNT45fOg%2FKSOSN6n%2BWYJp1dE7bHXzQyfzg%3D%3D&pageNo=1&numOfRows=10&dataType=XML&dataCd=ASOS&dateCd=DAY&startDt=20100101&endDt=20100601&stnIds=108&";
       String xmlstr = getRequest(urlstr, "");
       response.setContentType("text/xml;charset=euc-kr");
       PrintWriter out = response.getWriter();
       out.print(xmlstr);
	}

	public String getRequest(String url, String parameter) {

		try {
			String param = "{\"param\":\"" + parameter + "\"} ";
			URL uri = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			connection.setRequestMethod("GET");
			int code = connection.getResponseCode();
			if (code == 200) {
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
