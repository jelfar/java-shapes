/**
  * Definition for a ConvexPolygon. Implements shape.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class ConvexPolygon implements Shape {

    private Point[] vertices;
    private Color color;
    private boolean isFilled;

    /**
      * Constructor.
      *
      * @precondition               The vertices be provided in counter-clockwise order. 
      *                             This precondion is required so that the area calculation will work correctly.
      * @precondition               The polygon is not closed. This means that the first and 
      *                             last point are not the same point (no duplicate points).
      *
      * @param points               The vertices in an array.
      * @param col                  The color of the ConvexPolygon.
      * @param f                    Whether or not the ConvexPolygon is filled
      */
    public ConvexPolygon(Point[] points, Color col, boolean f) {
        vertices = points;
        color = col;
        isFilled = f;
    }

    /**
      * Calculates and returns the area of the ConvexPolygon. Uses the matrix method.
      *
      * @return                 The area of the ConvexPolygon.
      */
    public double getArea(){
        double sum = 0;
        for(int i = 0; i < vertices.length; i++){
            if(i == vertices.length-1)
                sum += (vertices[i].getX() * vertices[0].getY()) - (vertices[i].getY() * vertices[0].getX());
            else
                sum += (vertices[i].getX() * vertices[i+1].getY()) - (vertices[i].getY() * vertices[i+1].getX());
        }
        
        return sum/2;
    }

    /**
      * Returns the color of the ConvexPolygon.
      */
    public Color getColor(){
        return color;
    }

    /**
      * Sets the color of the ConvexPolygon.
      *
      * @param c                    The color of the ConvexPolygon.
      */
    public void setColor(Color c){
        color = c;
    }

    /**
      * Returns true if the ConvexPolygon is filled with color, otherwise false (ConvexPolygon is wire-framed).
      *
      * @return                 Whether the ConvexPolygon is filled or not.
      */
    public boolean getFilled(){
        return isFilled;
    }

    /**
      * Sets the filled state of the ConvexPolygon to the specified value.
      *
      * @param filled                   Whether the ConvexPolygon is filled or not.
      */
    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    /**
      * Returns the currrent position of the ConvexPolygon.
      *
      * @return                 The current position of the ConvexPolygon.
      */
    public Point getPosition(){
        return vertices[0];
    }

    /**
      * Changes the position of the ConvexPolygon to the specfied Point.
      *
      * @param p                 The position to move the ConvexPolygon to.
      */
    public void setPosition(Point p){
       /** Finds the delta between the position point(first point of array) and the point p */
       Point delta = new Point((int)(p.getX() - vertices[0].getX()), (int)(p.getY() - vertices[0].getY()));
       this.move(delta);
    }

    /**
      * Moves the shape by the x and y amounts specified (in the Point delta).
      *
      * @param delta                   The x and y delta of the position to move the ConvexPolygon to. 
      */
    public void move(Point delta){
        for(int i = 0; i < vertices.length; i++){
            vertices[i] = new Point((int)(vertices[i].getX() + delta.getX()), (int)(vertices[i].getY() + delta.getY()));
        }
    }

    /**
      * Gets the vertex at the specified index.
      *
      * @param index                    The index to look up.
      *
      * @return                         The specified index.
      */
    public Point getVertex(int index) {
        return vertices[index];
    }

    /**
      * Sets the vertex at the specified index.
      *
      * @param index                The index to change.
      * @param vertex               The value to set.
      */
    public void setVertex(int index, Point vertex) {
        vertices[index] = vertex;
    }

    /**
      * Testing equality between two ConvexPolygons.
      *
      * @return                 Returns whether this ConvexPolygon is equal to o.
      *                         Checks vertices, color, isFilled variables.
      */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Shape))
            return false;

        ConvexPolygon cp = (ConvexPolygon)o;
        
        for(int i = 0; i < vertices.length; i++){
            if(!vertices[i].equals(cp.getVertex(i)))
                return false;
        }

        return (color.equals(cp.getColor())) &&
               (isFilled == cp.getFilled());
    }
    
}
