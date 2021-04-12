import org.junit.Assert;
import org.junit.Test;

public class testFoodStuffs {

    @Test
    public void foodTestCnstructor(){
        FoodStuffs food=new FoodStuffs("A lot of words go here","","");
        Assert.assertTrue(food instanceof FoodStuffs);
    }
    @Test
    public void foodCountTest(){
        FoodStuffs food=new FoodStuffs("catmlmlmlmlmlcatlmlmlmcatlmlmlm","cat","");
        Assert.assertEquals(3, food.foodCount());
    }

    @Test
    public void priceTest(){
        FoodStuffs food=new FoodStuffs("cat1.96plplplplcat0.34plplplcat1.96ththtcat8.33","cat....","");
        Integer expected=4;
        food.priceFinder();
        Assert.assertEquals(expected, food.countPrices());
    }

    @Test
    public void errorTest(){
        FoodStuffs food=new FoodStuffs("cat1.96plplcatplplcat0.34plplplcat1.96tcatlklklkllkcaththtcat8.33","cat....","");
        Integer expected=3;
        food.priceFinder();
        food.setErrorCount();
        Assert.assertEquals(expected, food.getErrorCount());
    }



}
