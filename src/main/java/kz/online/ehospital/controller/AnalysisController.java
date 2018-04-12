package kz.online.ehospital.controller;

import kz.online.ehospital.model.Analysis;
import kz.online.ehospital.model.Card;
import kz.online.ehospital.service.AnalysisService;
import kz.online.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

@Controller
@SpringViewScoped
public class AnalysisController implements Serializable {
    @Autowired
    private AnalysisService analysisService;
    private Analysis analysis = new Analysis();
    private Card card = new Card();

    public void createAnalysis(){

        analysisService.saveOrUpdate(analysis);
    }
}
