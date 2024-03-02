package DAO;

import DTO.BlogCategoryDTO;
import DTO.BlogDTO;
import DTO.User;
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
        String sql = "SELECT b.*, u.Name AS UserUsername, bc.BlogCategoryName "
                + "FROM Blog b "
                + "JOIN Users u ON b.UsersID = u.UsersID "
                + "JOIN BlogCategory bc ON b.BlogCategoryID = bc.BlogCategoryID "
//                + "ORDER BY b.BlogID DESC"; // Sắp xếp theo BlogID giảm dần
                + "ORDER BY b.DateCreate DESC"; // Sắp xếp theo ngày giảm dần
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
                blog.setContent(rs.getString("Content"));
                blog.setDateCreate(rs.getDate("DateCreate"));
                blog.setDateModified(rs.getDate("DateModified"));

                User user = new User();
                user.setId(rs.getInt("UsersID"));
                user.setName(rs.getString("UserUsername"));
                blog.setUser(user);

                BlogCategoryDTO blogCategory = new BlogCategoryDTO();
                blogCategory.setBlogCategoryID(rs.getInt("BlogCategoryID"));
                blogCategory.setBlogCategoryName(rs.getString("BlogCategoryName"));
                blog.setBlogCategory(blogCategory);

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

        public String returnblogcategoryID(String category) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String blogcategoryID = null;

        try {
            connection = db.getConn(); // Obtain a connection to your database

            String query = "SELECT BlogCategoryID FROM BlogCategory WHERE BlogCategoryName = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, category);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result exists
            if (resultSet.next()) {
                blogcategoryID = resultSet.getString("BlogCategoryID");
            }

        } catch (SQLException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        } finally {
            // Close the resources in the reverse order of their creation
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Handle the exception appropriately
                e.printStackTrace();
            }
        }

        return blogcategoryID;
    }


          public void createBlog(String title, String content, String dateCreate, String categoryID, int userId) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConn();
            String sql = "INSERT INTO Blog (Title, Content, DateCreate, BlogCategoryID, UsersID) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, dateCreate);
            ps.setString(4, categoryID);
            ps.setInt(5, userId);

            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
          
//    public BlogDTO getBlogByID(int blogID) {
//        BlogDTO blog = null;
//        String sql = "SELECT Title, Content, Date FROM Blog WHERE BlogID = ?";
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            conn = db.getConn();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, blogID);
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                // Tạo một đối tượng BlogDTO từ dữ liệu trong ResultSet
//                blog = new BlogDTO();
//                blog.setBlogID(blogID);
//                blog.setTitle(rs.getString("Title"));
//                blog.setContent(rs.getString("Content"));
//                blog.setDateCreate(rs.getDate("Date"));
//            }
//        } catch (SQLException e) {
//            // Xử lý ngoại lệ
//            e.printStackTrace();
//        } finally {
//            // Đóng các đối tượng ResultSet, PreparedStatement và Connection
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return blog;
//    }
          public BlogDTO getBlogByID(int blogID) {
    BlogDTO blog = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = db.getConn();
        String sql = "SELECT * FROM Blog b JOIN BlogCategory bc ON b.BlogCategoryID = bc.BlogCategoryID WHERE b.BlogID = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, blogID);
        rs = ps.executeQuery();

        if (rs.next()) {
            blog = new BlogDTO();

            // Set the properties of the BlogDTO from the query result
            blog.setBlogID(rs.getInt("BlogID"));
            blog.setTitle(rs.getString("Title"));
            blog.setContent(rs.getString("Content"));
            blog.setDateCreate(rs.getDate("DateCreate"));

            // Create a BlogCategoryDTO and set its properties
            BlogCategoryDTO blogCategory = new BlogCategoryDTO();
            blogCategory.setBlogCategoryID(rs.getInt("BlogCategoryID"));
            blogCategory.setBlogCategoryName(rs.getString("BlogCategoryName"));

            // Set the BlogCategoryDTO in the BlogDTO
            blog.setBlogCategory(blogCategory);

            // You can retrieve other properties similarly based on your database schema
        }
    } catch (SQLException e) {
        // Handle any SQL exceptions
        e.printStackTrace();
    } finally {
        // Close resources
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return blog;
}


