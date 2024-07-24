import kotlin.test.Test
import kotlin.test.assertEquals
class ShipmentFactoryTest {
    val shipmentFactory = ShipmentFactory()
    @Test
    fun createExpressShipmentTest(){
        val expressShipment = shipmentFactory.createShipment(listOf("created", "12345", "express", "0"))
        assertEquals(expressShipment!!.id, "12345")
        assertEquals(expressShipment.currentLocation, "unknown")
        assertEquals(expressShipment.status, "created")
        assertEquals(expressShipment.expectedDeliveryTimeStamp, 0)
        assertEquals(expressShipment.notes.isEmpty(), true)
        assertEquals(expressShipment.updateHistory.isEmpty(), true)
    }
    @Test
    fun createBulkShipmentTest(){
        val bulkShipment = shipmentFactory.createShipment(listOf("created", "12344", "bulk", "0"))
        assertEquals(bulkShipment!!.id, "12344")
        assertEquals(bulkShipment.currentLocation, "unknown")
        assertEquals(bulkShipment.status, "created")
        assertEquals(bulkShipment.expectedDeliveryTimeStamp, 0)
        assertEquals(bulkShipment.notes.isEmpty(), true)
        assertEquals(bulkShipment.updateHistory.isEmpty(), true)
    }
    @Test
    fun createOvernightShipmentTest(){
        val overnightShipment = shipmentFactory.createShipment(listOf("created", "12343", "express", "0"))
        assertEquals(overnightShipment!!.id, "12343")
        assertEquals(overnightShipment.currentLocation, "unknown")
        assertEquals(overnightShipment.status, "created")
        assertEquals(overnightShipment.expectedDeliveryTimeStamp, 0)
        assertEquals(overnightShipment.notes.isEmpty(), true)
        assertEquals(overnightShipment.updateHistory.isEmpty(), true)
    }
    @Test
    fun createStandardShipmentTest(){
        val standardShipment = shipmentFactory.createShipment(listOf("created", "12342", "express", "0"))
        assertEquals(standardShipment!!.id, "12342")
        assertEquals(standardShipment.currentLocation, "unknown")
        assertEquals(standardShipment.status, "created")
        assertEquals(standardShipment.expectedDeliveryTimeStamp, 0)
        assertEquals(standardShipment.notes.isEmpty(), true)
        assertEquals(standardShipment.updateHistory.isEmpty(), true)
    }
}