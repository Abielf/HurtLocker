import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        GroceryList foods= new GroceryList(output);
        foods.printFoods();







        /*{
        String text = "Horatio dHjcnjkOanoxinkHznmdkHoratiosnckHORATIOamsn Horatio aksmalk";

        Pattern pattern = Pattern.compile("(Horatio)|(HORATIO)"); //generates regex pattern
        Matcher matcher = pattern.matcher(text);//generates match results of regex against test
        for (int i = 0; matcher.find(); i++) {
            System.out.println(new StringBuilder()
                    .append("\n-------------------")
                    .append("\nValue = " + matcher.group())
                    .append("\nMatch Number = " + i)
                    .append("\nStarting index = " + matcher.start())
                    .append("\nEnding index = " + matcher.end())
                    .append("\nA test"+matcher.end())
                    .toString());
        }System.out.println(matcher.replaceAll("Tariq"));
    }

    Pattern cookiePattern= Pattern.compile("M.*##");
        Matcher cookieMatcher= cookiePattern.matcher(output);
        int cookieCount = 0;

        for(int i=0;cookieMatcher.find() ;i++){
            cookieCount++;
            System.out.println(cookieMatcher.group());
        }

        System.out.println(cookieCount);*/

    }
}
