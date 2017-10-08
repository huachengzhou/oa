package cn.blake.shoa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Blake.Zhpu
 * 申请 Bean
 */
@SuppressWarnings("serial")
public class Form implements Serializable{
	private Integer fid;
	private String title;
	/*申请人*/
	private String applicator;
	/*申请日期*/
	private Date applictetime;
	/*状态*/
	private String state;
	private String url;
	/**
	 * 该字段是系统内部的表和jbpm的表连接的一个桥梁
	 */
	private String piid;//流程实例ID
	private FormTemplate formTemplate;
	private Set<Approve> approves = new HashSet<Approve>();

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApplicator() {
		return applicator;
	}

	public void setApplicator(String applicator) {
		this.applicator = applicator;
	}

	public Date getApplictetime() {
		return applictetime;
	}

	public void setApplictetime(Date applictetime) {
		this.applictetime = applictetime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Approve> getApproves() {
		return approves;
	}

	public void setApproves(Set<Approve> approves) {
		this.approves = approves;
	}

	public FormTemplate getFormTemplate() {
		return formTemplate;
	}

	public void setFormTemplate(FormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}

	public String getPiid() {
		return piid;
	}

	public void setPiid(String piid) {
		this.piid = piid;
	}



	
	
}
