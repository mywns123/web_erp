package web_erp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_erp.dto.Title;
import web_erp.service.TitleService;

@WebServlet("/TitleInsertServlet")
public class TitleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleService service;

    public TitleInsertServlet() {
    	service = new TitleService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//tno=7&tname=인턴
		int no = Integer.parseInt(request.getParameter("tno").trim());
		String name = request.getParameter("tname");		
		
		Title title = new Title(no,name);
		
		service.addTitle(title);
		
		response.sendRedirect("TitleListServlet");
//		request.getRequestDispatcher("TitleListServlet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
