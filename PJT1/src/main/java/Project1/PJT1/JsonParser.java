package Project1.PJT1;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
	//검색결과 common값
	public static String jsonParserCommon(String data) {
		String common = null;
		
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
			jsonObject = (JSONObject) jsonObject.get("results");
			jsonObject = (JSONObject) jsonObject.get("common");
			
			common = jsonObject.toJSONString();
		} catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return common;
	}
	
	//검색결과 주소 list
	public static String jsonParserAddress(String data) {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		String address = null;
		
		try {
			jsonObject = (JSONObject) jsonParser.parse(data);
			jsonObject = (JSONObject) jsonObject.get("results");
	        jsonObject.remove("common");
	        
	        JSONArray jusoInfoArray = (JSONArray) jsonObject.get("juso");
	        
	        address = jusoInfoArray.toJSONString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
        
		return address;
	}
	
	//검색결과 test
	public static void jsonParserTest(String data) {
		 try {
			 	System.out.println(data);

	            JSONParser jsonParser = new JSONParser();
	             
	            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
	            jsonObject = (JSONObject) jsonObject.get("results");
	            jsonObject.remove("common");
	            //books의 배열을 추출
	            JSONArray jusoInfoArray = (JSONArray) jsonObject.get("juso");
	 
	            for(int i=0; i<jusoInfoArray.size(); i++){
	 
	                System.out.println("=juso"+i+" ===========================================");
	                 
	                //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
	                JSONObject jusoObject = (JSONObject) jusoInfoArray.get(i);
	                 
	                //JSON name으로 추출
	                System.out.println("jusoInfo: zipNo==>"+jusoObject.get("zipNo"));
	                System.out.println("jusoInfo: jibunAddr==>"+jusoObject.get("jibunAddr"));
	                System.out.println("jusoInfo: roadAddr==>"+jusoObject.get("roadAddr"));
	 
	            }
	 
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	


}
