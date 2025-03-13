package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;

public class Pathfinding {
    public static LinkedListNode<Vector2D> findPath(Vector2D start,Vector2D end){
        double startX = Math.floor(start.getX());
        double startY = Math.floor(start.getY());

        double endX = Math.floor(end.getX());
        double endY = Math.floor(end.getY());

        LinkedListNode<Vector2D> path = new LinkedListNode<>(new Vector2D(startX,startY),null);
        LinkedListNode<Vector2D> current = path;
        while(current.getValue().getX() != endX || current.getValue().getY() != endY){
            if (current.getValue().getX() < endX){
                path.append(new Vector2D(current.getValue().getX() + 1,current.getValue().getY()));
            }else if (current.getValue().getX() > endX){
                path.append(new Vector2D(current.getValue().getX() - 1,current.getValue().getY()));
            }else if (current.getValue().getY() < endY){
                path.append(new Vector2D(current.getValue().getX(),current.getValue().getY() + 1));
            }else if (current.getValue().getY() > endY){
                path.append(new Vector2D(current.getValue().getX(),current.getValue().getY() - 1));
            }
            current = current.getNext();
        }
        return path;
    }
}
