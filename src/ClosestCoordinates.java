

import java.io.*;
import java.util.ArrayList;

public class ClosestCoordinates {

    //Variables
    String inputPath;
    String outputPath;
    Coordinate firstResult;
    Coordinate secondResult;
    String archievePath;
    ArrayList<Coordinate> coorList = new ArrayList<>();
    ArrayList<Coordinate> coorListSorted = new ArrayList<>();
    double minimumDistance = Double.MAX_VALUE;


    public ClosestCoordinates() {
        this.inputPath = System.getProperty("user.dir")+"/Input/input.txt";
        this.outputPath = System.getProperty("user.dir")+"/Output/outputTemp.txt";
    }

    void findClosestCoordinates() throws Exception {

        System.out.print("findClosestCoordinates is starting");
        readInputFile(inputPath);

        if(coorList.size() == 1){
            firstResult = coorList.get(0);
            secondResult = coorList.get(0);
        }
        else{
            for(int i=0; i<coorList.size();i++){
                for(int j=i+1; j<coorList.size(); j++){
                    double distance =0;
                    for(int k=0; k<coorList.get(i).coordinates.size(); k++){
                        distance += Math.pow(coorList.get(i).coordinates.get(k) - coorList.get(j).coordinates.get(k),2);
                    }
                    distance = Math.sqrt(distance);

                    if(distance < minimumDistance){
                        minimumDistance = distance;
                        firstResult = coorList.get(i);
                        secondResult = coorList.get(j);
                    }
                }
            }
        }


        writeOutputFile(outputPath);
        System.out.print("findClosestCoordinates end");
    }

    void readInputFile(String fileDirectory) throws Exception{
        String line;
        int index = 0;
        ArrayList<Double> tempCoordinates;
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader(new File(fileDirectory)));

            while((line = buffReader.readLine())!= null){
                tempCoordinates = new ArrayList<>();
                String[] lineCoordinates = line.split("\\t");

                for(int i = 0; i<lineCoordinates.length; i++){
                    tempCoordinates.add(Double.parseDouble(lineCoordinates[i]));
                }
                coorList.add(new Coordinate(++index,tempCoordinates));
                coorListSorted.add(new Coordinate(index,tempCoordinates));
            }
            buffReader.close();

        }
        catch(Exception ex){
            throw ex;
        }
    }
    void writeOutputFile(String outputDirectory) throws Exception{
        String line ;
        String line2 ;

        try{
            File outputFile = new File(outputDirectory);
            outputFile.createNewFile();
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outputFile));

            line = "Line #"+firstResult.lineNumber + " :";
            for(int i=0; i<firstResult.coordinates.size(); i++){
                line += firstResult.coordinates.get(i) + "\t";
            }

            line2 = "Line #"+ secondResult.lineNumber + " :";
            for(int i=0; i<secondResult.coordinates.size(); i++){
                line2 += secondResult.coordinates.get(i) + "\t";
            }

            if(firstResult.lineNumber < secondResult.lineNumber){
                buffWriter.write(line);
                buffWriter.newLine();
                buffWriter.write(line2);
            }
            else{
                buffWriter.write(line2);
                buffWriter.newLine();
                buffWriter.write(line);
            }

            buffWriter.close();
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
