package cn.blake.activiti;

import java.util.List;

public interface SpringJDBC {
	/**
	 * table role_privilege
	 * @param privilege id
	 * @param role rid
	 */
	public void insert(Integer id, Integer rid);
	public List<String> getIList( Integer rid);
}
