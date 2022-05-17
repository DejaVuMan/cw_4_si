import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public class Driver {

    public static void main(String[] args) {
        String truthStatement1 = "(p → (p && q || (r || q)))";

        HashMap<Character, Boolean> values1 = new HashMap<Character, Boolean>();
        values1.put('p', true);
        values1.put('q', true);
        values1.put('r', true);

        JexlTest test1 = new JexlTest();

        System.out.println(test1.plTrueJexl(truthStatement1, values1));
    }
}
