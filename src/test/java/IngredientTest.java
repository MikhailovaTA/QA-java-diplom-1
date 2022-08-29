import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    @Test
    public void checkParameters(){
        Ingredient ingredient = new Ingredient(FILLING, "dinosaur", 200f);
        Assert.assertEquals(FILLING,ingredient.getType());
        Assert.assertEquals("dinosaur", ingredient.getName());
        Assert.assertEquals(200f,ingredient.getPrice(), 0.001);
    }

}
