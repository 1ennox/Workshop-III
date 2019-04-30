package brewDay;

public class RecipeIngredient extends Ingredient {
	
	public RecipeIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		super(nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	public float getAmountOfRecipeIngredient() {
		return super.getAmountOfIngredient();
	}

	public String getNameOfRecipeIngredient() {
		return super.getNameOfIngredient();
	}
	
	
}
