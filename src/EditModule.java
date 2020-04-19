package omo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditModule")
public class EditModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditModule() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Post post = null;
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu01";
			String username = "";
			String password = "";
			
			c = DriverManager.getConnection(url, username, password);
			// Get post from database
			String sql = "select * from posts where id = ?";
			PreparedStatement pstmt1 = c.prepareStatement(sql);
			pstmt1.setString(1, request.getParameter("id"));
			ResultSet rs = pstmt1.executeQuery();
			
			while (rs.next()) {
				// Get post
				post = new Post(Integer.parseInt(rs.getString("id")), rs.getString("user"), rs.getString("title"), rs.getString("message"), rs.getDate("date"));
				// Get mediafiles of the post
				String sql2 = "select * from mediafiles where post_id = " + post.getId();
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				ResultSet rs2 = pstmt2.executeQuery();
				// Add mediafiles to the post
				while (rs2.next()) {
					post.addMediafile(new MediaFile(Integer.parseInt(rs2.getString("post_id")), rs2.getString("name"),
							rs2.getString("media_file"), rs2.getString("url")));
				}
				// Get hashtags of the post
				String sql3 = "select * from hashtags where post_id = " + post.getId();
				PreparedStatement pstmt3 = c.prepareStatement(sql3);
				ResultSet rs3 = pstmt3.executeQuery();
				// Add hashtags to the post
				while (rs3.next()) {
					post.addHashtag(new Hashtag(Integer.parseInt(rs3.getString("post_id")), rs3.getString("word")));
				}
			}
			c.close();
		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
		request.setAttribute("post", post);
		// Send post
		request.getRequestDispatcher("/WEB-INF/EditModule.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu01";
			String username = "";
			String password = "";
			// Update post
			String sql1 = "update posts set user = ?, title = ?, message = ? where id = ?";
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			String id = request.getParameter("id");
			String user = request.getParameter("user");
			String title = request.getParameter("title");
			String message = request.getParameter("message");
			pstmt1.setString(1, user);
			pstmt1.setString(2, title);
			pstmt1.setString(3, message);
			pstmt1.setString(4, id);
			pstmt1.executeUpdate();
			// Update hashtag for the post
			String sql3 = "update hashtags set word = ? where post_id = ?";
			PreparedStatement pstmt3 = c.prepareStatement(sql3);
			pstmt3.setString(1, request.getParameter("word"));
			pstmt3.setString(2, id);
			pstmt3.executeUpdate();
			// Update media file for the post
			String sql4 = "update mediafiles set name = ?, media_file = ?, url = ? where post_id = ?";
			PreparedStatement pstmt4 = c.prepareStatement(sql4);
			pstmt4.setString(1, request.getParameter("medianame"));
			pstmt4.setString(2, request.getParameter("mediafile"));
			pstmt4.setString(3, request.getParameter("url"));
			pstmt4.setString(4, id);
			pstmt4.executeUpdate();
			
			c.close();
		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
		response.sendRedirect("DisplayModule");
	}

}
