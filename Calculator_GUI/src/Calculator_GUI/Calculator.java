package Calculator_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.math.*;
import javax.swing.UIManager;

/*
 * Author: Halime
 * Date: 25-12-2023
 * Description: A simple calculator that can add, subtract multiply, divide,
 *              module and raise to n-th integer power 
 * */

public class Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel myPanel;
	private JTextField screenDown;
	private double num1;
	private double num2;
	private char op;
	private JTextField screenUp;
	
	
	private double Operation(double num1, double num2, char op) {
		double result=0;
		switch(op) {
		case '/': 	return (num1/num2);
		case '*':	return (num1*num2);
		case '+':	return (num1+num2);
		case '-':	return (num1-num2);
		case '^':	return  Math.pow(num1, num2);
		case '%':	return (num1%num2);
		}
		return result;
	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setTitle("Calculator");
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 490);
		myPanel = new JPanel();
		myPanel.setBackground(new Color(37, 37, 37));
		myPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(myPanel);
		myPanel.setLayout(null);
		
		screenDown = new JTextField();
		screenDown.setEditable(false);
		screenDown.setBorder(null);
		screenDown.setHorizontalAlignment(SwingConstants.TRAILING);
		screenDown.setForeground(new Color(255, 255, 255));
		screenDown.setFont(new Font("Lucida Console", Font.PLAIN, 25));
		screenDown.setToolTipText("enter two numbers");
		screenDown.setBackground(new Color(81, 81, 81));
		screenDown.setBounds(10, 54, 250, 36);
		myPanel.add(screenDown);
		screenDown.setColumns(10);
		
		screenUp = new JTextField();
		screenUp.setHorizontalAlignment(SwingConstants.RIGHT);
		screenUp.setEditable(false);
		screenUp.setForeground(new Color(255, 255, 255));
		screenUp.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		screenUp.setBorder(null);
		screenUp.setBackground(new Color(81, 81, 81));
		screenUp.setBounds(10, 26, 250, 28);
		myPanel.add(screenUp);
		screenUp.setColumns(10);
		
		
		JButton delete = new JButton("del");
		delete.setToolTipText("Clear all");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText("");
				screenUp.setText("");
				num1=0;
				num2=0;
			}
		});
		delete.setBackground(new Color(240, 240, 240));
		delete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delete.setBounds(10, 114, 55, 25);
		myPanel.add(delete);
		
		JButton erase = new JButton("<--");
		erase.setToolTipText("Clear last one");
		erase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText("");
				num2=0;
			}
		});
		erase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		erase.setBackground(new Color(240, 240, 240));
		erase.setBounds(10, 144, 55, 25);
		myPanel.add(erase);
		
//Operators
		JButton division = new JButton("/");
		division.setToolTipText("Division");
		division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1=Double.valueOf(screenDown.getText()) ;
				screenUp.setText(num1+"/");
				screenDown.setText("");
				op='/';
			}
		});
		division.setBackground(new Color(240, 240, 240));
		division.setFont(new Font("Tahoma", Font.PLAIN, 15));
		division.setBounds(75, 114, 55, 55);
		myPanel.add(division);
		
		JButton multiplication = new JButton("*");
		multiplication.setToolTipText("Multiplication");
		multiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1=Double.valueOf(screenDown.getText()) ;
				screenUp.setText(num1+"*");
				screenDown.setText("");
				op='*';
			}
		});
		multiplication.setBackground(new Color(240, 240, 240));
		multiplication.setFont(new Font("Tahoma", Font.PLAIN, 15));
		multiplication.setBounds(140, 114, 55, 55);
		myPanel.add(multiplication);
		
		JButton subtraction = new JButton("-");
		subtraction.setToolTipText("Subtraction");
		subtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1=Double.valueOf(screenDown.getText()) ;
				screenUp.setText(num1+"-");
				screenDown.setText("");
				op='-';
			}
		});
		subtraction.setBackground(new Color(240, 240, 240));
		subtraction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		subtraction.setBounds(205, 246, 55, 55);
		myPanel.add(subtraction);
		

		JButton addition = new JButton("+");
		addition.setToolTipText("Addition");
		addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1=Double.valueOf(screenDown.getText()) ;
				screenUp.setText(num1+"+");
				screenDown.setText("");
				op='+';
			}
		});
		
		JButton modulus = new JButton("%");
		modulus.setToolTipText("Modulus");
		modulus.setBackground(new Color(240, 240, 240));
		modulus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1=Double.valueOf(screenDown.getText()) ;
				screenUp.setText(num1+"%");
				screenDown.setText("");
				op='%';
			}
		});
		modulus.setBounds(205, 114, 55, 55);
		myPanel.add(modulus);
		
		JButton power = new JButton("^");
		power.setToolTipText("Power");
		power.setBackground(new Color(240, 240, 240));
		power.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1=Double.valueOf(screenDown.getText()) ;
				screenUp.setText(num1+"^");
				screenDown.setText("");
				op='^';
			}
		});
		power.setFont(new Font("Tahoma", Font.PLAIN, 15));
		power.setBounds(205, 180, 55, 55);
		myPanel.add(power);
		
		
		JButton point = new JButton(",");
		point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+".");
			}
		});
		point.setBackground(new Color(240, 240, 240));
		point.setFont(new Font("Tahoma", Font.PLAIN, 15));
		point.setBounds(75, 378, 55, 55);
		myPanel.add(point);	
		
		
