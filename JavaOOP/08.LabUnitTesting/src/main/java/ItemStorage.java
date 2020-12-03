package rpg_lab;

import java.util.Collection;
import java.util.Iterator;

public interface ItemStorage extends Iterable<Weapon> {
    Collection<Weapon> getWeapons();

    public Iterator<Weapon> iterator();
}
