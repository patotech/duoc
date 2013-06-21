Ext.define( 'Duoc.solemne2.store.UsuarioStore', {
	requires: [
		'Duoc.solemne2.model.UsuarioModel'
	],
	extend: 'Ext.data.Store',
	storeId: 'usuarioStore',
	model: 'Duoc.solemne2.model.UsuarioModel',
	proxy: {
		type: 'ajax',
		url: 'servicios/info/usuarios',
		reader: {
            type: 'json'
        }
	},
	autoLoad: true
});