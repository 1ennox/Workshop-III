package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Start {

	public static int readIntCommand() {
		Scanner getCommand = new Scanner(System.in);
		int result;
		try {
			result = getCommand.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You muse type an integer!");
			result = readIntCommand();
		}
		while (result < 0) {
			System.out.println("Positive integers only!");
			result = readIntCommand();
		}
		getCommand.nextLine();
		return result;
	}

	public static void getAllRecipes() throws SQLException {
		String sql = " SELECT * FROM Recipe";
		ResultSet rs = Database.Select(sql);
		while(rs.next())
		{
			String Name = rs.getString("Name");
			int amount = rs.getInt("Quantity");
			String unit = rs.getString("unit");
			System.out.println(Name + " " + amount + " " + unit);
		}
		System.out.println();
	}

	public static void viewSpecificRecipe() throws SQLException {
		System.out.print("Input the recipe name that you want to check:");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		Recipe r = new Recipe(name);
		System.out.println("The Ingredient of recipe " + name +"are as follow: ");
		r.viewIngredient();
	}

	public static void addRecipe() {
		System.out.println("Input the name of the recipe (No space in bewteen):");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.println("Input the quantity of the recipe: ");
		int quantity = input.nextInt();
		System.out.println("Input the unit of the recipe: ");
		char unit = input.next().charAt(0);
		Recipe r = new Recipe(name, quantity, unit);
		r.addRecipeToDB();
		System.out.println();
	}

	public static void addIngredient() {
		while(true) {
			System.out.println("0.exit");
			System.out.println("1.Add ingredient to storage");
			System.out.println("2.Add ingredient to a recipe");
			int command = readIntCommand();
			if(command == 0) {
				break;
			}
			else if(command == 1) {
				System.out.println("Input the name of the ingredient: ");
				Scanner input = new Scanner(System.in);
				String name = input.nextLine();
				System.out.println("Input the amount of the ingredient: ");
				int amount = input.nextInt();
				System.out.println("Input the unit of the ingredient: ");
				char unit = input.next().charAt(0);
				Ingredient i = new Ingredient(name, amount, unit);
				i.addIngredient(name, amount, unit);
			}
			else if(command == 2) {
				System.out.println("Input the recipe name that you want to add ingredient: ");
				Scanner input = new Scanner(System.in);
				String rName = input.nextLine();
				String sqlGetId = "SELECT RecipeID FROM Recipe WHERE Name = '" + rName + "' ";
				ResultSet rs = Database.Select(sqlGetId);
				int recipeId = -1;
				try {
					while(rs.next()) {
						recipeId = rs.getInt("RecipeID");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.out.println("Input the name of the ingredient: ");
				String name = input.nextLine();
				System.out.println("Input the amount of the ingredient: ");
				int amount = input.nextInt();
				System.out.println("Input the unit of the ingredient: ");
				char unit = input.next().charAt(0);
				RecipeIngredient ri = new RecipeIngredient(name, amount, unit);
				ri.addIngredient(name, amount, unit, recipeId);
			}
			else {
				System.out.println("You must input a valid integer!");
				continue;
			}

		}

	}







	public static void main(String[] args) throws SQLException {
		ShoppingList sl = new ShoppingList("Shopping list 1");

		while (true) {
			System.out.println("You are in start page, input the number to select the option:");
			System.out.println("1.View all recipes");
			System.out.println("2.View ingredients of a specific recipe");
			System.out.println("3.Add recipe");
			System.out.println("4.Add ingredient");
			System.out.println("5.Brew history");
			System.out.println("6.Recommand a recipe");
			System.out.println("7.Maintain equipment");
			int command = readIntCommand();
			switch (command) {
			case 1:
				System.out.println("---All the recipes in the database are as follow---");
				getAllRecipes();
				break;
			case 2:
				viewSpecificRecipe();
				break;
			case 3:
				addRecipe();
			case 4:
				addIngredient();
			}
		}

	}
	//			if (c.equals("2")) {
	//				System.out.println("---You are in 2.Maintain ingredients---");
	//				System.out.println("Input the number to select the option you want:");
	//				System.out.println("0.Back");
	//				System.out.println("101.View ingredient 1");
	//				System.out.println("102.Edit ingredient 1");
	//				System.out.println("103.Delete ingredient 1");
	//				System.out.println("201.View ingredient 2");
	//				System.out.println("202.Edit ingredient 2");
	//				System.out.println("203.Delete ingredient 2");
	//				System.out.println("301.View ingredient 3");
	//				System.out.println("302.Edit ingredient 3");
	//				System.out.println("303.Delete ingredient 3");
	//				System.out.println("999.Add a new ingredient");
	//				while (true) {
	//					Scanner readC3 = new Scanner(System.in); // reader for command
	//					String c3 = readC3.next();
	//					if (c.equals("0")) {
	//						break;
	//					} else {
	//						System.out.println("Done!");
	//					}
	//				}
	//			}
	//			if (c.equals("3")) {
	//				System.out.println("---You are in 3.History---");
	//				System.out.println("Input the volume of the beer you want to brew: (ml)");
	//				Scanner readVolume = new Scanner(System.in);
	//				String inputVolume = readVolume.next();
	//				// output the lack of recipe here and the shopping list
	//			}
	//			if (c.equals("4")) {
	//				System.out.println("---You are in 4.Recommand a recipe---");
	//				System.out.println("Input the number to select the option you want:");
	//				System.out.println("0.Back");
	//			}
	//			if (c.equals("5")) {
	//				System.out.println("---You are in 5.Maintain equipment---");
	//				System.out.println("Input the number to select the option you want:");
	//				System.out.println("0.Back");
	//			}
	//		}

}
