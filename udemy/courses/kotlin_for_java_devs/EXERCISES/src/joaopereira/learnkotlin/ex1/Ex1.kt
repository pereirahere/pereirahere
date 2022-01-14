package joaopereira.learnkotlin.ex1

fun main(args: Array<String>) {

    val hello1 = "Hello"
    val hello2 = "Hello"

    println(hello1===hello2)
    println(hello1==hello2)

    var number1 : Int = 2988
    val var1 : Any = "This is an ANY type variable"

    if (var1 is String){
        println(var1.toUpperCase())
    }

    print("""${1}    1
        ${1}   11
        ${1}  111
        ${1} 1111
    """.trimMargin("1"))




}