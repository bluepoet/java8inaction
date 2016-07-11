package net.bluepoet.java8inaction.chap03;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Mac on 2016. 7. 10..
 */
public class SortExampleJunitTest {
    private List<Apple> inventory = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        inventory.addAll(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red")));
    }

    @Test
    public void sortByLambda() throws Exception {
        //when
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        //then
        assertResult(80, 120, 155);
    }

    @Test
    public void reverseSortByLambda() throws Exception {
        //when
        inventory.sort(comparing(Apple::getWeight).reversed());

        //then
        assertResult(155, 120, 80);
    }

    @Test
    public void multipleComparingByLambda() throws Exception {
        //given
        inventory.set(1, new Apple(80, "blue"));

        //when
        inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor));

        //then
        assertThat(inventory.get(0).getColor()).isEqualTo("blue");
        assertThat(inventory.get(1).getColor()).isEqualTo("green");
    }

    private void assertResult(int firstNum, int secondNum, int thirdNum) {
        assertThat(inventory.get(0).getWeight()).isEqualTo(firstNum);
        assertThat(inventory.get(1).getWeight()).isEqualTo(secondNum);
        assertThat(inventory.get(2).getWeight()).isEqualTo(thirdNum);
    }
}
