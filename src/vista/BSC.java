/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import javax.swing.JOptionPane;
import logica.indicadorLog;
import logica.objetivoLog;
import logica.usuarioLog;
import modelo.Usuario;

/**
 *
 * @author Lenovo
 */
public class BSC extends javax.swing.JFrame {
    private usuarioLog usuLog = new usuarioLog();
    private objetivoLog objLog = new objetivoLog();
    private indicadorLog indLog = new indicadorLog();
    private List<Usuario> ListUsuarios;
    String area, nameUs, msgBienvenida;
    int cantidadRowF, cantidadRowC, cantidadRowPI, cantidadRowAC; //10
    String matriz[][];
    int codUsuario; //Para retornar todos codigos de los usuarios
    int ingresoDesde; //Para saber desde donde se ingresó
    int codUser;
    int seleccionF, seleccionC, seleccionPI, seleccionAC; //Para saber que parte de la tabla escogio el usuario
    String []descObj;
    String []desIndi;
    boolean cli, fin, procI, aprenC;
    /**
     * Creates new form BSC
     */
    public BSC(int user) {
        super(".:BSC:.");
        initComponents();
        codUser = user;
        ingresoDesde = 1;
        area = usuLog.retornarArea(user);
        nameUs = usuLog.retornarNameU(user);
        msgBienvenida = "Bienvenido Señor(a): "+nameUs;
        cli = true;
        fin = true;
        procI = true;
        aprenC = true;
        this.setLocationRelativeTo(null); 
        cantidadRowF = 0;
        cantidadRowC = 0;
        cantidadRowPI = 0;
        cantidadRowAC = 0;   
        codUsuario = 0;
        ListUsuarios = usuLog.consultar();
        
        for(Usuario u: ListUsuarios){
            codUsuario = u.getCodigo();
            descObj = objLog.descObjetivos(codUsuario);
            desIndi = indLog.descIndicador(codUsuario);
            
            if(u.getTipoArea().equals("Cliente") && cli){
                cantidadRowC = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowC][2];

                //Llenar tabla clientes************
                for(int i=0; i<cantidadRowC;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                }

                tablaC.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                cli = false;
            //*********************************
            }
            else if(u.getTipoArea().equals("Financiero") && fin){
                cantidadRowF = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowF][2];
                //Llenar tabla financiero************
                for(int i=0; i<cantidadRowF;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                }

                tablaFinanc.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                fin = false;
                //***************************************
            }
            
            else if(u.getTipoArea().equals("Procesos Internos") && procI){
                cantidadRowPI = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowPI][2];
               //Llenar tabla Procesos Internos************
                for(int i=0; i<cantidadRowPI;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                }

