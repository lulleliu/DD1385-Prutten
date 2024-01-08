public class NumberedItem<T> implements Comparable<NumberedItem<T>> {
    private int index;
    private T value;

    public NumberedItem(int index, T value) {
        this.index = (index < 0) ? 0 : index; //om index < 0 sätt index = 0 annars index = index
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public T getValue() {
        return value;
    }

    @Override
    public int compareTo(NumberedItem<T> other) {
        return this.getIndex() - other.getIndex();
    }

    @Override
    public String toString() {
        return "Index: " + index + "Value: " + value;
    }
    
    public boolean equals(NumberedItem<T> other){
        if(other == null){ //kollar ifall other finns
            return false;
        }
        else if (this.getIndex() - other.getIndex() == 0){ //kollar om this och other är lika med varandra
            return true;
        }
        return false; //Annars är de inte lika
    }
}