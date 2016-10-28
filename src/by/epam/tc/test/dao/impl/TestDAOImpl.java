package by.epam.tc.test.dao.impl;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import by.epam.tc.test.dao.TestDAO;
import by.epam.tc.test.dao.exception.DAOException;
import by.epam.tc.test.dao.pool.ConnectionPool;
import by.epam.tc.test.entity.Test;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */


public class TestDAOImpl implements TestDAO {

	@Override
	public boolean createTest(String subject) throws DAOException {

		boolean success = true;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from tests " + "where subject='" + subject + "'");

			if (rs != null) {
				if (rs.next()) {
					success = false;
					;
				}
			}
		} catch (HeadlessException | SQLException e2) {
			success = false;
			throw new DAOException(e2.getMessage());
		}

		if (success) {
			PreparedStatement ps;
			try {
				ps = (PreparedStatement) connection.prepareStatement("insert into tests (subject)" + " values(?)");
				ps.setString(1, subject);
				ps.execute();
			} catch (SQLException e) {
				success = false;
				throw new DAOException(e.getMessage());
			} finally {
				ConnectionPool.getPool().closeDbResources(connection, statement, rs);
			}
		}
		return success;
	}

	@Override
	public List<Test> showAllTests() throws DAOException {

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Test> resultList = new ArrayList<>();

		try {
			connection = ConnectionPool.getPool().getConnection();
			statement = (Statement) connection.createStatement();
			rs = statement.executeQuery("select * from tests ");
			while (rs.next()) {
				resultList.add(new Test(rs.getInt(1), rs.getString(2)));
			}

		} catch (HeadlessException | SQLException e2) {
			throw new DAOException(e2.getMessage());
		} finally {
			ConnectionPool.getPool().closeDbResources(connection, statement, rs);
		}
		return resultList;
	}

}
