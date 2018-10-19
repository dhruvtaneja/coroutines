import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {

    runBlocking {
        val sum = getSum().sumBy { it.await() }
        println("sum is : $sum")
    }

}


fun getSum(): List<Deferred<Int>> {

    return (1..100000).map { it ->
        async {
            delay(1000)
            it
        }
    }
}
