package com.natife.example.designpattenspracticeapp.ui.adapters

import kotlin.math.sqrt

class RoundHoleAdapter {

    fun convertToRadius(peg: SquarePeg) : RoundPeg {
        val pegConvertedToRound = RoundPeg(peg.width)
        pegConvertedToRound.radius = peg.width * sqrt(2.0) / 2
        return pegConvertedToRound
    }

}