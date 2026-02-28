package com.interai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;
import java.util.List;

@Service
public class AIService {

    @Value("${gemini.api.key}")
    private String apiKey;


    private final String GEMINI_URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=";



    // ==========================
    // Resume Feedback
    // ==========================

    public String getFeedback(String resumeText){

        String prompt =

                "Analyze this resume and give:\n\n"

                + "Overall feedback\n"
                + "Missing skills\n"
                + "Improvement suggestions\n\n"

                + "Resume:\n"

                + resumeText;


        return callGemini(prompt);

    }



    // ==========================
    // Resume JD Matching
    // ==========================

    public String matchResumeWithJD(String resumeText, String jdText){

        String prompt =

                "Compare the following resume and job description. "

                + "Give output in this format:\n\n"

                + "Match Score:\n"
                + "Matching Skills:\n"
                + "Missing Skills:\n"
                + "Suggestions:\n\n"

                + "Resume:\n"

                + resumeText

                + "\n\nJob Description:\n"

                + jdText;


        return callGemini(prompt);

    }




    // ==========================
    // Gemini API Call
    // ==========================

    private String callGemini(String prompt){

        try{

            RestTemplate restTemplate = new RestTemplate();


            String url = GEMINI_URL + apiKey;


            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);


            String body =
                    "{ \"contents\": [ { \"parts\": [ { \"text\": \"" +
                            prompt.replace("\"","\\\"")
                                    .replace("\n","\\n")
                            + "\" } ] } ] }";


            HttpEntity<String> entity =
                    new HttpEntity<>(body, headers);


            ResponseEntity<Map> response =
                    restTemplate.postForEntity(
                            url,
                            entity,
                            Map.class
                    );



            // ==========================
            // Extract TEXT from JSON
            // ==========================

            Map responseBody = response.getBody();


            List candidates =
                    (List) responseBody.get("candidates");


            Map firstCandidate =
                    (Map) candidates.get(0);


            Map content =
                    (Map) firstCandidate.get("content");


            List parts =
                    (List) content.get("parts");


            Map firstPart =
                    (Map) parts.get(0);


            String text =
                    firstPart.get("text").toString();


            return text;


        }

        catch(Exception e){

            e.printStackTrace();

            return "Error calling Gemini API: " + e.getMessage();

        }

    }


}