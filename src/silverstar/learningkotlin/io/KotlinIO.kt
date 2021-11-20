package silverstar.learningkotlin.io

import java.io.DataInputStream
import java.io.File
import java.io.FileInputStream

fun main() {

    val file = File("testfile.txt")
    println(file.reader().readLines().joinToString("\n"))
    println(file.bufferedReader().use { it.readText() })
    println(file.readText())
    file.reader().forEachLine { println(it) }
    file.reader().useLines { println(it.joinToString("\n")) }

    val binStream = FileInputStream("testfile.bin")
    val di = DataInputStream(binStream)
    println(di.reader().readLines().joinToString("\n"))
    println()

    // using Java classes directly in Kotlin
    // try {
    //     while(true) {
    //         println(di.readUTF())
    //     }
    // } catch (e: EOFException){}

    // try with resources in Kotlin is 'use()' function

    // walking file tree
    val parent = File(".") // start working directory
    parent.walkTopDown().filter { it.name.endsWith(".kt") }.forEach { println(it.name) }
}
