package com.example.dbtest.controllers;

import com.example.dbtest.models.VisitEntity;
import com.example.dbtest.models.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    final VisitRepository visitRepository;


    @Autowired
    public MainController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping("/")
    public String visit(Model model,
                        HttpServletRequest request){
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setIp(request.getRemoteHost());
        visitEntity.setCounter(123); //zbedny

        visitRepository.save(visitEntity);

        model.addAttribute("counter", visitRepository.count());
        return "index";
    }

}
