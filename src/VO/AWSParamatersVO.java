package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.services.ec2.model.IamInstanceProfile;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.InstanceBlockDeviceMapping;
import com.amazonaws.services.ec2.model.InstanceNetworkInterface;
import com.amazonaws.services.ec2.model.InstanceState;
import com.amazonaws.services.ec2.model.Monitoring;
import com.amazonaws.services.ec2.model.Placement;
import com.amazonaws.services.ec2.model.ProductCode;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.StateReason;
import com.amazonaws.services.ec2.model.Tag;

public class AWSParamatersVO {

	private ArrayList<String> InstanceIdList = new ArrayList<String>();
	private HashMap<String, Instance> InstanceHash = new HashMap<String, Instance>();
	private HashMap<String, Reservation> ReservationIdHash = new HashMap<String, Reservation>();
	private HashMap<String, String> ArchitectureHash = new HashMap<String, String>();
	private HashMap<String, String> ClientTokenHash = new HashMap<String, String>();
	private HashMap<String, String> HypervisorHash = new HashMap<String, String>();
	private HashMap<String, String> ImageIdHash = new HashMap<String, String>();
	private HashMap<String, String> InstanceLifecycleHash = new HashMap<String, String>();
	private HashMap<String, String> InstanceTypeHash = new HashMap<String, String>();
	private HashMap<String, String> KernelIdHash = new HashMap<String, String>();
	private HashMap<String, String> KeyNameHash = new HashMap<String, String>();
	private HashMap<String, String> PlatformHash = new HashMap<String, String>();
	private HashMap<String, String> PrivateDnsNameHash = new HashMap<String, String>();
	private HashMap<String, String> PrivateIpAddressHash = new HashMap<String, String>();
	private HashMap<String, String> PublicDnsNameHash = new HashMap<String, String>();
	private HashMap<String, String> PublicIpAddressHash = new HashMap<String, String>();
	private HashMap<String, String> RamdiskIdHash = new HashMap<String, String>();
	private HashMap<String, String> RootDeviceNameHash = new HashMap<String, String>();
	private HashMap<String, String> RootDeviceTypeHash = new HashMap<String, String>();
	private HashMap<String, String> SpotInstanceRequestIdHash = new HashMap<String, String>();
	private HashMap<String, String> SriovNetSupportHash = new HashMap<String, String>();
	private HashMap<String, String> StateTransitionReasonHash = new HashMap<String, String>();
	private HashMap<String, String> SubnetIdHash = new HashMap<String, String>();
	private HashMap<String, String> VirtualizationTypeHash = new HashMap<String, String>();
	private HashMap<String, String> VpcIdHash = new HashMap<String, String>();
	private HashMap<String, Integer> AmiLaunchIndexHash = new HashMap<String, Integer>();
	private HashMap<String, List<InstanceBlockDeviceMapping>> BlockDeviceMappingsHash = new HashMap<String, List<InstanceBlockDeviceMapping>>();
	private HashMap<String, Boolean> EbsOptimizedHash = new HashMap<String, Boolean>();
	private HashMap<String, IamInstanceProfile> IamInstanceProfileHash = new HashMap<String, IamInstanceProfile>();
	private HashMap<String, Date> LaunchTimeHash = new HashMap<String, Date>();
	private HashMap<String, Monitoring> MonitoringHash = new HashMap<String, Monitoring>();
	private HashMap<String, List<InstanceNetworkInterface>> NetworkInterfacesHash = new HashMap<String, List<InstanceNetworkInterface>>();
	private HashMap<String, Placement> PlacementHash = new HashMap<String, Placement>();
	private HashMap<String, List<ProductCode>> ProductCodesHash = new HashMap<String, List<ProductCode>>();
	private HashMap<String, List<GroupIdentifier>> SecurityGroupsHash = new HashMap<String, List<GroupIdentifier>>();
	private HashMap<String, Boolean> SourceDestCheckHash = new HashMap<String, Boolean>();
	private HashMap<String, InstanceState> StateHash = new HashMap<String, InstanceState>();
	private HashMap<String, StateReason> StateReasonHash = new HashMap<String, StateReason>();
	private HashMap<String, List<Tag>> TagsHash = new HashMap<String, List<Tag>>();
	
