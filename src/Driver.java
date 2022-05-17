import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public class Driver {

    public static void main(String[] args) {

        HashMap<Character, Boolean> values = new HashMap<Character, Boolean>();
        values.put('A', true);
        values.put('B', true);
        values.put('C', false);

        plTrue("(A ^ B) | (A ^ C)", true, values);
        plTrue("~A ^ (A v C)", false, values);
    }

    static void plTrue(String logicStatement, boolean expectedResult, HashMap toParse){
        // split string based on tautology symbols
        String[] splitElements = logicStatement.split("\\s*[()]\\s*");

        System.out.println("Evaluating logic statement: ");
        for(int i = 0; i < splitElements.length; i++){
            System.out.println(splitElements[i] + " ");
            if(splitElements[i].length() > 4){
                System.out.println("Detected elements to evaluate logic on: " + splitElements[i]);
                for(char parsing: splitElements[i].toCharArray()){
                    if(toParse.containsKey(parsing)){
                        System.out.println("Detected individual element to evaluate logic on: " + parsing);
                        System.out.println(parsing + " equals: " + toParse.get(parsing));
                        splitElements[i] = toParse.get(parsing).toString();
                    }
                }
            }
        }
        splitElements =  cleanArr(splitElements);
        System.out.println("");
    }

    static String[] cleanArr(String[] arr){
        for(int i = 0; i < arr.length; i++){
            if(Objects.equals(arr[i], "")){
                arr[i] = null;
                for(int j = 0; j < arr.length-1; j++){
                    arr[i] = arr[j];
                }
                // todo; return shortened array
            }
        }
        return arr;
    }
}
