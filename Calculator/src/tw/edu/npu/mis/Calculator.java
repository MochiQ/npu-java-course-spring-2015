/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * The model class of the calculator application.
 */
public class Calculator {

    private boolean dot = false;
    private double total = 0;//顯示
    //運算符號，數字
    private String operator = "", mOperand;
    private ArrayList<CalculatorView> totalListeners = new ArrayList<CalculatorView>();

    /**
     * The available operators of the calculator.
     */
    public enum Operator {

        CLEAR, // C
        CLEAR_ENTRY, // CE
        BACKSPACE, // ⌫
        EQUAL, // =
        PLUS, // +
        MINUS, // -
        TIMES, // ×
        OVER, // ⁄
        PLUS_MINUS, // ±
        RECIPROCAL, // 1/x
        PERCENT, // %
        SQRT, // √
        MEM_CLEAR, // MC
        MEM_SET, // MS
        MEM_PLUS, // M+
        MEM_MINUS, // M-
        MEM_RECALL   // MR
    }

    public void appendDigit(int digit) {

        mOperand = String.valueOf(digit);

        if (operator.equals("")) {
            total = digit;
        }
    }

    public void appendDot() {
       // dot=true;
        //operand +=".";

    }

    public void performOperation(String operator) {
        this.operator = operator;

    }

    public String getDisplay() {
        return String.valueOf(total);
    }

    Calculator() {
        reset();
    }

    public void addTotalListener(CalculatorView c) {
        totalListeners.add(c);
    }

    public void notifyTotalListeners() {
        for (int i = 0; i < totalListeners.size(); i++) {
            totalListeners.get(i).updateTotal(String.valueOf(total));
        }
    }

    public void reset() {
        total = 0;
        notifyTotalListeners();
        this.operator = "";
        this.mOperand = "";

    }

    //=
    public void equal() {
        switch (operator) {
            case "+":
                total += Integer.valueOf(mOperand);
                break;
            case "*":
                total *= Integer.valueOf(mOperand);
                break;
            case "-":
                total -= Integer.valueOf(mOperand);
                break;
            case "/":
                total /= Integer.valueOf(mOperand);
                break;
            case "√":
                total = Math.sqrt(total);
                break;
            case "1/x":
                total = 1 / total;
                break;
            case "±":
                total = -total;
                break;
        }
        notifyTotalListeners();
    }

}
