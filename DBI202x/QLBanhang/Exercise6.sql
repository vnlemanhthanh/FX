--1. Lấy ra các thông tin gồm Mã hoá đơn, ngày lập hoá đơn, tên khách hàng, địa chỉ khách hàng và số điện thoại.
Select H.MaHD, H.Ngay as NgayHoaDon, K.TenKH, K.DiaChi, K.DT
	From HoaDon as H
	Inner Join KhachHang as K
	On H.MaKH = K.MaKH
	Order by H.MaHD

--2. Lấy ra các thông tin gồm Mã hoá đơn, tên khách hàng, địa chỉ khách hàng và số điện thoại của ngày 25/5/2000.
SELECT H.MaHD, K.TenKH, K.DiaChi, K.DT
	FROM HoaDon as H
	INNER JOIN KhachHang as K
	ON H.MaKH = K.MaKH
	WHERE H.Ngay = DATEFROMPARTS(2000,5,25)

--3. Lấy ra các thông tin gồm Mã hoá đơn, ngày lập hoá đơn, tên khách hàng, địa chỉ khách hàng và số điện thoại
--của những hoá đơn trong tháng 6/2000.
SELECT H.MaHD, H.Ngay, K.TenKH, K.DiaChi, K.DT
	FROM HoaDon as H
	INNER JOIN KhachHang as K
	ON H.MaKH = K.MaKH
	WHERE YEAR(H.Ngay) = 2000 AND MONTH(H.Ngay) = 6

--4. Lấy ra danh sách những khách hàng (tên khách hàng, địa chỉ, số điện thoại) đã mua hàng trong tháng 6/2000.
SELECT K.TenKH, K.DiaChi, K.DT
	FROM HoaDon as H
	INNER JOIN KhachHang as K
	ON H.MaKH = K.MaKH
	WHERE YEAR(H.Ngay) = 2000 AND MONTH(H.Ngay) = 6
--5. Lấy ra danh sách các mặt hàng được bán từ ngày 1/1/2000 đến ngày 1/7/2000. 
--Thông tin gồm: mã vật tư, tên vật tư.
SELECT DISTINCT(V.MaVT), V.TenVT
	FROM HoaDon as H
		JOIN ChiTiet_HoaDon as C
			ON H.MaHD = C.MaHD
		JOIN VatTu as V
			ON C.MaVT = V.MaVT
	WHERE H.Ngay >= '20000101' AND H.Ngay < '20000702'

--6. Lấy ra danh sách các vật tư được bán từ ngày 1/1/2000 đến ngày 1/7/2000. 
--Thông tin gồm: mã vật tư, tên vật tư, tên khách  hàng đã mua, ngày mua, số lượng mua.
SELECT V.MaVT, V.TenVT,  K.TenKH, H.Ngay, C.SL
	FROM HoaDon as H
		JOIN ChiTiet_HoaDon as C
			ON H.MaHD = C.MaHD
		JOIN VatTu as V
			ON C.MaVT = V.MaVT
		JOIN KhachHang as K
			ON K.MaKH = H.MaKH
	WHERE H.Ngay >= '20000101' AND H.Ngay < '20000702'

--7. Lấy ra danh sách các vật tư được mua bởi những khách hàng ở Tân Bình, trong năm 2000. 
--Thông tin lấy ra gồm: mã vật tư, tên vật tư, tên khách hàng, ngày mua, số lượng mua.
 SELECT V.MaVT, V.TenVT,  K.TenKH, H.Ngay, C.SL
	FROM HoaDon as H
		JOIN ChiTiet_HoaDon as C
			ON H.MaHD = C.MaHD
		JOIN VatTu as V
			ON C.MaVT = V.MaVT
		JOIN KhachHang as K
			ON K.MaKH = H.MaKH
	WHERE YEAR(H.Ngay) = 2000 AND K.DiaChi = 'TAN BINH'

--8. Lấy ra danh sách các vật tư được mua bởi những khách hàng ở Tân Bình, trong năm 2000. 
--Thông tin lấy ra gồm: mã vật tư, tên vật tư.
 SELECT DISTINCT V.MaVT, V.TenVT
	FROM HoaDon as H
		JOIN ChiTiet_HoaDon as C
			ON H.MaHD = C.MaHD
		JOIN VatTu as V
			ON C.MaVT = V.MaVT
		JOIN KhachHang as K
			ON K.MaKH = H.MaKH
	WHERE YEAR(H.Ngay) = 2000 AND K.DiaChi = 'TAN BINH'

--9. Lấy ra danh sách những khách hàng không mua hàng trong tháng 6/2000 gồm 
--các thông tin tên khách hàng, địa chỉ, số điện thoại.
SELECT DISTINCT K.TenKH, K.DiaChi, K.DT
	FROM HoaDon as H
	JOIN KhachHang as K
	ON H.MaKH = K.MaKH
	WHERE NOT (YEAR(H.Ngay) = 2000 AND MONTH(H.Ngay) = 6)