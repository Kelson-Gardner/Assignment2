import kotlin.test.Test
import kotlin.test.assertEquals

class CanceledShipmentTest {
    val shipmentUpdate = CanceledShipment()
    val notes = arrayOf<String>()
    val updateHistory = arrayOf<ShippingUpdate>()
    val location = "unknown"
    val expressShipment = ExpressShipment(
        "shipped",
        "12345",
        notes,
        updateHistory,
        0,
        location,
        0)

    val bulkShipment = BulkShipment(
        "shipped",
        "12344",
        notes,
        updateHistory,
        0,
        location,
        0)

    val overnightShipment = OvernightShipment(
        "shipped",
        "12343",
        notes,
        updateHistory,
        0,
        location,
        0)

    val standardShipment = StandardShipment(
        "shipped",
        "12342",
        notes,
        updateHistory,
        0,
        location
    )

    @Test
    fun testUpdateExpressShipmentStatus(){
        shipmentUpdate.updateShipment(expressShipment, listOf("canceled", "12345", "123456789"))
        assertEquals(expressShipment.status, "canceled")
    }
    @Test
    fun testUpdateBulkShipmentStatus(){
        shipmentUpdate.updateShipment(bulkShipment, listOf("canceled", "12344", "123456789"))
        assertEquals(bulkShipment.status, "canceled")
    }
    @Test
    fun testUpdateOvernightShipmentStatus(){
        shipmentUpdate.updateShipment(overnightShipment, listOf("canceled", "12343", "123456789"))
        assertEquals(overnightShipment.status, "canceled")
    }
    @Test
    fun testUpdateStandardShipmentStatus(){
        shipmentUpdate.updateShipment(standardShipment, listOf("canceled", "12342", "123456789"))
        assertEquals(standardShipment.status, "canceled")
    }
    @Test
    fun testBulkUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(bulkShipment, listOf("canceled", "12345", "123456789"))
        assertEquals(bulkShipment.updateHistory[0].previousStatus, "shipped")
        assertEquals(bulkShipment.updateHistory[0].newStatus, "canceled")
        assertEquals(bulkShipment.updateHistory[0].timeStamp , 123456789)
    }
    @Test
    fun testOvernightUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(overnightShipment, listOf("canceled", "12344", "123456789"))
        assertEquals(overnightShipment.updateHistory[0].previousStatus, "shipped")
        assertEquals(overnightShipment.updateHistory[0].newStatus, "canceled")
        assertEquals(overnightShipment.updateHistory[0].timeStamp , 123456789)
    }
    @Test
    fun testStandardUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(standardShipment, listOf("canceled", "12343", "123456789"))
        assertEquals(standardShipment.updateHistory[0].previousStatus, "shipped")
        assertEquals(standardShipment.updateHistory[0].newStatus, "canceled")
        assertEquals(standardShipment.updateHistory[0].timeStamp , 123456789)
    }
    @Test
    fun testExpressUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(expressShipment, listOf("canceled", "12342", "123456789"))
        assertEquals(expressShipment.updateHistory[0].previousStatus, "shipped")
        assertEquals(expressShipment.updateHistory[0].newStatus, "canceled")
        assertEquals(expressShipment.updateHistory[0].timeStamp , 123456789)
    }
}