package Project1.PJT1;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Uni {
	
	
	public static void getList(String data) {
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
	
	
	
public static void showItem(String data,int number) throws ParseException{
		
		try {
			ArrayList<String> aList = new ArrayList<String>();
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
	        jsonObject = (JSONObject) jsonObject.get("results");
	        jsonObject.remove("common");
	        //books의 배열을 추출
	        JSONArray jusoInfoArray = (JSONArray) jsonObject.get("juso");
	        
	        JSONObject jusoObject = (JSONObject) jusoInfoArray.get(number);
			
	       
	        
	        
	        aList.add((String) jusoObject.get("zipNo"));
	        aList.add((String) jusoObject.get("jibunAddr"));
	        aList.add((String) jusoObject.get("roadAddr"));
	        
	        
	        
	    	
	    	System.out.println("=juso"+number+" ===================================================");
	   	    System.out.println("jusoInfo: zipNo==>"+aList.get(0));
	        System.out.println("jusoInfo: jibunAddr==>"+aList.get(1));
	        System.out.println("jusoInfo: roadAddr==>"+aList.get(2));
	        System.out.println("==========================================================");
	    	
			
	       
	        	
	          
	 
	            
	    } catch (ParseException e) {
	        
	        e.printStackTrace();
	    }
		
		  
		}
	
	
	
	
	
	
	
	
	
	
	public static String[] getItem(String data,int number) throws ParseException{
		
		try {
			ArrayList<String> aList = new ArrayList<String>();
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
	        jsonObject = (JSONObject) jsonObject.get("results");
	        jsonObject.remove("common");
	        //books의 배열을 추출
	        JSONArray jusoInfoArray = (JSONArray) jsonObject.get("juso");
	        
	        JSONObject jusoObject = (JSONObject) jusoInfoArray.get(number);
			
	       
	        
	        
	        aList.add((String) jusoObject.get("zipNo"));
	        aList.add((String) jusoObject.get("jibunAddr"));
	        aList.add((String) jusoObject.get("roadAddr"));
			
	       
	        	
	          
	         String[] temp = {aList.get(0),aList.get(1),aList.get(2)};
	            return temp;
	    } catch (ParseException e) {
	        
	        e.printStackTrace();
	    }
		return null;
		  
		}
		
	
	
	
	
	
	
	
	

}
