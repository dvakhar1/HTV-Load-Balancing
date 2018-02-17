package vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestVO {
 
	private String URI;
	private String ip;
	private int port;
	private String requestType;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	private String queryString;
	
	public RequestVO(){
		URI = "";
		ip = "0.0.0.0";
		port = 80;
		queryString = "";
	}
	
	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) throws Exception{
		
		if(uRI != null)
			this.URI = uRI;
		else
			throw new NullPointerException("RequestVO: setPort(): URI is null.");
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) throws Exception{
		
		if(port>0 && port<65534)
			this.port = port;
		else
			throw new Exception("RequestVO: setPort(): Port value must be > 0 and <  65534.");
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) throws Exception{
		
		if(requestType.equalsIgnoreCase("get") || requestType.equalsIgnoreCase("post"))
			this.requestType = requestType;
		else
			throw new Exception("RequestVO: setRequestType(): Request must be ither GET or POST");
			
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
