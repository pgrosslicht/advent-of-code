import com.squareup.kotlinpoet.*
import java.nio.file.Paths
import java.time.LocalDate
import kotlin.io.path.createFile
import kotlin.io.path.exists

fun main() {
    val today = LocalDate.now()
    if (Paths.get("${today.year}/src/main/kotlin/days/Day${today.dayOfMonth}.kt").exists())
        throw IllegalStateException("File for today already created!")
    generateCode(today)
    generateTests(today)
    downloadInput(today)
}

fun generateCode(today: LocalDate) {
    val day = today.dayOfMonth

    val file = FileSpec.builder("days", "Day$day")
        .addType(
            TypeSpec.classBuilder("Day$day")
                .superclass(Day::class)
                .addSuperclassConstructorParameter("$day")
                .addFunction(
                    FunSpec.builder("partOne")
                        .addModifiers(KModifier.OVERRIDE)
                        .returns(Int::class)
                        .addCode("// TODO")
                        .build()
                )
                .build()
        )
        .addFunction(
            FunSpec.builder("main")
                .addStatement("return Day.mainify(Day$day::class)")
                .build()
        )
        .build()

    file.writeTo(Paths.get("${today.year}/src/main/kotlin").toAbsolutePath())
}

fun generateTests(today: LocalDate) {
    val day = today.dayOfMonth

    val file = FileSpec.builder("days", "Day${day}Test")
        .addImport("org.junit.jupiter.api.Assertions", "assertEquals")
        .addType(
            TypeSpec.classBuilder("Day${day}Test")
                .addFunction(
                    FunSpec.builder("testPart1")
                        .addAnnotation(ClassName("org.junit.jupiter.api", "Test"))
                        .addCode("assertEquals(0, Day${day}().partOne()")
                        .build()
                )
                .addFunction(
                    FunSpec.builder("testPart2")
                        .addAnnotation(ClassName("org.junit.jupiter.api", "Test"))
                        .addCode("assertEquals(0, Day${day}().partTwo()")
                        .build()
                )
                .build()
        )
        .build()

    file.writeTo(Paths.get("${today.year}/test/main/kotlin").toAbsolutePath())
}

fun downloadInput(today: LocalDate) {
    // no actual downloading yet, just create file
    Paths.get("${today.year}/src/main/resources/input_day_${today.dayOfMonth}.txt").takeUnless { it.exists() }
        ?.createFile()
}