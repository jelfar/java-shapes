/**
  * Definition for a triangle. Implements shape.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class Triangle implements Shape {

    private Point v1;
    private Point v2;
    private Point v3;
    private Color color;
    private boolean isFilled;

    /**
      * Constructor.
      *
      * @param a                    The first point of the triangle. This represents position.
      * @param b                    The second point of the triangle.
      * @param c                    The third point of the triangle.
      * @param col                  The color of the triangle.
      * @param f                    Whether or not the triangle is filled
      */
    public Triangle(Point a, Point b, Point c, Color col, boolean f) {
        v1 = a;
        v2 = b;
        v3 = c;
        color = col;
        isFilled = f;
    }

    /**
      * Calculates and returns the area of the triangle.
      *
      * @return                 The area of the triangle.
      */
    public double getArea(){
        /** Finding all the lengths of the sides using the distance formula */
        double side1 = Math.sqrt(Math.pow(Math.abs(v1.getX() - v2.getX()), 2) + Math.pow(Math.abs(v1.getY() - v2.getY()), 2));
        double side2 = Math.sqrt(Math.pow(Math.abs(v2.getX() - v3.getX()), 2) + Math.pow(Math.abs(v2.getY() - v3.getY()), 2));
        double side3 = Math.sqrt(Math.pow(Math.abs(v1.getX() - v3.getX()), 2) + Math.pow(Math.abs(v1.getY() - v3.getY()), 2));

       /** Now using Heron's formula to find the area of a general rectangle */ 
       double semiperimeter = (side1 + side2 + side3) / 2;
       return Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
    }

    /**
      * Returns the color of the triangle.
      */
    public Color getColor(){
        return color;
    }

    /**
      * Sets the color of the triangle.
      *
      * @param c                    The color of the triangle.
      */
    public void setColor(Color c){
        color = c;
    }

    /**
      * Returns true if the triangle is filled with color, otherwise false (triangle is wire-framed).
      *
      * @return                 Whether the triangle is filled or not.
      */
    public boolean getFilled(){
        return isFilled;
    }

    /**
      * Sets the filled state of the triangle to the specified value.
      *
      * @param filled                   Whether the triangle is filled or not.
      */
    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    /**
      * Returns the currrent position of the triangle.
      *
      * @return                 The current position of the triangle.
      */
    public Point getPosition(){
        return v1;
    }

    /**
      * Changes the position of the triangle to the specfied Point.
      *
      * @param p                 The position to move the triangle to.
      */
    public void setPosition(Point p){
        /** Finds the delta between point p and the first vertex */
       Point delta = new Point((int)(p.getX() - v1.getX()), (int)(p.getY() - v1.getY()));
       this.move(delta);
    }

    /**
      * Moves the triangle by the x and y amounts specified (in the Point delta).
      *
      * @param delta                   The x and y delta of the position to move the triangle to. 
      */
    public void move(Point delta){
        v1 = new Point((int)(v1.getX() + delta.getX()), (int)(v1.getY() + delta.getY()));
        v2 = new Point((int)(v2.getX() + delta.getX()), (int)(v2.getY() + delta.getY()));
        v3 = new Point((int)(v3.getX() + delta.getX()), (int)(v3.getY() + delta.getY()));
    }

    /**
      * Gets the vertex A.
      *
      * @return                 The first vertex Point.
      */
    public Point getVertexA() {
        return v1;
    }

    /**
      * Gets the vertex B.
      *
      * @return                 The second vertex Point.
      */
    public Point getVertexB() {
        return v2;
    }

    /**
      * Gets the vertex C.
      *
      * @return                 The third vertex Point.
      */
    public Point getVertexC() {
        return v3;
    }

    /**
      * Sets the vertex A.
      */
    public void setVertexA(Point p) {
        v1 = p;
    }

    /**
      * Sets the vertex B.
      */
    public void setVertexB(Point p) {
        v2 = p;
    }

    /**
      * Sets the vertex C.
      */
    public void setVertexC(Point p) {
        v3 = p;
    }

    /**
      * Testing equality between two triangles.
      *
      * @return                 Returns whether this triangle is equal to o.
      *                         Checks three vertices, color, isFilled variables.
      */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Shape))
            return false;

        Triangle t = (Triangle)o;
        
        return (v1.equals(t.getVertexA())) &&
               (v2.equals(t.getVertexB())) &&
               (v3.equals(t.getVertexC())) &&
               (color.equals(t.getColor())) &&
               (isFilled == t.getFilled());
    }

}
