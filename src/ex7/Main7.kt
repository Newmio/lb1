package ex7

interface JobSeeker {
    val name: String
    val profession: String
    fun applyForJob(vacancy: Vacancy): Boolean
}

class Person(override val name: String, override val profession: String) : JobSeeker {
    override fun applyForJob(vacancy: Vacancy): Boolean {
        return profession.equals(vacancy.professionRequired, ignoreCase = true)
    }

    override fun toString(): String {
        return "Ім'я: $name, Професія: $profession"
    }
}

data class Vacancy(val professionRequired: String, val salary: Double, var isAvailable: Boolean = true)

class EmploymentAgency {
    private val vacancies = mutableListOf<Vacancy>()
    private val jobSeekers = mutableListOf<JobSeeker>()

    fun addVacancy(vacancy: Vacancy) {
        vacancies.add(vacancy)
        println("Додано вакансію: $vacancy")
    }

    fun addJobSeeker(jobSeeker: JobSeeker) {
        jobSeekers.add(jobSeeker)
        println("Додано шукача роботи: $jobSeeker")
    }

    fun showAvailableVacancies() {
        println("Доступні вакансії:")
        vacancies.filter { it.isAvailable }.forEach { println(it) }
    }

    fun matchJobs() {
        for (seeker in jobSeekers) {
            val matchedVacancy = vacancies.find { it.isAvailable && seeker.applyForJob(it) }
            if (matchedVacancy != null) {
                println("${seeker.name} отримує роботу: ${matchedVacancy.professionRequired} з зарплатою ${matchedVacancy.salary}")
                matchedVacancy.isAvailable = false
            } else {
                println("${seeker.name} не знайдено відповідної вакансії.")
            }
        }
    }
}

fun main() {
    val agency = EmploymentAgency()
    val vacancy1 = Vacancy("Програміст", 1500.0)
    val vacancy2 = Vacancy("Дизайнер", 1200.0)
    val vacancy3 = Vacancy("Інженер", 1800.0)

    agency.addVacancy(vacancy1)
    agency.addVacancy(vacancy2)
    agency.addVacancy(vacancy3)

    val person1 = Person("Іван", "Програміст")
    val person2 = Person("Олена", "Дизайнер")
    val person3 = Person("Петро", "Лікар")

    agency.addJobSeeker(person1)
    agency.addJobSeeker(person2)
    agency.addJobSeeker(person3)

    agency.showAvailableVacancies()

    agency.matchJobs()
}