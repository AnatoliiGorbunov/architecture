package ru.geekbrains;

import ru.geekbrains.bank.Account;
import ru.geekbrains.bank.CurrentAccount;
import ru.geekbrains.bank.FixedTermAccount;
import ru.geekbrains.bank.WithdrawableAccount;

import java.util.List;

public class Main {
    public static void withdrawFromAllAccounts(List<WithdrawableAccount> accounts, int value){
        accounts.forEach(acc -> acc.withdraw(value));
    }

    public static void main(String[] args) {
        WithdrawableAccount account1 = new CurrentAccount();
        account1.deposit(100);
        Account account2 = new FixedTermAccount();
        account2.deposit(200);
        withdrawFromAllAccounts(List.of(account1),20);
    }
}
