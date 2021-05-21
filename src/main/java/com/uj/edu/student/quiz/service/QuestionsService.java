package com.uj.edu.student.quiz.service;

import com.uj.edu.student.quiz.model.remoteAPI.Question;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionsService {

    private final RestTemplate restTemplate;

    public Question[] getGenericQuestions(List<String> tags, String difficulty, int limit) {
        String d = "difficulty=" + difficulty;
        String l = "limit=" + limit;
        String t = "tags=" + String.join(",", tags);
        String query = "https://quizapi.io/api/v1/questions?apiKey=oglecJoaTKPmp4oqt5fNofhptP1wb4SFWQS8cHfx" + "&" + d + "&" + l + "&" + t;
        ResponseEntity<Question[]> response = restTemplate.getForEntity(
                query,
                Question[].class);

        return response.getBody();
    }

    public Question[] getLinuxQuestions() {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(
                "https://quizapi.io/api/v1/questions?tags=Bash&difficulty=easy&limit=5&apiKey=oglecJoaTKPmp4oqt5fNofhptP1wb4SFWQS8cHfx",
                Question[].class);

        return response.getBody();
    }
}
