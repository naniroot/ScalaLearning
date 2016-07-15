//Conway Game of Life
// X => Alive
// O => dead

import util.Random.nextInt
import java.lang.Math._;

object Conway{
    def main(args: Array[String]){
    	var numRows = 10
    	var numCols = 10
        var mainArray = Array.ofDim[String](numRows, numCols)
        for(i <- 0 to numRows-1){
        	for(j <- 0 to numCols-1){
        		mainArray(i)(j) = getRandomChar()
        	}
        }
        println("Initial Matrix")
        printMatrix(mainArray, numRows, numCols)
        val iterations = 10
        getConway(mainArray, numRows, numCols, iterations)
    }
    def getConway(mainArray:Array[Array[String]], numRows: Int, numCols: Int, iterations: Int) : Unit = {
        for(k <- 0 to iterations-1){
            var nextArray = Array.ofDim[String](numRows, numCols)
            printf("Printing for iteration %d\n", k+1)
            for(i<- 0 to numRows-1){
                for(j<-0 to numCols-1){
                    var countOfAliveNeighbors = getNeighbourCount(mainArray, numRows, numCols, i, j)
                    //printf("The number of neighbors are %d\n", countOfAliveNeighbors)
                    if(mainArray(i)(j) == "O"){
                        if(countOfAliveNeighbors == 3){
                            nextArray(i)(j) = "X"
                        } else {
                            nextArray(i)(j) = "O"
                        }
                    } else { // the value is an "X" 
                        if(countOfAliveNeighbors < 2){
                            nextArray(i)(j) = "O"
                        } else if(countOfAliveNeighbors == 2 || countOfAliveNeighbors == 3){
                            nextArray(i)(j) = "X"
                        } else {
                            nextArray(i)(j) = "O"
                        }
                    }
                }
            }
            printMatrix(nextArray, numRows, numCols)
            //Copy one matrix to another, the really dumb way
            for(i <- 0 to numRows-1){
                for(j <- 0 to numCols-1){
                    mainArray(i)(j) = nextArray(i)(j)
                }
            }
            }
    }
    def getNeighbourCount(mainArray:Array[Array[String]], numRows: Int, numCols: Int, row: Int, col: Int) : Int = {
        var totalNeighborsAlive = 0
        if(numRows>0){
            for(x <- Math.max(0, row-1) to Math.min(row+1, numRows-1)){
                for(y <- Math.max(0, col-1) to Math.min(col+1, numCols-1)){
                    if(x != row || y != col){
                        if(mainArray(x)(y) == "X"){
                            totalNeighborsAlive += 1
                        }
                    }
                }
            }
        }
        totalNeighborsAlive
    }
    def printMatrix(mainArray:Array[Array[String]], numRows: Int, numCols: Int) : Unit = {
        for(i <- 0 to numRows-1){
            println("")
            for(j <- 0 to numCols-1){
                printf(mainArray(i)(j))
            }
        }
        println("")
    }
    def getRandomChar() : String = {
        var randomValue: Int = nextInt
        val xChar: String = "X"
        val oChar: String = "O"
        if(randomValue%2 == 0){
            return xChar
        }
        oChar
    }
}