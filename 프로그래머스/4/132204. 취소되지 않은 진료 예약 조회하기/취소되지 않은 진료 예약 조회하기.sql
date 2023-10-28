-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, d.MCDP_CD, d.dr_name, a.APNT_YMD 
from patient p
    inner join appointment a
    on p.pt_no = a.pt_no
        inner join doctor d
        on a.mddr_id = d.dr_id
where to_char(a.apnt_ymd, 'yyyy-mm-dd') = '2022-04-13' and a.apnt_cncl_yn = 'N' and a.mcdp_cd = 'CS'
order by a.APNT_YMD asc;