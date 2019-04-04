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

29.ʹ��join��ѯ��ʽ�ҳ�û�з���ĵ�Ӱid�Լ�����
select f.film_id, f.film_title from film left join film_category fc on f.film_id = fc.film_id where fc.film_id is null;

30.ʹ���Ӳ�ѯ�ķ�ʽ�ҳ�����Action��������е�Ӱ��Ӧ��title,description 
select title, description from film f where f.film_id in (select fc.film_id from film_category fc where fc.category_id = (select category_id from category where name = 'Action'))

31.��ȡselect * from employees��Ӧ��ִ�мƻ�
explain select * from employees;

32.��employees�������Ա����last_name��first_nameƴ��������ΪName���м���һ���ո�����(sqliteֻ֧��||���ӷ�ʽ)
select last_name||" "||first_name as name from employees;
select concat(last_name, ' ', first_name) as name from employees;(mysql,sqlserver,oracle)

33.����һ��actor��������������Ϣ
sqliteû��getdate()����
create table actor(
	actor_id smallint(5) not null,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	last_update timestamp not null default (datetime('now','localtime')),          
	primary key(actor_id)
);
mysql��
create table actor(
	actor_id smallint(5) not null,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	last_update timestamp not null default getdate(),          
	primary key(actor_id)
);

34.���ڱ�actor����������������
insert into actor(actor_id, first_name, last_name, last_update) 
values(1, 'PENELOPE', 'GUINESS', '2006-02-15 12:34:33'),(2, 'NICK', 'WAHLBERG', '2006-02-15 12:34:33')
��һ�ַ���
insert into actor(actor_id, first_name, last_name, last_update) 
select 1, 'PENELOPE', 'GUINESS', '2006-02-15 12:34:33'
union select 2, 'NICK', 'WAHLBERG', '2006-02-15 12:34:33'

35.���ڱ�actor����������������,��������Ѿ����ڣ�����ԣ���ʹ��replace����
insert or ignore into actor(actor_id, first_name, last_name, last_update) values(3, 'ED', 'CHASE', '2006-02-15 12:34:33')

36.����һ��actor_name����actor���е�����first_name�Լ�last_name����ñ� actor_name��ṹ���£�
create table actor_name(
	first_name varchar(45) not null,
	last_name varchar(45) not null
);
insert into actor_name(first_name, last_name) select first_name, last_name from actor;

37.������±�actor�ṹ��first_name����Ψһ����uniq_idx_firstname����last_name������ͨ����idx_lastname
create unique index uniq_idx_firstname on actor(first_name);
alter table actor add index idx_lastname(last_name);(sqlit��֧�����ַ�ʽ)
show index from actor;

38.���actor������ͼactor_name_view��ֻ����first_name�Լ�last_name���У���������������������first_nameΪfirst_name_v��last_name�޸�Ϊlast_name_v��
create view actor_name_view as
select first_name as first_name_v, last_name as last_name_v
from actor;

39.���salaries��emp_no�ֶδ�������idx_emp_no����ѯemp_noΪ10005, ʹ��ǿ��������
create index idx_emp_no on salaries(emp_no);
select * from salaries force index(idx_emp_no) where emp_no = '10005';(sqlite��֧��)

select * from salaries
indexed by idx_emp_no
where emp_no = '10005'

40.���actor��������last_update����������һ������Ϊcreate_date, ����Ϊdatetime, NOT NULL��Ĭ��ֵΪ'0000-00-00 00:00:00'
alter table actor add column create_date datetime not null default '0000 00:00:00' after last_update;(sqlite��֧��after,ȥ������)

CREATE TABLE employees_test(
ID INT PRIMARY KEY NOT NULL,
NAME TEXT NOT NULL,
AGE INT NOT NULL,
ADDRESS CHAR(50),
SALARY REAL
);
CREATE TABLE audit(
EMP_no INT NOT NULL,
NAME TEXT NOT NULL
);
41.����һ��������audit_log������employees_test���в���һ�����ݵ�ʱ�򣬴���������ص����ݵ�audit�С�
create trigger audit_log
after insert on employees_test
begin
	insert into audit(emp_no, name) values(new.id, new.name);
