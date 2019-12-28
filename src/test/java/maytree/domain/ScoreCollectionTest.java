package maytree.domain;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class ScoreCollectionTest {
    @Test
    void answersArithmeticMeanOfTwoNumbers() {
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        int result = collection.arithmeticMean();

        assertThat(result).isEqualTo(6);
    }
}
