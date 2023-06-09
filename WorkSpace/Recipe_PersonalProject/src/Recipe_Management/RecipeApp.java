package Recipe_Management;

import java.util.*;
/**
 * @author Jaewon You
 * <br>
 * 레시피를 등록, 조회하는 프로그램<br>
 * 기능 : 등록, 전체목록보기, 검색, 삭제<br>
 * 필요한 입력값 : 음식이름, 도구, 재료, 조리단계<br>
 * 등록 후 ArrayList에 저장<br>
 *  */
public class RecipeApp {
	Scanner sc = new Scanner(System.in);
	ArrayList<Recipe> myRecipes = new ArrayList<>();
	Recipe rcp;
	
	/** 메인 메뉴를 출력하는 메소드 */
	public void menu() {
		System.out.println("------RecipeApp v1.0------");
		System.out.println(" 1. 레시피 등록");
		System.out.println(" 2. 레시피 출력");
		System.out.println(" 3. 레시피 검색");
		System.out.println(" 4. 레시피 삭제");
		System.out.println(" 9. 종  료");
		System.out.println("----------------------------");
		System.out.println(" 메뉴 번호를 선택하세요 =>");
		System.out.println("----------------------------");
		
	}
	
	/** 레시피 등록시 각 항목별 입력을 위해 항목을 선택하는 메소드*/
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
	
