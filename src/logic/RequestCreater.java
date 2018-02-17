package logic;

import vo.RequestVO;

public class RequestCreater {
	
	public String formatRequest(RequestVO requestVO) throws Exception{
		
		try{
			
			String url = "http://";
			
			if(!requestVO.getIp().equals("0.0.0.0")){
				url = url+ requestVO.getIp() +":" +requestVO.getPort() +requestVO.getURI();
			}
			else{
				throw new Exception("Unwanted Ip Exception.");
			}
		
			return url;
		}
		catch(Exception exception){
			throw exception;
		}
	}
	
	/*public static void main(String[] args){
		
		try{
			
			String oldURL = "/Request_v1/ProcessRequest";
			String ip = "192.168.2.1";
			
			System.out.println("Old URL: "+oldURL);
					
			RequestCreater creater = new  RequestCreater();
			String newURL = creater.formatRequest(oldURL, ip, 8080);
			
			System.out.println("\nNew URL: "+newURL);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}*/
}
