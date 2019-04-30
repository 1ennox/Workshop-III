package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Brew {
	private float batchSize;
	private Date date;
	private Date time;

	private Note note;
	private Recipe recipe;
	private StorageIngredient ingredient;

	public Brew(float batchSize, Recipe recipe) {
		if(batchSize > 0) {
			this.batchSize = batchSize;
			this.date = new Date(System.currentTimeMillis());
			this.recipe = recipe; 
		}
	}

	public boolean implement(float batchSize, Recipe recipe) throws SQLException {
		int k = 0;
		if (batchSize < 0) {
			return false;
		} else {
			int flag = 0;
			ResultSet getRId = Database.Select("SELECT RecipeID FROM Recipe WHERE NAME = '" + recipe.getNameOfRecipe() + "'");
			int Rid = getRId.getInt("RecipeID");
			ResultSet getRI = Database.Select("SELECT Name, Amount FROM Recipe Where RecipeID = " + Rid);
			while (getRI.next()) {
				String nameOfRI = getRI.getString("Name");
				int amountOfRI = getRI.getInt("Amount");
				ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM Ingredient WHERE Name = '" + nameOfRI + "'");
				int amountOfIngredient = getAmountOfIngredient.getInt("Amount");
				if (amountOfRI >= amountOfIngredient) {
					continue;
				} else {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				while (getRI.next()) {
					String nameOfRI = getRI.getString("Name");
					int amountOfRI = getRI.getInt("Amount");
					ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM Ingredient WHERE Name = '" + nameOfRI + "'");
					int amountOfIngredient = getAmountOfIngredient.getInt("Amount");
					int result = amountOfIngredient - amountOfRI;
					String k1 = "UPDATE Ingredient SET Amount = " + result + "WHERE Name = '" + nameOfRI + "'";
					Database.Update(k1);
					return true;
				}

			}
			return false;
		}
	}
	}

