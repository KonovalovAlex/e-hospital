package kz.astonline.ehospital.service.impl;

import kz.astonline.ehospital.model.Card;
import kz.astonline.ehospital.repository.CardRepository;
import kz.astonline.ehospital.repository.RoleRepository;
import kz.astonline.ehospital.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;


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
}
