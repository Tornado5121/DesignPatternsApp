package com.natife.example.designpattenspracticeapp.ui.adapters

class RoundHole(private val radius: Double) {

    fun isFit(peg: RoundPeg): Boolean {
        return radius >= peg.radius
    }

}