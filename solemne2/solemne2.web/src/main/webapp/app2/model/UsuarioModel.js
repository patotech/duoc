Ext.define('Duoc.solemne2.model.UsuarioModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'rut', type: 'int'},
        {name: 'nombre', type: 'string'},
        {name: 'apellido_pat', type: 'string'},
        {name: 'apellido_mat', type: 'string'},
        {name: 'nombre_completo', type: 'string',
        	convert: function( newValue, model ) {
        		return model.get('nombre') + ' ' + model.get('apellido_pat') + ' ' + model.get('apellido_mat');
        	}
        }
    ]
});