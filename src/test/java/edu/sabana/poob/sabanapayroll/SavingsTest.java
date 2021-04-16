package edu.sabana.poob.sabanapayroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsTest {

    @Test
    public void shouldGetDepositDiscount() {
        Savings account = new Savings();

        assertTrue(Double.compare(2000, account.getDepositDiscount()) == 0);
    }
    @Test
    public void shouldDepositAmount() {
        Savings account = new Savings();
        boolean result = account.deposit(4000);

        assertTrue(result);
        assertTrue(Double.compare(2000, account.getBalance()) == 0);
    }

    @Test
    public void shouldNotDepositAmount() {
        Savings account = new Savings();

        assertFalse(account.deposit(1000));
        assertFalse(account.deposit(2000));
        assertTrue(Double.compare(0, account.getBalance()) == 0);
    }


    @Test
    public void shouldKeepBalance() {
        Savings account = new Savings();

        assertFalse(account.deposit(2000));
        assertTrue(account.deposit(45000)); //43000
        assertTrue(account.deposit(5000)); // 3000
        assertFalse(account.deposit(1500));


        assertTrue(Double.compare(46000, account.getBalance()) == 0);
    }
    @Test
    public void shouldGetMonthlyInterestDeposit() {
        Savings account = new Savings();
        account.deposit(15000); //13000
        assertTrue(Double.compare(account.depositMontlyInterest(),13130) == 0);

    }
}
