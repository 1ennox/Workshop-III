package brewDay;

public class Ingredient {
	private String nameOfIngredient;
	private float amountOfIngredient;
	private char unitOfIngredient;
	
	public Ingredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
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
	
	public void addIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		Ingredient i = new Ingredient(nameOfIngredient, amountOfIngredient, unitOfIngredient);
		String sql = "Insert Into Ingredient Values (NULL,'" + nameOfIngredient + "','" + amountOfIngredient + "','" + unitOfIngredient + "')";
		Database.Insert(sql);
		System.out.println("Ingredient " + i.getNameOfIngredient() + " has been successfully added to the shopping list!");
	}
	
	@SuppressWarnings("null")
	public boolean deleteIngredient(String name) {
		String sql = "DELETE FROM Ingredient WHERE Name = '" + name + "';"
	}
}
