package cn.blake.shoa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Blake.Zhou
 * @see 部门
 */
@SuppressWarnings("serial")
public class Department implements Serializable {
	/**
	 * 标示符
	 */
	private Integer did;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 职能说明
	 */
	private String description;

	private Set<User> users = new HashSet<User>();


	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
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

	public Department() {
	}

	public Department(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + ", description="
				+ description + "]";
	}

}
