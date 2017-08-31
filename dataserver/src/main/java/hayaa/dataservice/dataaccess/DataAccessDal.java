package hayaa.dataservice.dataaccess;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import hayaa.dataservice.model.DataResult;
import hayaa.dataservice.model.GridPager;
import hayaa.dataservice.model.ReturnResult;
import hayaa.dataservice.model.Sqldataservice;

public class DataAccessDal {
	private static DataAccessDal g_instance = new DataAccessDal();

	public static DataAccessDal getInstance() {
		return g_instance;
	}

	private DataAccessDal() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean update(String sql, Object[] params, String connectionString,
			String user, String pwd) {
		boolean r = false;
		QueryRunner qr = new QueryRunner();
		try {
			Connection conn = DriverManager.getConnection(connectionString,
					user, pwd);
			r = qr.update(conn, sql, params) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public boolean delete(String sql, Object[] params, String connectionString,
			String user, String pwd) {
		boolean r = false;
		QueryRunner qr = new QueryRunner();
		try {
			Connection conn = DriverManager.getConnection(connectionString,
					user, pwd);
			r = qr.execute(conn, sql, params) > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public <T> Object insert(String sql, Object[] params,
			String connectionString, String user, String pwd) {
		QueryRunner qr = new QueryRunner();
		try {
			Connection conn = DriverManager.getConnection(connectionString,
					user, pwd);
			return qr.insert(conn, sql, new ScalarHandler<T>(), params)
					.toString();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public <T> T get(String sql, Object[] params, String connectionString,
			String user, String pwd, Class<? extends T> type) {
		QueryRunner qr = new QueryRunner();
		try {
			Connection conn = DriverManager.getConnection(connectionString,
					user, pwd);
			return qr.query(conn, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public <T> List<T> listQuery(String sql, Object[] params,
			String connectionString, String user, String pwd,
			Class<? extends T> type) {
		QueryRunner qr = new QueryRunner();
		try {
			Connection conn = DriverManager.getConnection(connectionString,
					user, pwd);
			List<T> ls = qr.query(conn, sql, new BeanListHandler<T>(type),
					params);
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public <T> GridPager<T> listPagerQuery(String sql, String sqlForCount,Object[] params,
			String connectionString, String user, String pwd,
			Class<? extends T> type) {
		QueryRunner qr = new QueryRunner();
		GridPager<T> r = new GridPager<T>();
		try {
			Connection conn = DriverManager.getConnection(connectionString,
					user, pwd);
			r.Data = qr.query(conn, sql, new BeanListHandler<T>(type), params);
			r.Total= qr.query(conn, sqlForCount, new ScalarHandler<Integer>(), params);
			r.ActionResult = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.ActionResult = false;
		}
		return r;
	}

	public DataResult query(String sql, String connectionString, String user,
			String pwd) {
		DataResult r = new DataResult();
		try {
			Connection conn = DriverManager.getConnection(connectionString,
					user, pwd);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			// 获取表结构
			ResultSetMetaData rsmt = rs.getMetaData();
			int columnsCount = rsmt.getColumnCount();
			r.Headers = new String[columnsCount];
			for (int i = 1; i <= columnsCount; i++) {
				r.Headers[i] = rsmt.getColumnName(i);
			}
			// 设置数据
			rs.last();
			r.Data = new Object[rs.getRow()][columnsCount];
			rs.beforeFirst();
			int row = 0;
			while (rs.next()) {
				for (int i = 1; i <= columnsCount; i++) {
					r.Data[row][i] = rs.getObject(i);
				}
				row = row + 1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
}
