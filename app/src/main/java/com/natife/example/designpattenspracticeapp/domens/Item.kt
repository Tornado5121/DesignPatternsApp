package com.natife.example.designpattenspracticeapp.domens

data class Item(
    val id: Int,
    val title: String,
    val description: String
) {

    class Builder {
        private var id: Int = 0
        private var title: String = ""
        private var description: String = ""

        fun withId(id: Int): Builder {
            this.id = id
            return this
        }

        fun withTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun withDescription(description: String): Builder {
            this.description = description
            return this
        }

        fun build(): Item {
            return Item(id, title, description)
        }

    }

}