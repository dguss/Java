package Project1.PJT1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.parser.ParseException;


public class App 
{
	private final static Logger log = Logger.getLogger(App.class.getName());
	
    public static void main( String[] args ) throws IOException, ParseException
    {
    	
    	Scanner sc = new Scanner(System.in);
    	log.setLevel(Level.INFO);
    	log.info("========= 주소검색 결과 start =========");
    	// 요청변수 설정
    	String currentPage = "1"; 
    	String countPerPage = "5";
    	
    	System.out.print("검색할 도로명을 입력해주세요: ");
    	String keyword = sc.next();
    	
    	String resultInfo = APIaddrlink.searchAddress(currentPage, countPerPage, keyword);
    	String commonInfo = null;
    	String addressInfo = null;
    	

    	Uni.getList(resultInfo);
    	
    	commonInfo = JsonParser.jsonParserCommon(resultInfo);
    	addressInfo = JsonParser.jsonParserAddress(resultInfo);
    	
    	String strArray[] = addressInfo.split("},");
    	
  
    	  
    
    	
    	
    	
    	System.out.println("\n#########################################################\n");
    	
    	System.out.print("몇 번째 항목의 주소가 보여지길 원하는지 입력하세요:");
    	
    	int num = sc.nextInt();
    	
    	Uni.showItem(resultInfo,num);
    	
    	
    	sc.close();
    	
//    	System.out.println(strArray[2]);
//    	for(int i=0; i<strArray.length; i++){
//    		System.out.println(strArray[i]);
//    	}
    	
    	log.info("========= commonInfo =========");
    	System.out.println(commonInfo);
    	log.info("========= addressInfo =========");
    	System.out.println(addressInfo);
    	log.info("========= 주소검색 결과 end =========");
    	
    	
    	String[] tmp = Uni.getItem(resultInfo,num);
    	 
    	
    	File file = new File("/C:/Users/B.S.YU/Desktop/도로명주소 검색 결과.txt");
		
		  try {
		     
		      FileWriter fw = new FileWriter(file);
		      fw.write("#검색어: " + keyword+"\r\n \r\n");
		      fw.write("#검색결과: ");
		      fw.write("우편번호: " + tmp[0]+"\r\n");
		      fw.write("\t  도로명주소: " + tmp[1]+"\r\n");
		      fw.write("\t  지번주소: " + tmp[2]+"\r\n");
		      
		      fw.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  
  	
    	
    	
    	
    	
    }
}
