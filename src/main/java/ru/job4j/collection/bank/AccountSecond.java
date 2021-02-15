package ru.job4j.collection.bank;
import java.util.Objects;

/**
 * Класс реализует шаблон банковского счета, для банковского приложения.
 *  * В нем содержатся поля реквизиты и сумма баланса, которые характеризуют счет пользователя.
 *  * А также методы get и set для доступа к полям.
 */
public class AccountSecond {
    private String requisite;
    private double balance;

    public AccountSecond(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountSecond account = (AccountSecond) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
