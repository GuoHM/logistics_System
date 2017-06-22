package bean;
// Generated 2017-6-22 14:40:54 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Goods generated by hbm2java
 */
public class Goods implements java.io.Serializable {

	private String goodsId;
	private DistrictCenter districtCenterByReceiveDistrictCenter;
	private DistrictCenter districtCenterBySendDestrictCenter;
	private ProvinceCenter provinceCenterBySendProvinceCenter;
	private ProvinceCenter provinceCenterByReceiveProvinceCenter;
	private String senderName;
	private String senderPhone;
	private String senderProvince;
	private String senderCity;
	private String senderAddress;
	private String receiverName;
	private String receiverPhone;
	private String receiverProvince;
	private String receiverCity;
	private String receiverAddress;
	private Set goodsStatuses = new HashSet(0);

	public Goods() {
	}

	public Goods(String goodsId, String senderName, String senderPhone, String senderProvince, String senderCity,
			String senderAddress, String receiverName, String receiverPhone, String receiverProvince,
			String receiverCity, String receiverAddress) {
		this.goodsId = goodsId;
		this.senderName = senderName;
		this.senderPhone = senderPhone;
		this.senderProvince = senderProvince;
		this.senderCity = senderCity;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.receiverAddress = receiverAddress;
	}

	public Goods(String goodsId, DistrictCenter districtCenterByReceiveDistrictCenter,
			DistrictCenter districtCenterBySendDestrictCenter, ProvinceCenter provinceCenterBySendProvinceCenter,
			ProvinceCenter provinceCenterByReceiveProvinceCenter, String senderName, String senderPhone,
			String senderProvince, String senderCity, String senderAddress, String receiverName, String receiverPhone,
			String receiverProvince, String receiverCity, String receiverAddress, Set goodsStatuses) {
		this.goodsId = goodsId;
		this.districtCenterByReceiveDistrictCenter = districtCenterByReceiveDistrictCenter;
		this.districtCenterBySendDestrictCenter = districtCenterBySendDestrictCenter;
		this.provinceCenterBySendProvinceCenter = provinceCenterBySendProvinceCenter;
		this.provinceCenterByReceiveProvinceCenter = provinceCenterByReceiveProvinceCenter;
		this.senderName = senderName;
		this.senderPhone = senderPhone;
		this.senderProvince = senderProvince;
		this.senderCity = senderCity;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.receiverAddress = receiverAddress;
		this.goodsStatuses = goodsStatuses;
	}

	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public DistrictCenter getDistrictCenterByReceiveDistrictCenter() {
		return this.districtCenterByReceiveDistrictCenter;
	}

	public void setDistrictCenterByReceiveDistrictCenter(DistrictCenter districtCenterByReceiveDistrictCenter) {
		this.districtCenterByReceiveDistrictCenter = districtCenterByReceiveDistrictCenter;
	}

	public DistrictCenter getDistrictCenterBySendDestrictCenter() {
		return this.districtCenterBySendDestrictCenter;
	}

	public void setDistrictCenterBySendDestrictCenter(DistrictCenter districtCenterBySendDestrictCenter) {
		this.districtCenterBySendDestrictCenter = districtCenterBySendDestrictCenter;
	}

	public ProvinceCenter getProvinceCenterBySendProvinceCenter() {
		return this.provinceCenterBySendProvinceCenter;
	}

	public void setProvinceCenterBySendProvinceCenter(ProvinceCenter provinceCenterBySendProvinceCenter) {
		this.provinceCenterBySendProvinceCenter = provinceCenterBySendProvinceCenter;
	}

	public ProvinceCenter getProvinceCenterByReceiveProvinceCenter() {
		return this.provinceCenterByReceiveProvinceCenter;
	}

	public void setProvinceCenterByReceiveProvinceCenter(ProvinceCenter provinceCenterByReceiveProvinceCenter) {
		this.provinceCenterByReceiveProvinceCenter = provinceCenterByReceiveProvinceCenter;
	}

	public String getSenderName() {
		return this.senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPhone() {
		return this.senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderProvince() {
		return this.senderProvince;
	}

	public void setSenderProvince(String senderProvince) {
		this.senderProvince = senderProvince;
	}

	public String getSenderCity() {
		return this.senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}

	public String getSenderAddress() {
		return this.senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return this.receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverProvince() {
		return this.receiverProvince;
	}

	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}

	public String getReceiverCity() {
		return this.receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Set getGoodsStatuses() {
		return this.goodsStatuses;
	}

	public void setGoodsStatuses(Set goodsStatuses) {
		this.goodsStatuses = goodsStatuses;
	}

}
