import kotlin.math.pow

class Board(private val n: Int=3) {

    val start = "___"
    var board = Array(n) { Array(n) { start } }
    var GameOver = false
    var movecount = 0


    fun Drawboard() {
        for (row in board) {
            for (element in row) {
                if (element == start) {
                    print("|$element|")
                } else {
                    print("| $element |")
                }
            }
            println()
        }
    }


    fun placePiece(x: Int, y: Int, move: String) {
        if (!GameOver && board[x][y] == start) {
            board[x][y] = move
            movecount++
            Drawboard()
            GameOver = Win(x, y, move) || Draw()
            if (GameOver && !Draw()) {
                println("The winner is $currentPlayer!!")
            } else if (Draw()) {
                println("it's a tie!")
            }
        }
    }

   /* fun positionValid(x: Int, y: Int){
            while((board[x][y] != start) ) {
                println("already taken, please reenter position")
            }
     }*/

    fun Win(x: Int, y: Int, move: String): Boolean {

        for (i in 0 until n) {
            if (board[x][i] != move) {
                break
            }
            if (i == n - 1) {
                return true
            }
        }
        for (i in 0 until n) {
            if (board[i][y] != move) {
                break
            }
            if (i == n - 1) {
                return true
            }
        }
        if (x == y) {
            for (i in 0 until n) {
                if (board[i][i] != move) {
                    break
                }
                if (i == n - 1) {
                    return true
                }
            }
        }
        if (x + y == n - 1) {
            for (i in 0 until n) {
                if (board[i][(n - 1) - i] != move) {
                    break
                }
                if (i == n - 1) {
                    return true
                }
            }
        }

        return false
    }

    fun Draw(): Boolean {
        return (movecount == (n.toDouble().pow(2) ).toInt())
    }


}
