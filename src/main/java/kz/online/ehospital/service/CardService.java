package kz.online.ehospital.service;

import kz. online.ehospital.model.Card;
import kz. online.ehospital.model.Patient;
import kz. online.ehospital.service.base.BaseService;
import kz.online.ehospital.service.base.BaseService;

import java.util.List;

public interface CardService extends BaseService<Card,Long> {
    void initCard(Patient patient);
    List<Card> getCardsByIdPatient(long id,boolean isActive);
}
