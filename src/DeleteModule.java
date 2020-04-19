package omo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteModule")
public class DeleteModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteModule() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu01";
			String username = "";
			String password = "";
			
			c = DriverManager.getConnection(url, username, password);
			// Delete post by id
			String sql1 = "delete from posts where id = ?";
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.setString(1, request.getParameter("id"));
			pstmt1.executeUpdate();
			// Delete media file from post
			String sql2 = "delete from mediafiles where post_id = ?";
			PreparedStatement pstmt2 = c.prepareStatement(sql2);
			pstmt2.setString(1, request.getParameter("id"));
			pstmt2.executeUpdate();
			// Delete hashtag from post
			String sql3 = "delete from hashtags where post_id = ?";
			PreparedStatement pstmt3 = c.prepareStatement(sql3);
			pstmt3.setString(1, request.getParameter("id"));
			pstmt3.executeUpdate();
		
			c.close();
		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
		response.sendRedirect("DisplayModule");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
