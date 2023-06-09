package Recipe_Management;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RecipeHandler implements ActionListener , ItemListener {
	
	HomeGUI app;
	
	public RecipeHandler(HomeGUI happ) {
		this.app = happ;
	}

	@Override
	public void actionPerformed(ActionEvent e){ //[3]
		Object obj = e.getSource();
		if(obj==app.btList) {
			app.card.show(app.pC, "List");
			String str = "";
			for(Recipe rcp:app.myRecipes) {
				System.out.println(rcp.RecipeToString());
				str+= ((app.myRecipes.indexOf(rcp)+1)+". ");
				str+= (rcp.getFName()+"\n");
			}
			app.pList.ta.setText(str);
		}else if(obj==app.btAdd) {
			app.res = new Recipe();
			app.card.show(app.pC, "Add");
		}else if(obj==app.btSearch) {
			app.card.show(app.pC, "Search");
		}else if(obj==app.btDel) {
			app.card.show(app.pC, "Delete");
		}else if(obj==app.btPrint) {
			app.card.show(app.pC, "Print");
		}else if(obj==app.btEdit) {
			app.card.show(app.pC, "Edit");
		}
		
		else if(obj==app.pAdd.btAddTools) {
			addTools();
		}else if(obj==app.pAdd.btAddIngredients) {
			addIngre();
		}else if(obj==app.pAdd.btAddStep) {
			addStep();
		}else if(obj==app.pAdd.btComplete) {
			addComplete();
		}
		
		else if(obj==app.pSearch.btSearch) {
			ArrayList<Recipe> Srcp = app.searchRecipe(app.pSearch.tfSearch.getText());
			if(Srcp.size() == 0) {
				app.pSearch.taSearch.setText("\n  ---검색 결과가 없습니다.---");
			}else {
				app.pSearch.taSearch.setText("");
				for(Recipe rcp:Srcp) {
					app.pSearch.taSearch.append(rcp.RecipeToString()+"\n\n");
				}
			}
			System.out.println("검색버튼 누름");
		}
	}
	
	public void itemStateChanged(ItemEvent e){
		boolean selected;
		if(e.getStateChange()==ItemEvent.SELECTED) {
			//res.addTools(e.getItem().toString().trim());
			selected = true;
		}else {
			selected = false;
		}
		
		if(e.getSource()==app.pAdd.cbOven) {
//			Oven = selected;
			app.res.OSP.setOven(selected);
		}else if(e.getSource()==app.pAdd.cbStove) {
//			Stove = selected;
			app.res.OSP.setStove(selected);
		}else if(e.getSource()==app.pAdd.cbPan) {
//			Pan = selected;
			app.res.OSP.setPan(selected);
		}else if(e.getSource()==app.pAdd.cbPot) {
//			Pot = selected;
			app.res.OSP.setPot(selected);
		}
		//----
		app.pAdd.taPreviewTools.append(app.res.OSP.getTrues());
		app.pAdd.taPreviewTools.setText(app.res.OSP.getTrues());
		System.out.println(app.res.OSP.getTrues());
		JOptionPane.showMessageDialog(null, "---===---");
		JOptionPane.showMessageDialog(null, app.res.OSP.getTrues());
		app.pAdd.taPreviewSteps.setText("1----");
		//---
		app.pAdd.repaint();
	}
	
	// 데이터 관리 method
	public void addTools() {
		System.out.println("addTools()");
		String tool = app.pAdd.tfTools.getText();
		if(tool == null || tool.trim().isEmpty()) {
			app.showMessage("도구를 입력한 뒤 누르세요");
			app.pAdd.tfTools.requestFocus();
			return;
		}
		app.res.toolsArr.add(tool);
		app.pAdd.taPreviewTools.append(tool+"\n");
		app.pAdd.clearToolField();
	}
	
	public void addIngre() {
		System.out.println("addIngre()");
		String ingre = app.pAdd.tfIngredients.getText();
		String quan = app.pAdd.tfIngreQuantity.getText();
		String unit = app.pAdd.tfIngreUnit.getText();
		int intQuan;
		if(ingre == null || ingre.trim().isEmpty()) {
			app.showMessage("재료를 입력한 뒤 누르세요");
			app.pAdd.tfIngredients.requestFocus();
			return;
		}else if(quan == null || quan.trim().isEmpty()) {
			app.showMessage("양을 입력한 뒤 누르세요");
			app.pAdd.tfIngreQuantity.requestFocus();
			return;
		}else if(unit == null || unit.trim().isEmpty()) {
			app.showMessage("단위를 입력한 뒤 누르세요");
			app.pAdd.tfIngreUnit.requestFocus();
			return;
		}
		try {
			intQuan = Integer.parseInt(quan);
			Ingredient ingred = new Ingredient(ingre, intQuan, unit);
			app.res.ingreSet.add(ingred);
			app.pAdd.taPreviewIngre.append(ingre+" : "+intQuan+unit+"\n");
			app.pAdd.clearIngreField();
		}catch (NumberFormatException e) {
			app.showMessage("양을 정수로 입력하세요");
			app.pAdd.tfIngreQuantity.requestFocus();
		}
		
	}
	
	public void addStep() {
		System.out.println("addStep()");
		String step =  app.pAdd.tfStep.getText();
		if(step == null || step.trim().isEmpty()) {
			app.showMessage("조리단계를 입력한 뒤 누르세요");
			app.pAdd.tfStep.requestFocus();
			return;
		}
		app.res.recipeStep.add(step);
		app.pAdd.taPreviewSteps.append("- "+step+"\n");
		app.pAdd.clearStepField();
	}
	
	public void addComplete() {
		System.out.println("addStep()");
		System.out.println(app.res.getClass());
		System.out.println();
		app.myRecipes.add(app.res);
		app.pAdd.clearAllField();
	}
	
}
