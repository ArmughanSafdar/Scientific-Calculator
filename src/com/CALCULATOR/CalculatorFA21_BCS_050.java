package com.CALCULATOR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFA21_BCS_050 implements ActionListener{

     JFrame frame;

     JTextField textField;

     JPanel panel;

     JButton[] num_Buttons = new JButton[10];
     JButton[] simple_func_Buttons = new JButton[9];
     JButton[] hexa_Buttons = new JButton[6];
     JButton[] trig_func_Buttons = new JButton[12];
     JButton[] hyp_func_Buttons = new JButton[12];
     JButton[] lerd_func_Buttons = new JButton[9];

     JButton b_add, b_sub, b_mul, b_div, b_rem;
     JButton b_clear, b_backspace, b_dot, b_equal;
     JButton b_A, b_B, b_C, b_D, b_E, b_F;
     JButton b_sin, b_cos, b_tan, b_cosec, b_sec, b_cot;
     JButton b_sin_inv, b_cos_inv, b_tan_inv, b_cosec_inv, b_sec_inv, b_cot_inv;
     JButton b_sinh, b_cosh, b_tanh, b_cosech, b_sech, b_coth;
     JButton b_sinh_inv, b_cosh_inv, b_tanh_inv, b_cosech_inv, b_sech_inv, b_coth_inv;
     JButton b_log, b_exp, b_rad, b_deg;
     JButton b_pow, b_fact, b_sq, b_cube, b_sqrt;

     JRadioButton decimal;
     JRadioButton octal;
     JRadioButton binary;
     JRadioButton hexadecimal;
     ButtonGroup num_type;

     JRadioButton int_type;
     JRadioButton float_type;
     JRadioButton double_type;
     JRadioButton long_type;
     ButtonGroup datatype;

     Font myFont = new Font("MV Boli", Font.BOLD, 20);

     double num1 = 0, num2 = 0, result = 0;
     char operator;
     int A = 10,B = 11,C = 12,D = 13,E = 14,F = 15;

     CalculatorFA21_BCS_050() {

         frame = new JFrame("Calculator");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(720, 730);
         frame.setLayout(null);
         frame.setResizable(false);
         frame.getContentPane().setBackground(new Color(20, 90, 80));

         textField = new JTextField();
         textField.setBounds(50, 25, 600, 50);
         textField.setFont(myFont);
         textField.setEditable(false);

         decimal = new JRadioButton("Decimal", true);
         decimal.setBounds(53, 110, 80, 30);
         decimal.setFocusable(false);
         decimal.addActionListener(this);
         decimal.setActionCommand("DEC");

         octal = new JRadioButton("Octal");
         octal.setBounds(203, 110, 60, 30);
         octal.setFocusable(false);
         octal.addActionListener(this);
         octal.setActionCommand("OCT");

         binary = new JRadioButton("Binary");
         binary.setBounds(353, 110, 70, 30);
         binary.setFocusable(false);
         binary.addActionListener(this);
         binary.setActionCommand("BIN");

         hexadecimal = new JRadioButton("Hexadecimal");
         hexadecimal.setBounds(503, 110, 110, 30);
         hexadecimal.setFocusable(false);
         hexadecimal.addActionListener(this);
         hexadecimal.setActionCommand("HEX");

         num_type = new ButtonGroup();
         num_type.add(decimal);
         num_type.add(octal);
         num_type.add(binary);
         num_type.add(hexadecimal);

         int_type = new JRadioButton("Integer", true);
         int_type.setBounds(53, 160, 80, 30);
         int_type.setFocusable(false);
         int_type.addActionListener(this);
         int_type.setActionCommand("Integer");

         float_type = new JRadioButton("Float");
         float_type.setBounds(203, 160, 60, 30);
         float_type.setFocusable(false);
         float_type.addActionListener(this);
         float_type.setActionCommand("Float");

         double_type = new JRadioButton("Double");
         double_type.setBounds(353, 160, 70, 30);
         double_type.setFocusable(false);
         double_type.addActionListener(this);
         double_type.setActionCommand("Double");

         long_type = new JRadioButton("Long");
         long_type.setBounds(503, 160, 110, 30);
         long_type.setFocusable(false);
         long_type.addActionListener(this);
         long_type.setActionCommand("Long");

         datatype = new ButtonGroup();
         datatype.add(int_type);
         datatype.add(float_type);
         datatype.add(double_type);
         datatype.add(long_type);

         b_add = new JButton("+");
         b_sub = new JButton("-");
         b_mul = new JButton("*");
         b_div = new JButton("/");
         b_rem = new JButton("%");
         b_dot = new JButton(".");
         b_clear = new JButton("Clear");
         b_backspace = new JButton("Back");
         b_equal = new JButton("=");

         simple_func_Buttons[0] = b_dot;
         simple_func_Buttons[1] = b_mul;
         simple_func_Buttons[2] = b_div;
         simple_func_Buttons[3] = b_rem;
         simple_func_Buttons[4] = b_sub;
         simple_func_Buttons[5] = b_add;
         simple_func_Buttons[6] = b_clear;
         simple_func_Buttons[7] = b_backspace;
         simple_func_Buttons[8] = b_equal;

         for (int i = 0; i < 9; i++) {
             simple_func_Buttons[i].addActionListener(this);
             simple_func_Buttons[i].setFont(myFont);
             simple_func_Buttons[i].setFocusable(false);
         }

         for (int i = 0; i < 10; i++) {
             num_Buttons[i] = new JButton(String.valueOf(i));
             num_Buttons[i].addActionListener(this);
             num_Buttons[i].setFont(myFont);
             num_Buttons[i].setFocusable(false);
         }

         b_A = new JButton("A");
         b_B = new JButton("B");
         b_C = new JButton("C");
         b_D = new JButton("D");
         b_E = new JButton("E");
         b_F = new JButton("F");

         hexa_Buttons[0] = b_A;
         hexa_Buttons[1] = b_B;
         hexa_Buttons[2] = b_C;
         hexa_Buttons[3] = b_D;
         hexa_Buttons[4] = b_E;
         hexa_Buttons[5] = b_F;

         for (int i = 0; i < 6; i++) {
             hexa_Buttons[i].addActionListener(this);
             hexa_Buttons[i].setFont(myFont);
             hexa_Buttons[i].setFocusable(false);
         }

         b_sin = new JButton("sin()");
         b_cos = new JButton("cos()");
         b_tan = new JButton("tan()");
         b_cosec = new JButton("csc()");
         b_sec = new JButton("sec()");
         b_cot = new JButton("cot()");
         b_sin_inv = new JButton("sinI()");
         b_cos_inv = new JButton("cosI()");
         b_tan_inv = new JButton("tanI()");
         b_cosec_inv = new JButton("cscI()");
         b_sec_inv = new JButton("secI()");
         b_cot_inv = new JButton("cotI()");

         trig_func_Buttons[0] = b_sin;
         trig_func_Buttons[1] = b_cos;
         trig_func_Buttons[2] = b_tan;
         trig_func_Buttons[3] = b_cosec;
         trig_func_Buttons[4] = b_sec;
         trig_func_Buttons[5] = b_cot;
         trig_func_Buttons[6] = b_sin_inv;
         trig_func_Buttons[7] = b_cos_inv;
         trig_func_Buttons[8] = b_tan_inv;
         trig_func_Buttons[9] = b_cosec_inv;
         trig_func_Buttons[10] = b_sec_inv;
         trig_func_Buttons[11] = b_cot_inv;

         for (int i = 0; i < 12; i++) {
             trig_func_Buttons[i].addActionListener(this);
             trig_func_Buttons[i].setFont(myFont);
             trig_func_Buttons[i].setFocusable(false);
         }

         b_sinh = new JButton("sinh()");
         b_cosh = new JButton("cosh()");
         b_tanh = new JButton("tanh()");
         b_cosech = new JButton("csch()");
         b_sech = new JButton("sech()");
         b_coth = new JButton("coth()");
         b_sinh_inv = new JButton("sinhI()");
         b_cosh_inv = new JButton("coshI()");
         b_tanh_inv = new JButton("tanhI()");
         b_cosech_inv = new JButton("cschI()");
         b_sech_inv = new JButton("sechI()");
         b_coth_inv = new JButton("cothI()");

         hyp_func_Buttons[0] = b_sinh;
         hyp_func_Buttons[1] = b_cosh;
         hyp_func_Buttons[2] = b_tanh;
         hyp_func_Buttons[3] = b_cosech;
         hyp_func_Buttons[4] = b_sech;
         hyp_func_Buttons[5] = b_coth;
         hyp_func_Buttons[6] = b_sinh_inv;
         hyp_func_Buttons[7] = b_cosh_inv;
         hyp_func_Buttons[8] = b_tanh_inv;
         hyp_func_Buttons[9] = b_cosech_inv;
         hyp_func_Buttons[10] = b_sech_inv;
         hyp_func_Buttons[11] = b_coth_inv;

         for (int i = 0; i < 12; i++) {
             hyp_func_Buttons[i].addActionListener(this);
             hyp_func_Buttons[i].setFont(myFont);
             hyp_func_Buttons[i].setFocusable(false);
         }

         b_log = new JButton("log()");
         b_exp = new JButton("exp()");
         b_deg = new JButton("deg()");
         b_rad = new JButton("rad()");
         b_pow = new JButton("x^x");
         b_fact = new JButton("n!");
         b_sq = new JButton("x^2");
         b_sqrt = new JButton("sqrt");
         b_cube = new JButton("x^3");

         lerd_func_Buttons[0] = b_log;
         lerd_func_Buttons[1] = b_exp;
         lerd_func_Buttons[2] = b_deg;
         lerd_func_Buttons[3] = b_rad;
         lerd_func_Buttons[4] = b_pow;
         lerd_func_Buttons[5] = b_fact;
         lerd_func_Buttons[6] = b_sq;
         lerd_func_Buttons[7] = b_sqrt;
         lerd_func_Buttons[8] = b_cube;

         for (int i = 0; i < 9; i++) {
             lerd_func_Buttons[i].addActionListener(this);
             lerd_func_Buttons[i].setFont(myFont);
             lerd_func_Buttons[i].setFocusable(false);
         }

         b_backspace.setBounds(53, 630, 295, 50);
         b_clear.setBounds(353, 630, 295, 50);
         b_equal.setBounds(53, 575, 595, 50);

         panel = new JPanel();
         panel.setBounds(50, 210, 600, 340);
         panel.setLayout(new GridLayout(11, 5, 5, 5));
         panel.setBackground(new Color(20, 90, 80));
         panel.add(num_Buttons[1]);
         panel.add(num_Buttons[2]);
         panel.add(num_Buttons[3]);
         panel.add(hexa_Buttons[0]);
         panel.add(hexa_Buttons[1]);
         panel.add(num_Buttons[4]);
         panel.add(num_Buttons[5]);
         panel.add(num_Buttons[6]);
         panel.add(hexa_Buttons[2]);
         panel.add(hexa_Buttons[3]);
         panel.add(num_Buttons[7]);
         panel.add(num_Buttons[8]);
         panel.add(num_Buttons[9]);
         panel.add(hexa_Buttons[4]);
         panel.add(hexa_Buttons[5]);
         panel.add(b_sub);
         panel.add(num_Buttons[0]);
         panel.add(b_add);
         panel.add(trig_func_Buttons[0]);
         panel.add(trig_func_Buttons[1]);
         panel.add(b_rem);
         panel.add(b_mul);
         panel.add(b_div);
         panel.add(trig_func_Buttons[2]);
         panel.add(trig_func_Buttons[3]);
         panel.add(b_dot);
         panel.add(hyp_func_Buttons[0]);
         panel.add(hyp_func_Buttons[1]);
         panel.add(trig_func_Buttons[4]);
         panel.add(trig_func_Buttons[5]);
         panel.add(hyp_func_Buttons[2]);
         panel.add(hyp_func_Buttons[3]);
         panel.add(hyp_func_Buttons[4]);
         panel.add(trig_func_Buttons[6]);
         panel.add(trig_func_Buttons[7]);
         panel.add(hyp_func_Buttons[5]);
         panel.add(hyp_func_Buttons[6]);
         panel.add(hyp_func_Buttons[7]);
         panel.add(trig_func_Buttons[8]);
         panel.add(trig_func_Buttons[9]);
         panel.add(hyp_func_Buttons[8]);
         panel.add(hyp_func_Buttons[9]);
         panel.add(hyp_func_Buttons[10]);
         panel.add(trig_func_Buttons[10]);
         panel.add(trig_func_Buttons[11]);
         panel.add(hyp_func_Buttons[11]);
         panel.add(lerd_func_Buttons[0]);
         panel.add(lerd_func_Buttons[1]);
         panel.add(lerd_func_Buttons[2]);
         panel.add(lerd_func_Buttons[3]);
         panel.add(lerd_func_Buttons[4]);
         panel.add(lerd_func_Buttons[5]);
         panel.add(lerd_func_Buttons[6]);
         panel.add(lerd_func_Buttons[7]);
         panel.add(lerd_func_Buttons[8]);

         frame.add(textField);
         frame.add(decimal);
         frame.add(binary);
         frame.add(octal);
         frame.add(hexadecimal);
         frame.add(int_type);
         frame.add(float_type);
         frame.add(double_type);
         frame.add(long_type);
         frame.add(panel);
         frame.add(b_equal);
         frame.add(b_backspace);
         frame.add(b_clear);
         frame.setVisible(true);
     }

     public static void main(String[] args) {
         new CalculatorFA21_BCS_050();
     }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
             if (e.getSource() == num_Buttons[i]) {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == b_dot) {
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource() == b_add) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
            if (e.getSource() == b_sub) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
            if (e.getSource() == b_mul) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
            if (e.getSource() == b_div) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
            if (e.getSource() == b_rem) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
                textField.setText("");
            }
            if (e.getSource() == b_equal) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '%':
                        result = num1 % num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            }
            if (e.getSource() == b_clear) {
                textField.setText("");
            }
            if (e.getSource() == b_backspace) {
                String string = textField.getText();
                textField.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textField.setText(textField.getText() + string.charAt(i));
                }
            }

            if (e.getSource() == b_A) {
                textField.setText(textField.getText().concat("A"));
                textField.setText("" + A);
            }
            if (e.getSource() == b_B) {
                textField.setText(textField.getText().concat("B"));
                textField.setText("" + B);
            }
            if (e.getSource() == b_C) {
                textField.setText(textField.getText().concat("C"));
                textField.setText("" + C);
            }
            if (e.getSource() == b_D) {
                textField.setText(textField.getText().concat("D"));
                textField.setText("" + D);
            }
            if (e.getSource() == b_E) {
                textField.setText(textField.getText().concat("E"));
                textField.setText("" + E);
            }
            if (e.getSource() == b_F) {
                textField.setText(textField.getText().concat("F"));
                textField.setText("" + F);
            }

            if (e.getSource() == b_sq) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.pow(num1, 2);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sqrt) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sqrt(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cube) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.pow(num1, 3);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }

            if (num_type.getSelection().getActionCommand().equals("HEX")) {
                // DEC Number
                for (int i = 0; i < num_Buttons.length; i++) {
                    num_Buttons[i].setEnabled(true);
                }
                // HEX Number
                for (int i = 0; i < hexa_Buttons.length; i++) {
                    hexa_Buttons[i].setEnabled(true);
                }
                for (int i = 1; i < simple_func_Buttons.length; i++) {
                    simple_func_Buttons[0].setEnabled(false);
                    simple_func_Buttons[i].setEnabled(true);
                }
                for (int i = 0; i < trig_func_Buttons.length; i++) {
                    trig_func_Buttons[i].setEnabled(false);
                }
                for (int i = 0; i < hyp_func_Buttons.length; i++) {
                    hyp_func_Buttons[i].setEnabled(false);
                }
                for (int i = 0; i < lerd_func_Buttons.length; i++) {
                    lerd_func_Buttons[i].setEnabled(false);
                }

            } else if (num_type.getSelection().getActionCommand().equals("DEC")) {
                // DEC Number
                for (int i = 0; i < num_Buttons.length; i++) {
                    num_Buttons[i].setEnabled(true);
                }
                // HEX Number
                for (int i = 0; i < hexa_Buttons.length; i++) {
                    hexa_Buttons[i].setEnabled(false);
                }
                for (int i = 0; i < simple_func_Buttons.length; i++) {
                    simple_func_Buttons[i].setEnabled(true);
                }
                for (int i = 0; i < trig_func_Buttons.length; i++) {
                    trig_func_Buttons[i].setEnabled(true);
                }
                for (int i = 0; i < hyp_func_Buttons.length; i++) {
                    hyp_func_Buttons[i].setEnabled(true);
                }
                for (int i = 0; i < lerd_func_Buttons.length; i++) {
                    lerd_func_Buttons[i].setEnabled(true);
                }
            } else if (num_type.getSelection().getActionCommand().equals("OCT")) {
                // DEC Number
                for (int i = 0; i < num_Buttons.length; i++) {
                    num_Buttons[i].setEnabled(false);
                }
                // OCT Number
                for (int i = 0; i < 8; i++) {
                    num_Buttons[i].setEnabled(true);
                }
                // HEX Number
                for (int i = 0; i < hexa_Buttons.length; i++) {
                    hexa_Buttons[i].setEnabled(false);
                }
                for (int i = 1; i < simple_func_Buttons.length; i++) {
                    simple_func_Buttons[0].setEnabled(false);
                    simple_func_Buttons[i].setEnabled(true);
                }
                for (int i = 0; i < trig_func_Buttons.length; i++) {
                    trig_func_Buttons[i].setEnabled(false);
                }
                for (int i = 0; i < hyp_func_Buttons.length; i++) {
                    hyp_func_Buttons[i].setEnabled(false);
                }
                for (int i = 0; i < lerd_func_Buttons.length; i++) {
                    lerd_func_Buttons[i].setEnabled(false);
                }
            } else if (num_type.getSelection().getActionCommand().equals("BIN")) {
                // DEC Number
                for (int i = 0; i < num_Buttons.length; i++) {
                    num_Buttons[i].setEnabled(false);
                }
                // BIN Number
                for (int i = 0; i < 2; i++) {
                    num_Buttons[i].setEnabled(true);
                }
                // HEX Number
                for (int i = 0; i < hexa_Buttons.length; i++) {
                    hexa_Buttons[i].setEnabled(false);
                }
                for (int i = 1; i < simple_func_Buttons.length; i++) {
                    simple_func_Buttons[0].setEnabled(false);
                    simple_func_Buttons[i].setEnabled(true);
                }
                for (int i = 0; i < trig_func_Buttons.length; i++) {
                    trig_func_Buttons[i].setEnabled(false);
                }
                for (int i = 0; i < hyp_func_Buttons.length; i++) {
                    hyp_func_Buttons[i].setEnabled(false);
                }
                for (int i = 0; i < lerd_func_Buttons.length; i++) {
                    lerd_func_Buttons[i].setEnabled(false);
                }
            }


            if (e.getSource() == b_log) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.log(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_pow) {
                num1 = Double.parseDouble(textField.getText());
                num2 = Double.parseDouble(textField.getText());
                result = Math.pow(num1,num2);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_exp) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.exp(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_deg) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.toDegrees(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_rad) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.toRadians(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sin) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sin(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cos) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.cos(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_tan) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.tan(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cosec) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.sin(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sec) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.cos(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cot) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.tan(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sin_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.asin(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cos_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.acos(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_tan_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.atan(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cosec_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.asin(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sec_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.acos(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cot_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.atan(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sinh) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sinh(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cosh) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.cosh(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_tanh) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.tanh(num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cosech) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.sinh(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sech) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.cosh(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_coth) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / (Math.tanh(num1));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sinh_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.log10(num1 + (Math.sqrt((num1 * num1) + 1)));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cosh_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.log10(num1 + (Math.sqrt((num1 * num1) - 1)));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_tanh_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / 2 * (Math.log10((1 + num1) / (1 - num1)));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_cosech_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.log10((1 + (Math.sqrt(1 + (num1 * num1)))) / num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_sech_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.log10((1 + (Math.sqrt(1 - (num1 * num1)))) / num1);
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }
            if (e.getSource() == b_coth_inv) {
                num1 = Double.parseDouble(textField.getText());
                result = 1 / 2 * (Math.log10((num1 + 1) / (num1 - 1)));
                if (e.getSource() == b_equal) {
                    textField.setText(String.valueOf(result));
                    num1 = result;
                }
            }

     }
}



