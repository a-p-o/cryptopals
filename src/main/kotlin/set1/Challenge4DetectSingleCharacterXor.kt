package set1

import scoreMessage
import java.lang.invoke.MethodHandles

fun xorCipherMany(file: String): String {
    return MethodHandles.lookup().lookupClass().getResource(file)
        .openStream()
        .bufferedReader(Charsets.UTF_8)
        .useLines {
            // Brute-force single-cipher all of the cipher text
            it.map { cipherText -> xorCipher(cipherText) }
                // Find the best matching message
                .maxBy { message -> scoreMessage(message) } ?: ""
        }
}