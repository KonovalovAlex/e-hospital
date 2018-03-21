package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.model.Analysis;
import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.service.AnalysisService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
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
