public class BruteCollinearPoints {
   public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   {
       for (int i = 0; i < points.length; i++) {
           for (int j = 1; j < points.length; j++) {
               for (int k = 2; k < points.length; j++) {
                   //I'd use slope order here but idk how
                   if points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])
                       for (int l == 3; l < points.length; l++) {
                       if points[i].slopeTo(points[l]) == points[i].slopeTo(points[k])
                           LineSegment segment = new LineSegment(point[i],point[l]);
                   }
               }
           }
       }
   }
   public int numberOfSegments()        // the number of line segments
   {}
   public LineSegment[] segments()                // the line segments
   {}
}
