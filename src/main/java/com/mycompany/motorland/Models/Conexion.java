/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.motorland.Models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author julut
 */
public class Conexion {
    
    public DriverManagerDataSource conectar(){
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost/motorland", "root", "");
        //Creamos un DriverManagerDataSource pasándole al constructor directamente la ruta de la BBDD, el usuario "root" y el password ""
       
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");//Indicamos el Driver que vamos a utilizar
        
        return dataSource;//Devolvermos el objeto DriverManagerDataSource que vamos a utilizar en el Dispatcher
    }
    
}
