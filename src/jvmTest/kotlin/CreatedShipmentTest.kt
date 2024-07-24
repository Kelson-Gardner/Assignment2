import kotlin.test.Test
import kotlin.test.assertEquals
class CreatedShipmentTest {
    val shipmentUpdate = CreatedShipment()
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
    fun testUpdateExpressShipment(){
        shipmentUpdate.updateShipment(expressShipment, listOf("created"))
        assertEquals(expressShipment.status, "created")
    }
    @Test
    fun testUpdateBulkShipment(){
        shipmentUpdate.updateShipment(bulkShipment, listOf("created"))
        assertEquals(bulkShipment.status, "created")
    }
    @Test
    fun testUpdateOvernightShipment(){
        shipmentUpdate.updateShipment(overnightShipment, listOf("created"))
        assertEquals(overnightShipment.status, "created")
    }
    @Test
    fun testUpdateStandardShipment(){
        shipmentUpdate.updateShipment(standardShipment, listOf("created"))
        assertEquals(standardShipment.status, "created")
    }
}