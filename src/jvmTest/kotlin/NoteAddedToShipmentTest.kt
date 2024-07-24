import kotlin.test.Test
import kotlin.test.assertEquals

class NoteAddedToShipmentTest {
    val shipmentUpdate = NoteAddedToShipment()
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
    fun testNoUpdateOfShipmentStatus(){
        shipmentUpdate.updateShipment(standardShipment, listOf("delayed", "12342", "123456789","This package was damaged!"))
        assertEquals(standardShipment.status, "delayed")
    }
    @Test
    fun testUpdateExpectedDeliveryTime(){
        shipmentUpdate.updateShipment(standardShipment, listOf("delayed", "12345", "123456789","This package was damaged!"))
        assertEquals(standardShipment.notes[0], "This package was damaged!")
    }
    @Test
    fun testUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(standardShipment, listOf("delayed", "12345", "123456789", "This package was damaged!"))
        assertEquals(standardShipment.updateHistory.isEmpty(), true)
    }
}