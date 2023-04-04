package Recipe_Management;

import java.awt.*;
import javax.swing.*;

public class AddPage extends JPanel //implements ActionListener
{
	// Fields
	// 음식이름, 필요한 도구, 재료, 과정
	JPanel pN = new JPanel(new GridLayout(4,1));
	JPanel pN_sub_1, pN_sub_2, pN_sub_3, pN_sub_4;
	JCheckBox cbOven, cbStove, cbPan;
	JLabel lbTitle, lbTools, lbIngredients, lbStep;
	JTextField tfTitle, tfTools, tfIngredients, tfStep;
	JButton btSetTitle, btAddTools, btAddIngredients, btAddStep;
	JTextArea taPreview;
	
	String previewStr = "";
	String ToolsStr = "사용도구 : ", IngreStr = "[재료]\n"
			, StepStr = "[요리순서]\n\n";
	
	
	public AddPage() {
		this.setLayout(new GridLayout(2,1));
		add(pN, "North");
		
		pN.add(pN_sub_1 = new JPanel());
		pN.add(pN_sub_2 = new JPanel());
		pN.add(pN_sub_3 = new JPanel());

		pN_sub_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_1.add(lbTitle = new JLabel("요리 이름 : "));
		pN_sub_1.add(tfTitle = new JTextField(10));
		pN_sub_1.add(btSetTitle = new JButton("적용"));
		
		pN_sub_1.add(cbOven = new JCheckBox("Oven"));
		pN_sub_1.add(cbStove = new JCheckBox("Stove"));
		pN_sub_1.add(cbPan = new JCheckBox("Pan"));

		pN_sub_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_2.add(lbTools = new JLabel("도구 추가 : "));
		pN_sub_2.add(tfTools = new JTextField(10));
		pN_sub_2.add(btAddTools = new JButton("추가"));

		pN_sub_2.add(lbIngredients = new JLabel("재료 추가 : "));
		pN_sub_2.add(tfIngredients = new JTextField(10));
		pN_sub_2.add(btAddIngredients = new JButton("추가"));

		pN_sub_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		pN_sub_3.add(lbStep = new JLabel("단계 추가 : "));
		pN_sub_3.add(tfStep = new JTextField(25));
		pN_sub_3.add(btAddStep = new JButton("추가"));
		
		previewStr = tfTitle.getText().trim() + "\n" 
				+ ToolsStr + "\n" + IngreStr + "\n" + StepStr;
		taPreview = new JTextArea(previewStr);
		JScrollPane sp=new JScrollPane(taPreview);
		taPreview.setEditable(false);
		add(sp, "Center");
		
		

		
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
