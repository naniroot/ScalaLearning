//Conway Game of Life

object Conway{
    def main(args: Array[String]){
    	var numRows = 10
    	var numCols = 10
        var mainArray = Array.ofDim[String](numRows, numCols)
        for(i <- 0 to numRows-1){
        	for(j <- 0 to numCols-1){
        		mainArray(i)(j) = "X"
        	}
        }

        for(i <- 0 to numRows-1){
        	println("")
        	for(j <- 0 to numCols-1){
        		printf(mainArray(i)(j))
        	}
        }
    }
}