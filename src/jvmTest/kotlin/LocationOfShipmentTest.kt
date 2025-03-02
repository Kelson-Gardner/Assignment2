import kotlin.test.Test
import kotlin.test.assertEquals

class LocationShipmentTest {
    val shipmentUpdate = LocationOfShipment()
    val notes = arrayOf<String>()
    val updateHistory = arrayOf<ShippingUpdate>()
    val location = "unknown"
    val standardShipment = StandardShipment(
        "shipped",
        "12342",
        notes,
        updateHistory,
        0,
        location)

    @Test
    fun testNoUpdateOfShipmentStatus(){
        shipmentUpdate.updateShipment(standardShipment, listOf("location", "12345", "123456789","Los Angelos"))
        assertEquals(standardShipment.status, "shipped")
    }
    @Test
    fun testUpdateUpdateLocation(){
        shipmentUpdate.updateShipment(standardShipment, listOf("location", "12345", "123456789", "Los Angelos"))
        assertEquals(standardShipment.currentLocation, "Los Angelos")
    }
    @Test
    fun testNoAddingOfShippingUpdates(){
        shipmentUpdate.updateShipment(standardShipment, listOf("location", "12345", "123456789", "Los Angelos"))
        assertEquals(standardShipment.updateHistory.isEmpty(), true)
    }
}