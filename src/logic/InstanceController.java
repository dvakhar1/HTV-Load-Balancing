package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;

import vo.AWSParamatersVO;
import vo.InstaceInfoVO;

public class InstanceController {

	public static String KeyRepoPath = null;
	public static String system_type = null;
	
	public AWSParamatersVO DescribeMe(AmazonEC2Client amazonEC2Client) throws Exception{
		
		try{
			
			if(amazonEC2Client != null){
			
				System.out.println(new Date().toString() +": Loading...");
				
				AWSParamatersVO awsParamatersVO = new AWSParamatersVO();
						
			    findAWSParameters(amazonEC2Client, awsParamatersVO);
			
			    
			    HashMap<String, String> commands = new HashMap<String, String>();
				commands.put("MemoryFree","egrep 'MemFree' /proc/meminfo");
				commands.put("MemoryTotal","egrep 'MemTotal' /proc/meminfo");
				commands.put("Cpu_Usage", "echo $[100-$(vmstat|tail -1|awk '{print $15}')]");
				
				
				List<InstaceInfoVO> instaceInfos = new ArrayList<InstaceInfoVO>();
				InstaceInfoVO info = null;
				
				for(String ids: awsParamatersVO.getInstanceIdList()){

					
					if(awsParamatersVO.getPublicIpAddressHash().get(ids) != null){
						
						info = new InstaceInfoVO();
						
						info.setCommandList(commands);
						info.setHostname("ubuntu");
						info.setInstanceId(ids);
						info.setIp(awsParamatersVO.getPublicIpAddressHash().get(ids));
						info.setKeyfilePath(KeyRepoPath+awsParamatersVO.getKeyNameHash().get(ids)+".pem");
						
						instaceInfos.add(info);
					}
					
					
				}
				
				findCustomeParameters(instaceInfos, awsParamatersVO);
				
				System.out.println(new Date().toString() +": Loading complete.");
				System.out.println();
				
				return awsParamatersVO;
			}
			else
				throw new NullPointerException("InstanceController--> instances are empty.");
		}
		catch(Exception exception){
			throw exception;
		}
	}
	
	private AWSParamatersVO findAWSParameters(AmazonEC2Client amazonEC2Client, AWSParamatersVO awsParamatersVO) throws Exception{
		
		try{
			
			if(amazonEC2Client != null){
				
//				System.out.println("Calculating AWS defaults");
				
				DescribeAWSParameters describeAWSParameters = new DescribeAWSParameters();
				DescribeInstancesResult describeInstancesResult = describeAWSParameters.describeInstance(amazonEC2Client, new DescribeInstancesRequest());
				
				return describeAWSParameters.loadDescribedInstance(describeInstancesResult, awsParamatersVO);
				
			}
			else
				throw new NullPointerException("findAWSParameters--> instances are empty.");
		}
		catch(Exception exception){
			throw exception;
		}
	}
	
	
	private AWSParamatersVO findCustomeParameters(List<InstaceInfoVO> instaceInfos, AWSParamatersVO awsParamatersVO) throws Exception{
		
		try{
			
			if(instaceInfos != null && awsParamatersVO != null){
				
//				System.out.println("Info: Calculating custom parameters");
				
				LinuxInstance linuxInstance = new  LinuxInstance();
				awsParamatersVO = linuxInstance.instanceFetch(instaceInfos, awsParamatersVO);
				
				return awsParamatersVO;
			}
			else
				throw new NullPointerException("findCustomeParameters--> instaceInfos and awsParamatersVO are empty.");
		}
		catch(Exception exception){
			throw exception;
		}
	}
	
	

	
	/*@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		try{
			
			AmazonEC2Client amazonEC2Client = new AmazonEC2Client(new ProfileCredentialsProvider("Mishal Shah"));
			amazonEC2Client.setRegion(Regions.US_WEST_2);
			
			InstanceController instanceController = new InstanceController();
			AWSParamatersVO awsParamatersVO = instanceController.DescribeMe(amazonEC2Client);
			
			System.out.println("Fetch Successfull: "+awsParamatersVO +"\n\n");
			
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}*/
}
