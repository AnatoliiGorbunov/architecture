package ru.geekbrains.bank;

public class FixedTermAccount extends WithdrawableAccount{

    @Override
    public void withdraw(int value) {
       throw new IllegalStateException("Can't withdraw money from this accoutn");
    }
}
