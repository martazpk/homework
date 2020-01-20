package pl.kopp.marta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FormatterTest {
    private Formatter formatter = new Formatter();

    @Test
    void shouldDeleteBrackets() {
        List<String> given = new ArrayList<>(List.of("marta", "kopp"));

        String result = formatter.toStringWithoutBrackets(given);

        assertThat(result.charAt(0)).isEqualTo('m');
        assertThat(result.charAt(result.length()-1)).isEqualTo('p');
    }
}