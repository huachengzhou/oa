package cn.blake.shoa.domain;

import java.io.Serializable;

import org.activiti.engine.task.Task;

@SuppressWarnings("serial")
public class TaskView implements Serializable{
	private Form form;
	private Task task;
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
}
