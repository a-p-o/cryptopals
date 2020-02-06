package set1

import Hex
import toByteArray
import toHex
import kotlin.experimental.xor

/**
 * Write a function that takes two equal-length buffers and produces their XOR combination.
 *
 * If your function works properly, then when you feed it the string:
 *
 * `1c0111001f010100061a024b53535009181c`
 *
 * ... after hex decoding, and when XOR'd against:
 *
 * `686974207468652062756c6c277320657965`
 *
 * ... should produce:
 *
 * `746865206b696420646f6e277420706c6179`
 */
infix fun Hex.fixedXor(other: Hex): Hex {
    val byteArrayLeft = this.toByteArray()
    println("$this ${byteArrayLeft.joinToString(" ")}")
    val byteArrayRight = other.toByteArray()

    val xored = byteArrayLeft.zip(byteArrayRight)
        .map { pair -> pair.first xor pair.second }
        .toByteArray()

    return xored.toHex()
}

