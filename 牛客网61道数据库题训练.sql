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
select c.emp_no, c.salary, e.last_name, e.first_name
from
	(select b.emp_no, max(s.salary) salary
	from
		(select e.emp_no, e.last_name, e.first_name
		from employees e
		left join
			(select employees.emp_no from employees 
			join salaries on employees.emp_no = salaries.emp_no 
			where salaries.to_date = '9999-01-01' and salaries.salary = (select max(salary) from salaries where salaries.to_date = '9999-01-01')) a
		on e.emp_no = a.emp_no
		where a.emp_no is null) b
	join salaries s
	on b.emp_no = s.emp_no
	where s.to_date = '9999-01-01'
	group by b.emp_no
    order by salary desc
	limit 0,1) c
join employees e
on c.emp_no = e.emp_no;

CREATE TABLE `departments` (
`dept_no` char(4) NOT NULL,
`dept_name` varchar(40) NOT NULL,
PRIMARY KEY (`dept_no`));

19.查找所有员工的last_name和first_name以及对应的dept_name，也包括暂时没有分配部门的员工
select e.last_name, e.first_name, d.dept_name
from employees e
left join dept_emp de
on e.emp_no = de.emp_no
left join departments d
on de.dept_no = d.dept_no;

20.查找员工编号emp_no为10001其自入职以来的薪水salary涨幅值growth，只能从salaries表中获取数据
select (
	(select salary from salaries where emp_no = '10001' order by to_date desc limit 0,1)
    -
    (select salary from salaries where emp_no = '10001' order by to_date asc limit 0,1)
) growth;

21.查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序(题目有坑，题目说是所有员工，但如果去掉‘9999-01-01’这个条件限制就不通过)

select b.emp_no, (b.salary-c.salary) growth
from
	(select s.emp_no, s.salary
	from
		 salaries s
	join (select s.emp_no, max(s.to_date) to_date from salaries s where s.to_date = '9999-01-01' group by s.emp_no) a 
	on s.emp_no = a.emp_no and s.to_date = a.to_date) b
join
	(select s.emp_no, s.salary from salaries s join employees e on s.emp_no = e.emp_no where s.from_date = e.hire_date) c
on b.emp_no = c.emp_no
order by growth;

22.统计各个部门对应员工涨幅的次数总和，给出部门编码dept_no、部门名称dept_name以及次数sum
select 
	d.dept_no, d.dept_name, count(*) sum
from
	departments d, dept_emp de, salaries s
where
	d.dept_no = de.dept_no and de.emp_no = s.emp_no
group by 
	d.dept_no;
或者
select
    d.dept_no, d.dept_name, count(s.salary) sum
from
    departments d
join
    (dept_emp de join salaries s on de.emp_no = s.emp_no)
on
    d.dept_no = de.dept_no
group by
    d.dept_no, d.dept_name
order by
	d.dept_no;
	
23.对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列

select s1.emp_no, s1.salary, count(distinct s2.salary) as rank
from salaries s1, salaries s2
where s1.to_date = '9999-01-01' and s2.to_date = '9999-01-01' and s1.salary <= s2.salary
group by s1.emp_no, s1.salary
order by rank, s1.emp_no;

24.获取所有非manager员工当前的薪水情况，给出dept_no、emp_no以及salary ，当前表示to_date='9999-01-01'
select d.dept_no, b.* 
from
	(select s.emp_no, s.salary 
	from
		(select e.emp_no from employees e left join dept_manager dm on e.emp_no = dm.emp_no where dm.emp_no is null) a
	join salaries s
	on a.emp_no = s.emp_no and s.to_date = '9999-01-01') b
join dept_emp d
on b.emp_no = d.emp_no;

25.获取员工其当前的薪水比其manager当前薪水还高的相关信息，当前表示to_date='9999-01-01',
结果第一列给出员工的emp_no，
第二列给出其manager的manager_no，
第三列给出该员工当前的薪水emp_salary,
第四列给该员工对应的manager当前的薪水manager_salary
select b.emp_no, b.manager_no, s.salary emp_salary, b.manager_salary
from
	(select a.*, de.emp_no
	from
		(select salary manager_salary, dm.emp_no manager_no, dm.dept_no
		from dept_manager dm 
		join salaries s 
		on dm.emp_no = s.emp_no 
		where dm.to_date = '9999-01-01' and s.to_date = '9999-01-01') a 
    join 
		dept_emp de
	on
		a.dept_no = de.dept_no and a.manager_no != de.emp_no) b
join salaries s
on b.emp_no = s.emp_no and s.to_date = '9999-01-01' and s.salary > b.manager_salary;

26.汇总各个部门当前员工的title类型的分配数目，结果给出部门编号dept_no、dept_name、其当前员工所有的title以及该类型title对应的数目count

select d.dept_no, d.dept_name, t.title, count(t.title) count
from departments d, dept_emp de, titles t
where d.dept_no = de.dept_no and de.emp_no = t.emp_no and t.to_date = '9999-01-01' and de.to_date = '9999-01-01'
group by d.dept_no, d.dept_name, t.title
order by d.dept_no;

27.给出每个员工每年薪水涨幅超过5000的员工编号emp_no、薪水变更开始日期from_date以及薪水涨幅值salary_growth，并按照salary_growth逆序排列。
提示：在sqlite中获取datetime时间对应的年份函数为strftime('%Y', to_date)
select s1.emp_no, s1.from_date, (s2.salary-s1.salary) salary_growth
from salaries s1, salaries s2
where 
	s1.emp_no = s2.emp_no 
and (strftime('%Y', s1.to_date) = strftime('%Y', s2.to_date)-1 
		or 
	 strftime('%Y', s1.from_date) = strftime('%Y', s2.from_date)-1)
and
	s2.salary > s1.salary + 5000
order by salary_growth desc;


CREATE TABLE IF NOT EXISTS film (
film_id smallint(5)  NOT NULL DEFAULT '0',
title varchar(255) NOT NULL,
description text,
PRIMARY KEY (film_id));

CREATE TABLE category  (
category_id  tinyint(3)  NOT NULL ,
name  varchar(25) NOT NULL, `last_update` timestamp,
PRIMARY KEY ( category_id ));


CREATE TABLE film_category  (
film_id  smallint(5)  NOT NULL,
category_id  tinyint(3)  NOT NULL, `last_update` timestamp);
28.查找描述信息中包括robot的电影对应的分类名称以及电影数目，而且还需要该分类对应电影数量>=5部 (应该是题目有误)
SELECT c.name, COUNT(fc.film_id) FROM
 (select category_id, COUNT(film_id) AS category_num FROM
     film_category  GROUP BY category_id HAVING count(film_id)>=5) AS cc,
 film AS f, film_category AS fc, category AS c
WHERE  f.description LIKE '%robot%'
AND f.film_id = fc.film_id
AND c.category_id = fc.category_id
AND c.category_id=cc.category_id






















