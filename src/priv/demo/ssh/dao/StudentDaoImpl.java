package priv.demo.ssh.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import priv.demo.ssh.entity.Student;
import priv.demo.ssh.util.BaseDaoImpl;
/**
 * 实现类
 * @author 焦计划
 * @date 2019年7月26日  上午12:32:07
 */
@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.sessionFactory = sessionFactory;
	}
	

}
