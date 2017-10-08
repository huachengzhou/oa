package cn.blake.shoa.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.blake.shoa.dao.FormTemplateDao;
import cn.blake.shoa.domain.Form;
import cn.blake.shoa.domain.FormTemplate;
import cn.blake.shoa.service.FormTemplateService;
@Service("formTemplateService")
public class FormTemplateServiceImpl implements FormTemplateService {
	
	@Autowired
	private FormTemplateDao formTemplateDao;
	
	public Collection<FormTemplate> getAllFormTemplate() {
		return formTemplateDao.getAllEntry(FormTemplate.class);
	}

	@Transactional(readOnly=false)
	public void saveFormTemplate(FormTemplate formTemplate) {
		formTemplateDao.saveEntry(formTemplate);
	}

	public FormTemplate getFormTemplate(Integer ftid) throws Exception {
		FormTemplate formTemplate = formTemplateDao.getEntryById(ftid,FormTemplate.class);
		return formTemplate;
	}
	@Transactional(readOnly=false)
	public void removeDocument(Integer ftid) {
		FormTemplate formTemplate = formTemplateDao.getEntryById(ftid,FormTemplate.class);
		File file = null;
		formTemplateDao.deleteEntry(ftid,FormTemplate.class);
		try {
			String path = formTemplate.getUrl();
			file = new File(path);
			file.delete();
			try {
				path = path.replaceAll("\\","\\");
				file = new File(path);
				file.delete();
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
	}
	@Transactional(readOnly=false)
	public void updateFormTemplate(FormTemplate formTemplate) {
		formTemplateDao.updateEntry(formTemplate);
	}

	public List<Form> getFormsAll() {
		List<Form> forms = new ArrayList<Form>();
		Collection<FormTemplate> formTemplates = getAllFormTemplate();
		for (FormTemplate formTemplate : formTemplates) {
			Set<Form> set = formTemplate.getForms();
			for (Form form : set) {
				forms.add(form);
			}
		}
		return forms;
	}

}
