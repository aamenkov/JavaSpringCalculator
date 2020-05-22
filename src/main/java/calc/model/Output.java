package calc.model;

import java.util.ArrayList;

public class Output {
    private boolean success = true;
    private String message;
    private ArrayList<DataArray> data;

    public Output() {
    }

    public Output(boolean success, String message, ArrayList<DataArray> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "   'success' = " + success + ",\n" +
                "   'message' = '" + message + '\'' + ",\n" +
                "   'data' = " + data + "\n" +
                "}";
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<DataArray> getData() {
        return data;
    }

    public void setData(ArrayList<DataArray> data) {
        this.data = data;
    }
}
