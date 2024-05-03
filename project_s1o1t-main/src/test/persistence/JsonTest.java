package persistence;

import model.Bottoms;
import model.Outfit;
import model.Shoes;
import model.Tops;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This class provides test methods for checking an outfits fields in JSON format.
public class JsonTest {
    protected void checkOutfit(String topColor, String topType,
            String bottomColor, String bottomType, String shoeColor, String shoeType, String season, Outfit outfit) {
        assertEquals(topColor, outfit.getTop().getColor());
        assertEquals(topType, outfit.getTop().getType());
        assertEquals(bottomColor, outfit.getBottom().getColor());
        assertEquals(bottomType, outfit.getBottom().getType());
        assertEquals(shoeColor, outfit.getShoes().getColor());
        assertEquals(shoeType, outfit.getShoes().getType());
        assertEquals(season, outfit.getSeason());
    }
}
