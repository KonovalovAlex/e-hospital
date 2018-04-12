package kz.online.ehospital.service.impl;

import kz.online.ehospital.model.Card;
import kz.online.ehospital.model.Patient;
import kz.online.ehospital.repository.CardRepository;
import kz.online.ehospital.service.CardService;
import kz.online.ehospital.model.Card;
import kz.online.ehospital.model.Patient;
import kz.online.ehospital.repository.CardRepository;
import kz.online.ehospital.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    private Card card = new Card();

    @Autowired
    private CardRepository cardRepository;

    public void initCard(Patient patient) {
        Card card = new Card();
        card.setActive(true);
        card.setPatient(patient);
        saveOrUpdate(card);
    }

    @Override
    public List<Card> getCardsByIdPatient(long id, boolean isActive) {
        return cardRepository.findCardByIdPatient(id,isActive);
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

}
