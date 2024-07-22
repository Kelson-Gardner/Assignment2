import kotlin.test.Test
import kotlin.test.assertEquals

class TrackingSimulatorTest {

    val trackingSimulator = TrackingSimulator.getInstance()
    val notes = arrayOf<String>()
    val updateHistory = arrayOf<ShippingUpdate>()
    val location = "unknown"
    val shipment = Shipment(
        "delayed",
        "12345",
        notes,
        updateHistory,
        0,
        location)

    @Test
    fun testAddAndFindShipment(){
        trackingSimulator.addShipment(shipment)
        assertEquals(trackingSimulator.findShipment("12345"), shipment)
    }

    @Test
    fun testFindNoShipment(){
        assertEquals(trackingSimulator.findShipment("1212"), null)
        assertEquals(trackingSimulator.findShipment("1234"), null)
        assertEquals(trackingSimulator.findShipment("198273847"), null)
    }

}