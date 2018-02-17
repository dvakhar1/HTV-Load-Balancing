package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.RequestCreater;
import logic.VMQueue;
import vo.RequestVO;

/**
 * Servlet implementation class SendRequest
 */
@WebServlet("/sendRequest")
public class SendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestCreater requestCreator = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequest() {
        super();
        // TODO Auto-generated constructor stub
        requestCreator = new RequestCreater();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			
			Long time = System.currentTimeMillis();
			
			String email = request.getParameter("email");
			
			RequestVO requestVO = new RequestVO();
			requestVO.setHttpServletRequest(request);
			requestVO.setHttpServletResponse(response);
			requestVO.setPort(8080);
			
			VMQueue vmQueue = (VMQueue) request.getSession().getAttribute("vmQueue");
			
			ArrayList<String> vmList = vmQueue.getVm_queue();
			
			if(vmList != null && !vmList.isEmpty()){
				
				System.out.println();
				
				int index = vmQueue.getVm_queue_index();
				
				System.out.println("Request: "+email);
				
				String publicIP = vmList.get(index);
				System.out.println("Instance: "+publicIP);
				
				requestVO.setIp(publicIP);
				String newURL = requestCreator.formatRequest(requestVO);
				System.out.println("Redirect to: "+newURL);
				
				if(index == (vmList.size()-1)){
					vmQueue.setVm_queue_index(0);
				}
				else{
					vmQueue.setVm_queue_index(index+1);
				}
				
				System.out.println();
				System.out.println("Response Time: "+(System.currentTimeMillis()-time));
				System.out.println();
				
				response.sendRedirect(newURL);
				
			}
			else
				response.sendRedirect(request.getContextPath() +"/error.jsp");
			
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally {
			System.out.println();
		}
		
	}
}
