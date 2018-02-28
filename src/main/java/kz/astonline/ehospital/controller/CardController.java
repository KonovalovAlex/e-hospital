package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.CardService;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.service.impl.CardServiceImpl;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;


@Controller
@SpringViewScoped
public class CardController implements Serializable {

    private Card card = new Card();
    private Patient patient = new Patient();
    @Autowired
    private CardService cardService;
    @Autowired
    private PatientService patientService;
    private List<Patient> patientList = new ArrayList<>();

    public void editCard() {
        card.setEditable(true);
    }

    public void saveChangesInCard() {
        patient = patientList.get(0);
        patientService.saveOrUpdate(this.patient);
        patientList.clear();
        this.card = new Card();
        this.patient = new Patient();
    }

    //TODO сделать проверку
    public Card getMedicineCard(Patient patient) {
//        if(patient.getCard().isEmpty())
        return patient.getCard().get(0);
    }

    public List<Patient> findPatient() {
        setPatientList(patientService.findPatientByFullName(patient.getName(), patient.getSurName()));
        editCard();
        return patientList;
    }

    public void addRecord() {
        String newRecord = card.getRecord() + ("");
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public CardController() {
    }

    public Card getCard() {
        return card;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CardService getCardService() {
        return cardService;
    }

    public void setCardService(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

}
