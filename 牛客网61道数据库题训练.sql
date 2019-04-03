CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));


1.����������ְԱ����������Ϣ
select * from employees 
where hire_date = (select max(hire_date) from employees);

2.������ְԱ��ʱ����������������Ա��������Ϣ
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

3.���Ҹ������ŵ�ǰ(to_date='9999-01-01')�쵼��ǰнˮ�����Լ����Ӧ���ű��dept_no
select s.*, d.dept_no from salaries s inner join dept_manager d 
on d.emp_no = s.emp_no 
and d.to_date = '9999-01-01' 
and s.to_date = '9999-01-01';
��Ŀ�пӣ����������salaries������join ... on ����ĵڶ�������ѯ����Ҳ������where


CREATE TABLE `dept_emp` (
`emp_no` int(11) NOT NULL,
`dept_no` char(4) NOT NULL,
`from_date` date NOT NULL,
`to_date` date NOT NULL,
PRIMARY KEY (`emp_no`,`dept_no`));

4.���������Ѿ����䲿�ŵ�Ա����last_name��first_name
select employees.last_name, employees.first_name, dept_emp.dept_no 
from employees join dept_emp 
on employees.emp_no = dept_emp.emp_no;

5.��������Ա����last_name��first_name�Լ���Ӧ���ű��dept_no��Ҳ����չʾû�з�����岿�ŵ�Ա��
select employees.last_name, employees.first_name, dept_emp.dept_no 
from employees
left join dept_emp
on employees.emp_no = dept_emp.emp_no;

6.��������Ա����ְʱ���нˮ���������emp_no�Լ�salary�� ������emp_no��������
select employees.emp_no, salary
from employees
left join salaries
on employees.emp_no = salaries.emp_no
where employees.hire_date = from_date
order by employees.emp_no desc;

7.����нˮ�Ƿ�����15�ε�Ա����emp_no�Լ����Ӧ���Ƿ�����t
select emp_no, count(distinct salary) t
from salaries
group by emp_no
having t > 15;

8.�ҳ�����Ա����ǰ(to_date='9999-01-01')�����нˮsalary�����������ͬ��нˮֻ��ʾһ��,������������ʾ
select distinct salary
from salaries
where salaries.to_date = '9999-01-01'
order by salary desc;

9.��ȡ���в��ŵ�ǰmanager�ĵ�ǰнˮ���������dept_no, emp_no�Լ�salary����ǰ��ʾto_date='9999-01-01'
select dept_manager.dept_no, dept_manager.emp_no, salary
from dept_manager
join salaries
on dept_manager.emp_no = salaries.emp_no
where salaries.to_date = '9999-01-01' and dept_manager.to_date = '9999-01-01';

10.��ȡ���з�manager��Ա��emp_no
select employees.emp_no 
from employees
left join dept_manager
on employees.emp_no = dept_manager.emp_no
where dept_manager.emp_no is null;

select employees.emp_no
from employees
where employees.emp_no not in (select distinct emp_no from dept_manager);

11.��ȡ����Ա����ǰ��manager�������ǰ��manager���Լ��Ļ��������ʾ����ǰ��ʾto_date='9999-01-01'��
�����һ�и�����ǰԱ����emp_no,�ڶ��и�����manager��Ӧ��manager_no��
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

12.��ȡ���в����е�ǰԱ��нˮ��ߵ������Ϣ������dept_no, emp_no�Լ����Ӧ��salary
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

13.��titles���ȡ����title���з��飬ÿ��������ڵ���2������title�Լ���Ӧ����Ŀt��
select title, count(*) t from titles group by title having t >= 2;

14.��titles���ȡ����title���з��飬ÿ��������ڵ���2������title�Լ���Ӧ����Ŀt��
ע������ظ���emp_no���к��ԡ�
select title, count(distinct emp_no) t from titles group by title having t >= 2;

15.����employees������emp_noΪ��������last_name��ΪMary��Ա����Ϣ��������hire_date��������
select * from employees
where emp_no&1 and last_name!='Mary'
order by hire_date desc;

16.ͳ�Ƴ���ǰ����title���Ͷ�Ӧ��Ա����ǰнˮ��Ӧ��ƽ�����ʡ��������title�Լ�ƽ������avg��
select title, avg(salary)
from titles
join salaries
on titles.emp_no = salaries.emp_no
where salaries.to_date = '9999-01-01' and titles.to_date = '9999-01-01'
group by title;

17.��ȡ��ǰ��to_date='9999-01-01'��нˮ�ڶ����Ա����emp_no�Լ����Ӧ��нˮsalary
select emp_no, max(salary) salary from salaries
where salaries.to_date = '9999-01-01'
group by emp_no
order by salary desc
limit 1,1;

