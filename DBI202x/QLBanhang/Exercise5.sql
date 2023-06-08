USE [QLBanhang]
GO
--1. Hiển danh sách tất cả các khách hàng gồm mã khách hàng, tên khách hàng, địa chỉ, điện thoại, và địa chỉ E-mail.
SELECT *
FROM [KhachHang]
GO
--2. Hiển danh sách các khách hàng có địa chỉ là “TAN BINH” gồm mã khách hàng, tên khách hàng, địa chỉ, điện thoại, và địa chỉ E-mail.
--Sắp xếp theo mã khách hàng.
SELECT *
FROM KhachHang
WHERE DiaChi = N'TAN BINH'
ORDER BY MaKH ASC
GO
--3. Hiển danh sách các khách hàng đã có số điện thoại và địa chỉ E-mail gồm mã khách hàng, tên khách hàng,
--địa chỉ, điện thoại,và địa chỉ E-mail.
SELECT *
FROM KhachHang
WHERE DT IS NOT NULL AND DT != ''
	AND Email IS NOT NULL AND Email != ''
GO
--4. Hiển danh sách tất cả các vật tư gồm mã vật tư, tên vật tư, đơn vị tính và giá mua.
SELECT MaVT, TenVT, DVT, GiaMua
FROM VatTu
GO
--5. Hiển danh sách các vật tư gồm mã vật tư, tên vật tư, đơn vị tính và giá mua mà có giá mua
--nằm trong khoảng từ 20000 đến 40000. Sắp xếp theo giá mua từ lớn xuống bé.
SELECT MaVT, TenVT, DVT, GiaMua
FROM VatTu
WHERE GiaMua BETWEEN 20000 AND 40000
ORDER BY GiaMua ASC
GO
--6. Hiển danh sách các vật tư là “GẠCH” (bao gồm các loại gạch) gồm mã vật tư, tên vật tư, đơn vị tính và giá mua.
SELECT MaVT, TenVT, DVT, GiaMua
FROM VatTu
WHERE TenVT LIKE N'%GACH%'
GO
--7. Hiển thị số lượng vật tư có trong CSDL
SELECT COUNT(*) AS N'Số loại vật tư'
FROM VatTu
GO
--8. Hiển thị cho biết mỗi hóa đơn đã mua bao nhiêu loại vật tư. 
--Thông tin lấy về gồm: Mã hóa đơn, số loại vật tư trong hóa đơn này.
SELECT MaHD, COUNT(MaVT) AS 'Số loại vật tư'
FROM ChiTiet_HoaDon
GROUP BY MaHD
GO
--9. Hiển thị cho biết tổng tiền của mỗi hóa đơn. Thông tin lấy về gồm: mã hóa đơn, tổng tiền của hóa đơn
--(biết rằng tổng tiền của 1 hóa đơn là tổng tiền của các vật tư trong hóa đơn đó).
SELECT MaHD, SUM(SL * GiaBan) AS TongTien
FROM ChiTiet_HoaDon
GROUP BY MaHD
GO
--10. Hiển thị cho biết mỗi khách hàng đã mua bao nhiêu hóa đơn. Thông tin lấy về gồm: Mã khách hàng,
--số lượng hóa đơn khách hàng này đã mua.
SELECT MaKH, COUNT(MaHD) As SoLuongHoaDon
FROM HoaDon
GROUP BY MaKH
GO