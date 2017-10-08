package cn.blake.shoa.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.blake.shoa.dao.FormDao;
import cn.blake.shoa.dao.FormTemplateDao;
import cn.blake.shoa.domain.Form;
import cn.blake.shoa.domain.FormTemplate;
import cn.blake.shoa.domain.TaskView;
import cn.blake.shoa.domain.User;
import cn.blake.shoa.service.WorkFlowService;

@Service("workFlowService")
public class WorkFlowServiceImpl implements WorkFlowService {
	
	@Autowired
	private FormTemplateDao formTemplateDao;
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private FormDao formDao;
	
	@Transactional(readOnly=false)
	public void submit(Integer ftid, String processKey,MultipartFile file,HttpServletRequest request) {
		String url = cn.blake.util.FileUtil.saveFile(file, request);
		
		//form对象填充值
		Form form = new Form();
		User user = (User) request.getSession().getAttribute("user");
		form.setApplicator(user.getUsername());
		Date time = new Date();
		form.setApplictetime(time);
		FormTemplate formTemplate = this.formTemplateDao.getEntryById(ftid,FormTemplate.class);
		form.setFormTemplate(formTemplate);
		form.setState("申请中");
		
		form.setFid(ftid);
		
		form.setTitle(formTemplate.getName()+"_"+user.getUsername()+"_"+time);
		form.setUrl(url);
		
		formDao.saveEntry(form);
		//启动流程实例
		//放在流程实例中的流程变量form必须是持久化数据
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("form", form);
		ProcessInstance instance = processEngine.getRuntimeService()
				.startProcessInstanceByKey(processKey, variables);
		
		form.setPiid(instance.getId());
		//完成任务
		//根据piid获取该流程实例当前正在执行的任务
		Task task = processEngine.getTaskService().createTaskQuery()
				.executionId(instance.getId()).singleResult();
		processEngine.getTaskService().complete(task.getId());
		
	}

	public Collection<Form> myTaskList() {
		
		return null;
	}

	public Collection<TaskView> myTaskList2(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		List<TaskView> taskViews = new ArrayList<TaskView>();
		
		List<Task> tasks = processEngine.getTaskService().createTaskQuery()
				.taskAssignee(username).list();
		
		if (tasks.size()==0) {
			tasks = processEngine.getTaskService().createTaskQuery().list();
		}
		
		for (Task task : tasks) {
			//从当前的流程实例中把流程变量"form"提取出来
			Form form = (Form) processEngine.getRuntimeService()
			.getVariable(task.getExecutionId(),"form");
			TaskView taskView = new TaskView();
			taskView.setForm(form);
			taskView.setTask(task);
			taskViews.add(taskView);
		}
		System.out.println("size:"+taskViews.size());
		return taskViews;
	}

	public void approve() {

	}

}
