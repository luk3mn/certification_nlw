package com.rocketseat.certification_nlw.modules.students.useCases;

import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;

@Service // it means this layer is a service layer
public class VerifyHasCertificationUseCase {
    
    public boolean execute( VerifyHasCertificationDTO dto ) {
        if(dto.getEmail().equals("luke@gmail.com") && dto.getTechnology().equals("JAVA")) {
            return true;
        }
        return false;
    }

}
