package brewDay;

import java.util.ArrayList;

public class RecipeIngredient {
	private String nameOfRecipeIngredient;
	private float amountOfRecipeIngredient;
	private int idOfRecipeIngredient;
	private ArrayList<Recipe> recipes;
	
	public boolean updateAmount (float amount) {
		if(amount < 0) {
			return false;
		}
		else {
			this.amountOfRecipeIngredient = amount;
			return true;
		}
	}
	
	public boolean updateName(String name) {
		if(name != null) {
			this.nameOfRecipeIngredient = name;
			return true;
		}
		else
			return false;
	}
	
	@SuppressWarnings("null")
	public boolean delete(int id) {
		if(this.idOfRecipeIngredient == id) {
			this.nameOfRecipeIngredient = null;
			this.amountOfRecipeIngredient = (Float) null;
			this.idOfRecipeIngredient = (Integer) null;
			return true;
		}
		else {
			return false;
		}
		
	}
}