end;

mysql��Ҫ����д
delimiter $
create trigger audit_log
after insert on employees_test 
for each row
begin
	insert into audit(emp_no, name)
	values(new.id, new.name);
end $ 
delimiter ;

CREATE TABLE IF NOT EXISTS titles_test (
id int(11) not null primary key,
emp_no int(11) NOT NULL,
title varchar(50) NOT NULL,
from_date date NOT NULL,
to_date date DEFAULT NULL);
insert into titles_test values ('1', '10001', 'Senior Engineer', '1986-06-26', '9999-01-01'),
('2', '10002', 'Staff', '1996-08-03', '9999-01-01'),
('3', '10003', 'Senior Engineer', '1995-12-03', '9999-01-01'),
('4', '10004', 'Senior Engineer', '1995-12-03', '9999-01-01'),
('5', '10001', 'Senior Engineer', '1986-06-26', '9999-01-01'),
('6', '10002', 'Staff', '1996-08-03', '9999-01-01'),
('7', '10003', 'Senior Engineer', '1995-12-03', '9999-01-01');
42.���titles_test��ɾ��emp_no�ظ��ļ�¼��ֻ������С��id��Ӧ�ļ�¼��
sqlite֧�ָ÷�ʽ����mysql��֧��
delete * from t1 where t1.id in (
	select t2.id
	from titles_test t1 join titles_test t2
	on t1.emp_no = t2.emp_no and t1.id < t2.id
);
mysql������д
set SQL_SAFE_UPDATES = 0;
delete from titles_test where id in(
	select id from (
		select t2.id
		from titles_test t1 join titles_test t2
		on t1.emp_no = t2.emp_no and t1.id < t2.id
    ) a
);
set SQL_SAFE_UPDATES = 1;

43.����titles_test����to_dateΪ9999-01-01��ȫ������ΪNULL,�� from_date����Ϊ2001-01-01��(��Ŀ�пӣ������not null���ָ���Ϊnull)
update titles_test set to_date = null, from_date = '2001-01-01' where to_date = '9999-01-01'

44.��titles_test��id=5�Լ�emp_no=10001���������滻��id=5�Լ�emp_no=10005,�������ݱ��ֲ��䣬ʹ��replaceʵ�֡�
update titles_test set emp_no = replace(emp_no, '10001', '10005') where id = 5 and emp_no = '10001';

45.��titles_test�����޸�Ϊtitles_2017��
sqlite��֧��rename table titles_test to titles_2017;
alter table titles_test rename to titles_2017;

46.��audit���ϴ������Լ������emp_no��Ӧemployees_test�������id��(oj̫���壬��������һ�δ���)
drop table audit; 
CREATE TABLE audit(
    EMP_no INT NOT NULL,
    create_date datetime NOT NULL,
    FOREIGN KEY(EMP_no) REFERENCES employees_test(ID));
mysql������д
alter table audit add foreign key(emp_no) references employees_test(id);

47.�������µ���ͼ��
create view emp_v as select * from employees where emp_no >10005;
��λ�ȡemp_v��employees����ͬ�����ݣ�
select * from emp_v;

create table emp_bonus(
emp_no int not null,
recevied datetime not null,
btype smallint not null);

48.�����л�ȡ�����Ա����ǰ��нˮ����10%��
UPDATE salaries SET salary = salary * 1.1 WHERE emp_no IN
(SELECT s.emp_no FROM salaries AS s INNER JOIN emp_bonus AS eb 
ON s.emp_no = eb.emp_no AND s.to_date = '9999-01-01')
mysql��
update salaries 
join (select e.emp_no from emp_bonus e join salaries s on e.emp_no = s.emp_no and s.to_date = '9999-01-01') a
on salaries.emp_no = a.emp_no and to_date = '9999-01-01'
set salary = salary * 1.1;

