
USE QuanLyQuanCafeFinal
GO

-- Ban (id, ten ban, ghi chu)
-- Tai khoan (username, pass, type)
-- Menu (id, ten, gia)
-- Hoa don (id, Ban.id)
-- CT hoa don (HoaDon.id, Menu.Ten, SoLuong, Menu.Gia)


CREATE TABLE Ban
(
	id INT IDENTITY PRIMARY KEY,
	TenBan NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên',
	GhiChu NVARCHAR(100) -- Trống || Có người
)
GO

CREATE TABLE TaiKhoan
(
	UserName NVARCHAR(100) PRIMARY KEY,
	Password NVARCHAR(1000) NOT NULL, -- Cần mã hóa nên dùng 1000
	Type INT NOT NULL DEFAULT 1 -- 0: admin, 1: staff
)
GO

CREATE TABLE Menu
(
	id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên',
	Gia FLOAT NOT NULL
)
GO

CREATE TABLE HoaDon
(
	id INT IDENTITY PRIMARY KEY,
	idBan INT NOT NULL,

	FOREIGN KEY (idBan) REFERENCES dbo.Ban(id)
)
GO

CREATE TABLE CT_HoaDon
(
	idHoaDon INT NOT NULL,
	idMenu INT NOT NULL,
	SoLuong INT NOT NULL DEFAULT 0

	FOREIGN KEY (idHoaDon) REFERENCES dbo.HoaDon(id),
	FOREIGN KEY (idMenu) REFERENCES dbo.Menu(id)
)
GO