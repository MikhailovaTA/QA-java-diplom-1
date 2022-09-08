import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getIngredientsPart() {
        return new Object[][] {
            { FILLING, "cutlet", 100},
            { SAUCE, "sour cream", 200},
            { null, "chili sauce", 300},
            { FILLING, null, 200},
            { SAUCE, "", 100},
            { FILLING, "sausage", 0}
        };
    }

    @Test
    public void checkParameters(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type,ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price,ingredient.getPrice(), Utils.PRICE_DELTA);
    }

}
