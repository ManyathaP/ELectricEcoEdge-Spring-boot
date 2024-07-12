package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LaptopDetailsDTO {
	 private String laptopBrand;
	    private int laptopYearsUsed;
	    private String laptopDescription;
	    private String laptopImageUrl;
	    private String signupName;
	    private String signupEmail;
	    private String signupPhoneNo;
	    private String signupLocation;


}
