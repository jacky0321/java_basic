package LearnJDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import models.Student;
import utils.Dbutil;
import utils.SqlHandlers;

public class LearnJDBC {
	
	public static void main(String[] args) {
		Dbutil dbutil = new Dbutil();
		
		Connection conn = dbutil.getCon();
		Statement stat = dbutil.getStat(conn);		
		SqlHandlers sqlHandler = new SqlHandlers();
		
//		Student stu = new Student(24, "jacky");
//		sqlHandler.insert(stat, stu);
		
//		Student student = new Student(1, 25, "jacky");
//		sqlHandler.update(stat, student);
//		dbutil.close(conn, stat);
		
//		int id = 1;
//		sqlHandler.delete(stat, id);
		
//		String insertSqlString = "insert into t_student values(null, ?, ?);";
//		PreparedStatement preStat = dbutil.getPreStat(conn, insertSqlString);
//		Student stu = new Student(24, "jacky");
//		sqlHandler.preInsert(preStat, stu);
		
//		String sqlString = "update t_student set name=? , age=? where id=?;";
//		PreparedStatement preStat = dbutil.getPreStat(conn, sqlString);
//		Student stu = new Student(2, 30, "mike");
//		sqlHandler.preUpdate(preStat, stu);
//		dbutil.close(conn, stat);
		
//		String sqlString = "delete from t_student where id = ?";
//		PreparedStatement preStat = dbutil.getPreStat(conn, sqlString);
//		
//		sqlHandler.preDelete(preStat, 2);
		
//		String string = "select * from t_student;";
//		PreparedStatement preStat = dbutil.getPreStat(conn, string);
//		List<Student> students = sqlHandler.preSelect(preStat);
//		System.out.println(students);
		
//		String string = "call Pro_dept_avg_sal(?, ?); ";
//		CallableStatement callStat = dbutil.getCallStat(conn, string);
//		float avgSal = sqlHandler.callProcedure(callStat, 10);
//		System.out.println(avgSal);
		
//		sqlHandler.getDbMeta(conn);
		
		String string = "select * from t_student;";
		PreparedStatement preStat = dbutil.getPreStat(conn, string);
		sqlHandler.getRsMeta(preStat);
		dbutil.close(conn, stat);
		
	}
}
