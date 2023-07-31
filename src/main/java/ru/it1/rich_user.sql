SELECT person.name, SUM(payments.value)
FROM person
  INNER JOIN payments ON person.id = payments.persons_id
GROUP BY person.name
HAVING SUM(payments.value) > 20;

-- Даны две таблицы :
-- Persons со списком работников
-- Id	Name
-- 1	Petya
-- 2	Vasya
-- 3	Kolya
--
-- Payments с зарплатными начислениями ежемесячно.
--
-- Id	Persons_id	Value
-- 1		1	 	        10
-- 2		1	        	20
-- 3		3	        	15
--
-- выбрать сотрудников у которых общий размер начислений превышает 20