package brewDay;

import java.util.ArrayList;

public class Start {

	public static void main(String[] args) {
		ShoppingList sl = new ShoppingList("Shopping list 1");
		
		sl.addIngredient("water", 100, 'L');
//		sl.addIngredient(002, "salt", 500, 'g');
//		
//		Recipe r = new Recipe("Beer", 100, 'L', 001);
//		RecipeIngredient ri1 = new RecipeIngredient(006, "water", 50, 'L');
//		RecipeIngredient ri2 = new RecipeIngredient(001, "salt", 100, 'g');
//		r.addRecipeIngredients(ri1);
//		r.addRecipeIngredients(ri2);
//		System.out.println("Recipe " + r.getNameOfRecipe() + " has been successfully added!");
//		System.out.println("Now the storage ingredients are: ");
//		ArrayList<Ingredient> a = sl.getIngredients();
//		for(int k = 0; k < a.size(); k++) {
//			System.out.println(a.get(k).getNameOfIngredient());
//		}
//		Brew b1 = new Brew(50, 002, r);
//		b1.implement(50, 002);
	}
}
