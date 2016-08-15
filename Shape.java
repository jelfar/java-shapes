/**
  * This is the interface for shapes;
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;

public interface Shape {

    /**
      * Calculates and returns the area of the shape.
      */
    public double getArea();

    /**
      * Returns the color of the shape.
      */
    public Color getColor();

    /**
      * Sets the color of the shape.
      *
      * @param color                    The color of the shape.
      */
    public void setColor(Color color);

    /**
      * Returns true if the shape is filled with color, otherwise false (shape is wire-framed).
      */
    public boolean getFilled();

    /**
      * Sets the filled state of the shape to the specified value.
      *
      * @param filled                   Whether the shape is filled or not.
      */
    public void setFilled(boolean filled);

    /**
      * Returns the currrent position of the shape.
      */
    public Point getPosition();

    /**
      * Changes the position of the shape to the specfied Point.
      *
      * @param position                 The position to move the shape to.
      */
    public void setPosition(Point position);

    /**
      * Moves the shape by the x and y amounts specified (in the Point delta).
      *
      * @param delta                   The x and y delta of the position to move the shape to. 
      */
    public void move(Point delta);

}
