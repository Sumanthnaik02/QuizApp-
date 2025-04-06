package com.springbootp3.QuizApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class AnswerReview {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String correctAnswer;

    public AnswerReview(String question, String option1, String option2, String option3, String option4, String answer, String correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }
}
