import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoodStuffs {
    String data;
    String regex;
    String name;
    HashMap<String, Integer> priceList = new HashMap<String, Integer>();

    FoodStuffs(String in, String reg, String n) {
        regex=reg;
        data = in;
        name=n;
    }
    public HashMap priceFinder(){
        Matcher foodMatcher=Pattern.compile(regex).matcher(data);
        while (foodMatcher.find()) {
            Matcher priceMatch=Pattern.compile("[0-9]\\.[0-9][0-9]").matcher(foodMatcher.group());
            if (priceMatch.find()){
                if(priceList.containsKey(priceMatch.group())){
                    priceList.put(priceMatch.group(), priceList.get(priceMatch.group()) + 1);
                }else {priceList.put(priceMatch.group(),1);}
            }
        }return priceList;  //Returns priceList only for testing purposes
    }
    public void foodString(){
        priceFinder();
        System.out.println("Name: "+name+"          Seen: "+countPrices()+" Times");
        System.out.println("=============     \t =============");
        for(String p:priceList.keySet()){
            System.out.println("Price:   "+p+"        Seen: "+priceList.get(p)+" Times");
            System.out.println("-------------        -------------");
        }
    }
    public Integer countPrices(){
        Integer totalPrices=0;
        for(String p: priceList.keySet()) totalPrices+=priceList.get(p);
        return totalPrices;
    }
}