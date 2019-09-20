/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Indicador;
import modelo.Objetivo;
import modelo.Usuario;
import persistencia.IndicadorJpaController;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lenovo
 */
public class indicadorLog {
    
    private IndicadorJpaController controlInd = new IndicadorJpaController();
    private objetivoLog objLog = new objetivoLog();
    private usuarioLog usLog = new usuarioLog();
    private List<Objetivo> listObj;
    private List<Indicador> listInd;
    private List<Usuario> listUs;
    
    public indicadorLog(){
        
    }
    
    //Retorna todos los indicadores
    public List<Indicador> consultarInd(){
        return controlInd.findIndicadorEntities();
    }
    
    //Crea un indicador
    public void crearInd(Indicador ind) throws Exception{
        if(ind == null){
            throw new Exception("El Indicador no tiene información");
        }
        Indicador indi = controlInd.findIndicador(ind.getCodIndicador());
        if(indi == null){
            controlInd.create(ind);
        }else{
            throw new Exception("Indicador ya registrado");
        } 
    }
    
    //Modificar indicador
    public void modificarInd(Indicador ind){
        try {
            controlInd.edit(ind);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(indicadorLog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(indicadorLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Retorna cuantos indicadores hay
    public int cantidadI(int codU){
        listObj = objLog.consultarObj();
        Usuario user = new Usuario();
        user = usLog.consultarUser(codU);
        listInd = controlInd.findIndicadorEntities();
        listUs = usLog.consultar();
        int cantidadInd = 0;
        
        for(Indicador i: listInd){
            cantidadInd++;
        }        
        
        return cantidadInd;
        
    }
    
    //Retorna la descripcion de un indicador
    public String[] descIndicador(int codU){
        listObj = objLog.consultarObj();
        Objetivo obj = new Objetivo();
        Usuario user = new Usuario();
        user = usLog.consultarUser(codU);
        listUs = usLog.consultar();
        listInd = controlInd.findIndicadorEntities();
        String[] descripInd = new String[usLog.cantidadObj(codU)];
        int cont = 0;
        
        for(Usuario u: listUs){
            if(u.getTipoArea().equals(user.getTipoArea())){
                for(Objetivo o: listObj){
                    if(o.getCodUsuario().getCodigo() == u.getCodigo()){
                        for(Indicador i: listInd){
                            if(i.getCodObj().getCodObjetivo() == o.getCodObjetivo()){
                                descripInd[cont] = i.getDescripcion();
                                cont++;
                            }
                        }
                    }
                }
            }
        }
        
        return descripInd;
        
    }
    
}
