package com.paymentSystem.paymentsystem.repo;

public class VerifyData {
    private Model data;

    public Model getModel() {
        return data;
    }

    public void setData(Model data) {
        this.data = data;
    }

    static class Model {
        private String status;
        private Long amount;
        private String currency;
        private String tx_ref;
        private String network;
        private String paymentType;
        private String description;
        private String fullName;
        private String email;
        private String phoneNumber;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getTxRef() {
            return tx_ref;
        }

        public void setTxRef(String txRef) {
            this.tx_ref = txRef;
        }

        public String getnetwork() {
            return network;
        }

        public void setnetwork(String network) {
            this.network = network;
        }

        public String getPaymentOption() {
            return paymentType;
        }

        public void setPaymentOption(String paymentOption) {
            this.paymentType = paymentOption;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
