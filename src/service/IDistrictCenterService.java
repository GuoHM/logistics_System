package service;

import bean.DistrictCenter;

public interface IDistrictCenterService {
	DistrictCenter getDistrictCenterByIDAndPwd(String id, String pwd) throws Exception;

	void save(DistrictCenter user) throws Exception;
	DistrictCenter getDistrictCenter(String district,String city, String province) throws Exception;
}
