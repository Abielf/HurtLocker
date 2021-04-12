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

    public Matcher matchMaker(String in, String reg) {
        Pattern foodPattern = Pattern.compile(reg);
        return foodPattern.matcher(in);
    }

    public void priceFinder(){
        Matcher foodMatcher=matchMaker(data, regex);
        Matcher priceMatch;
        int count=0;
        for (int i = 0; foodMatcher.find(); i++) {
            priceMatch=matchMaker(foodMatcher.group(),"[0-9]\\.[0-9][0-9]");
            while (priceMatch.find()){
                if(priceList.containsKey(priceMatch.group())){
                    count = priceList.get(priceMatch.group());
                    priceList.put(priceMatch.group(),count+1);
                }else {priceList.put(priceMatch.group(),1);}
            }
        }
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
        for(String p: priceList.keySet()){
            totalPrices+=priceList.get(p);
        }
        return totalPrices;
    }
}
