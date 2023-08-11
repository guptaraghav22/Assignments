
CREATE TRIGGER NewProcedure
ON Production.Product
AFTER UPDATE
AS
BEGIN
       
       IF UPDATE(ListPrice)
              BEGIN
                      UPDATE Production.Product
                      SET ListPrice = IIF((i.ListPrice - d.ListPrice) > d.ListPrice*0.15, d.ListPrice, i.ListPrice)
                      FROM deleted AS d, Production.Product AS p
                      INNER JOIN inserted AS i ON i.ProductID = p.ProductID
              END
END
UPDATE Production.Product SET  ListPrice=163  where ProductID=813;
select * from Production.Product where ProductID=813;