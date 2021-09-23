package com.paymentSystem.paymentsystem.models;

import javax.persistence.*;

import java.io.Serializable;

import com.paymentSystem.paymentsystem.repo.Auditable;

@Entity
public class Transactions extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @OneToOne(mappedBy = "transactionId")
    // private Customer idUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customerId;

    @Column
    private long amount;

    @Column
    private String currency;

    @Column
    private String txRef;

    @Column
    private String network;

    @Column
    private String paymentOptoin;

    @Column
    private String description;

    // public Customer getIdUser() {
    // return idUser;
    // }

    // public void setIdUser(Customer idUser) {
    // this.idUser = idUser;
    // }

    public Customer customerId() {
        return customerId;
    }

    public void setCusotmerId(Customer newCustomerId) {
        this.customerId = newCustomerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTxRef() {
        return txRef;
    }

    public void setId(String txRef) {
        this.txRef = txRef;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getPaymentOption() {
        return paymentOptoin;
    }

    public void setPaymenetOption(String paymentOption) {
        this.paymentOptoin = paymentOption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
