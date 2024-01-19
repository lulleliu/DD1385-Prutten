import java.util.*;
public class Vec <E extends Comparable<E>> implements SparseVec<E> {
    private TreeMap<Integer, E> map;

    public Vec(){
        map = new TreeMap<>();
    }

    public int size(){
        //Check the size of the map
        return map.size();
    }

    public int maxIndex(){
        return map.isEmpty() ? -1 : map.lastKey();  //Checks if the map is empty, returns -1 if empty, otherwise the highest key
    }

    public int minIndex(){
        return map.isEmpty() ? -1: map.firstKey(); //Checks if the map is empty, returns -1 if empty, otherwise the lowest key
    }

    public void removeAt(int position){
        if (map.containsKey(position)){
            map.remove(position);
        }
    }
    public void removeElem(E element){
            for (int i : map.keySet()){
                if (map.get(i).equals(element)){
                    map.remove(i);
                    break;
                }
            }
        }
    
    
    public E get(int position){
        if (map.containsKey(position)){
            return map.get(position);
        }
        return null;
    }
    public void add(int position, E element){
        if (position < 0){
            position = 0;
        }
        map.put(position, element);
    }

    public void add(E element){
        int position = 0;
        while (map.containsKey(position)) {
            position++;
            
        }
        map.put(position, element);
    }

    public int indexOf(E elem){
        for (int i : map.keySet()){
            if (map.get(i).equals(elem)){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        if (map.isEmpty()){
            return "The map is empty";
        }
        StringBuilder treeString = new StringBuilder();
        for (int i : map.keySet()){
            treeString.append(i).append(": ").append(map.get(i)).append("\n");
        }
        return treeString.toString();
    }

    public Object[] toArray(){
        if (map.isEmpty()){
            return null;
        }
        Object[] arr = new Object[this.maxIndex()+1];
        for (int j : map.keySet()){
            arr[j] = map.get(j);
        }
        return arr;
    }

    public List<E> sortedValues(){
        if (map.isEmpty()){
            return null;
        }
        List<E> list = new ArrayList<>();
        for (int i : map.keySet()){
            list.add(map.get(i));
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