	private HashMap<String, String> TotalMemory = new HashMap<String, String>();
	private HashMap<String, String> FreeMemory = new HashMap<String, String>();
	private HashMap<String, String> CPUThresold = new HashMap<String, String>();
	
	
	public HashMap<String, String> getTotalMemory() {
		return TotalMemory;
	}
	public void setTotalMemory(HashMap<String, String> totalMemory) {
		TotalMemory = totalMemory;
	}
	public HashMap<String, String> getFreeMemory() {
		return FreeMemory;
	}
	public void setFreeMemory(HashMap<String, String> freeMemory) {
		FreeMemory = freeMemory;
	}
	public HashMap<String, String> getCPUThresold() {
		return CPUThresold;
	}
	public void setCPUThresold(HashMap<String, String> cPUThresold) {
		CPUThresold = cPUThresold;
	}
	public HashMap<String, String> getArchitectureHash() {
		return ArchitectureHash;
	}
	public void setArchitectureHash(HashMap<String, String> architectureHash) {
		ArchitectureHash = architectureHash;
	}
	public HashMap<String, String> getClientTokenHash() {
		return ClientTokenHash;
	}
	public void setClientTokenHash(HashMap<String, String> clientTokenHash) {
		ClientTokenHash = clientTokenHash;
	}
	public HashMap<String, String> getHypervisorHash() {
		return HypervisorHash;
	}
	public void setHypervisorHash(HashMap<String, String> hypervisorHash) {
		HypervisorHash = hypervisorHash;
	}
	public HashMap<String, String> getImageIdHash() {
		return ImageIdHash;
	}
	public void setImageIdHash(HashMap<String, String> imageIdHash) {
		ImageIdHash = imageIdHash;
	}
	public HashMap<String, String> getInstanceLifecycleHash() {
		return InstanceLifecycleHash;
	}
	public void setInstanceLifecycleHash(
			HashMap<String, String> instanceLifecycleHash) {
		InstanceLifecycleHash = instanceLifecycleHash;
	}
	public HashMap<String, String> getInstanceTypeHash() {
		return InstanceTypeHash;
	}
	public void setInstanceTypeHash(HashMap<String, String> instanceTypeHash) {
		InstanceTypeHash = instanceTypeHash;
	}
	public HashMap<String, String> getKernelIdHash() {
		return KernelIdHash;
	}
	public void setKernelIdHash(HashMap<String, String> kernelIdHash) {
		KernelIdHash = kernelIdHash;
	}
	public HashMap<String, String> getKeyNameHash() {
		return KeyNameHash;
	}
	public void setKeyNameHash(HashMap<String, String> keyNameHash) {
		KeyNameHash = keyNameHash;
	}
	public HashMap<String, String> getPlatformHash() {
		return PlatformHash;
	}
	public void setPlatformHash(HashMap<String, String> platformHash) {
		PlatformHash = platformHash;
	}
	public HashMap<String, String> getPrivateDnsNameHash() {
		return PrivateDnsNameHash;
	}
	public void setPrivateDnsNameHash(HashMap<String, String> privateDnsNameHash) {
		PrivateDnsNameHash = privateDnsNameHash;
	}
	public HashMap<String, String> getPrivateIpAddressHash() {
		return PrivateIpAddressHash;
	}
	public void setPrivateIpAddressHash(HashMap<String, String> privateIpAddressHash) {
		PrivateIpAddressHash = privateIpAddressHash;
	}
	public HashMap<String, String> getPublicDnsNameHash() {
		return PublicDnsNameHash;
	}
	public void setPublicDnsNameHash(HashMap<String, String> publicDnsNameHash) {
		PublicDnsNameHash = publicDnsNameHash;
	}
	public HashMap<String, String> getPublicIpAddressHash() {
		return PublicIpAddressHash;
	}
	public void setPublicIpAddressHash(HashMap<String, String> publicIpAddressHash) {
		PublicIpAddressHash = publicIpAddressHash;
	}
	public HashMap<String, String> getRamdiskIdHash() {
		return RamdiskIdHash;
	}
	public void setRamdiskIdHash(HashMap<String, String> ramdiskIdHash) {
		RamdiskIdHash = ramdiskIdHash;
	}
	public HashMap<String, String> getRootDeviceNameHash() {
		return RootDeviceNameHash;
	}
	public void setRootDeviceNameHash(HashMap<String, String> rootDeviceNameHash) {
		RootDeviceNameHash = rootDeviceNameHash;
	}
	public HashMap<String, String> getRootDeviceTypeHash() {
		return RootDeviceTypeHash;
	}
	public void setRootDeviceTypeHash(HashMap<String, String> rootDeviceTypeHash) {
		RootDeviceTypeHash = rootDeviceTypeHash;
	}
	public HashMap<String, String> getSpotInstanceRequestIdHash() {
		return SpotInstanceRequestIdHash;
	}
	public void setSpotInstanceRequestIdHash(
			HashMap<String, String> spotInstanceRequestIdHash) {
		SpotInstanceRequestIdHash = spotInstanceRequestIdHash;
	}
	public HashMap<String, String> getSriovNetSupportHash() {
		return SriovNetSupportHash;
	}
	public void setSriovNetSupportHash(HashMap<String, String> sriovNetSupportHash) {
		SriovNetSupportHash = sriovNetSupportHash;
	}
	public HashMap<String, String> getStateTransitionReasonHash() {
		return StateTransitionReasonHash;
	}
	public void setStateTransitionReasonHash(
			HashMap<String, String> stateTransitionReasonHash) {
		StateTransitionReasonHash = stateTransitionReasonHash;
	}
	public HashMap<String, String> getSubnetIdHash() {
		return SubnetIdHash;
	}
	public void setSubnetIdHash(HashMap<String, String> subnetIdHash) {
		SubnetIdHash = subnetIdHash;
	}
	public HashMap<String, String> getVirtualizationTypeHash() {
		return VirtualizationTypeHash;
	}
	public void setVirtualizationTypeHash(
			HashMap<String, String> virtualizationTypeHash) {
		VirtualizationTypeHash = virtualizationTypeHash;
	}
	public HashMap<String, String> getVpcIdHash() {
		return VpcIdHash;
	}
	public void setVpcIdHash(HashMap<String, String> vpcIdHash) {
		VpcIdHash = vpcIdHash;
	}
	public HashMap<String, Integer> getAmiLaunchIndexHash() {
		return AmiLaunchIndexHash;
	}
	public void setAmiLaunchIndexHash(HashMap<String, Integer> amiLaunchIndexHash) {
		AmiLaunchIndexHash = amiLaunchIndexHash;
	}
	public HashMap<String, List<InstanceBlockDeviceMapping>> getBlockDeviceMappingsHash() {
		return BlockDeviceMappingsHash;
	}
	public void setBlockDeviceMappingsHash(
			HashMap<String, List<InstanceBlockDeviceMapping>> blockDeviceMappingsHash) {
		BlockDeviceMappingsHash = blockDeviceMappingsHash;
	}
	public HashMap<String, Boolean> getEbsOptimizedHash() {
		return EbsOptimizedHash;
	}
	public void setEbsOptimizedHash(HashMap<String, Boolean> ebsOptimizedHash) {
		EbsOptimizedHash = ebsOptimizedHash;
	}
	public HashMap<String, IamInstanceProfile> getIamInstanceProfileHash() {
		return IamInstanceProfileHash;
	}
	public void setIamInstanceProfileHash(
			HashMap<String, IamInstanceProfile> iamInstanceProfileHash) {
		IamInstanceProfileHash = iamInstanceProfileHash;
	}
	public HashMap<String, Date> getLaunchTimeHash() {
		return LaunchTimeHash;
	}
	public void setLaunchTimeHash(HashMap<String, Date> launchTimeHash) {
		LaunchTimeHash = launchTimeHash;
	}
	public HashMap<String, Monitoring> getMonitoringHash() {
		return MonitoringHash;
	}
	public void setMonitoringHash(HashMap<String, Monitoring> monitoringHash) {
		MonitoringHash = monitoringHash;
	}
	public HashMap<String, List<InstanceNetworkInterface>> getNetworkInterfacesHash() {
		return NetworkInterfacesHash;
	}
	public void setNetworkInterfacesHash(
			HashMap<String, List<InstanceNetworkInterface>> networkInterfacesHash) {
		NetworkInterfacesHash = networkInterfacesHash;
	}
	public HashMap<String, Placement> getPlacementHash() {
		return PlacementHash;
	}
	public void setPlacementHash(HashMap<String, Placement> placementHash) {
		PlacementHash = placementHash;
	}
	public HashMap<String, List<ProductCode>> getProductCodesHash() {
		return ProductCodesHash;
	}
	public void setProductCodesHash(
			HashMap<String, List<ProductCode>> productCodesHash) {
		ProductCodesHash = productCodesHash;
	}
	public HashMap<String, List<GroupIdentifier>> getSecurityGroupsHash() {
		return SecurityGroupsHash;
	}
	public void setSecurityGroupsHash(
			HashMap<String, List<GroupIdentifier>> securityGroupsHash) {
		SecurityGroupsHash = securityGroupsHash;
	}
	public HashMap<String, Boolean> getSourceDestCheckHash() {
		return SourceDestCheckHash;
	}
	public void setSourceDestCheckHash(HashMap<String, Boolean> sourceDestCheckHash) {
		SourceDestCheckHash = sourceDestCheckHash;
	}
	public HashMap<String, InstanceState> getStateHash() {
		return StateHash;
	}
	public void setStateHash(HashMap<String, InstanceState> stateHash) {
		StateHash = stateHash;
	}
	public HashMap<String, StateReason> getStateReasonHash() {
		return StateReasonHash;
	}
	public void setStateReasonHash(HashMap<String, StateReason> stateReasonHash) {
		StateReasonHash = stateReasonHash;
	}
	public HashMap<String, List<Tag>> getTagsHash() {
		return TagsHash;
	}
	public void setTagsHash(HashMap<String, List<Tag>> tagsHash) {
		TagsHash = tagsHash;
	}
	public ArrayList<String> getInstanceIdList() {
		return InstanceIdList;
	}
	public void setInstanceIdList(ArrayList<String> instanceIdList) {
		InstanceIdList = instanceIdList;
	}
	public HashMap<String, Reservation> getReservationIdHash() {
		return ReservationIdHash;
	}
	public void setReservationIdHash(HashMap<String, Reservation> reservationIdHash) {
		ReservationIdHash = reservationIdHash;
	}
	public HashMap<String, Instance> getInstanceHash() {
		return InstanceHash;
	}
	public void setInstanceHash(HashMap<String, Instance> instanceHash) {
		InstanceHash = instanceHash;
	}
	
	
}
