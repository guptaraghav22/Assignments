--Exercise 2
use AdventureWorks2008R2;
--using join
select  Sales.Customer.CustomerID from Sales.Customer LEFT JOIN Sales.SalesOrderHeader  on 
Sales.Customer.CustomerID =Sales.SalesOrderHeader.CustomerID where SalesOrderID is null ;
--using subquery
select CustomerID from Sales.Customer  Where CustomerID Not in (Select CustomerID from Sales.SalesOrderHeader);
--Using CTE
WITH Acount_Number(AccountNumber, customerID)
AS (SELECT AccountNumber, CustomerID FROM   Sales.SalesOrderHeader)
    SELECT s.CustomerID 
   FROM    Sales.Customer AS s LEFT OUTER JOIN
                Acount_Number AS h ON s.CustomerID = h.customerID 
   WHERE (h.AccountNumber IS NULL) ORDER BY customerID;
--using Exist
Select CustomerID from Sales.Customer cobj 
where not exists(Select * from Sales.SalesOrderHeader sobj where cobj.CustomerID=sobj.CustomerID);