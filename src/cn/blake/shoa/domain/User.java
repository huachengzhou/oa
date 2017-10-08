package cn.blake.shoa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author Blake.Zhou
 * @see ÓÃ»§
 */
@Entity
@SuppressWarnings("serial")
public class User implements Serializable{
	private Integer uid;
	private String username;
	private String name;
	private String password;
	private String sex;
	private String phone;
	private String email;
	@JsonIgnore
	private Set<Role> roles = new HashSet<Role>();
	
	private Department department;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", name=" + name
				+ ", password=" + password + ", sex=" + sex + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
	public static String SEX_MAN ="ÄÐ";
	public static String SEX_WOMAN ="Å®";

}
