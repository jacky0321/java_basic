package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import models.Student;

public class SqlHandlers {

	public void insert(Statement statement, Student stu) {
		int modifyNum = 0;
		String sqlString = "insert into t_student values(null,'" + stu.getName() + "'," + stu.getAge() + ");";
		System.out.println(sqlString);
		try {
			modifyNum = statement.executeUpdate(sqlString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("insert + " + modifyNum + " lines.");
	}

	public void update(Statement statement, Student stu) {
		int modifyNum = 0;
		String sqlString = "update t_student set name = '" + stu.getName() + "', age = " + stu.getAge() + " where id = "
				+ stu.getId() + ";";
		System.out.println(sqlString);
		try {
			modifyNum = statement.executeUpdate(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("insert + " + modifyNum + " lines.");
	}

	public void delete(Statement statement, int id) {
		int modifyNum = 0;
		String sqlString = "delete from t_student where id = " + id;
		System.out.println(sqlString);
		try {
			modifyNum = statement.executeUpdate(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("delete " + modifyNum + " lines.");
	}

	public void preInsert(PreparedStatement preStat, Student stu) {
		int modifyNum = 0;

		try {
			preStat.setString(1, stu.getName());
			preStat.setInt(2, stu.getAge());
			modifyNum = preStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("insert " + modifyNum + " lines.");
	}

	public void preUpdate(PreparedStatement preStat, Student stu) {
		int modifyNum = 0;

		try {
			preStat.setString(1, stu.getName());
			preStat.setInt(2, stu.getAge());
			preStat.setInt(3, stu.getId());
			modifyNum = preStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("update " + modifyNum + " lines.");
	}

	public void preDelete(PreparedStatement preStat, int id) {
		int modifyNum = 0;

		try {
			preStat.setInt(1, id);

			modifyNum = preStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("delete " + modifyNum + " lines.");
	}

	public List<Student> preSelect(PreparedStatement preStat) {
		ResultSet rSet = null;
		List<Student> students = new ArrayList<>();
		Student student = null;
		try {
			rSet = preStat.executeQuery();
			while (rSet.next()) {
				student = new Student(rSet.getInt("id"), rSet.getInt("age"), rSet.getString("name"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public float callProcedure(CallableStatement callStat, int deptno) {
		 /*show create procedure pro_dept_avg_sal\G
		 * *************************** 1. row ***************************
		 * Procedure: pro_dept_avg_sal 
		 * sql_mode:  STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION
		 * Create Procedure: CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_dept_avg_sal`(in dept_no int, out avg_sal float)
		 * begin 
		 * select avg(sal) into avg_sal from emp where deptno = dept_no; 
		 * end
		 * character_set_client: utf8 collation_connection: utf8_general_ci
		 * Database Collation: utf8_general_ci
		 */
		float avgSal = 0.0f;
		try {
			callStat.setInt(1, deptno);
			callStat.registerOutParameter(2, Types.FLOAT);
			callStat.execute();

			avgSal = callStat.getFloat("avg_sal");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return avgSal;
	}
	
	public void getDbMeta(Connection conn) {
		OutputStream oStream = null;
		PrintStream pStream = null;
		try {
			DatabaseMetaData dbMeta = conn.getMetaData();
			File file = new File("c://error.txt");
			oStream = new FileOutputStream(file);
			pStream = new PrintStream(oStream);
			
			System.out.println(dbMeta.getDriverVersion());
			throw new Exception();// test e.printStackTrace(pStream); 

		} catch (Exception e) {
			e.printStackTrace(pStream);
		}
	}
	
	public void getRsMeta(PreparedStatement preStat) {

		try {
			ResultSetMetaData rsMetaData = preStat.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			for(int i = 1; i <= columnCount; i++) {
				System.out.println(i + " " + rsMetaData.getColumnName(i) + " " + rsMetaData.getColumnTypeName(i));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
