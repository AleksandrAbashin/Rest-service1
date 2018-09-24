package com.task.storage.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client_contact")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long contactId;
    private String name;

   @OneToMany(mappedBy = "contact",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    protected List<Application> applications;

    public Client() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contact_id) {
        this.contactId = contact_id;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void setOrders(boolean add) {
    }
}
