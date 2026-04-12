package Main.video_06;

public class Car {
    private String  name = "Fride";
    private String color = "White";
    private long weight = 500L;

    public void setName(String name){
        this.name = name;
    }

    public String getName (){
        return name;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public long getWeight(){
            return weight;
    }

    public Car(){
    }
    public Car(String name){
        this.name = name;
    }
    public Car(String name , String color ){
        this.name = name ;
        this.color = color ;
    }
    public static void main(String[] args){
        Car c1 = new Car() ;
        Car c2 = new Car("Saland");
        Car c3 = new Car("Saland" , "black");
        System.out.println(c1.getName() + "  " + c1.getColor() + "  " + c1.getWeight());
        System.out.println(c2.getName() + "  " + c2.getColor() + "  " + c2.getWeight());
        System.out.println(c3.getName() + "  " + c3.getColor() + "  " + c3.getWeight());
    }

}
