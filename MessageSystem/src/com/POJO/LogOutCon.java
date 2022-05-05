package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;

public class LogOutCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		// 2. session (loginvo) 값 삭제
		session.removeAttribute("loginvo");

		// 3. main.jsp로 이동
		
		return "main.jsp";
	}

}
