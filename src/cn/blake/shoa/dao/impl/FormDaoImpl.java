package cn.blake.shoa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.blake.shoa.dao.FormDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.Form;

@Repository("formDao")
public class FormDaoImpl extends BaseDaoImpl<Form> implements FormDao{

}
