package kr.ac.jejunu.user;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTests {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "hulk";
        String password = "1234";
        UserDao userDao = new UserDao();
        User user = userDao.findById(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }
}
