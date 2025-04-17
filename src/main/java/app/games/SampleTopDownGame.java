package app.games;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Goal;
import app.games.commonobjects.Potion;
import app.games.topdownobjects.*;
import app.games.commonobjects.Wall;

public class SampleTopDownGame extends Game {
    public SampleTopDownGame() {
        super();
    }

    public void init() {
        this.addLevel(levelWithCollectables());
        this.addLevel(levelZero());
        this.addLevel(levelOne());
        this.addLevel(levelTwo());
        this.loadLevel(levelWithCollectables());
    }
    public Level levelWithCollectables(){
        Level level = new TopDownLevel(this, 11, 11, "levelWithCollectables!");

        level.getStaticObjects().add(new Goal(9, 5, this));

        level.getPlayerStartLocation().setX(1.0);
        level.getPlayerStartLocation().setY(5.0);

        Enemy e1 = new Enemy(new Vector2D(8,1));
        e1.setDecisionTree(null);
        level.getDynamicObjects().add(e1);

        Enemy e2 = new Enemy(new Vector2D(8,9));
        e2.setDecisionTree(null);
        level.getDynamicObjects().add(e2);

        level.getDynamicObjects().add(new AxePickup(new Vector2D(4,4)));

        level.getDynamicObjects().add(new MagicPickup(new Vector2D(4,6)));

        level.getDynamicObjects().add(new PotionPickup(new Vector2D(4,2), 7));

        level.getDynamicObjects().add(new PotionPickup(new Vector2D(4,8), 2));

        return level;
    }
    public Level levelZero() {
        Level firstLevel = new TopDownLevel(this, 12, 8, "level0");
        firstLevel.getStaticObjects().add(new Wall(4, 1));
        firstLevel.getStaticObjects().add(new Wall(4, 2));
        firstLevel.getStaticObjects().add(new Wall(4, 3));
        firstLevel.getStaticObjects().add(new Wall(4, 4));
        firstLevel.getStaticObjects().add(new Wall(5, 4));
        firstLevel.getStaticObjects().add(new Wall(6, 4));
        firstLevel.getStaticObjects().add(new Wall(7, 4));
        firstLevel.getStaticObjects().add(new Wall(8, 4));
        firstLevel.getStaticObjects().add(new Tower(10, 1));
        firstLevel.getStaticObjects().add(new Goal(6, 2, this));
        firstLevel.getPlayerStartLocation().setX(2.0);
        firstLevel.getPlayerStartLocation().setY(2.0);

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 1.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 5.0)));
        return firstLevel;
    }

    public Level levelOne() {
        Level firstLevel = new TopDownLevel(this, 12, 9, "level1");
        firstLevel.getStaticObjects().add(new Goal(7, 4, this));
        firstLevel.getPlayerStartLocation().setX(2.0);
        firstLevel.getPlayerStartLocation().setY(4.0);

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 3.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 4.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 5.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(5.0, 6.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(6.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(7.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 6.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 6.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 5.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 4.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 3.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(9.0, 2.0)));

        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(8.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(7.0, 2.0)));
        firstLevel.getDynamicObjects().add(new Enemy(new Vector2D(6.0, 2.0)));

        return firstLevel;
    }

    public Level levelTwo() {
        Level firstLevel = new TopDownLevel(this, 17, 9, "level2");


        firstLevel.getStaticObjects().add(new Wall(2, 2));
        firstLevel.getStaticObjects().add(new Wall(2, 3));
        firstLevel.getStaticObjects().add(new Wall(2, 4));
        firstLevel.getStaticObjects().add(new Wall(2, 5));
        firstLevel.getStaticObjects().add(new Wall(2, 6));

        firstLevel.getStaticObjects().add(new Wall(3, 5));

        firstLevel.getStaticObjects().add(new Wall(4, 4));

        firstLevel.getStaticObjects().add(new Wall(5, 5));

        firstLevel.getStaticObjects().add(new Wall(6, 2));
        firstLevel.getStaticObjects().add(new Wall(6, 3));
        firstLevel.getStaticObjects().add(new Wall(6, 4));
        firstLevel.getStaticObjects().add(new Wall(6, 5));
        firstLevel.getStaticObjects().add(new Wall(6, 6));

        firstLevel.getStaticObjects().add(new Wall(8, 2));
        firstLevel.getStaticObjects().add(new Wall(8, 3));
        firstLevel.getStaticObjects().add(new Wall(8, 4));
        firstLevel.getStaticObjects().add(new Wall(8, 5));
        firstLevel.getStaticObjects().add(new Wall(8, 6));

        firstLevel.getStaticObjects().add(new Wall(10, 2));
        firstLevel.getStaticObjects().add(new Wall(10, 3));
        firstLevel.getStaticObjects().add(new Wall(10, 4));
        firstLevel.getStaticObjects().add(new Wall(10, 5));
        firstLevel.getStaticObjects().add(new Wall(10, 6));

        firstLevel.getStaticObjects().add(new Wall(11, 3));

        firstLevel.getStaticObjects().add(new Wall(12, 4));

        firstLevel.getStaticObjects().add(new Wall(13, 5));

        firstLevel.getStaticObjects().add(new Wall(14, 2));
        firstLevel.getStaticObjects().add(new Wall(14, 3));
        firstLevel.getStaticObjects().add(new Wall(14, 4));
        firstLevel.getStaticObjects().add(new Wall(14, 5));
        firstLevel.getStaticObjects().add(new Wall(14, 6));

        firstLevel.getPlayerStartLocation().setX(4.0);
        firstLevel.getPlayerStartLocation().setY(2.0);

        return firstLevel;
    }
}
