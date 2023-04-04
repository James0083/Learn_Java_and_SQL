package Recipe_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //[1]

public class HomeGUI extends JFrame implements ActionListener , ItemListener{ //[2]

	Recipes res = new Recipes();
	boolean Oven, Stove, Pan;
	
	Container cp;
	JPanel pN = new JPanel(); 	//FlowLayout //북쪽
	JPanel pC = new JPanel();	//FlowLayout //남쪽
	JPanel pS = new JPanel();
	JPanel pWhite;
	ListPage pList = new ListPage();
	AddPage pAdd = new AddPage();
	SearchPage pSearch = new SearchPage();
	DeletePage pDel = new DeletePage();
	ViewRecipePage pPrint = new ViewRecipePage();
	EditPage pEdit = new EditPage();
	
	CardLayout card;
	
	JButton btList, btAdd, btSearch, btDel, btPrint
		, btEdit, btSubmit, btComplete;

	public HomeGUI() {
		super(":: 레시피 ::");
		cp = this.getContentPane();
		cp.add(pN, "North");
		cp.add(pC, "Center");
		
		pC.setBackground(Color.white);
		pC.setLayout(card = new CardLayout());
//		pC.add(pWhite = new JPanel(), "White");
		pC.add(pList, "List");
		pC.add(pAdd, "Add");
		pC.add(pSearch, "Search");
		pC.add(pDel, "Delete");
		pC.add(pPrint, "Print");
		pC.add(pEdit, "Edit");

		pN.add(btList=new JButton("목록"));
		pN.add(btAdd=new JButton("추가"));
		pN.add(btSearch=new JButton("검색"));
		pN.add(btDel=new JButton("삭제︎︎"));
		pN.add(btPrint=new JButton("레시피 출력"));
		pN.add(btEdit=new JButton("수정"));
		
		btList.addActionListener(this);	//[4]
		btAdd.addActionListener(this);
		btSearch.addActionListener(this);
		btDel.addActionListener(this);
		btPrint.addActionListener(this);
		btEdit.addActionListener(this);
		
		add(pS, "South");
		pS.add(btComplete=new JButton("완료︎︎"));
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e){ //[3]
		Object obj = e.getSource();
		if(obj==btList) {
			card.show(pC, "List");
		}else if(obj==btAdd) {
			res = new Recipes();
			card.show(pC, "Add");
		}else if(obj==btSearch) {
			card.show(pC, "Search");
		}else if(obj==btDel) {
			card.show(pC, "Delete");
		}else if(obj==btPrint) {
			card.show(pC, "Print");
		}else if(obj==btEdit) {
			card.show(pC, "Edit");
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		boolean selected;
		if(e.getStateChange()==ItemEvent.SELECTED) {
			//res.addTools(e.getItem().toString().trim());
			selected = true;
		}else {
			selected = false;
		}
		
		if(e.getItem()==pAdd.cbOven) {
			Oven = selected;
		}else if(e.getItem()==pAdd.cbStove) {
			Stove = selected;
		}else if(e.getItem()==pAdd.cbPan) {
			Pan = selected;
		}
	}
	
	public static void main(String[] args) {
		HomeGUI my = new HomeGUI();
		my.setSize(700, 700);
		my.setLocation(500,300);
		my.setVisible(true);

	}

}