package com.natife.example.designpattenspracticeapp.ui

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.designpattenspracticeapp.R
import com.natife.example.designpattenspracticeapp.domens.Book
import com.natife.example.designpattenspracticeapp.domens.Item
import com.natife.example.designpattenspracticeapp.domens.decoder.Car
import com.natife.example.designpattenspracticeapp.domens.decoder.Plane
import com.natife.example.designpattenspracticeapp.domens.decoder.Ship
import com.natife.example.designpattenspracticeapp.domens.decoder.Transport
import com.natife.example.designpattenspracticeapp.factories.ItemFactory

class MainActivity : AppCompatActivity() {

    private val factory = ItemFactory()
    private val transportFactory = Transport
        .TransportBuilder()
        .withCar(Car())
        .withShip(Ship())
        .withPlane(Plane())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Builder
        val item: Item =
            Item.Builder()
                .withId(1)
                .withTitle("ItemTitle")
                .withDescription("ItemDescription")
                .build()
        d("itemInfo", item.toString())

        //Factory
        val factoryItem = factory.createItemById(1)
        d("itemFactoryInfo", factoryItem.toString())

        val factoryDefaultItem = factory.createItem()
        d("itemDefaultFactoryInfo", factoryDefaultItem.toString())

        //Singleton
        val book = Book
        d("bookInfo", book.bookTitle + " by " + book.bookAuthor)

        //Adapter


        //Decorator
        transportFactory.fly()

    }

}