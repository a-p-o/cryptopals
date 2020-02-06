package set1

import Hex
import base64ToHex
import hammingDistance
import scoreCiphers
import toByteArray
import xorCipherOneByte
import java.lang.invoke.MethodHandles
import kotlin.streams.asSequence

/**
 * # It is officially on, now.
 * > This challenge isn't conceptually hard, but it involves actual error-prone coding.
 * > The other challenges in this set are there to bring you up to speed.
 * > This one is there to qualify you. If you can do this one, you're probably just fine up to Set 6.
 *
 * There's a file here. It's been base64'd after being encrypted with repeating-key XOR.
 *
 * Decrypt it.
 *
 * Here's how:
 *
 * 1. Let KEYSIZE be the guessed length of the key; try values from 2 to (say) 40.
 * 2. Write a function to compute the edit distance/Hamming distance between two strings. *The Hamming distance is just the number of differing bits.* The distance between:
 *
 * ```
 * this is a test
 * ```
 *
 * and
 *
 * ```
 * wokka wokka!!!
 * ```
 *
 * is **37**. *Make sure your code agrees before you proceed.*
 *
 * 3. For each KEYSIZE, take the *first* KEYSIZE worth of bytes, and the *second* KEYSIZE worth of bytes, and find the edit distance between them. Normalize this result by dividing by KEYSIZE.
 *
 * 4. The KEYSIZE with the smallest normalized edit distance is probably the key. You could proceed perhaps with the smallest 2-3 KEYSIZE values. Or take 4 KEYSIZE blocks instead of 2 and average the distances.
 *
 * 5. Now that you probably know the KEYSIZE: break the cipher text into blocks of KEYSIZE length.
 *
 * 6. Now transpose the blocks: make a block that is the first byte of every block, and a block that is the second byte of every block, and so on.
 *
 * 7. Solve each block as if it was single-character XOR. You already have code to do this.
 *
 * 8. For each block, the single-byte XOR key that produces the best looking histogram is the repeating-key XOR key byte for that block. Put them together and you have the key.
 *
 * This code is going to turn out to be surprisingly useful later on.
 * Breaking repeating-key XOR ("Vigenere") statistically is obviously an academic exercise, a "Crypto 101" thing.
 * But more people "know how" to break it than can *actually break it*, and a similar technique breaks something much more important.
 *
 * # No, that's not a mistake.
 * > We get more tech support questions for this challenge than any of the other ones. We promise, there aren't any blatant errors in this text. In particular: the "wokka wokka!!!" edit distance really is 37.
 */
fun breakRepeatingKeyXor(file: String): String {
    // Read the base64 file
    val base64 = MethodHandles.lookup().lookupClass().getResource(file)
        .openStream()
        .bufferedReader(Charsets.UTF_8)
        // Strip the new lines
        .lines().asSequence().joinToString("")

    // Convert base64 to hex
    val hex = base64ToHex(base64)

    val keySizesToHammingDistance = findKeySizesWithSmallestHammingDistance(hex)
    
    // Print the five best/smallest keysize to hamming distance pairs as sanity check
    val bestKeySizes = keySizesToHammingDistance.take(3).map { it.first }.toList()
//    println("Best key sizes: $bestKeySizes")

    // 5. Break ciphertext into blocks of keysize length
    // 6. Transpose the blocks/chunks
    // Make a block that is the first byte of every block
    // Make a block that is the second byte of every block
    // And so on
    // Try transposing the hex by the best key size
    val transposed = hex.transposed(bestKeySizes.first())

    // Don't look for English after step 7. You're looking for the key, not the message
    // Look for the best histogram

    // 7. Solve each block as if it was a single-character xor

//    transposed.map { xorCipher(it) }.forEach(::println)

//    val ciphered = xorCipher(transposed.first())
//    println(ciphered)
    xorCipherRaw(transposed.first()).forEach(::println)
    // 8. For each block, the single-byte xor key that produces the best looking histogram is the repeating-key xor key key byte for that block
    // Put them together and you have the key

    TODO()
}

fun CharSequence.transposed(size: Int): List<String> {
    val chunked = this.chunked(size).toMutableList()

    val transposed = mutableListOf<String>()
    while (chunked.first().isNotEmpty()) {
        val tmp = chunked.joinToString("") { it.take(1) }
        chunked.replaceAll { it.drop(1) }
        transposed.add(tmp)
    }

    return transposed.toList()
}

private fun findKeySizesWithSmallestHammingDistance(ciphertext: Hex): Iterable<Pair<Int, Double>> {
    // 1. Let keysize be the guessed length of the key
    // Try values from 2 to (say) 40
    val startKeysize = 2
    val endKeysize = 40
    
    // Don't mess with hex, just use bytes
    // Using bytes complicates [hammingDistance], because hex represents one byte with two characters
    // !! NOTE This is using Hex.toByteArray()
    val byteArray = ciphertext.toByteArray()

    // This function will only work for [ciphertext] with lengths 80 bytes (160 hex characters) or greater
    
    // 3. For each keysize...
    return (startKeysize..endKeysize).asSequence()
        .map { keysize ->
            // 3. Take the first keysize worth of bytes
            val first = byteArray.copyOfRange(0, keysize)

            // 3. Take the second keysize worth of bytes
            val second = byteArray.copyOfRange(keysize, 2 * keysize)

            // 3. Find the edit (hamming) distance
            val hammingDistance = first.hammingDistance(second)

            // 3. Normalize by dividing by keysize
            val normalizedHammingDistance = hammingDistance.toDouble() / keysize
//            println("$first $second hamming $normalizedHammingDistance")

            // Return (keySize, normalizedHammingDistance) so we can sort them
            keysize to normalizedHammingDistance
        }
        // 4. The keysize with the smallest normalized hamming distance is probably the key
        .sortedBy { it.second }
        // 4. You could probably proceed with the smallest few values.
        .asIterable()
    // I chose to return all of the keysizes and normalized hamming distances
    // Turns out I could probably return 5 (maximum) for this example
}

private fun xorCipherRaw(cipherText: Hex): List<Triple<Int, Byte, String>> {
    val cipherTextBytes = cipherText.toByteArray()

    val messages = IntRange(0, 256).asSequence()
        .map { it.toByte() }
        .map { key -> key to xorCipherOneByte(cipherTextBytes, key) }
        .toMap()

    return scoreCiphers(messages)
}