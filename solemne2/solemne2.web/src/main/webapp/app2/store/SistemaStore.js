Ext.define( 'Duoc.solemne2.store.SistemaStore', {
	requires: [
		'Duoc.solemne2.model.SistemaModel'
	],
	extend: "Ext.data.Store",
	storeId: 'sistemaStore',
	model: "Duoc.solemne2.model.SistemaModel",
	proxy: {
		type: 'ajax',
		url: 'servicios/info/sistemas',
		reader: {
            type: 'json'
        }
	},
	autoLoad: true
});