import java.util.ArrayList;

public class Coordinate {

    int lineNumber;
    ArrayList<Double> coordinates;

    public Coordinate(int lineNumber, ArrayList<Double> coordinates){
        this.lineNumber = lineNumber;
        this.coordinates = coordinates;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
