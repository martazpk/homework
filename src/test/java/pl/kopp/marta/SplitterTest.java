package pl.kopp.marta;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SplitterTest {
    private Splitter splitter = new Splitter();

    @Test
    void shouldThrowExceptionWhenNullIsGiven() {
        assertThrows(IllegalArgumentException.class, () -> splitter.groupByLetter(null));
    }

    @Test
    void shouldDeleteComma() {
        String given = "marta,";
        Map<Character, Set<String>> result = splitter.groupByLetter(given);

        assertThat(result.get('m')).contains("marta");
    }

    @Test
    void shouldChangeToLowerCase() {
        String given = "Marta";
        Map<Character, Set<String>> result = splitter.groupByLetter(given);

        assertThat(result.get('m')).contains("marta");
    }

    @Test
    void shouldNotRepeatTheSameWords() {
        String given = "Marta marta";
        Map<Character, Set<String>> result = splitter.groupByLetter(given);

        assertThat(result.get('m').size()).isEqualTo(1);
    }

    @Test
    void shouldSortValues() {
        String given = "ola ela ala";
        Map<Character, Set<String>> map = splitter.groupByLetter(given);
        Set<String> values = map.get('a');

        assertThat(values.toString()).isEqualTo("[ala, ela, ola]");
    }
}