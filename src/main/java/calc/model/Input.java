package calc.model;

import java.text.ParseException;

public class Input {
    private String date;
    private double rate;
    private int term;
    private double amount;

    public Input() {
    }

    public Input(String date, double rate, int term, double amount) throws ParseException {
        this.rate= rate;
        this.term = term;
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
