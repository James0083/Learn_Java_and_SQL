package Recipe_Management;

import java.awt.*;
import javax.swing.*;

public class AddPage extends JPanel //implements ActionListener
{
	HomeGUI app;
	// Fields
	// 음식이름, 필요한 도구, 재료, 과정
	JPanel pN = new JPanel(), pC = new JPanel(), pS = new JPanel();
	JPanel pN_sub_1, pN_sub_2, pN_sub_3, pN_sub_4;
	JCheckBox cbOven, cbStove, cbPan, cbPot;
	JLabel lbTitle, lbTools, lbIngredients, lbStep;
	JTextField tfTitle, tfTools, tfIngredients, tfIngreQuantity, tfIngreUnit, tfStep;
	JButton btAddTools, btAddIngredients, btAddStep, btComplete;
	JTextArea taPreviewTools, taPreviewIngre, taPreviewSteps;
	
//	String PreviewStr = "";
	String ToolsStr = "[사용도구]\n", IngreStr = "[재료]\n"
			, StepStr = "[요리순서]\n";
	
	
	public AddPage(HomeGUI app) {
		this.app = app;
		//this.setLayout(new GridLayout(4,1));
		setLayout(new BorderLayout());
		add(pN, "North");
		add(pC, "Center");
		
		pN.setLayout(new GridLayout(4,1));
		pN.add(pN_sub_1 = new JPanel());
		pN.add(pN_sub_2 = new JPanel());
		pN.add(pN_sub_3 = new JPanel());
		pN.add(pN_sub_4 = new JPanel());

		pN_sub_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_1.add(lbTitle = new JLabel("요리 이름: "));
		pN_sub_1.add(tfTitle = new JTextField(10));

		pN_sub_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_2.add(lbIngredients = new JLabel("재료 이름: "));
		pN_sub_2.add(tfIngredients = new JTextField(10));
		pN_sub_2.add(new JLabel("| 양(정수): "));
		pN_sub_2.add(tfIngreQuantity = new JTextField(4));
		pN_sub_2.add(new JLabel("| 단위: "));
		pN_sub_2.add(tfIngreUnit = new JTextField(3));
		pN_sub_2.add(btAddIngredients = new JButton("추가"));
		
		pN_sub_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_3.add(lbTools = new JLabel("도구 추가: "));
		pN_sub_3.add(tfTools = new JTextField(10));
		pN_sub_3.add(btAddTools = new JButton("추가"));

		pN_sub_3.add(cbOven = new JCheckBox("Oven"));
		pN_sub_3.add(cbStove = new JCheckBox("Stove"));
		pN_sub_3.add(cbPan = new JCheckBox("Pan"));
		pN_sub_3.add(cbPot = new JCheckBox("Pot"));
		

		pN_sub_4.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_4.add(lbStep = new JLabel("단계 추가: "));
		pN_sub_4.add(tfStep = new JTextField(25));
		pN_sub_4.add(btAddStep = new JButton("추가"));
		
		pC.setLayout(new GridLayout(3,1));
		//PreviewStr = tfTitle.getText().trim() + "\n" + ToolsStr + "\n" + IngreStr + "\n" + StepStr;
		//taPreview = new JTextArea(PreviewStr);
		taPreviewTools = new JTextArea(ToolsStr);
		taPreviewIngre = new JTextArea(IngreStr);
		taPreviewSteps = new JTextArea(StepStr);
		JScrollPane spTool=new JScrollPane(taPreviewTools);
		taPreviewTools.setEditable(false);
		pC.add(spTool);
		JScrollPane spIngre=new JScrollPane(taPreviewIngre);
		taPreviewTools.setEditable(false);
		pC.add(spIngre);
		JScrollPane spSteps=new JScrollPane(taPreviewSteps);
		taPreviewTools.setEditable(false);
		pC.add(spSteps);
		
		
		add(pS, "South");
		pS.add(btComplete=new JButton("완료︎︎"));
		
		clearAllField();
	}
	
	public void clearIngreField() {
		this.tfIngreQuantity.setText("");
		this.tfIngreUnit.setText("");
		this.tfIngredients.setText("");
		this.tfIngredients.requestFocus();//입력포커스
	}//--------------------------

	public void clearToolField() {
		this.tfTools.setText("");
		this.tfTools.requestFocus();
	}//-------------------------
	
	public void clearStepField() {
		this.tfStep.setText("");
		this.tfStep.requestFocus();//입력포커스
	}//--------------------------

	public void clearTitleField() {
		this.tfTitle.setText("");
		this.tfTitle.requestFocus();
	}//-------------------------
	
	public void clearAllField() {
		this.tfTitle.setText("");
		this.tfTools.setText("");
		this.tfIngreQuantity.setText("");
		this.tfIngreUnit.setText("");
		this.tfIngredients.setText("");
		this.tfStep.setText("");
		this.tfTitle.requestFocus();
		
	}

	public void reloadToolField() {
		this.ToolsStr += app.res.toolsArr.get(app.res.toolsArr.size()-1);
	}
	
	
}
