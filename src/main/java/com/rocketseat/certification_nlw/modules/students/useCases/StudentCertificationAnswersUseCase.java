package com.rocketseat.certification_nlw.modules.students.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.questions.entities.QuestionEntity;
import com.rocketseat.certification_nlw.modules.questions.respositories.QuestionRepository;
import com.rocketseat.certification_nlw.modules.students.dto.StudentCertificationAnswerDTO;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private QuestionRepository questionRepository;

    // throws Exception => allow to deal with exception in time to call this method
    public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO dto) {
        
        // search by questions alternatives
        // - correct or incorrect
        List<QuestionEntity> questionEntity = questionRepository.findByTechnology(dto.getTechnology());

        dto.getQuestionAnswers()
            .stream().forEach(questionAnswer -> {
                var question = questionEntity.stream().
                    filter(q -> q.getId().equals(questionAnswer.getQuestionID()))
                    .findFirst().get();
                
                var findCorrectAlternative = question.getAlternatives().stream()
                    .filter(alternative -> alternative.isCorrect())
                    .findFirst().get();

                if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())) {
                    questionAnswer.setCorrect(true);    
                } else {
                    questionAnswer.setCorrect(false);
                }
            });

            // store certification information
            return dto;
    }

}
