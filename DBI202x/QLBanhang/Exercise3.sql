USE master
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'QLBanhang') 
--IF EXISTS (SELECT * FROM sys.sysdatabases WHERE name = 'QLBanhang') 
BEGIN
    DROP DATABASE QLBanhang
    PRINT 'DROP DATABASE QLBanhang'
END
    CREATE DATABASE QLBanhang
    PRINT 'CREATE DATABASE QLBanhang'
GO

USE QLBanhang
GO

DROP TABLE KhachHang; 
CREATE TABLE KhachHang (
	MaKH nvarchar(5),
	TenKH nvarchar (30),
	DiaChi nvarchar(300),
	DT varchar(10),
	Email varchar(30)
	);
GO

DROP TABLE VatTu;
CREATE TABLE VatTu (
	MaVT nvarchar(5),
	TenVT nvarchar(30),
	DVT nvarchar(20),
	GiaMua money,
	SLTon int
	);
GO

DROP TABLE HoaDon;
CREATE TABLE HoaDon (
	MaHD nvarchar(10),
	Ngay datetime,
	MaKH nvarchar(5),
	TongTG money,
	);
GO

DROP TABLE ChiTiet_HoaDon;
CREATE TABLE ChiTiet_HoaDon (
	MaHD nvarchar(10),
	MaVT nvarchar(5),
	SL int,
	GiaBan money
	);
GO