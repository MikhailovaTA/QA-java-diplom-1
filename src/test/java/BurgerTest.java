import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Mock
    Ingredient ingredient3;

    @Test
    public void setBunTest(){
        burger.setBuns(bun);
        Assert.assertEquals(bun,burger.bun);
    }

    @Test
    public void addIngredientTest(){
        Assert.assertTrue(burger.ingredients.isEmpty());
        burger.addIngredient(ingredient);
        Assert.assertEquals(1,burger.ingredients.size());
        Assert.assertEquals(ingredient,burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(1, 2);
        Assert.assertEquals(ingredient,burger.ingredients.get(0));
        Assert.assertEquals(ingredient3,burger.ingredients.get(1));
        Assert.assertEquals(ingredient2,burger.ingredients.get(2));
    }

    @Test
    public void getPriceTest(){
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(50f);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Assert.assertEquals(250,burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptTest(){
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(bun.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getPrice()).thenReturn(300f);
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Assert.assertEquals("(==== white bun ====)\r\n" +
            "= sauce chili sauce =\r\n" +
            "(==== white bun ====)\r\n" +
            "\r\n" +
            "Price: 700,000000\r\n",burger.getReceipt());
    }
}
