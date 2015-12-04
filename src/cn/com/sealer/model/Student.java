package cn.com.sealer.model;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable{

	private static final long serialVersionUID = 1008839474745209456L;
	
	
	
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, int age, int gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public Student(Map<String, Object> map) {
		int id = (int)map.get("id");
		String name = (String)map.get("stu_name");
		int age = (int)map.get("age");
		int gender = (int)map.get("gender");
		String address = (String)map.get("address");
		
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	private int id;//ѧ��id;
	private String name;//ѧ������;
	private int age;//ѧ������;
	private int gender;//ѧ���Ա�;
	private String address;//ѧ��סַ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
