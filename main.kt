var board=Board()
var move=""
var currentPlayer = ""
const val move1="X"
const val move2="O"
var name1=""
var name2=""

fun printname():String {
    var name = ""
    var test = true
    name= readLine()!!.toString()
    var i = 0
    while ((i < name.length) and (test == true)) {
        if ((!(((name[i]) >= ('a')) and ((name[i]) <= ('z')))) and (!(((name[i]) >= ('A')) and ((name[i]) <= ('Z')))))  {
            test = false
            println("invalid name, please reenter your name")
            break
        }
        i++
    }
    while (test == false) {
        name= readLine()!!.toString()
        i = 0
        test = true
        while ((i < name.length) and (test == true)) {
            if ((!(((name[i]) >= ('a')) and ((name[i]) <= ('z')))) and (!(((name[i]) >= ('A')) and ((name[i]) <= ('Z'))))) {
                test = false
                println("invalid name, please reenter your name")
                break
            }
            i++
        }
    }
    return (name)
}
fun test_num():Int {
    var num: Int
    num = readLine()!!.toInt()
    while ((num != 1) and (num != 2) and (num != 3)) {
        println("number out of range , reenter a number")
        num = readLine()!!.toInt()
    }
    return (num)
}

fun main() {
    println("Player1 please enter your name")
    name1=printname()
    println("player2 please enter your name")
    name2=printname()
board = Board()
board.Drawboard()


    fun switchTurns() {
            currentPlayer = if (currentPlayer == name1) {
                name2
            } else {
                name1
            }

    }
    fun determineMove() {
        if (currentPlayer == name1) {
            move = move1
        } else if (currentPlayer == name2) {
            move = move2
        }

    }

    while (!board.GameOver) {
        switchTurns()
        println("$currentPlayer's turn")
        println("Enter row number:")
        var row=test_num()
       println("Enter column number:")
       var col=test_num()
      determineMove()
        board.placePiece(row - 1, col - 1, move)

    }
}
