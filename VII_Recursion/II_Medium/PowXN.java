package VII_Recursion.II_Medium;

public class PowXN {
    public static void main(String[] args) {
       double x = 2.00000;
       int n = 10 ;
       PowXNSolution solution = new PowXNSolution();
        System.out.println(solution.myPow(x, n));
    }
}

class PowXNSolution {
    public double myPow(double x, int n) {
        return solve(x, n);
    }

    public double solve(double x, long n){
        if(n == 0) return 1;
        if(n < 0) return solve(1/x, -n);
        if(n%2 == 0) return solve(x*x, n/2);
        return x * solve(x*x, n/2);
    }
}
