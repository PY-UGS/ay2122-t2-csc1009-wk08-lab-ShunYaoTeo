import java.util.Scanner;

public class CircleWithException {
    private double radius;
    public static final double PI = 3.14159265;
    Scanner input = new Scanner(System.in);
    public CircleWithException(){
        this.radius = 1;
    }

    public CircleWithException(double radius) throws Exception {
        if(radius < 0) {
            throw new IllegalArgumentException();
        }else if(radius < 1000){
            throw new Exception();
        }else {
            this.radius = radius;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius() throws Exception {
        System.out.println("Please enter your Radius: ");
        double i = input.nextDouble();
        if(i < 0) {
            throw new IllegalArgumentException();
        }else if(i > 1000){
            throw new Exception();
        }else {
            this.radius = i;
        }
    }

    public double getArea(){
        return PI*this.radius*this.radius;
    }

    public double getDiameter(){
        return this.radius*2;
    }

    public static void main(String[] args) {
        CircleWithException circle = new CircleWithException();
        try{
            circle.setRadius();
            System.out.println("The area of your Circle is: "+ circle.getArea());
        }catch(IllegalArgumentException e){
            System.out.println("Please enter a positive Radius!");
        }catch(Exception e){
            System.out.println("Please enter a value LESS than 1000");
        }
    }

}
