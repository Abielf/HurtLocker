import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryList {
    FoodStuffs cookies;
    FoodStuffs bread;
    FoodStuffs apples;
    FoodStuffs milk;
    String data;

    GroceryList(String mess){
    cookies=new FoodStuffs(mess,"C..k.e.;....e:....", "Cookies");
    bread=new FoodStuffs(mess,"Br..D;....e:....", "Bread");
    apples=new FoodStuffs(mess,"apPles;p..ce:....", "Apples");
    milk=new FoodStuffs(mess,"Mi..;pri.e:....", "Milk");
    data=mess;
    }
    public void printFoods(){
        cookies.foodString();
        bread.foodString();
        apples.foodString();
        milk.foodString();
        System.out.println("\nErrors         	 	 seen: "+countErrorType()+" times");
    }
    public Integer countErrorType(){
            Integer eCount=0;
            Matcher missingno=Pattern.compile("(..M.:[^a-zA-Z])|(;....e:[^0-9])").matcher(data);
            while(missingno.find()){eCount++;}
            return eCount;
    }
}