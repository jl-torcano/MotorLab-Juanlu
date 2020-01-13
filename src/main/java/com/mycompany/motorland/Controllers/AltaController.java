/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.motorland.Controllers;

import com.mycompany.motorland.Models.Conexion;
import com.mycompany.motorland.Models.Motor;
import com.mycompany.motorland.Models.ValidaMotor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author julut
 */
@Controller//Indicamos que la clase es un Controller
public class AltaController {
    
    JdbcTemplate jdbcT;//Creamos un JdbcTemplate que utilizaremos para conectar con la BBDD y realizar las consultas
    ValidaMotor validador;//Creamos un objeto ValidaMotor con el que comprobaremos si los campos introducidos por formulario son validos

    public AltaController() {//Constructor del Controller que conecta con la BBDD y asigna el ValidaMotor
        Conexion conexion = new Conexion();
        this.jdbcT = new JdbcTemplate(conexion.conectar());
        this.validador = new ValidaMotor();
    }
    
    @RequestMapping(value = "alta.htm", method = RequestMethod.GET)//Mapeamos la vista "alta.htm" por método GET
    public ModelAndView alta(){
        
        Motor motor = new Motor();//Creamos un objeto Motor vacío para enviarlo al formulario
        ModelAndView mav = new ModelAndView("alta", "command", motor);//Usamos el ModelAndView para redirigir a "alta.htm" y enviamos el objeto motor
        
        return mav;
    }
    
    @RequestMapping(value = "alta.htm", method = RequestMethod.POST)//Mapeamos la vista "alta.htm" por método POST
    public ModelAndView form(@ModelAttribute("motor") Motor mot, BindingResult result){
        //Recogemos el objeto motor completado en el formulario y el result que utilizaremos para la validacion
        this.validador.validate(mot, result);//
        
        if(result.hasErrors()){//Comprobamos si no se cumple alguna de las condiciones establecidas en la clase validador, y si es así redirigimos a la pagina de alta
            Motor motor = new Motor();
            ModelAndView mav = new ModelAndView("alta", "command", motor);
            return mav;
        }
        //Si no hay errores, insertamos en la BBDD los valores recogidos por el formulario utilizando el jdbcT
        this.jdbcT.update("insert into motores values(?,?,?,?,?)", mot.getModelo(), mot.getFabricante(), mot.getPotencia(), mot.getPeso(), mot.getCantidad());
       
        return new ModelAndView("redirect:/listado.htm");//Redireccionamos 
    }
    
}
