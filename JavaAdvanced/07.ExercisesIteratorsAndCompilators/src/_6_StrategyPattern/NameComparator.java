package _6_StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        int result = firstPerson.getName().length() - secondPerson.getName().length();
        if (result == 0) {
            result =firstPerson.getName().toLowerCase().charAt(0) -
                    secondPerson.getName().toLowerCase().charAt(0);
        }

        return result;
    }
}
