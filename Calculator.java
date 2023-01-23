import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
  JFrame frame;
  JTextField textField;
  JButton[] number_Buttons = new JButton[10];
  JButton[] operators_Buttons = new JButton[9];
  JButton addButton, subButton, multButton, divButton;
  JButton decButton, equButton, delButton, clrButton, negButton;
  JPanel panel;

  Font font = new Font("monoscope", Font.PLAIN, 30);

  double number_1 = 0, number_2 = 0, result = 0;
  char operator;

  Calculator() {
    frame = new JFrame("CALCULATOR");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 550);
    frame.setLayout(null);

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(font);

    addButton = new JButton("+");
    subButton = new JButton("-");
    multButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    clrButton = new JButton("c");
    equButton = new JButton("=");
    delButton = new JButton("delete");
    negButton = new JButton("-");

    operators_Buttons[0] = addButton;
    operators_Buttons[1] = subButton;
    operators_Buttons[2] = multButton;
    operators_Buttons[3] = divButton;
    operators_Buttons[4] = decButton;
    operators_Buttons[5] = clrButton;
    operators_Buttons[6] = equButton;
    operators_Buttons[7] = delButton;
    operators_Buttons[8] = negButton;

    for (int i = 0; i < 9; i++) {
      operators_Buttons[i].addActionListener(this);
      operators_Buttons[i].setFont(font);
      operators_Buttons[i].setFocusable(false);
    }

    for (int i = 0; i < 10; i++) {
      number_Buttons[i] = new JButton(String.valueOf(i));
      number_Buttons[i].addActionListener(this);
      number_Buttons[i].setFont(font);
      number_Buttons[i].setFocusable(false);
    }

    
    delButton.setBounds(150, 430, 100, 50);
    clrButton.setBounds(250, 430, 100, 50);
    negButton.setBounds(50, 430, 100, 50);

    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));

    panel.add(number_Buttons[1]);
    panel.add(number_Buttons[2]);
    panel.add(number_Buttons[3]);
    panel.add(addButton);

    panel.add(number_Buttons[4]);
    panel.add(number_Buttons[5]);
    panel.add(number_Buttons[6]);
    panel.add(subButton);

    panel.add(number_Buttons[7]);
    panel.add(number_Buttons[8]);
    panel.add(number_Buttons[9]);
    panel.add(multButton);
    panel.add(decButton);
    panel.add(number_Buttons[0]);
    panel.add(equButton);
    panel.add(decButton);
    panel.add(divButton);

    frame.add(panel);
    frame.add(negButton);
    frame.add(delButton);
    frame.add(clrButton);
    frame.add(textField);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new Calculator();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    for (int i = 0; i < 10; i++) {
      if (e.getSource() == number_Buttons[i]) {
        textField.setText(textField.getText().concat(String.valueOf(i)));
      }
    }
    if (e.getSource() == decButton) {
      textField.setText(textField.getText().concat("."));
    }
    if (e.getSource() == addButton) {
      number_1 = Double.parseDouble(textField.getText());
      operator = '+';
      textField.setText("");

    }

    if (e.getSource() == subButton) {
      number_1 = Double.parseDouble(textField.getText());
      operator = '-';
      textField.setText("");

    }
    if (e.getSource() == multButton) {
      number_1 = Double.parseDouble(textField.getText());
      operator = '*';
      textField.setText("");

    }
    if (e.getSource() == divButton) {
      number_1 = Double.parseDouble(textField.getText());
      operator = '/';
      textField.setText("");
    }

    if (e.getSource() == equButton) {
      number_2 = Double.parseDouble(textField.getText());
      switch (operator) {
        case '+':
          result = number_1 + number_2;
          break;
        case '-':
          result = number_1 - number_2;
          break;
        case '*':
          result = number_1 * number_2;
          break;
        case '/':
          result = number_1 / number_2;
          break;
      }
      textField.setText(String.valueOf(result));
      number_1 = result;
    }
    if (e.getSource() == clrButton) {
      textField.setText("");
    }
    if (e.getSource() == delButton) {
      String string = textField.getText();
      textField.setText("");

      for (int i = 0; i < string.length() - 1; i++) {
        textField.setText(textField.getText() + string.charAt(i));
      }
    }
    if (e.getSource() == negButton) {
      double temp = Double.parseDouble(textField.getText());
      temp *= -1;
      textField.setText(String.valueOf(temp));
    }
  }
}
