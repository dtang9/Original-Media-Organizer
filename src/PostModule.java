package omo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostModule")
public class PostModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostModule() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/PostModule.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu01";
			String username = "cs3337stu01";
			String password = "!DBgrBWB";
			// Add a post
			String sql1 = "insert into posts (user, title, message, date) values (?, ?, ?, now())";
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			String user = request.getParameter("user");
			String title = request.getParameter("title");
			String message = request.getParameter("message");
			pstmt1.setString(1, user);
			pstmt1.setString(2, title);
			pstmt1.setString(3, message);
			pstmt1.executeUpdate();
			//Get post id
			String sql2 = "select id from posts where user = ? and title = ?";
			PreparedStatement pstmt2 = c.prepareStatement(sql2);
			pstmt2.setString(1, user);
			pstmt2.setString(2, title);
			ResultSet rs = pstmt2.executeQuery();
			String post_id = "0";
			while (rs.next()) {
				post_id = rs.getString("id");
			}
			// Add hashtag to the post
			String sql3 = "insert into hashtags (post_id, word) values (?, ?)";
			PreparedStatement pstmt3 = c.prepareStatement(sql3);
			pstmt3.setString(1, post_id);
			pstmt3.setString(2, request.getParameter("word"));
			pstmt3.executeUpdate();
			// Add media file to the post
			String sql4 = "insert into mediafiles (post_id, name, media_file, url) values (?, ?, ?, ?)";
			PreparedStatement pstmt4 = c.prepareStatement(sql4);
			pstmt4.setString(1, post_id);
			pstmt4.setString(2, request.getParameter("medianame"));
			pstmt4.setString(3, request.getParameter("mediafile"));
			pstmt4.setString(4, request.getParameter("url"));
			pstmt4.executeUpdate();
			
			c.close();
		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
		response.sendRedirect("DisplayModule");
	}

}
