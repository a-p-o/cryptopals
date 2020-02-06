package set1

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Challenge4DetectSingleCharacterXorTest : StringSpec({

    "given example" {
        val input = "/challenge-4-strings.txt"

        // TODO Why is there a trailing newline?
        xorCipherMany(input) shouldBe "Now that the party is jumping\n"
    }

})