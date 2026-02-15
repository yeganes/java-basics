package video_03;
//جدول ضرب 1-100 با 10 سطر به ازای هر عدد صحیح 1-10
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((i*j) +  " ");
            }
            System.out.println();

        }
    }
}