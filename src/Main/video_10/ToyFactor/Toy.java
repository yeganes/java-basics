package Main.video_10.ToyFactor;

public class Toy {

    private double basePrice ;
    protected ToySize size;

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        if (size == ToySize.SMALL) {
            return basePrice;
        } else if (size == ToySize.MEDIUM) {
            return basePrice * 1.5;
        } else if (size == ToySize.LARGE) {
            return basePrice * 2;
        }
        return 0;
    }
    public double getPrice(double discount) {
        double i = discount / 100;
        if (size == ToySize.SMALL) {
            return i * basePrice;
        } else if (size == ToySize.MEDIUM) {
            return i * basePrice*1.5;
        } else if (size == ToySize.LARGE) {
            return i * basePrice * 2;

        }

        return 0;
    }
    public Toy( double basePrice , ToySize size){
        this.basePrice = basePrice;
        this.size = size;
    }

    enum ToySize {
        SMALL, MEDIUM, LARGE
    }

    public static void main(String[] args){
        Toy teddyBear = new Toy(20000 , ToySize.LARGE);
        Toy kite = new Toy(20000 , ToySize.SMALL);
        Toy ball = new Toy(20000 , ToySize.MEDIUM);
        Car car = new Car(40000, ToySize.MEDIUM);
        System.out.println(teddyBear.getPrice() + " " + kite.getPrice()+ " " +ball.getPrice() + " " + teddyBear.getPrice(50) + " " + car.getPrice(20));
    }
}