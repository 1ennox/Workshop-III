package brewDay;
/*
 * Noting in this class now.
 */
public interface ModelListener {
	public void update();
	// This interface will be implemented by views and the model will use this
	// interface to notify the views that they need to
	// update themselves.

}
