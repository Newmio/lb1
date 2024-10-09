
data class Person(val name: String, val age: Int)
data class Apartment(val number: Int, val rent: Boolean)

class Building(val apartments: List<Apartment>, val residents: List<Person>) {

    fun countResidentsOlderThan(age: Int) {
        val count = residents.count { it.age >= age }
        println("Кількість мешканців старше $age років: $count")
    }

    fun listApartmentsForRent() {
        println("Квартири, що здаються в оренду:")
        for (apartment in apartments) {
            if (apartment.rent) {
                println("Квартира номер ${apartment.number} доступна для оренди.")
            }
        }
    }
}

fun main() {
    val residents = listOf(
        Person("Іван", 25),
        Person("Олена", 30),
        Person("Петро", 40),
        Person("Марія", 20)
    )

    val apartments = listOf(
        Apartment(1, true),
        Apartment(2, false),
        Apartment(3, true),
        Apartment(4, false)
    )

    val building = Building(apartments, residents)
    building.countResidentsOlderThan(25)
    building.listApartmentsForRent()
}