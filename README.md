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
Vamos fazer um m�todo para retornar a soma das �reas de uma lista de
figuras.

### Problema 2 (princ�pio get/put)
Vamos fazer um m�todo que copia os elementos de uma lista para uma
outra lista que pode ser mais gen�rica que a primeira.

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

### Princ�pio get/put - covari�ncia 

List<? extends Number> --> Qualquer list do tipo que seja subtipo de NUMBER (integer, byte, short, long)

- Opera��o GET � permitida
- Opera��o put n�o � permitida 

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

### Princ�pio get/put - contravari�ncia

List<? super Number> --> Qualquer valor do tipo Number ou SUPER tipo de number (Ex. Object)
~~~java
public class Main {
    public static void main(String[] args){
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        List<? super Number> myNums = myObjs; // --- Observa��o ---
        myNums.add(10);
        myNums.add(3.14);
        Number x = myNums.get(0); // erro de compilacao
    }
}

// get - ERROR
// put = OK


~~~