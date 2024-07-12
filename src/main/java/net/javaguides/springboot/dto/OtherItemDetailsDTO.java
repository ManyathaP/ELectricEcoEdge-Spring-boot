package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class OtherItemDetailsDTO {
	private String otherItemBrand;
    private int otherItemYearsUsed;
    private String otherItemDescription;
    private String otherItemImageUrl;
    private String signupName;
    private String signupEmail;
    private String signupPhoneNo;
    private String signupLocation;

}
