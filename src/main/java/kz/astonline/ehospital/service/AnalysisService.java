package kz.astonline.ehospital.service;

import kz.astonline.ehospital.model.Analysis;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.base.BaseService;

public interface AnalysisService extends BaseService <Analysis,Long> {

    Analysis initAnalysis(Patient patient);
}
