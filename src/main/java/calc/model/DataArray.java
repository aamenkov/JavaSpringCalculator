package calc.model;

import java.math.BigDecimal;

public class DataArray {

    private int num;
    private String date;
    private BigDecimal interest;
    private BigDecimal debt;
    private BigDecimal payment;
    private BigDecimal debtRest;

    public DataArray() {
    }

    public DataArray(int num, String date, BigDecimal interest, BigDecimal debt, BigDecimal payment, BigDecimal debtRest) {
        this.num = num;
        this.date = date;
        this.interest = interest;
        this.debt = debt;
        this.payment = payment;
        this.debtRest = debtRest;
    }

    @Override
    public String toString() {
        return  "\n            {" + "\n" +
                "               'num' = " + num + ",\n" +
                "               'date' = " + date + ",\n" +
                "               'interest' = " + interest + ",\n" +
                "               'debt' = " + debt + ",\n" +
                "               'payment' = " + payment + ",\n" +
                "               'debtRest' = " + debtRest + ",\n" +
                "            }" ;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getDebtRest() {
        return debtRest;
    }

    public void setDebtRest(BigDecimal debtRest) {
        this.debtRest = debtRest;
    }
}
