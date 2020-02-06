package set1

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Challenge3SingleByteXorCipherTest : StringSpec({

    "given example" {
        val input = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"

        xorCipher(input) shouldBe "Cooking MC's like a pound of bacon"
    }

})