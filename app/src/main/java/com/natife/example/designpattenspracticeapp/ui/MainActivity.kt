package com.natife.example.designpattenspracticeapp.ui

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.designpattenspracticeapp.R
import com.natife.example.designpattenspracticeapp.domens.Book
import com.natife.example.designpattenspracticeapp.domens.Item
import com.natife.example.designpattenspracticeapp.domens.S
import com.natife.example.designpattenspracticeapp.domens.decoder.Car
import com.natife.example.designpattenspracticeapp.domens.decoder.Plane
import com.natife.example.designpattenspracticeapp.domens.decoder.Ship
import com.natife.example.designpattenspracticeapp.domens.decoder.Transport
import com.natife.example.designpattenspracticeapp.factories.ItemFactory
import com.natife.example.designpattenspracticeapp.ui.adapters.*

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

        val s = S.getInstance()
        d("Singleton", s.name)

        //Adapter
        val hole = RoundHole(5.0)
        val roundPeg = RoundPeg(5.0)
        val bool = hole.isFit(roundPeg)
        d("boolIsRoundPegFit", bool.toString()) //true

        val squarePeg = SquarePeg(5.0)
        val adapter = RoundHoleAdapter().convertToRadius(squarePeg)
        val bool2 = hole.isFit(adapter)
        d("boolIsRoundPegFit2", bool2.toString()) //true

        val squarePeg2 = SquarePeg(10.0)
        val adapter2 = RoundHoleAdapter().convertToRadius(squarePeg2)
        val bool3 = hole.isFit(adapter2)
        d("boolIsRoundPegFit3", bool3.toString()) //false

        //Decorator
        transportFactory.fly()
        transportFactory.move()
        transportFactory.turn()
        transportFactory.stop()
    }

}