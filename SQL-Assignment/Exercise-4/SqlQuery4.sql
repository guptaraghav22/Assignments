use AdventureWorks2008R2;
Go
CREATE FUNCTION Sales.getProducts(@SalesOrderID int, @CurrencyCode nchar(3) ,@CurrencyRateDate datetime)
RETURNS TABLE
AS
RETURN
WITH Products
AS (
              SELECT *
              FROM Sales.SalesOrderDetail AS sod
              WHERE sod.SalesOrderID = @SalesOrderID
       )
       SELECT p.ProductID, p.OrderQty, p.UnitPrice, p.UnitPrice*scr.EndOfDayRate AS 'Converted Price'
       FROM Products AS p, Sales.CurrencyRate AS scr
       WHERE scr.ToCurrencyCode = @CurrencyCode
              AND scr.CurrencyRateDate = @CurrencyRateDate
			  GO
			select * from Sales.getProducts(43668, 'MXN', '2005-09-05 00:00:00.000');
		