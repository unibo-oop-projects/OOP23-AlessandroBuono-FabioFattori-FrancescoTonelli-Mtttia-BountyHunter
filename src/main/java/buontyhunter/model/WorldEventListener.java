package buontyhunter.model;

public interface WorldEventListener {

	/**
	 * Notify the listener that an event has occurred
	 * @param ev the event that has occurred
	 */
	void notifyEvent(WorldEvent ev);
}
