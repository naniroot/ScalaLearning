//Conway Game of Life
// X => Alive
// O => dead

import util.Random.nextInt

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
        val iterations = 3
        getConway(mainArray, numRows, numCols, iterations)
    }
    def getConway(mainArray:Array[Array[String]], numRows: Int, numCols: Int, iterations: Int) : Unit = {
        for(k <- 0 to iterations-1){
            printf("Printing for iteration %d\n", k+1)
            for(i<- 0 to numRows-1){
                for(j<-0 to numCols-1){

                }
            }
        }
    }
    def getNeighbourCount(mainArray:Array[Array[String]], numRows: Int, numCols: Int, row: Int, col: Int) : Int = {
        var totalNeighborsAlive = 0
        if()
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