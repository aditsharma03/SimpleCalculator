import java.util.*;
public class Calculator
{
    private String rawinput, postfix;
    private double result;
    

    Calculator()
    {
        this.rawinput = "";
        this.postfix = "";
        this.result = 0.0;
    }

    protected void input()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an expression:\n");
        this.rawinput = sc.nextLine();
    }

    protected void format()
    {
        this.rawinput = rawinput.replace(" ","");
        this.rawinput = rawinput.replace("/"," / ");
        this.rawinput = rawinput.replace("*"," * ");
        this.rawinput = rawinput.replace("+"," + ");
        this.rawinput = rawinput.replace("-"," - ");
    }

    public static void main(String args[])
    {
        Calculator calc = new Calculator();
        calc.input();
        calc.format();

        PostfixConvertor pcon = new PostfixConvertor(calc.rawinput); 
        calc.postfix = pcon.postfix();
        
        PostfixSolver psolve = new PostfixSolver(calc.postfix);
        calc.result = psolve.solver();

        System.out.println("\nSolution:\t"+ calc.result);
    }
}


