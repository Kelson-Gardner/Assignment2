import kotlin.test.Test
import kotlin.test.assertEquals

class TrackingSimulatorTest {

    val notes = arrayOf<String>()
    val updateHistory = arrayOf<ShippingUpdate>()
    val location = "unknown"
    val trackingSimulator = TrackingSimulator.getInstance()
    val expressShipment = ExpressShipment(
        "delayed",
        "12345",
        notes,
        updateHistory,
        0,
        location,
        0)

    val bulkShipment = BulkShipment(
        "delayed",
        "12344",
        notes,
        updateHistory,
        0,
        location,
        0)

    val overnightShipment = OvernightShipment(
        "delayed",
        "12343",
        notes,
        updateHistory,
        0,
        location,
        0)

    val standardShipment = StandardShipment(
        "delayed",
        "12342",
        notes,
        updateHistory,
        0,
        location
    )

    @Test
    fun testAddAndFindExpressShipment(){
        trackingSimulator.addShipment(expressShipment)
        assertEquals(trackingSimulator.findShipment("12345"), expressShipment)
    }
    @Test
    fun testAddAndFindBulkShipment(){
        trackingSimulator.addShipment(bulkShipment)
        assertEquals(trackingSimulator.findShipment("12344"), bulkShipment)
    }
    @Test
    fun testAddAndFindOvernightShipment(){
        trackingSimulator.addShipment(overnightShipment)
        assertEquals(trackingSimulator.findShipment("12343"), overnightShipment)
    }
    @Test
    fun testAddAndFindStandardShipment(){
        trackingSimulator.addShipment(standardShipment)
        assertEquals(trackingSimulator.findShipment("12342"), standardShipment)
    }

    @Test
    fun testFindNoShipment(){
        assertEquals(trackingSimulator.findShipment("1212"), null)
        assertEquals(trackingSimulator.findShipment("1234"), null)
        assertEquals(trackingSimulator.findShipment("198273847"), null)
    }

}