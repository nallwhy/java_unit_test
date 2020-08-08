package maytree.controller;

import maytree.domain.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

class QuestionControllerTest {

    private QuestionController questionController;

    @BeforeEach
    void init() {
        questionController = new QuestionController();
    }

    @AfterEach
    void tearDown() {
        questionController.deleteAll();
    }

    @Test
    void questionAnswersDateAdded() {
        Instant now = new Date().toInstant();
        questionController.setClock(Clock.fixed(new, ZoneId.of("Asia/Seoul")));
        int id = questionController.addBooleanQuestion("text");

        Question question = questionController.find(id);

        assertThat(question.getCreateTimestamp()).isEqualsTo(now);
    }
}
