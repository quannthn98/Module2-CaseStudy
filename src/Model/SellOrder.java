package Model;

import Model.Account.Account;
import Model.Monster.MonsterTypes.Monster;

import java.io.Serializable;

public class SellOrder implements Serializable {
    private Monster monster;
    private Account seller;
    private int price;
    public static int count;
    private int id;
    private boolean status;

    public SellOrder(Monster monster, Account seller, int price) {
        id = ++count;
        this.monster = monster;
        this.seller = seller;
        this.price = price;
        this.status = true;
    }

    public Monster getMonster() {
        return monster;
    }

    public Account getSeller() {
        return seller;
    }

    public int getPrice() {
        return price;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sell Order: " +
                "id: " + id +
                ", price: " + price +
                ", seller: " + seller.getUsername() +
                ", monster: " + monster;
    }
}
