package com.freelearningapp.uber.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "otp")
@Getter
@Setter
public class OTP extends Auditable {
	private String code;

	private String sentToNumber;

	@Builder.Default
	private Integer attemptsMade = 0;

	@Builder.Default
	private Boolean isValid = true;

	public static OTP randomOTP(String sentToNumber) {
		return OTP.builder().code("0000").sentToNumber(sentToNumber).build();
	}
}

// 1. Disk is cheap
// 2. Premature optimization is the root of all evil
