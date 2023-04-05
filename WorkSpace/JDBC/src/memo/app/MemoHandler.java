package memo.app;

import java.awt.event.*;
import java.sql.*;
import java.util.*;

/**
 * @author a
 * Controller
 * 	view 쪽에서 이벤트가 발생하면 이벤트를 처리한다. ==> DB관련 작업이 있으면
 * 	DAO객체 통해 작업을 수행한다. ==> 그 처리 결과를 View에 전달한다
 * 	Model과 View 사이에서 제어하는 역할을 수행한다
 */
public class MemoHandler implements ActionListener{
	MemoAppView app;//View
	MemoDAO dao=new MemoDAO();//Model
	
	public MemoHandler(MemoAppView mav) {
		this.app = mav;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		//System.out.println("event 처리 중...");
		//MemoAppView타이틀에 "event 처리 중..." 출력하고자 한다면
		//app.setTitle("event 처리 중...");
		Object obj=e.getSource();
		if(obj==app.btAdd) {
			addMemo();
			app.clearInput();
		}
	}//-----------------------
	public void addMemo() {
		//[1] app의 tfName, tfMsg에 입력한 값 얻어오기
		String mName = app.tfName.getText();
		String mMsg = app.tfMsg.getText();
		//[2] 유효성 체크(null, 빈문자열 체크)
		if(mName==null||mMsg==null||mName.trim().isEmpty()||mMsg.trim().isEmpty()) {
			app.showMessage("작성자와 메모 내용을 입력해야 해요");
			app.tfName.requestFocus();
			return;
		}
		//[3] [1] 번에서 받은 값을 MemoVO객체에 담아준다
		MemoVO mVo = new MemoVO(0, mName, mMsg, null);
		//[4] dao의 insertMemo()호출한다
		try {
			int result = dao.insertMemo(mVo);
			if(result>0) {
				app.setTitle("글 등록 성공!!");
			}else {
				app.showMessage("글 등록 실패!!");
			}
		//[5] 그 결과값에 따라 메시지 처리
		}catch (SQLException e) {
			app.showMessage(e.getMessage());
		}
		
		
	}//-----------------------

}
