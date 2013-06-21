Ext.define('Desktop.App', {
    extend: 'Ext.container.Viewport',
    requires: [ 'Duoc.solemne2.GridAplicaciones',
                'Duoc.solemne2.model.AplicacionesModel',
                'Duoc.solemne2.store.LenguajeStore',
                'Duoc.solemne2.store.PlataformaStore',
                'Duoc.solemne2.store.SistemaStore' ],    
    layout: 'border',
    items: [{
        region: 'north',
        html: '<h1 class="x-panel-header">Gestión de Aplicaciones</h1>',
        border: false,
        margins: '0 0 5 0'
    }, {
        region: 'center',
        xtype: 'solemne2'
    }]
});