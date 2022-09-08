import java.util.*;
public class PostfixConvertor
{
    private String input, result;
    private Stack<String> stack = new Stack<String>();

    PostfixConvertor(String rawinput)
    {
        this.input = rawinput;
        this.result = "";
        StringTokenizer stoken = new StringTokenizer(this.input," ");
        while(stoken.hasMoreTokens()){
            String token = stoken.nextToken();
            if(! isOperator(token)) result += token + " ";
            else    stackOperation(token);
        }
        while(! stack.isEmpty()){
            result += stack.pop() + " ";
        }
    }

    protected boolean isOperator(String x)
    {
       if(x.equals("/") || x.equals("*") || x.equals("+") || x.equals("-"))
        return true;
       return false; 
    }

    protected int getPrecedence(String x)
    {
        int precedence = 0;
        if( x.equals("*") || x.equals("/") ) precedence = 2;
        else if( x.equals("+") || x.equals("-")) precedence = 1;
        return precedence;

    } 

    protected void stackOperation(String str)
    {
        if(stack.isEmpty()){
            stack.push(str);
            return;
        }

        int precedence1 = getPrecedence(str);
        int prededence2 = getPrecedence(stack.peek());

        if(precedence1 > prededence2) stack.push(str);
        else {
            result += stack.pop() + " ";
            stackOperation(str);
        }
    }   

    protected String postfix()
    {
        return result;
    }

}