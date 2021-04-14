import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class testClasses {

    @Test
    public void groceryConstructorTest(){
        GroceryList food=new GroceryList("This should pass Methinks");
        Assert.assertTrue(food instanceof GroceryList);}

    @Test
    public void listTest(){
        GroceryList food=new GroceryList("cat1.96plplplplcat0.34plplplcat1.96ththtcat8.33");
        HashMap<String, Integer> mappy=food.priceFinder("cat....","");
        Integer expected = 1;
        Assert.assertEquals(expected, mappy.get("0.34"));
    }

    @Test
    public void priceTest(){
        GroceryList food=new GroceryList("cat1.96plplplplcat0.34plplplcat1.96ththtcat8.33");
        Integer expected=4;
        HashMap<String, Integer> thing =food.priceFinder("cat....","");
        Integer actual=food.countPrices(thing);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void errorTest(){
        GroceryList food=new GroceryList("NAME:90abMc:28;jimse:nah;ungae:free;type:oka");
        Integer expected=4;
        Assert.assertEquals(expected, food.errorCounter());
    }
}
