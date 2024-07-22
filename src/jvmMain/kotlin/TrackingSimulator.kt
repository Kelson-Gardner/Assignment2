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

    private fun createShipment(shipment: String): Shipment{
        val notes = arrayOf<String>()
        val updateHistory = arrayOf<ShippingUpdate>()
        val location = "unknown"
        val shipmentDetails = shipment.split(',')
        val shipmentStatus = shipmentDetails[0]
        val shipmentId = shipmentDetails[1]
        return Shipment(
            shipmentStatus,
            shipmentId,
            notes,
            updateHistory,
            0,
            location)
    }

    fun updateShipment(updateStrategy: String){
        val shipmentDetails = updateStrategy.split(',')
        val shipment: Shipment?
        if(shipmentDetails[0] == "created"){
            shipment = createShipment(updateStrategy)
            addShipment(shipment)
        }
        else{
            shipment = findShipment(shipmentDetails[1])
        }
        val shipmentUpdate = strategies[shipmentDetails[0]] ?: CreatedShipment()
        if (shipment != null) {
            shipmentUpdate.updateShipment(shipment, shipmentDetails)
        }
    }
}

