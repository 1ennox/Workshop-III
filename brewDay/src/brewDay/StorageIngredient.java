package brewDay;

<<<<<<< HEAD
public class StorageIngredient extends Ingredient {
=======
public class StorageIngredient {
<<<<<<< HEAD
	private int idOfIngredeint;
	private String nameOfStorageIngredient;
	private float amountOfStorageIngredient;
	private char unitOfStorageIngredient;
	private Brew brew;
	
	public StorageIngredient(int idOfIngredient, String nameOfStorageIngredient, char unitOfStorageIngredient) {
		this.idOfIngredeint = idOfIngredient;
		this.nameOfStorageIngredient = nameOfStorageIngredient;
		this.amountOfStorageIngredient = 0;
		this.unitOfStorageIngredient = unitOfStorageIngredient;
=======
	private int idOfStorageIngredient;
	private String nameOfStorageIngredient;
	private float amountOfStorageingredient;
	private char unitOfstorageIngredient;
>>>>>>> e319a684b2b534fddcef2da09c295c00a9655736
	private Brew brew;
	
	public StorageIngredient(int idOfIngredient, String nameOfIngredient, float amountOfIngredient,
			char unitOfIngredient) {
		super(idOfIngredient, nameOfIngredient, amountOfIngredient, unitOfIngredient);
	}

	public boolean addAmount(String name, float amount) {
		
		setAmountOfIngredient(getAmountOfIngredient() + super.getAmountOfIngredient());
	}
	

<<<<<<< HEAD
=======
	public void setAmountOfStorageingredient(float amountOfStorageingredient) {
		this.amountOfStorageingredient = amountOfStorageingredient;
>>>>>>> 7f070b3d6b80f77eae57712a471163f532ad8ab7
	}
>>>>>>> e319a684b2b534fddcef2da09c295c00a9655736
}
