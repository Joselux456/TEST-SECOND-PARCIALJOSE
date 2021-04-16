package edu.sabana.poob.sabanapayroll;

import java.time.LocalDate;

public class Checking extends BankAccount {

    public static final double DEPOSIT_DISCOUNT = 5000;

    @Override
    public double getDepositDiscount() {
        return DEPOSIT_DISCOUNT;
    }

    @Override
    public boolean deposit(double amount) {
        boolean result = false;
        if(amount > getDepositDiscount()) {
            result = true;
            amount = amount - DEPOSIT_DISCOUNT;
            try {
                super.setBalance(getBalance() + amount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Verifica si el cheque es válido
     * <br><br>
     * @param check el cheque a aplicar.
     * @return Si el cheque es válido.
     */
    public boolean processCheck(Check check){
        boolean result = false;
        if(check.getExpirationDate().isAfter(LocalDate.now()))
            result = true;
        if(result)
            result = this.deposit(check.getAmount());
        return result;
    }

}
