package video_02;
//محیط دایره هایی که شعاعشان از 1 تا 10 هست.
public class Exercise2 {
    public static void main(String[] args){
        int r = 0;
        double c = 0;
        do {
            r++;
            c = circleRound(r);
            System.out.println(" r : " + r + " c : " + c );
        } while (r < 10);
    }
    static double circleRound(int num){

        return 2 * 3.14 * num ;
    }
}