                tablaProcI.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                procI = false;
                //*************************************** 
            }
            
            else if(u.getTipoArea().equals("Aprendizaje y Crecimiento") && aprenC){
                cantidadRowAC = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowAC][2];
                //Llenar tabla Aprendizaje y Crecimiento************
                for(int i=0; i<cantidadRowAC;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                }

                tablaAprenC.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                aprenC = false;
                //*************************************** 
            }
            
        }
               
        //Bloquear botones de la interfaz
        if(area.equals("Financiero")){
            bienvenido.setText(msgBienvenida);
            //Bloquea los botones del area Aprendizaje y Crecimiento
            agregarAprenC.setEnabled(false);
            eliminarAprenC.setEnabled(false);
            modificarAprenC.setEnabled(false);
            vermoreAprenC.setEnabled(false);
            
            //Bloquea los botones del area Clientes
            agregarC.setEnabled(false);
            eliminarC.setEnabled(false);
            modificarC.setEnabled(false);
            vermoreC.setEnabled(false);
            
            //Bloquea los botones del area Procesos Internos
            agregarProcI.setEnabled(false);
            eliminarProcI.setEnabled(false);
            modificarProcI.setEnabled(false);
            vermoreProcI.setEnabled(false);
        }  
        
        else if(area.equals("Cliente")){
            bienvenido.setText(msgBienvenida);
            //Bloquea los botones del area Aprendizaje y Crecimiento
            agregarAprenC.setEnabled(false);
            eliminarAprenC.setEnabled(false);
            modificarAprenC.setEnabled(false);
            vermoreAprenC.setEnabled(false);
            
            //Bloquea los botones del area Financiera
            agregarFinanc.setEnabled(false);
            eliminarFinanc.setEnabled(false);
            modificarFinanc.setEnabled(false);
            vermoreFinanc.setEnabled(false);
            
            //Bloquea los botones del area Procesos Internos
            agregarProcI.setEnabled(false);
            eliminarProcI.setEnabled(false);
            modificarProcI.setEnabled(false);
            vermoreProcI.setEnabled(false);
        }
        
        else if(area.equals("Procesos Internos")){
            bienvenido.setText(msgBienvenida);
            //Bloquea los botones del area Aprendizaje y Crecimiento
            agregarAprenC.setEnabled(false);
            eliminarAprenC.setEnabled(false);
            modificarAprenC.setEnabled(false);
            vermoreAprenC.setEnabled(false);
            
            //Bloquea los botones del area Financiera
            agregarFinanc.setEnabled(false);
            eliminarFinanc.setEnabled(false);
            modificarFinanc.setEnabled(false);
            vermoreFinanc.setEnabled(false);
            
            //Bloquea los botones del area Clientes
            agregarC.setEnabled(false);
            eliminarC.setEnabled(false);
            modificarC.setEnabled(false);
            vermoreC.setEnabled(false);
        }
        
        else if(area.equals("Aprendizaje y Crecimiento")){
            bienvenido.setText(msgBienvenida);
            //Bloquea los botones del area Procesos Internos
            agregarProcI.setEnabled(false);
            eliminarProcI.setEnabled(false);
            modificarProcI.setEnabled(false);
            vermoreProcI.setEnabled(false);
            
            //Bloquea los botones del area Financiera
            agregarFinanc.setEnabled(false);
            eliminarFinanc.setEnabled(false);
            modificarFinanc.setEnabled(false);
            vermoreFinanc.setEnabled(false);
            
            //Bloquea los botones del area Clientes
            agregarC.setEnabled(false);
            eliminarC.setEnabled(false);
            modificarC.setEnabled(false);
            vermoreC.setEnabled(false);
        }
    }
    
    public BSC(){
        super(".:BSC:.");
        initComponents();
        ingresoDesde = 2;
        msgBienvenida = "Bienvenido Señor(a): Administrador";
        bienvenido.setText(msgBienvenida);
        this.setLocationRelativeTo(null);
        codUsuario = 0;
        cantidadRowF = 0;
        cantidadRowC = 0;
        cantidadRowPI = 0;
        cantidadRowAC = 0; 
        cli = true;
        fin = true;
        procI = true;
        aprenC = true;
        ListUsuarios = usuLog.consultar();
        
        for(Usuario u: ListUsuarios){
            codUsuario = u.getCodigo();
            descObj = objLog.descObjetivos(codUsuario);
            desIndi = indLog.descIndicador(codUsuario);
            
            if(u.getTipoArea().equals("Cliente") && cli){
                cantidadRowC = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowC][2];
                //Llenar tabla clientes************
                for(int i=0; i<cantidadRowC;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                }

                tablaC.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                cli = false;
            //*********************************
            }
            else if(u.getTipoArea().equals("Financiero") && fin){
                cantidadRowF = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowF][2];
                //Llenar tabla financiero************
                for(int i=0; i<cantidadRowF;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                    System.out.println("Matriz--> "+ matriz[i][1]);
                }

                tablaFinanc.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                fin = false;
                //***************************************
            }
            
            else if(u.getTipoArea().equals("Procesos Internos") && procI){
                cantidadRowPI = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowPI][2];
               //Llenar tabla Procesos Internos************
                for(int i=0; i<cantidadRowPI;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                }

                tablaProcI.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                procI = false;
                //*************************************** 
            }
            
            else if(u.getTipoArea().equals("Aprendizaje y Crecimiento") && aprenC){
                cantidadRowAC = usuLog.cantidadObj(codUsuario);
                matriz = new String[cantidadRowAC][2];
                //Llenar tabla Aprendizaje y Crecimiento************
                for(int i=0; i<cantidadRowAC;i++){
                    matriz[i][0] = descObj[i];
                    matriz[i][1] = desIndi[i];
                }

                tablaAprenC.setModel(new javax.swing.table.DefaultTableModel(
                    matriz,
                    new String [] {
                        "Objetivo", "Indicadores"
                    }
                ));
                aprenC = false;
                //*************************************** 
            }
            
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        bienvenido = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        agregarFinanc = new javax.swing.JButton();
        modificarAprenC = new javax.swing.JButton();
        agregarProcI = new javax.swing.JButton();
        eliminarProcI = new javax.swing.JButton();
        agregarAprenC = new javax.swing.JButton();
        eliminarAprenC = new javax.swing.JButton();
        agregarC = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaFinanc = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaProcI = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaAprenC = new javax.swing.JTable();
        atrasBSC = new javax.swing.JButton();
        eliminarFinanc = new javax.swing.JButton();
        modificarFinanc = new javax.swing.JButton();
        modificarC = new javax.swing.JButton();
        eliminarC = new javax.swing.JButton();
        modificarProcI = new javax.swing.JButton();
        vermoreFinanc = new javax.swing.JButton();
        vermoreProcI = new javax.swing.JButton();
        vermoreAprenC = new javax.swing.JButton();
        vermoreC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Clientes");

        bienvenido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bienvenido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bienvenido.setText("Bienvenido Señor(a): ");

        tablaC = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objetivo", "Indicadores"
            }
        ));
        jScrollPane2.setViewportView(tablaC);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Financiero");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Procesos Internos");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Aprendizaje y Crecimiento");

        agregarFinanc.setText("Agregar");
        agregarFinanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFinancActionPerformed(evt);
            }
        });

        modificarAprenC.setText("Modificar");

        agregarProcI.setText("Agregar");
        agregarProcI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProcIActionPerformed(evt);
            }
        });

        eliminarProcI.setText("Eliminar");
        eliminarProcI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProcIActionPerformed(evt);
            }
        });

        agregarAprenC.setText("Agregar");
        agregarAprenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAprenCActionPerformed(evt);
            }
        });

        eliminarAprenC.setText("Eliminar");
        eliminarAprenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAprenCActionPerformed(evt);
            }
        });

        agregarC.setText("Agregar");
        agregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCActionPerformed(evt);
            }
        });

        tablaFinanc = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaFinanc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaFinanc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objetivo", "Indicadores"
            }
        ));
        tablaFinanc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFinancMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaFinanc);

        tablaProcI = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaProcI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaProcI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objetivo", "Indicadores"
            }
        ));
        jScrollPane5.setViewportView(tablaProcI);

        tablaAprenC = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaAprenC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaAprenC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Objetivo", "Indicadores"
            }
        ));
        jScrollPane4.setViewportView(tablaAprenC);

        atrasBSC.setText("Atras");
        atrasBSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBSCActionPerformed(evt);
            }
        });

        eliminarFinanc.setText("Eliminar");
        eliminarFinanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarFinancActionPerformed(evt);
            }
        });

        modificarFinanc.setText("Modificar");
        modificarFinanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarFinancActionPerformed(evt);
            }
        });

        modificarC.setText("Modificar");

        eliminarC.setText("Eliminar");
        eliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCActionPerformed(evt);
            }
        });

        modificarProcI.setText("Modificiar");

        vermoreFinanc.setText("Ver más");

        vermoreProcI.setText("Ver más");

        vermoreAprenC.setText("Ver más");

        vermoreC.setText("Ver más");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(atrasBSC)
                        .addGap(171, 171, 171)
                        .addComponent(bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(agregarFinanc)
                                .addGap(19, 19, 19)
                                .addComponent(eliminarFinanc)
                                .addGap(18, 18, 18)
                                .addComponent(modificarFinanc)
                                .addGap(18, 18, 18)
                                .addComponent(vermoreFinanc)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(agregarProcI)
                                .addGap(18, 18, 18)
                                .addComponent(eliminarProcI)
                                .addGap(18, 18, 18)
                                .addComponent(modificarProcI)
                                .addGap(18, 18, 18)
                                .addComponent(vermoreProcI))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregarAprenC)
                                .addGap(18, 18, 18)
                                .addComponent(eliminarAprenC)
                                .addGap(18, 18, 18)
                                .addComponent(modificarAprenC)
                                .addGap(18, 18, 18)
                                .addComponent(vermoreAprenC)
                                .addGap(120, 120, 120)
                                .addComponent(agregarC)
                                .addGap(18, 18, 18)
                                .addComponent(eliminarC)
                                .addGap(18, 18, 18)
                                .addComponent(modificarC)
                                .addGap(18, 18, 18)
                                .addComponent(vermoreC))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atrasBSC)
                    .addComponent(bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarFinanc)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarFinanc)
                        .addComponent(modificarFinanc)
                        .addComponent(vermoreFinanc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminarProcI)
                        .addComponent(agregarProcI)
                        .addComponent(modificarProcI)
                        .addComponent(vermoreProcI)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarAprenC)
                    .addComponent(eliminarAprenC)
                    .addComponent(modificarAprenC)
                    .addComponent(vermoreAprenC)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(agregarC)
                        .addComponent(eliminarC)
                        .addComponent(modificarC)
                        .addComponent(vermoreC)))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasBSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBSCActionPerformed
        if(ingresoDesde == 1){
            Login inicio  = new Login();
            inicio.setVisible(true);
            dispose();
        }
        else if(ingresoDesde == 2){
            Admin ad  = new Admin();
            ad.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_atrasBSCActionPerformed

    private void agregarFinancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFinancActionPerformed
        if(ingresoDesde == 1){
            if(cantidadRowF <= 10){
                areaFinan arF = new areaFinan(codUser,1);
                arF.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
        else if(ingresoDesde == 2){
            if(cantidadRowF <= 10){
                areaFinan arF = new areaFinan(1);
                arF.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
    }//GEN-LAST:event_agregarFinancActionPerformed

    private void agregarProcIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProcIActionPerformed
        if(ingresoDesde == 1){
            if(cantidadRowPI <= 10){
                areaProcInt arPC = new areaProcInt(codUser,1);
                arPC.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
        else if(ingresoDesde == 2){
            if(cantidadRowPI <= 10){
                areaProcInt arPC = new areaProcInt(1);
                arPC.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
    }//GEN-LAST:event_agregarProcIActionPerformed

    private void agregarAprenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAprenCActionPerformed
        if(ingresoDesde == 1){
            if(cantidadRowAC <= 10){
                areaAprenyCrec arAC = new areaAprenyCrec(codUser,1);
                arAC.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
        else if(ingresoDesde == 2){
            if(cantidadRowAC <= 10){
                areaAprenyCrec arAC = new areaAprenyCrec(1);
                arAC.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
    }//GEN-LAST:event_agregarAprenCActionPerformed

    private void agregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCActionPerformed
        if(ingresoDesde == 1){
            if(cantidadRowAC <= 10){
                areaCliente arC = new areaCliente(codUser,1);
                arC.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
        else if(ingresoDesde == 2){
            if(cantidadRowAC <= 10){
                areaCliente arC = new areaCliente(1);
                arC.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Ya cumplió con el limite de filas(10)");
            }
        }
    }//GEN-LAST:event_agregarCActionPerformed
//Fin agregar ***********************************************************************************    
    
    private void eliminarFinancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFinancActionPerformed
        
    }//GEN-LAST:event_eliminarFinancActionPerformed

    private void eliminarProcIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProcIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarProcIActionPerformed

    private void eliminarAprenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAprenCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarAprenCActionPerformed

    private void eliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarCActionPerformed

    private void modificarFinancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarFinancActionPerformed
        if(ingresoDesde == 1){
            areaFinan arF = new areaFinan(codUser, 2);
            arF.setVisible(true);
            arF.selec = 20 + seleccionF;
            dispose();
        }
        else if(ingresoDesde == 2){
            areaFinan arF = new areaFinan(2);
            arF.setVisible(true);
            arF.selec = 20 + seleccionF;
            dispose();
        }
    }//GEN-LAST:event_modificarFinancActionPerformed

    private void tablaFinancMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFinancMouseClicked
        seleccionF = tablaFinanc.getSelectedRow();
    }//GEN-LAST:event_tablaFinancMouseClicked
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BSC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BSC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarAprenC;
    private javax.swing.JButton agregarC;
    private javax.swing.JButton agregarFinanc;
    private javax.swing.JButton agregarProcI;
    private javax.swing.JButton atrasBSC;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JButton eliminarAprenC;
    private javax.swing.JButton eliminarC;
    private javax.swing.JButton eliminarFinanc;
    private javax.swing.JButton eliminarProcI;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton modificarAprenC;
    private javax.swing.JButton modificarC;
    private javax.swing.JButton modificarFinanc;
    private javax.swing.JButton modificarProcI;
    private javax.swing.JTable tablaAprenC;
    private javax.swing.JTable tablaC;
    private javax.swing.JTable tablaFinanc;
    private javax.swing.JTable tablaProcI;
    private javax.swing.JButton vermoreAprenC;
    private javax.swing.JButton vermoreC;
    private javax.swing.JButton vermoreFinanc;
    private javax.swing.JButton vermoreProcI;
    // End of variables declaration//GEN-END:variables
}
