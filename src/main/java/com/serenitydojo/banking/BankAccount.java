package com.serenitydojo.banking;

public class BankAccount {

    private double balance;
    //private double interestRate; For SavingsAccount
    //private double overdraft; For CurrentAccount

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
