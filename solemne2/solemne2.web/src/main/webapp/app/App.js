Ext.define('Desktop.App', {
    extend: 'Duoc.solemne2.desktop.App',
    
    requires: [
               'Ext.window.MessageBox',
               'Duoc.solemne2.desktop.ShortcutModel',
               'Desktop.GridWindow',
               'Desktop.Settings'
    ],
           
    init: function() {
    	// custom logic before getXYZ methods get called...
    	this.callParent();
        // now ready...
    },

    getModules : function(){
        return [
            new Desktop.GridWindow()
        ];
    },
    
    getTaskbarConfig: function () {
        var ret = this.callParent();

        return Ext.apply(ret, {
            quickStart: [
                { name: 'Accordion Window', iconCls: 'accordion', module: 'acc-win' },
                { name: 'Grid Window', iconCls: 'icon-grid', module: 'grid-win' }
            ],
            trayItems: [
                { xtype: 'trayclock', flex: 1 }
            ]
        });
    },    

    getDesktopConfig: function () {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            //cls: 'ux-desktop-black',

            contextMenuItems: [
                { text: 'Cambiar Configuración', handler: me.onSettings, scope: me }
            ],

            shortcuts: Ext.create('Ext.data.Store', {
                model: 'Duoc.solemne2.desktop.ShortcutModel',
                data: [
                    { name: 'Gestión de Aplicaciones', iconCls: 'grid-shortcut', module: 'grid-win' }
                ]
            }),

            wallpaper: 'app/wallpapers/Blue-Sencha.jpg',
            wallpaperStretch: false
        });
    },

    // config for the start menu
    getStartConfig : function() {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            title: 'Don Griffin',
            iconCls: 'user',
            height: 300,
            toolConfig: {
                width: 100,
                items: [
                    {
                        text:'Settings',
                        iconCls:'settings',
                        handler: me.onSettings,
                        scope: me
                    },
                    '-',
                    {
                        text:'Logout',
                        iconCls:'logout',
                        handler: me.onLogout,
                        scope: me
                    }
                ]
            }
        });
    },

    onSettings: function () {
        var dlg = new Desktop.Settings({
            desktop: this.desktop
        });
        dlg.show();
    }
});