package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.rocketseat.certification_nlw.modules.students.useCases.VerifyHasCertificationUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyHasCertificationUseCase verifyHasCertificationUseCase;
    
    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
        // Emai
        // Technology
        var result = this.verifyHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if (result) {
            return "User has already done the exam";
        }
        
        return "User can do the exam";
    }

    @PostMapping("/certification/answer")
    public StudentCertificationAnswerDTO certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        return studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
    }

}
