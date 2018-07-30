package example;

import java.util.regex.Pattern;

public class PlzChecker {

    public boolean isPlz(String plz) {
        return Pattern.compile("[0-9]{5}").matcher(plz).matches();
    }

}
