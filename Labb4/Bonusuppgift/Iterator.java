public interface Iterator<Component> {
    Component next();           // gå fram ett steg och returnera nästa element
    boolean hasNext();  // returnera true om det finns fler element att besöka
    void remove();      // krävs ej i labben, implementeras tom
}
