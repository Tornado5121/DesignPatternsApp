package com.natife.example.designpattenspracticeapp.ui.adapters

import com.natife.example.designpattenspracticeapp.domens.NotItem

class ItemAdapter: Itemable {

    override fun putItem() {
        val notItem = NotItem()
        notItem.notItemMethod()
    }

}