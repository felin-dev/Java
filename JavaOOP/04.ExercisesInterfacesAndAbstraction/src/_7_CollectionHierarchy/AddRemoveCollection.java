package _7_CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String text) {
        super.getItems().add(0, text);
        return 0;
    }

    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size() - 1);
    }
}
