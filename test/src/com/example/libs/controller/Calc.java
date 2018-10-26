package com.example.libs.controller;

import com.example.libs.model.StudentDTO;

public class Calc {
	private StudentDTO student;
	public Calc(StudentDTO student) {
		this.student = student;
	}
	public void calc() {
		int sum = this.student.getKor() + this.student.getEng() + this.student.getMat() + this.student.getEdp();
		double avg = sum / 4.;
		char grade = (avg <= 100 && avg >= 90) ? 'A' :
								(avg < 90 && avg >= 80) ? 'B' :
									(avg < 80 && avg >= 70) ? 'C' :
										(avg < 70 && avg >= 60) ? 'D' : 'F';
		this.student.setSum(sum);
		this.student.setAvg(avg);
		this.student.setGrade(grade);
	}
}





