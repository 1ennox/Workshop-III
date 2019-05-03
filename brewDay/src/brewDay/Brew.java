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

	public void implement(Recipe recipe) throws SQLException {
		int flag = 0;
		int Rid;
		Rid = recipe.getRecipeId();
		ResultSet getRI = Database.Select("SELECT Name, Amount FROM RecipeIngredient Where RecipeID = " + Rid);
		while (getRI.next()) {
			String nameOfRI = getRI.getString("Name");
			int amountOfRI = getRI.getInt("Amount");
			
			System.out.println("RI:" + nameOfRI + " " + amountOfRI);
			
			ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM Ingredient WHERE Name = '" + nameOfRI + "'");
			while(getAmountOfIngredient.next()) {
				String nameOfIngredient = getAmountOfIngredient.getString("Name");
				int amountOfIngredient = getAmountOfIngredient.getInt("Amount");
				System.out.println("Ingredient: "+ nameOfIngredient + " " + amountOfIngredient);
				if(nameOfIngredient.equals(nameOfRI)) {
					if (amountOfIngredient >= amountOfRI) {
						continue;
					} else {
						flag = 1;
						break;
					}
				}
			}
			System.out.println("Flag:" + flag);
		}
		if (flag == 0) {
			ResultSet getRI1 = Database.Select("SELECT Name, Amount FROM RecipeIngredient Where RecipeID = " + Rid);
			while (getRI1.next()) {
				String nameOfRI = getRI1.getString("Name");
				int amountOfRI = getRI1.getInt("Amount");
				ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM Ingredient WHERE Name = '" + nameOfRI + "'");
				while(getAmountOfIngredient.next()) {
					int amountOfIngredient = getAmountOfIngredient.getInt("Amount");
					int result = amountOfIngredient - amountOfRI;
					String k1 = "UPDATE Ingredient SET Amount = " + result + " WHERE Name = '" + nameOfRI + "'";
					Database.Update(k1);
					System.out.println("Update amount of " + nameOfRI);
				}
			}
		}else {
			System.out.println("No enough ingredient.");
		}
	}
	
}


