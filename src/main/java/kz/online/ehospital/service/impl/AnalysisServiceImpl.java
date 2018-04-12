package kz.online.ehospital.service.impl;

import kz.online.ehospital.model.Analysis;
import kz.online.ehospital.model.Card;
import kz.online.ehospital.model.Patient;
import kz.online.ehospital.repository.AnalysisRepository;
import kz.online.ehospital.service.AnalysisService;
import kz.online.ehospital.repository.AnalysisRepository;
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
