package by.epam.tc.test.dao.impl;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import by.epam.tc.test.dao.QuestionDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.pool.ConnectionPool;
import by.epam.tc.test.entity.Question;
import by.epam.tc.test.entity.Test;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */


public class QuestionDAOImpl implements QuestionDAO{

	@Override
	public boolean createQuestion(int test_id, String question, String options, int correct_answer) throws DAOException {
		
		boolean success = true;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = ConnectionPool.getPool().getConnection();
		PreparedStatement ps;
			
			try {
				ps = (PreparedStatement) connection.prepareStatement("insert into questions (test_id, question, options, correct_answer)" + " values(?,?,?,?)");
				ps.setInt(1, test_id);
				ps.setString(2, question);
				ps.setString(3, options);
				ps.setInt(4, correct_answer);
				ps.execute();
			} catch (SQLException e) {
				success = false;
				throw new DAOException(e.getMessage());
			} finally {
				ConnectionPool.getPool().closeDbResources(connection, statement, rs);
			}
		
		return success;
	}

	@Override
	public List<Question> showAllQuestions() throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List <Question> resultList = new ArrayList<>();

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from questions ");
			while (rs.next()) {
				resultList.add(new Question(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (HeadlessException | SQLException e2) {
			throw new DAOException(e2.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return resultList;		
	}
	

}
