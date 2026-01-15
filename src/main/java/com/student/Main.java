package com.student;

import java.util.List;
import java.util.Scanner;

/**
 * 程序主类，控制台交互入口
 */
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 打印菜单
            System.out.println("\n===== 学生信息管理系统 =====");
            System.out.println("1. 添加学生信息");
            System.out.println("2. 根据ID查询学生");
            System.out.println("3. 显示所有学生信息");
            System.out.println("4. 计算各科平均分");
            System.out.println("5. 退出系统");
            System.out.print("请输入你的选择（1-5）：");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 吸收换行符

            // 菜单功能分支
            switch (choice) {
                case 1:
                    // 添加学生
                    System.out.print("请输入学生姓名：");
                    String name = scanner.nextLine();
                    System.out.print("请输入学生性别：");
                    String gender = scanner.nextLine();
                    System.out.print("请输入学生班级：");
                    String className = scanner.nextLine();
                    System.out.print("请输入高数成绩：");
                    double math = scanner.nextDouble();
                    System.out.print("请输入Java成绩：");
                    double java = scanner.nextDouble();
                    Student student = new Student(name, gender, className, math, java);
                    boolean isAdd = manager.addStudent(student);
                    if (isAdd) {
                        System.out.println("✅ 学生信息添加成功！");
                    } else {
                        System.out.println("❌ 学生信息添加失败！");
                    }
                    break;
                case 2:
                    // 根据ID查询
                    System.out.print("请输入要查询的学生ID：");
                    int id = scanner.nextInt();
                    Student s = manager.findStudentById(id);
                    if (s != null) {
                        System.out.println("✅ 查询到学生信息：");
                        System.out.println(s);
                    } else {
                        System.out.println("❌ 未查询到该ID的学生！");
                    }
                    break;
                case 3:
                    // 显示所有学生
                    List<Student> list = manager.findAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("📄 暂无学生信息！");
                    } else {
                        System.out.println("===== 所有学生信息 =====");
                        for (Student stu : list) {
                            System.out.println(stu);
                        }
                    }
                    break;
                case 4:
                    // 计算平均分
                    manager.calculateAvgScore();
                    break;
                case 5:
                    // 退出系统
                    System.out.println("👋 感谢使用学生管理系统，再见！");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ 输入错误，请输入1-5之间的数字！");
            }
        }
    }
}