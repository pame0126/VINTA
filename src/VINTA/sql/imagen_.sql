
  CREATE TABLE SAMANDA.IMAGEN 
   (	CODIGO NUMBER NOT NULL, 
	IMAGEN_DIR VARCHAR2(200) NOT NULL, 
	 FOREIGN KEY (CODIGO) REFERENCES SAMANDA.PRENDA (ID)
   );
