/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Indicador;
import modelo.Iniciativa;
import modelo.Meta;
import modelo.Objetivo;
import modelo.Usuario;
import persistencia.IndicadorJpaController;
import persistencia.IniciativaJpaController;
import persistencia.MetaJpaController;
import persistencia.ObjetivoJpaController;
import persistencia.UsuarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lenovo
 */
public class usuarioLog {
    private ObjetivoJpaController controlObjetivo = new ObjetivoJpaController();
    private IndicadorJpaController controlIndicador = new IndicadorJpaController();
    private IniciativaJpaController controlIniciativa = new IniciativaJpaController();
    private MetaJpaController controlMeta = new MetaJpaController();
    private UsuarioJpaController controlUsuario = new UsuarioJpaController();
    private List<Usuario> listUsers;
    private List<Objetivo> listObj;
    private List<Indicador> listInd;
    private List<Iniciativa> listInic;
    private List<Meta> listMeta;
    
    public usuarioLog(){
        
    }
    
    //Retorna los usuarios
    public List<Usuario> consultar(){
        return controlUsuario.findUsuarioEntities();
    }
    
    //Buscar un usuario por el codigo y retornarlo
    public Usuario consultarUser(int us){
        listUsers = controlUsuario.findUsuarioEntities();
        Usuario user = new Usuario();
        for(Usuario u: listUsers){
            if(u.getCodigo() == us){
                user = u;
              }
          }
        return user;
    }
    
    //Buscar un usuario por la cedula y retornarlo
    public Usuario consultarUserCed(String ced){
        listUsers = controlUsuario.findUsuarioEntities();
        Usuario user = new Usuario();
        for(Usuario u: listUsers){
            if(u.getCedula().equals(ced)){
                user = u;
              }
          }
        return user;
    }
    
    //Crear un usuario
    public void crearUser(Usuario u) throws Exception{
        if(u == null){
            throw new Exception("El usuario no tiene información");
        }
        Usuario user = controlUsuario.findUsuario(u.getCodigo());
        if(user == null){
            controlUsuario.create(u);
        }else{
            throw new Exception("Usuario ya registrado");
        } 
    }
    
    //Modificar usuario
    public void modificarUser(Usuario u){
        try {
            controlUsuario.edit(u);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(usuarioLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(usuarioLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Eliminar Usuario
    public void eliminarUser(int codU){
        try {
            controlUsuario.destroy(codU);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(usuarioLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(usuarioLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Retorna true o false si un usuario tiene objetivos
    public boolean usuarioObjetivos(int codU){
        listUsers = controlUsuario.findUsuarioEntities();
        listObj = controlObjetivo.findObjetivoEntities();
        Usuario userR = new Usuario();
        boolean hay = false;
        
        for(Usuario u: listUsers){
            if(u.getCodigo() == codU){
                userR = u;
              }
          }
        for(Objetivo o: listObj){
            if(o.getCodUsuario().getCodigo() == userR.getCodigo()){
                hay = true;
            }
        }
        return hay;
    }
    
    //Retorna el area de un usuario
    public String retornarArea(int codigoU){
        listUsers = controlUsuario.findUsuarioEntities();
        String areaUser = "";
        for(Usuario r: listUsers){
            if(r.getCodigo() == codigoU){
                areaUser = r.getTipoArea();
              }
          }
        return areaUser;
    }
    
    //Retorna el nombre de un usuario
    public String retornarNameU(int codigoU){
        listUsers = controlUsuario.findUsuarioEntities();
        String nameUser = "";
        for(Usuario r: listUsers){
            if(r.getCodigo() == codigoU){
                nameUser = r.getNombre();
              }
          }
        return nameUser;
    }
    
    //Retorna la cantidad de objetivos creados por un usuario
    public int cantidadObj(int codU){
        listUsers = controlUsuario.findUsuarioEntities();
        listObj = controlObjetivo.findObjetivoEntities();
        int cantidad = 0;
        Usuario userR = new Usuario();
        
        for(Usuario u: listUsers){
            if(u.getCodigo() == codU){
                userR = u;
              }
          }
        for(Objetivo o: listObj){
            if(o.getCodUsuario().getTipoArea().equals(userR.getTipoArea())){
                cantidad++;
            }
        }
        
        return cantidad;
        
    }
   
    
    
    
}