	/** 레시피를 항목별로 입력받는 메소드 */
	public void inputRecipe() {
		sc.skip("\n");
		System.out.print("음식이름 : ");
		String name = sc.nextLine();
		rcp.setFName(name);
		
		rcp.OSP.getOSP();
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
				rcp.addTool(sc.nextLine());
				break;
			case 2: //재료 추가
				System.out.print("재료 추가 : ");
				String iName = sc.nextLine();
				System.out.print("재료양(정수) : ");
				int iQuantity = sc.nextInt();
				sc.skip("\n");
				System.out.print("재료 단위 : ");
				String iUnit = sc.nextLine();
				rcp.addIngredients(new Ingredient(iName, iQuantity, iUnit));
				break;
			case 3: //조리 단계 추가
				System.out.print("조리단계 추가 : ");
				rcp.addSteps(sc.nextLine());
				break;
			}
		}
	}
	
	
	/** 레시피 등록하는 메소드 */
	public void registerRecipe() {
		rcp = new Recipe();
		
		inputRecipe();
		
		String info = rcp.RecipeToString();
		System.out.println(info);
		System.out.println(">>위 정보를 등록할까요? [1.yes 2.no]");
		//arr에 저장하기
		int no = Integer.parseInt(sc.nextLine());
		if(no==1) {
			myRecipes.add(rcp);
			System.out.println("등록 완료!! 현재 등록 레시피 개수: "
							+myRecipes.size()+"개");
		}else {
			System.out.println("등록을 취소하였습니다!!");
		}
	}

	/** 레시피 출력하는 메소드 */
	public void printRecipe() {
		System.out.println("***총 "+myRecipes.size()+"개의 레시피***");
		for(Recipe rcp:myRecipes) {
			if(rcp != null) {
				System.out.println(rcp.RecipeToString());
			}
		}
	}

	/** 레시피 검색하는 메소드 */
	public Recipe searchRecipe(String search_str) {
		System.out.print("검색할 제목 : ");
		sc.skip("\n");
		String str = sc.nextLine();
		Recipe srcp = new Recipe();
		int i = 1;
		ArrayList<String> Searched = new ArrayList<>();
		boolean searched = true;

		//검색어를 포함하는 요리명 검색
		for(Recipe rcp:myRecipes) {
			if(rcp.getFName().contains(str)) {
				Searched.add(rcp.getFName());
				System.out.println((i++)+rcp.getFName());
			}
		}
		if(myRecipes.size()==0) searched=false;
		//보여지는 목록에서 선택
		int n = 0;
		while(searched) {
			System.out.println(search_str+ "할 레시피 선택(정수) : ");
			n = sc.nextInt();
			
			if(n<1||n>=i) {
				System.out.println("잘못된 입력입니다. 다시 선택하세요.");
			}else {
				break;
			}
		}
		//해당하는 레시피 반환변수에 입력
		for(Recipe rcp:myRecipes) {
			if(rcp.compareRecipe(Searched.get(n-1))) {
				srcp = rcp;
				break;
			}
			
		}
		return srcp;
	}

	/** 레시피 삭제하는 메소드 */
	public void removeRecipe() {
		Recipe Srcp = this.searchRecipe("삭제");
		if(Srcp==null) {
			System.out.println("검색결과가 없습니다.");
			return;
		}
		myRecipes.remove(Srcp);
		System.out.println("레시피를 삭제하였습니다!!");
	}

	/** 테스트용 더미 항목 자동입력 */
	public void setTestCase() {
		Recipe testRCP = new Recipe();
		testRCP.setFName("마카롱");
		
		testRCP.OSP.setOven(true);
		testRCP.addTool("거품기");
		testRCP.addTool("볼");
		testRCP.addTool("짤주머니");
		testRCP.addTool("스패출러");
		
		testRCP.addIngredients(new Ingredient("아몬드 파우더", 140, "g"));
		testRCP.addIngredients(new Ingredient("슈가파우더", 150, "g"));
		testRCP.addIngredients(new Ingredient("달걀흰자", 6, "개"));
		testRCP.addIngredients(new Ingredient("흰설탕", 150, "g"));
		testRCP.addIngredients(new Ingredient("물", 40, "ml"));
		testRCP.addIngredients(new Ingredient("화이트 커버춰 초콜릿", 75, "g"));
		testRCP.addIngredients(new Ingredient("생크림", 50, "g"));
		testRCP.addIngredients(new Ingredient("바닐라빈", 2, "g"));
		
		testRCP.addSteps("아몬드 가루와 수거파우더를 체쳐놓는다.");
		testRCP.addSteps("1에 달걀흰자를 넣고 잘 섞어준다.");
		testRCP.addSteps("냄비에 설탕과 준비된 물을 넣어 시럽을 만든다.");
		testRCP.addSteps("흰자로 머랭을 만든다.");
		testRCP.addSteps("시럽을 머랭에조금씩 나눠 흘리면서 계속 휘핑해준다.");
		testRCP.addSteps("가루 반죽과 머랭을 잘 섞어준다음 짤 주머니에 넣어 유산지를 깐 후라이팬에 동글동글하게 패닝한다.");
		testRCP.addSteps("실온에서 30분 정도 건조시켜 표면이 꾸덕하게 한다.");
		testRCP.addSteps("생크림에 바닐라빈을 잘라 씨를 긁어 넣고 끓여준다.");
		testRCP.addSteps("화이트 초코렛에 생크림을 녹여부어준다(초코렛이 녹지 않으면 뜨거운 물에 중탕한다).");
		testRCP.addSteps("만든 가나슈 필링를 짤 주머니에 넣고 냉장고에 보관한다.");
		testRCP.addSteps("표면이 꾸덕해진 마카롱을 160도에서 10분간 굽는다(프릴이 생길 때까지 굽는다).");
		testRCP.addSteps("잘 구워진 마카롱을 식혀준 후 잘 떼어낸 후 식힘 망에서 다시 식혀준다.");
		testRCP.addSteps("잘 식은 마카롱에 냉장보관한 가나슈를 샌드한다.");
		
		myRecipes.add(testRCP);
	}
	
	/** 정수값을 받는 메소드*/
	public int getInt() throws NotIntegerException{
		String s;
		sc.skip("\n");
		s= sc.nextLine();
		for(int i=0;i<s.length();i++) {
			if(!Character.isDigit(s.charAt(i))) {
				throw new NotIntegerException("잘못된 입력입니다. 정수가 아닙니다.");
			}
		}
		int num = Integer.parseInt(s);
		return num;
	}
	
	/** 프로그램 전체를 실행하는 메인 메소드 */
	public static void main(String[] args) {
		RecipeApp app = new RecipeApp();
		int num=0;
		while(true) {
			app.menu();
			num=app.sc.nextInt();
			if(num==9) {
				System.out.println("Bye Bye~~");
				break;
			}
			if(num==1000) {
				app.setTestCase();
			}
			else if(num<1||num>4) {
				System.out.println("메뉴에 없는 번호입니다. 다시 입력하세요.");
				continue;
			}
			
			switch (num) {
			case 1: //레시피 등록
				app.registerRecipe();
				break;
			case 2: //모든 레시피 목록 출력
				app.printRecipe();
				break;
			case 3: //검색
				Recipe Srcp = app.searchRecipe("검색");
				if(Srcp==null) {
					System.out.println("검색결과가 없습니다.");
					break;
				}
				System.out.println(Srcp.RecipeToString());
				break;
			case 4: //삭제
				app.removeRecipe();
				break;
			}
		}//while ---
	}

}
