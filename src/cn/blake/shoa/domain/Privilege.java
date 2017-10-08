package cn.blake.shoa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

/**
 * @see 权限
 * @author Blake.Zhou
 * 
 */
@Entity
@SuppressWarnings("serial")
public class Privilege implements Serializable {
	/**
	 * 主键...
	 */
	private Integer id;
	/**
	 * 父节点ID...
	 */
	private Integer pid;
	/**
	 * 节点的名称...
	 */
	private String name;
	/**
	 * "1"为菜单 "2"为功能...
	 */
	private String flag;
	private Boolean checked;
	/**
	 * 是否是父节点
	 */
	private Boolean isParent;
	/**
	 * 跳转到的链接
	 */
	private String url;
	/**
	 * 跳转到的frame的名字
	 */
	private String target;
	/**
	 * 图片的路径
	 */
	private String icon;
	private Set<Role> roles = new HashSet<Role>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Privilege() {
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", pid=" + pid + ", name=" + name
				+ ", flag=" + flag + ", checked=" + checked + ", isParent="
				+ isParent + ", url=" + url + ", target=" + target + ", icon="
				+ icon + "]";
	}
	
	public static String PRIVILEGE_ID_NAME = "id";
}
