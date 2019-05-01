package brewDay;

public class RecipeIngredient extends Ingredient {

	public RecipeIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		super(nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	//function 1 add ingredient to the specific recipe	
	public void addIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient, int recipeId) {
		String sql = "INSERT INTO RecipeIngredient VALUES (NULL, '" + nameOfIngredient + "','" + amountOfIngredient +"','" + unitOfIngredient +"','" + recipeId;
		Database.Insert(sql);
		System.out.println("Ingredient " + nameOfIngredient + " has been successluffy added into recipe ");
	}

	
	public float getAmountOfRecipeIngredient() {
		return super.getAmountOfIngredient();
	}

	public String getNameOfRecipeIngredient() {
		return super.getNameOfIngredient();
	}


}
