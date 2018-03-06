package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.model.Patient;
import kz.astonline.ehospital.repository.CardRepository;
import kz.astonline.ehospital.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
    public List<Card> getCardsByIdPatinet(long id) {
        return cardRepository.findCardsByIdPatient(id);
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
