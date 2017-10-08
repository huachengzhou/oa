package cn.blake.activiti;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.blake.util.SessionFactoryUtil;

public class SpringJDBCImpl implements SpringJDBC {
	private DataSource dataSource = SessionFactoryUtil.getCtx().getBean(DataSource.class);
	
	public void insert(Integer id,Integer rid){
		QueryRunner runner = new QueryRunner(dataSource);
		String sql = "insert into role_privilege(id,rid) values(?,?)";
		try {
			int i = runner.update(sql,new Object[]{id,rid});
			System.out.println((i>0?"³É¹¦":"Ê§°Ü"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	public List<String> getIList(Integer rid){
		QueryRunner runner = new QueryRunner(dataSource);
		String sql = "select id from role_privilege where rid = ?";
		List<String> idList = new ArrayList<String>();
		try {
			idList = runner.query(sql,rid,new BeanListHandler<String>(String.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idList;
	}
}
