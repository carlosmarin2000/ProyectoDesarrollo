/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Iniciativa;
import modelo.Objetivo;
import persistencia.IniciativaJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lenovo
 */
public class iniciativaLog {
    
    private IniciativaJpaController controlInic = new IniciativaJpaController();
    private objetivoLog objLog = new objetivoLog();
    private usuarioLog usLog = new usuarioLog();
    private List<Objetivo> listObj;
    private List<Iniciativa> listInic;
    
    public iniciativaLog(){
        
    }
    
    //Retorna todas las iniciativas
    public List<Iniciativa> consultarIni(){
        return controlInic.findIniciativaEntities();
    }
    
    //Crea una iniciativa
    public void crearInic(Iniciativa ini) throws Exception{
        if(ini == null){
            throw new Exception("La Iniciativa no tiene información");
        }
        Iniciativa indi = controlInic.findIniciativa(ini.getCodIniciativa());
        if(indi == null){
            controlInic.create(ini);
        }else{
            throw new Exception("Iniciativa ya registrada");
        } 
    }
    
    //Modificar iniciativa
    public void modificarInic(Iniciativa inic){
        try {
            controlInic.edit(inic);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(iniciativaLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(iniciativaLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
