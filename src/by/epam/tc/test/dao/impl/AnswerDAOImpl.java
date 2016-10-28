package by.epam.tc.test.dao.impl;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import by.epam.tc.test.dao.AnswerDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.pool.ConnectionPool;
import by.epam.tc.test.entity.Answer;
import by.epam.tc.test.entity.Question;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public class AnswerDAOImpl implements AnswerDAO {

	@Override
	public boolean createAnswer(int test_id, int users_id, int mark) throws DAOException {
		
		boolean success = true;
		Connection connection = null;
		Statement statement = null;
		PreparedStatement ps;
		
			try {
				connection = ConnectionPool.getPool().getConnection();
				ps = (PreparedStatement) connection.prepareStatement("insert into answers (id_test, id_user, mark)" + " values(?,?,?)");
				ps.setInt(1, test_id);
				ps.setInt(2, users_id);
				ps.setInt(3, mark);
				ps.execute();
			} catch (SQLException e) {
				success = false;
				throw new DAOException(e.getMessage());
			} finally {
				ConnectionPool.getPool().closeDbResources(connection, statement);
		}
		return success;
	}

	@Override
	public List<Answer> showAnswersByUsersId(int users_id) throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List <Answer> resultList = new ArrayList<>();

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from answers "+ "where id_user='" + users_id + "'");
			while (rs.next()) {
				resultList.add(new Answer(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}

		} catch (HeadlessException | SQLException e2) {
			throw new DAOException(e2.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return resultList;		
	}

	
	
	
}
