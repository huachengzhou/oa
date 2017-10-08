package cn.blake.shoa.service.impl;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blake.shoa.service.PDManager;
import cn.blake.util.ProcessEngineUtil;

@Service("pDManager")
public class PDManagerImpl implements PDManager {
	@Autowired
	private ProcessEngine processEngine;

	public Collection<ProcessDefinition> getLasterVersion() {
		/**
		 * 把所有的流程定义全部查询出来，并且按照版本的从低到高排序
		 */
		Collection<ProcessDefinition> pdList = processEngine
				.getRepositoryService().createProcessDefinitionQuery()
				.list();
		/**
		 * 遍历每一个流程定义，如果存在相同的key值，后者覆盖前者，也就意味着高版本的覆盖低版本的
		 */
		Map<String, ProcessDefinition> map = new HashMap<String, ProcessDefinition>();
		for (ProcessDefinition pd : pdList) {
			map.put(pd.getKey(), pd);
		}
		return map.values();
	}

	public void deploy(InputStream inputStream) throws Exception {
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		try {
			Deployment deployment = processEngine.getRepositoryService().createDeployment()
					.name("XXX").addZipInputStream(zipInputStream).deploy();
			System.out.println(deployment.getId());
			System.out.println(deployment.getName());
		} catch (Exception e) {
			ProcessEngine engine = ProcessEngineUtil.getProcessEngine();
			ZipInputStream zipInputStream1 = new ZipInputStream(inputStream);
			Deployment deployment = engine.getRepositoryService().createDeployment()
					.name("XXX").addZipInputStream(zipInputStream1).deploy();
			System.out.println(deployment.getId());
			System.out.println(deployment.getName());
		}
	}

	public void removePD(String key) {
		Collection<ProcessDefinition> pdList = processEngine.getRepositoryService().createProcessDefinitionQuery().processDefinitionKey(key)
				.list();
		try {
			for (ProcessDefinition processDefinition : pdList) {
				processEngine.getRepositoryService().deleteDeployment(processDefinition.getDeploymentId());
			}
			System.out.println("remove success!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public InputStream getImgManager(String deploymentId){
		/*1、根据deploymentID获取流程定义*/
		ProcessDefinition processDefinition = processEngine.getRepositoryService()
				.createProcessDefinitionQuery().deploymentId(deploymentId).singleResult();
		/*2:获取InpuStream*/
		InputStream inputStream = processEngine.getRepositoryService()
				.getResourceAsStream(deploymentId,processDefinition.getResourceName());
		return inputStream;
	}

}
