import kotlin.test.Test
import kotlin.test.assertEquals

class ShippedShipmentTest {
    val shipmentUpdate = ShippedShipment()
    val notes = arrayOf<String>()
    val updateHistory = arrayOf<ShippingUpdate>()
    val location = "unknown"
    val expressShipment = ExpressShipment(
        "created",
        "12345",
        notes,
        updateHistory,
        0,
        location,
        0)

    val bulkShipment = BulkShipment(
        "created",
        "12344",
        notes,
        updateHistory,
        0,
        location,
        0)

    val overnightShipment = OvernightShipment(
        "created",
        "12343",
        notes,
        updateHistory,
        0,
        location,
        0)

    val standardShipment = StandardShipment(
        "created",
        "12342",
        notes,
        updateHistory,
        0,
        location
    )

    @Test
    fun testUpdateExpressShipmentStatus(){
        shipmentUpdate.updateShipment(expressShipment, listOf("shipped", "12345", "123456789","11111111"))
        assertEquals(expressShipment.status, "shipped")
    }
    @Test
    fun testUpdateBulkShipmentStatus(){
        shipmentUpdate.updateShipment(bulkShipment, listOf("shipped", "12344", "123456789","11111111"))
        assertEquals(bulkShipment.status, "shipped")
    }
    @Test
    fun testUpdateOvernightShipmentStatus(){
        shipmentUpdate.updateShipment(overnightShipment, listOf("shipped", "12343", "123456789","11111111"))
        assertEquals(overnightShipment.status, "shipped")
    }
    @Test
    fun testUpdateStandardShipmentStatus(){
        shipmentUpdate.updateShipment(standardShipment, listOf("shipped", "12342", "123456789","11111111"))
        assertEquals(standardShipment.status, "shipped")
    }
    @Test
    fun testExpressUpdateExpectedDeliveryTime(){
        shipmentUpdate.updateShipment(expressShipment, listOf("shipped", "12345", "123456789","11111111"))
        assertEquals(expressShipment.expectedDeliveryTimeStamp, 11111111)
    }
    @Test
    fun testBulkUpdateExpectedDeliveryTime(){
        shipmentUpdate.updateShipment(bulkShipment, listOf("shipped", "12344", "123456789","11111111"))
        assertEquals(bulkShipment.expectedDeliveryTimeStamp, 11111111)
    }
    @Test
    fun testOvernightUpdateExpectedDeliveryTime(){
        shipmentUpdate.updateShipment(overnightShipment, listOf("shipped", "12343", "123456789","11111111"))
        assertEquals(overnightShipment.expectedDeliveryTimeStamp, 11111111)
    }
    @Test
    fun testUpdateExpectedDeliveryTime(){
        shipmentUpdate.updateShipment(standardShipment, listOf("shipped", "12342", "123456789","11111111"))
        assertEquals(standardShipment.expectedDeliveryTimeStamp, 11111111)
    }
    @Test
    fun testExpressUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(expressShipment, listOf("shipped", "12345", "123456789", "11111111"))
        assertEquals(expressShipment.updateHistory[0].previousStatus, "created")
        assertEquals(expressShipment.updateHistory[0].newStatus, "shipped")
        assertEquals(expressShipment.updateHistory[0].timeStamp , 123456789)
    }
    @Test
    fun testBulkUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(bulkShipment, listOf("shipped", "12344", "123456789", "11111111"))
        assertEquals(bulkShipment.updateHistory[0].previousStatus, "created")
        assertEquals(bulkShipment.updateHistory[0].newStatus, "shipped")
        assertEquals(bulkShipment.updateHistory[0].timeStamp , 123456789)
    }
    @Test
    fun testOvernightUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(overnightShipment, listOf("shipped", "12343", "123456789", "11111111"))
        assertEquals(overnightShipment.updateHistory[0].previousStatus, "created")
        assertEquals(overnightShipment.updateHistory[0].newStatus, "shipped")
        assertEquals(overnightShipment.updateHistory[0].timeStamp , 123456789)
    }
    @Test
    fun testUpdateUpdateHistory(){
        shipmentUpdate.updateShipment(standardShipment, listOf("shipped", "12342", "123456789", "11111111"))
        assertEquals(standardShipment.updateHistory[0].previousStatus, "created")
        assertEquals(standardShipment.updateHistory[0].newStatus, "shipped")
        assertEquals(standardShipment.updateHistory[0].timeStamp , 123456789)
    }
}