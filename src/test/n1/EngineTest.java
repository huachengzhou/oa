package test.n1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;

import cn.blake.util.ProcessEngineUtil;


public class EngineTest {
	ProcessEngine engine = ProcessEngineUtil.getProcessEngine();
	@Test
	public void isit() throws FileNotFoundException{
		InputStream inputStream = new FileInputStream("E:\\JAVA\\IO\\qingjia.zip");
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		Deployment deployment = engine.getRepositoryService().createDeployment()
				.name("XXX-").addZipInputStream(zipInputStream).deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}
	@Test
	public void isN(){
		Collection<ProcessDefinition> pdList = engine
				.getRepositoryService().createProcessDefinitionQuery()
				.list();
		for (ProcessDefinition processDefinition : pdList) {
			System.out.println("name:"+processDefinition.getName()+";version:"+processDefinition.getVersion()+";id:"
		    +processDefinition.getId()+";DeploymentId:"+processDefinition.getDeploymentId()+";key:"+processDefinition.getKey());
		}
	}
	
	@Test
	public void isLeaveBill(){
		Collection<ProcessDefinition> pdList = engine.getRepositoryService().createProcessDefinitionQuery().processDefinitionKey("qingjia__process")
		.list();
		for (ProcessDefinition processDefinition : pdList) {
			System.out.println("name:"+processDefinition.getName()+";version:"+processDefinition.getVersion()+";id:"
				    +processDefinition.getId()+";DeploymentId:"+processDefinition.getDeploymentId()+";key:"+processDefinition.getKey());
			engine.getRepositoryService().deleteDeployment(processDefinition.getDeploymentId());
		}
	}
}
