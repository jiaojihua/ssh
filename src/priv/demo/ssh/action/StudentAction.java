package priv.demo.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import priv.demo.ssh.entity.Student;
import priv.demo.ssh.service.StudentService;
/**
 * 
 * @author 焦计划
 * @date 2019年7月26日  下午10:49:59
 */
public class StudentAction extends ActionSupport {
	private StudentService studentService;
	private List<Student> students;
	
	public String findAllStudents() {
		this.students = studentService.searchAll();
		return SUCCESS;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	

}
