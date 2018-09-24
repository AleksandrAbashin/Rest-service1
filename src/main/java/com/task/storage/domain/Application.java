package com.task.storage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_appli")
public class Application {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_appli")
    private Long applicationId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "dt_appli")
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dtСreated = LocalDateTime.now();

    @ManyToOne()
    @JoinColumn(name = "contact_id")
    private Client contact;

    public Client getContact() {
        return contact;
    }

    public void setContact(Client contact) {
        this.contact = contact;
    }

    public Application() {
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDateTime getDtСreated() {
        return dtСreated;
    }

    public void setDtСreated(LocalDateTime dtСreated) {
        this.dtСreated = dtСreated;
    }
}
