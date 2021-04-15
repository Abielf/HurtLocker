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
        GroceryList food=new GroceryList("");
        HashMap<String, Integer> mappy=food.priceFinder("cat....","cat1.96plplplplcat0.34plplplcat1.96ththtcat8.33");
        Integer expected = 1;
        Assert.assertEquals(expected, mappy.get("0.34"));
    }

    @Test
    public void listTest2(){
        GroceryList food=new GroceryList("");
        HashMap<String, Integer> mappy=food.priceFinder("cat....","cat1.96plplplplcat0.34plplplcat1.96ththtcat8.33");
        Integer expected = 2;
        Assert.assertEquals(expected, mappy.get("1.96"));
    }

    @Test
    public void listTest3(){
        GroceryList food=new GroceryList("");
        HashMap<String, Integer> mappy=food.priceFinder("cat....","");
        Assert.assertTrue(mappy instanceof HashMap);
    }

    @Test
    public void priceTest(){
        GroceryList food=new GroceryList("");
        Integer expected=4;
        HashMap<String, Integer> thing =food.priceFinder("cat....","cat1.96plplplplcat0.34plplplcat1.96ththtcat8.33");
        Integer actual=food.countPrices(thing);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void priceTest2(){
        GroceryList food=new GroceryList("");
        HashMap<String, Integer> mappy=food.priceFinder("cat....","catkokokokokokcatokokoko");
        Integer expected = 0;
        Integer actual=food.countPrices(mappy);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void errorTest(){
        GroceryList food=new GroceryList("NAME:90abMc:28;jimse:nah;ungae:free;type:oka");
        Integer expected=4;
        Assert.assertEquals(expected, food.errorCounter());
    }

    @Test
    public void errorTest2(){
        GroceryList food=new GroceryList("");
        Integer expected=4;
        Assert.assertNotEquals(expected, food.errorCounter());
    }

    @Test
    public void errorTest3(){
        GroceryList food=new GroceryList("");
        Integer expected=0;
        Assert.assertEquals(expected, food.errorCounter());
    }
}
