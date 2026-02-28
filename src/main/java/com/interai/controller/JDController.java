package com.interai.controller;

import com.interai.service.PDFService;
import com.interai.service.AIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.ui.Model;

import java.io.File;

@Controller
public class JDController {

    @Autowired
    private PDFService pdfService;

    @Autowired
    private AIService aiService;



    @GetMapping("/jd")
    public String jdPage(){

        return "jd";

    }



    @PostMapping("/match")
    public String matchResume(

            @RequestParam("file") MultipartFile file,

            @RequestParam("jd") String jd,

            Model model

    ){


        try{

            File dir = new File("uploads");

            if(!dir.exists()) dir.mkdir();


String uploadDir = System.getProperty("user.dir") + "/uploads/";

File uploadFolder = new File(uploadDir);

if (!uploadFolder.exists()) {
    uploadFolder.mkdirs();
}

String path = uploadDir + file.getOriginalFilename();

file.transferTo(new File(path));



            String resumeText = pdfService.extractText(path);



            String result =
                    aiService.matchResumeWithJD(resumeText, jd);



            model.addAttribute("result", result);



            return "result";

        }

        catch(Exception e){

            e.printStackTrace();

            model.addAttribute("result",
                    "Error: " + e.getMessage());

            return "result";

        }

    }

}