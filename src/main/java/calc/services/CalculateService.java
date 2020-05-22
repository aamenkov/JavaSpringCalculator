package calc.services;

import calc.model.DataArray;
import calc.model.Input;
import calc.model.Output;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CalculateService {

    public String annuatePayment(String inputJson){
        Gson gson = new Gson();
        Output output = new Output();
        Input inputObj = new Input();

        inputObj = gson.fromJson(inputJson, Input.class);

        output = check(inputObj);

        try {
            if (output.isSuccess() != false) {
                output = calculatePayment(inputObj);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            output.setSuccess(false);
            output.setMessage("Error. Incorrect input format data.");
        }

        String outputJson = gson.toJson(output);

        return outputJson;
    }

    private Output calculatePayment(Input input) throws ParseException {
        double kof;                                                             // kof annuitetnogo platezha
        double i = (input.getRate() / 12);                                    // procentnaya stavka v mesyac
        BigDecimal kof1, payment, interest, debtRest, debt;

        kof = (i * Math.pow((1+i), input.getTerm()))/(Math.pow((1+i), input.getTerm()) - 1);
        kof1 = BigDecimal.valueOf(kof);
        payment = kof1.multiply(BigDecimal.valueOf(input.getAmount()));
        debtRest = BigDecimal.valueOf(input.getAmount());

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(df.parse(input.getDate()).getTime());

        ArrayList<DataArray> data = new ArrayList<>();
        for (int k=1; k<=input.getTerm(); k++) {

            DataArray object = new DataArray();

            date.setMonth(date.getMonth() + 1);

            interest = debtRest.multiply(BigDecimal.valueOf(i));
            debt = payment.subtract(interest);
            debtRest = debtRest.subtract(debt);

            object.setNum(k);
            object.setDate(df.format(date));
            object.setDebt(debt.setScale(2, BigDecimal.ROUND_UP));
            object.setDebtRest(debtRest.setScale(2, BigDecimal.ROUND_DOWN));
            object.setInterest(interest.setScale(2, BigDecimal.ROUND_UP));
            object.setPayment(payment.setScale(2, BigDecimal.ROUND_UP));
            data.add(object);
        }
        return new Output(true,null,data);
    }

    private Output check(Input input){

        Output checkOutput = new Output();

        if (input.getAmount() <= 0) {
            checkOutput.setSuccess(false);
            checkOutput.setMessage("Amount <= 0. Insert correct amount.");
        } else  if (input.getTerm() <= 0) {
            checkOutput.setSuccess(false);
            checkOutput.setMessage("Term <= 0. Insert correct term.");
        } else if (input.getRate() <= 0) {
            checkOutput.setSuccess(false);
            checkOutput.setMessage("Rate <= 0. Insert correct rate.");
        }
        return checkOutput;
    }

}
