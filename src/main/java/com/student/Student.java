package com.student;

/**
 * 学生实体类，封装学生信息
 */
public class Student {
    // 成员属性：与数据库表字段完全对应
    private Integer id;         // 学生ID
    private String name;        // 学生姓名
    private String gender;      // 学生性别
    private String className;   // 学生班级
    private Double mathScore;   // 高数成绩
    private Double javaScore;   // Java成绩

    // 无参构造方法（必须）
    public Student() {
    }

    // 有参构造方法（新增学生时用，不含id，因为id自增）
    public Student(String name, String gender, String className, Double mathScore, Double javaScore) {
        this.name = name;
        this.gender = gender;
        this.className = className;
        this.mathScore = mathScore;
        this.javaScore = javaScore;
    }

    // 全参构造方法（查询时用）
    public Student(Integer id, String name, String gender, String className, Double mathScore, Double javaScore) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.className = className;
        this.mathScore = mathScore;
        this.javaScore = javaScore;
    }

    // 所有属性的setter和getter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getMathScore() {
        return mathScore;
    }

    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }

    public Double getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(Double javaScore) {
        this.javaScore = javaScore;
    }

    // toString方法：打印学生信息时格式化输出
    @Override
    public String toString() {
        return "Student{" +
                "学号=" + id +
                ", 姓名='" + name + '\'' +
                ", 性别='" + gender + '\'' +
                ", 班级='" + className + '\'' +
                ", 高数成绩=" + mathScore +
                ", Java成绩=" + javaScore +
                '}';
    }
}