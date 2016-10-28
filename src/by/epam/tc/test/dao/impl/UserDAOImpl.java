package by.epam.tc.test.dao.impl;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import by.epam.tc.test.dao.UserDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.pool.ConnectionPool;
import by.epam.tc.test.entity.Answer;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.entity.User;

public class UserDAOImpl implements UserDAO {
	/**
	 * Created by Aliaksei Boltak on 25/10/2016.
	 */

	@Override
	public boolean registration(String login, String pass) throws DAOException {

		boolean valid = true;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from users " + "where login='" + login + "'");
			if (rs != null) {
				if (rs.next()) {
					valid = false;
				}
			}
		} catch (HeadlessException | SQLException e2) {
			valid = false;
			throw new DAOException(e2.getMessage());
		}

		if (valid) {
			PreparedStatement ps;
			try {
				ps = (PreparedStatement) connection
						.prepareStatement("insert into users (login, pass, role,  block_status)" + " values(?,?,?,?)");
				ps.setString(1, login);
				ps.setString(2, pass);
				ps.setInt(3, 0);
				ps.setInt(4, 0);
				ps.execute();
			} catch (SQLException e) {
				valid = false;
				throw new DAOException(e.getMessage());
			} finally {
				ConnectionPool.getPool().closeDbResources(connection, statement, rs);
			}
		}
		return valid;
	}

	@Override
	public User logination(String login, String pass) throws DAOException {

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from users where login ='" + login + "'");
			if (rs != null) {
				if (rs.next()) {
					if (rs.getString("pass").equals(pass)) {
						if (rs.getInt("role") == 0) {
							if (rs.getInt("block_status") == 0) {
								user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
										rs.getInt(5));
								return user;
							} else {
								if (rs.getInt("block_status") == 1) {
									user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 1);
									return user;
								}
							}
						} else {
							if (rs.getInt("role") == 1) {
								user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
										rs.getInt(5));
								return user;
							}
						}
					}
				}
			}

		} catch (SQLException e1) {
			throw new DAOException(e1.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return user;
	}

	@Override
	public List <Question>  chooseTestToPass(int test_id) throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Question> resultList = new ArrayList<>();

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from questions " + "where test_id='" + test_id + "'");
			while (rs.next()) {
				resultList
						.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (HeadlessException | SQLException e2) {
			throw new DAOException(e2.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return resultList;
	}
	
	@Override
	public List<User> showAllUsers() throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List <User> resultList = new ArrayList<>();

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from users ");
			while (rs.next()) {
				resultList
						.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}

		} catch (HeadlessException | SQLException e2) {
			throw new DAOException(e2.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return resultList;
	}

	@Override
	public boolean blockUser(String users_id) throws DAOException {

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {

			connection = ConnectionPool.getPool().getConnection();

			statement = (Statement) connection.createStatement();

			rs = statement.executeQuery("select * from users " + "where users_id='" + Integer.valueOf(users_id) + "'");

			if (rs.next()) {

				statement.executeUpdate("update users set block_status=1 where users_id=" + Integer.valueOf(users_id));
				return true;

			}
		} catch (NumberFormatException | HeadlessException | SQLException e1) {

			throw new DAOException(e1.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return false;
	}

	@Override
	public boolean unBlockUser(String users_id) throws DAOException {

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {

			connection = ConnectionPool.getPool().getConnection();

			statement = (Statement) connection.createStatement();

			rs = statement.executeQuery("select * from users " + "where users_id='" + Integer.valueOf(users_id) + "'");

			if (rs.next()) {

				statement.executeUpdate("update users set block_status=0 where users_id=" + Integer.valueOf(users_id));
				return true;
			}
		} catch (NumberFormatException | HeadlessException | SQLException e1) {
			throw new DAOException(e1.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return false;
	}

}
