package pl.kopp.marta;

import java.util.Collection;

public class Formatter {

    public String toStringWithoutBrackets(Collection collection){
        return collection.toString().replace("[", "").replace("]", "");
    }
}
