package Recipe_Management;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Tools{
	private boolean Oven;
	private boolean Stove;
	private boolean Pan;
	
	public Tools() {
		this(false, false, false);
	}
	public Tools(boolean oven, boolean stove, boolean pan) {
		this.Oven=oven;
		this.Stove=stove;
		this.Pan=pan;
	}
	
	
	public void setOven(boolean b) {
		this.Oven = b;
	}
	public void setStove(boolean b) {
		this.Stove = b;
	}
	public void setPan(boolean b) {
		this.Pan = b;
	}
	public boolean getOven() {
		return this.Oven;
	}
	public boolean getStove() {
		return this.Stove;
	}
	public boolean getPan() {
		return this.Pan;
	}
	
}

class Ingredient{
	private String ingre;
	private int quantity;
	private String unit;
	
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}
	public Ingredient(String ingre, int quantity, String unit) {
		this.ingre = ingre;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	public void setIngredient(String ingre, int quantity, String unit) {
		this.ingre = ingre;
		this.quantity = quantity;
		this.unit = unit;
	}
	public String getIngre() {
		return this.ingre;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public String getUnit() {
		return this.unit;
	}
}

public class Recipes {
	private String fName;
	ArrayList<String> toolsArr = new ArrayList<>();
	ArrayList<String> recipeStep = new ArrayList<>();
	HashSet<Ingredient> ingreSet=new HashSet<>();
	
	public void setFName(String name) {
		this.fName=name;
	}
	public String getFName() {
		return this.fName;
	}
	
	public boolean addRecipes(String explain) {
		return recipeStep.add(explain);
	}
	
	public void printRecipes() {
		System.out.println("arrList2.size(): "+recipeStep.size());
		int i = 0;
		for(String str:recipeStep) {
			System.out.println((i++) +"@"+str);
		}
	}
	
	public void addIngredients(Ingredient ingre) {
		ingreSet.add(ingre);
	}
	public void printIngredients() {
		System.out.println("ingreSet.size(): "+ingreSet.size());
		Iterator<Ingredient> it=ingreSet.iterator();
		while(it.hasNext()) {
			Ingredient ing = it.next();
			System.out.println(ing.getIngre()+" : "+ing.getQuantity()+ing.getUnit());
		}
	}

	public void addTools(String tool) {
		toolsArr.add(tool);
	}
	public ArrayList<String> getTools() {
		return toolsArr;
	}

}
