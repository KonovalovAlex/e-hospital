package kz.astonline.ehospital.service;

import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.base.BaseService;

public interface CardService extends BaseService<Card,Long> {
    void initCard(Patient patient);
}
