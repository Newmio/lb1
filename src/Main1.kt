fun main() {
    val text = """
        Це приклад тексту для задачі, в якому деякі слова повторюються. 
        Наприклад, слово 'текст' зустрічається декілька разів. слово слово слово слово
    """.trimIndent()

    val searchChar = 'т'

    val wordsStartingWithChar = getWordsStartingWithChar(text, searchChar)
    println("Слова, що починаються на '$searchChar':")
    println(wordsStartingWithChar)

    val wordFrequency = calculateWordFrequency(text)
    println("\nЧастота появи всіх слів:")
    println(wordFrequency)

    val sortedWords = sortByFrequency(wordFrequency)
    println("\nВсі слова у порядку збільшення частоти:")
    println(sortedWords)
}

fun getWordsStartingWithChar(text: String, char: Char): List<String> {
    return text.split(Regex("\\s+"))
        .map { it.trim().lowercase().replace(Regex("[^\\p{L}\\p{Nd}]"), "") }
        .filter { it.startsWith(char) && it.isNotEmpty() }
}

fun calculateWordFrequency(text: String): Map<String, Int> {
    return text.split(Regex("\\s+"))
        .map { it.trim().lowercase().replace(Regex("[^\\p{L}\\p{Nd}]"), "") }
        .filter { it.isNotEmpty() }
        .groupingBy { it }.eachCount()
}

fun sortByFrequency(wordFrequency: Map<String, Int>): List<Pair<String, Int>> {
    return wordFrequency.entries.sortedBy { it.value }.map { it.toPair() }
}