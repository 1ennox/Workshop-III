package brewDay;
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
	
	public boolean implement(float batchSize, Recipe recipe) {
		int k = 0;
		if(batchSize < 0) {
			return false;
		}
		else {
			ArrayList<RecipeIngredient> RI = recipe.getRecipeIngredients();
			for(int k1 = 0; k1 < RI.size(); k1++) {
				
				if( )
			}
		}
	}

}

