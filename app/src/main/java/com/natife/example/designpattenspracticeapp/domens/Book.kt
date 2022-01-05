package com.natife.example.designpattenspracticeapp.domens

object Book {
    const val bookTitle = "Book"
    const val bookAuthor = "Author"
}

class S private constructor(val name:String) {

    companion object {

        private var INSTANCE: S? = null

        fun getInstance(): S {
            val checkInstance = INSTANCE
            if (checkInstance != null) {
                return checkInstance
            }
            return synchronized(this) {
                val checkInstanceAgain = INSTANCE
                if (checkInstanceAgain != null) {
                    checkInstanceAgain
                } else {
                    val created = S("Test")
                    INSTANCE = created
                    created
                }
            }
        }

    }




}