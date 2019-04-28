package brewDay;

import java.util.ArrayList;

public class Recipe {
	private String nameOfRecipe;
	private float quantityOfRecipe;
	private char unit;
	private int idOfrecipe;
//	private ArrayList<RecipeIngredient> recipeIngredients;
	
	public boolean updateName(String name) {
		if(name != null) {
			this.nameOfRecipe = name;
			return true;
		}
		else
			return false;
	}
	
	public boolean updateQuantity(float quantity) {
		if(quantity < 0) {
			return false;
		}
		else {
			this.quantityOfRecipe = quantity;
			return true;
		}
	}
	
	public boolean deleteRecipe(int id) {
		if(this.idOfrecipe == id) {
			this.idOfrecipe = (Integer) null;
			this.nameOfRecipe = null;
			this.quantityOfRecipe =  (Float) null;
			this.unit = (Character) null;
			return true;
		}
		else 
			return false;
	}
	
	
}
