
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
public class ResumeController {

    @Autowired
    PDFService pdfService;

    @Autowired
    AIService aiService;

    @GetMapping("/upload")
    public String uploadPage(){
        return "upload";
    }

    @PostMapping("/uploadResume")
    public String uploadResume(@RequestParam("file") MultipartFile file, Model model) throws Exception {

        File dir = new File("uploads");
        if(!dir.exists()) dir.mkdir();

        String path = "uploads/" + file.getOriginalFilename();

        file.transferTo(new File(path));

        String text = pdfService.extractText(path);

        String feedback = aiService.getFeedback(text);

        model.addAttribute("feedback", feedback);

        return "result";
    }
}
