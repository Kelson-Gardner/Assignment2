class OvernightShipment(
    status: String,
    id: String,
    notes: Array<String>,
    updateHistory: Array<ShippingUpdate>,
    expectedDeliveryTimeStamp: Long,
    currentLocation: String,
    private val shippedTimeStamp: Long
) : Shipment(status, id, notes, updateHistory, expectedDeliveryTimeStamp, currentLocation){
    override fun checkDeliveryDate() {
        val maxDeliveryTimeStamp = shippedTimeStamp + 1 * 24 * 60 * 60 * 1000
        if (expectedDeliveryTimeStamp > maxDeliveryTimeStamp) {
            addNote("Expected delivery date exceeds 1 day from the shipped date.")
            notifyObservers()
        }
    }
}