import java.math.BigInteger
import java.util.*
import kotlin.experimental.xor

typealias Hex = String

// Convert Hex <=> ByteArray <=> Base64

// Convert Hex <=> ByteArray
fun Hex.toByteArray(): ByteArray = BigInteger(this, 16).toByteArray()
fun ByteArray.toHex(): Hex = BigInteger(this).toString(16)

// Convert Base64 <=> ByteArray
fun base64ToByteArray(base64: String): ByteArray = Base64.getDecoder().decode(base64)
fun ByteArray.toBase64(): String = Base64.getEncoder().encodeToString(this)

// Convert Hex <=> Base64
fun base64ToHex(base64: String): Hex = base64ToByteArray(base64).toHex()
fun Hex.toBase64(): String = toByteArray().toBase64()

/**
 * Hamming Distance for plaintext.
 */
fun String.hammingDistance(other: String): Int {
    require(this.length == other.length) { "Strings must be of equal length." }

    // 0 1 0 1
    //  x o r
    // 1 1 1 0
    // -------
    // 1 0 1 1
    // then
    // 1 + 0 + 1 + 1 = 3

    return this.zip(other)
        // xor first second
        .map { (first, second) -> first xor second }
        // Count number of set bits (https://stackoverflow.com/a/5268949)
        .map { Integer.bitCount(it.toInt()) }
        // Sum number of set bits
        .sum()
}

/**
 * Hamming Distance for [ByteArray]. Prefer this over a function specifically for [Hex] or base 64.
 */
fun ByteArray.hammingDistance(other: ByteArray): Int {
    require(this.size == other.size) { "ByteArrays must be of equal size." }

    return this.zip(other)
        // xor first second
        .map { (first, second) -> first xor second }
        // Count number of set bits (https://stackoverflow.com/a/5268949)
        .map { Integer.bitCount(it.toInt()) }
        // Sum number of set bits
        .sum()
}

/**
 * Similar to [Byte.xor].
 * @see Int.xor
 */
private infix fun Char.xor(second: Char): Char = (this.toInt() xor second.toInt()).toChar()

fun Int.toHex(): Hex = this.toString(16).padStart(2, '0')

fun xorCipherOneByte(cipherText: ByteArray, key: Byte): String {
    return cipherText.asSequence()
        .map { it xor key }
        .map { it.toChar() }
        .joinToString("")
}

private const val alphabet = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
fun scoreMessage(message: String): Int = message.count { it in alphabet }

fun scoreCiphers(ciphers: Map<Byte, String>): List<Triple<Int, Byte, String>> {
    return ciphers.map { Triple(scoreMessage(it.value), it.key, it.value) }
}

fun findBestCipher(ciphers: Map<Byte, String>): String {
    return ciphers.map { it.value }.maxBy { scoreMessage(it) } ?: ""
}
