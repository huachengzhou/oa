package cn.blake.mvc;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.task.Task;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.blake.shoa.domain.Form;
import cn.blake.shoa.domain.FormTemplate;
import cn.blake.shoa.domain.TaskView;
import cn.blake.shoa.service.FormTemplateService;
import cn.blake.shoa.service.WorkFlowService;

@Controller
public class WorkFlowController {
	private static final Log logger = LogFactory.getLog(WorkFlowController.class);
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private FormTemplateService formTemplateService;
	@Autowired
	private WorkFlowService workFlowService;
	
	/*显示表单模版*/
	@RequestMapping(value="/showWorkFlowFormTemplate")
	public String showFormTemplate(Model model){
		logger.info("showWorkFlowFormTemplate()");
		Collection<FormTemplate> ftList = formTemplateService.getAllFormTemplate();
		model.addAttribute("ftList",ftList);
		return "workflow/workflow/formTemplateList";
	}
	
	/**
	 * 转到 提交申请
	 * @param ftid
	 * @param processKey
	 * @return
	 */
	@RequestMapping(value="/addSubmit")
	public String addSubmit(@RequestParam Integer ftid,@RequestParam String processKey,Model model){
		FormTemplate formTemplate = new FormTemplate();
		try {
			formTemplate = formTemplateService.getFormTemplate(ftid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("formTemplate",formTemplate);
		return "workflow/workflow/submitUI";
	}
	
	@RequestMapping(value="/workFlowAction_submit")
	public String workFlowAction_submit(HttpServletRequest request, Model model, @RequestParam("file") MultipartFile file
			,@RequestParam String processKey,@RequestParam Integer ftid){
		logger.info("workFlowAction_submit()");
		System.out.println("ftid:"+ftid+" processKey:"+processKey);
		workFlowService.submit(ftid, processKey, file, request);
		return "frame/right";
	}
	
	@RequestMapping(value="/myTaskList")
	public String myTaskList(Model model,HttpServletRequest request){
		logger.info("myTaskList()");
		Collection<TaskView> taskViews = workFlowService.myTaskList2(request);
		model.addAttribute("taskViews",taskViews);
		return "workflow/workflow/myTaskList";
	}
	
	@RequestMapping(value="/approveUI")
	public String approveUI(@RequestParam Integer fid,@RequestParam String taskId,Model model){
		model.addAttribute("fid",fid);
		model.addAttribute("taskId",taskId);
		return "workflow/workflow/approveUI";
	}
	
	@RequestMapping(value="/approveData")
	public String approveData(@RequestParam String taskId,@RequestParam Integer fid,@RequestParam String commen
			,@RequestParam Integer fag){
		Map<String,Object> variables = new HashMap<String, Object>();
		variables.put("意见",commen);
		if (fag==1) {//同意
			processEngine.getTaskService().complete(taskId,variables);
			FormTemplate formTemplate = isN();//取出数据,并且修改
			formTemplateService.updateFormTemplate(formTemplate);
		}else if (fag==2) {//不同意
			
		}
		return "frame/right";
	}
	
	@RequestMapping("/listForm")
	public String listForm(Model model){
		List<Form> forms = formTemplateService.getFormsAll();
		model.addAttribute("forms",forms);
		return "workflow/formTemplate/MySubmit";
	}
	
	public FormTemplate isN(){
		Task task = processEngine.getTaskService().createTaskQuery().processDefinitionKey("qingjia__process").singleResult();
		Form form = (Form) processEngine.getRuntimeService().getVariable(task.getExecutionId(),"form");
		form.setState("通过");
		FormTemplate formTemplate = form.getFormTemplate();
		Set<Form> forms = new HashSet<Form>();
		forms.add(form);
		formTemplate.setForms(forms);
		return formTemplate;
	}
}
