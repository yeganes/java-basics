package video_02;
//فیبوناچی زیر1000

public class Fibonacci {
    public static void main(String[] args) {
        int first = 0 ;
        int second = 1;

        System.out.println(first);
        System.out.println(second);

        while (true) {
            int next = first + second;
            //متغیر باید داخل اسکوپ تعریف بشه
            if (next >= 1000) {
                break;
            }
            System.out.println(next);
            first = second ;
            second = next;



        }


    }
}