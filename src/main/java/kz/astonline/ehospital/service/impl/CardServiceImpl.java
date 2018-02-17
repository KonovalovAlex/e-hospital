package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.repository.CardRepository;
import kz.astonline.ehospital.repository.RoleRepository;
import kz.astonline.ehospital.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private Card card = new Card();

    @Autowired
    private CardRepository cardRepository;

    private String string;

    public void initCard(Patient patient) {
        patient.setInClinic(true);
        patient.setPlace("зарегестрирован в "+ LocalDateTime.now().toString()+ " и находится в очереди к терапевту - "+patient.getTherapist());
        Card card = new Card();
        card.setActive(true);
        card.setPatient(patient);
        saveOrUpdate(card);
    }

    @Override
    public Card saveOrUpdate(Card entity) {
        return cardRepository.save(entity);
    }

    @Override
    public Card findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Card> findAll() {
        return null;
    }

    public CardServiceImpl() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }

    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
