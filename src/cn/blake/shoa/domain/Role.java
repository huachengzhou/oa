package cn.blake.shoa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Blake.Zhou
 * @see 角色
 */
@SuppressWarnings("serial")
@Entity
public class Role implements Serializable{
	private Integer rid;
	private String name;
	private String description;
	private Integer pid;//父节点的id
	private Boolean checked;
	@JsonIgnore
	private Set<Privilege> privileges = new HashSet<Privilege>();
	@JsonIgnore
	private Set<User> users = new HashSet<User>();
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Role() {
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", name=" + name + ", description="
				+ description + ", pid=" + pid + ", checked=" + checked + "]";
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public static String ROLE_RID_NAME = "rid";
}
