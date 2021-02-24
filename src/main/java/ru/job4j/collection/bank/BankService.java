package ru.job4j.collection.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Класс описывает работу простейшего приложения для банка. Реализует 5 методов,
 * которые выполняют добавление пользователя, поиск клиента по паспорту, поиск счета по реквизитам,
 * добавление аккаунта, а также трансфер с одного счета на другой.
 *
 * @author Lana Sergeeva
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение информации о пользователе и его счетах осущетсвляется в коллекции типа HashMap,
     * где пользователь - ключ, а лист со счетами пользователя - значение.
     */
    private Map<User, List<AccountSecond>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя. В случае отстсутсвия такового в базе,добавляет его.
     *
     * @param user пользователь, которого добавляем.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить аккаунт , используя в параметрах значение passport,
     * для поиска пользователя через метод findByPassport, и аккаунт,
     * который мы проверяем на наличие у пользователя.
     *
     * @param passport, паспорт, по которому проходит поиск пользователя.
     * @param account,  счет,  который мы закрепляем за пользователем, если это еще не было сделано.
     */

    public void addAccount(String passport, AccountSecond account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<AccountSecond> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод на вход паспорт, по которому производится поиск пользователя.
     *
     * @param passport, по которому осуществляем поиск.
     * @return вовзращает найденного  пользователя, либо null, если тот не найден.
     */
    /*public User findByPassport(String passport) {
        User rsl = null;
        for (User us : users.keySet()) {
            if (us.getPassport().equals(passport)) {
                rsl = us;
                break;
            }
        }
        return rsl;
    }*/
    public User findByPassport(String passport) {
        return users.keySet().stream().filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает на вход пасспорт и реквизиты, по которым осуществляется поиск пользователя,
     * а затем поиск аккаунта по реквизитам.
     *
     * @param passport  используется для поиска пользователя методом findByPassport
     * @param requisite , реквизиты, по которым мы ищем счет пользователя.
     * @return возвращает счет пользователя, либо null, если не найден.
     */
    /*public AccountSecond findByRequisite(String passport, String requisite) {
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
    }*/
    public AccountSecond findByRequisite(String passport, String requisite) {
        User us = findByPassport(passport);
        if (us != null) {
            return users.get(us)
                    .stream()
                    .filter(ac -> ac.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт и реквизиты с двух счетов, а также сумму, которая будет
     * переводиться. Поиск аккаунта, осуществляется за счет метода findByRequisite
     *
     * @param srcPassport   пасспорт пользователя, со счета которого будет делаться перевод.
     * @param srcRequisite  реквизиты счета, с которого делается перевод.
     * @param destPassport  пасспорт пользователя, на счет которого будет делаться перевод.
     * @param destRequisite реквизиты, пользователя, на счет которого будет делаться перевод
     * @param amount        сумма перевода.
     * @return возвращает булевое значение true, при успешной операции и false,
     * если операция не прошла.
     */
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



