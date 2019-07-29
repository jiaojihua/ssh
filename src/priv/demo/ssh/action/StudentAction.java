package priv.demo.ssh.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import priv.demo.ssh.entity.Student;
import priv.demo.ssh.service.StudentService;
import priv.demo.ssh.util.PageUtil;

/**
 * 
 * @author 焦计划
 * @date 2019年7月26日 下午10:49:59
 */
@Controller("studentAction")
public class StudentAction extends ActionSupport {
	private StudentService studentService;
	private List<Student> students;
	private PageUtil pageUtil;
	private Student student;
	private int pageNum=1;

	public String findAllStudents() {
		this.students = studentService.searchAll();
		for(int i=0; i<50; i++) {
			Student stu = new Student();
			stu.setName("名字"+i);
			stu.setNation('汉');
			stu.setSex('男');
			stu.setGrade("风云一班");
			stu.setBirth(new Date());
			studentService.addStudent(stu);
			
		}
		return SUCCESS;
	}
	
	public String findStudentsByPage() {
		int totalCount = studentService.getTotalCount();
		pageUtil = new PageUtil(totalCount,pageNum);
		students = studentService.searchByPage(pageUtil.getPageSize(),pageNum);
		return SUCCESS;
	}
	
	

	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
