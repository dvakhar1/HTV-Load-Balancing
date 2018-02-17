package logic;

import java.util.List;

import vo.AWSParamatersVO;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.EbsInstanceBlockDevice;
import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.InstanceBlockDeviceMapping;
import com.amazonaws.services.ec2.model.InstanceNetworkInterface;
import com.amazonaws.services.ec2.model.ProductCode;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.Tag;

public class DescribeAWSParameters {

	public DescribeInstancesResult describeInstance(AmazonEC2Client amazonEC2Client, DescribeInstancesRequest describeInstancesRequest) throws Exception{
		// TODO Auto-generated method stub

		try{		
		
			return amazonEC2Client.describeInstances();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public AWSParamatersVO loadDescribedInstance(DescribeInstancesResult describeInstancesResult, AWSParamatersVO describeInstanceVO) throws Exception{
		
		try{		
			
			List<Reservation> reservations = describeInstancesResult.getReservations();
			
			String instanceID = null;
			
			for (Reservation reservation : reservations) {
				
				for (Instance instance : reservation.getInstances()) {
					
					if(instance.getPublicIpAddress() != null){
					
						instanceID = instance.getInstanceId();
						
						describeInstanceVO.getInstanceIdList().add(instanceID);
						describeInstanceVO.getInstanceHash().put(instanceID, instance);
						
						describeInstanceVO.getArchitectureHash().put(instanceID, instance.getArchitecture());
						describeInstanceVO.getAmiLaunchIndexHash().put(instanceID,instance.getAmiLaunchIndex());
						describeInstanceVO.getBlockDeviceMappingsHash().put(instanceID, instance.getBlockDeviceMappings());
						describeInstanceVO.getClientTokenHash().put(instanceID, instance.getClientToken());
						describeInstanceVO.getEbsOptimizedHash().put(instanceID, instance.getEbsOptimized());
						describeInstanceVO.getHypervisorHash().put(instanceID, instance.getHypervisor());
						describeInstanceVO.getIamInstanceProfileHash().put(instanceID, instance.getIamInstanceProfile());
						describeInstanceVO.getImageIdHash().put(instanceID, instance.getImageId());
						describeInstanceVO.getInstanceLifecycleHash().put(instanceID, instance.getInstanceLifecycle());
						describeInstanceVO.getInstanceTypeHash().put(instanceID, instance.getInstanceType());
						describeInstanceVO.getKernelIdHash().put(instanceID, instance.getKernelId());
						describeInstanceVO.getKeyNameHash().put(instanceID, instance.getKeyName());
						describeInstanceVO.getLaunchTimeHash().put(instanceID, instance.getLaunchTime());
						describeInstanceVO.getMonitoringHash().put(instanceID, instance.getMonitoring());
						describeInstanceVO.getNetworkInterfacesHash().put(instanceID, instance.getNetworkInterfaces());
						describeInstanceVO.getPlacementHash().put(instanceID, instance.getPlacement());
						describeInstanceVO.getPlatformHash().put(instanceID, instance.getPlatform());
						describeInstanceVO.getPrivateDnsNameHash().put(instanceID, instance.getPrivateDnsName());
						describeInstanceVO.getPrivateIpAddressHash().put(instanceID, instance.getPrivateIpAddress());
						describeInstanceVO.getProductCodesHash().put(instanceID, instance.getProductCodes());
						describeInstanceVO.getPublicDnsNameHash().put(instanceID, instance.getPublicDnsName());
						describeInstanceVO.getPublicIpAddressHash().put(instanceID, instance.getPublicIpAddress());
						describeInstanceVO.getRamdiskIdHash().put(instanceID, instance.getRamdiskId());
						describeInstanceVO.getReservationIdHash().put(instanceID, reservation);
						describeInstanceVO.getRootDeviceNameHash().put(instanceID, instance.getRootDeviceName());
						describeInstanceVO.getRootDeviceTypeHash().put(instanceID, instance.getRootDeviceType());
						describeInstanceVO.getSecurityGroupsHash().put(instanceID, instance.getSecurityGroups());
						describeInstanceVO.getSourceDestCheckHash().put(instanceID, instance.getSourceDestCheck());
						describeInstanceVO.getSpotInstanceRequestIdHash().put(instanceID, instance.getSpotInstanceRequestId());
						describeInstanceVO.getSriovNetSupportHash().put(instanceID, instance.getSriovNetSupport());
						describeInstanceVO.getStateHash().put(instanceID, instance.getState());
						describeInstanceVO.getStateReasonHash().put(instanceID, instance.getStateReason());
						describeInstanceVO.getStateTransitionReasonHash().put(instanceID, instance.getStateTransitionReason());
						describeInstanceVO.getSubnetIdHash().put(instanceID, instance.getSubnetId());
						describeInstanceVO.getTagsHash().put(instanceID, instance.getTags());
						describeInstanceVO.getVirtualizationTypeHash().put(instanceID, instance.getVirtualizationType());
						describeInstanceVO.getVpcIdHash().put(instanceID, instance.getVpcId());
					}
					
				}
			}
			
			return describeInstanceVO;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void printInstanceDetails(DescribeInstancesResult describeInstancesResult) throws Exception{
		
		try{
			
			int i = 0;
			List<Reservation> reservations = describeInstancesResult.getReservations();
			
			for (Reservation reservation : reservations) {
				
				System.out.println("Finded Instance...\n");
				
				System.out.println("Reservation ID: "+reservation.getReservationId());
				System.out.println("Reservation Request ID: "+reservation.getRequesterId());
				System.out.println("Reservation Owner ID: "+reservation.getOwnerId());
				
				for(String grpName: reservation.getGroupNames()){
					System.out.println("Reservation Group Name: "+grpName);
				}
				
				for(GroupIdentifier grpIdentifier: reservation.getGroups()){
					System.out.println("Reservation Group Identifier ID: "+grpIdentifier.getGroupId());
					System.out.println("Reservation Group Identifier Name: "+grpIdentifier.getGroupName());
				}
				
				
				for (Instance instance : reservation.getInstances()) {
					
					System.out.println("\n-----------------Instance-----------------\n");
									
					System.out.println("Instance ID: "+instance.getInstanceId());
					System.out.println("Instance Arch: "+instance.getArchitecture());
					System.out.println("Instance ClientToken: "+instance.getClientToken());
					System.out.println("Instance HyperVisior: "+instance.getHypervisor());
					System.out.println("Instance ImageID: "+instance.getImageId());
					System.out.println("Instance LifeCycle: "+instance.getInstanceLifecycle());
					System.out.println("Instance InstanceType: "+instance.getInstanceType());
					System.out.println("Instance KernelID: "+instance.getKernelId());
					System.out.println("Instance KeyName: "+instance.getKeyName());
					System.out.println("Instance Platform: "+instance.getPlatform());
					System.out.println("Instance Private DNS Name: "+instance.getPrivateDnsName());
					System.out.println("Instance Private IP Address: "+instance.getPrivateIpAddress());
					System.out.println("Instance Public DNS Address: "+instance.getPublicDnsName());
					System.out.println("Instance Public IP Address: "+instance.getPublicIpAddress());
					System.out.println("Instance RAM Disk ID: "+instance.getRamdiskId());
					System.out.println("Instance Root Device Name: "+instance.getRootDeviceName());
					System.out.println("Instance Root Device Type: "+instance.getRootDeviceType());
					System.out.println("Instance Spot Instance Request ID: "+instance.getSpotInstanceRequestId());
					System.out.println("Instance Sriov Net Support: "+instance.getSriovNetSupport());
					System.out.println("Instance State Transition Reason: "+instance.getStateTransitionReason());
					System.out.println("Instance Subnet ID: "+instance.getSubnetId());
					System.out.println("Instance Virtulization Type: "+instance.getVirtualizationType());
					System.out.println("Instance VPC ID: "+instance.getVpcId());
					System.out.println("Instance AMI Launch Index: "+instance.getAmiLaunchIndex());
					
					i=0;
					for(InstanceBlockDeviceMapping instanceBlockDeviceMapping : instance.getBlockDeviceMappings()){
							System.out.println("Instance Block Device Mapping Name "+i +": "+instanceBlockDeviceMapping.getDeviceName());
							
							EbsInstanceBlockDevice blockDevice = instanceBlockDeviceMapping.getEbs();
							System.out.println("Instance Block Device Status "+i +": "+blockDevice.getStatus());
							System.out.println("Instance Block Device Status "+i +": "+blockDevice.getVolumeId());
							System.out.println("Instance Block Delete On Termination "+i +": "+blockDevice.getDeleteOnTermination());
							System.out.println("Instance Block Attach Time "+i +": "+blockDevice.getAttachTime());
							
							i++;
					}
					
					System.out.println("Instance EBS Optimized: "+instance.getEbsOptimized());
					System.out.println("Instance IAM Instance Profile: "+instance.getIamInstanceProfile());
					System.out.println("Instance Launch Time: "+instance.getLaunchTime());
					System.out.println("Instance Monitoring: "+instance.getMonitoring());
					
					i=0;
					for(InstanceNetworkInterface networkInterface : instance.getNetworkInterfaces()){
						System.out.println("Instance Network Interface Description "+i +": "+networkInterface.getDescription());
						System.out.println("Instance Network Interface MAC Address "+i +": "+networkInterface.getMacAddress());
						System.out.println("Instance Network Interface ID "+i +": "+networkInterface.getNetworkInterfaceId());
						System.out.println("Instance Network Interface Owner ID "+i +": "+networkInterface.getOwnerId());
						System.out.println("Instance Network Interface Private DNS Name "+i +": "+networkInterface.getPrivateDnsName());
						System.out.println("Instance Network Interface Private IP Address "+i +": "+networkInterface.getPrivateIpAddress());
						System.out.println("Instance Network Interface Status "+i +": "+networkInterface.getStatus());
						System.out.println("Instance Network Interface Subnet ID "+i +": "+networkInterface.getSubnetId());
						System.out.println("Instance Network Interface VPC ID "+i +": "+networkInterface.getVpcId());
						
						if(networkInterface.getAssociation() !=null){
							System.out.println("Instance Network Interface IP Owner ID "+i +": "+networkInterface.getAssociation().getIpOwnerId());
							System.out.println("Instance Network Interface Public DNS Name "+i +": "+networkInterface.getAssociation().getPublicDnsName());
							System.out.println("Instance Network Interface Public IP "+i +": "+networkInterface.getAssociation().getPublicIp());
							System.out.println("Instance Network Interface Attachment ID "+i +": "+networkInterface.getAttachment().getAttachmentId());
						}
						
						System.out.println("Instance Network Interface Attachment Status "+i +": "+networkInterface.getAttachment().getStatus());
						System.out.println("Instance Network Interface Attachment Device Index "+i +": "+networkInterface.getAttachment().getDeviceIndex());
						System.out.println("Instance Network Interface Attachment Time "+i +": "+networkInterface.getAttachment().getAttachTime());
						System.out.println("Instance Network Interface Attachment Deletion On Termination "+i +": "+networkInterface.getAttachment().getDeleteOnTermination());
						
						i++;
					}
					
					System.out.println("Instance Placement: "+instance.getPlacement());
					
					i=0;
					for(ProductCode productCode : instance.getProductCodes()){
						System.out.println("Instance Product Code ID "+i +": "+productCode.getProductCodeId());
						System.out.println("Instance Product Code Type "+i +": "+productCode.getProductCodeType());
						
						i++;
					}
					
					i=0;
					for(GroupIdentifier groupIdentifier : instance.getSecurityGroups()){
						System.out.println("Instance Security Groups ID "+i +": "+groupIdentifier.getGroupId());
						System.out.println("Instance Security Groups Name "+i +": "+groupIdentifier.getGroupName());
						
						i++;
					}
					
					System.out.println("Instance Source Destination Check: "+instance.getSourceDestCheck());
					System.out.println("Instance State: "+instance.getState());
					System.out.println("Instance State Reason: "+instance.getStateReason());
					
					i=0;
					for(Tag tag : instance.getTags()){
						System.out.println("Instance Tag Key "+i +": "+tag.getKey());
						System.out.println("Instance Tag Value "+i +": "+tag.getValue());
						
						i++;
					}
					
					System.out.println("\n**************Instance**************\n");
				}
			}
						
		}
		catch(Exception ex){
			throw ex;
		}
			
		
	}

}
