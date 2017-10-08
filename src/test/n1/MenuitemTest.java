package test.n1;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.blake.shoa.domain.Menuitem;
import cn.blake.shoa.service.MenuitemService;
import cn.blake.util.SessionFactoryUtil;

public class MenuitemTest {
	SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	MenuitemService menuitemService = SessionFactoryUtil.getCtx().getBean(MenuitemService.class);

	public static void main(String[] args) {
		MenuitemTest mTest = new MenuitemTest();
		mTest.isit();
	}
	public void isit(){
		Collection<Menuitem> menuitems = menuitemService.getAllMenuitem();
		for (Menuitem menuitem : menuitems) {
			System.out.println(menuitem);
		}
	}

	public void addMenuItem() {

		/***********************************************************************************/
		/*
		 * 个人办公
		 */
		Menuitem Menuitemitem1 = new Menuitem();
		Menuitemitem1.setMid(1);
		Menuitemitem1.setIcon("css/images/MenuIcon/FUNC20082.gif");
		Menuitemitem1.setName("办公自动化");
		Menuitemitem1.setPid(0);
		// Menuitemitem1.setChecked(false);
		Menuitemitem1.setIsParent(true);

		Menuitem Menuitem2 = new Menuitem();
		Menuitem2.setMid(2);
		Menuitem2.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menuitem2.setName("个人办公");
		// Menuitem2.setChecked(false);
		Menuitem2.setPid(1);
		Menuitem2.setIsParent(true);

		Menuitem Menuitem21 = new Menuitem();
		Menuitem21.setMid(21);
		Menuitem21.setIcon("css/images/MenuIcon/FUNC20054.gif");
		Menuitem21.setName("个人考勤");
		// Menuitem21.setChecked(false);
		Menuitem21.setPid(2);
		Menuitem21.setIsParent(false);

		Menuitem Menuitem22 = new Menuitem();
		Menuitem22.setMid(22);
		Menuitem22.setIcon("css/images/MenuIcon/FUNC23700.gif");
		Menuitem22.setName("日程安排");
		// Menuitem22.setChecked(false);
		Menuitem22.setPid(2);
		Menuitem22.setIsParent(false);

		Menuitem Menuitem23 = new Menuitem();
		Menuitem23.setMid(23);
		Menuitem23.setIcon("css/images/MenuIcon/FUNC20069.gif");
		Menuitem23.setName("工作计划");
		// Menuitem23.setChecked(false);
		Menuitem23.setPid(2);
		Menuitem23.setIsParent(false);

		Menuitem Menuitem24 = new Menuitem();
		Menuitem24.setMid(24);
		Menuitem24.setIcon("css/images/MenuIcon/FUNC20056.gif");
		Menuitem24.setName("工作日记");
		// Menuitem24.setChecked(false);
		Menuitem24.setPid(2);
		Menuitem24.setIsParent(false);

		Menuitem Menuitem25 = new Menuitem();
		Menuitem25.setMid(25);
		Menuitem25.setIcon("css/images/MenuIcon/time_date.gif");
		Menuitem25.setName("通讯录");
		// Menuitem25.setChecked(false);
		Menuitem25.setPid(2);
		Menuitem25.setIsParent(false);
		/*********************************************************************************/
		/*
		 * 审批流转
		 */
		Menuitem Menuitem3 = new Menuitem();
		Menuitem3.setMid(3);
		// /Menuitem3.setChecked(false);
		Menuitem3.setIsParent(true);
		Menuitem3.setPid(1);
		Menuitem3.setName("审批流转");
		Menuitem3.setIcon("css/images/MenuIcon/FUNC20057.gif");

		Menuitem Menuitem31 = new Menuitem();
		Menuitem31.setMid(31);
		// Menuitem31.setChecked(false);
		Menuitem31.setIsParent(false);
		Menuitem31.setPid(3);
		Menuitem31.setName("审批流程管理");
		Menuitem31.setIcon("css/images/MenuIcon/manager.gif");

		Menuitem Menuitem32 = new Menuitem();
		Menuitem32.setMid(32);
		// Menuitem32.setChecked(false);
		Menuitem32.setIsParent(false);
		Menuitem32.setPid(3);
		Menuitem32.setName("表单模板管理");
		Menuitem32.setIcon("css/images/MenuIcon/formmodel.gif");

		Menuitem Menuitem33 = new Menuitem();
		Menuitem33.setMid(33);
		Menuitem33.setIsParent(false);
		// Menuitem33.setChecked(false);
		Menuitem33.setPid(3);
		Menuitem33.setName("发起申请");
		Menuitem33.setIcon("css/images/MenuIcon/FUNC241000.gif");

		Menuitem Menuitem34 = new Menuitem();
		Menuitem34.setMid(34);
		Menuitem34.setIsParent(false);
		// Menuitem34.setChecked(false);
		Menuitem34.setPid(3);
		Menuitem34.setName("审批申请");
		Menuitem34.setIcon("css/images/MenuIcon/FUNC20029.gif");

		Menuitem Menuitem35 = new Menuitem();
		Menuitem35.setMid(35);
		Menuitem35.setIsParent(false);
		// Menuitem35.setChecked(false);
		Menuitem35.setPid(3);
		Menuitem35.setName("状态查询");
		Menuitem35.setIcon("css/images/MenuIcon/FUNC20029.gif");
		/************************************************************************************/
		/*
		 * 知识管理
		 */
		Menuitem Menuitem4 = new Menuitem();
		Menuitem4.setMid(4);
		Menuitem4.setIsParent(false);
		// Menuitem4.setChecked(false);
		Menuitem4.setPid(1);
		Menuitem4.setName("知识管理");
		Menuitem4.setIcon("css/images/MenuIcon/FUNC20056.gif");
		/*******************************************************************************/
		/*
		 * 综合行政
		 */
		Menuitem Menuitem5 = new Menuitem();
		Menuitem5.setMid(5);
		Menuitem5.setIsParent(true);
		// Menuitem5.setChecked(false);
		Menuitem5.setPid(1);
		Menuitem5.setName("管理行政");
		Menuitem5.setIcon("css/images/MenuIcon/manager.gif");

		Menuitem Menuitem51 = new Menuitem();
		Menuitem51.setMid(51);
		Menuitem51.setIsParent(false);
		// Menuitem51.setChecked(false);
		Menuitem51.setPid(5);
		Menuitem51.setName("考勤管理");
		Menuitem51.setIcon("css/images/MenuIcon/FUNC20070.gif");

		Menuitem Menuitem52 = new Menuitem();
		Menuitem52.setMid(52);
		Menuitem52.setIsParent(false);
		// Menuitem52.setChecked(false);
		Menuitem52.setPid(5);
		Menuitem52.setName("会议管理");
		Menuitem52.setIcon("css/images/MenuIcon/FUNC20064.gif");

		Menuitem Menuitem53 = new Menuitem();
		Menuitem53.setMid(53);
		Menuitem53.setIsParent(false);
		// Menuitem53.setChecked(false);
		Menuitem53.setPid(5);
		Menuitem53.setName("车辆管理");
		Menuitem53.setIcon("css/images/MenuIcon/radio_blue.gif");
		/**************************************************************************************/
		/*
		 * 人力资源管理 档案管理 培训记录 奖金记录 职位变更 人事合同 薪酬制度
		 */
		Menuitem Menuitem6 = new Menuitem();
		Menuitem6.setMid(6);
		Menuitem6.setIsParent(true);
		// Menuitem6.setChecked(false);
		Menuitem6.setPid(1);
		Menuitem6.setName("人力资源");
		Menuitem6.setIcon("css/images/MenuIcon/FUNC20001.gif");

		Menuitem Menuitem61 = new Menuitem();
		Menuitem61.setMid(61);
		Menuitem61.setIsParent(false);
		// Menuitem61.setChecked(false);
		Menuitem61.setPid(6);
		Menuitem61.setName("档案管理");
		Menuitem61.setIcon("css/images/MenuIcon/FUNC20076.gif");

		Menuitem Menuitem62 = new Menuitem();
		Menuitem62.setMid(62);
		Menuitem62.setIsParent(false);
		// Menuitem62.setChecked(false);
		Menuitem62.setPid(6);
		Menuitem62.setName("培训记录");
		Menuitem62.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Menuitem Menuitem63 = new Menuitem();
		Menuitem63.setMid(63);
		Menuitem63.setIsParent(false);
		// Menuitem63.setChecked(false);
		Menuitem63.setPid(6);
		Menuitem63.setName("奖赏记录");
		Menuitem63.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Menuitem Menuitem64 = new Menuitem();
		Menuitem64.setMid(64);
		Menuitem64.setIsParent(false);
		// Menuitem64.setChecked(false);
		Menuitem64.setPid(6);
		Menuitem64.setName("职位变更");
		Menuitem64.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Menuitem Menuitem65 = new Menuitem();
		Menuitem65.setMid(65);
		Menuitem65.setIsParent(false);
		// Menuitem65.setChecked(false);
		Menuitem65.setPid(6);
		Menuitem65.setName("人事合同");
		Menuitem65.setIcon("css/images/MenuIcon/FUNC55000.gif");

		Menuitem Menuitem66 = new Menuitem();
		Menuitem66.setMid(66);
		Menuitem66.setIsParent(false);
		// Menuitem66.setChecked(false);
		Menuitem66.setPid(6);
		Menuitem66.setName("薪酬制度");
		Menuitem66.setIcon("css/images/MenuIcon/FUNC20001.gif");
		/*****************************************************************************************/
		/*
		 * 电子邮件
		 */
		Menuitem Menuitem7 = new Menuitem();
		Menuitem7.setMid(7);
		Menuitem7.setIsParent(false);
		// Menuitem7.setChecked(false);
		Menuitem7.setPid(1);
		Menuitem7.setName("电子邮件");
		Menuitem7.setIcon("css/images/MenuIcon/eml.gif");

		/*******************************************************************/
		/*
		 * 实用工具 车票预定 GIS查询 邮政编码
		 */
		Menuitem Menuitem8 = new Menuitem();
		Menuitem8.setMid(8);
		Menuitem8.setIsParent(true);
		// Menuitem8.setChecked(false);
		Menuitem8.setPid(1);
		Menuitem8.setName("实用工具");
		Menuitem8.setIcon("css/images/MenuIcon/FUNC20076.gif");
		Menuitem Menuitem81 = new Menuitem();
		Menuitem81.setMid(81);
		Menuitem81.setIsParent(false);
		// Menuitem81.setChecked(false);
		Menuitem81.setPid(8);
		Menuitem81.setName("车票预定");
		Menuitem81.setIcon("css/images/MenuIcon/FUNC220000.gif");
		Menuitem Menuitem82 = new Menuitem();
		Menuitem82.setMid(82);
		Menuitem82.setIsParent(false);
		// Menuitem82.setChecked(false);
		Menuitem82.setPid(8);
		Menuitem82.setName("GIS查询");
		Menuitem82.setIcon("css/images/MenuIcon/search.gif");
		Menuitem Menuitem83 = new Menuitem();
		Menuitem83.setMid(83);
		Menuitem83.setIsParent(false);
		// Menuitem83.setChecked(false);
		Menuitem83.setPid(8);
		Menuitem83.setName("邮政编码");
		Menuitem83.setIcon("css/images/MenuIcon/FUNC249000.gif");
		/**************************************************************************/
		/*
		 * 个人设置 个人信息 密码修改
		 */
		Menuitem Menuitem9 = new Menuitem();
		Menuitem9.setMid(9);
		Menuitem9.setIsParent(true);
		// Menuitem9.setChecked(false);
		Menuitem9.setPid(1);
		Menuitem9.setName("个人设置");
		Menuitem9.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menuitem Menuitem91 = new Menuitem();
		Menuitem91.setMid(91);
		Menuitem91.setIsParent(false);
		// Menuitem91.setChecked(false);
		Menuitem91.setPid(9);
		Menuitem91.setName("个人信息");
		Menuitem91.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menuitem Menuitem92 = new Menuitem();
		Menuitem92.setMid(92);
		Menuitem92.setIsParent(false);
		// Menuitem92.setChecked(false);
		Menuitem92.setPid(9);
		Menuitem92.setName("密码修改");
		Menuitem92.setIcon("css/images/MenuIcon/FUNC241000.gif");
		/***********************************************************************************/
		/*
		 * 系统管理 岗位管理 部门管理 用户管理
		 */
		Menuitem Menuitem10 = new Menuitem();
		Menuitem10.setMid(10);
		Menuitem10.setIsParent(true);
		// Menuitem10.setChecked(false);
		Menuitem10.setPid(1);
		Menuitem10.setName("系统管理");
		Menuitem10.setIcon("css/images/MenuIcon/system.gif");
		Menuitem Menuitem101 = new Menuitem();
		Menuitem101.setMid(101);
		Menuitem101.setIsParent(false);
		// Menuitem101.setChecked(false);
		Menuitem101.setPid(10);
		Menuitem101.setName("岗位管理");
		Menuitem101.setIcon("css/images/MenuIcon/FUNC20001.gif");
		Menuitem Menuitem102 = new Menuitem();
		Menuitem102.setMid(102);
		Menuitem102.setIsParent(false);
		// Menuitem102.setChecked(false);
		Menuitem102.setPid(10);
		Menuitem102.setName("部门管理");
		Menuitem102.setIcon("css/images/MenuIcon/department.gif");
		Menuitem Menuitem103 = new Menuitem();
		Menuitem103.setMid(103);
		Menuitem103.setIsParent(false);
		// Menuitem103.setChecked(false);
		Menuitem103.setPid(10);
		Menuitem103.setName("用户管理");
		Menuitem103.setIcon("css/images/MenuIcon/FUNC20001.gif");
		/**********************************************************************/
		/*
		 * { 1,1 2,5 3,5 4,1 5,3 6,6 7,1 8,3 9,2 10,3 }
		 */

		session.save(Menuitemitem1);

		session.save(Menuitem2);
		session.save(Menuitem21);
		session.save(Menuitem22);
		session.save(Menuitem23);
		session.save(Menuitem24);
		session.save(Menuitem25);

		session.save(Menuitem3);
		session.save(Menuitem31);
		session.save(Menuitem32);
		session.save(Menuitem33);
		session.save(Menuitem34);
		session.save(Menuitem35);

		session.save(Menuitem4);

		session.save(Menuitem5);
		session.save(Menuitem51);
		session.save(Menuitem52);
		session.save(Menuitem53);

		session.save(Menuitem6);

		session.save(Menuitem61);
		session.save(Menuitem62);
		session.save(Menuitem63);
		session.save(Menuitem64);
		session.save(Menuitem65);
		session.save(Menuitem66);

		session.save(Menuitem7);

		session.save(Menuitem8);
		session.save(Menuitem81);
		session.save(Menuitem82);
		session.save(Menuitem83);

		session.save(Menuitem9);
		session.save(Menuitem91);
		session.save(Menuitem92);

		session.save(Menuitem10);
		session.save(Menuitem101);
		session.save(Menuitem102);
		session.save(Menuitem103);
		transaction.commit();
	}

	public void saveMenuitem_Privilege() {
		Menuitem Menuitem10 = new Menuitem();
		Menuitem10.setMid(11);
		Menuitem10.setIsParent(true);
		// Menuitem10.setChecked(false);
		Menuitem10.setPid(1);
		Menuitem10.setName("权限管理");
		Menuitem10.setIcon("css/images/MenuIcon/system.gif");
		session.save(Menuitem10);
		transaction.commit();
	}

	public void updateMenuitem_Privilege() {
		Menuitem Menuitem10 = new Menuitem();
		Menuitem10.setMid(11);
		Menuitem10.setIsParent(false);
		// Menuitem10.setChecked(false);
		Menuitem10.setPid(1);
		Menuitem10.setName("权限管理");
		Menuitem10.setIcon("css/images/MenuIcon/system.gif");
		session.update(Menuitem10);
		transaction.commit();
	}
}
