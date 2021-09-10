package Model.Account;

import Model.Monster.MonsterTypes.Monster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable, Comparable<Account>{
    private String username, password;
    private int balance;
    private List<Monster> monsterList;
    private final int initialBalance = 1000;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
        this.monsterList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", monsterList=" + monsterList +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        return o.getBalance() - this.balance;
    }
}
