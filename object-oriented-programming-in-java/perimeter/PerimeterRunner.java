import edu.duke.*;
import java.io.File;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints(Shape s) {
        int totalPoints = 0;
        for (Point currPt : s.getPoints()) {
            totalPoints += 1;
        }
        return totalPoints;
    }
    
    public double getLargestSide(Shape s) {
        double largestSide = 0;
        
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if (currDist > largestSide) {
                largestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        
        return largestSide;
    }
    
    public double getAverageLength(Shape s) {
        return getPerimeter(s) / getNumPoints(s);
    }
    
    public double getLargestX(Shape s) {
        double largestX = 0;
        
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currX = currPt.getX();
            // Update totalPerim by currDist
            if (currX > largestX) {
                largestX = currX;
            }
        }
        
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        
        double largestPerim = 0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                largestPerim = currPerim;
            }
        }
        
        return largestPerim;
    }
    
    public File getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        
        File largestFile = null;
        double largestPerim = 0;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim) {
                largestPerim = currPerim;
                largestFile = f;
            }
        }
        
        return largestFile;
    }
    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int totalPoints = getNumPoints(s);
        System.out.println("totalPoints = " + totalPoints);
        double averageLength = getAverageLength(s);
        System.out.println("averageLength = " + averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("largestSide = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("largestX = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("largestPerim = " + largestPerim);
        File largestFile = getFileWithLargestPerimeter();
        System.out.println("largestFile = " + largestFile.getName());
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        // pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
