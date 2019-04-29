package brewDay;

public class StorageIngredient {
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
	}
}