18.���ҵ�ǰнˮ(to_date='9999-01-01')�����ڶ����Ա�����emp_no��нˮsalary��last_name�Լ�first_name����׼ʹ��order by
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

19.��������Ա����last_name��first_name�Լ���Ӧ��dept_name��Ҳ������ʱû�з��䲿�ŵ�Ա��
select e.last_name, e.first_name, d.dept_name
from employees e
left join dept_emp de
on e.emp_no = de.emp_no
left join departments d
on de.dept_no = d.dept_no;

20.����Ա�����emp_noΪ10001������ְ������нˮsalary�Ƿ�ֵgrowth��ֻ�ܴ�salaries���л�ȡ����
select (
	(select salary from salaries where emp_no = '10001' order by to_date desc limit 0,1)
    -
    (select salary from salaries where emp_no = '10001' order by to_date asc limit 0,1)
) growth;

21.��������Ա������ְ������нˮ�Ƿ����������Ա�����emp_no�Լ����Ӧ��нˮ�Ƿ�growth��������growth��������(��Ŀ�пӣ���Ŀ˵������Ա���������ȥ����9999-01-01������������ƾͲ�ͨ��)

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

22.ͳ�Ƹ������Ŷ�ӦԱ���Ƿ��Ĵ����ܺͣ��������ű���dept_no����������dept_name�Լ�����sum
select 
	d.dept_no, d.dept_name, count(*) sum
from
	departments d, dept_emp de, salaries s
where
	d.dept_no = de.dept_no and de.emp_no = s.emp_no
group by 
	d.dept_no;
����
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
	
23.������Ա���ĵ�ǰ(to_date='9999-01-01')нˮ����salary���а���1-N����������ͬsalary�����Ұ���emp_no��������

select s1.emp_no, s1.salary, count(distinct s2.salary) as rank
from salaries s1, salaries s2
where s1.to_date = '9999-01-01' and s2.to_date = '9999-01-01' and s1.salary <= s2.salary
group by s1.emp_no, s1.salary
order by rank, s1.emp_no;

24.��ȡ���з�managerԱ����ǰ��нˮ���������dept_no��emp_no�Լ�salary ����ǰ��ʾto_date='9999-01-01'
select d.dept_no, b.* 
from
	(select s.emp_no, s.salary 
	from
		(select e.emp_no from employees e left join dept_manager dm on e.emp_no = dm.emp_no where dm.emp_no is null) a
	join salaries s
	on a.emp_no = s.emp_no and s.to_date = '9999-01-01') b
join dept_emp d
on b.emp_no = d.emp_no;

25.��ȡԱ���䵱ǰ��нˮ����manager��ǰнˮ���ߵ������Ϣ����ǰ��ʾto_date='9999-01-01',
�����һ�и���Ա����emp_no��
�ڶ��и�����manager��manager_no��
�����и�����Ա����ǰ��нˮemp_salary,
�����и���Ա����Ӧ��manager��ǰ��нˮmanager_salary
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

26.���ܸ������ŵ�ǰԱ����title���͵ķ�����Ŀ������������ű��dept_no��dept_name���䵱ǰԱ�����е�title�Լ�������title��Ӧ����Ŀcount

select d.dept_no, d.dept_name, t.title, count(t.title) count
from departments d, dept_emp de, titles t
where d.dept_no = de.dept_no and de.emp_no = t.emp_no and t.to_date = '9999-01-01' and de.to_date = '9999-01-01'
group by d.dept_no, d.dept_name, t.title
order by d.dept_no;

27.����ÿ��Ա��ÿ��нˮ�Ƿ�����5000��Ա�����emp_no��нˮ�����ʼ����from_date�Լ�нˮ�Ƿ�ֵsalary_growth��������salary_growth�������С�
��ʾ����sqlite�л�ȡdatetimeʱ���Ӧ����ݺ���Ϊstrftime('%Y', to_date)
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
28.����������Ϣ�а���robot�ĵ�Ӱ��Ӧ�ķ��������Լ���Ӱ��Ŀ�����һ���Ҫ�÷����Ӧ��Ӱ����>=5�� (Ӧ������Ŀ����)
SELECT c.name, COUNT(fc.film_id) FROM
 (select category_id, COUNT(film_id) AS category_num FROM
     film_category  GROUP BY category_id HAVING count(film_id)>=5) AS cc,
 film AS f, film_category AS fc, category AS c
WHERE  f.description LIKE '%robot%'
AND f.film_id = fc.film_id
AND c.category_id = fc.category_id
AND c.category_id=cc.category_id






















