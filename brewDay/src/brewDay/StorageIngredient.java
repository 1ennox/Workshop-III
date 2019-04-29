package brewDay;

public class StorageIngredient {
<<<<<<< HEAD
	private int idOfIngredeint;
	private String nameOfStorageIngredient;
	private float amountOfStorageIngredient;
	private char unitOfStorageIngredient;
	private Brew brew;
	
	public StorageIngredient(int idOfIngredient, String nameOfStorageIngredient, char unitOfStorageIngredient) {
		this.idOfIngredeint = idOfIngredient;
		this.nameOfStorageIngredient = nameOfStorageIngredient;
		this.amountOfStorageIngredient = 0;
		this.unitOfStorageIngredient = unitOfStorageIngredient;
=======
	private int idOfStorageIngredient;
	private String nameOfStorageIngredient;
	private float amountOfStorageingredient;
	private char unitOfstorageIngredient;
	private Brew brew;
	
	public StorageIngredient(int idOfStorageIngredient, String nameOfStorageIngredient, float amountOfStorageingredient, char unitOfstorageIngredient, int brewID) {
		this.idOfStorageIngredient = idOfStorageIngredient;
		this.setNameOfStorageIngredient(nameOfStorageIngredient);
		this.amountOfStorageingredient = amountOfStorageingredient;
		this.unitOfstorageIngredient = unitOfstorageIngredient;
		this.brew.setIdOfBrew(brewID);
	}
	
	public boolean addAmount(int id, float amount) {
		if(amount < 0) {
			return false;
		}
		else if(id == this.idOfStorageIngredient) {
			this.amountOfStorageingredient += amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean subtractAmount(int id, float amount) {
		if(amount < 0) {
			return false;
		}
		else if(this.amountOfStorageingredient > amount) {
			this.amountOfStorageingredient -= amount;
			return false;
		}
		else {
			return false;
		}
	}

	public String getNameOfStorageIngredient() {
		return nameOfStorageIngredient;
	}

	public void setNameOfStorageIngredient(String nameOfStorageIngredient) {
		this.nameOfStorageIngredient = nameOfStorageIngredient;
	}
	public float getAmountOfStorageingredient() {
		return amountOfStorageingredient;
	}

	public void setAmountOfStorageingredient(float amountOfStorageingredient) {
		this.amountOfStorageingredient = amountOfStorageingredient;
>>>>>>> 7f070b3d6b80f77eae57712a471163f532ad8ab7
	}
}
