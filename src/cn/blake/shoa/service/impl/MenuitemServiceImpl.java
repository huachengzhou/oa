package cn.blake.shoa.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.blake.shoa.dao.MenuitemDao;
import cn.blake.shoa.domain.Menuitem;
import cn.blake.shoa.service.MenuitemService;

@Service("menuitemService")
public class MenuitemServiceImpl implements MenuitemService {
	@Resource(name = "menuitemDao")
	private MenuitemDao menuitemDao;

	public Collection<Menuitem> getAllMenuitem() {
		return menuitemDao.getAllEntry(Menuitem.class);
	}

}
