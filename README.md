# Curingas Delimitado (bounded wildcards)

---

~~~~java 
public class Main {
    public static void main(String[] args){
        List<? extends Number> list = intList;
    }
}
~~~~

### Problema 1
Vamos fazer um método para retornar a soma das áreas de uma lista de
figuras.

### Problema 2 (princípio get/put)
Vamos fazer um método que copia os elementos de uma lista para uma
outra lista que pode ser mais genérica que a primeira.

~~~~java
public class Main {
    public static void main(String[] args){
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();
        
        copy(myInts, myObjs);
        copy(myDoubles, myObjs);
    }
}

~~~~

### Princípio get/put - covariância 

List<? extends Number> --> Qualquer list do tipo que seja subtipo de NUMBER (integer, byte, short, long)

- Operação GET é permitida
- Operação put não é permitida 

~~~java
public class Main {
    public static void main(String[] args){
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);
        List<? extends Number> list = intList;
        Number x = list.get(0);
        
        list.add(20); // erro de compilacao
    }
}

// get - OK
// put = ERROR


~~~

### Princípio get/put - contravariância

List<? super Number> --> Qualquer valor do tipo Number ou SUPER tipo de number (Ex. Object)
~~~java
public class Main {
    public static void main(String[] args){
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        List<? super Number> myNums = myObjs; // --- Observação ---
        myNums.add(10);
        myNums.add(3.14);
        Number x = myNums.get(0); // erro de compilacao
    }
}

// get - ERROR
// put = OK


~~~