package com.Servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;


@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet implements Servlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LineCaptcha lineCaptcha=CaptchaUtil.createLineCaptcha(200, 100);
		String code = lineCaptcha.getCode();
		HttpSession session =request.getSession();
		session.setAttribute("code", code);
		ServletOutputStream outputStream=response.getOutputStream();
		lineCaptcha.write(outputStream);
		System.out.println("—È÷§¬Î «£∫"+code);
	}

}