//    public boolean updateBlog(int blogId, String title, String content) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        boolean success = false;
//
//        try {
//            conn = db.getConn();
//            String sql = "UPDATE Blog SET Title = ?, Content = ? WHERE BlogID = ?";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, title);
//            ps.setString(2, content);
//            ps.setInt(3, blogId);
//
//            int rowsUpdated = ps.executeUpdate();
//            success = (rowsUpdated > 0);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Đóng các đối tượng PreparedStatement và Connection
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return success;
//    }
          
           public void updateBlog(int blogId, String title, String content, String category, String dateModified) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConn();
            String sql = "UPDATE Blog SET Title=?, Content=?, BlogCategoryID=?, DateModified=? WHERE BlogID=?";
            ps = conn.prepareStatement(sql);

            // Set parameters for the update query
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, category);
            ps.setString(4, dateModified);
            ps.setInt(5, blogId);

            // Execute the update query
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
    
     public boolean deleteBlogCategory(int blogCategoryID) {
        String sql = "DELETE FROM BlogCategory WHERE BlogCategoryID = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, blogCategoryID);
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
    
    
    public List<String> listCategory() {
    List<String> categoryList = new ArrayList<>();
    String sql = "SELECT [BlogCategoryName] FROM [HouseSystem].[dbo].[BlogCategory]";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = db.getConn();
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            String categoryName = rs.getString("BlogCategoryName");
            categoryList.add(categoryName);
        }
    } catch (SQLException e) {
        // Handle exception (log or throw as needed)
        e.printStackTrace();
    } finally {
        // Close resources in the reverse order of their creation
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

    return categoryList;
}
    public void createBlogCategory(String newCategoryValue) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConn();
            String sql = "INSERT INTO BlogCategory (BlogCategoryName) VALUES (?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, newCategoryValue);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or log it
        } finally {
            // Close resources
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle the exception or log it
            }
        }
    }
//   public void createBlogCategory(String newCategoryValue) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        try {
//            conn = db.getConn();
//            String sql = "INSERT INTO BlogCategory (BlogCategoryName) VALUES (?)";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, newCategoryValue);
//
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            // Handle exceptions appropriately
//            e.printStackTrace();
//        } finally {
//            // Close resources
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    public List<BlogCategoryDTO> getAllBlogCategories() {
    List<BlogCategoryDTO> categories = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = db.getConn();
       String sql = "SELECT * FROM BlogCategory ORDER BY BlogCategoryID DESC";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            BlogCategoryDTO category = new BlogCategoryDTO();
            // Set the properties of the BlogCategoryDTO from the query result
            category.setBlogCategoryID(rs.getInt("BlogCategoryID"));
            category.setBlogCategoryName(rs.getString("BlogCategoryName"));

            categories.add(category);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
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
    return categories;
}
 public BlogCategoryDTO getBlogCategoryID(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BlogCategoryDTO category = null;

        try {
            conn = db.getConn();
            String sql = "SELECT * FROM BlogCategory WHERE BlogCategoryID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                category = new BlogCategoryDTO();
                category.setBlogCategoryID(rs.getInt("BlogCategoryID"));
                category.setBlogCategoryName(rs.getString("BlogCategoryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
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
        return category;
    }

        public void updateBlogCategory(String categoryID, String newCategoryName) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = db.getConn();
            String sql = "UPDATE BlogCategory SET BlogCategoryName = ? WHERE BlogCategoryID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, newCategoryName);
            ps.setString(2, categoryID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
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
        
        public List<BlogDTO> getAllbyCategory(String category) {
    List<BlogDTO> blogs = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = db.getConn();
//        String sql = "SELECT * FROM Blog WHERE BlogCategoryID = (SELECT BlogCategoryID FROM BlogCategory WHERE BlogCategoryName = ?)";
String sql = "SELECT b.*, u.UserName AS UserUsername, bc.BlogCategoryName "
                + "FROM Blog b "
                + "JOIN Users u ON b.UsersID = u.UsersID "
                + "JOIN BlogCategory bc ON b.BlogCategoryID = bc.BlogCategoryID "
                + "WHERE bc.BlogCategoryName = ? "
                + "ORDER BY b.DateCreate DESC";

        ps = conn.prepareStatement(sql);
        ps.setString(1, category);
        rs = ps.executeQuery();

           while (rs.next()) {
                BlogDTO blog = new BlogDTO(); // Tạo một đối tượng BlogDTO mới

                // Set các thuộc tính của BlogDTO từ kết quả truy vấn
                blog.setBlogID(rs.getInt("BlogID"));
                blog.setTitle(rs.getString("Title"));
                blog.setContent(rs.getString("Content"));
                blog.setDateCreate(rs.getDate("DateCreate"));
                blog.setDateModified(rs.getDate("DateModified"));

                User user = new User();
                user.setId(rs.getInt("UsersID"));
                user.setName(rs.getString("UserUsername"));
                blog.setUser(user);

                BlogCategoryDTO blogCategory = new BlogCategoryDTO();
                blogCategory.setBlogCategoryID(rs.getInt("BlogCategoryID"));
                blogCategory.setBlogCategoryName(rs.getString("BlogCategoryName"));
                blog.setBlogCategory(blogCategory);

                blogs.add(blog);
            }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources
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
    return blogs;
}
        
        
      
    public static void main(String[] args) {
        BlogDAO dao = new BlogDAO();

    }
}
