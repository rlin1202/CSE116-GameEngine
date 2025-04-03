package app.gameengine;

import app.gameengine.graphics.SpriteGraphics;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.GameObject;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;

import java.util.HashMap;

/**
 * Controls the UI and levels of the game.
 *
 * You can extend this class if you would like to build a different
 * game. The game that is played by default is `SampleTopDownGame.java`
 */
public class Game {

    private Player player = new Player(new Vector2D(0.0, 0.0), 10);
    private Level currentLevel;
    private long lastUpdate = 0L;
    protected LinkedListNode<Level> levelList;
    protected String displayString = "This is where UI information would go, like HP, number of keys, or inventory";


    public Game() {
        init();
    }
    public void init(){

    }
    public LinkedListNode<Level> getLevelList(){
        return levelList;
    }

    public void setLevelList(LinkedListNode<Level> levels){
        this.levelList = levels;
    }

    public void addLevel(Level level){
        if (levelList == null) {
            levelList = new LinkedListNode<>(level,null);
        }else{
            levelList.append(level);
        }
    }

    public void removeLevelByName(String name){
        if (levelList != null) {
            LinkedListNode<Level> current = levelList;
            if (levelList.getValue().getName().equals(name)) {
                levelList = levelList.getNext();
                return;
            }
            while (current != null){
                if (current.getNext() != null && current.getNext().getValue().getName().equals(name)) {
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current = current.getNext();
            }
        }
    }
    public Player getPlayer() {
        return player;
    }
    
    public String getUI() {
        return this.getCurrentLevel().getName() + " - " + this.player.getHP() + "/" + this.player.getMaxHP() + " - "
        + this.displayString;
    }


    public Level getCurrentLevel() {
        return this.currentLevel;
    }
    
    public void loadLevel(Level level) {
        this.currentLevel = level;
        this.player.getLocation().setX(level.getPlayerStartLocation().getX());
        this.player.getLocation().setY(level.getPlayerStartLocation().getY());
        this.currentLevel.getDynamicObjects().removeIf(GameObject::isPlayer); // prevents the player from being in the level more than once
        this.currentLevel.getDynamicObjects().add(this.player);
    }

    public void update(long timestamp) {
        if (this.lastUpdate != 0) {
            double dt = (timestamp - this.lastUpdate) / 1000000000.0;
            this.currentLevel.update(dt);
            if (this.player.isDestroyed()) {
                this.player.setHP(this.player.getMaxHP());
                this.player.revive();
                this.loadLevel(this.currentLevel);
            }
        }
        this.lastUpdate = timestamp;
    }

    public void advanceLevelHelper(LinkedListNode<Level> level){
        if (level.getNext() == null){
            return;
        }
        if (this.getCurrentLevel().getName().equals(level.getValue().getName())) {
            this.loadLevel(level.getNext().getValue());
        }else{
            advanceLevelHelper(level.getNext() );
        }
    }

    public void advanceLevel(){
        if (this.levelList == null){
            return;
        }else{
            advanceLevelHelper(levelList);
        }
    }


}
