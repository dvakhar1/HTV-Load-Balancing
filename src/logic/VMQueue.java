package logic;

import java.util.ArrayList;

public class VMQueue {
	
	private ArrayList<String> vm_queue;
	private Integer vm_queue_index;
	private boolean isEmpty = false;
	
	public VMQueue(){
		
		setVm_queue(new ArrayList<String>());
		setVm_queue_index(0);
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public Integer getVm_queue_index() {
		return vm_queue_index;
	}

	public void setVm_queue_index(Integer vm_queue_index) {
		this.vm_queue_index = vm_queue_index;
	}

	public ArrayList<String> getVm_queue() {
		return vm_queue;
	}

	public void setVm_queue(ArrayList<String> vm_queue) {
		this.vm_queue = vm_queue;
	}

	
	
}
