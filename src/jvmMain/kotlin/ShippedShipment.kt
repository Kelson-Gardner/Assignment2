import kotlin.reflect.typeOf

class ShippedShipment: ShipmentUpdateStrategy {
    override fun updateShipment(shipment: Shipment, shipmentUpdateDetails: List<String>) {
        val oldStatus = shipment.status
        val newStatus = shipmentUpdateDetails[0]
        val timeStamp = shipmentUpdateDetails[2].toLong()
        val newExpectedDeliveryTime = shipmentUpdateDetails[3].toLong()
        val shippingUpdate = ShippingUpdate(
            oldStatus,
            newStatus,
            timeStamp
        )
        shipment.status = newStatus
        shipment.expectedDeliveryTimeStamp = newExpectedDeliveryTime
        shipment.addShippingUpdate(shippingUpdate)
        shipment.notifyObservers()
        shipment.checkDeliveryDate()
    }
}