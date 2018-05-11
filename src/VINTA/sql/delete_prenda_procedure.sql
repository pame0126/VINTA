--- Delete prenda
create or replace procedure delete_prenda(ide in number)
is
begin
    delete CONTACTO where CONTACTO.CODIGO = ide;
    delete IMAGEN where IMAGEN.CODIGO = ide;
    delete PRENDA where PRENDA.ID = ide;
end delete_prenda;