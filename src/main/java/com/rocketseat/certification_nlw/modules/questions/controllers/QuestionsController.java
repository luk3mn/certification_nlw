package com.rocketseat.certification_nlw.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.questions.dto.AlternativesResultDTO;
import com.rocketseat.certification_nlw.modules.questions.dto.QuestionResultDTO;
import com.rocketseat.certification_nlw.modules.questions.entities.AlternativesEntity;
import com.rocketseat.certification_nlw.modules.questions.entities.QuestionEntity;
import com.rocketseat.certification_nlw.modules.questions.respositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology) { // all variable that comes on path
        System.out.println("TECH == " + technology);
        var result = this.questionRepository.findByTechnology(technology);
        
        var toMap = result.stream().map(question -> mapQuestionToDTO(question))
            .collect(Collectors.toList());
        return toMap;
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity questions) {
        var questionResultDTO = QuestionResultDTO.builder()
        .id(questions.getId())
        .technology(questions.getTechnology())
        .description(questions.getDescription()).build();
        
        List<AlternativesResultDTO> alternativesResultDTOs = 
        questions.getAlternatives()
        .stream().map(alternative -> mapAlternativesDTO(alternative))
        .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativesResultDTOs);
        return questionResultDTO;
    }

    static AlternativesResultDTO mapAlternativesDTO(AlternativesEntity alternativesResultDTO) {
        return AlternativesResultDTO.builder()
        .id(alternativesResultDTO.getId())
        .description(alternativesResultDTO.getDescription()).build();
    }
}
