CREATE TABLE Faculities
(
	Id INT PRIMARY KEY,
	Address VARCHAR(200),
	PhoneNumber VARCHAR(100),
	UpdateDate INT,
	CreateDate INT,
	Emai VARCHAR(200)
);

CREATE TABLE Accounts
(
	Id INT PRIMARY KEY,
	Username VARCHAR(100),
	Password VARCHAR(200),
	FullName VARCHAR(200),
	Email VARCHAR(200),
	FaculityId INT,
	UpdateDate INT,
	CreateDate INT,
	IsActive BOOLEAN
);

CREATE TABLE Semesters
(
	Id INT PRIMARY KEY,
	SemesterNumber INT, /* 1,2,3,4,0 - kỳ 1,2,3 hè*/
	SemesterName VARCHAR(200),
	Years INT,
	StartDate INT,
	EndDate INT,
	UpdateDate INT,
	CreateDate INT
);

CREATE TABLE Classes
(
	Id INT PRIMARY KEY,
	ClassName VARCHAR(200),
	TeacherName VARCHAR(200),
	StartDate INT,
	EndDate INT,
	Description VARCHAR(500),
	ImageUrl VARCHAR(200),
	MaxNumber INT,
	SemesterId INT,
	FaculityId INT,
	UpdateDate INT,
	CreateDate INT,
	IsActive BOOLEAN
);

CREATE TABLE Students
(
	Id INT PRIMARY KEY,
	FirstName VARCHAR(100),
	LastName VARCHAR(100),
	FaculityId INT,
	UpdateDate INT,
	CreateDate INT,
	IsActive INT(1)
);

CREATE TABLE Student_Classes
(
	Id INT PRIMARY KEY,
	StudentId INT,
	ClassId INT,
	StartDate INT,
	UpdateDate INT,
	CreateDate INT,
	IsStart INT(1)
);

/* Tiền đặt chỗ âm còn lại là > 0 */
CREATE TABLE Costs
(
	Id INT PRIMARY KEY,
	Name VARCHAR(200),
	SemesterId INT,
	Amount DOUBLE,
	FaculityId INT,
	NumberDay INT,
	UpdateDate INT,
	CreateDate INT
);

CREATE TABLE Student_Costs
(
	Id INT PRIMARY KEY,
	CostId INT,
	StudentId INT,
	NumberApprove INT,
	AmountToPay DOUBLE,
	AmountPaid DOUBLE,
	UpdateDate INT,
	CreateDate INT,
	IsDebt BOOLEAN
);

CREATE TABLE ReduceFees
(
	Id INT PRIMARY KEY
	Percent FLOAT,
	StudentId INT,
	Reason VARCHAR(200),
	UpdateDate INT,
	CreateDate INT
);

CREATE TABLE Receipts
(
	Id INT PRIMARY KEY,
	No INT,
	StudentId INT,
	CreateDate INT,
	Payer VARCHAR(200),
	Casher VARCHAR(200),
	Inwords VARCHAR(500),
	IsRetun BOOLEAN,
	UpdateDate INT,
	CreateDate INT
);

CREATE TABLE Receipt_details
(
	Id INT PRIMARY KEY,
	AmountPaid DOUBLE,
	Description VARCHAR(500),
	UpdateDate INT,
	CreateDate INT
);

CREATE TABLE Leaves
(
	Id INT PRIMARY KEY,
	StudentId INT,
	StartDate INT,
	EndDate INT,
	Reason VARCHAR(200),
	UpdateDate INT,
	CreateDate INT,
	IsLeave BOOLEAN
);


