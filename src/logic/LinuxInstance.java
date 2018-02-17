package logic;

import vo.AWSParamatersVO;
import vo.InstaceInfoVO;

import com.jcraft.jsch.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class LinuxInstance{
	
	public AWSParamatersVO executeOnLinux(String instanceId, String hostName, String ip, String keyfilePath, HashMap<String, String> commands, AWSParamatersVO awsParamatersVO) throws Exception{

		try{

			 Session session =makeConnection(hostName, ip, keyfilePath);
			 Channel channel= session.openChannel("exec");
				
			 String commandResult = "";
			 byte[] tmp;
			 
			 for(String key: commands.keySet()){
				
				 channel= session.openChannel("exec");
				 
				 String command = commands.get(key);
				 commandResult ="";
				 
				 ((ChannelExec)channel).setCommand(command);

				 ((ChannelExec)channel).setErrStream(System.err);

				 InputStream in=channel.getInputStream();

				 channel.connect();

				 tmp=new byte[1024];
				 
				 while(true){
					 
					 while(in.available()>0){
						 int i=in.read(tmp, 0, 1024);
						 if(i<0)break;

						 commandResult = commandResult + new String(tmp);
						 //System.out.print(commandResult);
					 }
					 if(channel.isClosed()){
						 if(in.available()>0) continue;
						 //System.out.println("exit-status: "+channel.getExitStatus());
						 break;
					 }
					 try{Thread.sleep(5000);}catch(Exception ee){}
				 }
				 
				 channel.disconnect();
				 
				 if(key.equalsIgnoreCase("MemoryFree"))
					 awsParamatersVO = formateMemoryFree(instanceId, commandResult, awsParamatersVO);
				 if(key.equalsIgnoreCase("MemoryTotal"))
					 awsParamatersVO = formateMemoryTotal(instanceId, commandResult, awsParamatersVO);
				 if(key.equalsIgnoreCase("Cpu_Usage"))
					 awsParamatersVO = CPU(instanceId, commandResult, awsParamatersVO);
					 
				 

			 }
			 session.disconnect(); 
			 
			 return awsParamatersVO;
			
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	private Session makeConnection(String hostName, String ip, String keyFilePath) throws Exception{
		
		try{
			

			JSch jsch=new JSch();
			jsch.addIdentity(keyFilePath);
			
			String host= hostName+"@"+ip; 
			
			String user=host.substring(0, host.indexOf('@'));
			host=host.substring(host.indexOf('@')+1);

			Session session=jsch.getSession(user, host, 22);

			// username and passphrase will be given via UserInfo interface.
			session.setHost(host);
			session.setUserInfo(new UserInfo() {
				
				@Override
				public void showMessage(String arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public boolean promptYesNo(String arg0) {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean promptPassword(String arg0) {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public boolean promptPassphrase(String arg0) {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String getPassphrase() {
					// TODO Auto-generated method stub
					return null;
				}
			});
			
			session.connect();
			
			return session;
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		
	}

	public AWSParamatersVO instanceFetch(List<InstaceInfoVO> instances, AWSParamatersVO awsParamatersVO) throws Exception{
		
		try{
			
			for(InstaceInfoVO instaceInfo: instances){
				
				awsParamatersVO = executeOnLinux(instaceInfo.getInstanceId() ,instaceInfo.getHostname(), instaceInfo.getIp(), instaceInfo.getKeyfilePath(), instaceInfo.getCommandList(), awsParamatersVO);
				
			}
			
			return awsParamatersVO;
		}
		catch(Exception exception){
			throw exception;
		}
	}
	
	
	private AWSParamatersVO formateMemoryFree(String instanceId, String commandResult, AWSParamatersVO awsParamatersVO) throws Exception{
		
		try{
			
			String[] x = commandResult.split(" ");
			
			awsParamatersVO.getFreeMemory().put(instanceId, x[x.length-2]);
			
			return awsParamatersVO;
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	private AWSParamatersVO formateMemoryTotal(String instanceId, String commandResult, AWSParamatersVO awsParamatersVO) throws Exception{
		
		try{
			
			String[] x = commandResult.split(" ");
		
			awsParamatersVO.getTotalMemory().put(instanceId, x[x.length-2]);
			
			return awsParamatersVO;
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
	private AWSParamatersVO CPU(String instanceId, String commandResult, AWSParamatersVO awsParamatersVO) throws Exception{
		
		try{
			
			awsParamatersVO.getCPUThresold().put(instanceId, commandResult);
			
			return awsParamatersVO;
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	
}
