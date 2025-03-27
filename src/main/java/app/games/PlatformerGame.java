package app.games;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Goal;
import app.games.commonobjects.Potion;
import app.games.platformerobjects.PlatformerLevel;
import app.games.platformerobjects.PlatformerWall;
import app.games.platformerobjects.Spike;

public class PlatformerGame extends Game {
    @Override
    public void init(){
        this.addLevel(levelOne());
        this.addLevel(levelTwo());
        this.addLevel(extraLevelDX());
        this.addLevel(EndingLevel());
        this.loadLevel(levelOne());
    }
    public Level levelOne(){

        Level level = new PlatformerLevel(this, 10, 10, "platformer_1");

        level.getStaticObjects().add(new PlatformerWall(1,7));
        level.getStaticObjects().add(new PlatformerWall(2,7));
        level.getStaticObjects().add(new PlatformerWall(3,7));

        level.getStaticObjects().add(new Goal(1, 6, this));

        level.getPlayerStartLocation().setX(5.0);
        level.getPlayerStartLocation().setY(7.0);


        return level;
    }

    public Level levelTwo(){

        Level level = new PlatformerLevel(this, 10, 10, "platformer_2");

        level.getStaticObjects().add(new PlatformerWall(1,6));
        level.getStaticObjects().add(new PlatformerWall(2,6));
        level.getStaticObjects().add(new PlatformerWall(3,6));

        level.getStaticObjects().add(new PlatformerWall(6,5));
        level.getStaticObjects().add(new PlatformerWall(7,5));
        level.getStaticObjects().add(new PlatformerWall(8,5));

        level.getStaticObjects().add(new Goal(7, 4, this));

        level.getPlayerStartLocation().setX(5.0);
        level.getPlayerStartLocation().setY(7.0);


        return level;
    }

    public Level extraLevelDX(){
        Level level = new PlatformerLevel(this, 12, 12, "spikes and such");

        level.getStaticObjects().add(new PlatformerWall(4,3));
        level.getStaticObjects().add(new PlatformerWall(5,3));
        level.getStaticObjects().add(new PlatformerWall(6,3));

        level.getDynamicObjects().add(new Potion(new Vector2D(5,2), 7));

        level.getStaticObjects().add(new PlatformerWall(4,7));
        level.getStaticObjects().add(new PlatformerWall(5,7));
        level.getStaticObjects().add(new PlatformerWall(6,7));

        level.getDynamicObjects().add(new Potion(new Vector2D(5,6), -5));

        level.getStaticObjects().add(new PlatformerWall(2,6));
        level.getStaticObjects().add(new PlatformerWall(1,9));




        level.getStaticObjects().add(new PlatformerWall(9,9));
        level.getStaticObjects().add(new PlatformerWall(10,9));
        level.getStaticObjects().add(new PlatformerWall(9,10));
        level.getStaticObjects().add(new PlatformerWall(10,10));





        level.getStaticObjects().add(new Spike(1,10));
        level.getStaticObjects().add(new Spike(2,10));
        level.getStaticObjects().add(new Spike(3,10));
        level.getStaticObjects().add(new Spike(4,10));
        level.getStaticObjects().add(new Spike(5,10));
        level.getStaticObjects().add(new Spike(6,10));
        level.getStaticObjects().add(new Spike(7,10));
        level.getStaticObjects().add(new Spike(8,10));



        level.getStaticObjects().add(new Goal(1, 8, this));

        level.getPlayerStartLocation().setX(9.5);
        level.getPlayerStartLocation().setY(7);



        return level;
    }

    public Level EndingLevel(){

        Level level = new PlatformerLevel(this, 10, 10, "platformer_Win_:)");
        level.getStaticObjects().add(new PlatformerWall(8,1));
        level.getStaticObjects().add(new PlatformerWall(1,1));


        level.getStaticObjects().add(new PlatformerWall(3,2));
        level.getStaticObjects().add(new PlatformerWall(3,3));

        level.getStaticObjects().add(new PlatformerWall(6,2));
        level.getStaticObjects().add(new PlatformerWall(6,3));


        level.getStaticObjects().add(new PlatformerWall(2,5));
        level.getStaticObjects().add(new PlatformerWall(3,6));
        level.getStaticObjects().add(new PlatformerWall(3,7));
        level.getStaticObjects().add(new PlatformerWall(4,7));
        level.getStaticObjects().add(new PlatformerWall(5,7));
        level.getStaticObjects().add(new PlatformerWall(6,7));
        level.getStaticObjects().add(new PlatformerWall(6,6));
        level.getStaticObjects().add(new PlatformerWall(7,5));

        level.getStaticObjects().add(new PlatformerWall(8,8));
        level.getStaticObjects().add(new PlatformerWall(1,8));


        level.getPlayerStartLocation().setX(4.5);
        level.getPlayerStartLocation().setY(5.0);


        return level;
    }
}
