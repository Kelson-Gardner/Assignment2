class ShipmentFactory {
    fun createShipment(shipmentDetails: List<String>): Shipment?{
        val notes = arrayOf<String>()
        val updateHistory = arrayOf<ShippingUpdate>()
        val location = "unknown"
        val shipmentStatus = shipmentDetails[0]
        val shipmentId = shipmentDetails[1]
        val shipmentType = shipmentDetails[2]
        val createdTimeStamp = shipmentDetails[3].toLong()
        when(shipmentType){
            "bulk" -> return BulkShipment(shipmentStatus, shipmentId, notes, updateHistory, 0, location, createdTimeStamp)
            "express" -> return ExpressShipment(shipmentStatus, shipmentId, notes, updateHistory, 0, location, createdTimeStamp)
            "overnight" -> return OvernightShipment(shipmentStatus, shipmentId, notes, updateHistory, 0, location, createdTimeStamp)
            "standard" -> return StandardShipment(shipmentStatus, shipmentId, notes, updateHistory, 0, location)
            else -> return null
        }
    }
}