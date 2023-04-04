package Recipe_Management;

import java.util.*;

class Tool{
	private boolean Oven;
	private boolean Stove;
	private boolean Pan;
	private boolean Pot;
	
	public Tool() {
		this(false, false, false, false);
	}
	public Tool(boolean oven, boolean stove, boolean pot, boolean pan) {
		this.Oven=oven;
		this.Stove=stove;
		this.Pot=pot;
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
	public void setPot(boolean b) {
		this.Pot = b;
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
	public boolean getPot() {
		return this.Pot;
	}
	
	public String getTrues() {
		String str = "";
		if(Oven) str+="<오븐> ";
		if(Stove) str+="<가스레인지/인덕션> ";
		if(Pan) str+="<프라이팬> ";
		if(Pot) str+="<냄비> ";
		
		return str;
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

public class Recipe {
	private String fName;
	Tool OSP = new Tool(false, false, false, false);
	ArrayList<String> toolsArr = new ArrayList<>();
	ArrayList<String> recipeStep = new ArrayList<>();
	HashSet<Ingredient> ingreSet=new HashSet<>();
	
	public void setFName(String name) {
		this.fName=name;
	}
	public String getFName() {
		return this.fName;
	}
	
	public boolean addSteps(String explain) {
		return recipeStep.add(explain);
	}
	/*
	public void printSteps() {
		System.out.println("arrList2.size(): "+recipeStep.size());
		int i = 0;
		for(String str:recipeStep) {
			System.out.println((i++) +"@"+str);
		}
	}
	*/
	public void addIngredients(Ingredient ingre) {
		ingreSet.add(ingre);
	}
	/*
	public void printIngredients() {
		System.out.println("ingreSet.size(): "+ingreSet.size());
		Iterator<Ingredient> it=ingreSet.iterator();
		while(it.hasNext()) {
			Ingredient ing = it.next();
			System.out.println(ing.getIngre()+" : "+ing.getQuantity()+ing.getUnit());
		}
	}
	*/
	
	public void addTool(String tool) {
		toolsArr.add(tool);
	}
	/*
	public ArrayList<String> getTools() {
		return toolsArr;
	}
	*/
	
	public void input_menu() {
		System.out.println("----------------------------");
		System.out.println(" 1. 도구 추가");
		System.out.println(" 2. 재료 추가");
		System.out.println(" 3. 조리단계 추가");
		System.out.println(" 9. 종  료");
		System.out.println("----------------------------");
		System.out.println(" 메뉴 번호를 선택하세요 =>");
		System.out.println("----------------------------");
	}
	
	Scanner sc = new Scanner(System.in);
	public void input() {
		System.out.print("음식이름 : ");
		setFName(sc.nextLine());
		System.out.print("오븐 사용 여부(1.사용 / 0.미사용) : ");
		boolean bO = (sc.nextInt()==1)? true:false;
		System.out.print("가스레인지/인덕션 사용 여부(1.사용 / 0.미사용) : ");
		boolean sO = (sc.nextInt()==1)? true:false;
		System.out.print("냄비 사용 여부(1.사용 / 0.미사용) : ");
		boolean potO = (sc.nextInt()==1)? true:false;
		System.out.print("프라이팬 사용 여부(1.사용 / 0.미사용) : ");
		boolean panO = (sc.nextInt()==1)? true:false;
		OSP.setOven(bO);
		OSP.setStove(sO);
		OSP.setPot(potO);
		OSP.setPan(panO);
		while(true) {
			this.input_menu();
			int num = sc.nextInt();
			sc.skip("\n");
			if(num==9) {
				System.out.println("~~레시피 입력 종료~~");
				break;
			}
			if(num<1||num>4) {
				System.out.println("메뉴에 없는 번호에요. 다시 입력하세요.");
				continue;
			}
			switch (num) {
			case 1: //도구 추가
				System.out.print("도구 추가 : ");
				addTool(sc.nextLine());
				break;
			case 2: //재료 추가
				System.out.print("재료 추가 : ");
				String iName = sc.nextLine();
				System.out.print("재료양(정수) : ");
				int iQuantity = sc.nextInt();
				sc.skip("\n");
				System.out.print("재료 단위 : ");
				String iUnit = sc.nextLine();
				addIngredients(new Ingredient(iName, iQuantity, iUnit));
				break;
			case 3: //조리 단계 추가
				System.out.print("조리단계 추가 : ");
				addSteps(sc.nextLine());
				break;
			}
		}
	}
	
	public String RecipeToString() {
		String rts = "========"+fName+"========\n";
		rts += "[사용도구]\n"+OSP.getTrues();

		Iterator<String> it = toolsArr.iterator();
		if(it.hasNext()) rts += it.next();
		
		while(it.hasNext()) {
			rts += ", "+it.next();
		}
		rts += "\n\n[재료]\n";
		for(Ingredient ing:ingreSet) {
			rts += ing.getIngre()+": "+ing.getQuantity()+" "
					+ing.getUnit()+"\n";
		}
		rts += "\n[조리 단계]\n";
		int i = 1;
		for(String str:recipeStep) {
			rts += (i++) +". "+str+"\n";
		}
		return rts;
	}
	
	public boolean compareRecipe(String str) {
		return str.equals(fName);
	}
	/*
	public boolean containStr(String str) {
		return fName.contains(str);
	}
	*/
}