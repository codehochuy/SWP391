package DAO;

import DTO.BlogDTO;
import DTO.BlogDetailDTO;
import DTO.BlogImageDTO;
import Utils.DBContext;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class BlogDAO {

    private DBContext db;

    public BlogDAO() {
        db = new DBContext();
    }

    public BlogDAO(DBContext db) {
        this.db = db;
    }

    public DBContext getDb() {
        return db;
    }

    public void setDb(DBContext db) {
        this.db = db;
    }

    public List<BlogDTO> getAll() {
        List<BlogDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Blog";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                BlogDTO blog = new BlogDTO(); // Tạo một đối tượng BlogDTO mới

                // Set các thuộc tính của BlogDTO từ kết quả truy vấn
                blog.setBlogID(rs.getInt("BlogID"));
                blog.setTitle(rs.getString("Title"));
                blog.setDate(rs.getDate("Date"));
                blog.setUsersID(rs.getInt("UsersID"));

                // Thêm BlogDTO vào danh sách
                list.add(blog);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        } finally {
            // Đóng các đối tượng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public static byte[] decodeBase64(String base64Image) {
        return Base64.getDecoder().decode(base64Image);
    }

    public static void createImageFile(byte[] imageData, String filePath) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(imageData);
        }
    }

    public static String extractBase64Data(String base64String) {
        int commaIndex = base64String.indexOf(",");
        if (commaIndex == -1 || commaIndex == base64String.length() - 1) {
            return null;
        }
        return base64String.substring(commaIndex + 1);
    }
//    public static String extractBase64Data(String base64String) {
//    // Tìm vị trí của dấu phẩy
//    int commaIndex = base64String.indexOf(",");
//    
//    // Nếu không tìm thấy dấu phẩy hoặc không có dữ liệu sau dấu phẩy, trả về null hoặc chuỗi rỗng
//    if (commaIndex == -1 || commaIndex == base64String.length() - 1) {
//        return null; // hoặc return "";
//    }
//    
//    // Trích xuất phần dữ liệu base64 sau dấu phẩy
//    String base64Data = base64String.substring(commaIndex + 1);
//    
//    return base64Data;
//}

    public void createFiles(String base64Image, String imagePath, String imageName) {
//    String imageName = generateRandomName() + ".jpg"; // Đặt tên ngẫu nhiên cho file
        String filePath = imagePath + imageName; // Đường dẫn đầy đủ của file
//    System.out.println(filePath);

        String base64Data = extractBase64Data(base64Image);
        // Giải mã base64 thành mảng byte
        byte[] imageData = decodeBase64(base64Data);
//        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        try {
            // Tạo file hình ảnh từ byte array
            createImageFile(imageData, filePath);
            System.out.println("File hình ảnh đã được tạo thành công.");
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi tạo file hình ảnh: " + e.getMessage());
        }

        // Tạo luồng đầu ra để ghi dữ liệu vào file
//        FileOutputStream outputStream = new FileOutputStream(imagePath);
        // Ghi mảng byte vào file
//        outputStream.write(imageBytes);
        // Đóng luồng
//        outputStream.close();
    }

    public boolean deleteBlog(int blogID) {
        String sql = "DELETE FROM Blog WHERE BlogID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, blogID);
            int rowsAffected = ps.executeUpdate();
            // Trả về true nếu có ít nhất một dòng được ảnh hưởng (blog được xóa thành công)
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Trả về false nếu có lỗi xảy ra trong quá trình xóa blog
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public BlogDTO getBlogByID(int blogID) {
        String sql = "SELECT b.BlogID, b.Title AS BlogTitle, b.Date, b.UsersID, "
                + "bd.BlogDetailID, bd.Title AS BlogDetailTitle, bd.Content, "
                + "bi.BlogImageID, bi.URL, bi.Caption "
                + "FROM Blog b "
                + "LEFT JOIN BlogDetail bd ON b.BlogID = bd.BlogID "
                + "LEFT JOIN BlogImage bi ON bd.BlogDetailID = bi.BlogDetailID "
                + "WHERE b.BlogID = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BlogDTO blogDTO = null;

        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, blogID);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (blogDTO == null) {
                    blogDTO = new BlogDTO();
                    blogDTO.setBlogID(rs.getInt("BlogID"));
                    blogDTO.setTitle(rs.getString("BlogTitle"));
                    blogDTO.setDate(rs.getDate("Date"));
                    blogDTO.setUsersID(rs.getInt("UsersID"));
                    blogDTO.setBlogDetails(new ArrayList<>());
                }

                int blogDetailID = rs.getInt("BlogDetailID");
                if (blogDetailID > 0) {
                    BlogDetailDTO blogDetailDTO = new BlogDetailDTO();
                    blogDetailDTO.setBlogDetailID(blogDetailID);
                    blogDetailDTO.setTitle(rs.getString("BlogDetailTitle"));
                    blogDetailDTO.setContent(rs.getString("Content"));
                    blogDetailDTO.setBlogID(String.valueOf(blogID));

                    blogDetailDTO.setBlogImages(new ArrayList<>());
                    blogDTO.addBlogDetail(blogDetailDTO);
                }

                int blogImageID = rs.getInt("BlogImageID");
                if (blogImageID > 0) {
                    BlogImageDTO blogImageDTO = new BlogImageDTO();
                    blogImageDTO.setBlogImageID(blogImageID);
                    blogImageDTO.setUrl(rs.getString("URL"));
                    blogImageDTO.setCaption(rs.getString("Caption"));
                    blogImageDTO.setBlogDetailID(String.valueOf(blogDetailID)); // Cập nhật BlogDetailID

                    // Lấy index của blogDetail trong blogDTO
                    int index = blogDTO.getBlogDetails().size() - 1;
                    blogDTO.getBlogDetails().get(index).addBlogImage(blogImageDTO);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return blogDTO;
    }

    public String createBlog(String title, String date, String userID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String generatedID = null;

        try {
            conn = db.getConn();
            String sql = "INSERT INTO Blog (Title, Date, UsersID) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, title);
            ps.setString(2, date);
            ps.setString(3, userID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // Lấy về các khóa được tạo tự động (nếu có)
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    // Lấy BlogID vừa được tạo
                    generatedID = String.valueOf(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return generatedID;
    }

// Phương thức tạo blog detail
    public String createBlogDetail(String title, String content, String blogID) {
        String createdBlogDetailID = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConn();
            String sql = "INSERT INTO BlogDetail (Title, Content, BlogID) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, blogID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    createdBlogDetailID = String.valueOf(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các đối tượng ResultSet, PreparedStatement và Connection
            // ...
        }
        return createdBlogDetailID;
    }

    // tạo BlogImage
    public String createBlogImage(String imageURL, String caption, String blogDetailID) {
        String createdBlogImageID = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConn();
            String sql = "INSERT INTO BlogImage ([URL], Caption, BlogDetailID) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, imageURL);
            ps.setString(2, caption);
            ps.setString(3, blogDetailID);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    createdBlogImageID = String.valueOf(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các đối tượng ResultSet, PreparedStatement và Connection
            // ...
        }
        return createdBlogImageID;
    }

    public static void main(String[] args) {
        BlogDAO dao = new BlogDAO();
        System.out.println(dao.getBlogByID(1));
    }
}
