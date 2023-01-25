
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircle = new ArrayList<>();
        myCircle.add(new Circle(2.0));
        myCircle.add(new Circle(3.0));


        System.out.println("Total area: " + totalArea(myCircle));
        System.out.println("Total area: " + totalArea(myShapes));
    }

    public static double totalArea(List<? extends Shape > list) { // Observação
        // list.add(new Rectangle(2.0, 3.0) X não é possivel essa operação
        double sum =  0.0;
        for(Shape s: list){
            sum += s.area();
        }
        return sum;
    }

}