package com.rocketseat.certification_nlw.modules.students.entities;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // Getter and Setters automatically
@AllArgsConstructor // create a constructor with all atributes
@NoArgsConstructor // empty constructor
public class CertificationStudentEntity {
    
    private UUID id;
    private UUID studentID;
    private String technology;
    private int grade;
    List<AnswersCertificationEntity> answersCertificationEntities;

}
