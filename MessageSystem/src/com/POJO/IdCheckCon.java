package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberDAO;

public class IdCheckCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//1. email �� �ޱ�(getParmerter ���)
		
		String email = request.getParameter("email");
		
		//2. memberDAO email�� ����� �� �ִ� email���� Ȯ�����ִ� �ż��� (idCheck())
		//��ȯ��: �ִ� ���̵�� true / ���� ���̵�� false
		
		memberDAO dao = new memberDAO();
		boolean check = dao.idCheck(email);
		
		//3.console�� true / false(��ȯ��) ���
		
		return String.valueOf(check);	//boolean -> string Ÿ������ ��ȯ => String.valueOf
		
	}

}
