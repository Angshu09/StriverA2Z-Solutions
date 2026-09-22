package VII_Recursion.II_Medium;

public class CountGoodNumbers {
    public static void main(String[] args) {
        long n = 50;
        CountGoodNumbersSolution solution = new CountGoodNumbersSolution();
        System.out.println(solution.countGoodNumbers(n));
    }
}

class CountGoodNumbersSolution {
    long M = ((long)Math.pow(10,9))+7;
    public int countGoodNumbers(long n) {
        return (int)((solve2(5, (n+1)/2) * solve2(4, n/2))%M);
    }

    public long solve(long a, long b){
        if(b == 0) return 1;
        long half = solve(a, b/2);
        long result = (half*half)%M;
        if(b%2!=0) result = (result * a)%M;
        return result;
    }

    public long solve2(long x, long n){
        if(n == 0) return 1;

        if(n % 2 == 0) return solve(x*x, n/2) % M;

        return (x * solve(x*x, n/2)) % M;
    }
}
