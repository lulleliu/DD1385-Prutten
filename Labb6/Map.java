import java.util.*;

public class Map<E extends Comparable<E>> extends TreeMap<Integer, E> implements SparseVec<E> {

    public Map() {
        super();
    }

    @Override
    public int size() {
        return super.size(); // Use the size() method from TreeMap
    }

    @Override
    public int maxIndex() {
        if (super.isEmpty()) {
            return -1;
        }
        return super.lastKey();
        //return super.isEmpty() ? -1 : super.firstKey(); // Use the firstKey() method from TreeMap
    }

    @Override
    public int minIndex() {
        if (super.isEmpty()) {
            return -1;
        }
        return super.firstKey();
        //return super.isEmpty() ? -1 : super.lastKey(); // Use the lastKey() method from TreeMap
    }

    @Override
    public void removeAt(int position) {
        if (super.containsKey(position)) {
            super.remove(position); // Use the remove() method from TreeMap
        }
    }

    @Override
    public void removeElem(E element) {
        //if (super.containsKey(element)){ //onödigt skit
        for (int i : super.keySet()){
            if (super.get(i).equals(element)){
                super.remove(i);
                break;
            }
        }
        
    }

    @Override
    public E get(int position) {
        if (super.containsKey(position)){
            return super.get(position); // Use the get() method from TreeMap
    }
    return null;
}

    @Override
    public void add(int position, E element) {
        if (position < 0) {
            position = 0;
        }
        super.put(position, element); // Use the put() method from TreeMap
    }

    @Override
    public void add(E element) {
        int position = 0;
        while (super.containsKey(position)) {
            position++;
        }
        super.put(position, element); // Use the put() method from TreeMap
    }

    @Override
    public int indexOf(E element) {
        for (int i: super.keySet()) {
            if (super.get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (super.isEmpty()) {
            return "The map is empty";
        }
        StringBuilder treeString = new StringBuilder();
        for (int i : super.keySet()) {
            treeString.append(i).append(": ").append(super.get(i)).append("\n");
        }
        return treeString.toString();
    }

    @Override
    public Object[] toArray() {
        if (super.isEmpty()) {
            return null;
        }
        Object[] arr = new Object[this.maxIndex() + 1];
        for (int j : super.keySet()) {
            arr[j] = super.get(j);
        }
        return arr;
    }

    @Override
    public List<E> sortedValues() {
        if (super.isEmpty()) {
            return null;
        }
        List<E> list = new ArrayList<>();
        for (int i : super.keySet()){
            list.add(super.get(i));
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        // create a MyVec of strings
        Map<String> vec = new Map<String>();
        // add some strings
        vec.add("nollte");
        vec.add(1, "ett");
        vec.add("abcdefg");
        vec.add(7, "test");
        vec.add(15, "hejhej");
        vec.add(13, "hej fast en andra gång");
        vec.add(3, "????");
        vec.add(7, ":SSS");
        vec.add(5, "123");




        // print the vector using the toString() method
        System.out.println(" Printing using toString() will give this result:");
        System.out.println(vec);
        // print the vector with toArray()
        System.out.println("Printing the vector using the toArray() will give this result:");
        Object[] arr = vec.toArray();
        for (Object o : arr) {
            System.out.println(o);
        }
        // print the vector with sortedValues()
        System.out.println("Printing using the sortedValues() will sort the vector and print this: ");
        List<String> list = vec.sortedValues();
        for (String s : list) {
            System.out.println(s);
        }


    }
}