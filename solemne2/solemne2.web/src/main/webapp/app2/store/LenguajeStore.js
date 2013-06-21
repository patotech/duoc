Ext.define( 'Duoc.solemne2.store.LenguajeStore', {
	requires: [
		'Duoc.solemne2.model.LenguajeModel'
	],
	extend: "Ext.data.Store",
	storeId: 'lenguajeStore',
	model: "Duoc.solemne2.model.LenguajeModel",
	proxy: {
		type: 'ajax',
		url: 'servicios/info/lenguajes',
		reader: {
            type: 'json'
        }
	},
	autoLoad: true
});