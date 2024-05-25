package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Item> items(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    @Test
    void checkEveryBranch() {
        RuntimeException ex;

        //1 allItems=null,payment=X
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 1));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        //2 allItems=[{"",0456,302,0.2}],payment=2000
        assertTrue(SILab2.checkCart(items(new Item("", "0456", 302, 0.2f)), 2000));

        //3 allItems=[{"notebook",null,X,X}],payment=X
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("notebook", null, 0, 0f)), 1));
        assertTrue(ex.getMessage().contains("No barcode!"));

        //4 allItems=[{"pencil",-1356,X,X}],payment=X
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("pencil", "-1356", 0, 0f)), 1));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        //5 allItems=[{"pen",8573,302,0.2}],payment=2
        assertFalse(SILab2.checkCart(items(new Item("pen", "8573", 302, 0.2f)), 2));

    }
    @Test
    void checkMultipleConditions(){
        assertTrue(SILab2.checkCart(items(new Item("", "04628", 350, 0.3f)),300)); //TTT
        assertFalse(SILab2.checkCart(items(new Item("", "74858", 489, 0.5f)),5)); //TTF
        assertFalse(SILab2.checkCart(items(new Item("", "83678", 350, 0)),0)); // TFF
        assertFalse(SILab2.checkCart(items(new Item("", "02535", 300, 0.7f)),7)); //FTT
    }
}