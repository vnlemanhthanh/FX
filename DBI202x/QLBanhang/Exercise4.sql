USE QLBanhang;

ALTER TABLE KhachHang
ALTER COLUMN MaKH nvarchar(5) NOT NULL;

ALTER TABLE KhachHang
ADD CONSTRAINT PK_KH
PRIMARY KEY (MaKH);

ALTER TABLE VatTu
ALTER COLUMN MaVT nvarchar(5) NOT NULL;

ALTER TABLE VatTu
ADD CONSTRAINT PK_VT
PRIMARY KEY (MaVT);

ALTER TABLE HoaDon
ALTER COLUMN MaHD nvarchar(10) NOT NULL;

ALTER TABLE HoaDon
ADD CONSTRAINT PK_HD
PRIMARY KEY (MaHD);

ALTER TABLE ChiTiet_HoaDon
ALTER COLUMN MaHD nvarchar(10) NOT NULL;

ALTER TABLE ChiTiet_HoaDon
ALTER COLUMN MaVT nvarchar(5) NOT NULL;

AlTER TABLE ChiTiet_HoaDon
ADD CONSTRAINT PK_CTHD
PRIMARY KEY (MaHD, MaVT);

ALTER TABLE KhachHang
ALTER COLUMN TenKH nvarchar(30) NOT NULL;

ALTER TABLE KhachHang
ALTER COLUMN DT varchar(8);  

ALTER TABLE VatTu
ALTER COLUMN TenVT nvarchar(30) NOT NULL;

ALTER TABLE VatTu
ADD CONSTRAINT Chk_GiaMua CHECK (GiaMua > 0);

ALTER TABLE VatTu
ADD CONSTRAINT Chk_SLTon CHECK (SLTon >= 0);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_KH
FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH);

ALTER TABLE ChiTiet_HoaDon
ADD CONSTRAINT Df_SL 
DEFAULT 1 FOR SL;

ALTER TABLE ChiTiet_HoaDon
ADD CONSTRAINT Chk_SL
CHECK (SL > 0);

ALTER TABLE ChiTiet_HoaDon
ADD CONSTRAINT FK_HD
FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD);

ALTER TABLE ChiTiet_HoaDon
ADD CONSTRAINT FK_VT
FOREIGN KEY (MaVT) REFERENCES VatTu(MaVT);
