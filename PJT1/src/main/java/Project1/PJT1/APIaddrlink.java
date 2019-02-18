package Project1.PJT1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class APIaddrlink {
	private final static String confmKey = "U01TX0FVVEgyMDE5MDIxNDEwMzE1ODEwODUwNzI=";
	
	public static String searchAddress(String currentPage, String countPerPage, String keyword) throws IOException {
		// 요청변수 설정
		
		String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+
				"&countPerPage="+countPerPage+
				"&keyword="+URLEncoder.encode(keyword,"UTF-8")+
				"&confmKey="+confmKey+
				"&resultType=json";
		
		URL url = new URL(apiUrl);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		
		String tempStr = br.readLine();
		br.close();
		
		return tempStr;
	}
}
