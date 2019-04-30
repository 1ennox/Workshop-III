package brewDay;

public class Start {

	public static void main(String[] args) {
		ShoppingList sl = new ShoppingList(001);
		sl.addIngredient(001, "water", 100, 'L');
		sl.addIngredient(002, "salt", 500, 'g');
		Recipe r = new Recipe("Beer", 100, 'L', 001);
		RecipeIngredient ri1 = new RecipeIngredient(006, "water", 50, 'L');
		RecipeIngredient ri2 = new RecipeIngredient(001, "salt", 100, 'g');
		r.addRecipeIngredients(ri1);
		r.addRecipeIngredients(ri2);
		System.out.println("Recipe " + r.getNameOfRecipe() + " has been successfully added!");
		System.out.println("Now the storage ingredients are: ");
		System.out.println(sl. + ' ');
		
	}

}
