package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Brew {
	private float batchSize;
	private String date;

	private Note note;
	private Recipe recipe;
	private StorageIngredient ingredient;

	public Brew(float batchSize, Recipe recipe) {
		if(batchSize > 0) {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
			this.date = date.format(new Date());
			this.batchSize = batchSize;
			this.recipe = recipe; 
		}
	}

	public void implement(Recipe recipe) throws SQLException { //implement the recipe that use select
		int flag = 0; //a mark
		int Rid; //recipe ID, for searching use
		Rid = recipe.getRecipeId();
		ResultSet getRI = Database.Select("SELECT Name, Amount FROM RecipeIngredient Where RecipeID = " + Rid);
		while (getRI.next()) { //get amount from the class RecipeIngredient
			String nameOfRI = getRI.getString("Name");
			int amountOfRI = getRI.getInt("Amount");
			ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM StorageIngredient WHERE Name = '" + nameOfRI + "'");
			while(getAmountOfIngredient.next()) {//get amount from the class Ingredient
				String nameOfIngredient = getAmountOfIngredient.getString("Name");
				int amountOfIngredient = getAmountOfIngredient.getInt("Amount");
				if(nameOfIngredient.equals(nameOfRI)) { //for the same ingredient in RI and ingredient
					if (amountOfIngredient >= amountOfRI) { //if the amount is enough for this operation, do other matching 
						continue;
					} else {// if no enough ingredient, the process stopped and give error message
						flag = 1;
						break;
					}
				}
			}
		}
		if (flag == 0) {//implement process
			
			ResultSet getRI1 = Database.Select("SELECT Name, Amount FROM RecipeIngredient Where RecipeID = " + Rid);
			while (getRI1.next()) {//get amount from the class RecipeIngredient
				String nameOfRI = getRI1.getString("Name");
				int amountOfRI = getRI1.getInt("Amount");
				ResultSet getAmountOfIngredient = Database.Select("SELECT Name, Amount FROM StorageIngredient WHERE Name = '" + nameOfRI + "'");
				while(getAmountOfIngredient.next()) {//get amount from the class Ingredient
					int amountOfIngredient = getAmountOfIngredient.getInt("Amount");
					int result = amountOfIngredient - amountOfRI; //subtract and update the amount in class Ingredient
					String k1 = "UPDATE StorageIngredient SET Amount = " + result + " WHERE Name = '" + nameOfRI + "'";
					Database.Update(k1); //2 while loops update every ingredient needed for this brew
					System.out.println("Update amount of " + nameOfRI);
				}
			}
			System.out.println("Brew finished.");
			String sqlBrew = "Insert Into Brew Values (NULL, " + batchSize+ " , '" + date + "' , " + Rid +")"; //insert brew data into database
			Database.Insert(sqlBrew);
		}else {
			System.out.println("No enough ingredient.");
		}
	}
	
	public void recommend() {//under developing
		System.out.println("This function is not finished yet.");
	}
	
}


