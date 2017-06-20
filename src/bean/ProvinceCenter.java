package bean;
// Generated 2017-6-20 21:05:36 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * ProvinceCenter generated by hbm2java
 */
public class ProvinceCenter implements java.io.Serializable {

	private int centerId;
	private TransportationManagement transportationManagement;
	private String province;
	private String pwd;
	private Set goodsesForSendProvinceCenter = new HashSet(0);
	private Set goodsesForReceiveProvinceCenter = new HashSet(0);

	public ProvinceCenter() {
	}

	public ProvinceCenter(int centerId, TransportationManagement transportationManagement, String province,
			String pwd) {
		this.centerId = centerId;
		this.transportationManagement = transportationManagement;
		this.province = province;
		this.pwd = pwd;
	}

	public ProvinceCenter(int centerId, TransportationManagement transportationManagement, String province, String pwd,
			Set goodsesForSendProvinceCenter, Set goodsesForReceiveProvinceCenter) {
		this.centerId = centerId;
		this.transportationManagement = transportationManagement;
		this.province = province;
		this.pwd = pwd;
		this.goodsesForSendProvinceCenter = goodsesForSendProvinceCenter;
		this.goodsesForReceiveProvinceCenter = goodsesForReceiveProvinceCenter;
	}

	public int getCenterId() {
		return this.centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public TransportationManagement getTransportationManagement() {
		return this.transportationManagement;
	}

	public void setTransportationManagement(TransportationManagement transportationManagement) {
		this.transportationManagement = transportationManagement;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set getGoodsesForSendProvinceCenter() {
		return this.goodsesForSendProvinceCenter;
	}

	public void setGoodsesForSendProvinceCenter(Set goodsesForSendProvinceCenter) {
		this.goodsesForSendProvinceCenter = goodsesForSendProvinceCenter;
	}

	public Set getGoodsesForReceiveProvinceCenter() {
		return this.goodsesForReceiveProvinceCenter;
	}

	public void setGoodsesForReceiveProvinceCenter(Set goodsesForReceiveProvinceCenter) {
		this.goodsesForReceiveProvinceCenter = goodsesForReceiveProvinceCenter;
	}

}
