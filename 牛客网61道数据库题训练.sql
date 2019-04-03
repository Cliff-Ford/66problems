CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));


1.查找最晚入职员工的所有信息
select * from employees 
where hire_date = (select max(hire_date) from employees);

2.查找入职员工时间排名倒数第三的员工所有信息
select * from employees 
where hire_date = (select hire_date from employees group by hire_date order by hire_date desc limit 2,1);

CREATE TABLE `dept_manager` (
`dept_no` char(4) NOT NULL,
`emp_no` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

CREATE TABLE `salaries` (
`emp_no` int(11) NOT NULL,
`salary` int(11) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`from_date`));

3.查找各个部门当前(to_date='9999-01-01')领导当前薪水详情以及其对应部门编号dept_no
select s.*, d.dept_no from salaries s inner join dept_manager d 
on d.emp_no = s.emp_no 
and d.to_date = '9999-01-01' 
and s.to_date = '9999-01-01';
题目有坑，主表必须是salaries，另外join ... on 后面的第二三个查询条件也可以用where


CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

4.查找所有已经分配部门的员工的last_name和first_name
select employees.last_name, employees.first_name, dept_emp.dept_no 
from employees join dept_emp 
on employees.emp_no = dept_emp.emp_no;

5.查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括展示没有分配具体部门的员工
select employees.last_name, employees.first_name, dept_emp.dept_no 
from employees
left join dept_emp
on employees.emp_no = dept_emp.emp_no;

6.查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序
select employees.emp_no, salary
from employees
left join salaries
on employees.emp_no = salaries.emp_no
where employees.hire_date = from_date
order by employees.emp_no desc;

7.查找薪水涨幅超过15次的员工号emp_no以及其对应的涨幅次数t
select emp_no, count(distinct salary) t
from salaries
group by emp_no
having t > 15;

8.找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示
select distinct salary
from salaries
where salaries.to_date = '9999-01-01'
order by salary desc;

9.获取所有部门当前manager的当前薪水情况，给出dept_no, emp_no以及salary，当前表示to_date='9999-01-01'
select dept_manager.dept_no, dept_manager.emp_no, salary
from dept_manager
join salaries
on dept_manager.emp_no = salaries.emp_no
where salaries.to_date = '9999-01-01' and dept_manager.to_date = '9999-01-01';

10.获取所有非manager的员工emp_no
select employees.emp_no 
from employees
left join dept_manager
on employees.emp_no = dept_manager.emp_no
where dept_manager.emp_no is null;

select employees.emp_no
from employees
where employees.emp_no not in (select distinct emp_no from dept_manager);

11.获取所有员工当前的manager，如果当前的manager是自己的话结果不显示，当前表示to_date='9999-01-01'。
结果第一列给出当前员工的emp_no,第二列给出其manager对应的manager_no。
select c.emp_no, dept_manager.emp_no manager_no
from
	(select dept_emp.emp_no, dept_emp.dept_no
	from dept_emp
	left join dept_manager b
	on dept_emp.emp_no = b.emp_no and b.to_date = '9999-01-01'
	where b.emp_no is null) c
join dept_manager
on c.dept_no = dept_manager.dept_no
where dept_manager.to_date = '9999-01-01';

12.获取所有部门中当前员工薪水最高的相关信息，给出dept_no, emp_no以及其对应的salary
select b.dept_no, a.emp_no, a.salary
from
	(select dept_emp.dept_no, dept_emp.emp_no, max(salary) salary 
     from dept_emp 
     join salaries 
     on dept_emp.emp_no = salaries.emp_no 
     where dept_emp.to_date = '9999-01-01' and salaries.to_date = '9999-01-01' 
     group by dept_emp.dept_no, dept_emp.emp_no) a
join 
	(select dept_no, max(salary) salary from dept_emp join salaries on dept_emp.emp_no = salaries.emp_no
	 where salaries.to_date = '9999-01-01' and dept_emp.to_date = '9999-01-01'
	 group by dept_no) b
on a.salary = b.salary and b.dept_no = a.dept_no
order by b.dept_no;

CREATE TABLE IF NOT EXISTS "titles" (
`emp_no` int(11) NOT NULL,
`title` varchar(50) NOT NULL,
`from_date` date NOT NULL,
`to_date` date DEFAULT NULL);

13.从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
select title, count(*) t from titles group by title having t >= 2;

14.从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
注意对于重复的emp_no进行忽略。
select title, count(distinct emp_no) t from titles group by title having t >= 2;

15.查找employees表所有emp_no为奇数，且last_name不为Mary的员工信息，并按照hire_date逆序排列
select * from employees
where emp_no&1 and last_name!='Mary'
order by hire_date desc;

16.统计出当前各个title类型对应的员工当前薪水对应的平均工资。结果给出title以及平均工资avg。
select title, avg(salary)
from titles
join salaries
on titles.emp_no = salaries.emp_no
where salaries.to_date = '9999-01-01' and titles.to_date = '9999-01-01'
group by title;

17.获取当前（to_date='9999-01-01'）薪水第二多的员工的emp_no以及其对应的薪水salary
select emp_no, max(salary) salary from salaries
where salaries.to_date = '9999-01-01'
group by emp_no
order by salary desc
limit 1,1;

18.查找当前薪水(to_date='9999-01-01')排名第二多的员工编号emp_no、薪水salary、last_name以及first_name，不准使用order by
select count(distinct emp_no) n from salaries where salaries.to_date = '9999-01-01'

select s.emp_no, max(s.salary) salary, e.last_name, e.first_name
from salaries s
join employees e
on s.emp_no = e.emp_no
where s.to_date = '9999-01-01'
group by s.emp_no
having salary != (select max(salaries.salary) from salaries where salaries.to_date = '9999-01-01')















