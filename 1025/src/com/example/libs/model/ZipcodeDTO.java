package com.example.libs.model;

public class ZipcodeDTO {
	private String zipcode, sido, gugun, dong, bunji;

	public ZipcodeDTO(String zipcode, String sido, String gugun, String dong, String bunji) {
		this.zipcode = zipcode;   this.sido = sido;   this.gugun = gugun;
		this.dong = dong;          this.bunji = bunji;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getSido() {
		return sido;
	}

	public String getGugun() {
		return gugun;
	}

	public String getDong() {
		return dong;
	}

	public String getBunji() {
		return bunji;
	}
	@Override
	public String toString() {
		return String.format("[%s] %s %s %s", zipcode, sido, gugun, dong);
	}
}
