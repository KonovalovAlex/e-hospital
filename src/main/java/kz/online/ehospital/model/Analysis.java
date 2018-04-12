package kz.online.ehospital.model;

import kz.online.ehospital.model.base.BaseEntity;
import kz.online.ehospital.model.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ANALYZES")
public class Analysis extends BaseEntity implements Serializable {

    @Column
    private String record;
    @Column
    private String treatment;
    @Column
    private int numberOfBlood;
    @Column
    private String rhesusFactor;
    @Column
    private String author;
    @Column
    private boolean result;
    @Column
    private String pills;
    @Column
    private int quantityDays;
    @Column
    private int quantityTimes;
    @Column
    private int numberOfCabinet;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cards_id", referencedColumnName = "id")
    private Card card;

    public int getNumberOfCabinet() {
        return numberOfCabinet;
    }

    public void setNumberOfCabinet(int numberOfCabinet) {
        this.numberOfCabinet = numberOfCabinet;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getPills() {
        return pills;
    }

    public void setPills(String pills) {
        this.pills = pills;
    }

    public int getQuantityDays() {
        return quantityDays;
    }

    public void setQuantityDays(int quantityDays) {
        this.quantityDays = quantityDays;
    }

    public int getQuantityTimes() {
        return quantityTimes;
    }

    public void setQuantityTimes(int quantityTimes) {
        this.quantityTimes = quantityTimes;
    }

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
