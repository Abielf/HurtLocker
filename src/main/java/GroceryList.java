import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryList {


    Integer errorCount=0;
    FoodStuffs cookies;
    FoodStuffs bread;
    FoodStuffs apples;
    FoodStuffs milk;
    String data;


    GroceryList(String mess){
    cookies=new FoodStuffs(mess,"C..kies.Price.....", "Cookies");
    bread=new FoodStuffs(mess,"Br..D.Price.....", "Bread");
    apples=new FoodStuffs(mess,"apPles;p..ce:....", "Apples");
    milk=new FoodStuffs(mess,"Mi..;pri.e:....", "Milk");
    data=mess;
    }


    public void printFoods(){
        cookies.foodString();
        errorCount+=cookies.getErrorCount();
        bread.foodString();
        errorCount+= bread.getErrorCount();
        apples.foodString();
        errorCount+= apples.getErrorCount();
        milk.foodString();
        errorCount+= milk.getErrorCount();
        countUnNamed();
        System.out.println("\nErrors         	 	 seen: "+errorCount+" times");
    }
    /**/
    public void countUnNamed(){
            Pattern missing = Pattern.compile("..M.:[^a-zA-Z]");
            Matcher missingno=missing.matcher(data);
            while(missingno.find()){errorCount++;}
    }


}
