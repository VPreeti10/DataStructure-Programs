//Postfix Expression evalaution 

import java.util.Stack;

public class Expessionevaluation {
	
	public static int applyOp(char op,int a,int b) {
		switch(op) {
			case '+':return(a+b);
			case '*':return(a*b);
			case '-':return(a-b);
			case '/':return(a/b);
			default:
		}
		return 0;
	}
	public static int evaluate(String exp) {
		char[] tokens=exp.toCharArray();
		Stack<Integer> values=new Stack<Integer>();
		Stack<Character> op=new Stack<Character>();
		
		for(int i=0;i<tokens.length;i++) {
			if(tokens[i]==' ') {
				continue;
			}
			
			else if(tokens[i]>='0' && tokens[i]<'9') {
				StringBuffer sbf=new StringBuffer();
				while(i<tokens.length && tokens[i]>='0' && tokens[i]<'9') {
					sbf.append(tokens[i]);
					i++;
				}
				values.push(Integer.parseInt(sbf.toString()));
			}
			
			else if(tokens[i]=='(') {
				op.push(tokens[i]);
			}
			else if(tokens[i]==')') {
				while(op.peek()!='(') {
					values.push(applyOp(op.pop(), values.pop(), values.pop()));
				}
				op.pop();
			}//pop all operators from op which have higher or equal precedence to tokens[i]
			//then push the token[i]
			else if(tokens[i]=='+'||tokens[i]=='*'||tokens[i]=='-'||tokens[i]=='/') {
				while(!op.empty() && hasPrecedence(tokens[i], op.peek())) {
					values.push(applyOp(op.pop(),values.pop(),values.pop()));
				}
				op.push(tokens[i]);
			}
		}
		while(!op.empty()) {
			values.push((applyOp(op.pop(),values.pop(),values.pop())));
		}
		return values.pop();
	}
	public static boolean hasPrecedence(char op1,char op2) {
		
		if(op2=='('||op2==')')
			return false;
		if((op1=='/'||op1=='*') && (op2=='+' || op2=='-')) {
			return false;
		}
		else
			return true;
	}
	public static void main(String[] args) {
		 	System.out.println(Expessionevaluation.evaluate("10 + 2 * 6"));
	        System.out.println(Expessionevaluation.evaluate("100 * 2 + 12"));
	        System.out.println(Expessionevaluation.evaluate("100 * ( 2 + 12 )"));
	        System.out.println(Expessionevaluation.evaluate("100 * ( 2 + 12 ) / 14"));
	}
}
