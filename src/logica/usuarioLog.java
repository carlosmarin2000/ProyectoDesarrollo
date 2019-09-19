/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
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
    
    //Retorna la descripcion de cualquier cosa
    public String retornarDescripcion(int codigoU, String necesito){
        listUsers = controlUsuario.findUsuarioEntities();
        Usuario userR = new Usuario();
        listObj = controlObjetivo.findObjetivoEntities();
        Objetivo obj = new Objetivo();
        listInd = controlIndicador.findIndicadorEntities();
        listInic = controlIniciativa.findIniciativaEntities();  
        listMeta = controlMeta.findMetaEntities(); 
        String descripcion = "";
        
        for(Usuario u: listUsers){
            if(u.getCodigo() == codigoU){
                userR = u;
              }
          }
        for(Objetivo o: listObj){
            if(o.getCodUsuario().getCodigo() == userR.getCodigo()){
                obj = o;
            }
        }
        
        
        if(necesito.equals("Objetivo")){
            for(Objetivo ob: listObj){
                if(ob.getCodUsuario().getCodigo() == userR.getCodigo()){
                    descripcion = ob.getDescripcion();
                }
            }
        }
        
        else if(necesito.equals("Meta")){
            for(Meta m: listMeta){
                if(m.getCodObj().getCodObjetivo() == obj.getCodObjetivo()){
                    descripcion = m.getDescripcion();
                }
            }
        }
        
        else if(necesito.equals("Iniciativa")){
            for(Iniciativa i: listInic){
                if(i.getCodObj().getCodObjetivo() == obj.getCodObjetivo()){
                    descripcion = i.getDescripcion();
                }
            }
        }
        
        else if(necesito.equals("Indicador")){
            for(Indicador in: listInd){
                if(in.getCodObj().getCodObjetivo() == obj.getCodObjetivo()){
                    System.out.println("Indicador");
                    descripcion = in.getDescripcion();
                }
            }
        }
        
        else{
            System.out.println("Descripcion no encontrada");
        }
        
        return descripcion;
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
            if(o.getCodUsuario().getCodigo() == userR.getCodigo()){
                cantidad++;
            }
        }
        
        return cantidad;
        
    }
   
    
    
    
}
