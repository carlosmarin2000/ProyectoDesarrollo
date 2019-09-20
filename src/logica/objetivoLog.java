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
import persistencia.ObjetivoJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lenovo
 */
public class objetivoLog {
    
    private ObjetivoJpaController controlObj = new ObjetivoJpaController();
    private List<Objetivo> listObj;
    private List<Usuario> listUsers;
    private List<Indicador> listInd;
    private List<Iniciativa> listIni;
    private List<Meta> listMeta;
    private iniciativaLog iniLog = new iniciativaLog();
    private metaLog metLog = new metaLog();
    private indicadorLog indLog = new indicadorLog();
    private usuarioLog usLog = new usuarioLog();    
    
    public objetivoLog(){

    }
    
    //Retorna todos los objetivos
    public List<Objetivo> consultarObj(){
        return controlObj.findObjetivoEntities();
    }
    
    //Crea un objetivo
    public void crearObj(Objetivo o) throws Exception{
        if(o == null){
            throw new Exception("El Objetivo no tiene información");
        }
        Objetivo obj = controlObj.findObjetivo(o.getCodObjetivo());
        if(obj == null){
            controlObj.create(o);
        }else{
            throw new Exception("Objetivo ya registrado");
        } 
    }
    
    //Modificar objetivo
    public void modificarObj(Objetivo o){
        try {
            controlObj.edit(o);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(objetivoLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(objetivoLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Retorna un array con la descripcion de objetivo, indicador, meta e iniciativa
    public String[] descripciones(int codObj){
        String[] descripc = new String[4];
        listUsers = usLog.consultar();
        listObj = controlObj.findObjetivoEntities();
        listInd = indLog.consultarInd();
        listIni = iniLog.consultarIni();
        listMeta = metLog.consultarMeta();
        
        for(Objetivo o: listObj){
            if(o.getCodObjetivo() == codObj){
                descripc[0] = o.getDescripcion();
                for(Indicador i: listInd){
                    if(i.getCodObj().getCodObjetivo() == codObj){
                        descripc[1] = i.getDescripcion();
                    }
                }
                
                for(Meta m: listMeta){
                    if(m.getCodObj().getCodObjetivo() == codObj){
                        descripc[2] = m.getDescripcion();
                    }
                }
                
                for(Iniciativa ini: listIni){
                    if(ini.getCodObj().getCodObjetivo() == codObj){
                        descripc[3] = ini.getDescripcion();
                    }
                }
            }
        }
        return descripc;
    }
    
    //Retorna un arreglo con las descripciones de los Objetivos
    public String[] descObjetivos(int codU){
        listUsers = usLog.consultar();
        Usuario userR = new Usuario();
        listObj = controlObj.findObjetivoEntities();
        String[] descripObj = new String[usLog.cantidadObj(codU)];
        int cont = 0;
        
        for(Usuario u: listUsers){
            if(u.getCodigo() == codU){
                userR = u;
            }
        }
        
        for(Objetivo o: listObj){
            if(o.getCodUsuario().getTipoArea().equals(userR.getTipoArea())){
                descripObj[cont] = o.getDescripcion();
                cont++;
            }
        }
        return descripObj;
        
    }
    
    
    
}