//Enter
		JButton Enter = new JButton("Enter");
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num2=Double.valueOf(screenDown.getText());
				screenUp.setText(String.format("%s%s%s=",num1,op,num2));
				screenDown.setText(String.format("%s", Operation(num1, num2, op)));
			}
		});
		Enter.setBackground(new Color(240, 240, 240));
		Enter.setToolTipText("Enter");
		Enter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Enter.setBounds(140, 378, 120, 55);
		myPanel.add(Enter);
		
		
//Numbers
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"1");
			}
		});
		one.setBackground(new Color(240, 240, 240));
		one.setFont(new Font("Tahoma", Font.PLAIN, 15));
		one.setBounds(10, 312, 55, 55);
		myPanel.add(one);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"2");
			}
		});
		two.setBackground(new Color(240, 240, 240));
		two.setFont(new Font("Tahoma", Font.PLAIN, 15));
		two.setBounds(75, 312, 55, 55);
		myPanel.add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"3");
			}
		});
		three.setBackground(new Color(240, 240, 240));
		three.setFont(new Font("Tahoma", Font.PLAIN, 15));
		three.setBounds(140, 312, 55, 55);
		myPanel.add(three);

		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"4");
			}
		});
		four.setBackground(new Color(240, 240, 240));
		four.setFont(new Font("Tahoma", Font.PLAIN, 15));
		four.setBounds(10, 246, 55, 55);
		myPanel.add(four);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"5");
			}
		});
		five.setBackground(new Color(240, 240, 240));
		five.setFont(new Font("Tahoma", Font.PLAIN, 15));
		five.setBounds(75, 246, 55, 55);
		myPanel.add(five);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"6");
			}
		});
		six.setBackground(new Color(240, 240, 240));
		six.setFont(new Font("Tahoma", Font.PLAIN, 15));
		six.setBounds(140, 246, 55, 55);
		myPanel.add(six);
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"7");
			}
		});
		seven.setBackground(new Color(240, 240, 240));
		seven.setFont(new Font("Tahoma", Font.PLAIN, 15));
		seven.setBounds(10, 180, 55, 55);
		myPanel.add(seven);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"8");
			}
		});
		eight.setBackground(new Color(240, 240, 240));
		eight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eight.setBounds(75, 180, 55, 55);
		myPanel.add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"9");
			}
		});
		nine.setBackground(new Color(240, 240, 240));
		nine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nine.setBounds(140, 180, 55, 55);
		myPanel.add(nine);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDown.setText(screenDown.getText()+"0");
			}
		});
		zero.setBackground(new Color(240, 240, 240));
		zero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zero.setBounds(10, 378, 55, 55);
		myPanel.add(zero);
		
		
		
		addition.setBackground(new Color(240, 240, 240));
		addition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addition.setBounds(205, 312, 55, 55);
		myPanel.add(addition);
		
		
		
		
		
	}
	
}
