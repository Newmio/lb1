fun main() {
    val numbers = listOf(3, 12, 5, 25, 8, 17, 10, 6, 22)
    val sequence1 = mutableListOf<Int>()
    val sequence2 = mutableListOf<Int>()

    for (num in numbers) {
        if (num % 2 == 0 && num > 10) {
            sequence1.add(num)
        }
        if (num % 2 != 0 || num % 5 == 0) {
            sequence2.add(num)
        }
    }

    println("Перша послідовність до дублів (парні і більше 10): $sequence1")
    println("Друга послідовність до дублів (непарні і кратні 5): $sequence2")

    if (sequence1.size < 6) {
        for (i in 2 until sequence1.size step 3){
            sequence1.add(sequence1[i])
        }
    }

    if (sequence2.size < 6) {
        for (i in 2 until sequence2.size step 3){
            sequence2.add(sequence2[i])
        }
    }

    println("Перша послідовність після дублів (парні і більше 10): $sequence1")
    println("Друга послідовність після дублів (непарні і кратні 5): $sequence2")
}