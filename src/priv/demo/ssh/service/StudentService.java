package priv.demo.ssh.service;

import java.util.List;

import priv.demo.ssh.entity.Student;

/**
 * 
 * @author 焦计划
 * @date 2019年7月26日  上午12:33:58
 */
public interface StudentService {
	public Student searchStudentById(int id);
	public List<Student> searchAll();
}
