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

@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Filter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Access database
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu01";
			String username = "";
			String password = "";
			c = DriverManager.getConnection(url, username, password);
			String filter = request.getParameter("filter");
			
			// Text filter
			if (filter.equals("text")) {
				List<Text> texts = new ArrayList<Text>();
				// Get text of posts
				String sql = "select user, title, message from posts";
				PreparedStatement pstmt = c.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the text
					texts.add(new Text(rs.getString("user"), rs.getString("title"), rs.getString("message")));
				}
				c.close();
				request.setAttribute("texts", texts);
				// Redirect user to the filtered texts page
				request.getRequestDispatcher("/WEB-INF/FilteredTexts.jsp").forward(request, response);
			}
			// Image filter
			else if (filter.equals("image")) {
				List<MediaFile> images = new ArrayList<MediaFile>();
				String sql = "select * from mediafiles where media_file = ?";
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, filter);
				// Get media with specified file
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the media file
					images.add(new MediaFile(Integer.parseInt(rs.getString("post_id")), rs.getString("name"), rs.getString("media_file"), rs.getString("url")));
				}
				c.close();
				request.setAttribute("images", images);
				// Redirect user to the filtered images page
				request.getRequestDispatcher("/WEB-INF/FilteredImages.jsp").forward(request, response);
			}
			// Video filter
			else if (filter.equals("video")) {
				List<MediaFile> videos = new ArrayList<MediaFile>();
				String sql = "select * from mediafiles where media_file = ?";
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, filter);
				// Get media with specified file
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the media file
					videos.add(new MediaFile(Integer.parseInt(rs.getString("post_id")), rs.getString("name"), rs.getString("media_file"), rs.getString("url")));
				}
				c.close();
				request.setAttribute("videos", videos);
				// Redirect user to the filtered videos page
				request.getRequestDispatcher("/WEB-INF/FilteredVideos.jsp").forward(request, response);
			}
			// Song filter
			else if (filter.equals("song")) {
				List<MediaFile> songs = new ArrayList<MediaFile>();
				String sql = "select * from mediafiles where media_file = ?";
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, filter);
				// Get media with specified file
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the media file
					songs.add(new MediaFile(Integer.parseInt(rs.getString("post_id")), rs.getString("name"), rs.getString("media_file"), rs.getString("url")));
				}
				c.close();
				request.setAttribute("songs", songs);
				// Redirect user to the filtered songs page
				request.getRequestDispatcher("/WEB-INF/FilteredSongs.jsp").forward(request, response);
			}
			// Hashtag filter
			else if (filter.equals("hashtag")) {
				List<Hashtag> hashtags = new ArrayList<Hashtag>();
				String sql = "select * from hashtags";
				PreparedStatement pstmt = c.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					hashtags.add(new Hashtag(Integer.parseInt(rs.getString("post_id")), rs.getString("word")));
				}
				c.close();
				request.setAttribute("hashtags", hashtags);
				// Redirect user to the filtered hashtags page
				request.getRequestDispatcher("/WEB-INF/FilteredHashtags.jsp").forward(request, response);
			}
			// Date filter
			if (filter.equals("date")) {
				List<String> dates = new ArrayList<String>();
				// Get dates of posts
				String sql = "select date from posts";
				PreparedStatement pstmt = c.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the date
					dates.add(rs.getString("date"));
				}
				c.close();
				request.setAttribute("dates", dates);
				// Redirect user to the filtered dates page
				request.getRequestDispatcher("/WEB-INF/FilteredDates.jsp").forward(request, response);
			}
			c.close();
		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
