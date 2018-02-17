package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.amazonaws.services.ec2.AmazonEC2Client;

import vo.AWSParamatersVO;

public class VM implements Runnable{

	public static boolean stopThread = true;
	private Long refreshTime = 1L;
	
	private AmazonEC2Client amazonEC2Client;
	private VMQueue vmQueue;
	
	public VM(AmazonEC2Client amazonEC2Client, Long refreshTime, VMQueue vmQueue) throws Exception{
		
		this.amazonEC2Client = amazonEC2Client;
		this.vmQueue = vmQueue;
		
	}
	
	public void run(){
		
		try{
			
			while(stopThread){
				
				/* Fetching AWS Parameters */
				InstanceController instanceController = new InstanceController();
				AWSParamatersVO awsParamatersVO = instanceController.DescribeMe(amazonEC2Client);
				
				/* Storing AWS CPU Parameter */
				HashMap<String, String> cpu = awsParamatersVO.getCPUThresold();
				
				
				for(String id: cpu.keySet()){		
					System.out.println(new Date().toString() +": " +id +" CPU: "+cpu.get(id).trim() +"%");
				}
				System.out.println();
				
				
				/* Fetching AWS Memory Parameter */
				HashMap<String, String> memory = awsParamatersVO.getFreeMemory();
					
				for(String id: memory.keySet()){
					
					Float tmp = Sort_HashMap.calculate100(Float.parseFloat(awsParamatersVO.getTotalMemory().get(id)), Float.parseFloat(awsParamatersVO.getFreeMemory().get(id)));
					memory.replace(id, Float.toString(tmp));
					
					System.out.println("Info: "+id +" Memory: "+tmp +"%");
				}
				
				
				/* Calculation of utilization_factor */
				HashMap<String, String>  utilizationFactor = new HashMap<String, String>();
				
				for(String id: awsParamatersVO.getInstanceIdList()){
					
					String value = Float.toString((Float.parseFloat(cpu.get(id)) + Float.parseFloat(memory.get(id))) / 2);
					utilizationFactor.put(id, value);
					
					System.out.println("Info: "+id +" Utilization: "+value +"%");
				}
				
				utilizationFactor = (HashMap<String, String>) Sort_HashMap.sortByValue(utilizationFactor);
				
				
				ArrayList<String>  vm_Queue = new ArrayList<String>();
				
				System.out.println(new Date().toString() +": Printing Queue....");
				for (String intsanceId : utilizationFactor.keySet()) {
					
					vm_Queue.add(awsParamatersVO.getPublicIpAddressHash().get(intsanceId));
					System.out.println(new Date().toString() +": " +intsanceId +" is  in queue with public ip "+awsParamatersVO.getPublicIpAddressHash().get(intsanceId));
						
				}
				
				vmQueue.setVm_queue(vm_Queue);
				vmQueue.setVm_queue_index(0);
				vmQueue.setEmpty(false);
				
				Thread.sleep(1000*60*refreshTime); // 1 min refresh time
				
				System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++=\n");
			}
			
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		
	}
	
}
