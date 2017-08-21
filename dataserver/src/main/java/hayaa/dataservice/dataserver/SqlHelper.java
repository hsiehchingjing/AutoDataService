package hayaa.dataservice.dataserver;

import java.util.Hashtable;
import java.util.Map.Entry;

import hayaa.dataservice.config.DefineTable;
import hayaa.dataservice.model.*;



public class SqlHelper {
	
	public String GetInsertSql(Hashtable<String, String> pamaters,String sqlTemplate) {
		StringBuffer columns=new StringBuffer();
		StringBuffer values=new StringBuffer();
		for(Entry<String, String> entry:pamaters.entrySet()) {
			columns.append(entry.getKey()+",");
			values.append(entry.getValue()+",");
		}
		sqlTemplate=sqlTemplate.replace(DefineTable.SqlTmpTag_Column, columns.substring(columns.length(), 
				columns.length()-2));
		sqlTemplate=sqlTemplate.replace(DefineTable.SqlTmpTag_ColumnValue, values.substring(values.length(),
				values.length()-2));
		return sqlTemplate;
	}
 public	String GetQuerySql(CommonQuery queryInfo,String sqlTemplate) {
		if(queryInfo==null)
			return "queryInfo is null";
		StringBuilder sql=new StringBuilder();
		//替代展示列
		StringBuilder strColumn=new StringBuilder();
		for(int i=0;i<queryInfo.Columns.length;i++) {
			strColumn.append(queryInfo.Columns[i].Key+",");
		}
		sqlTemplate.replace(DefineTable.SqlTmpTag_Column, strColumn.substring(0, strColumn.length()-2));
		//置换过滤条件		
		sqlTemplate=sqlTemplate.replace(DefineTable.SqlTmpTag_Filter,getFilter(queryInfo.Filter));		
		//置换分组
		sqlTemplate=sqlTemplate.replace(DefineTable.SqlTmpTag_GroupBy,String.join(",", queryInfo.GroupBys));	
		//置换排序
		sqlTemplate=sqlTemplate.replace(DefineTable.SqlTmpTag_OrderBy,getOrderBy(queryInfo.OrderBys));	
		return sql.toString();
	}

	private String getOrderBy(OrderBy[] orderBys) {
		if(orderBys==null)
			return "";
		StringBuffer str=new StringBuffer();
		for(int i=0;i<orderBys.length;i++) {
			str.append(orderBys[i].OrderColumn+" "+orderBys[i].OrderDirection.getValue()+",");
		}
		return str.substring(0, str.length()-2);
	}

	private String getFilter(FilterItem[] filter) {
		if(filter==null)
			return "";
		StringBuffer str=new StringBuffer();
		for(int i=0;i<filter.length;i++) {
			FilterItem temp=filter[i];
			StringBuilder values=new StringBuilder();
			String strQuote="";
			if(temp.IsQuote) strQuote="'";
			if(temp.FilterValues.length>1) {//多值运算
				values.append("(");
				for(int j=0;j<temp.FilterValues.length;j++) {
					values.append(String.format("{0}{1}{2},", strQuote,temp.FilterValues[j],strQuote));
				}
				values.delete(values.length()-1, values.length()-1);
				values.append(")");				
			}else {//一值运算
				values.append(String.format("{0}{1}{2},", strQuote,temp.FilterValues[0],strQuote));
			}			
			str.append(String.format("{0}{1}{2}", temp.FilterOn,temp.FilterType.getValue(),values.toString()));			
		}
		return str.toString();
	}
}
