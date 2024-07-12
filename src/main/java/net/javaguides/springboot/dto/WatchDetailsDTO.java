package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class WatchDetailsDTO {
	private String watchBrand;
    private int watchYearsUsed;
    private String watchDescription;
    private String watchImageUrl;
    private String signupName;
    private String signupEmail;
    private String signupPhoneNo;
    private String signupLocation;

}
