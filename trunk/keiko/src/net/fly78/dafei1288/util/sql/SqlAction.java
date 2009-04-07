package net.fly78.dafei1288.util.sql;

import java.sql.Connection;
import java.util.Collection;

public abstract class SqlAction {
	
	private SqlConnectionManager sqlm;
	public SqlConnectionManager getSQLConnectionManager(){
		return this.sqlm;
	}
	public SqlAction(String file){
		sqlm = SqlConnectionManager.getInstance(file);
	} 
	
	public boolean update(){
		boolean tag = false;
		try{
			this.setUpdateSql(sqlm.getConnection());
			//sqlm.release();
			tag = true;
		}catch(Exception e){
			e.printStackTrace();
			tag = false;
		}
		return tag;
	}
	
	public boolean delete(){
		boolean tag = false;
		try{
			this.setDeleteSql(sqlm.getConnection());
			//sqlm.release();
			tag = true;
		}catch(Exception e){
			e.printStackTrace();
			tag = false;
		}
		return tag;
	}
	
	public boolean insert(){
		boolean tag = false;
		try{
			this.setInsertSql(sqlm.getConnection());
			//sqlm.release();
			tag = true;
		}catch(Exception e){
			e.printStackTrace();
			tag = false;
		}
		return tag;
	}
	
	
	public Object getOneSearchSql(){
		Object o = this.setOneSearchSql(sqlm.getConnection());
		//sqlm.release();
		return o;
	}
	
	public Collection<?> getSearchSql(){
		Collection<?> col = this.setSearchSql(sqlm.getConnection());
		//sqlm.release();
		return col;
	}
	
	abstract public void setInsertSql(Connection conn);
	abstract public Object setOneSearchSql(Connection conn);
	abstract public Collection<?> setSearchSql(Connection conn);
	abstract public void setUpdateSql(Connection conn);
	abstract public void setDeleteSql(Connection conn);
}
