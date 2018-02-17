package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.model.Analysis;
import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.repository.AnalysisRepository;
import kz.astonline.ehospital.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private AnalysisRepository analysisRepository;

    @Override
    public Analysis saveOrUpdate(Analysis entity) {
        return analysisRepository.save(entity);
    }



    @Override
    public Analysis findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Analysis> findAll() {
        return null;
    }
}
