package maytree;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {
  static private Logger logger = Logger.getLogger(ProfileTest.class.getName());

  private Profile profile;
  private BooleanQuestion question;
  private Criteria criteria;

  @Before
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

    assertFalse(matches);
  }

  @Test
  public void matchAnswersTrueForAnyDontCareCriteria() {
    Answer profileAnswer = new Answer(this.question, Bool.FALSE);
    profile.add(profileAnswer);
    Answer criteriaAnswer = new Answer(this.question, Bool.TRUE);
    Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
    this.criteria.add(criterion);

    boolean matches = profile.matches(this.criteria);

    assertTrue(matches);
  }
}