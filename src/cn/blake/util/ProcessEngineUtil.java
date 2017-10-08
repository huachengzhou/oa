package cn.blake.util;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

public class ProcessEngineUtil {
	
	public static void isit(){
		ProcessEngine engine = SessionFactoryUtil.getCtx().getBean(ProcessEngine.class);
		System.out.println(engine);
	}
	public static void main(String[] args) {
		isB();
	}
	public static void isB(){
		ProcessEngine engine =  ProcessEngines.getDefaultProcessEngine();
		System.out.println(engine);
	}
	public static ProcessEngine getProcessEngine(){
		return ProcessEngines.getDefaultProcessEngine();
	}
}
