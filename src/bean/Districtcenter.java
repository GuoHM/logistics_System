package bean;
// Generated 2017-6-20 1:58:58 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * DistrictCenter generated by hbm2java
 */
public class DistrictCenter implements java.io.Serializable {

	private String centerId;
	private String district;
	private String city;
	private String province;
	private String pwd;
	private Set goodsesForSendDestrictCenter = new HashSet(0);
	private Set goodsesForReceiveDistrictCenter = new HashSet(0);

	public DistrictCenter() {
	}

	public DistrictCenter(String centerId, String district, String city, String province, String pwd) {
		this.centerId = centerId;
		this.district = district;
		this.city = city;
		this.province = province;
		this.pwd = pwd;
	}

	public DistrictCenter(String centerId, String district, String city, String province, String pwd,
			Set goodsesForSendDestrictCenter, Set goodsesForReceiveDistrictCenter) {
		this.centerId = centerId;
		this.district = district;
		this.city = city;
		this.province = province;
		this.pwd = pwd;
		this.goodsesForSendDestrictCenter = goodsesForSendDestrictCenter;
		this.goodsesForReceiveDistrictCenter = goodsesForReceiveDistrictCenter;
	}

	public String getCenterId() {
		return this.centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Set getGoodsesForSendDestrictCenter() {
		return this.goodsesForSendDestrictCenter;
	}

	public void setGoodsesForSendDestrictCenter(Set goodsesForSendDestrictCenter) {
		this.goodsesForSendDestrictCenter = goodsesForSendDestrictCenter;
	}

	public Set getGoodsesForReceiveDistrictCenter() {
		return this.goodsesForReceiveDistrictCenter;
	}

	public void setGoodsesForReceiveDistrictCenter(Set goodsesForReceiveDistrictCenter) {
		this.goodsesForReceiveDistrictCenter = goodsesForReceiveDistrictCenter;
	}

}
