package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Tests Outfit Class methods
class OutfitTest {
    private Outfit outfit1;
    private Tops whiteBlouse;
    private Bottoms blackSkirt;
    private Shoes blackHeels;
    private Tops pinkSweater;
    private Bottoms pinkPants;
    private Shoes pinkNikes;
    private String fall;
    private String spring;
    private VirtualCloset virtualCloset;
    private Outfit outfit2;

    @BeforeEach
    void runBefore() {
        whiteBlouse = new Tops("White", "Blouse");
        blackSkirt = new Bottoms("Black", "Skirt");
        blackHeels = new Shoes("Black", "Heels");
        fall = new String("Fall");
        spring = new String("Spring");
        outfit1 = new Outfit(whiteBlouse, blackSkirt, blackHeels, "Spring");
        pinkSweater = new Tops("Pink", "Sweater");
        pinkPants = new Bottoms("Pink", "Pants");
        pinkNikes = new Shoes("Pink", "Nikes");
        outfit2 = new Outfit(pinkSweater, pinkPants, pinkNikes, fall);
    }

    @Test
    void testConstructor() {
        assertEquals("White", outfit1.getTop().getColor());
        assertEquals("Blouse", outfit1.getTop().getType());
        assertEquals("Black", outfit1.getBottom().getColor());
        assertEquals("Skirt", outfit1.getBottom().getType());
        assertEquals("Black", outfit1.getShoes().getColor());
        assertEquals("Heels", outfit1.getShoes().getType());
    }

    @Test
    void testGetTop() {
        assertEquals("White", outfit1.getTop().getColor());
        assertEquals("Blouse", outfit1.getTop().getType());
    }

    @Test
    void testGetBottom() {
        assertEquals("Black", outfit1.getBottom().getColor());
        assertEquals("Skirt", outfit1.getBottom().getType());
    }

    @Test
    void testGetShoes() {
        assertEquals("Black", outfit1.getShoes().getColor());
        assertEquals("Heels", outfit1.getShoes().getType());
    }

    @Test
    void testGetSeason() {
        assertEquals("Spring", outfit1.getSeason());
    }


}