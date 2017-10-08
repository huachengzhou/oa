package test.n1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;

import cn.blake.shoa.domain.Privilege;
import cn.blake.util.SessionFactoryUtil;
/**
 * 
 * @author Blake.Zhou
 *  注意:testSavePrivilege_Menuitem要先执行一次,然后在执行另外一个方法,另外就是不要设置为自动增长类型
 */
public class PrivilegeTest {
	ApplicationContext applicationContext = SessionFactoryUtil.getCtx();
	Session session = SessionFactoryUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	public static void main(String[] args) {
		PrivilegeTest pTest = new PrivilegeTest();
		pTest.testSavePrivilege_Function();
	}
	/**
	 * 插入两个类型的数据 1、菜单类型的数据 2、功能类型的数据
	 */
	public  void testSavePrivilege_Menuitem() {
         String rightTarget = "right";
		/***********************************************************************************/
		/*
		 * 个人办公
		 */
		Privilege Privilegeitem1 = new Privilege();
		Privilegeitem1.setId(1);
		Privilegeitem1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		Privilegeitem1.setName("办公自动化");
		Privilegeitem1.setPid(0);
		Privilegeitem1.setFlag("1");
		Privilegeitem1.setIsParent(true);

		Privilege Privilege2 = new Privilege();
		Privilege2.setId(2);
		Privilege2.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Privilege2.setName("个人办公");
		// Privilege2.setChecked(false);
		Privilege2.setPid(1);
		Privilege2.setFlag("1");
		Privilege2.setIsParent(true);

		Privilege Privilege21 = new Privilege();
		Privilege21.setId(21);
		Privilege21.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Privilege21.setName("个人考勤");
		// Privilege21.setChecked(false);
		Privilege21.setPid(2);
		Privilege21.setFlag("1");
		Privilege21.setIsParent(false);

		Privilege Privilege22 = new Privilege();
		Privilege22.setId(22);
		Privilege22.setIcon("css/images/MenuIcon/FUNC23700.gif");
		Privilege22.setName("日程安排");
		// Privilege22.setChecked(false);
		Privilege22.setPid(2);
		Privilege22.setFlag("1");
		Privilege22.setIsParent(false);

		Privilege Privilege23 = new Privilege();
		Privilege23.setId(23);
		Privilege23.setIcon("css/images/MenuIcon/FUNC20069.gif");
		Privilege23.setName("工作计划");
		// Privilege23.setChecked(false);
		Privilege23.setPid(2);
		Privilege23.setFlag("1");
		Privilege23.setIsParent(false);

		Privilege Privilege24 = new Privilege();
		Privilege24.setId(24);
		Privilege24.setIcon("css/images/MenuIcon/FUNC20056.gif");
		Privilege24.setName("工作日记");
		// Privilege24.setChecked(false);
		Privilege24.setPid(2);
		Privilege24.setFlag("1");
		Privilege24.setIsParent(false);

		Privilege Privilege25 = new Privilege();
		Privilege25.setId(25);
		Privilege25.setIcon("css/images/MenuIcon/time_date.gif");
		Privilege25.setName("通讯录");
		// Privilege25.setChecked(false);
		Privilege25.setPid(2);
		Privilege25.setFlag("1");
		Privilege25.setIsParent(false);
		/*********************************************************************************/
		/*
		 * 审批流转
		 */
		Privilege Privilege3 = new Privilege();
		Privilege3.setId(3);
		// /Privilege3.setChecked(false);
		Privilege3.setIsParent(true);
		Privilege3.setPid(1);
		Privilege3.setName("审批流转");
		Privilege3.setFlag("1");
		Privilege3.setIcon("css/images/MenuIcon/FUNC20057.gif");

		Privilege Privilege31 = new Privilege();
		Privilege31.setId(31);
		// Privilege31.setChecked(false);
		Privilege31.setIsParent(false);
		Privilege31.setPid(3);
		Privilege31.setFlag("1");
		Privilege31.setName("审批流程管理");
		Privilege31.setIcon("css/images/MenuIcon/manager.gif");

		Privilege Privilege32 = new Privilege();
		Privilege32.setId(32);
		// Privilege32.setChecked(false);
		Privilege32.setIsParent(false);
		Privilege32.setPid(3);
		Privilege32.setFlag("1");
		Privilege32.setName("表单模板管理");
		Privilege32.setIcon("css/images/MenuIcon/formmodel.gif");

		Privilege Privilege33 = new Privilege();
		Privilege33.setId(33);
		Privilege33.setIsParent(false);
		// Privilege33.setChecked(false);
		Privilege33.setPid(3);
		Privilege33.setFlag("1");
		Privilege33.setName("发起申请");
		Privilege33.setIcon("css/images/MenuIcon/FUNC241000.gif");

		Privilege Privilege34 = new Privilege();
		Privilege34.setId(34);
		Privilege34.setIsParent(false);
		// Privilege34.setChecked(false);
		Privilege34.setPid(3);
		Privilege34.setFlag("1");
		Privilege34.setName("审批申请");
		Privilege34.setIcon("css/images/MenuIcon/FUNC20029.gif");

		Privilege Privilege35 = new Privilege();
		Privilege35.setId(35);
		Privilege35.setIsParent(false);
		// Privilege35.setChecked(false);
		Privilege35.setPid(3);
		Privilege35.setName("状态查询");
		Privilege35.setFlag("1");
		Privilege35.setIcon("css/images/MenuIcon/FUNC20029.gif");
		/************************************************************************************/
		/*
		 * 知识管理
		 */
		Privilege Privilege4 = new Privilege();
		Privilege4.setId(4);
		Privilege4.setIsParent(false);
		// Privilege4.setChecked(false);
		Privilege4.setPid(1);
		Privilege4.setFlag("1");
		Privilege4.setName("知识管理");
		Privilege4.setIcon("css/images/MenuIcon/FUNC20056.gif");
		/*******************************************************************************/
		/*
		 * 综合行政
		 */
		Privilege Privilege5 = new Privilege();
		Privilege5.setId(5);
		Privilege5.setIsParent(true);
		// Privilege5.setChecked(false);
		Privilege5.setPid(1);
		Privilege5.setFlag("1");
		Privilege5.setName("管理行政");
		Privilege5.setIcon("css/images/MenuIcon/manager.gif");

		Privilege Privilege51 = new Privilege();
		Privilege51.setId(51);
		Privilege51.setIsParent(false);
		// Privilege51.setChecked(false);
		Privilege51.setPid(5);
		Privilege51.setName("考勤管理");
		Privilege51.setFlag("1");
		Privilege51.setIcon("css/images/MenuIcon/FUNC20070.gif");

		Privilege Privilege52 = new Privilege();
		Privilege52.setId(52);
		Privilege52.setIsParent(false);
		// Privilege52.setChecked(false);
		Privilege52.setPid(5);
		Privilege52.setFlag("1");
		Privilege52.setName("会议管理");
		Privilege52.setIcon("css/images/MenuIcon/FUNC20064.gif");

		Privilege Privilege53 = new Privilege();
		Privilege53.setId(53);
		Privilege53.setIsParent(false);
		// Privilege53.setChecked(false);
		Privilege53.setPid(5);
		Privilege53.setFlag("1");
		Privilege53.setName("车辆管理");
		Privilege53.setIcon("css/images/MenuIcon/radio_blue.gif");
		/**************************************************************************************/
		/*
		 * 人力资源管理 档案管理 培训记录 奖金记录 职位变更 人事合同 薪酬制度
		 */
		Privilege Privilege6 = new Privilege();
		Privilege6.setId(6);
		Privilege6.setIsParent(true);
		// Privilege6.setChecked(false);
		Privilege6.setPid(1);
		Privilege6.setFlag("1");
		Privilege6.setName("人力资源");
		Privilege6.setIcon("css/images/MenuIcon/FUNC20001.gif");

		Privilege Privilege61 = new Privilege();
		Privilege61.setId(61);
		Privilege61.setIsParent(false);
		// Privilege61.setChecked(false);
		Privilege61.setPid(6);
		Privilege61.setFlag("1");
		Privilege61.setName("档案管理");
		Privilege61.setIcon("css/images/MenuIcon/FUNC20076.gif");

		Privilege Privilege62 = new Privilege();
		Privilege62.setId(62);
		Privilege62.setFlag("1");
		Privilege62.setIsParent(false);
		// Privilege62.setChecked(false);
		Privilege62.setPid(6);
		Privilege62.setName("培训记录");
		Privilege62.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Privilege Privilege63 = new Privilege();
		Privilege63.setId(63);
		Privilege63.setFlag("1");
		Privilege63.setIsParent(false);
		// Privilege63.setChecked(false);
		Privilege63.setPid(6);
		Privilege63.setName("奖赏记录");
		Privilege63.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Privilege Privilege64 = new Privilege();
		Privilege64.setId(64);
		Privilege64.setIsParent(false);
		Privilege64.setFlag("1");
		// Privilege64.setChecked(false);
		Privilege64.setPid(6);
		Privilege64.setName("职位变更");
		Privilege64.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Privilege Privilege65 = new Privilege();
		Privilege65.setId(65);
		Privilege65.setIsParent(false);
		// Privilege65.setChecked(false);
		Privilege65.setPid(6);
		Privilege65.setFlag("1");
		Privilege65.setName("人事合同");
		Privilege65.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Privilege Privilege66 = new Privilege();
		Privilege66.setId(66);
		Privilege66.setIsParent(false);
		// Privilege66.setChecked(false);
		Privilege66.setPid(6);
		Privilege66.setFlag("1");
		Privilege66.setName("薪酬制度");
		Privilege66.setIcon("css/images/MenuIcon/FUNC20001.gif");
		/*****************************************************************************************/
		/*
		 * 电子邮件
		 */
		Privilege Privilege7 = new Privilege();
		Privilege7.setId(7);
		Privilege7.setIsParent(false);
		// Privilege7.setChecked(false);
		Privilege7.setPid(1);
		Privilege7.setFlag("1");
		Privilege7.setName("电子邮件");
		Privilege7.setIcon("css/images/MenuIcon/eml.gif");

		/*******************************************************************/
		/*
		 * 实用工具 车票预定 GIS查询 邮政编码
		 */
		Privilege Privilege8 = new Privilege();
		Privilege8.setId(8);
		Privilege8.setIsParent(true);
		// Privilege8.setChecked(false);
		Privilege8.setPid(1);
		Privilege8.setFlag("1");
		Privilege8.setName("实用工具");
		Privilege8.setIcon("css/images/MenuIcon/FUNC20076.gif");

		Privilege Privilege81 = new Privilege();
		Privilege81.setId(81);
		Privilege81.setIsParent(false);
		// Privilege81.setChecked(false);
		Privilege81.setPid(8);
		Privilege81.setFlag("1");
		Privilege81.setName("车票预定");
		Privilege81.setIcon("css/images/MenuIcon/FUNC220000.gif");

		Privilege Privilege82 = new Privilege();
		Privilege82.setId(82);
		Privilege82.setIsParent(false);
		// Privilege82.setChecked(false);
		Privilege82.setPid(8);
		Privilege82.setFlag("1");
		Privilege82.setName("GIS查询");
		Privilege82.setIcon("css/images/MenuIcon/search.gif");

		Privilege Privilege83 = new Privilege();
		Privilege83.setId(83);
		Privilege83.setIsParent(false);
		// Privilege83.setChecked(false);
		Privilege83.setFlag("1");
		Privilege83.setPid(8);
		Privilege83.setName("邮政编码");
		Privilege83.setIcon("css/images/MenuIcon/FUNC249000.gif");
		/**************************************************************************/
		/*
		 * 个人设置 个人信息 密码修改
		 */
		Privilege Privilege9 = new Privilege();
		Privilege9.setId(9);
		Privilege9.setIsParent(true);
		// Privilege9.setChecked(false);
		Privilege9.setPid(1);
		Privilege9.setFlag("1");
		Privilege9.setName("个人设置");
		Privilege9.setIcon("css/images/MenuIcon/FUNC20001.gif");

		Privilege Privilege91 = new Privilege();
		Privilege91.setId(91);
		Privilege91.setIsParent(false);
		// Privilege91.setChecked(false);
		Privilege91.setPid(9);
		Privilege91.setFlag("1");
		Privilege91.setName("个人信息");
		Privilege91.setIcon("css/images/MenuIcon/FUNC20001.gif");

		Privilege Privilege92 = new Privilege();
		Privilege92.setId(92);
		Privilege92.setIsParent(false);
		// Privilege92.setChecked(false);
		Privilege92.setFlag("1");
		Privilege92.setPid(9);
		Privilege92.setName("密码修改");
		Privilege92.setIcon("css/images/MenuIcon/FUNC241000.gif");
		/***********************************************************************************/
		/*
		 * 系统管理 岗位管理 部门管理 用户管理
		 */
		Privilege Privilege10 = new Privilege();
		Privilege10.setId(10);
		Privilege10.setIsParent(true);
		// Privilege10.setChecked(false);
		Privilege10.setPid(1);
		Privilege10.setFlag("1");
		Privilege10.setName("系统管理");
		Privilege10.setIcon("css/images/MenuIcon/system.gif");

		Privilege Privilege101 = new Privilege();
		Privilege101.setId(101);
		Privilege101.setIsParent(false);
		// Privilege101.setChecked(false);
		Privilege101.setPid(10);
		Privilege101.setFlag("1");
		Privilege101.setName("岗位管理");
		Privilege101.setTarget(rightTarget);
		Privilege101.setUrl("showAllRole");
		Privilege101.setIcon("css/images/MenuIcon/FUNC20001.gif");

		Privilege Privilege102 = new Privilege();
		Privilege102.setId(102);
		Privilege102.setIsParent(false);
		// Privilege102.setChecked(false);
		Privilege102.setPid(10);
		Privilege102.setName("部门管理");
		Privilege102.setTarget(rightTarget);
		Privilege102.setUrl("showAllDepartment");
		Privilege102.setFlag("1");
		Privilege102.setIcon("css/images/MenuIcon/department.gif");

		Privilege Privilege103 = new Privilege();
		Privilege103.setId(103);
		Privilege103.setIsParent(false);
		// Privilege103.setChecked(false);
		Privilege103.setPid(10);
		Privilege103.setFlag("1");
		Privilege103.setName("用户管理");
		Privilege103.setTarget(rightTarget);
		Privilege103.setUrl("showAllUser");
		Privilege103.setIcon("css/images/MenuIcon/FUNC20001.gif");
		/**********************************************************************/
		/*
		 * { 1,1 2,5 3,5 4,1 5,3 6,6 7,1 8,3 9,2 10,3 }
		 */

		session.save(Privilegeitem1);

		session.save(Privilege2);
		session.save(Privilege21);
		session.save(Privilege22);
		session.save(Privilege23);
		session.save(Privilege24);
		session.save(Privilege25);

		session.save(Privilege3);
		session.save(Privilege31);
		session.save(Privilege32);
		session.save(Privilege33);
		session.save(Privilege34);
		session.save(Privilege35);

		session.save(Privilege4);

		session.save(Privilege5);
		session.save(Privilege51);
		session.save(Privilege52);
		session.save(Privilege53);

		session.save(Privilege6);

		session.save(Privilege61);
		session.save(Privilege62);
		session.save(Privilege63);
		session.save(Privilege64);
		session.save(Privilege65);
		session.save(Privilege66);

		session.save(Privilege7);

		session.save(Privilege8);
		session.save(Privilege81);
		session.save(Privilege82);
		session.save(Privilege83);

		session.save(Privilege9);
		session.save(Privilege91);
		session.save(Privilege92);

		session.save(Privilege10);
		session.save(Privilege101);
		session.save(Privilege102);
		session.save(Privilege103);
		transaction.commit();
	}

