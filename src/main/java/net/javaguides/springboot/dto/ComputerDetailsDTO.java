package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComputerDetailsDTO {
    private String computerBrand;
    private int computerYearsUsed;
    private String computerDescription;
    private String computerImageUrl;
    private String signupName;
    private String signupEmail;
    private String signupPhoneNo;
    private String signupLocation;
    private Long signupId;
}
