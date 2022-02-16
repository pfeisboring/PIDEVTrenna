/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Terrain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.MyDB;



/**
 *
 * @author Walid Boulima
 */
public class ServiceTerrain implements IService<Terrain>{
    private Connection cnx;
    
    public ServiceTerrain(){
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouterTerrain(Terrain t) {
       try {
           String querry="INSERT INTO `terrain`(`idTerrain`, `typeTerrain`) VALUES (' "+t.getIdTerrain()+" ',' "+t.getTypeTerrain()+" ') ";
           Statement stm = cnx.createStatement();
           stm.executeUpdate(querry);
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    

    @Override
    public List<Terrain> afficherTerrain() {
        List<Terrain> terrains = new ArrayList();
        
        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `terrain` ";
            
            ResultSet rs = stm.executeQuery(querry);
            
            while(rs.next()){
                Terrain t = new Terrain();
                t.setIdTerrain(rs.getInt(1));
                t.setTypeTerrain(rs.getString("typeTerrain"));
                
                terrains.add(t);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return terrains;
    }
    
    

    @Override
    public boolean modifierTerrain(Terrain t) {
       try {
           String querry = "SELECT * FROM terrain WHERE terrain.`idTerrain`=" +t.getIdTerrain() + ";";
           Statement stm = cnx.createStatement();
           ResultSet rs = stm.executeQuery(querry);
           
           querry = "UPDATE `terrain` SET `idTerrain`='" + t.getIdTerrain() + " ', `typeTerrain`='" +t.getTypeTerrain() + " ' WHERE terrain.`idTerrain`=" + t.getIdTerrain() + ";" ; 
           int x = stm.executeUpdate(querry);
           System.out.println(x + " modifié avec succées");
           return true;
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
                   return false;

    }   
    }
    

        
    @Override
    public boolean supprimerTerrain(Terrain t) {
        try {
            String querry = "SELECT * FROM terrain WHERE terrain.`idTerrain`=" +t.getIdTerrain() + ";";
            Statement stm = cnx.createStatement();
             ResultSet rs = stm.executeQuery(querry);
             
             querry = "DELETE FROM `terrain` WHERE terrain.`idTerrain`=" + t.getIdTerrain() + ";";
              int x = stm.executeUpdate(querry);
           System.out.println(x + " supprimé avec succées");
           return true;
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
             return false;
    }
        }
    }

 


