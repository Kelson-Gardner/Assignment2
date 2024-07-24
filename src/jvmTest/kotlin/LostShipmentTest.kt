import kotlin.test.Test
import kotlin.test.assertEquals

class LostShipmentTest {
    val shipmentUpdate = LostShipment()
    val notes = arrayOf<String>()
    val updateHistory = arrayOf<ShippingUpdate>()
    val location = "unknown"
    val standardShipment = StandardShipment(
        "delayed",
        "12342",
        notes,
        updateHistory,
        0,
        location)

    @Test
    fun testUpdateShipmentStatus(){
        shipmentUpdate.updateShipment(standardShipment, listOf("lost", "12342", "123456789"))
        assertEquals(standardShipment.status, "lost")
    }

    @Test
    fun testUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(standardShipment, listOf("lost", "12342", "123456789"))
        assertEquals(standardShipment.updateHistory[0].previousStatus, "delayed")
        assertEquals(standardShipment.updateHistory[0].newStatus, "lost")
        assertEquals(standardShipment.updateHistory[0].timeStamp , 123456789)
    }
}