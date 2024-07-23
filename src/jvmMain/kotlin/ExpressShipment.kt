class ExpressShipment(
    status: String,
    id: String,
    notes: Array<String>,
    updateHistory: Array<ShippingUpdate>,
    expectedDeliveryTimeStamp: Long,
    currentLocation: String,
    private val shippedTimeStamp: Long
) : Shipment(status, id, notes, updateHistory, expectedDeliveryTimeStamp, currentLocation){
    init{
        println("I was created and I am an express shipment")
    }
    override fun checkDeliveryDate() {
        println("I am the check delivery date function")
        val maxDeliveryTimeStamp = shippedTimeStamp + 3 * 24 * 60 * 60 * 1000
        println(maxDeliveryTimeStamp)
        println(expectedDeliveryTimeStamp)
        if (expectedDeliveryTimeStamp > maxDeliveryTimeStamp) {
            addNote("Expected delivery date exceeds 3 days from the shipped date.")
            notifyObservers()
        }
    }
}