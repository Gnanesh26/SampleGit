package Eis.Entities;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private int emp_id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary")
	private double salary;

	@Column(name = "date_of_joining")
	private Date date_of_joining;

	public Employee() {
		super();
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "dep_id")
	private Department department;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "job_id")
	public Job job;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date_of_joining, department, emp_id, job, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(date_of_joining, other.date_of_joining) && Objects.equals(department, other.department)
				&& emp_id == other.emp_id && Objects.equals(job, other.job) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + ", date_of_joining="
				+ date_of_joining + ", department=" + department + ", job=" + job + "]";
	}

}
