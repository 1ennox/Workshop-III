package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
	private String nameOfRecipe;
	private float quantityOfRecipe;
	private char unit;
	private int recipeId;

	private ArrayList<RecipeIngredient> recipeIngredients;


	public Recipe(String nameOfRecipe, float quantityOfRecipe, char unit) {
		this.nameOfRecipe = nameOfRecipe;
		this.quantityOfRecipe = quantityOfRecipe;
		this.unit = unit;
		this.recipeIngredients = new ArrayList<RecipeIngredient>();

		Database.Insert("Insert Into Recipe Values (NULL,'" + nameOfRecipe + "','"+ quantityOfRecipe + "','" + unit + "')");
	}

//function 1	
	public void addRecipeIngredients(RecipeIngredient recipeIngredient) throws SQLException {
		String name = recipeIngredient.getNameOfIngredient();
		float amount = recipeIngredient.getAmountOfRecipeIngredient();
		char unit = recipeIngredient.getUnitOfIngredient();
		int recipeID = getRecipeId();
		int flag = 0;

		ResultSet rs = Database.Select("SELECT Name FROM RecipeIngredient Where RecipeID = " + recipeID);
		while(rs.next()) {
			String ingredientName = rs.getString("Name");
			if(name.equals(ingredientName)) {
				flag = 1;
				break;
			}
			else {
				continue;
			}
		}

		if(flag == 0) {
			String sqlInsert = "INSERT INTO RecipeIngredient Values (NULL,'" + name +"','" + amount + "','"+ unit +"','"+ recipeID + "')";
			Database.Insert(sqlInsert);
			this.recipeIngredients.add(recipeIngredient);
			System.out.println("Ingredient " + recipeIngredient.getNameOfIngredient() + " has been successfully added to recipe " + this.nameOfRecipe);
		}
		else {
			System.out.println("Ingredient " + name +" has already been put into the recipe.");
		}
	}
// function 2	
	public void deleteRecipe(String name) {
		while(true) {
			System.out.println("Are you sure to delete recipe " + name +" in the datase? Input [Y] for yes, [N] for no.");
			Scanner input = new Scanner(System.in);
			String c = input.nextLine();
			if(c.equals("Y") || c.equals("y")) {
				String sqlDelete = "DELETE FROM Recipe WHERE Name = '" + name +"'";
				Database.Delete(sqlDelete);
				System.out.println("Recipe " + name + " has been successfully removed from the database.");
				break;
			}
			else if(c.equals("N") || c.equals("n")) {
				System.out.println("Delete process stopped.");
				break;
			}
			else {
				System.out.println("You must input Y or N.");
			}
		}	
	}
//function 3 
	public int getRecipeId() throws SQLException {
		String sqlGetId = "SELECT RecipeID FROM Recipe WHERE Name = '" + this.nameOfRecipe + "' ";
		ResultSet rs = Database.Select(sqlGetId);
		while(rs.next()) {
			int recipeId = rs.getInt("RecipeID");
			System.out.println(recipeId);
			return recipeId;
		}
		return 000;
	}
//function 4  may need some change to the variable	
	public void deleteRecipeIngredient(String name) {
		String sqlGetId = "SELECT FROM Recipe WHERE Name = '" + nameOfRecipe + "'";
		ResultSet rs = Database.Select(sqlGetId);
		try {
			int recipeId = rs.getInt("RecipeID");
			String sqlDelete = "DELETE FROM RecipeIngredient WHERE Name = '" + name + "' and Recipe ID = '" + recipeId + "'" ;
			Database.Delete(sqlDelete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
//useless functions, but may be used in the future	
	
	public void updateQuantity(float quantity) throws SQLException {
		if(quantity > 0) {
			this.setQuantityOfRecipe(quantity);
			String sqlUpdate = "UPDATE Recipe SET Quantity = '" + quantity + "'";
			Database.Update(sqlUpdate);
		}
		else {
			System.out.println("You must input a positive number.");
		}
	}

	public char getUnit() {
		return unit;
	}

	public void setUnit(char unit) throws SQLException {
		String sqlSet = "UPDATE Recipe SET Unit = '" + unit +"' Where RecipeID = " + getRecipeId()+ "";
		Database.Update(sqlSet);
		this.unit = unit;
	}

	public float getQuantityOfRecipe() {
		return quantityOfRecipe;
	}

	public void setQuantityOfRecipe(float quantityOfRecipe) throws SQLException {
		int recipeID = getRecipeId();
		String sqlUpdate = "UPDATE Recipe SET Quantity = " + quantityOfRecipe + " WHERE RecipeID = " + recipeID ;
		Database.Update(sqlUpdate);
		this.quantityOfRecipe = quantityOfRecipe;
	}

	public String getNameOfRecipe() {
		return nameOfRecipe;
	}

	public void setNameOfRecipe(String nameOfRecipe) throws SQLException { //error, don't know why
		int recipeID = getRecipeId();
		String sqlUpdate = "UPDATE Recipe SET Name = '" + nameOfRecipe + "' WHERE RecipeID = " + recipeID ;
		Database.Update(sqlUpdate);
		this.nameOfRecipe = nameOfRecipe;
	}
}
