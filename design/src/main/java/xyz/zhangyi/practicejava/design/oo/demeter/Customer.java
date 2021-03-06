package xyz.zhangyi.practicejava.design.oo.demeter;

public class Customer {
    private String firstName;
    private String lastName;
    private Wallet myWallet;

    public Customer(Wallet wallet) {
        this.myWallet = wallet;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Wallet getWallet(){
        return myWallet;
    }
}
