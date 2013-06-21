Ext.define('Duoc.solemne2.model.AplicacionesModel', {
    extend: 'Ext.data.Model',
    fields: [
        // the 'name' below matches the tag name to read, except 'availDate'
        // which is mapped to the tag 'availability'
        {name: 'idAplicacion', type: 'int'},
        {name: 'descripcion', type: 'string'},
        {name: 'idSistema', type: 'int'},
        {name: 'idDetalle', type: 'int'},
        {name: 'idLenguaje', type: 'int'},
        {name: 'idPlataforma', type: 'int'},
        {name: 'descripcionDetalle', type: 'string'},
        {name: 'especialista', type: 'int'},
        {name: 'dueno', type: 'int'},
        {name: 'baseDatos', type: 'string'},
        {name: 'estado', type: 'string'},
        {name: 'id', type:'string'}
    ],
    idProperty: 'id'
});