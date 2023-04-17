package kr.ac.jejunu.user;

import java.sql.*;

public class UserDao {
    public User findById(Long id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/jeju", "jeju", "jejupw");
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name, password from userinfo where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }
}
