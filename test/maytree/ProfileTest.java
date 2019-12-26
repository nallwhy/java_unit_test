package maytree;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfileTest {
  static private Logger logger = Logger.getLogger(ProfileTest.class.getName());

  private Profile profile;
  private BooleanQuestion question;
  private Criteria criteria;

  @BeforeEach
  public void create() {
    this.profile = new Profile("Bull Hockey, Inc.");
    this.question = new BooleanQuestion(1, "Got bounses?");
    this.criteria = new Criteria();

    logger.info("called twice");
  }

  @Test
  public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
    Answer profileAnswer = new Answer(this.question, Bool.FALSE);
    profile.add(profileAnswer);
    Answer criteriaAnswer = new Answer(this.question, Bool.TRUE);
    Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
    this.criteria.add(criterion);

    boolean matches = profile.matches(this.criteria);

    assertThat(matches).isFalse();
  }

  @Test
  public void matchAnswersTrueForAnyDontCareCriteria() {
    Answer profileAnswer = new Answer(this.question, Bool.FALSE);
    profile.add(profileAnswer);
    Answer criteriaAnswer = new Answer(this.question, Bool.TRUE);
    Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
    this.criteria.add(criterion);

    boolean matches = profile.matches(this.criteria);

    assertThat(matches).isTrue();
  }
}