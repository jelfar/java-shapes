/**
  * Definition for a rectangle. Implements shape.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class Rectangle implements Shape {

    private int width;
    private int height;
    private Point position;
    private Color color;
    private boolean isFilled;

    /**
      * Constructor.
      *
      * @param w                    The width of the rectangle.
      * @param h                    The height of the rectangle.
      * @param p                    The position of the rectangle- lower left corner.
      * @param c                    The color of the rectangle.
      * @param f                    Whether or not the rectangle is filled
      */
    public Rectangle(int w, int h, Point p, Color c, boolean f) {
        width = w;
        height = h;
        position = p;
        color = c;
        isFilled = f;
    }

    /**
      * Calculates and returns the area of the rectangle.
      *
      * @return                 The area of the rectangle.
      */
    public double getArea(){
        return width * height;
    }

    /**
      * Returns the color of the rectangle.
      */
    public Color getColor(){
        return color;
    }

    /**
      * Sets the color of the rectangle.
      *
      * @param c                    The color of the rectangle.
      */
    public void setColor(Color c){
        color = c;
    }

    /**
      * Returns true if the rectangle is filled with color, otherwise false (rectangle is wire-framed).
      *
      * @return                 Whether the rectangle is filled or not.
      */
    public boolean getFilled(){
        return isFilled;
    }

    /**
      * Sets the filled state of the rectangle to the specified value.
      *
      * @param filled                   Whether the rectangle is filled or not.
      */
    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    /**
      * Returns the currrent position of the rectangle.
      *
      * @return                 The current position of the rectangle.
      */
    public Point getPosition(){
        return position;
    }

    /**
      * Changes the position of the rectangle to the specfied Point.
      *
      * @param p                 The position to move the rectangle to.
      */
    public void setPosition(Point p){
       position = p;
    }

    /**
      * Moves the shape by the x and y amounts specified (in the Point delta).
      *
      * @param delta                   The x and y delta of the position to move the rectangle to. 
      */
    public void move(Point delta){
        position = new Point((int)(position.getX() + delta.getX()), (int)(position.getY() + delta.getY()));
    }

    /**
      * Gets the width of the rectangle.
      *
      * @return                 The width of the rectangle.
      */
    public int getWidth() {
        return width;
    }

    /**
      * Gets the height of the rectangle.
      *
      * @return                 The width of the rectangle.
      */
    public int getHeight() {
        return height;
    }

    /**
      * Sets the width of the rectangle.
      *
      * @param w                    The width to set the rectangle to.
      */
    public void setWidth(int w) {
        width = w;
    }

    /**
      * Sets the height of the rectangle.
      *
      * @param h                    The height to set the rectangle to.
      */
    public void setHeight(int h) {
        height = h;
    }

    /**
      * Testing equality between two rectangles.
      *
      * @return                 Returns whether this Rectangle is equal to o.
      *                         Checks width, height, position, color, is filled variables.
      */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Shape))
            return false;

        Rectangle r = (Rectangle)o;
        
        return (height == r.getHeight()) &&
               (width == r.getWidth()) &&
               (position.equals(r.getPosition())) &&
               (color.equals(r.getColor())) &&
               (isFilled == r.getFilled());
    }
    
}
