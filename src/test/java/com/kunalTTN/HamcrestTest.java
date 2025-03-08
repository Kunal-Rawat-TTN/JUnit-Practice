package com.kunalTTN;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class HamcrestTest {
    @Test
    public void testHamcrest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 7);
        assertThat(list, hasSize(5));
        assertThat(list, hasItems(1, 3, 2));
        assertThat(list, hasItems(1, 3, 2, 3));
//        assertThat(list, hasItems(1,3,2,3,5));

        assertThat(list, everyItem(greaterThan(-1)));
        assertThat(list, everyItem(lessThan(10)));
        assertThat(list, everyItem(lessThanOrEqualTo(7)));

        assertThat("", emptyString());
        assertThat(null, emptyOrNullString());

        Integer[] arr = {1, 2, 4, 6};
        assertThat(arr, arrayWithSize(4));
//        assertThat(arr, arrayContaining(2,6,1));
//        assertThat(arr, arrayContaining(2,4,6));
//        assertThat(arr, arrayContaining(1,2,4));
//        assertThat(arr, arrayContainingInAnyOrder(2,4,6));
        assertThat(arr, arrayContainingInAnyOrder(2, 4, 6, 1));
//        assertThat(arr, arrayContainingInAnyOrder(2, 4, 6, 1,4));
    }
}
