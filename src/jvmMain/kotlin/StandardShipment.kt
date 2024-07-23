class StandardShipment(
    status: String,
    id: String,
    notes: Array<String>,
    updateHistory: Array<ShippingUpdate>,
    expectedDeliveryTimeStamp: Long,
    currentLocation: String,
) : Shipment(status, id, notes, updateHistory, expectedDeliveryTimeStamp, currentLocation){
    override fun checkDeliveryDate() {}
}