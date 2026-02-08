package video_02;
//اعداد صحیحی که اگر در شعاع دایره قرار بگیرند محیط دایره کمتر از 100 است.
public class Exercise1 {
    public static void main(String[] args) {
        int r = 0 ;
        double c = 0;
        do {
            r++ ;
            c = circleRound(r);
            //using a method
            if (c<100)
                System.out.println(r);
        }while (c < 100);
        //when we have a do we have to add the while too, it expects it .
    }
    static double circleRound(int num) {
        //defining a method
        return 2 * 3.14 * num ;
    }
}
