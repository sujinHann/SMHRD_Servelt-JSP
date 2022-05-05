package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberDAO;

public class IdCheckCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//1. email 값 받기(getParmerter 사용)
		
		String email = request.getParameter("email");
		
		//2. memberDAO email이 사용할 수 있는 email인지 확인해주는 매서드 (idCheck())
		//반환값: 있는 아이디면 true / 없는 아이디면 false
		
		memberDAO dao = new memberDAO();
		boolean check = dao.idCheck(email);
		
		//3.console에 true / false(반환값) 출력
		
		return String.valueOf(check);	//boolean -> string 타입으로 변환 => String.valueOf
		
	}

}