49��Կ��е����б�����select count(*)��Ӧ��SQL���
sqlite��
select "select count(*) from "||name||";" as cnts from sqlite_master where type = 'table';
mysql��
select concat('select count(*) from ', table_name, ';') as cnts 
from (select table_name from information_schema.tables where table_schema = 'niuke_sql_test') a;

50.��employees���е�����Ա����last_name��first_nameͨ��(')����������'
select last_name||"'"||first_name as name from employees;

51.�����ַ���'10,A,B' �ж���','���ֵĴ���cnt��
select length("10,A,B")-length(replace("10,A,B",",","")) as cnt;

52.��ȡEmployees�е�first_name����ѯ����first_name���������ĸ�����������������
mysql��
select first_name from employees order by right(first_name, 2);
sqlite��
select first_name from employees order by substr(first_name,length(first_name)-1)

53.����dept_no���л��ܣ�����ͬһ�����ŵ�emp_no���ն��Ž������ӣ��������dept_no�Լ����ӳ��Ľ��employees
select dept_no, group_concat(emp_no) from dept_emp
group by dept_no;

54.�����ų���ǰ�����Сsalary֮���Ա����ƽ������avg_salary��(��Ŀ����)
ԭ��Ľ�Ӧ�����£�����ѡmax��min��ʱ��Ӧ�ü�������
select avg(salary) avg_salary from salaries 
where to_date = '9999-01-01' 
and salary < (select max(salary) from salaries where to_date = '9999-01-01') 
and salary > (select min(salary) from salaries where to_date = '9999-01-01');
��oj��ac������
select avg(salary) avg_salary from salaries 
where to_date = '9999-01-01' 
and salary < (select max(salary) from salaries) 
and salary > (select min(salary) from salaries);

55.��ҳ��ѯemployees��ÿ5��һҳ�����ص�2ҳ������
select * from employees limit 5,5;

56.��ȡ����Ա����emp_no�����ű��dept_no�Լ���Ӧ��bonus����btype��recevied��û�з�������Ա������ʾ
select e.emp_no, de.dept_no, eb.btype, eb.recevied
from employees e inner join dept_emp de on e.emp_no = de.emp_no left join emp_bonus eb on e.emp_no = eb.emp_no

57.ʹ�ú��йؼ���exists����δ������岿�ŵ�Ա����������Ϣ��
select * from employees where not exists(select dept_emp.emp_no from dept_emp where dept_emp.emp_no = employees.emp_no);

58.�������µ���ͼ��
create view emp_v as select * from employees where emp_no >10005;��ȡemployees�е������ݣ�����Щ��Ҳ������emp_v�С�ע�ⲻ��ʹ��intersect�ؼ��֡�
select * from emp_v;

59.��ȡ�н����Ա�������Ϣ������emp_no��first_name��last_name����������btype����Ӧ�ĵ�ǰнˮ���salary�Լ�������bonus�� bonus����btypeΪ1�佱��Ϊнˮsalary��10%��btypeΪ2�佱��Ϊнˮ��20%���������;�Ϊнˮ��30%�� ��ǰнˮ��ʾto_date='9999-01-01'
select eb.emp_no, e.first_name, e.last_name, eb.btype, s.salary, (
	case eb.btype
    when 1 then s.salary*0.1
    when 2 then s.salary*0.2
    else s.salary*0.3 end
) as bonus
from emp_bonus eb join employees e on eb.emp_no = e.emp_no
join salaries s on s.to_date = '9999-01-01' and eb.emp_no = s.emp_no;

60.����salary���ۼƺ�running_total������running_totalΪǰ����Ա����salary�ۼƺͣ������Դ����ơ� ����������Demoչʾ����
select emp_no, salary, (
	select sum(salary) from salaries s2 where to_date = '9999-01-01' and s1.emp_no >= s2.emp_no
) as running_total from salaries s1
where to_date = '9999-01-01'
order by emp_no;

61.����employees���У����������е�first_name
select e1.first_name
from employees e1
where (select count(*) from employees e2 where e1.first_name <= e2.first_name)%2=1;
