package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class MobileDetailsDTO {
	
	private String mobileBrand;
    private int mobileYearsUsed;
    private String mobileDescription;
    private String mobileImageUrl;
    private String signupName;
    private String signupEmail;
    private String signupPhoneNo;
    private String signupLocation;

}
