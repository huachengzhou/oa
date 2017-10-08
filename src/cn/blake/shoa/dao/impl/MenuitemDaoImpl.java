package cn.blake.shoa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.blake.shoa.dao.MenuitemDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.Menuitem;
@Repository("menuitemDao")
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao {

}
