class BulkShipment(
    status: String,
    id: String,
    notes: Array<String>,
    updateHistory: Array<ShippingUpdate>,
    expectedDeliveryTimeStamp: Long,
    currentLocation: String,
    private val shippedTimeStamp: Long
) : Shipment(status, id, notes, updateHistory, expectedDeliveryTimeStamp, currentLocation){
    override fun checkDeliveryDate() {
        val minDeliveryTimeStamp = shippedTimeStamp + 3 * 24 * 60 * 60 * 1000
        if (expectedDeliveryTimeStamp < minDeliveryTimeStamp) {
            addNote("Expected delivery date is set within 3 days from the shipped date.")
            notifyObservers()
        }
    }
}