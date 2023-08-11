use AdventureWorks2008R2;
--Exercise 1
--1
Select count(*) from Sales.SalesPerson;
---2
Select FirstName,LastName from Person.Person Where FirstName LIKE'b%';
---3
Select FirstName,LastName from Person.Person where BusinessEntityID in (Select BusinessEntityID from HumanResources.Employee where JobTitle 
in('Design Engineer','Tool Designer','Marketing Assistant'));
--4
Select Name,Color,Weight From Production.Product where Weight=(Select MAX(Weight) from Production.Product);
--5
select Description,ISNULL(MaxQty,0.00) as MaxQty from Sales.SpecialOffer;
--6
Select * from sales.CurrencyRate 
where FromCurrencyCode='USD' and ToCurrencyCode='GBP' and  YEAR(CurrencyRateDate)='2005';
--7
Select ROW_NUMBER() Over(Order By FirstName) as Number ,FirstName,LastName from Person.Person where Firstname like '%ss%';
--8
Select BusinessEntityID,CommissionPct,
IIF(CommissionPct=0,'BAND 0',IIF(CommissionPct<=0.01,'BAND 1',IIF(CommissionPct<=0.015,'BAND 2',IIF(CommissionPct>0.015,'BAND 3',''))))
from Sales.SalesPerson;
----9
Exec dbo.uspGetEmployeeManagers @BusinessEntityID =48;
  --10
  Select * from Production.ProductInventory where Quantity = (Select MAX(Quantity) from Production.ProductInventory);
  Exec dbo.ufnGetStock @ProductID = 528;
