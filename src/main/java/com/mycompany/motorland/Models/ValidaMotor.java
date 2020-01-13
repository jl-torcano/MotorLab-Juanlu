/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.motorland.Models;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 *
 * @author julut
 */
public class ValidaMotor implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Motor.class.isAssignableFrom(type);//Comprobación de que estemos usando un objeto de la clase correcta
    }

    @Override
    public void validate(Object o, Errors errors) {
      
        Motor motor = (Motor)o;//Creamos un objeto motor mediante casting del que recibimos del formulario
        
        if(motor.getModelo().length()!=5){//Si el campo modelo tiene una longitud distinta de 5 entrará al error
            errors.rejectValue("modelo", "verificaModelo", "El modelo debe tener 5 carácteres");
            //Con esto lanzaremos el error correspondiente, el primer String hace referencia al campo rellenado en el formulario, 
            //el segundo es como vamos a llamar al codigo de este error y el tercero el mensaje que vamos a mostrar
        }
        
        if(motor.getPeso()<=0){//Si el peso es menor o igual a cero lanzaremos el error
            errors.rejectValue("peso", "verificaPeso", "El peso debe de ser mayor de 0");
        }
        
        if(motor.getPotencia()<=0){//Si la potencia es menor o igual a cero lanzaremos el error
            errors.rejectValue("potencia", "verificaPotencia", "La potencia debe de ser mayor de 0");
        }
        
        if(motor.getCantidad()<0){//Si la Cantidad es negativa, lanzaremos el error
            errors.rejectValue("cantidad", "verificaCantidad", "La cantidad no puede ser negativa");
        }
        
    }
   
}
