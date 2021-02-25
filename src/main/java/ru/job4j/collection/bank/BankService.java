package ru.job4j.collection.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<AccountSecond> accountList = users.get(user.get());
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
    /*public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User us : users.keySet()) {
            if (us.getPassport().equals(passport)) {
                rsl = Optional.of(us);
                break;
            }
        }
        return rsl;
    }*/
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
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
    public Optional<AccountSecond> findByRequisite(String passport, String requisite) {
        Optional<User> us = findByPassport(passport);
        return us.flatMap(user -> users.get(user)
                .stream()
                .filter(ac -> ac.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<AccountSecond> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<AccountSecond> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSrc.isPresent() && accountDest.isPresent()
                && accountSrc.get().getBalance() >= amount) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> opt = bank.findByPassport("321");
        opt.ifPresent(user -> System.out.println(user.getUsername()));
        /*List<AccountSecond> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new AccountSecond("3fdsbb9", 140));
        int index = accounts.indexOf(new AccountSecond(requisite, -1));
        AccountSecond find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());*/
    }
}



