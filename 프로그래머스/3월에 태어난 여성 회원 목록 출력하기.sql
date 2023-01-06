SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') from MEMBER_PROFILE where TLNO IS NOT NULL and month(DATE_OF_BIRTH) = 3 and GENDER = 'W' order by MEMBER_ID