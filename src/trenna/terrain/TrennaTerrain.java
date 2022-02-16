/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trenna.terrain;

import Entities.Terrain;
import Services.ServiceTerrain;
import Utils.MyDB;
/**
 *
 * @author Walid Boulima
 */
public class TrennaTerrain {

    public static void main(String[] args) {
       
        
        //ajout terrain
          ServiceTerrain st = new ServiceTerrain();
    
    st.ajouterTerrain(new Terrain(5, "football"));
     System.out.println( st.afficherTerrain().toString());
        
        
        
        // modifier terrain
        ServiceTerrain st1 = new ServiceTerrain();
        Terrain terrain1 = new Terrain(2,"volleyball");
        st1.modifierTerrain(terrain1);
        
        
        //supprimer terrain
        ServiceTerrain st2 = new ServiceTerrain();
        Terrain terrain2 = new Terrain(2,"");
        st2.supprimerTerrain(terrain2);
        
    }
    
}
