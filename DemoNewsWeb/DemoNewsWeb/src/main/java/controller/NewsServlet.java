package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.News;

// Servlet được gọi đến với tên liên kết news theo file cấu hình web.xml
public class NewsServlet extends HttpServlet {
// List chứa dữ liệu giả, dùng static để tồn tại trong bộ nhớ chia sẻ chung của ứng dụng
	private static List<News> newsList = new ArrayList<>();
	private static int idCounter = 1;
	
	@Override
	public void init() {
// Dữ liệu giả
		newsList.add(new News(idCounter++, "Tiêu đề 1", "Nội dung bài viết 1"));
		newsList.add(new News(idCounter++, "Tiêu đề 2", "Nội dung bài viết 2"));
	}

// Phương thức doGet được gọi khi method gửi từ phía client là "GET"
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
// Thiết lập UTF-8 cho request, response để hiển thị đúng tiếng Việt
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
// Lấy về giá trị các tham số được gửi qua request từ client
		String action = req.getParameter("action");
		String idStr = req.getParameter("id");

		if (action == null)
			action = "list";
		switch (action) {
		case "create": 
			req.getRequestDispatcher("form.jsp").forward(req, resp);
			break;
		case "edit": 
// Lấy nội dung với id tin tức tương ứng cần sửa
			int idEdit = Integer.parseInt(idStr);
			News editNews = findById(idEdit);
// ghi vào request để trang form.jsp lấy ra điền vào các trường
			req.setAttribute("news", editNews);
			req.getRequestDispatcher("form.jsp").forward(req, resp);
			break;
		case "delete":
			int idDelete = Integer.parseInt(idStr);
			newsList.removeIf(n -> n.getId() == idDelete);
			resp.sendRedirect("news"); // quay lại trang chủ tin tức
			break;
		case "detail":
			int idDetail = Integer.parseInt(idStr);
			News detailNews = findById(idDetail);
			req.setAttribute("news", detailNews);
			req.getRequestDispatcher("detail.jsp").forward(req, resp);
			break;
		default: 
// ghi ds tin tức vào request để trang list.jsp lấy ra hiển thị
			req.setAttribute("newsList", newsList);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
			break;
		}
	}
// Phương thức doPost được gọi khi method gửi từ phía client là "POST"
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// Lấy các trường từ form được submit tới ở trang form.jsp
		String idStr = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		// Nếu ko có id, ứng với tình huống tạo mới tin tức
		if (idStr == null || idStr.isEmpty()) {
		News newNews = new News(idCounter++, title, content);
		newsList.add(newNews);
		} else {
			// Cập nhật tin tức với id tương ứng
			int id = Integer.parseInt(idStr);
			News existing = findById(id);
			if (existing != null) {
				existing.setTitle(title);
				existing.setContent(content);
			}
		}
		resp.sendRedirect("news");
	}
	// Lấy ra đối tượng tin tức theo id từ danh sách tin tức
	private News findById(int id) {
		for (News n : newsList) {
			if (n.getId() == id)
				return n;
		}
		return null;
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}