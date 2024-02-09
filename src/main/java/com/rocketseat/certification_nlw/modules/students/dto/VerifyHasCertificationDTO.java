package com.rocketseat.certification_nlw.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter and Setters automatically
@AllArgsConstructor // create a constructor with all atributes
@NoArgsConstructor // empty constructor
public class VerifyHasCertificationDTO {
    
    private String email;
    private String technology;

}
