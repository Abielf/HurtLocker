import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryList {
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
        bread.foodString();
        apples.foodString();
        milk.foodString();
        System.out.println("\nErrors         	 	 seen: "+totalError()+" times");
    }

    public Integer totalError(){
        return countUnNamed()+countUnPriced();
    }

    public Integer countUnNamed(){
            Pattern missing = Pattern.compile("..M.:[^a-zA-Z]");
            Integer eCount=0;
            Matcher missingno=missing.matcher(data);
            while(missingno.find()){eCount++;}
            return eCount;
    }
    public Integer countUnPriced(){
        Pattern missing = Pattern.compile(";....e:[^0-9]");
        Integer pCount=0;
        Matcher priceless=missing.matcher(data);
        while(priceless.find()){pCount++;}
        return pCount;
    }

}
