package brewDay;

public class Ingredient {
	private int idOfIngredient;
	private String nameOfIngredient;
	private float amountOfIngredient;
	private char unitOfIngredient;
	
	private RecipeIngredient recipeIngredient;
	private StorageIngredient storageIngredient;
	
	public Ingredient(int idOfIngredient, String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		this.idOfIngredient = idOfIngredient;
		this.nameOfIngredient = nameOfIngredient;
		this.setAmountOfIngredient(amountOfIngredient);
		 this.unitOfIngredient = unitOfIngredient;
	}
	
	public float getAmountOfIngredient() {
		return amountOfIngredient;
	}
	public void setAmountOfIngredient(float amountOfIngredient) {
		this.amountOfIngredient = amountOfIngredient;
	}
	
	public String getNameOfIngredient() {
		return nameOfIngredient;
	}
	public void setNameOfIngredient(String nameOfIngredient) {
		this.nameOfIngredient = nameOfIngredient;
	}
	public StorageIngredient getStorageIngredient() {
		return storageIngredient;
	}
	public void setStorageIngredient(StorageIngredient storageIngredient) {
		this.storageIngredient = storageIngredient;
	}
	
	public boolean addIngredient(String name, float amount, char unit) throws Exception {
		if(amount < 0) {
			return false;
		}
		else if (this.nameOfIngredient.equals(name) && this.unitOfIngredient == unit) {
			this.setAmountOfIngredient(this.getAmountOfIngredient() + amount);
			return true;
		}
		else
			return false;
	}
	
	@SuppressWarnings("null")
	public boolean deleteIngredient(String name) {
		if(this.nameOfIngredient.equals(name)) {
			this.nameOfIngredient = null;
			this.idOfIngredient = (Integer) null;
			this.setAmountOfIngredient((Float) null);
			this.unitOfIngredient = (Character) null;
			return true;
		}
		else
			return false;
	}
}
