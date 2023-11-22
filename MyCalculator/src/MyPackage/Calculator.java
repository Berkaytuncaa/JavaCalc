package MyPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] funcitonButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clearButton, negButton;
	JPanel panel;
	
	Font font = new Font("MV Boli", Font.BOLD,30);
	
	double num1 = 0, num2 = 0;
	double result = 0;
	char operator;
	
	Calculator(){
		LineBorder line = new LineBorder(Color.black, 3, true);
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 550);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 70);
		textfield.setFont(font);
		textfield.setEditable(false);
		textfield.setBackground(Color.LIGHT_GRAY);
		textfield.setBorder(line);
		
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("÷");
		decButton = new JButton(",");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clearButton = new JButton("AC");
		negButton = new JButton("(-)");
		
		funcitonButtons[0] = divButton;
		funcitonButtons[1] = mulButton;
		funcitonButtons[2] = subButton;
		funcitonButtons[3] = addButton;
		funcitonButtons[4] = equButton;
		funcitonButtons[5] = decButton;
		funcitonButtons[6] = delButton;
		funcitonButtons[7] = clearButton;
		funcitonButtons[8] = negButton;
		
		for(int i = 0; i < 9; i++) {
			funcitonButtons[i].addActionListener(this);
			funcitonButtons[i].setFont(font);
			funcitonButtons[i].setFocusable(false);
		}
		
		for(int j = 0; j < 10; j++) {
			numberButtons[j] = new JButton(String.valueOf(j));
			
			numberButtons[j].addActionListener(this);
			numberButtons[j].setFont(font);
			numberButtons[j].setFocusable(false);
		}
		
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clearButton.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBounds(50, 100, 300, 300);
		panel.setBackground(Color.GRAY);
		panel.setBorder(line);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(divButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(mulButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(subButton);
		panel.add(addButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(equButton);
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clearButton);
		frame.add(textfield);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	for(int i = 0; i < 10; i++) {
		if(e.getSource() == numberButtons[i]) {
			textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
	
	if(e.getSource() == decButton) {
		textfield.setText(textfield.getText().concat("."));
		}
	if(e.getSource() == addButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '+';
		textfield.setText("");
		}
	if(e.getSource() == subButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '-';
		textfield.setText("");
		}
	if(e.getSource() == mulButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = 'x';
		textfield.setText("");
		}
	if(e.getSource() == divButton) {
		num1 = Double.parseDouble(textfield.getText());
		operator = '÷';
		textfield.setText("");
		}
	if(e.getSource() == equButton) {
		num2 = Double.parseDouble(textfield.getText());
		
		switch(operator) {
			case '+':
				result=num1+num2;
				break;
			case '-':
				result=num1-num2;
				break;
			case 'x':
				result=num1*num2;
				break;
			case '÷':
				result=num1/num2;
				break;
			}
		textfield.setText(String.valueOf(result));
		num1=result;
		}
	if(e.getSource() == clearButton) {
		textfield.setText("");
		}
	if(e.getSource() == delButton) {
		String string = textfield.getText();
		textfield.setText("");
		for(int i = 0; i<string.length()-1;i++) {
			textfield.setText(textfield.getText()+string.charAt(i));
				}
		
			}
	if(e.getSource() == negButton) {
		double temp = Double.parseDouble(textfield.getText());
		
		temp*= -1;
		textfield.setText(String.valueOf(temp));
		}	
	}

}
