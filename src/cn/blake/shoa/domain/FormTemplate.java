package cn.blake.shoa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class FormTemplate implements Serializable{
	private Integer ftid;
	private String name;
	private String processKey;
	private String url;
	
	private Set<Form> forms = new HashSet<Form>();

	public Integer getFtid() {
		return ftid;
	}

	public void setFtid(Integer ftid) {
		this.ftid = ftid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Form> getForms() {
		return forms;
	}

	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}

	public FormTemplate() {
	}

	
}
