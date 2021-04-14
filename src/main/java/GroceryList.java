import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryList {
    String data;

    GroceryList(String mess){
    data=mess;
    }

    public HashMap priceFinder(String reg, String text){
        Matcher foodMatcher=Pattern.compile(reg).matcher(text);
        HashMap<String, Integer> priceList = new HashMap<String, Integer>();
        while (foodMatcher.find()) {
            Matcher priceMatch= Pattern.compile("[0-9]\\.[0-9][0-9]").matcher(foodMatcher.group());
            if (priceMatch.find()){
                if(priceList.containsKey(priceMatch.group())){
                    priceList.put(priceMatch.group(), priceList.get(priceMatch.group()) + 1);
                }else {priceList.put(priceMatch.group(),1);}
            }
        }
        return priceList;
    }

    public void foodString(String text, String reg, String name){
        HashMap<String, Integer> priceList = priceFinder(reg, text);
        System.out.println("Name: "+name+"          Seen: "+countPrices(priceList)+" Times");
        System.out.println("=============     \t =============");
        for(String p:priceList.keySet()){
            System.out.println("Price:   "+p+"        Seen: "+priceList.get(p)+" Times");
            System.out.println("-------------        -------------");
        }
    }

    public Integer countPrices(HashMap<String, Integer> prices){
        Integer totalPrices=0;
        for(String p: prices.keySet()) totalPrices+=prices.get(p);
        return totalPrices;
    }

    public void printGroceries(){
        foodString(data,"C..k.e.;....e:....", "Cookies");
        foodString(data,"Br..D;....e:....", "Bread");
        foodString(data,"apPles;p..ce:....", "Apples");
        foodString(data,"Mi..;pri.e:....", "Milk");
        System.out.println("\nErrors         	 	 seen: "+errorCounter()+" times");
    }
    public Integer errorCounter(){
            Integer eCount=0;
            Matcher missingno=Pattern.compile("(..M.:[^a-zA-Z])|(;....e:[^0-9])").matcher(data);
            while(missingno.find()){eCount++;}
            return eCount;
    }
}