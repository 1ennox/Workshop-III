package brewDay;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class ShoppingList {
	private String nameOfIngredient;
	private float NumberOfIngredient;
	private Date ShoppingDate;
	private ArrayList<Ingredient> ingredients;
	
	public ShoppingList(String name) {
		this.nameOfIngredient = name;
		this.NumberOfIngredient = 0;
		this.ingredients = new ArrayList<Ingredient>();
	}
	
	
	
	public void addIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		Ingredient i = new Ingredient(nameOfIngredient, amountOfIngredient, unitOfIngredient);
		this.ingredients.add(i);
		System.out.println("Ingredient " + i.getNameOfIngredient() + " has been successfully added to the shopping list!");
	}
	
	public void getNameOfAllIngredients() {
		for(int k = 0; k < ingredients.size(); k++) {
			System.out.println(ingredients.get(k).getNameOfIngredient());
		}
	}
	
	public int getSizeOfArrayList() {
		return this.ingredients.size();
	}
	
	public boolean updateNumber(float NumberOfIngredient) {
		if(NumberOfIngredient < (float)0) {
			return false;
		}
		else {
			this.NumberOfIngredient = NumberOfIngredient;
			return true;
		}
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}



	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}



	




	
	
}
