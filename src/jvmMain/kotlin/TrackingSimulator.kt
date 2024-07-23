import kotlin.reflect.typeOf

class TrackingSimulator private constructor(){

    private var shipments: Array<Shipment> = arrayOf()

    private val strategies = mapOf(
        "created" to CreatedShipment(),
        "shipped" to ShippedShipment(),
        "location" to LocationOfShipment(),
        "delivered" to DeliveredShipment(),
        "delayed" to DelayedShipment(),
        "lost" to LostShipment(),
        "canceled" to CanceledShipment(),
        "noteadded" to NoteAddedToShipment()
    )

    companion object {
        @Volatile
        private var instance: TrackingSimulator? = null

        fun getInstance(): TrackingSimulator {
            return instance ?: synchronized(this) {
                instance ?: TrackingSimulator().also { instance = it }
            }
        }
    }

    fun findShipment(id: String): Shipment?{
        return shipments.find {it.id == id}
    }

    fun addShipment(shipment: Shipment){
        shipments += shipment
    }

    fun updateShipment(updateStrategy: String){
        val shipmentDetails = updateStrategy.split(',')
        val shipment: Shipment?
        if(shipmentDetails[0] == "created"){
            val factoryShipment = ShipmentFactory()
            shipment = factoryShipment.createShipment(shipmentDetails)
            if(shipment != null) {
                println(shipment::class)
                println(shipment)
                addShipment(shipment)
            }
        }
        else{
            shipment = findShipment(shipmentDetails[1])
            println(shipment!!::class)
            println(shipment)
        }
        val shipmentUpdate = strategies[shipmentDetails[0]] ?: CreatedShipment()
        if (shipment != null) {
            shipmentUpdate.updateShipment(shipment, shipmentDetails)
        }
    }
}

