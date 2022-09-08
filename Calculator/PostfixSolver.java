import java.util.*;
public class PostfixSolver
{
    private String postfix;
    private double result;
    private Stack<String> stack = new Stack<String>();

    PostfixSolver(String arg)
    {
        this.postfix = arg;
    }

     protected boolean isOperator(String x)
    {
       if(x.equals("/") || x.equals("*") || x.equals("+") || x.equals("-"))
        return true;
       return false; 
    }

    protected void reduce()
    {
        String a = stack.pop();
        double y = Double.valueOf(stack.pop());
        double x = Double.valueOf(stack.pop());
        double ans = 0.0;
        if(a.equals("/"))   ans = x/y;
        if(a.equals("*"))   ans = x*y;
        if(a.equals("+"))   ans = x+y;
        if(a.equals("-"))   ans = x-y;

        stack.push( String.valueOf(ans) );
        this.result = ans;

    }

    protected double solver()
    {
        StringTokenizer stoken = new StringTokenizer(this.postfix," ");

        while(stoken.hasMoreTokens()){
            String str = stoken.nextToken();
            stack.push(str);
            if( isOperator(str) )   reduce();

        }
        return this.result;
    }


}