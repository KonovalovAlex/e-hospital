package kz.astonline.ehospital.model;

import kz.astonline.ehospital.model.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "ANALYZES")
public class Analysis extends BaseEntity implements Serializable {

    @Column
    private String record;
    @Column
    private int numberOfBlood;
    @Column
    private String rhesusFactor;
    @Column
    private String author;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER) @JoinColumn (name = "cards_id",referencedColumnName = "id")
    private Card card;


    public Analysis() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public int getNumberOfBlood() {
        return numberOfBlood;
    }

    public void setNumberOfBlood(int numberOfbood) {
        this.numberOfBlood = numberOfbood;
    }

    public String getRhesusFactor() {
        return rhesusFactor;
    }

    public void setRhesusFactor(String rhesusFactor) {
        this.rhesusFactor = rhesusFactor;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
