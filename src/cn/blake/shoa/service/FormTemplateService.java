package cn.blake.shoa.service;

import java.util.Collection;
import java.util.List;

import cn.blake.shoa.domain.Form;
import cn.blake.shoa.domain.FormTemplate;

public interface FormTemplateService {
    public Collection<FormTemplate> getAllFormTemplate();
    
    public List<Form> getFormsAll();
	
	public void saveFormTemplate(FormTemplate formTemplate);
	
	public void updateFormTemplate(FormTemplate formTemplate);
	
	public FormTemplate getFormTemplate(Integer ftid) throws Exception ;
	
	public void removeDocument(Integer ftid);
}
