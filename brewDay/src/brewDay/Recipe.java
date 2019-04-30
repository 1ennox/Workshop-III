package brewDay;

import java.util.ArrayList;

public class Recipe {
	private String nameOfRecipe;
	private float quantityOfRecipe;
	private char unit;

	private int idOfrecipe;
	private ArrayList<RecipeIngredient> recipeIngredients;


	public Recipe(String nameOfRecipe, float quantityOfRecipe, char unit, int id) {
		this.setNameOfRecipe(nameOfRecipe);
		this.setQuantityOfRecipe(quantityOfRecipe);
		this.unit = unit;
		this.setIdOfRecipe(id);
		this.recipeIngredients = new ArrayList<RecipeIngredient>();
	}
	
	public int getIdOfrecipe() {
		return idOfrecipe;
	}

	public void setIdOfrecipe(int idOfrecipe) {
		this.idOfrecipe = idOfrecipe;
	}


	public void setRecipeIngredients(ArrayList<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	
	public char getUnit() {
		return unit;
	}

	public void setUnit(char unit) {
		this.unit = unit;
	}

	public ArrayList<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void addRecipeIngredients(RecipeIngredient recipeIngredient) {
		this.recipeIngredients.add(recipeIngredient);
	}
	
	public int getIdOfRecipe() {
		return idOfrecipe;
	}

	public void setIdOfRecipe(int idOfRecipe) {
		this.idOfrecipe = idOfRecipe;
	}

	public float getQuantityOfRecipe() {
		return quantityOfRecipe;
	}

	public void setQuantityOfRecipe(float quantityOfRecipe) {
		this.quantityOfRecipe = quantityOfRecipe;
	}

	public String getNameOfRecipe() {
		return nameOfRecipe;
	}

	public void setNameOfRecipe(String nameOfRecipe) {
		this.nameOfRecipe = nameOfRecipe;
	}
	
	public boolean deleteRecipeIngredient(RecipeIngredient recipeIngredient) {
		int k = 0;
		for(RecipeIngredient nameOfRecipeIngredient: recipeIngredients) {
			if(k == recipeIngredients.size()) {
				return false;
			}
			if(nameOfRecipeIngredient.equals(recipeIngredient.getNameOfRecipeIngredient())) {
				recipeIngredients.remove(recipeIngredient);
				return true;
			}
			k += 1;
		}
		return false;
	}
	
	public boolean updateName(String name) {
		if(name != null) {
			this.setNameOfRecipe(name);
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
			this.setQuantityOfRecipe(quantity);
			return true;
		}
	}
	
	@SuppressWarnings("null")
	public boolean deleteRecipe(int id) {
		if(this.getIdOfRecipe() == id) {
			this.setIdOfRecipe((Integer) null);
			this.setNameOfRecipe(null);
			this.setQuantityOfRecipe((Float) null);
			this.unit = (Character) null;
			return true;
		}
		else 
			return false;
	}	
}
