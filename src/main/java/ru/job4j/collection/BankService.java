package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class BankService {
    private Map<User, List<AccountSecond>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<AccountSecond>());
    }

    public void addAccount(String passport, AccountSecond account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<AccountSecond> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User us : users.keySet()) {
            if (us.getPassport().equals(passport)) {
                rsl = us;
                break;
            }
        }
        return rsl;
    }

    public AccountSecond findByRequisite(String passport, String requisite) {
        AccountSecond rsl = null;
        User us = findByPassport(passport);
        if (us != null) {
            List<AccountSecond> acList = users.get(us);
            for (AccountSecond account : acList) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        AccountSecond accountSrc = findByRequisite(srcPassport, srcRequisite);
        AccountSecond accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc != null && accountDest != null && accountSrc.getBalance() >= amount) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<AccountSecond> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new AccountSecond("3fdsbb9", 140));
        int index = accounts.indexOf(new AccountSecond(requisite, -1));
        AccountSecond find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}



