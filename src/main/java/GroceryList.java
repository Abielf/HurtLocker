import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryList {
    String data;

    GroceryList(String mess){
    data=mess;
    }

    public HashMap priceFinder(String reg, String text){ //returns hashmap of a food types prices
        Matcher foodMatcher=Pattern.compile(reg).matcher(text);
        HashMap<String, Integer> priceList = new HashMap<String, Integer>();
        while (foodMatcher.find()) {
            Matcher priceMatch= Pattern.compile("[0-9]\\.[0-9][0-9]").matcher(foodMatcher.group());
            if (priceMatch.find()){
                if(priceList.containsKey(priceMatch.group())){
                    priceList.put(priceMatch.group(), priceList.get(priceMatch.group()) + 1);
                }else {priceList.put(priceMatch.group(),1);}
            }
        } return priceList;
    }
    public void printGroceries(){//prints out grocery list, with errors
        HashMap<String, Integer> priceList;
        String[] foods={"C..k.e.;....e:....","Cookies","Br..D;....e:...."," Bread ","apPles;p..ce:....",
                " Apples","Mi..;pri.e:...."," Milk  "};
        for(int i=0;i<foods.length;i+=2){
            priceList = priceFinder(foods[i], data);
            System.out.println("Name:"+foods[i+1]+"         Seen: "+countPrices(priceList)+" Times");
            System.out.println("=============     \t =============");
            for(String p:priceList.keySet()){
                System.out.println("Price:   "+p+"        Seen: "+priceList.get(p)+" Times");
                System.out.println("-------------        -------------");
            }
        } System.out.println("\nErrors         	 	 seen: "+errorCounter()+" times");
    }
    public Integer countPrices(HashMap<String, Integer> prices){//counts up prices for a food item
        Integer totalPrices=0;
        for(String p: prices.keySet()) totalPrices+=prices.get(p);
        return totalPrices;
    }
    public Integer errorCounter(){ //counts every instance of an empty name or price field
            Integer eCount=0;
            Matcher missingNo=Pattern.compile("(..M.:[^a-zA-Z])|(;....e:[^0-9])").matcher(data);
            while(missingNo.find()){eCount++;}
            return eCount;
    }
}