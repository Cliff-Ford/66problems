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
select count(distinct emp_no) n from salaries where salaries.to_date = '9999-01-01'

select s.emp_no, max(s.salary) salary, e.last_name, e.first_name
from salaries s
join employees e
on s.emp_no = e.emp_no
where s.to_date = '9999-01-01'
group by s.emp_no
having salary != (select max(salaries.salary) from salaries where salaries.to_date = '9999-01-01')















