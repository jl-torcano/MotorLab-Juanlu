/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.motorland.Controllers;

import com.mycompany.motorland.Models.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author julut
 */
@Controller
public class ListadoController {
    
    private JdbcTemplate jdbcT;
    
    public ListadoController(){//Dentro del Constructor creamos la conexíon a la BBDD mediante el jdbcT
        
        Conexion conexion = new Conexion();
        this.jdbcT = new JdbcTemplate(conexion.conectar());
    }
    
    @RequestMapping("listado.htm")//Maping para listado.htm
    public ModelAndView listado(){
        
        ModelAndView mav = new ModelAndView();
        List listadoMotores = jdbcT.queryForList("select * from motores;");
        //Sacamos en una lista los elementos de la BBDD
        
        mav.addObject("listadoMotores", listadoMotores);//Añadimos para enviar a la vista el listado
        mav.setViewName("listado");
        return mav;
    }
}
