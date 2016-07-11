package net.bluepoet.java8inaction.chap03

import spock.lang.Specification

/**
 * Created by Mac on 2016. 7. 10..
 */
class SortExampleSpockTest extends Specification {
    def inventory

    void setup() {
        inventory = new ArrayList<Apple>()
        inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red")))
    }

    def "comparator 클래스를 만들어 정렬한다."() {
        given:
        inventory.sort(new AppleComparator())

        expect:
        inventory.get(i).getWeight() == a

        where:
        i | a
        0 | 80
        1 | 120
        2 | 155
    }

    def "익명클래스를 만들어 정렬한다."() {
        given:
        inventory.sort(new Comparator<Apple>() {

            @Override
            int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight())
            }
        });

        expect:
        inventory.get(i).getWeight() == a

        where:
        i | a
        0 | 80
        1 | 120
        2 | 155
    }
}