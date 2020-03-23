package lab9_stack.in_to_postfix;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class InfixToPostfix { // Reverse Polish implementation by Koffman & Wolfgang

	private Stack<Character> operatorStack = new Stack<Character>();
	private StringBuilder postfix; // the output	
	private static final String OPERATORS = "+-*/^()";
	private static final int[] PRECEDENCE = {1,1,2,2,3,-1,-1};
	private boolean debug = false;
	
	public InfixToPostfix(boolean debug) {
		this.debug = debug;
	}
	
	public String convert(String infix) throws SyntaxErrorException {
		
		this.operatorStack.clear();
		this.postfix = new StringBuilder();
		StringTokenizer stringTokenizer = new StringTokenizer(infix);
				
		try {
			while(stringTokenizer.hasMoreTokens()) {
				String token = stringTokenizer.nextToken();
				char ch = token.charAt(0);
				
				if(debug)
					System.out.println("Character:" + ch);
				
				if(Character.isJavaIdentifierStart(ch) || 
				   Character.isDigit(ch)) { // Is it an operand
					
					postfix.append(ch);
					postfix.append(' ');
					showStatus();
										
				} else if(isOperator(ch)) { // Is it an operator
					
					processOperator(ch);
										
				} else {
					throw new SyntaxErrorException("SyntaxErrorException:invalid character found:'" + ch + "'");
				}
			}
			
			// Pop any remaining operators
			if(debug)
				System.out.println("\nPop off all the remaining operators in the OperatorStack if any.");
			
			while(!this.operatorStack.isEmpty()) {
				char operator = this.operatorStack.pop();
				
				if(operator == '(')
					throw new SyntaxErrorException("SyntaxErrorException:invalid operator found:'" + operator + "'");
				
				postfix.append(operator);
				postfix.append(' ');
				showStatus();
			}
			
			return this.postfix.toString();
			
		} catch (EmptyStackException ese) {
			System.out.println("EmptyStackException:" + ese.getMessage());
		}
		
		return this.postfix.toString(); // no infix given.
	}
	
	private void processOperator(char operator) {
		
		if(this.operatorStack.empty() || operator == '(') {
			
			// let '(' to have the highest priority
			this.operatorStack.push(operator);
			showStatus();
			
		} else {
			
			char topOperator = operatorStack.peek();
			
			if(precedence(operator) > precedence(topOperator)) {
				
				this.operatorStack.push(operator);
				showStatus();
				
			} else {
				
				while( !this.operatorStack.empty() &&
					   precedence(operator) <= precedence(topOperator) ) {
					
					this.operatorStack.pop();
					
					if(topOperator == '(') 
					{
						showStatus();
						break;
					}
					
					this.postfix.append(topOperator);
					this.postfix.append(' ');
					showStatus();
					
					if(!this.operatorStack.empty())
						topOperator = this.operatorStack.peek();
				}
				
				if(operator != ')') // do not put ')' into the OperatorStack
					this.operatorStack.push(operator);
			}
		}
	}
	
	// Helpers
	private boolean isOperator(char ch) {
		return OPERATORS.indexOf(ch) != -1;
	}
	
	private int precedence(char operator) {
		return PRECEDENCE[OPERATORS.indexOf(operator)];
	}
	
	public void showStatus()
	{
		if(this.debug) {
			System.out.println("\tPostfix:" + this.postfix.toString());
			System.out.println("\tStack:" + this.operatorStack.toString());
		}
	}
	
	/*
	public static void main(String[] args) {
		String infix = "c * ( a + b )";
		InfixToPostfix infixToPostfix = new InfixToPostfix(true);
		
		try {
			String postfix = infixToPostfix.convert(infix);
			System.out.println("Postfix=" + postfix);
		} catch (SyntaxErrorException see) {
			System.out.println(see.getMessage());
		}
	}
	*/
	
	
	public static void main(String[] args)
	{
		String infix = " ";
		InfixToPostfix infixToPostfix = new InfixToPostfix(true);
		
		while(true) {					
			infix = JOptionPane.showInputDialog("Enter an infix expression:");
			infix = infix.trim();
			
			if(infix.length() == 0) 
				break;
			
			try{
				String postfix = infixToPostfix.convert(infix);
				JOptionPane.showMessageDialog(null, postfix, "Postfix of " + infix, JOptionPane.PLAIN_MESSAGE);
			} catch (SyntaxErrorException see) {
				JOptionPane.showMessageDialog(null, "Infix expression is invalid", "Syntax error ", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
