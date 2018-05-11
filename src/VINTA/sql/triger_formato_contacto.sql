create or replace TRIGGER FORMATO_INSERT_CONTACTO 
BEFORE INSERT OR UPDATE ON CONTACTO 
FOR EACH ROW
BEGIN
  --- telefono
  if (:new.telefono is not null) then
      :new.telefono := trim(:new.telefono);
      if( length(:new.telefono) = 8 ) then
          --- 
          :new.telefono := '(506)'||substr(:new.telefono,1,4)||'-'||substr(:new.telefono,5,8);
      else if ( length(:new.telefono) = 9 ) then
          :new.telefono := '(506)'||substr(:new.telefono,1,4)||'-'||substr(:new.telefono,6,9);
      --- sobrepasa el largo de capacidad de la BD
      else if (length(:new.telefono) > 14) then
          :new.telefono := null;
      else 
         NULL;
      end if; 
      end if;
      end if;
  end if;
  
  ---correo
   if (:new.correo is null) then
        NULL;
   else 
        :new.correo := trim(:new.correo);
            --- Si esta con el formato aceptable de correo se ingresa
            
        if ( REGEXP_LIKE(:new.correo, '([a-zA-Z0-9._])+(@[a-z]+[.com|.es])') ) then
             NULL;
        else
            :new.correo := null;
        end if;
  end if;
END FORMATO_INSERT_CONTACTO;