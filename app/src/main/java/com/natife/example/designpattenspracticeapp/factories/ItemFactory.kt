package com.natife.example.designpattenspracticeapp.factories

import com.natife.example.designpattenspracticeapp.domens.Item

class ItemFactory {

    fun createItem() : Item {
        return Item(1, "", "")
    }

    fun createItemById(id: Int): Item {
        return Item(
            id,
            "$id",
            "$id"
        )
    }

}