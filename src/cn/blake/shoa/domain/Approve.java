package cn.blake.shoa.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Approve implements Serializable{
	/**
	 * 
	 */
	private Integer aid;
	/*审批人*/
	private String approvename;
	/*审批时间*/
	private Date approvetime;
	/*审批是否通过*/
	private Boolean isapprove;
	
	private Form form;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getApprovename() {
		return approvename;
	}

	public void setApprovename(String approvename) {
		this.approvename = approvename;
	}

	public Date getApprovetime() {
		return approvetime;
	}

	public void setApprovetime(Date approvetime) {
		this.approvetime = approvetime;
	}

	public Boolean getIsapprove() {
		return isapprove;
	}

	public void setIsapprove(Boolean isapprove) {
		this.isapprove = isapprove;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

}
