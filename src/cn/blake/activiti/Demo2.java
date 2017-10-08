package cn.blake.activiti;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.task.Task;

import cn.blake.shoa.domain.Form;
import cn.blake.shoa.domain.TaskView;
import cn.blake.util.ProcessEngineUtil;

public class Demo2 {
	static ProcessEngine engine = ProcessEngineUtil.getProcessEngine();
	public static void main(String[] args) {	
		isN();
	}
	
	public static void isit(){
		List<TaskView> taskViews = new ArrayList<TaskView>();
		List<Task> tasks = engine.getTaskService().createTaskQuery().list();
		for (Task task : tasks) {
			System.out.println(task.getId()+" "+task.getProcessDefinitionId());
			Form form = (Form) engine.getRuntimeService().getVariable(task.getExecutionId(),"form");
			System.out.println("title:"+form.getTitle());
		}
	}
	
	public static void isM(){
	}
	
	public static void isN(){
		Task task = engine.getTaskService().createTaskQuery().processDefinitionKey("qingjia__process").singleResult();
		System.out.println(task.getId()+" "+task.getProcessDefinitionId());
		Form form = (Form) engine.getRuntimeService().getVariable(task.getExecutionId(),"form");
		System.out.println("title:"+form.getTitle());
		System.out.println(form.getFid());
		System.out.println(form.getFormTemplate().getFtid());
	}
}
