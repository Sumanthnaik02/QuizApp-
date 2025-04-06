package com.springbootp3.QuizApp.service;

import com.springbootp3.QuizApp.DTO.AnswerReview;
import com.springbootp3.QuizApp.DTO.UserAnswer;
import com.springbootp3.QuizApp.model.Quiz;
import com.springbootp3.QuizApp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private final QuizRepository questionRepository;

    QuizService(QuizRepository questionRepository){
        this.questionRepository=questionRepository;
    }
    public List<Quiz> getAllQuestions(){
        return questionRepository.findAll();
    }

   public int calcScore(List<UserAnswer> answers){
        int score = 0;
        for (UserAnswer ans : answers){
           Quiz question = questionRepository.findById(ans.getQuestionId()).orElse(null);
           if(question != null && question.getCorrectAnswer().equals(ans.getAnswer())){
               score++;
           }
        }
        return score;
   }

   public List<AnswerReview> getAnswerReview(List<UserAnswer> answers){
        List<AnswerReview> reviews = new ArrayList<>();
        for(UserAnswer ans : answers){
            Quiz questions = questionRepository.findById(ans.getQuestionId()).orElse(null);
            if (questions != null) {
                reviews.add(new AnswerReview(
                      questions.getQuestion(),
                      questions.getOption1(),
                      questions.getOption2(),
                      questions.getOption3(),
                      questions.getOption4(),
                      ans.getAnswer(),
                      questions.getCorrectAnswer()
                ));
            }
        }
        return reviews;
   }
}
