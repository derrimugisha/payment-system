package com.paymentSystem.paymentsystem.models;

import javax.persistence.*;

import java.io.Serializable;

// import com.paymentSystem.paymentsystem.models.Transactions;
import com.paymentSystem.paymentsystem.repo.Auditable;

@Entity
public class Customer extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    // private Transactions transactionId;

    // @OneToOne(mappedBy = "customerId")
    // private Transactions idTransactions;

    @Column
    private String fullName;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String NewFullName) {
        this.fullName = NewFullName;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String newEmail) {
        this.email = newEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    // public Transactions transctionId() {
    // return transactionId;
    // }

    // public void setTransactionId(Transactions newTransactionId) {
    // this.transactionId = newTransactionId;
    // }

    // public Transactions getIdTransactions() {
    // return idTransactions;
    // }

    // public void setIdTransactions(Transactions idTransactions) {
    // this.idTransactions = idTransactions;
    // }

}
