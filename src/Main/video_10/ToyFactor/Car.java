package Main.video_10.ToyFactor;

public class Car extends Toy{

    public Car(double basePrice, ToySize size) {
        super(basePrice,  size);}

    @Override
    public double getPrice(){
            if (size == ToySize.SMALL) {
                return getBasePrice() * 2;
            } else if (size == ToySize.MEDIUM) {
                return getBasePrice() * 2.5;
            } else if (size == ToySize.LARGE) {
                return getBasePrice() * 3;
            }
            return 0;
        }




    }

