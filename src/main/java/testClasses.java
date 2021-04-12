import org.junit.Assert;
import org.junit.Test;

public class testClasses {

    @Test
    public void foodTestCnstructor(){
        FoodStuffs food=new FoodStuffs("A lot of words go here","","");
        Assert.assertTrue(food instanceof FoodStuffs);
    }

    @Test
    public void groceryConstructorTest(){
        GroceryList food=new GroceryList("This should pass Methinks");
        Assert.assertTrue(food instanceof GroceryList);}

    @Test
    public void priceTest(){
        FoodStuffs food=new FoodStuffs("cat1.96plplplplcat0.34plplplcat1.96ththtcat8.33","cat....","");
        Integer expected=4;
        food.priceFinder();
        Assert.assertEquals(expected, food.countPrices());
    }

    @Test
    public void errorTest(){
        GroceryList food=new GroceryList("NAME:90abMc:28;jimse:nah;ungae:free;type:oka");
        Integer expected=4;

        Assert.assertEquals(expected, food.totalError());
    }



}
