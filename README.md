# Closest Coordinates

This Java program in the repository reads an Input.txt file under Input folder where each line contains the coordinates of 
multidimensional point and then looks for the closest pair of points in the line. If the program has found the closest 
pair of points, it creates a outputTemp.txt  file under Output Folder to show the closest 2 points.

The Input.txt should contain one point per line and the coordinate values in each line should be seperated by a tabulator 
character.

Algorithm in this program calculates distances amoung each point in order to find the shortest distance which is the square root
of the sum of squares of the dfferences of corresponging coordinates values.

The formula to find shortest distance : sqrt(sum_i((x_i-y_i)^2))

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. To get a copy of the project to your local machine run the code in below on your terminal.
```
$ git clone https://github.com/mertbozkurt/ClosestCoordinates.git
```

### Prerequisites


* There should be  one point per line  and  at least two points in input.txt
* In every line, coordinates should be separated by "\t". 
* There is no restriction for dimension and number of points


### Output

* outputTemp.txt file shows 2 points which have shortest distance to each other.
* Results are ordered according to line number in input.txt

## Authors

* **Mert Bozkurt**  - [Linkedin](https://www.linkedin.com/in/mert-bozkurt-2b3a4114/)

