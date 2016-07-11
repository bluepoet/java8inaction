package net.bluepoet.java8inaction.chap03;

import java.util.Comparator;

/**
 * Created by Mac on 2016. 7. 9..
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
