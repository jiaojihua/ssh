package priv.demo.ssh.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;


/**
 * 抽象实体类 人
 * 
 * @author 焦计划
 * @date 2019年7月20日 上午7:23:06
 */
@MappedSuperclass
public abstract class Human {
	private String name;
	private char sex;
	private char nation;// 民族
	private Date birth;
	private String IDCard;
	private String birthAddress;

	public Human() {
		super();
	}

	public Human(String name, char sex, char nation, Date birth, String iDCard, String birthAddress) {
		super();
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.birth = birth;
		IDCard = iDCard;
		this.birthAddress = birthAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public char getNation() {
		return nation;
	}

	public void setNation(char nation) {
		this.nation = nation;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getBirthAddress() {
		return birthAddress;
	}

	public void setBirthAddress(String birthAddress) {
		this.birthAddress = birthAddress;
	}

}
