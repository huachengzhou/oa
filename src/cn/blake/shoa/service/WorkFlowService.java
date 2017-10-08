package cn.blake.shoa.service;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.blake.shoa.domain.Form;
import cn.blake.shoa.domain.TaskView;

public interface WorkFlowService {
	public void submit(Integer ftid,String processKey,MultipartFile file,HttpServletRequest request);
	
	public Collection<Form> myTaskList();
	
	public Collection<TaskView> myTaskList2(HttpServletRequest request);
	
	public void approve();
}
