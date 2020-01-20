package pl.kopp.marta;

import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        Splitter splitter = new Splitter();
        Formatter formatter = new Formatter();

        String input = "ala ma kota, kot koduje w Javie Kota";

        Map<Character, Set<String>> check = splitter.groupByLetter(input);
        check.forEach((key, value) ->
                System.out.println(key + ": " + formatter.toStringWithoutBrackets(value)));

    }
}
