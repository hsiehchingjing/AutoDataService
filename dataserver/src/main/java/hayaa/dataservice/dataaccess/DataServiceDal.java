package hayaa.dataservice.dataaccess;

import java.io.Reader;

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
	        			+ "SqldataserviceMapper.selectByActionName", 2);
	        	return r;
	        } finally {
	        session.close();
	        return null;
	        }
	}
}
