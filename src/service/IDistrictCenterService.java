package service;

import bean.DistrictCenter;

public interface IDistrictCenterService {
	DistrictCenter getDistrictCenterByIDAndPwd(String id,String pwd) throws Exception;
}