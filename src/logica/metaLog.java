/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Meta;
import modelo.Objetivo;
import persistencia.MetaJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lenovo
 */
public class metaLog {
    
    private MetaJpaController controlMeta = new MetaJpaController();
    private objetivoLog objLog = new objetivoLog();
    private usuarioLog usLog = new usuarioLog();
    private List<Objetivo> listObj;
    private List<Meta> listInic;
    
    public metaLog(){
        
    }
    
    //Retorna todas las metas
    public List<Meta> consultarMeta(){
        return controlMeta.findMetaEntities();
    }
    
    //Crea una meta
    public void crearMeta(Meta me) throws Exception{
        if(me == null){
            throw new Exception("La Meta no tiene información");
        }
        Meta m = controlMeta.findMeta(me.getCodigoMeta());
        if(m == null){
            controlMeta.create(me);
        }else{
            throw new Exception("Meta ya registrada");
        } 
    }
    
    //Modificar meta
    public void modificarMeta(Meta m){
        try {
            controlMeta.edit(m);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(metaLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(metaLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
