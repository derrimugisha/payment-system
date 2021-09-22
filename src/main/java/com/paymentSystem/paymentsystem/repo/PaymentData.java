package com.paymentSystem.paymentsystem.repo;

public class PaymentData {
    private long amount;
    private String currency;
    private long phoneNumber;
    private String description;
    private String email;
    private String fullName;
    private String network;
    private String tx_ref;
    private String payment_options;
    private String redirect_url;

    public String getPaymentOption() {
        return payment_options;
    }

    public String getRedirectUrl() {
        return redirect_url;
    }

    public void setRedirectUrl(String newRedirectUrl) {
        this.redirect_url = newRedirectUrl;
    }

    public void setPaymentOption(String newPaymentOption) {
        this.payment_options = newPaymentOption;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String newFullName) {
        this.fullName = newFullName;
    }

    public String getNework() {
        return network;
    }

    public void setNetwork(String newNetwork) {
        this.network = newNetwork;
    }

    public String getTxRef() {
        return tx_ref;
    }

    public void setTxRef(String newTxRef) {
        this.tx_ref = newTxRef;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long newAmount) {
        this.amount = newAmount;
    }

    public String getCurrence() {
        return currency;
    }

    public void setCurrence(String newCurrence) {
        this.currency = newCurrence;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
}
