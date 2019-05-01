package brewDay;

public class Ingredient {
	private String nameOfIngredient;
	private float amountOfIngredient;
	private char unitOfIngredient;
	
	public Ingredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		this.nameOfIngredient = nameOfIngredient;
		this.amountOfIngredient = amountOfIngredient;
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
	
	public char getUnitOfIngredient() {
		return unitOfIngredient;
	}

	public void setUnitOfIngredient(char unitOfIngredient) {
		this.unitOfIngredient = unitOfIngredient;
	}

	public void addIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		Ingredient i = new Ingredient(nameOfIngredient, amountOfIngredient, unitOfIngredient);
		String sql = "Insert Into Ingredient Values (NULL,'" + nameOfIngredient + "','" + amountOfIngredient + "','" + unitOfIngredient + "')";
		Database.Insert(sql);
		System.out.println("Ingredient " + i.getNameOfIngredient() + " has been successfully added to the storage!");
	}

	public boolean deleteIngredient(String name) {
		return true;
	}
}
