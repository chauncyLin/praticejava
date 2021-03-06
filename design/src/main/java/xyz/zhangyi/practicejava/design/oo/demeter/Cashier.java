package xyz.zhangyi.practicejava.design.oo.demeter;

public class Cashier {
    public void charge(Customer myCustomer, float payment) {
        Wallet theWallet = myCustomer.getWallet();
        if (theWallet.getTotalMoney() > payment) {
            theWallet.subtractMoney(payment);
        } else {
            throw new NotEnoughMoneyException("Money is not enough", new Exception());
        }
    }
}
