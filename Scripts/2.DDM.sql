-- 직책
CREATE TABLE title (
	tno   INT         NOT NULL COMMENT '직책코드', -- 직책코드
	tname VARCHAR(20) NOT NULL COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE title
	ADD CONSTRAINT PK_title -- 직책 기본키
		PRIMARY KEY (
			tno -- 직책코드
		);

-- 부서
CREATE TABLE department (
	deptNO   INT         NOT NULL COMMENT '부서번호', -- 부서번호
	deptName VARCHAR(20) NOT NULL COMMENT '부서명', -- 부서명
	floor    INT         NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE department
	ADD CONSTRAINT PK_department -- 부서 기본키
		PRIMARY KEY (
			deptNO -- 부서번호
		);

-- 사원
CREATE TABLE employee (
	empNo   INT         NOT NULL COMMENT '사원번호', -- 사원번호
	empName VARCHAR(20) NOT NULL COMMENT '사원명', -- 사원명
	title   INT         NULL     COMMENT '직책', -- 직책
	manager INT         NULL     COMMENT '직속상사', -- 직속상사
	salary  INT         NULL     COMMENT '급여', -- 급여
	dept    INT         NULL     COMMENT '부서' -- 부서
)
COMMENT '사원';

-- 사원
ALTER table employee
	ADD CONSTRAINT PK_employee -- 사원 기본키
		PRIMARY KEY (
			empNo -- 사원번호
		);

-- 사원
ALTER TABLE employee
	ADD CONSTRAINT FK_title_TO_employee -- 직책 -> 사원
		FOREIGN KEY (
			title -- 직책
		)
		REFERENCES erp.title ( -- 직책
			tno -- 직책코드
		);

-- 사원
ALTER TABLE employee
	ADD CONSTRAINT FK_employee_TO_employee -- 사원 -> 사원
		FOREIGN KEY (
			manager -- 직속상사
		)
		REFERENCES erp.employee ( -- 사원
			empNo -- 사원번호
		);

-- 사원
ALTER TABLE employee
	ADD CONSTRAINT FK_department_TO_employee -- 부서 -> 사원
		FOREIGN KEY (
			dept -- 부서
		)
		REFERENCES erp.department ( -- 부서
			deptNO -- 부서번호
		);