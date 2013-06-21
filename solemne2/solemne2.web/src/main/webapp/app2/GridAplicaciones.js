Ext.define('Duoc.solemne2.GridAplicaciones', {
    extend: 'Ext.grid.Panel',
    
    requires: [
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*',
        'Duoc.solemne2.model.AplicacionesModel',
        'Duoc.solemne2.store.LenguajeStore',
        'Duoc.solemne2.store.PlataformaStore',
        'Duoc.solemne2.store.SistemaStore'
    ],
    xtype: 'solemne2',
    
    
    title: 'Editar Aplicaciones',
    frame: true,
    
    initComponent: function() {
        this.cellEditing = new Ext.grid.plugin.CellEditing({
            clicksToEdit: 1
        });
        
        var lenguajes = Ext.StoreManager.lookup('lenguajeStore');
        var plataformas = Ext.StoreManager.lookup('plataformaStore');
        var sistemas = Ext.StoreManager.lookup('sistemaStore');
        var usuarios = Ext.StoreManager.lookup('usuarioStore');
        
        Ext.apply(this, {
            width: 680,
            height: 350,
            plugins: [this.cellEditing],
            store: new Ext.data.Store({
                autoDestroy: true,
                model: Duoc.solemne2.model.AplicacionesModel,
                proxy: {
                    type: 'ajax',
                    //url: 'servicios/aplicaciones/listado',
                    api: {
                        read: 'servicios/aplicaciones/listado',
                        create: 'servicios/aplicaciones/grabar',
                        update: 'servicios/aplicaciones/grabar',
                        destroy: 'servicios/aplicaciones/borrar'
                    },
                    reader: {
                        type: 'json'
                    },
                    writer: {
                        type:'json',
                        writeAllFields: true,
                        allowSingle: false
                    }
                },
                sorters: [{
                    property: 'descripcion',
                    direction:'ASC'
                }]
            }),
            columns: [{
                header: 'Descripcion',
                dataIndex: 'descripcion',
                flex: 1,
                editor: {
                    allowBlank: false
                }
            }, {
                header: 'Sistema',
                dataIndex: 'idSistema',
                width: 130,
                editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    store: sistemas,
                    valueField : 'id_sistema',
                    displayField: 'descripcion'
                }),
				renderer : function(val) {
					var rs = val;
					var index = sistemas.findExact('id_sistema', val);
					if (index != -1) {
						rs = sistemas.getAt(index).data.descripcion;
					}
					return rs;
				}
            }, {
                header: 'Lenguaje',
                dataIndex: 'idLenguaje',
                width: 130,
                editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    store: lenguajes,
                    valueField : 'id_lenguaje',
                    displayField: 'descripcion'
                }),
				renderer : function(val) {
					var rs = val;
					var index = lenguajes.findExact('id_lenguaje', val);
					if (index != -1) {
						rs = lenguajes.getAt(index).data.descripcion;
					}
					return rs;
				}
            }, {
                header: 'Plataforma',
                dataIndex: 'idPlataforma',
                width: 130,
                editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    store: plataformas,
                    valueField : 'id_plataforma',
                    displayField: 'descripcion'
                }),
				renderer : function(val) {
					var rs = val;
					var index = plataformas.findExact('id_plataforma', val);
					if (index != -1) {
						rs = plataformas.getAt(index).data.descripcion;
					}
					return rs;
				}
            }, {
                header: 'Detalle Ejecutable',
                dataIndex: 'descripcionDetalle',
                flex: 1,
                editor: {
                    allowBlank: false
                }
            }, {
                header: 'Especialista',
                dataIndex: 'especialista',
                width: 200,
                editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    store: usuarios,
                    valueField : 'rut',
                    displayField: 'nombre_completo'
                }),
				renderer : function(val) {
					var rs = val;
					var index = usuarios.findExact('rut', val);
					if (index != -1) {
						rs = usuarios.getAt(index).data.nombre_completo;
					}
					return rs;
				}           
            }, {
                header: 'Dueño',
                dataIndex: 'dueno',
                width: 200,
                editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    store: usuarios,
                    valueField : 'rut',
                    displayField: 'nombre_completo'
                }),
				renderer : function(val) {
					var rs = val;
					var index = usuarios.findExact('rut', val);
					if (index != -1) {
						rs = usuarios.getAt(index).data.nombre_completo;
					}
					return rs;
				}                
            }, {
                header: 'Base de Datos?',
                dataIndex: 'baseDatos',
                width: 130,
                editor: new Ext.form.field.ComboBox({
                    typeAhead: true,
                    triggerAction: 'all',
                    store: [
                        ['S','Si'],
                        ['N','No']
                    ]
                }),
				renderer : function(val) {
					if( val == "S" )
						return "Si";
					else
						return "No";
				}
            }, {
                xtype: 'actioncolumn',
                width: 30,
                sortable: false,
                menuDisabled: true,
                items: [{
                    icon: 'app2/icons/delete.gif',
                    tooltip: 'Borrar Aplicacion',
                    scope: this,
                    handler: this.onRemoveClick
                }]
            }],
            selModel: {
                selType: 'cellmodel'
            },
            tbar: [{
                text: 'Agregar Aplicación',
                scope: this,
                handler: this.onAddClick
            },{
                text: 'Grabar Cambios',
                scope: this,
                handler: this.onSync
            }]
        });
        
        this.callParent();
        
        this.on('afterlayout', this.loadStore, this, {
            delay: 1,
            single: true
        });
    },
    
    loadStore: function() {
        this.getStore().load({
            callback: this.onStoreLoad
        });
    },
    
    onSync: function() {
    	this.getStore().sync({
    		callback: function() {
    			Ext.Msg.alert('Estatus', 'Los cambios fueron almacenados.');
    		}
    	});
    },
    
    onStoreLoad: function(){
    	Ext.Msg.hide();
    },
    
    onAddClick: function(){
        // Create a model instance
        var rec = new Duoc.solemne2.model.AplicacionesModel();
        
        this.getStore().insert(0, rec);
        this.cellEditing.startEditByPosition({
            row: 0, 
            column: 0
        });
    },
    
    onRemoveClick: function(grid, rowIndex){
        this.getStore().removeAt(rowIndex);
    }
});