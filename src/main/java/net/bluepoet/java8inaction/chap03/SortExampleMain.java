package net.bluepoet.java8inaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by Mac on 2016. 7. 9..
 */
public class SortExampleMain {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));

        System.out.println(inventory);
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(1, new Apple(30, "green"));
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        System.out.println(inventory);

        inventory.set(1, new Apple(25, "yello"));
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        inventory.set(2, new Apple(24, "blue"));
        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

        inventory.set(1, new Apple(24, "red"));
        inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor));
        System.out.println(inventory);
    }
}
