/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import javax.swing.JButton;

/**
 *
 * @author user
 */
public class CalcController {

    private Calculator model;
    private CalculatorView view;
/**
 * 帶入model,view
 * @param model 帶入Calculator model
 */
    CalcController(Calculator model) {
        this.model = model;
        view = new CalculatorView(model, this);

    }
/**
 * 清除
 */
    public void clear() {
        model.reset();
    }
/**
 * 設定運算符號
 * @param operator 運算符號之字串
 */
    void setoperator(String operator) {
        model.performOperation(operator);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator model = new Calculator();
        CalcController controller = new CalcController(model);
        
        
    }
}
