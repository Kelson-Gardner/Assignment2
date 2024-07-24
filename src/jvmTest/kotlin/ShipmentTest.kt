import kotlin.test.Test
import kotlin.test.assertEquals

class ShipmentTest {
    val notes = arrayOf<String>("This is a test note")
    val shippingUpdate = ShippingUpdate("created", "shipped", 1652712855468)
    val updateHistory = arrayOf<ShippingUpdate>()
    val location = "unknown"

    val standardShipment = StandardShipment(
        "delayed",
        "12342",
        notes,
        updateHistory,
        0,
        location
    )
    val trackerViewHelper = TrackerViewHelper()
    @Test
    fun testAddNote(){
        standardShipment.addNote("This is another test note")
        assertEquals(standardShipment.notes[1], "This is another test note")
        assertEquals(standardShipment.notes[0], "This is a test note")
    }
    @Test
    fun testAddShippingUpdate(){
        standardShipment.addShippingUpdate(shippingUpdate)
        assertEquals(standardShipment.updateHistory[0], shippingUpdate)
    }
    @Test
    fun testSubscribe(){
        standardShipment.subscribe(trackerViewHelper)
        assertEquals(standardShipment.observers[0], trackerViewHelper)
    }
    @Test
    fun testUnsubscribe(){
        standardShipment.unsubscribe(trackerViewHelper)
        assertEquals(standardShipment.observers.isEmpty(), true)
    }
    @Test
    fun testNotifyObservers(){
        standardShipment.subscribe(trackerViewHelper)
        standardShipment.addShippingUpdate(shippingUpdate)
        standardShipment.notifyObservers()
        assertEquals(trackerViewHelper.shipmentId.value, "12342")
        assertEquals(trackerViewHelper.shipmentNotes.value[0], "This is a test note")
        assertEquals(trackerViewHelper.shipmentUpdateHistory.value[1], "Shipment went from created to shipped at 2022-05-16 08:54:15")
        assertEquals(trackerViewHelper.expectedShipmentDeliveryDate.value, "1969-12-31 17:00:00")
        assertEquals(trackerViewHelper.shipmentStatus.value, "delayed")
        assertEquals(trackerViewHelper.shipmentLocation.value, "unknown")
    }
}