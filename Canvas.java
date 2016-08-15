/**
  * A simple canvas to use with the variety of shapes.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.util.ArrayList;
public class Canvas {
    private ArrayList<Shape> shapes;

    /**
      * Default Constructor.
      */
    public Canvas(){
        shapes = new ArrayList<Shape>();
    }

    /**
      * Adds objects which implement the Shape interface to the end of the Canvas's java.util.ArrayList<Shape>  instance variable.
      *
      * @param shape                    The shape object to add to shapes.
      */
    public void add(Shape shape){
        shapes.add(shape);
    }

    /**
      * Removes the Shape at the specified index and returns a reference to it or null if the index is out-of-bounds.
      *
      * @param index                    The index of the shape to remove.
      *
      * @return                         The shape at the removed index or null
      *                                 if the index is out of bounds.
      */
    public Shape remove(int index){
        if(index >= shapes.size() || index < 0)
            return null;

        return shapes.remove(index);
    }

    /**
      * Returns the ith Shape object from Canvas.
      *
      * @param index                    The index of the shape to return.
      *
      * @return                         The shape at the specified index.
      */
    public Shape get(int index) {
        return shapes.get(index);
    }

    /**
      * Returns the number of Shapes contained by the Canvas.
      *
      * @return                         The number of shapes.
      */
    public int size(){
        return shapes.size();
    }

    /**
      * Returns a java.util.ArrayList of all of the Circle objects contained in the Canvas.
      *
      * @return                         A list of the circle objects.
      */
    public ArrayList<Circle> getCircles(){
        ArrayList<Circle> list = new ArrayList<Circle>();
        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof Circle)
                list.add((Circle)shapes.get(i));
        }
        return list;
    }

    /**
      * Returns a java.util.ArrayList of all of the Rectangle objects contained in the Canvas.
      *
      * @return                         A list of the rectangle objects.
      */
    public ArrayList<Rectangle> getRectangles(){
        ArrayList<Rectangle> list = new ArrayList<Rectangle>();
        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof Rectangle)
                list.add((Rectangle)shapes.get(i));
        }

        return list;
    }

    /**
      * Returns a java.util.ArrayList of all of the Triangle objects contained in the Canvas.
      *
      * @return                         A list of the triangle objects.
      */
    public ArrayList<Triangle> getTriangles(){
        ArrayList<Triangle> list = new ArrayList<Triangle>();
        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof Triangle)
                list.add((Triangle)shapes.get(i));
        }

        return list;
    }

    /**
      * Returns a java.util.ArrayList of all of the ConvexPolygon objects contained in the Canvas. 
      *
      * @return                         A list of the ConvexPolygon objects.
      */
    public ArrayList<ConvexPolygon> getConvexPolygons(){
        ArrayList<ConvexPolygon> list = new ArrayList<ConvexPolygon>();
        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof ConvexPolygon)
                list.add((ConvexPolygon)shapes.get(i));
        }

        return list;
    }

    /**
      * Returns a java.util.ArrayList of all Shape objects in the Canvas that match the specified java.awt.Color.
      *
      * @param color                    The color of the shapes to find.
      *
      * @return                         A list of the shapes with the specified color.
      */
    public ArrayList<Shape> getShapesByColor(Color color){
        ArrayList<Shape> list = new ArrayList<Shape>();
        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i).getColor().equals(color))
                list.add(shapes.get(i));
        }

        return list;
    }

    /**
      * Returns the sum of the area of all Shape objects in the Canvas.
      *
      * @return                         The sum of the area of all the shapes.
      */
    public double getAreaOfAllShapes(){
        double sum = 0;
        for(int i = 0; i < shapes.size(); i++)
            sum += shapes.get(i).getArea();

        return sum;
    }

}
