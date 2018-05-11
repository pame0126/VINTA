--- procedimiento llamado desde INSERTAR_PRENDA
create or replace procedure insertar_fotos(imgs in varchar2 , id in number)
as
fotos varchar2(1000);
foto varchar2(200);
begin
  
    if(imgs is null) THEN
        dbms_output.put_line('Problema del null con la imagen') ;
    else
       fotos:= trim(imgs);
        if ( instr(fotos,',') = 0) then
            insert into SAMANDA.IMAGEN (CODIGO, IMAGEN_DIR) VALUES (id, fotos);
        else
          for item in (select regexp_substr(imgs,'[^,]+', 1, level) as str from dual
                      connect by regexp_substr(imgs, '[^,]+', 1, level) is not null)
            loop
                insert into SAMANDA.IMAGEN (CODIGO, IMAGEN_DIR) VALUES (id, item.str);
            end loop;
        end if;
    end if;
end insertar_fotos;