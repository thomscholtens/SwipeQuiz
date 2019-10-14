package com.example.myapplication

data class Question (
    var question: String,
    var answer: Boolean
) {
    companion object {
        val QUESTIONS = listOf(
            Question("Lightning never strikes in the same place twice", false),
            Question("If you cry in space the tears just stick to your face", true),
            Question("Humans can distinguish between over a trillion different smells", true),
            Question("There are more cells of bacteria in your body than there are human cells", true),
            Question("Your fingernails and hair keep growing after you die", false),
            Question("Birds are dinosaurs", true),
            Question("It costs the U.S. Mint more to make pennies and nickels than the coins are actually worth", true),
            Question("Water spirals down the plughole in opposite directions in the northern and southern hemispheres", false),
            Question("The top of the Eiffel Tower leans away from the sun", true)
        )
    }
}