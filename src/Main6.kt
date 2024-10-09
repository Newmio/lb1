fun main() {
    println("Введіть 16-значний номер банківської карти:")
    val cardNumber = readLine()

    if (cardNumber != null && cardNumber.length == 16 && cardNumber.all { it.isDigit() }) {
        val isValid = isValidCard(cardNumber)
        if (isValid) {
            println("Картка є валідною.")
        } else {
            println("Картка є невалідною.")
        }
    } else {
        println("Будь ласка, введіть правильний 16-значний номер карти.")
    }
}

fun isValidCard(cardNumber: String): Boolean {
    val digits = cardNumber.map { it.toString().toInt() }
    val checksum = digits.reversed().mapIndexed { index, digit ->
        if (index % 2 == 1) {
            val doubled = digit * 2
            if (doubled > 9) doubled - 9 else doubled
        } else {
            digit
        }
    }.sum()

    return checksum % 10 == 0
}