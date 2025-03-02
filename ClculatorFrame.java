import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class ClculatorFrame extends JFrame implements ActionListener {
	private static final int Fwidth = 400;
	private static final int Fheight = 600;
	private static final int Fx = 200;
	private static final int Fy = 200;

	JButton plus;
	JButton minus;
	JButton multi;
	JButton equals;
	JButton divide;
	JButton clear;
	JButton numbers[];
	JTextField input;
	JTextArea textArea;
	private double num1, num2;
	private char operation;

	public ClculatorFrame() {
		setTitle("CALCULATOR");
		setSize(Fwidth, Fheight);
		setLocation(Fx, Fy);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		OperationsButtons();
		NumbersButtons();
		changeColor();
		text();
		setVisible(true);

	}

	public void OperationsButtons() {
		plus = new JButton("+");
		minus = new JButton("-");
		multi = new JButton("×");
		equals = new JButton("=");
		divide = new JButton("÷");
		clear = new JButton("Clear");

		Container container = getContentPane();
		container.setLayout(null);
		container.add(plus);
		container.add(minus);
		container.add(multi);
		container.add(divide);
		container.add(equals);
		container.add(clear);

		plus.addActionListener(this);
		minus.addActionListener(this);
		multi.addActionListener(this);
		divide.addActionListener(this);
		equals.addActionListener(this);
		clear.addActionListener(this);
		plus.setBounds(10, 410, 70, 70);
		minus.setBounds(10, 480, 70, 70);
		multi.setBounds(80, 410, 70, 70);
		divide.setBounds(80, 480, 70, 70);
		equals.setBounds(150, 410, 210, 70);
		clear.setBounds(150, 480, 210, 70);

	}

	public void NumbersButtons() {
		numbers = new JButton[10];
		Container container = getContentPane();
		int x = -60;

		for (int i = 0; i <= 4; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].setBounds(x += 70, 340, 70, 70);
			numbers[i].addActionListener(this);

			container.add(numbers[i]);
		}
		x = -60;
		for (int i = 5; i <= 9; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].setBounds(x += 70, 270, 70, 70);
			numbers[i].addActionListener(this);

			container.add(numbers[i]);
		}

	}

	public void text() {
		Container container = getContentPane();

		input = new JTextField();
		input.setBounds(10, 230, 350, 40);
		container.add(input);

		textArea = new JTextArea();
		textArea.setBounds(10, 80, 350, 100);
		Border border = BorderFactory.createLineBorder(Color.black, 3);
		textArea.setBorder(border);
		container.add(textArea);
	}

	public void changeColor() {
		Container container = getContentPane();
		container.setBackground(Color.white);
	}

	public void actionPerformed(ActionEvent event) {

		for (int i = 0; i <= 9; i++) {
			if (event.getSource() == numbers[i]) {
				input.setText(input.getText() + i);
				return;
			}
		}
		if (event.getSource() == plus || event.getSource() == minus || event.getSource() == multi
				|| event.getSource() == divide) {
			num1 = Double.parseDouble(input.getText());
			operation = ((JButton) event.getSource()).getText().charAt(0);
			input.setText("");
		} else if (event.getSource() == equals) {
			num2 = Double.parseDouble(input.getText());
			double result=0;
			switch (operation) {
			case '+':
				result = num1 + num2;
				break;
			case'-':result=num1-num2;
			break;
			case'÷': result=num1/num2;
			break;
			case'×':result=num1*num2;
			break;
			}
			textArea.setText(num1 + " " + operation + " " + num2 + " = " + result);
            input.setText("");
		}
		else if(event.getSource()==clear) {
			input.setText("");
			textArea.setText("");
		}
	}
}
