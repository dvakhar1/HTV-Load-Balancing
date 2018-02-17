package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2Client;

import logic.InstanceController;
import logic.VM;
import logic.VMQueue;

/**
 * Servlet implementation class loadProject
 */
@WebServlet("/loadProject")
public class LoadProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			
			
			String accessKey = "AKIAI7RWKS22D3PZBTTQ";
			String secretKey = "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";
			Regions regions = Regions.AP_SOUTHEAST_1;
			
			Long refreshTime = 1L; // 1 Minute
			InstanceController.KeyRepoPath = "/run/media/mishal/Data/My Data/Accounts/AWS/Harshal Sir/Server/";
			InstanceController.system_type = "linux"; //windows or linux
			
			
			
			AmazonEC2Client amazonEC2Client = new AmazonEC2Client(new BasicAWSCredentials(accessKey, secretKey));
			amazonEC2Client.setRegion(Region.getRegion(regions));
			
			VMQueue vmQueue = new VMQueue();
			request.getSession().setAttribute("vmQueue", vmQueue);
			
			VM vm = new VM(amazonEC2Client, refreshTime, vmQueue);
			Thread thread2 = new Thread(vm);
			
			thread2.start();
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

}
