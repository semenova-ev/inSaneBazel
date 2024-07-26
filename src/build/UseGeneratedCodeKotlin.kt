package build

import abc.build.Generated2

/**
 * Similar to UsesGeneratedCode, but in Kotlin
 */
class UseGeneratedCodeKotlin {
    fun getGeneratedMessage(): String =
        Generated1.getGeneratedMessage() + Generated2.getGeneratedMessage()
}