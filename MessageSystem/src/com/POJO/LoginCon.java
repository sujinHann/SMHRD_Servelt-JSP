package com.POJO;

import com.Command.Command;
import com.DAO.memberDAO;
import com.VO.memberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email, pw);
		
		if(vo!=null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginvo", vo);
			
		}
		//어디로 이동할 건지
		return "main.jsp";
	}

	
	
}
