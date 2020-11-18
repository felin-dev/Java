package _7_CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {

    @Override
    public int add(String text) {
        super.getItems().add(0, text);
        return 0;
    }

    @Override
    public String remove() {
        return super.getItems().remove(0);
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
