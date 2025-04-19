package app.tests;

import app.gameengine.*;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Potion;
import app.games.topdownobjects.AxePickup;
import app.games.topdownobjects.MagicPickup;
import app.games.topdownobjects.PotionPickup;
import org.junit.Test;
import static org.junit.Assert.*;



public class TestTask5 {
    /*
    addInventoryItem and cycleInventory:
    Write tests to ensure that adding items to the inventory has the proper behavior
    when cycling through the inventory, i.e. calling cycleInventory will go through every added CollectibleGameObject
    and wrap around to the beginning

    removeActiveItem:
    Write tests to ensure that calling removeActiveItem properly removes the active item from the inventory and sets the new active item.
    When testing these methods, you only need to check that the item IDs match the expected.
     */
    @Test
    public void testInventory(){
        Player player = new Player(new Vector2D(0.0,0.0),100);
        PotionPickup healthPotion = new PotionPickup(new Vector2D(1.0,1.0),20);
        AxePickup axe = new AxePickup(new Vector2D(2.0,1.0));;
        MagicPickup magic = new MagicPickup(new Vector2D(5.0,5.0));
        MagicPickup magic2 = new MagicPickup(new Vector2D(5.0,5.0));
        PotionPickup healthPotion1 = new PotionPickup(new Vector2D(1.0,1.0),20);
        PotionPickup healthPotion2 = new PotionPickup(new Vector2D(1.0,1.0),20);

        assertNull(player.getActiveItem());
        assertEquals("No item equipped",player.getActiveItemID());

        player.addInventoryItem(axe);
        player.addInventoryItem(healthPotion);
        player.addInventoryItem(magic);
        player.addInventoryItem(healthPotion1);
        player.addInventoryItem(healthPotion2);
        player.addInventoryItem(magic2);

        assertEquals("Axe",player.getActiveItemID());
        player.cycleInventory();
        assertEquals("Health Potion",player.getActiveItemID());
        player.cycleInventory();
        assertEquals("Magic",player.getActiveItemID());
        player.cycleInventory();
        player.cycleInventory();
        player.cycleInventory();
        player.cycleInventory();
        assertEquals("Axe",player.getActiveItemID());

        player.removeActiveItem();
        assertEquals("Health Potion",player.getActiveItemID());
        player.cycleInventory();
        player.cycleInventory();
        player.cycleInventory();
        player.cycleInventory();
        assertEquals("Magic",player.getActiveItemID());
        player.removeActiveItem();
        assertEquals("Health Potion",player.getActiveItemID());
    }
}
