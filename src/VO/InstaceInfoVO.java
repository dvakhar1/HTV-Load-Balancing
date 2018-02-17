package vo;

import java.util.HashMap;

public class InstaceInfoVO {

	private String instanceId;
	private String hostname;
	private String ip;
	private String keyfilePath;
	private HashMap<String, String> commandList;
	
	public InstaceInfoVO(){
		commandList = new HashMap<String, String>();
	}
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getKeyfilePath() {
		return keyfilePath;
	}
	public void setKeyfilePath(String keyfilePath) {
		this.keyfilePath = keyfilePath;
	}
	public HashMap<String, String> getCommandList() {
		return commandList;
	}
	public void setCommandList(HashMap<String, String> commandList) {
		this.commandList = commandList;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	
}