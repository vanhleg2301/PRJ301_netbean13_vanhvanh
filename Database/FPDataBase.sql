
use [FinalProject]
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[AccountID] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](50) NULL,
	[Password] [varchar](50) NULL,
	[CustomerID] [int] NULL,
	[EmployeeID] [int] NULL,
	[Role] [int] NULL,
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories] ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[Price] [int] NOT NULL,
	[CategoryName] [nvarchar](15) NOT NULL,
	[Description] [ntext] NULL,
	[Picture] [varchar](50) NULL,
	[CateID] [int] NOT NULL,
	[SellID] [int] NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers] ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerID] [int] IDENTITY(1,1) NOT NULL,
	[CompanyName] [nvarchar](40) NOT NULL,
	[Address] [nvarchar](60) NULL,
 CONSTRAINT [PK_Customers] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Departments] ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[DepartmentID] [int] IDENTITY(1,1) NOT NULL,
	[DepartmentName] [nvarchar](50) NULL,
	[DepartmentType] [nvarchar](50) NULL,
 CONSTRAINT [PK_Departments] PRIMARY KEY CLUSTERED 
(
	[DepartmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employees] ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[EmployeeID] [int] IDENTITY(1,1) NOT NULL,
	[LastName] [nvarchar](20) NOT NULL,
	[FirstName] [nvarchar](10) NOT NULL,
	[DepartmentID] [int] NULL,
	[Title] [nvarchar](30) NULL,
	[TitleOfCourtesy] [nvarchar](25) NULL,
	[BirthDate] [datetime] NULL,
	[HireDate] [datetime] NULL,
	[Address] [nvarchar](60) NULL,
 CONSTRAINT [PK_Employees] PRIMARY KEY CLUSTERED 
(
	[EmployeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([AccountID], [Email], [Password], [CustomerID], [EmployeeID], [Role]) VALUES (1, N'cust1@gmail.com', N'123', 2002, NULL, 2)
INSERT [dbo].[Account] ([AccountID], [Email], [Password], [CustomerID], [EmployeeID], [Role]) VALUES (2, N'cust2@gmail.com', N'123', 2004, NULL, 2)
INSERT [dbo].[Account] ([AccountID], [Email], [Password], [CustomerID], [EmployeeID], [Role]) VALUES (3, N'emp1@fpt.edu.vn', N'123', 2005, 5, 1)
INSERT [dbo].[Account] ([AccountID], [Email], [Password], [CustomerID], [EmployeeID], [Role]) VALUES (4, N'emp2@fpt.edu.vn', N'123', 2006, 2, 1)
SET IDENTITY_INSERT [dbo].[Account] OFF


SET IDENTITY_INSERT [dbo].[Product] ON 
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(1, 5550000, N'LG', 'nice', N'images/product-1.jpg', 01, 1)
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(2, 3505000, N'LG', 'beautiful', N'images/product-2.jpg', 02, 1)
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(3, 7006700, N'DELL', 'good', N'images/product-3.jpg', 03, 2)
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(4, 10050000, N'DELL', 'VIP', N'images/product-4.jpg', 04, 2)
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(5, 15050200, N'SAMSUNG', 'VIP', N'images/product-5.jpg', 05, 3)
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(6, 4050000, N'SAMSUNG', 'VIP', N'images/product-6.jpg', 06, 3)
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(7, 8050000, N'LG', 'VIP', N'images/product-7.jpg', 07, 1)
INSERT [dbo].[Product] ([CategoryID], [Price], [CategoryName], [Description], [Picture], [CateID], [SellID]) VALUES(8, 9045600, N'DELL', 'VIP', N'images/product-8.jpg', 08, 2)
SET IDENTITY_INSERT [dbo].[Product] OFF


SET IDENTITY_INSERT [dbo].[Customer] ON 
INSERT [dbo].[Customer] ([CustomerID], [CompanyName], [Address]) VALUES(2002, N'ABA', N'Ha Noi')
INSERT [dbo].[Customer] ([CustomerID], [CompanyName], [Address]) VALUES(2004, N'Alphabet', N'Nam Dinh')
INSERT [dbo].[Customer] ([CustomerID], [CompanyName], [Address]) VALUES(2005, N'Tesla', N'Thai Binh')
INSERT [dbo].[Customer] ([CustomerID], [CompanyName], [Address]) VALUES(2006, N'Amazom', N'Bac Ninh')
SET IDENTITY_INSERT [dbo].[Customer] OFF


SET IDENTITY_INSERT [dbo].[Department] ON 
INSERT [dbo].[Department] ([DepartmentID], [DepartmentName], [DepartmentType]) VALUES(1, N'Can Thuy', N'Thach That')
INSERT [dbo].[Department] ([DepartmentID], [DepartmentName], [DepartmentType]) VALUES(2, N'Minh Anh', N'Thanh Tri')
INSERT [dbo].[Department] ([DepartmentID], [DepartmentName], [DepartmentType]) VALUES(3, N'Tuan Nguyen', N'Ba Vi')
INSERT [dbo].[Department] ([DepartmentID], [DepartmentName], [DepartmentType]) VALUES(4, N'Mai Linh', N'Soc Son')
SET IDENTITY_INSERT [dbo].[Department] OFF


SET IDENTITY_INSERT [dbo].[Employee] ON 
INSERT [dbo].[Employee] ([EmployeeID], [LastName], [FirstName], [DepartmentID], [Title], [TitleOfCourtesy] ,[BirthDate], [HireDate], [Address]) VALUES(1, N'Kotoko', N'Iwanaga', 1, N'In Spectre', N'anime', CAST(N'2002-02-12' AS Date), CAST(N'2022-02-12' AS Date), N'Can Thuy')
INSERT [dbo].[Employee] ([EmployeeID], [LastName], [FirstName], [DepartmentID], [Title], [TitleOfCourtesy] ,[BirthDate], [HireDate], [Address]) VALUES(2, N'Takeo', N'Yamato', 2, N'My story love', N'anime', CAST(N'2003-05-16' AS Date), CAST(N'2022-05-18' AS Date), N'Minh Anh')
INSERT [dbo].[Employee] ([EmployeeID], [LastName], [FirstName], [DepartmentID], [Title], [TitleOfCourtesy] ,[BirthDate], [HireDate], [Address]) VALUES(3, N'takagi', N'mimi', 3, N'Josee', N'anime', CAST(N'2006-07-02' AS Date), CAST(N'2022-04-19' AS Date), N'Tuan Nguyen')
INSERT [dbo].[Employee] ([EmployeeID], [LastName], [FirstName], [DepartmentID], [Title], [TitleOfCourtesy] ,[BirthDate], [HireDate], [Address]) VALUES(4, N'Hana', N'Yuki', 4, N'Your Name', N'anime', CAST(N'2000-04-22' AS Date), CAST(N'2022-08-27' AS Date), N'Mai Linh')
SET IDENTITY_INSERT [dbo].[Employee] OFF