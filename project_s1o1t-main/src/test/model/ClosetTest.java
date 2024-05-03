package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Tests for VirtualCloset class methods
class ClosetTest {
    private Outfit outfit1;
    private Tops whiteBlouse;
    private Bottoms blackSkirt;
    private Shoes blackHeels;
    private Tops pinkSweater;
    private Bottoms pinkPants;
    private Shoes pinkNikes;
    private VirtualCloset virtualCloset;
    private Outfit outfit2;
    private Outfit outfit3;
    private Outfit outfit4;
    private Outfit outfit5;
    private String seasonFall = "Fall";
    private String seasonSpring = "Spring";
    private String seasonWinter = "Winter";
    private String seasonSummer = "Summer";
    private List<Outfit> outfits = new ArrayList<>();

    @BeforeEach
    void runBefore() {
        whiteBlouse = new Tops("White", "Blouse");
        blackSkirt = new Bottoms("Black", "Skirt");
        blackHeels = new Shoes("Black", "Heels");
        pinkSweater = new Tops("Pink", "Sweater");
        pinkPants = new Bottoms("Pink", "Pants");
        pinkNikes = new Shoes("Pink", "Nikes");
        outfit1 = new Outfit(whiteBlouse, blackSkirt, blackHeels, seasonSpring);
        outfit2 = new Outfit(pinkSweater, pinkPants, pinkNikes, seasonFall);
        outfit3 = new Outfit(pinkSweater, blackSkirt, pinkNikes, seasonWinter);
        outfit4 = new Outfit(whiteBlouse, pinkPants, blackHeels, seasonSummer);
        outfit5 = new Outfit(pinkSweater, pinkPants, pinkNikes, seasonWinter);
        virtualCloset = new VirtualCloset(outfits);
    }
    //Test constructor to ensure empty list
    @Test
    void testClosetConstructor() {
        assertTrue(virtualCloset.getAllOutfits().isEmpty());
        assertNotNull(virtualCloset.getAllOutfits());
    }

    @Test
    void testGetAllOutfits() {
        virtualCloset.addOutfit(outfit1);
        virtualCloset.addOutfit(outfit2);
        assertEquals(2, virtualCloset.getAllOutfits().size());
        assertEquals(outfit1, virtualCloset.getAllOutfits().get(0));
        assertEquals(outfit2, virtualCloset.getAllOutfits().get(1));
    }

    @Test
    void testAddOutfitVirtualCloset() {
        virtualCloset.addOutfit(outfit1);
        assertEquals(1, virtualCloset.getAllOutfits().size());
        assertEquals(outfit1, virtualCloset.getAllOutfits().get(0));
    }

    @Test
    void testAddTwoOutfitVirtualCloset() {
        virtualCloset.addOutfit(outfit1);
        virtualCloset.addOutfit(outfit2);
        assertEquals(2, virtualCloset.getAllOutfits().size());
        assertEquals(outfit2, virtualCloset.getAllOutfits().get(1));
    }

    @Test
    void testRemoveOneOutfit() {
        virtualCloset.addOutfit(outfit1);
        virtualCloset.addOutfit(outfit2);
        assertEquals(2, virtualCloset.getAllOutfits().size());
        virtualCloset.removeOutfit(0);
        assertEquals(1, virtualCloset.getAllOutfits().size());
        assertEquals(outfit2, virtualCloset.getAllOutfits().get(0));
    }

    @Test
    void testRemoveTwoOutfits() {
        virtualCloset.addOutfit(outfit1);
        virtualCloset.addOutfit(outfit2);
        assertEquals(2, virtualCloset.getAllOutfits().size());
        virtualCloset.removeOutfit(1);
        assertEquals(1, virtualCloset.getAllOutfits().size());
        virtualCloset.removeOutfit(0);
        assertEquals(0, virtualCloset.getAllOutfits().size());
        assertTrue(virtualCloset.getAllOutfits().isEmpty());
    }

    @Test
    void testGetOutfitsBySeasonSpring() {
        virtualCloset.addOutfit(outfit1);
        List<Outfit> springOutfits = virtualCloset.getOutfitsBySeason("Spring");
        assertEquals("White", springOutfits.get(0).getTop().getColor());
        assertEquals("Blouse", springOutfits.get(0).getTop().getType());
        assertEquals("Black", springOutfits.get(0).getBottom().getColor());
        assertEquals("Skirt", springOutfits.get(0).getBottom().getType());
        assertEquals("Black", springOutfits.get(0).getShoes().getColor());
        assertEquals("Heels", springOutfits.get(0).getShoes().getType());
        assertEquals("Spring", springOutfits.get(0).getSeason());
        assertEquals(1, springOutfits.size());
    }

