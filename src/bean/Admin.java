package bean;
// Generated 2017-6-20 1:58:58 by Hibernate Tools 3.5.0.Final

/**
 * Admin generated by hbm2java
 */
public class Admin implements java.io.Serializable {

	private String adminId;
	private String pwd;

	public Admin() {
	}

	public Admin(String adminId, String pwd) {
		this.adminId = adminId;
		this.pwd = pwd;
	}

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
