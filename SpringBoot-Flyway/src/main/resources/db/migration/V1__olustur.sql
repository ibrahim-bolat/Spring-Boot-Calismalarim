CREATE SEQUENCE seq_kisi start 1 increment 1;

CREATE TABLE kisi (
   id int NOT NULL default nextval('seq_kisi'),
   ad varchar(100) NOT NULL,
   soyad varchar(50) NOT NULL,
   maas int DEFAULT NULL,
   dogum_tarihi date DEFAULT NULL,
   PRIMARY KEY (id)
);
