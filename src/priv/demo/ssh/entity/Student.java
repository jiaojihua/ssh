package priv.demo.ssh.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类
 * @author 焦计划
 * @date 2019年7月20日  上午7:20:22
 */
@Entity
public class Student extends Human{
	private int sid;
	private String school;
	private String grade;
	private String headMaster;
	
	public Student(String name, char sex, char nation, Date birth, String iDCard, String birthAddress,String school, String grade, String headMaster) {
		super(name, sex, nation, birth, iDCard, birthAddress);
		this.school = school;
		this.grade = grade;
		this.headMaster = headMaster;
		// TODO Auto-generated constructor stub
	}
	public Student(String name, char sex, char nation, Date birth, String iDCard, String birthAddress) {
		super(name, sex, nation, birth, iDCard, birthAddress);
		// TODO Auto-generated constructor stub
	}
	public Student(String school, String grade, String headMaster) {
		super();
		this.school = school;
		this.grade = grade;
		this.headMaster = headMaster;
	}
	public Student() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getHeadMaster() {
		return headMaster;
	}
	public void setHeadMaster(String headMaster) {
		this.headMaster = headMaster;
	}
	
	
}
