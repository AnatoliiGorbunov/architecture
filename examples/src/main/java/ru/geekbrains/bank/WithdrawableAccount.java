package ru.geekbrains.bank;

public abstract class WithdrawableAccount extends Account {

    public void withdraw(int value){
        this.value -= value;
    }
}
