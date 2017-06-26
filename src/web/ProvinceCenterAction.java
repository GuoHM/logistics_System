package web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

import bean.DistrictCenter;
import bean.Goods;
import bean.GoodsStatus;
import bean.GoodsStatusId;
import bean.ProvinceCenter;
import bean.Transportation;
import bean.TransportationManagement;
import bean.TransportationManagementId;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import service.IConditionsService;
import service.IDistrictCenterService;
import service.IGoodsService;
import service.IGoodsStatusService;
import service.IProvinceCenterService;

public class ProvinceCenterAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1405926533311347411L;
	ActionContext context = ActionContext.getContext();
	protected HttpServletRequest servletRequest = null;
	Logger logger = Logger.getLogger(AllAction.class);
	private IGoodsService goodsService;
	private IGoodsStatusService goodsStatusService;
	private IConditionsService conditionsService;
	private IProvinceCenterService provinceCenterService;
	private IDistrictCenterService districtCenterService;
	private String depature;
	private String destination;
	private String amount;
	private String[] box;
	private String centerName;

	@SuppressWarnings({ "null", "unused" })
	public String getGoodsByProvince() throws Exception {// 获取当前省未发往其他省的快递
		int sum=1;
		List<Goods> list = null;
		List<Goods> list2 = new ArrayList<Goods>();//list2存放本省的未发过去的订单
		List<Transportation> list3 = new ArrayList<Transportation>();
		ProvinceCenter province = (ProvinceCenter) context.getSession().get("login");
		System.out.println((ProvinceCenter) context.getSession().get("login"));
		list=goodsService.getGoodsByProvince(province.getProvince());
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Goods goods = list.get(i);
				if (goods.getProvinceCenterBySendProvinceCenter() != null&&goods.getProvinceCenterByReceiveProvinceCenter()==null) {
					list2.add(list.get(i));
				}
			}
		}
		String a[][]=new String[list2.size()][2];
		for(int i=0;i<list2.size();i++){
			String provinceName=list2.get(i).getReceiverProvince();
			for(int j=i+1;j<list2.size();j++){
				if(list2.get(j).getReceiverProvince().equals(list2.get(i).getReceiverProvince())){
					list2.remove(j);
					--j;
					++sum;
				}
			}
		
			a[i][0]=provinceName;
			a[i][1]=sum+"";
		
			//list3=provinceCenterService.getTransportationlistByDD(province.getProvince(), provinceName);
		}
		if (a != null&&list3!=null) {
			context.getSession().put("senderProvincearray", a);
			context.getSession().put("transportationList", list3);
			return "getGoodsBysenderProvinceSuccess";
		} else {
			return "getGoodsBysenderProvinceFalse";
		}
	}

	@SuppressWarnings("null")
	public String addsenderProvinceListStatus() throws Exception {// 发往相应省份时，将这些商品链表都加上状态信息
		int j = 0;
		List<Goods> list = null;
		List<Goods> list2 = new ArrayList<Goods>();
		ProvinceCenter province = (ProvinceCenter) context.getSession().get("login");
		list=goodsService.getGoodsByProvince(province.getProvince());
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Goods goods = list.get(i);
				if (goods.getProvinceCenterBySendProvinceCenter() != null&&goods.getProvinceCenterByReceiveProvinceCenter()==null) {
					list2.add(list.get(i));
				}
			}
		}
		for (j = 0; j < list2.size(); j++) {
			Goods goods = list2.get(j);
			GoodsStatusId goodsStatusId = new GoodsStatusId();
			goodsStatusId.setGoodsId(goods.getGoodsId());
			goodsStatusId.setConditionId("4");
			GoodsStatus goodsStatus = new GoodsStatus();
			goodsStatus.setId(goodsStatusId);
			ProvinceCenter provinceCenter = provinceCenterService
					.getProvinceCenterByProvinceName(goods.getReceiverProvince());
			goods.setProvinceCenterByReceiveProvinceCenter(provinceCenter);
			goodsService.save(goods);
			goods = goodsService.getGoodsBygoodsId(goods.getGoodsId());
			goodsStatus.setGoods(goods);
			goodsStatus.setConditions(conditionsService.getConditionsByConditonsId("4"));
			goodsStatusService.save(goodsStatus);
		}
		if (j == list2.size()) {
			return "saveprovinceListStatusSuccess";
		} else
			return "saveprovinceListStatusFalse";
	}
	
	public String viewTransportation() throws Exception {
		List<Transportation> list=provinceCenterService.getTransportationlistByDD(depature, destination);
		context.getSession().put("transporationlist", list);
		context.getSession().put("show", "show");
		context.getSession().put("amount", amount);
		return SUCCESS;
	}

	public String selectedTransportation() throws Exception{//获取已选择车辆
		TransportationManagement transportation=new TransportationManagement();
		String s=new String();
		for(int i=0;i<box.length;i++){
			s+=box[i];
			if(i+1!=box.length)
				s+=",";
			ProvinceCenter province=provinceCenterService.getProvinceCenterByProvinceName(centerName);
			System.out.print(province.getCenterId());
			TransportationManagementId transportationManagementId=new TransportationManagementId();
			transportationManagementId.setCenterId(province.getCenterId());
			transportationManagementId.setTransportationId(box[i]);
			transportation.setId(transportationManagementId);
			transportation.setProvinceCenter(province);
			transportation.setTransportation(provinceCenterService.getTransportationByID(box[i]));
			System.out.print(transportation);
			provinceCenterService.save(transportation);
		}
		context.getSession().put("selectedTransportation", s);
		return "success";
	}
	
	@SuppressWarnings({ "null", "unused" })
	public String getByreceiverProvince() throws Exception {    // 获取本省快递链表
		int sum=1;
		List<Goods> list = null;
		List<Goods> list2 = new ArrayList<Goods>();//list2存放本省的未发过去的订单
		ProvinceCenter province = (ProvinceCenter) context.getSession().get("login");
		list=goodsService.getGoodsByreceiverProvince(province.getProvince());
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Goods goods = list.get(i);
				if (goods.getProvinceCenterByReceiveProvinceCenter()!=null&&goods.getDistrictCenterByReceiveDistrictCenter()==null) {
					list2.add(list.get(i));
				}
			}
		}
		String a[][]=new String[list2.size()][2];
		for(int i=0;i<list2.size();i++){
			String districtName=list2.get(i).getReceiverDistrict();
			for(int j=i+1;j<list2.size();j++){
				if(list2.get(j).getReceiverDistrict().equals(list2.get(i).getReceiverDistrict())){
					list2.remove(j);
					--j;
					++sum;
				}
			}
		
			a[i][0]=districtName;
			a[i][1]=sum+"";
		}
		if (a != null) {
			context.getSession().put("senderDistrictarray", a);
			return "getByreceiverProvinceSuccess";
		} else {
			return "getByreceiverProvinceFalse";
		}
	}
	@SuppressWarnings("null")
	public String addsenderDistrictListStatus() throws Exception {// 发往相应区县营业点，将这些商品链表都加上状态信息
		int j = 0;
		List<Goods> list = null;
		List<Goods> list2 = new ArrayList<Goods>();//list2存放本省的未发过去的订单
		ProvinceCenter province = (ProvinceCenter) context.getSession().get("login");
		list=goodsService.getGoodsByreceiverProvince(province.getProvince());
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Goods goods = list.get(i);
				if (goods.getProvinceCenterByReceiveProvinceCenter()!=null&&goods.getDistrictCenterByReceiveDistrictCenter()==null) {
					list2.add(list.get(i));
				}
			}
		}
		for (j = 0; j < list2.size(); j++) {
			Goods goods = list2.get(j);
			GoodsStatusId goodsStatusId = new GoodsStatusId();
			goodsStatusId.setGoodsId(goods.getGoodsId());
			System.out.println(goods.getGoodsId());
			goodsStatusId.setConditionId("5");
			GoodsStatus goodsStatus = new GoodsStatus();
			goodsStatus.setId(goodsStatusId);
			DistrictCenter districtCenter = districtCenterService.getDistrictCenter(goods.getReceiverDistrict(), goods.getReceiverCity(), goods.getReceiverProvince());
			goods.setDistrictCenterByReceiveDistrictCenter(districtCenter);
			goodsService.save(goods);
			goods = goodsService.getGoodsBygoodsId(goods.getGoodsId());
			System.out.println(goods.getGoodsId());
			goodsStatus.setGoods(goods);
			goodsStatus.setConditions(conditionsService.getConditionsByConditonsId("5"));
			System.out.println(goodsStatus.getConditions().getConditionId()+goodsStatus.getId().getConditionId());
			goodsStatusService.save(goodsStatus);
		}
		if (j == list2.size()) {
			return "addsenderDistrictListStatusSuccess";
		} else
			return "addsenderDistrictListStatusFalse";
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the context
	 */
	public ActionContext getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(ActionContext context) {
		this.context = context;
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return logger;
	}

	/**
	 * @param logger the logger to set
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * @return the goodsService
	 */
	public IGoodsService getGoodsService() {
		return goodsService;
	}

	/**
	 * @param goodsService the goodsService to set
	 */
	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * @return the goodsStatusService
	 */
	public IGoodsStatusService getGoodsStatusService() {
		return goodsStatusService;
	}

	/**
	 * @param goodsStatusService the goodsStatusService to set
	 */
	public void setGoodsStatusService(IGoodsStatusService goodsStatusService) {
		this.goodsStatusService = goodsStatusService;
	}

	/**
	 * @return the conditionsService
	 */
	public IConditionsService getConditionsService() {
		return conditionsService;
	}

	/**
	 * @param conditionsService the conditionsService to set
	 */
	public void setConditionsService(IConditionsService conditionsService) {
		this.conditionsService = conditionsService;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the servletRequest
	 */
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	/**
	 * @return the depature
	 */
	public String getDepature() {
		return depature;
	}

	/**
	 * @param depature the depature to set
	 */
	public void setDepature(String depature) {
		this.depature = depature;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the provinceCenterService
	 */
	public IProvinceCenterService getProvinceCenterService() {
		return provinceCenterService;
	}

	/**
	 * @param provinceCenterService the provinceCenterService to set
	 */
	public void setProvinceCenterService(IProvinceCenterService provinceCenterService) {
		this.provinceCenterService = provinceCenterService;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the box
	 */
	public String[] getBox() {
		return box;
	}

	/**
	 * @param box the box to set
	 */
	public void setBox(String[] box) {
		this.box = box;
	}

	/**
	 * @return the centerName
	 */
	public String getCenterName() {
		return centerName;
	}

	/**
	 * @param centerName the centerName to set
	 */
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	/**
	 * @return the districtCenterService
	 */
	public IDistrictCenterService getDistrictCenterService() {
		return districtCenterService;
	}

	/**
	 * @param districtCenterService the districtCenterService to set
	 */
	public void setDistrictCenterService(IDistrictCenterService districtCenterService) {
		this.districtCenterService = districtCenterService;
	}
	
	}