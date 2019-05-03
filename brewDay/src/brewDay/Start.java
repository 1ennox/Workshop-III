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
		System.out.println("The Ingredient of recipe " + name +" are as follow: ");
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
				int amount = readIntCommand();
				System.out.println("Input the unit of the ingredient: ");
				char unit = input.next().charAt(0);
				Ingredient i = new Ingredient(name, amount, unit);
				try {
					i.addIngredient(name, amount, unit);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else if(command == 2) {
				System.out.println("Input the recipe name that you want to add ingredient: ");
				Scanner input = new Scanner(System.in);
				String rName = input.nextLine();
				Recipe r = new Recipe(rName);
				if(r.whetherInDB() == false) {
					System.out.println("No such recipe found in database.");
					break;
				}
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
				try {
					ri.addIngredient(name, amount, unit, recipeId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("You must input a valid integer!");
				continue;
			}
			break;
		}
	}

	public static void brew() throws SQLException {
		while(true) {
			System.out.println("Input the name of recipe that you want to brew:");
			Scanner getInput = new Scanner(System.in);
			String recipeName = getInput.nextLine();
			Recipe r = new Recipe(recipeName);
			String command;
			if(r.whetherInDB() == false) {
				System.out.println("No such recipe fount in database.");
				break;
			}
			else {
				System.out.println("Input [Y] to implement, otherwise, input [N]");
				command = getInput.nextLine();
			}
			
			if(command.equals("Y") || command.equals("y")){
				Brew b = new Brew(r.getQuantityOfRecipe(), r);
				b.implement(r);
			}
			else if(command.equals("N") || command.equals("n")) {
				System.out.println("Implement process stop.");
				break;
			}
			else {
				System.out.println("You must input Y or N");
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
			System.out.println("5.Brew");
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
				break;
			case 4:
				addIngredient();
				break;
			case 5:
				brew();
				break;
			}
		}

	}


}
