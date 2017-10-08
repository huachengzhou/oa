package cn.blake.shoa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.blake.shoa.dao.FormTemplateDao;
import cn.blake.shoa.dao.base.BaseDaoImpl;
import cn.blake.shoa.domain.FormTemplate;

@Repository("formTemplateDao")
public class FormTemplateDaoImpl extends BaseDaoImpl<FormTemplate> implements FormTemplateDao {

}
