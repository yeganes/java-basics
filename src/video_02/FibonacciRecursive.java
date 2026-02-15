package video_02;

public class FibonacciRecursive {

    public static void main (String[] args){

        for (int i = 0; true ; i++){
                System.out.println(fib(i));
                if (fib(i) > 980)
                    break;
        }

    }
    static int fib(int n){
        if ( n <= 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}