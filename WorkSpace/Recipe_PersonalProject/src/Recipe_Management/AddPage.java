package Recipe_Management;

import java.awt.*;
import javax.swing.*;

public class AddPage extends JPanel //implements ActionListener
{
	// Fields
	// 음식이름, 필요한 도구, 재료, 과정
	JPanel pN = new JPanel(), pC = new JPanel();
	JPanel pN_sub_1, pN_sub_2, pN_sub_3, pN_sub_4;
	JCheckBox cbOven, cbStove, cbPan, cbPot;
	JLabel lbTitle, lbTools, lbIngredients, lbStep;
	JTextField tfTitle, tfTools, tfIngredients, tfStep;
	JButton btAddTools, btAddIngredients, btAddStep;
	JTextArea taPreviewTools, taPreviewIngre, taPreviewSteps;
	
//	String PreviewStr = "";
	String ToolsStr = "[사용도구]\n", IngreStr = "[재료]\n"
			, StepStr = "[요리순서]\n\n";
	
	
	public AddPage() {
		//this.setLayout(new GridLayout(4,1));
		setLayout(new BorderLayout());
		add(pN, "North");
		add(pC, "Center");
		
		pN.setLayout(new GridLayout(3,1));
		pN.add(pN_sub_1 = new JPanel());
		pN.add(pN_sub_2 = new JPanel());
		pN.add(pN_sub_3 = new JPanel());

		pN_sub_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_1.add(lbTitle = new JLabel("요리 이름 : "));
		pN_sub_1.add(tfTitle = new JTextField(10));

		pN_sub_1.add(lbIngredients = new JLabel("재료 추가 : "));
		pN_sub_1.add(tfIngredients = new JTextField(10));
		pN_sub_1.add(btAddIngredients = new JButton("추가"));
		
		pN_sub_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_2.add(lbTools = new JLabel("도구 추가 : "));
		pN_sub_2.add(tfTools = new JTextField(10));
		pN_sub_2.add(btAddTools = new JButton("추가"));

		pN_sub_2.add(cbOven = new JCheckBox("Oven"));
		pN_sub_2.add(cbStove = new JCheckBox("Stove"));
		pN_sub_2.add(cbPan = new JCheckBox("Pan"));
		pN_sub_2.add(cbPot = new JCheckBox("Pot"));
		

		pN_sub_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_3.add(lbStep = new JLabel("단계 추가 : "));
		pN_sub_3.add(tfStep = new JTextField(25));
		pN_sub_3.add(btAddStep = new JButton("추가"));
		
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
		
		

		
	}
	
	public void appendToolsStr(String str) {
		this.ToolsStr += str;
	}
	
	public void reset() {
		this.tfTitle.setText("");
		this.tfTools.setText("");
		this.tfIngredients.setText("");
		this.tfStep.setText("");
	}

}