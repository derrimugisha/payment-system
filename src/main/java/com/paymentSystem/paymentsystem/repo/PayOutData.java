package com.paymentSystem.paymentsystem.repo;

public class PayOutData {
    private String account_bank;
    private Long account_number;
    private String amount;
    private String narration;
    private String currency;
    private String reference;
    private String beneficiary_name;

    public String getAccountBank() {
        return account_bank;
    }

    public void setAccountBank(String accountBank) {
        this.account_bank = accountBank;
    }

    public Long getAccountNumber() {
        return account_number;
    }

    public void setAccountNumber(Long accountNumber) {
        this.account_number = accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReference() {
        return reference;
    }

    public void setreference(String reference) {
        this.reference = reference;
    }

    public String getBeneficiaryName() {
        return beneficiary_name;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiary_name = beneficiaryName;
    }
}
