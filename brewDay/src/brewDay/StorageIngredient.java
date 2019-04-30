package brewDay;

public class StorageIngredient extends Ingredient {
	private Brew brew;

	public StorageIngredient(int idOfIngredient, String nameOfIngredient, float amountOfIngredient,
			char unitOfIngredient) {
		super(idOfIngredient, nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	public boolean addAmount(String name, float amount) {
		setAmountOfIngredient(getAmountOfIngredient() + super.getAmountOfIngredient());
		return true;
	}
	public boolean subtractAmount(String name, float amount) {
		if(getAmountOfIngredient() >= amount) {
			setAmountOfIngredient(getAmountOfIngredient() - super.getAmountOfIngredient());
			return true;
		}
		else
			return false;
	}
}
