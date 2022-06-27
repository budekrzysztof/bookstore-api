    package com.kbudek.bookstoreapi.repos;

    import com.kbudek.bookstoreapi.domain.User;
    import com.kbudek.bookstoreapi.exceptions.BSAuthException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.dao.EmptyResultDataAccessException;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.jdbc.core.RowMapper;
    import org.springframework.jdbc.support.GeneratedKeyHolder;
    import org.springframework.jdbc.support.KeyHolder;
    import org.springframework.security.crypto.bcrypt.BCrypt;
    import org.springframework.stereotype.Repository;

    import java.sql.PreparedStatement;
    import java.sql.Statement;
    import java.util.UUID;

    @Repository
    public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_CREATE = "INSERT INTO bs_users(user_id, email, password) VALUES(?, ?, ?)";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM bs_users WHERE email = ?";
    private static final String SQL_FIND_BY_ID = "SELECT user_id, email, password FROM bs_users WHERE user_id = ?";
    private static final String SQL_FIND_BY_EMAIL = "SELECT user_id, email, password FROM bs_users WHERE email = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User create(UUID userId, String email, String hashedPassword) throws BSAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, userId);
                ps.setString(2, email);
                ps.setString(3, hashedPassword);
                return ps;
            }, keyHolder);
            return findById((UUID) keyHolder.getKeys().get("user_id"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BSAuthException("Invalid details. Failed to create an account.");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws BSAuthException {
        try {
            User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, userRowMapper, email);
            if(!BCrypt.checkpw(password, user.getPassword()))
                throw new BSAuthException("Invalid email or password.");
            return user;
        } catch(EmptyResultDataAccessException e) {
            throw new BSAuthException("Invalid email or password.");
        }
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, Integer.class, email);
    }

    @Override
    public User findById(UUID userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, userRowMapper, userId);
    }

    final private RowMapper<User> userRowMapper = ((rs, rowNum) -> {
        return new User((UUID) rs.getObject("user_id"),
            rs.getString("email"),
            rs.getString("password"));
        });
    }
