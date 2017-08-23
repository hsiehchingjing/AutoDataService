package hayaa.dataservice.dataaccess;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import hayaa.dataservice.config.ConfigHelper;
import hayaa.dataservice.config.DataServerConfig;
import hayaa.dataservice.model.Sqldataservice;

public class DataServiceDal {
	 private static SqlSessionFactory sqlSessionFactory;
	    private static Reader reader;

	    static{
	        try{
	            reader= Resources.getResourceAsReader("Configuration.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	private DataServerConfig g_Config=ConfigHelper.getInstance().getConfig();
	@SuppressWarnings("finally")
	public static Sqldataservice GetSqldataservice(String actionName) {	
		 SqlSession session = sqlSessionFactory.openSession();
	        try {
	        	Sqldataservice r = (Sqldataservice) session.selectOne("hayaa.dataservice.model."
	        			+ "SqldataserviceMapper.selectByActionName",actionName);
	        	return r;
	        } finally {
	        session.close();
	        return null;
	        }
	}
	/*
	 * @see 获取有服务资源分配的有效数据方法
	 */
	@SuppressWarnings("finally")
	public static List<Sqldataservice> GetSqldataservice(int resourceID) {	
		 SqlSession session = sqlSessionFactory.openSession();
	        try {
	        	List<Object> tr = session.selectList("hayaa.dataservice.model."
	        			+ "SqldataserviceMapper.selectByResourceID", resourceID);
	        	List<Sqldataservice> r=null;
	        	if(tr!=null) {
	        		r=new ArrayList<Sqldataservice>();
	        		for(Object val:tr){
	        			r.add((Sqldataservice)val);
	        		}
	        	}
	        	return r;
	        } finally {
	        session.close();
	        return null;
	        }
	}
}
