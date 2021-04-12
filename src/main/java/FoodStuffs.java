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

    public Matcher foodMatch() {
        Pattern foodPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return foodPattern.matcher(data);
    }

    public int foodCount(){
        Matcher foodMatcher=foodMatch();
        int foodCount = 0;
        for (int i = 0; foodMatcher.find(); i++) {
            foodCount++;
            }
        return foodCount;
    }

    public void priceFinder(){
        Matcher foodMatcher=foodMatch();
        Pattern pricePattern = Pattern.compile("[0-9]\\.[0-9][0-9]");
        Matcher priceMatch;
        int count=0;
        for (int i = 0; foodMatcher.find(); i++) {
            priceMatch=pricePattern.matcher(foodMatcher.group());
            while (priceMatch.find()){
                if(priceList.containsKey(priceMatch.group())){
                    count = priceList.get(priceMatch.group());
                    priceList.put(priceMatch.group(),count+1);
                }else {priceList.put(priceMatch.group(),1);}
            }
        }
    }
    public void printList(){
        priceFinder();
        for(String p:priceList.keySet()){
            System.out.println("Price:   "+p+"        Seen: "+priceList.get(p)+" Times");
            System.out.println("-------------        -------------");
        }
    }

    public String countToString(){
        return "Name: "+name+"     	 Seen: "+foodCount()+" Times";
    }

    public void foodString(){
        System.out.println(countToString());
        System.out.println("=============     \t =============");
        printList();
    }


    public Integer countPrices(){
        Integer totalPrices=0;
        for(String p: priceList.keySet()){
            totalPrices+=priceList.get(p);
        }
        return totalPrices;
    }
}
