package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class TabletDetailsDTO {
	
	private String tabletBrand;
    private int tabletYearsUsed;
    private String tabletDescription;
    private String tabletImageUrl;
    private String signupName;
    private String signupEmail;
    private String signupPhoneNo;
    private String signupLocation;

}
