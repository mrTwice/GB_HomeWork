package ru.myhomework.homeworksecond.Repositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.myhomework.homeworksecond.Domain.User;

import java.util.List;
@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, Long.valueOf(id));
    }

    public User getUserById(int id){
        String sql = "SELECT * FROM userTable WHERE id=?";
        User user = jdbc.queryForObject(sql, User.class);
        return user;

    }

    public void updateUser(User user){
        String firstNmae = user.getFirstName();
        String lastName = user.getLastName();
        int id = user.getId();
        String sql = "update userTable set firstName = ?, lastName = ? where id = ?";
        this.jdbc.update(sql, firstNmae, lastName, id);
    }

}
