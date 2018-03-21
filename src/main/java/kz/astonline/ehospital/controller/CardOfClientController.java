package kz.astonline.ehospital.controller;

import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.service.CardService;
import kz.astonline.ehospital.service.PatientService;
import kz.astonline.ehospital.spring.scope.SpringViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringViewScoped
@Controller
public class CardOfClientController {
    private Card card = new Card();
    private Patient patient = new Patient();
    private List<Card> cards = new LinkedList<>();
    @Autowired
    private CardService cardService;
    @Autowired
    private PatientService patientService;
    private List<Patient> patientList = new ArrayList<>();

    @PostConstruct
    private void init() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String patientId = request.getParameter("patientId");
        //THIS is choosed patient
        if (patientId != null) {
            this.patient = patientService.findById(Long.parseLong(patientId));
            cards.addAll(cardService.getCardsByIdPatient(patient.getId(), true));
            this.card = cards.get(0);
        }
    }
    public void closeCard() {
        card.setActive(false);
        cardService.saveOrUpdate(card);
        addMessage("Карта была закрыта",
                "Чтобы открыть карту обратитесь к администратору");
    }
    public void saveChanges(){
        cardService.saveOrUpdate(card);
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void editCard() {
        card.setEditable(true);
    }

    //    public void acceptPatient(long id) {
//        cards.clear();
//        List<Patient> patients = new LinkedList<>(patientController.getPatients());
//        for (Patient patient : patients) {
//            if (patient.getId() == id) {
//                this.patient = patient;
//                break;
//            }
//        }
//        cards.addAll(cardService.getCardsByIdPatient(id));
//
//    }
    public Card getMedicineCard(Patient patient) {
//        if(patient.getCard().isEmpty())
        return patient.getCard().get(0);
    }

    public List<Patient> findPatient() {
        setPatientList(patientService.findPatientByFullName(patient.getName(), patient.getSurName()));
        editCard();
        return patientList;
    }

    public CardOfClientController() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public CardService getCardService() {
        return cardService;
    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}




