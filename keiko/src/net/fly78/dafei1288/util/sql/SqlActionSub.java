package net.fly78.dafei1288.util.sql;

import java.sql.Connection;
import java.util.Collection;

public class SqlActionSub extends SqlAction {

	public SqlActionSub(String file) {
		super(file);
	}

	@Override
	public void setInsertSql(Connection conn) {
		System.out.println(conn);
		System.out.println("setInsertSql");
	}

	@Override
	public Object setOneSearchSql(Connection conn) {
		System.out.println("setOneSearchSql");
		System.out.println(conn);
		return null;
	}

	@Override
	public Collection<?> setSearchSql(Connection conn) {
		System.out.println("setSearchSql");
		System.out.println(conn);
		return null;
	}

	@Override
	public void setUpdateSql(Connection conn) {
		System.out.println(conn);
		System.out.println("setUpdateSql");
	}

	@Override
	public void setDeleteSql(Connection conn) {
		System.out.println(conn);
		System.out.println("setDeleteSql");
		
	}

}
