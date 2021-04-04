-- 계정권한 부여
	grant all
	on native_jdbc.* 
	to 'user_native_jdbc'@'localhost' identified by 'rootroot';

CREATE database native_jdbc;
use native_jdbc;

-- file (backup, load)권한 --root만 권한 부여가능
	grant File
	on *.*
	to 'user_native_jdbc'@'localhost';
	