    @Test
    void testGetOutfitsBySeasonTwoWinterOutfits() {
        virtualCloset.addOutfit(outfit3);
        virtualCloset.addOutfit(outfit5);
        List<Outfit> winterOutfits = virtualCloset.getOutfitsBySeason("Winter");
        assertEquals("Pink", winterOutfits.get(0).getTop().getColor());
        assertEquals("Sweater", winterOutfits.get(0).getTop().getType());
        assertEquals("Black", winterOutfits.get(0).getBottom().getColor());
        assertEquals("Skirt", winterOutfits.get(0).getBottom().getType());
        assertEquals("Pink", winterOutfits.get(0).getShoes().getColor());
        assertEquals("Nikes", winterOutfits.get(0).getShoes().getType());
        assertEquals("Winter", winterOutfits.get(0).getSeason());
        assertEquals("Pink", winterOutfits.get(1).getTop().getColor());
        assertEquals("Sweater", winterOutfits.get(1).getTop().getType());
        assertEquals("Pink", winterOutfits.get(1).getBottom().getColor());
        assertEquals("Pants", winterOutfits.get(1).getBottom().getType());
        assertEquals("Pink", winterOutfits.get(1).getShoes().getColor());
        assertEquals("Nikes", winterOutfits.get(1).getShoes().getType());
        assertEquals("Winter", winterOutfits.get(1).getSeason());
        assertEquals(2, winterOutfits.size());

    }

    @Test
    void testGetOutfitsBySeasonOnlyOneWinterInCloset() {
        virtualCloset.addOutfit(outfit3);
        virtualCloset.addOutfit(outfit1);
        List<Outfit> winterOutfits = virtualCloset.getOutfitsBySeason("Winter");
        assertEquals("Pink", winterOutfits.get(0).getTop().getColor());
        assertEquals("Sweater", winterOutfits.get(0).getTop().getType());
        assertEquals("Black", winterOutfits.get(0).getBottom().getColor());
        assertEquals("Skirt", winterOutfits.get(0).getBottom().getType());
        assertEquals("Pink", winterOutfits.get(0).getShoes().getColor());
        assertEquals("Nikes", winterOutfits.get(0).getShoes().getType());
        assertEquals("Winter", winterOutfits.get(0).getSeason());
        assertEquals(1, winterOutfits.size());
    }

    @Test
    void testGetOutfitsBySeasonSummer() {
        virtualCloset.addOutfit(outfit4);
        List<Outfit> summerOutfits = virtualCloset.getOutfitsBySeason("Summer");
        assertEquals("White", summerOutfits.get(0).getTop().getColor());
        assertEquals("Blouse", summerOutfits.get(0).getTop().getType());
        assertEquals("Pink", summerOutfits.get(0).getBottom().getColor());
        assertEquals("Pants", summerOutfits.get(0).getBottom().getType());
        assertEquals("Black", summerOutfits.get(0).getShoes().getColor());
        assertEquals("Heels", summerOutfits.get(0).getShoes().getType());
        assertEquals("Summer", summerOutfits.get(0).getSeason());
        assertEquals(1, summerOutfits.size());
    }

    @Test
    void testGetOutfitsBySeasonFall() {
        virtualCloset.addOutfit(outfit2);
        List<Outfit> fallOutfits = virtualCloset.getOutfitsBySeason("Fall");
        assertEquals("Pink", fallOutfits.get(0).getTop().getColor());
        assertEquals("Sweater", fallOutfits.get(0).getTop().getType());
        assertEquals("Pink", fallOutfits.get(0).getBottom().getColor());
        assertEquals("Pants", fallOutfits.get(0).getBottom().getType());
        assertEquals("Pink", fallOutfits.get(0).getShoes().getColor());
        assertEquals("Nikes", fallOutfits.get(0).getShoes().getType());
        assertEquals("Fall", fallOutfits.get(0).getSeason());
        assertEquals(1, fallOutfits.size());
    }
}