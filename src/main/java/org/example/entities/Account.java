package org.example.entities;

public class Account  {

    public static double DEPOSIT_FEE_PERCENTAGE = 0.02;
    private Long id;
    private Double balance;

    public Account ( Long id, Double balance ) {
        this.id = id;
        this.balance = balance;
    }

    public Account () {
    }


    public Double getBalance () {
        return balance;
    }

    public void deposit (double amount){
        if (amount > 0) {

            amount -= amount * DEPOSIT_FEE_PERCENTAGE;
            balance += amount;

        }

    }
    public void withdraw (double amount){
        if (amount > balance) {
                throw new IllegalArgumentException();
        }
           balance -= amount;
    }

    public double fullWithdraw(){
        double aux  = balance;
        balance = 0.0;
        return aux;
    }


}
