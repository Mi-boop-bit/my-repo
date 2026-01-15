package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生管理业务类，实现所有核心功能
 */
public class StudentManager {

    // ========== 功能1：添加学生信息到数据库 ==========
    public boolean addStudent(Student student) {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO students(name,gender,class_name,math_score,java_score) VALUES (?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGender());
            pstmt.setString(3, student.getClassName());
            pstmt.setDouble(4, student.getMathScore());
            pstmt.setDouble(5, student.getJavaScore());
            int rows = pstmt.executeUpdate();
            return rows > 0; // 受影响行数>0表示添加成功
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn, pstmt);
        }
        return false;
    }

    // ========== 功能2：根据学生ID查询单个学生信息 ==========
    public Student findStudentById(int id) {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM students WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("class_name"),
                        rs.getDouble("math_score"),
                        rs.getDouble("java_score")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn, pstmt, rs);
        }
        return null; // 无该ID学生返回null
    }

    // ========== 功能3：查询所有学生信息 ==========
    public List<Student> findAllStudents() {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("class_name"),
                        rs.getDouble("math_score"),
                        rs.getDouble("java_score")
                );
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn, pstmt, rs);
        }
        return studentList;
    }

    // ========== 功能4：计算所有学生各科目的平均分数 ==========
    public void calculateAvgScore() {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT AVG(math_score) mathAvg, AVG(java_score) javaAvg FROM students";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                double mathAvg = rs.getDouble("mathAvg");
                double javaAvg = rs.getDouble("javaAvg");
                System.out.println("===== 全班平均分统计 =====");
                System.out.println("高等数学平均分：" + String.format("%.2f", mathAvg) + "分");
                System.out.println("Java课程平均分：" + String.format("%.2f", javaAvg) + "分");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn, pstmt, rs);
        }
    }
}