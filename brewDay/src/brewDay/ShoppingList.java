package brewDay;

import java.util.Date;
import java.util.Set;

public class ShoppingList {
//	private String nameOfIngredient;
	private float NumberOfIngredient;
	private Date ShoppingList;
	private int idOfShoppingDate;
	private Set<Ingredient> ingredients;
	
	public ShoppingList(int id) {
		this.idOfShoppingDate = id;
		this.NumberOfIngredient = 0;
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
	
	public boolean delete(int id) {
		if(this.idOfShoppingDate == id) {
			Set.clear(Ingredient);
		}
	}
}