package org.qr.purejava.tools;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomUtilsTest {

    @Test
    public void testRandom() {
        for (int i =0; i<10000; i++) {
            String substring = nextRandom();

            System.out.println(substring);

            assertEquals(4, substring.length());
        }


    }

    public static String nextRandom() {
        float aFloat = RandomUtils.nextFloat(0.01f, 0.99f);
        String valueOf = String.valueOf(aFloat);
        return StringUtils.substring(valueOf, 0, 4);
    }
}
