--- update prenda
create or replace procedure update_prenda
( ident in PRENDA.ID%TYPE,
  title in varchar2,
  categ in varchar2,
  precio in varchar2,
  descrip in varchar2,
  email in varchar2,
  telf in varchar2,
  imgs in varchar2)
  
is
fotos varchar2(1000);
foto varchar2(200);
begin
   --- update Prenda
    UPDATE PRENDA SET TITULO = title, CATEGORIA = categ, COSTO = precio, DESCRIPCION = descrip WHERE ID = ident;
    
    -- update contacto
    if(email is null) then
        UPDATE CONTACTO SET TELEFONO = telf WHERE CODIGO = ident;
    else
         UPDATE CONTACTO SET CORREO = email, TELEFONO = telf WHERE CODIGO = ident;
    end if;
    
    -- update de las imagenes
    delete IMAGEN where codigo = ident;
     if(imgs is null) THEN
        dbms_output.put_line('Problema del null con la imagen') ;
    else
       fotos:= trim(imgs);
        if ( instr(fotos,',') = 0) then
            insert into SAMANDA.IMAGEN (CODIGO, IMAGEN_DIR) VALUES (ident, fotos);
        else
          for item in (select regexp_substr(imgs,'[^,]+', 1, level) as str from dual
                      connect by regexp_substr(imgs, '[^,]+', 1, level) is not null)
            loop
                insert into SAMANDA.IMAGEN (CODIGO, IMAGEN_DIR) VALUES (ident, item.str);
            end loop;
        end if;
    end if;
    
end update_prenda;