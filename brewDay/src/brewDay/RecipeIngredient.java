package brewDay;


public class RecipeIngredient {
	private String nameOfRecipeIngredient;
	private float amountOfRecipeIngredient;
	private int idOfRecipeIngredient;
	
	public RecipeIngredient(String nameOfRecipeIngredient, float amountOfRecipeIngredient, int idOfRecipeIngredient, int recipeId) {
		this.setNameOfRecipeIngredient(nameOfRecipeIngredient);
		this.setAmountOfRecipeIngredient(amountOfRecipeIngredient);
		this.idOfRecipeIngredient = idOfRecipeIngredient;
	}
	
	public boolean updateAmount (float amount) {
		if(amount < 0) {
			return false;
		}
		else {
			this.setAmountOfRecipeIngredient(amount);
			return true;
		}
	}
	
	public boolean updateName(String name) {
		if(name != null) {
			this.setNameOfRecipeIngredient(name);
			return true;
		}
		else
			return false;
	}
	
	@SuppressWarnings("null")
	public boolean delete(int id) {
		if(this.idOfRecipeIngredient == id) {
			this.setNameOfRecipeIngredient(null);
			this.setAmountOfRecipeIngredient((Float) null);
			this.idOfRecipeIngredient = (Integer) null;
			return true;
		}
		else {
			return false;
		}
		
	}

	public String getNameOfRecipeIngredient() {
		return nameOfRecipeIngredient;
	}

	public void setNameOfRecipeIngredient(String nameOfRecipeIngredient) {
		this.nameOfRecipeIngredient = nameOfRecipeIngredient;
	}

	public float getAmountOfRecipeIngredient() {
		return amountOfRecipeIngredient;
	}

	public void setAmountOfRecipeIngredient(float amountOfRecipeIngredient) {
		this.amountOfRecipeIngredient = amountOfRecipeIngredient;
	}
}
