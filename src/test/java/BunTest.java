import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getBunPart() {
        return new Object[][] {
            { "black bun", 100},
            { "red bun", 500.50f},
            { "green bun", 0},
            { "", 100},
            { null, 500}
        };
    }

    @Test
    public void getNameTests(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTests(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), Utils.PRICE_DELTA);
    }

}
