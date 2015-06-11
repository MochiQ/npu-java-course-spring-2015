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
/**
 * 存放數字
 * @param digit 傳入的數字
 */
    public void appendDigit(int digit) {

        mOperand = String.valueOf(digit);

        if (operator.equals("")) {
            total = digit;
        }
    }
/**
 * 存放 點 號
 */
    public void appendDot() {
       // dot=true;
        //operand +=".";

    }
/**
 * 改變運算符號
 * @param operator 傳入運算符號之字串
 */
    public void performOperation(String operator) {
        this.operator = operator;

    }
/**
 * 顯示畫面
 * @return 傳回畫面值
 */
    public String getDisplay() {
        return String.valueOf(total);
    }

    Calculator() {
        reset();
    }
/**
 * 
 * @param c 
 */
    public void addTotalListener(CalculatorView c) {
        totalListeners.add(c);
    }
/**
 * 
 */
    public void notifyTotalListeners() {
        for (int i = 0; i < totalListeners.size(); i++) {
            totalListeners.get(i).updateTotal(String.valueOf(total));
        }
    }
/**
 * 重設值
 */
    public void reset() {
        total = 0;
        notifyTotalListeners();
        this.operator = "";
        this.mOperand = "";

    }

   /**
    * 選擇運算方式
    */
    public void equal() {
        switch (operator) {
            case "＋":
                total += Integer.valueOf(mOperand);
                break;
            case "＊":
                total *= Integer.valueOf(mOperand);
                break;
            case "－":
                total -= Integer.valueOf(mOperand);
                break;
            case "／":
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
