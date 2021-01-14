package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;

    private boolean avaliable = true;
    private boolean onlyUpdate;

    public Enrollment() {
    }

    public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean avaliable, boolean onlyUpdate) {
        id.setUser(user);
        id.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.avaliable = avaliable;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent(){
        return id.getUser();
    }

    public void setStudent(User student){
        id.setUser(student);
    }

    public  Offer getOffer(){
        return id.getOffer();
    }

    public void setOffer(Offer offer){
        id.setOffer(offer);
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public Instant getRefoundMoment() {
        return refundMoment;
    }

    public void setRefoundMoment(Instant refundMoment) {
        this.refundMoment = refundMoment;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public boolean isOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }
}
