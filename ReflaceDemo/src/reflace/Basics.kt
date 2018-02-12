package reflace

class Basics {

    private fun sum(a: Int, b: Int) = a + b

    //    private fun print(a: Int, b: Int) :Unit = print(sum(a, b))
    private fun print(a: Int, b: Int) = print(sum(a, b))

    var a = 11
    var b = 12

    var  result = "The sum of $a and $b is ${sum(a, b)}"
    var test = "result is $result, $"
    fun getResult(): Int?{
        return a+b
    }
    fun parse2Integer(str: String) :Int? {
        return str.toIntOrNull()
    }
}
fun compare(a: Int, b: Int): Int = if (a > b)  a else b

fun main(args: Array<String>) {
    var b = Basics()
    b.a = 0
    b.b = 0

    println("b.a = "+b.a)
    println("b.b = "+b.b)
    println("b.result = "+b.result)
    println("b.getResult = "+b.getResult())

    val b1 = Basics()
    b1.a = 1
    b1.b = 1
    val b2 = Basics()
    b2.a = 2
    b2.b = 2
    val items = listOf(b, b1, b2)
//    for (item in items) {
//        println(item.result)
//    }
//    for (index in items.indices) {
//        println(index)
//        println(items[index].result)
//    }
////    val basics = Basics()
//    println(basics.result)
//    println(basics.test)
//    println(basics.parse2Integer("22"))
//    println(basics.parse2Integer("s"))
//    println(compare(243, 54345))
}