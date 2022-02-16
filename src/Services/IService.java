/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;
/**
 *
 * @author Walid Boulima
 */


public interface IService<T> {

    public void ajouterTerrain(T t);
    public List<T> afficherTerrain();
    public boolean modifierTerrain(T t);
    public boolean supprimerTerrain(T t);
    
    
}