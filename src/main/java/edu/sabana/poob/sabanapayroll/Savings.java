package edu.sabana.poob.sabanapayroll;

public class Savings extends BankAccount {
    public static final double DEPOSIT_DISCOUNT = 2000;
    public static final double ANNUAL_INTEREST_RATE = 0.01;

    @Override
    public double getDepositDiscount() {
        return DEPOSIT_DISCOUNT;
    }

    @Override
    public boolean deposit(double amount) {
        boolean result = false;
        if(amount > getDepositDiscount()) {
            amount = amount - getDepositDiscount();
            result = true;
            try {
                super.setBalance(getBalance()+amount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningún descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */
    public double depositMontlyInterest(){
        return getBalance()+(getBalance()*ANNUAL_INTEREST_RATE);
    }

}
