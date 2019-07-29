package priv.demo.ssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.demo.ssh.dao.StudentDao;
import priv.demo.ssh.entity.Student;
/**
 * 
 * @author 焦计划
 * @date 2019年7月26日  上午12:35:35
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	@Override
	public Student searchStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	@Override
	public List<Student> searchAll() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}
	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}

	@Override
	public void modifyStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDao.deletyById(id);;
	}

	@Override
	public List<Student> searchByPage(int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		return studentDao.findByPage(pageNum, pageSize);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return studentDao.getTotalCount();
	}
	
	

}
