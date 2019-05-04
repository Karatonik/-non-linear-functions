package nonLinearFunctionsProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public boolean Verification(String number) {
        Pattern p = Pattern.compile("^[-+]?[0-9]+[.]?[0-9]*$");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}