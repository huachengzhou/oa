package cn.blake.mvc;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.blake.shoa.InterceptorAndException.AppWideExceptionHandler;
import cn.blake.shoa.domain.Department;
import cn.blake.shoa.service.DepartmentService;

/**
 * @author Blake.Zhou
 * @see 部门 MVC
 */
@Controller
public class DepartmentController {

	private static final Log logger = LogFactory
			.getLog(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;

	/**
	 * @see 显示部门列表
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/showAllDepartment")
	public ModelAndView showAllDepartment(ModelAndView mv) {
		logger.info("showAllDepartment() 显示部门列表");
		Collection<Department> departments = departmentService
				.getAllDepartment();
		logger.debug("showAllDepartment() data:" + departments);
		mv.addObject("departments", departments);
		mv.setViewName("system/department/list");
		return mv;
	}

	/**
	 * @see 转到添加部门页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add_")
	public String saveUI(Model model) {
		logger.info("saveUI() 转到添加部门页面");
		model.addAttribute("dept", new Department());
		return "system/department/add";
	}

	/**
	 * @see 添加部门信息
	 */
	@RequestMapping(value = "/add")
	public String add(@ModelAttribute Department department, Model model) {
		logger.info("add() 添加部门信息");
		try {
			departmentService.DepartmentSave(department);
		} catch (Exception e) {
			logger.debug("Department:" + department + " " + e.getMessage());
		}
		return "redirect:/showAllDepartment";
	}

	/**
	 * @see 删除部门信息
	 * @param did
	 * @return
	 */
	@RequestMapping(value = "/removeDepartment")
	public String removeDepartment(@RequestParam Integer did) {
		logger.info("removeDepartment() 删除部门信息 id:" + did);
		try {
			departmentService.deleteDepartment(did);
		} catch (Exception e) {
			logger.debug("id:" + did + " ;" + e.getMessage());
		}
		return "redirect:/showAllDepartment";
	}

	/**
	 * @see 转入修改部门页面
	 * @param did
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateDepartment_")
	public String updateDepartment_(@RequestParam Integer did, Model model) {
		logger.info("updateDepartment_() 转入修改部门页面");
		Department department = departmentService.getDepartmentById(did);
		model.addAttribute("department", department);
		logger.debug("Department " + department);
		return "system/department/update";
	}

	/**
	 * @see 修改部门信息
	 * @param model
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "/updateDepartment")
	public String updateDepartment(Model model,
			@ModelAttribute Department department) {
		logger.info("updateDepartment() 修改部门信息 Department:" + department);
		try {
			departmentService.updateDepartment(department);
		} catch (Exception e) {
			logger.debug(department + " " + e.getMessage());
		}
		return "redirect:/showAllDepartment";
	}

	/**
	 * @see 回到部门主页
	 * @return
	 */
	@RequestMapping(value = "/goBack")
	public String goBack() {
		logger.info("goBack() 回到部门主页");
		return "redirect:/showAllDepartment";
	}

	/**
	 * @see 统一处理该控制器的所有异常
	 * @return
	 */
	@ExceptionHandler(AppWideExceptionHandler.class)
	public String handleDuplicateException() {
		return "exception/error";
	}
}
