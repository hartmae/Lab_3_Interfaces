import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(0, 0, 1, 1));
        rectangles.add(new Rectangle(0, 0, 2, 1));
        rectangles.add(new Rectangle(0, 0, 2, 2));
        rectangles.add(new Rectangle(0, 0, 3, 2));
        rectangles.add(new Rectangle(0, 0, 3, 3));
        rectangles.add(new Rectangle(0, 0, 4, 3));
        rectangles.add(new Rectangle(0, 0, 4, 4));
        rectangles.add(new Rectangle(0, 0, 5, 4));
        rectangles.add(new Rectangle(0, 0, 5, 5));
        rectangles.add(new Rectangle(0, 0, 6, 5));

        BigRectangleFilter filter = new BigRectangleFilter();

        System.out.println("All rectangles:");
        for (Rectangle rect : rectangles) {
            int perimeter = 2 * (rect.width + rect.height);
            System.out.println("Rectangle [width=" + rect.width + ", height=" + rect.height + "] - Perimeter: " + perimeter);
        }

        System.out.println("\nRectangles with perimeter > 10:");
        for (Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                int perimeter = 2 * (rect.width + rect.height);
                System.out.println("Rectangle [width=" + rect.width + ", height=" + rect.height + "] - Perimeter: " + perimeter);
            }
        }
    }
}