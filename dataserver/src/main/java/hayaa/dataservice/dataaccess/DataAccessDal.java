package hayaa.dataservice.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import hayaa.dataservice.model.DataResult;
import hayaa.dataservice.model.ReturnResult;

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
	
	public ReturnResult insert(String sql,String connectionString,String user,String pwd) {
		ReturnResult r=new ReturnResult(); 
		r.ActionResult=false;
		try {
			 Connection conn = DriverManager.getConnection(connectionString, user, pwd);
			 Statement statement = conn.createStatement();  
		    ResultSet rs = statement.executeQuery(sql);  
		     r.DataJson=rs.getString(0);
		     r.ActionResult=true;
		 } catch (SQLException e) {
				r.Messsage=e.getMessage();
				e.printStackTrace();
			}  
		   return r;
	}
 	public DataResult query(String sql,String connectionString,String user,String pwd) {
			DataResult r=new DataResult();
		   try {
			   Connection conn = DriverManager.getConnection(connectionString, user, pwd);
			   Statement statement = conn.createStatement();  
			   ResultSet rs = statement.executeQuery(sql);  
			   //获取表结构
			   ResultSetMetaData rsmt=rs.getMetaData();	
			   int columnsCount=rsmt.getColumnCount();
			   r.Headers=new String[columnsCount];
			   for(int i=1;i<=columnsCount;i++) {
				   r.Headers[i]=rsmt.getColumnName(i);
			   }
			   //设置数据
			   rs.last();
			   r.Data=new Object[rs.getRow()][columnsCount];
			   rs.beforeFirst();
			   int row=0;
			   while(rs.next())
			   {				  
			    for(int i=1;i<=columnsCount;i++)
			    {
			    	r.Data[row][i]=rs.getObject(i);
			    }
			    row=row+1;
			   }
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return r;
	}
}
