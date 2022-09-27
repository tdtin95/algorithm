package tdtin;

import tdtin.algorithm.LevenshteinDistance;
import org.junit.jupiter.api.Test;

public class LevenshteinDistanceTest {

    @Test
    void shoudl() {
        System.out.println(LevenshteinDistance.calculate("Tin", ""));
    }
}
