package cn.blake.shoa.service;

import java.util.Collection;

import cn.blake.shoa.domain.Menuitem;

/**
 * @see 菜单
 * @author Blake.Zhou
 * 
 */
public interface MenuitemService {
	/**
	 * @see 获取所有菜单信息
	 * @return
	 */
	public Collection<Menuitem> getAllMenuitem();
}
