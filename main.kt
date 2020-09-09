var board=Board()
var move=""
var currentPlayer = ""
const val move1="X"
const val move2="O"
var name1=""
var name2=""

fun printname1():Boolean {
    println("Player1 please enter your name")
    return when (readLine()!!.toString()) {
        "0" -> false
        "1" -> false
        "2" -> false
        "3" -> false
        "4" -> false
        "5" -> false
        "6" -> false
        "7" -> false
        "8" -> false
        "9" -> false
        " " -> false
        else -> true

    }
}
fun check1() {
    while (printname1() == false) {
        println("invalid entry, please reenter your name")
    }
}
fun printname2():Boolean {
    println("Player2 please enter your name")
    return when (readLine()!!.toString()) {
        "0" -> false
        "1" -> false
        "2" -> false
        "3" -> false
        "4" -> false
        "5" -> false
        "6" -> false
        "7" -> false
        "8" -> false
        "9" -> false
        " " -> false
        else -> true
    }
}
fun check2() {
   when (printname2()){
       false->println("invalid entry, please reenter your name")
       true->name1
   }

}
fun main() {
    check1()
    check2()
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
            move= move1
        }
        else if (currentPlayer == name2) {
            move=move2}

    }


    while (!board.GameOver) {
        switchTurns()
        println("$currentPlayer's turn")
        println("Enter row number:")
        var row = readLine()!!.toInt()
        println("Enter column number:")
        var col = readLine()!!.toInt()
        determineMove()
        board.placePiece(row - 1, col - 1, move)

    }
}