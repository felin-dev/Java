package _7_CollectionHierarchy;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String text) {
        super.getItems().add(text);
        return super.getItems().size() - 1;
    }
}
