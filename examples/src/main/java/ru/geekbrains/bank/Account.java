package ru.geekbrains.bank;

public abstract class Account {

    protected int value;

    public void deposit(int value) {
        this.value += value;
    }


}
