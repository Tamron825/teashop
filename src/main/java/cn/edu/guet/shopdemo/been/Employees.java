package cn.edu.guet.shopdemo.been;

import java.util.Objects;

/**
 * @Auther wjw
 * @Date 2022/4/29 20:12
 * @Version 1.0
 */
public class Employees {
    private int e_id;//员工id
    private String e_name;//员工姓名
    private String e_department;//员工部门
    private String e_posts;//员工职务
    private int e_wages;//员工工资

    public Employees() {
    }

    public Employees(String e_name, String e_department, String e_posts, int e_wages) {
        this.e_name = e_name;
        this.e_department = e_department;
        this.e_posts = e_posts;
        this.e_wages = e_wages;
    }

    public Employees(int e_id, String e_name, String e_department, String e_posts, int e_wages) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_department = e_department;
        this.e_posts = e_posts;
        this.e_wages = e_wages;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }


    public String getE_department() {
        return e_department;
    }

    public void setE_department(String e_department) {
        this.e_department = e_department;
    }

    public String getE_posts() {
        return e_posts;
    }

    public void setE_posts(String e_posts) {
        this.e_posts = e_posts;
    }

    public int getE_wages() {
        return e_wages;
    }

    public void setE_wages(int e_wages) {
        this.e_wages = e_wages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return e_id == employees.e_id && e_wages == employees.e_wages && Objects.equals(e_name, employees.e_name) && Objects.equals(e_department, employees.e_department) && Objects.equals(e_posts, employees.e_posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e_id, e_name, e_department, e_posts, e_wages);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_department='" + e_department + '\'' +
                ", e_posts='" + e_posts + '\'' +
                ", e_wages=" + e_wages +
                '}';
    }
}
