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
			String sql = "select * from mediafiles where media_file = ?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			String text = request.getParameter("text");
			String image = request.getParameter("image");
			String video = request.getParameter("video");
			String audio = request.getParameter("audio");
			String hashtag = request.getParameter("hashtag");
			String date = request.getParameter("date");
			
			if (text != null) {
				List<Text> texts = new ArrayList<Text>();
				// Get text of posts
				sql = "select username, title, message from posts";
				pstmt = c.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the text
					texts.add(new Text(rs.getString("username"), rs.getString("title"), rs.getString("message")));
				}
				c.close();
				request.setAttribute("texts", texts);
				// Redirect user to the corresponding filtered page
				request.getRequestDispatcher("/WEB-INF/FilteredTexts.jsp").forward(request, response);
			}
			else if (image != null) {
				List<MediaFile> images = new ArrayList<MediaFile>();
				pstmt.setString(1, image);
				// Get media with specified file
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the media file
					images.add(new MediaFile(Integer.parseInt(rs.getString("post_id")), rs.getString("name"), rs.getString("media_file"), rs.getString("url")));
				}
				c.close();
				request.setAttribute("images", images);
				// Redirect user to the corresponding filtered page
				request.getRequestDispatcher("/WEB-INF/FilteredImages.jsp").forward(request, response);
			}
			else if (video != null) {
				List<MediaFile> videos = new ArrayList<MediaFile>();
				pstmt.setString(1, video);
				// Get media with specified file
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the media file
					videos.add(new MediaFile(Integer.parseInt(rs.getString("post_id")), rs.getString("name"), rs.getString("media_file"), rs.getString("url")));
				}
				c.close();
				request.setAttribute("videos", videos);
				// Redirect user to the corresponding filtered page
				request.getRequestDispatcher("/WEB-INF/FilteredVideos.jsp").forward(request, response);
			}
			else if (audio != null) {
				List<MediaFile> audios = new ArrayList<MediaFile>();
				pstmt.setString(1, audio);
				// Get media with specified file
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the media file
					audios.add(new MediaFile(Integer.parseInt(rs.getString("post_id")), rs.getString("name"), rs.getString("media_file"), rs.getString("url")));
				}
				c.close();
				request.setAttribute("audios", audios);
				// Redirect user to the corresponding filtered page
				request.getRequestDispatcher("/WEB-INF/FilteredAudios.jsp").forward(request, response);
			}
			else if (hashtag != null) {
				List<Hashtag> hashtags = new ArrayList<Hashtag>();
				sql = "select * from hashtags";
				pstmt = c.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					hashtags.add(new Hashtag(Integer.parseInt(rs.getString("post_id")), rs.getString("word")));
				}
				c.close();
				request.setAttribute("hashtags", hashtags);
				request.getRequestDispatcher("/WEB-INF/FilteredHashtags.jsp").forward(request, response);
			}
			if (date != null) {
				List<String> dates = new ArrayList<String>();
				// Get dates of posts
				sql = "select date from posts";
				pstmt = c.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					// Store the date
					dates.add(rs.getString("date"));
				}
				c.close();
				request.setAttribute("dates", dates);
				// Redirect user to the corresponding filtered page
				request.getRequestDispatcher("/WEB-INF/FilteredDates.jsp").forward(request, response);
			}
			c.close();
		}
		catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
