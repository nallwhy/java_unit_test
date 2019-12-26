package maytree;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ScoreCollectionTest {
  @Test
  public void answersArithmeticMeanOfTwoNumbers() {
    ScoreCollection collection = new ScoreCollection();
    collection.add(() -> 5);
    collection.add(() -> 7);

    int result = collection.arithmeticMean();

    assertThat(result).isEqualTo(6);
  }
}
