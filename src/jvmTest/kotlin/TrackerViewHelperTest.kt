import kotlin.test.Test
import kotlin.test.assertEquals

class TrackerViewHelperTest {
    var trackerViewHelper = TrackerViewHelper()
    val notes = arrayOf<String>("This is a test note")
    val shippingUpdate = ShippingUpdate("created", "shipped", 1652712855468)
    val updateHistory = arrayOf(shippingUpdate)
    val location = "unknown"
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
    fun testUpdateExpress(){
        trackerViewHelper.update(expressShipment)
        assertEquals(trackerViewHelper.shipmentId.value, "12345")
        assertEquals(trackerViewHelper.shipmentNotes.value[0], "This is a test note")
        assertEquals(trackerViewHelper.shipmentUpdateHistory.value[1], "Shipment went from created to shipped at 2022-05-16 08:54:15")
        assertEquals(trackerViewHelper.expectedShipmentDeliveryDate.value, "1969-12-31 17:00:00")
        assertEquals(trackerViewHelper.shipmentStatus.value, "delayed")
        assertEquals(trackerViewHelper.shipmentLocation.value, "unknown")
    }
    @Test
    fun testUpdateBulk(){
        trackerViewHelper.update(bulkShipment)
        assertEquals(trackerViewHelper.shipmentId.value, "12344")
        assertEquals(trackerViewHelper.shipmentNotes.value[0], "This is a test note")
        assertEquals(trackerViewHelper.shipmentUpdateHistory.value[1], "Shipment went from created to shipped at 2022-05-16 08:54:15")
        assertEquals(trackerViewHelper.expectedShipmentDeliveryDate.value, "1969-12-31 17:00:00")
        assertEquals(trackerViewHelper.shipmentStatus.value, "delayed")
        assertEquals(trackerViewHelper.shipmentLocation.value, "unknown")
    }
    @Test
    fun testUpdateOvernight(){
        trackerViewHelper.update(overnightShipment)
        assertEquals(trackerViewHelper.shipmentId.value, "12343")
        assertEquals(trackerViewHelper.shipmentNotes.value[0], "This is a test note")
        assertEquals(trackerViewHelper.shipmentUpdateHistory.value[1], "Shipment went from created to shipped at 2022-05-16 08:54:15")
        assertEquals(trackerViewHelper.expectedShipmentDeliveryDate.value, "1969-12-31 17:00:00")
        assertEquals(trackerViewHelper.shipmentStatus.value, "delayed")
        assertEquals(trackerViewHelper.shipmentLocation.value, "unknown")
    }
    @Test
    fun testUpdateStandard(){
        trackerViewHelper.update(standardShipment)
        assertEquals(trackerViewHelper.shipmentId.value, "12342")
        assertEquals(trackerViewHelper.shipmentNotes.value[0], "This is a test note")
        assertEquals(trackerViewHelper.shipmentUpdateHistory.value[1], "Shipment went from created to shipped at 2022-05-16 08:54:15")
        assertEquals(trackerViewHelper.expectedShipmentDeliveryDate.value, "1969-12-31 17:00:00")
        assertEquals(trackerViewHelper.shipmentStatus.value, "delayed")
        assertEquals(trackerViewHelper.shipmentLocation.value, "unknown")
    }

    @Test
    fun testFormatShipmentUpdateHistory(){
        trackerViewHelper.update(standardShipment)
        assertEquals(trackerViewHelper.shipmentUpdateHistory.value[1], "Shipment went from created to shipped at 2022-05-16 08:54:15")
    }
    @Test
    fun testFormatTimeStamp(){
        trackerViewHelper.update(standardShipment)
        assertEquals(trackerViewHelper.expectedShipmentDeliveryDate.value, "1969-12-31 17:00:00")
    }
}