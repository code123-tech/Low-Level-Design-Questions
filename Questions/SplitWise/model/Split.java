package model;

public class Split {

    User user;
    double amountOwe;
    int percentage;

    public Split(User user, double amountOwe){
        this.user = user;
        this.amountOwe = amountOwe;
    }

    public Split(User user, double amountOwe, int percentage){
        this.user = user;
        this.amountOwe = amountOwe;
        this.percentage = percentage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

}
