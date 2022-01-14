package joaopereira.learningkotlin.declarations

fun main() {
    var number :Int
    number = 10
    number = 20

    val employee1 = Employee("Sara", 70)
    println(employee1)

    val change = 4.22

    println("O troco é $$change")

    val numerator = 10.99
    val denominator = 20.00
    println("division: ${numerator/denominator}")

    val phrase = """posh
        |que cena
        |macabra
        |lololol
    """.trimMargin()
    println(phrase)
}

class Employee(var name: String, val id: Int){

    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
    }

}