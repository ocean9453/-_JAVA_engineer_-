-- drop table if exists BPI;
-- CREATE TABLE BPI (
--     id   INTEGER   NOT NULL AUTO_INCREMENT,
--     code VARCHAR(50) NOT NULL,
--     symbol VARCHAR(50) NOT NULL,
--     rate VARCHAR(50) NOT NULL,
--     description VARCHAR(50) NOT NULL,
--     rate_float VARCHAR(50) NOT NULL,
--     PRIMARY KEY (id)
-- );

-- drop table if exists UPDATETIME;
-- CREATE TABLE UPDATETIME (
--     id   INTEGER   NOT NULL AUTO_INCREMENT,
--     updated VARCHAR(50) NOT NULL,
--     updatediso VARCHAR(50) NOT NULL,
--     updateduk VARCHAR(50) NOT NULL,
--     PRIMARY KEY (id)
-- );

drop table if exists NAMECONVERT;
CREATE TABLE NAMECONVERT (
    CODE VARCHAR(50) NOT NULL,
    CNAME VARCHAR(50) NOT NULL,
    PRIMARY KEY (CODE)
);