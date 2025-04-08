package com.springbootp3.QuizApp.controller;

import com.springbootp3.QuizApp.DTO.AnswerReview;
import com.springbootp3.QuizApp.DTO.UserAnswer;
import com.springbootp3.QuizApp.model.Quiz;
import com.springbootp3.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    //get all questions
    @GetMapping("/questions")
    public List<Quiz> getQuestions(){
        return quizService.getAllQuestions();
    }

    //submit
    @PostMapping("/submit")
    public Map<String,Object> submitQuiz(@RequestBody List<UserAnswer> answers){
        int score = quizService.calcScore(answers);
        List<AnswerReview> review = quizService.getAnswerReview(answers);

        Map<String, Object> result = new HashMap<>();
        result.put("Score",score);
        result.put("review",review);
        return result;
    }
}
