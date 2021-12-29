package com.natife.example.designpattenspracticeapp.domens.decoder

class Transport(
    private val car: Car,
    private val ship: Ship,
    private val plane: Plane
) {

    fun move() {
        car.move()
        ship.move()
        plane.move()
    }

    fun turn() {
        car.turn()
        ship.turn()
        plane.turn()
    }

    fun stop() {
        car.stop()
        ship.stop()
        plane.stop()
    }

    fun fly() {
        plane.fly()
    }

    class TransportBuilder {

        private var car: Car = Car()
        private var ship: Ship = Ship()
        private var plane: Plane =  Plane()

        fun withCar(car: Car) : TransportBuilder {
            this.car = car
            return this
        }

        fun withShip(ship: Ship) : TransportBuilder {
            this.ship = ship
            return this
        }

        fun withPlane(plane: Plane) : TransportBuilder {
            this.plane = plane
            return this
        }

        fun build(): Transport {
            return Transport(car, ship, plane)
        }
    }

}