package set1

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class Challenge2FixedXorTest : StringSpec({

    "given example" {
        val input1 = "1c0111001f010100061a024b53535009181c"
        val input2 = "686974207468652062756c6c277320657965"

        input1 fixedXor input2 shouldBe "746865206b696420646f6e277420706c6179"
    }

})
