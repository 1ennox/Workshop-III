package brewDay;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		ShoppingList sl = new ShoppingList("Shopping list 1");
		sl.addIngredient("fuckDatabasejarpack", 100, 'L');
//		sl.addIngredient("salt", 500, 'g');
////
//		Recipe r = new Recipe("Beer", 100, 'L');
//		RecipeIngredient ri1 = new RecipeIngredient("water", 50, 'L');
//		RecipeIngredient ri2 = new RecipeIngredient("salt", 100, 'g');
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
		System.out.println("---Welcome to Brew Day!---\n");
		System.out.println("Input the number to select the option you want:");
		System.out.println("1.Maintain recipe");
		System.out.println("2.Maintain ingredients");
		System.out.println("3.History");
		System.out.println("4.Recommand a recipe");
		System.out.println("5.Maintain equipment");

		while (true) {
			Scanner readC = new Scanner(System.in); // reader for command
			String c = readC.next();
			if (c.equals("1")) {
				System.out.println("---You are in 1.Maintain recipe---");
				System.out.println("Input the number to select the option you want:");
				System.out.println("0.Back");
				System.out.println("101.View recipe 1");
				System.out.println("102.Edit recipe 1");
				System.out.println("103.Delete recipe 1");
				System.out.println("201.View recipe 2");
				System.out.println("202.Edit recipe 2");
				System.out.println("203.Delete recipe 2");
				System.out.println("301.View recipe 3");
				System.out.println("302.Edit recipe 3");
				System.out.println("303.Delete recipe 3");
				System.out.println("999.Add a new recipe");
				while (true) {
					Scanner readC2 = new Scanner(System.in); // reader for command
					String c2 = readC2.next();
					if (c.equals("0")) {
						break;
					} else {
						System.out.println("Done!");
					}
				}
			}
			if (c.equals("2")) {
				System.out.println("---You are in 2.Maintain ingredients---");
				System.out.println("Input the number to select the option you want:");
				System.out.println("0.Back");
				System.out.println("101.View ingredient 1");
				System.out.println("102.Edit ingredient 1");
				System.out.println("103.Delete ingredient 1");
				System.out.println("201.View ingredient 2");
				System.out.println("202.Edit ingredient 2");
				System.out.println("203.Delete ingredient 2");
				System.out.println("301.View ingredient 3");
				System.out.println("302.Edit ingredient 3");
				System.out.println("303.Delete ingredient 3");
				System.out.println("999.Add a new ingredient");
				while (true) {
					Scanner readC3 = new Scanner(System.in); // reader for command
					String c3 = readC3.next();
					if (c.equals("0")) {
						break;
					} else {
						System.out.println("Done!");
					}
				}
			}
			if (c.equals("3")) {
				System.out.println("---You are in 3.History---");
				System.out.println("Input the volume of the beer you want to brew: (ml)");
				Scanner readVolume = new Scanner(System.in);
				String inputVolume = readVolume.next();
				// output the lack of recipe here and the shopping list
			}
			if (c.equals("4")) {
				System.out.println("---You are in 4.Recommand a recipe---");
				System.out.println("Input the number to select the option you want:");
				System.out.println("0.Back");
			}
			if (c.equals("5")) {
				System.out.println("---You are in 5.Maintain equipment---");
				System.out.println("Input the number to select the option you want:");
				System.out.println("0.Back");
			}
		}
	}
}
