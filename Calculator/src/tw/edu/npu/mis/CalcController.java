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

    CalcController(Calculator model) {
        this.model = model;
        view = new CalculatorView(model, this);

    }

    public void clear() {
        model.reset();
    }

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
