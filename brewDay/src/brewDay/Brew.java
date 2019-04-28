package brewDay;
import java.util.Date;

public class Brew {
	private StorageIngredient ingredient;
	private float batchSize;
	private Date date;
	private Date time;
	private int idOfBrew;
	private Note note;
	
	public Brew(float batchSize, int idOfBrew) {
		if(batchSize > 0) {
			this.batchSize = batchSize;
			this.setIdOfBrew(idOfBrew);
		}
	}
	
	public boolean implement(float batchSize) {
		if()
	}

	public int getIdOfBrew() {
		return idOfBrew;
	}

	public void setIdOfBrew(int idOfBrew) {
		this.idOfBrew = idOfBrew;
	}
}

