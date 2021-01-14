package com.devsuperior.dslearnbds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tb_task")
public class Task extends Lesson {
    private static final long serialVersionUID = -1363805642581153365L;

    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double wight;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant doDate;

    public Task() {
    }

    public Task(Long id, String title, Integer position, Section section, String description, Integer questionCount, Integer approvalCount, Double wight, Instant doDate) {
        super(id, title, position, section);
        this.description = description;
        this.questionCount = questionCount;
        this.approvalCount = approvalCount;
        this.wight = wight;
        this.doDate = doDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Integer getApprovalCount() {
        return approvalCount;
    }

    public void setApprovalCount(Integer approvalCount) {
        this.approvalCount = approvalCount;
    }

    public Double getWight() {
        return wight;
    }

    public void setWight(Double wight) {
        this.wight = wight;
    }

    public Instant getDoDate() {
        return doDate;
    }

    public void setDoDate(Instant doDate) {
        this.doDate = doDate;
    }
}
