package brewDay;


public class RecipeIngredient extends Ingredient {
	
	public RecipeIngredient(int idOfIngredient, String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		super(idOfIngredient, nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	public float getAmountOfRecipeIngredient() {
		return super.getAmountOfIngredient();
	}

	public String getNameOfRecipeIngredient() {
		return super.getNameOfIngredient();
	}
	
	
}
