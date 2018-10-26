package com.example.libs.model;

public class TaxDTO {
	private String dept, name,code,num;
	private int gibon,honum,famsal,nightsal,sum,sal,nighttime,famnum,jobsal,intax;
	public TaxDTO(String num, int honum, int nighttime, int famnum) {
		this.num = num;
		this.honum = honum;
		this.nighttime = nighttime;
		this.famnum = famnum;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getGibon() {
		return gibon;
	}
	public void setGibon(int gibon) {
		this.gibon = gibon;
	}
	public int getHonum() {
		return honum;
	}
	public void setHonum(int hosal) {
		this.honum = hosal;
	}
	public int getFamsal() {
		return famsal;
	}
	public void setFamsal(int famsal) {
		this.famsal = famsal;
	}
	public int getNightsal() {
		return nightsal;
	}
	public void setNightsal(int nightsal) {
		this.nightsal = nightsal;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getNighttime() {
		return nighttime;
	}
	public void setNighttime(int nighttime) {
		this.nighttime = nighttime;
	}
	public int getFamnum() {
		return famnum;
	}
	public void setFamnum(int famnum) {
		this.famnum = famnum;
	}
	public int getJobsal() {
		return jobsal;
	}
	public void setJobsal(int jobsal) {
		this.jobsal = jobsal;
	}
	public int getIntax() {
		return intax;
	}
	public void setIntax(int intax) {
		this.intax = intax;
	}
	@Override
	public String toString() {
		return "TaxDTO [dept=" + dept + ", name=" + name + ", code=" + code + ", num=" + num + ", gibon=" + gibon
				+ ", honum=" + honum + ", famsal=" + famsal + ", nightsal=" + nightsal + ", sum=" + sum + ", sal=" + sal
				+ ", nighttime=" + nighttime + ", famnum=" + famnum + ", jobsal=" + jobsal + ", intax=" + intax + "]";
	}
	
}
