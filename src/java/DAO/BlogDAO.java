package DAO;

import DTO.BlogCategoryDTO;
import DTO.BlogDTO;
import DTO.User;
import Utils.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                //                + "ORDER BY b.BlogID DESC"; 
                + "ORDER BY b.DateCreate DESC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                BlogDTO blog = new BlogDTO();
                blog.setBlogID(rs.getInt("BlogID"));
                blog.setTitle(rs.getString("Title"));
                blog.setTags(rs.getString("Tags"));
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
        return list;
    }

    public String returnblogcategoryID(String category) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String blogcategoryID = null;
        try {
            connection = db.getConn();
            String query = "SELECT BlogCategoryID FROM BlogCategory WHERE BlogCategoryName = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                blogcategoryID = resultSet.getString("BlogCategoryID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
                e.printStackTrace();
            }
        }
        return blogcategoryID;
    }

    public String returnblogcategoryName(String categoryid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String blogcategoryName = null;
        try {
            connection = db.getConn();
            String query = "SELECT BlogCategoryName FROM BlogCategory WHERE  BlogCategoryID = ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, categoryid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                blogcategoryName = resultSet.getString("BlogCategoryName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
                e.printStackTrace();
            }
        }
        return blogcategoryName;
    }

    public void createBlog(String title, String tags, String content, String dateCreate, String categoryID, int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.getConn();
            String sql = "INSERT INTO Blog (Title, Tags, Content, DateCreate, BlogCategoryID, UsersID) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, tags);
            ps.setString(3, content);
            ps.setString(4, dateCreate);
            ps.setString(5, categoryID);
            ps.setInt(6, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public BlogDTO getBlogByID(int blogID) {
        BlogDTO blog = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            String sql = "SELECT b.*, u.Name AS UserUsername, bc.BlogCategoryName "
                    + "FROM Blog b "
                    + "JOIN Users u ON b.UsersID = u.UsersID "
                    + "JOIN BlogCategory bc ON b.BlogCategoryID = bc.BlogCategoryID "
                    + "WHERE b.BlogID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, blogID);
            rs = ps.executeQuery();
            if (rs.next()) {
                blog = new BlogDTO();
                blog.setBlogID(rs.getInt("BlogID"));
                blog.setTitle(rs.getString("Title"));
                blog.setTags(rs.getString("Tags"));
                blog.setContent(rs.getString("Content"));
                blog.setDateCreate(rs.getDate("DateCreate"));
                blog.setDateModified(rs.getDate("DateModified"));
                // Set user information
                User user = new User();
                user.setId(rs.getInt("UsersID"));
                user.setName(rs.getString("UserUsername"));
                blog.setUser(user);
                // Set the BlogCategory information
                BlogCategoryDTO blogCategory = new BlogCategoryDTO();
                blogCategory.setBlogCategoryID(rs.getInt("BlogCategoryID"));
                blogCategory.setBlogCategoryName(rs.getString("BlogCategoryName"));
                // Set the BlogCategoryDTO in the BlogDTO
                blog.setBlogCategory(blogCategory);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return blog;
    }

    public void updateBlog(int blogId, String title, String tags, String content, String category, String dateModified) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.getConn();
            String sql = "UPDATE Blog SET Title=?, Tags=?, Content=?, BlogCategoryID=?, DateModified=? WHERE BlogID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, tags);
            ps.setString(3, content);
            ps.setString(4, category);
            ps.setString(5, dateModified);
            ps.setInt(6, blogId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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

    public List<BlogCategoryDTO> getAllBlogCategories() {
        List<BlogCategoryDTO> categories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            String sql = "SELECT * FROM BlogCategory";
//             ORDER BY BlogCategoryID DESC
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BlogCategoryDTO category = new BlogCategoryDTO();
                category.setBlogCategoryID(rs.getInt("BlogCategoryID"));
                category.setBlogCategoryName(rs.getString("BlogCategoryName"));
                categories.add(category);
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
                BlogDTO blog = new BlogDTO();
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

    public List<BlogDTO> getAllbyCategoryID(String categoryId) {
        List<BlogDTO> blogs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            String sql = "SELECT b.*, u.UserName AS UserUsername, bc.BlogCategoryName "
                    + "FROM Blog b "
                    + "JOIN Users u ON b.UsersID = u.UsersID "
                    + "JOIN BlogCategory bc ON b.BlogCategoryID = bc.BlogCategoryID "
                    + "WHERE bc.BlogCategoryID = ? "
                    + "ORDER BY b.DateCreate DESC";
            ps = conn.prepareStatement(sql);
            ps.setString(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                BlogDTO blog = new BlogDTO();
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

    public List<BlogDTO> getAllbyTags(String tagSearch) {
        List<BlogDTO> list = new ArrayList<>();
        String sql = "SELECT b.*, u.Name AS UserUsername, bc.BlogCategoryName "
                + "FROM Blog b "
                + "JOIN Users u ON b.UsersID = u.UsersID "
                + "JOIN BlogCategory bc ON b.BlogCategoryID = bc.BlogCategoryID "
                + "WHERE b.Tags LIKE ? "
                + "ORDER BY b.DateCreate DESC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tagSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                BlogDTO blog = new BlogDTO();
                blog.setBlogID(rs.getInt("BlogID"));
                blog.setTitle(rs.getString("Title"));
                blog.setTags(rs.getString("Tags"));
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
        return list;
    }

    public static void main(String[] args) {
        BlogDAO dao = new BlogDAO();
    }
}
