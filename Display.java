package omo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Display() {
        super();
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Post> posts = new ArrayList<Post>();
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu01";
			String username = 
			String password = 
			
			c = DriverManager.getConnection(url, username, password);
			String sql = "select * from posts";
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Post post = new Post(Integer.parseInt(rs.getString("id")), rs.getString("username"), rs.getString("title"), rs.getString("text"), rs.getDate("date"));
				String sql2 = "select * from mediafiles where post_id = " + post.getId();
				PreparedStatement pstmt2 = c.prepareStatement(sql2);
				ResultSet rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					post.addMediafile(new MediaFile(Integer.parseInt(rs2.getString("post_id")), rs2.getString("name"),
							rs2.getString("media_type"), rs2.getString("url")));
					posts.add(post);
				}
			}
			c.close();
		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/WEB-INF/Display.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
