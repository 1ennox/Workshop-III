package brewDay;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ingredient {
	private String nameOfIngredient;
	private float amountOfIngredient;
	private char unitOfIngredient;

	public Ingredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) {
		this.nameOfIngredient = nameOfIngredient;
		this.amountOfIngredient = amountOfIngredient;
		this.unitOfIngredient = unitOfIngredient;
	}
	//function 1 add ingredient to the storage	
	public void addIngredient(String nameOfIngredient, float amountOfIngredient, char unitOfIngredient) throws SQLException {
		//		Ingredient i = new Ingredient(nameOfIngredient, amountOfIngredient, unitOfIngredient);
		String name = "a";
		float amount = (float) 0.0;
		String unit = "a";
		int id = 0;
		String searchInDB = "SELECT Name, Amount, Unit, IngredientID FROM Ingredient WHERE Name = '" + nameOfIngredient + "'";
		ResultSet rs = Database.Select(searchInDB);
		while(rs.next())
		{
			name = rs.getString("Name");
			amount = rs.getFloat("Amount");
			unit = rs.getString("Unit");
			id = rs.getInt("IngredientID");
		}
		if(nameOfIngredient.equals(name) && unitOfIngredient == unit.charAt(0)) {
			amount += amountOfIngredient;
			String sqlAdd = "UPDATE Ingredient SET Amount = " + amount + " WHERE IngredientID = " + id;
			Database.Update(sqlAdd);
			System.out.println("Amount of ingredient " + name + " has been added to the original amount.");
		}
		else {
			String sql = "Insert Into Ingredient Values (NULL,'" + nameOfIngredient + "','" + amountOfIngredient + "','" + unitOfIngredient + "')";
			Database.Insert(sql);
			System.out.println("Ingredient " + nameOfIngredient + " has been successfully added to the storage!");
		}
	}



	//may be used in the future	
	public float getAmountOfIngredient() {
		return amountOfIngredient;
	}
	public void setAmountOfIngredient(float amountOfIngredient) {
		this.amountOfIngredient = amountOfIngredient;
	}

	public String getNameOfIngredient() {
		return nameOfIngredient;
	}

	public void setNameOfIngredient(String nameOfIngredient) {
		this.nameOfIngredient = nameOfIngredient;
	}

	public char getUnitOfIngredient() {
		return unitOfIngredient;
	}

	public void setUnitOfIngredient(char unitOfIngredient) {
		this.unitOfIngredient = unitOfIngredient;
	}

	public boolean deleteIngredient(String name) {
		return true;
	}
}
