import kotlin.test.Test
import kotlin.test.assertEquals

class DelayedShipmentTest {
    val shipmentUpdate = DelayedShipment()
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
    fun testUpdateShipmentStatus(){
        shipmentUpdate.updateShipment(standardShipment, listOf("delayed", "12345", "123456789","11111111"))
        assertEquals(standardShipment.status, "delayed")
    }
    @Test
    fun testUpdateExpectedDeliveryTime(){
        shipmentUpdate.updateShipment(standardShipment, listOf("delayed", "12345", "123456789","11111111"))
        assertEquals(standardShipment.expectedDeliveryTimeStamp, 11111111)
    }
    @Test
    fun testUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(standardShipment, listOf("delayed", "12345", "123456789", "11111111"))
        assertEquals(standardShipment.updateHistory[0].previousStatus, "shipped")
        assertEquals(standardShipment.updateHistory[0].newStatus, "delayed")
        assertEquals(standardShipment.updateHistory[0].timeStamp , 123456789)
    }
}