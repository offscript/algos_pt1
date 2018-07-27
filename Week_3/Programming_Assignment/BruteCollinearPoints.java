public class BruteCollinearPoints {
   public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   {
       for (Point i : points) {
         if (i.hasNext()) System.out.println("!");
       }
   
   }
   public int numberOfSegments()        // the number of line segments
   {}
   public LineSegment[] segments()                // the line segments
   {}
}