	/**
	 * 保存功能
	 */
	public void testSavePrivilege_Function() {
		String rightTarget = "right";
		Privilege Privilege1 = new Privilege();
		Privilege1.setId(201);
		Privilege1.setFlag("2");
		Privilege1.setPid(0);
		Privilege1.setIcon("css/images/MenuIcon/system.gif");
		Privilege1.setName("用户增加");
		Privilege1.setUrl("addUser_");
		Privilege1.setTarget(rightTarget);

		Privilege Privilege2 = new Privilege();
		Privilege2.setId(202);
		Privilege2.setFlag("2");
		Privilege2.setPid(0);
		Privilege2.setIcon("css/images/MenuIcon/system.gif");
		Privilege2.setName("用户删除");
		Privilege2.setUrl("removeUser");
		Privilege2.setTarget(rightTarget);

		Privilege Privilege3 = new Privilege();
		Privilege3.setId(203);
		Privilege3.setFlag("2");
		Privilege3.setPid(0);
		Privilege3.setIcon("css/images/MenuIcon/system.gif");
		Privilege3.setName("用户修改");
		Privilege3.setUrl("updateUser_");
		Privilege3.setTarget(rightTarget);

		Privilege Privilege32 = new Privilege();
		Privilege32.setId(210);
		Privilege32.setFlag("2");
		Privilege32.setPid(0);
		Privilege32.setIcon("css/images/MenuIcon/system.gif");
		Privilege32.setName("用户查询");

		Privilege Privilege4 = new Privilege();
		Privilege4.setId(204);
		Privilege4.setFlag("2");
		Privilege4.setPid(0);
		Privilege4.setIcon("css/images/MenuIcon/system.gif");
		Privilege4.setName("部门增加");
		Privilege4.setUrl("add_");
		Privilege4.setTarget(rightTarget);

		Privilege Privilege5 = new Privilege();
		Privilege5.setId(205);
		Privilege5.setFlag("2");
		Privilege5.setPid(0);
		Privilege5.setIcon("css/images/MenuIcon/system.gif");
		Privilege5.setName("部门删除");
		Privilege5.setUrl("removeDepartment");
		Privilege5.setTarget(rightTarget);

		Privilege Privilege6 = new Privilege();
		Privilege6.setId(206);
		Privilege6.setFlag("2");
		Privilege6.setPid(0);
		Privilege6.setIcon("css/images/MenuIcon/system.gif");
		Privilege6.setName("部门修改");
		Privilege6.setTarget(rightTarget);
		Privilege6.setUrl("updateDepartment_");

		Privilege Privilege66 = new Privilege();
		Privilege66.setId(211);
		Privilege66.setFlag("2");
		Privilege66.setPid(0);
		Privilege66.setIcon("css/images/MenuIcon/system.gif");
		Privilege66.setName("部门查询");

		Privilege Privilege7 = new Privilege();
		Privilege7.setId(207);
		Privilege7.setFlag("2");
		Privilege7.setPid(0);
		Privilege7.setIcon("css/images/MenuIcon/system.gif");
		Privilege7.setName("岗位增加");
		Privilege7.setTarget(rightTarget);
		Privilege7.setUrl("addRole_");

		Privilege Privilege8 = new Privilege();
		Privilege8.setId(208);
		Privilege8.setFlag("2");
		Privilege8.setPid(0);
		Privilege8.setIcon("css/images/MenuIcon/system.gif");
		Privilege8.setName("岗位删除");
		Privilege8.setTarget(rightTarget);
		Privilege8.setUrl("removeRole");

		Privilege Privilege9 = new Privilege();
		Privilege9.setId(209);
		Privilege9.setFlag("2");
		Privilege9.setPid(0);
		Privilege9.setIcon("css/images/MenuIcon/system.gif");
		Privilege9.setName("岗位修改");
		Privilege9.setTarget(rightTarget);
		Privilege9.setUrl("updateRole_");

		Privilege Privilege99 = new Privilege();
		Privilege99.setId(212);
		Privilege99.setFlag("2");
		Privilege99.setPid(0);
		Privilege99.setIcon("css/images/MenuIcon/system.gif");
		Privilege99.setName("岗位查询");

		session.save(Privilege1);
		session.save(Privilege2);
		session.save(Privilege3);
		session.save(Privilege32);
		session.save(Privilege66);
		session.save(Privilege99);
		session.save(Privilege4);
		session.save(Privilege5);

		session.save(Privilege6);
		session.save(Privilege7);
		session.save(Privilege8);
		session.save(Privilege9);

		transaction.commit();
	}
}
