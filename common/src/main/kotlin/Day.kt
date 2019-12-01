import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor
import kotlin.system.measureTimeMillis

abstract class Day(val day: Int) {
    protected val dataList: List<String> by lazy { InputReader.getInputAsList(day) }
    protected val dataString: String by lazy { InputReader.getInputAsString(day) }

    open fun partOne(): Any? {
        return null
    }

    open fun partTwo(): Any? {
        return null
    }

    companion object {
        fun mainify(clazz: KClass<out Day>) {
            clazz.primaryConstructor?.call()?.apply {
                println("Day $day")
                measureTimeMillis {
                    println("First: ${partOne()?.toString() ?: "unsolved"}")
                }.run {
                    println("Time: ${this}ms")
                }
                measureTimeMillis {
                    println("Second: ${partTwo()?.toString() ?: "unsolved"}")
                }.run {
                    println("Time: ${this}ms")
                }
            }
        }
    }
}