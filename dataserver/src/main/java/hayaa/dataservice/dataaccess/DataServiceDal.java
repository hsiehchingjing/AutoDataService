package hayaa.dataservice.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import hayaa.dataservice.config.ConfigHelper;
import hayaa.dataservice.config.DataServerConfig;
import hayaa.dataservice.model.Sqldataservice;

public class DataServiceDal {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static DataServiceDal g_DataServiceDal = new DataServiceDal();

	public static DataServiceDal getInstance() {
		return g_DataServiceDal;
	}

	private DataServerConfig g_Config = ConfigHelper.getInstance().getConfig();

	private Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					g_Config.getDataServerConnenction(),
					g_Config.getDatabaseUser(), g_Config.getDatabaseUserPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Sqldataservice GetSqldataservice(String actionName) {
		Connection conn = getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = " select * from SqlDataService where ActionName=? and IsDelete=0 and Status=1";
		try {
			Sqldataservice r = qr.query(conn, sql,
					new BeanHandler<Sqldataservice>(Sqldataservice.class),
					actionName);
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @see 获取有服务资源分配的有效数据方法
	 */
	public List<Sqldataservice> GetServerServiceList(int resourceID) {
		Connection conn = getConnection();
		QueryRunner qr = new QueryRunner();
		String sql = "select s.* from SqlDataService s inner join Rel_Resource_DataService r "
				+ "on s.DataServiceID=r.DataServiceID  and s.IsDelete=0 and s.Status=1 where r.ResourceID=?";
		try {
			List<Sqldataservice> ls = qr.query(conn, sql,
					new BeanListHandler<Sqldataservice>(Sqldataservice.class),
					resourceID);
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
