select Top 2 * from FinalProject.dbo.[Product]


select Top 2 * from FinalProject.dbo.[Product] Order By CategoryID desc

insert into FinalProject.dbo.[Account] values(N'vanh',N'vanhvanh',2002, null, 2)

SELECT [Email],[CustomerID],[EmployeeID] FROM FinalProject.dbo.[Account] where [Email] = N'cust1@gmail.com'

select Top 4 * from FinalProject.dbo.[Product]


select * from FinalProject.dbo.[Product] where [CategoryID] = '1' or [CategoryID] = '2'

select * from FinalProject.dbo.[Product] where price between 3505000 and 7006700

insert into FinalProject.dbo.[Account](Email,Password,CustomerID,EmployeeID,Role) values(N'cust4@gmail.com',N'123',2002,2012,2)

update FinalProject.dbo.[Product] SET [Price] = 3000000, [CategoryName] = N'LG', [Description] = N'nice', [Picture] = N'images/product-10.jpg', [SellID] = 2023 WHERE CateID = 4



