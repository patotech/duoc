Ext.define( 'Duoc.solemne2.store.PlataformaStore', {
	requires: [
		'Duoc.solemne2.model.PlataformaModel'
	],
	extend: "Ext.data.Store",
	storeId: 'plataformaStore',
	model: "Duoc.solemne2.model.PlataformaModel",
	proxy: {
		type: 'ajax',
		url: 'servicios/info/plataformas',
		reader: {
            type: 'json'
        }
	},
	autoLoad: true
});