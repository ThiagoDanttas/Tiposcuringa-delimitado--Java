import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Integer> myInts = Arrays.asList(1,2,3,4);
        List<Double> myDouble = Arrays.asList(3.14, 6.28);
        List<Object> myObj = new ArrayList<Object>();

        copy(myInts, myObj);
        printList(myObj);
        copy(myDouble, myObj);
        printList(myObj);

    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        destiny.addAll(source);
    }

    public static void printList(List<?> list){
        for(Object obj: list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }


}
