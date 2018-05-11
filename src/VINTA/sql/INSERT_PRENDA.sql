create or replace procedure insert_prenda
( title in varchar2,
  categoria in varchar2,
  costo in varchar2,
  descrip in varchar2,
  email in varchar2,
  telefono in varchar2,
  imagenes in varchar2)
  
  is
  act_id PRENDA.ID%TYPE;
  begin
   insert into SAMANDA.PRENDA (TITULO, CATEGORIA, COSTO, DESCRIPCION) values (title, categoria, costo, descrip)
      returning id into act_id;
   insert into SAMANDA.CONTACTO (CODIGO, CORREO, TELEFONO) VALUES (act_id, email, telefono);
   
   INSERTAR_FOTOS(imagenes, act_id);
   
end insert_prenda;