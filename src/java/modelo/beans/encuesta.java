/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class encuesta {
    String titulo;
    String enunciado;
    ArrayList<pregunta> lista = new ArrayList<>();
    
    public encuesta(int tipo){
    if(tipo==1){//encuesta a empresarios
    titulo="Encuesta a empresarios, lideres y agentes externos";
    enunciado="En el proceso de autoevaluación permanente, con miras a fortalecer los procesos de mejoramiento continuo, es de vital importancia conocer la apreciación de los EMPRESARIOS, LÍDERES Y AGENTES EXTERNOS acerca de los diferentes aspectos del Programa.";					
    
    pregunta p19= new pregunta("Informacion General",0,1);
    p19.lista=null;
    this.lista.add(p19);
    
    pregunta p1=new pregunta("Nombre de la Empresa u Organización a la que pertenece:",1,2);
    p1.lista=null;
    this.lista.add(p1);
    
    
    pregunta p2=new pregunta("Activida principal de su empresa",2,3);
    p2.lista=null;
    this.lista.add(p2);
    
    pregunta p3=new pregunta(" Para cada uno de los siguientes enunciados marque con una X la casilla correspondiente a su apreciación al respecto, en una escala de 1 a 5, donde 5 es lo óptimo y 1 lo mínimo.\n" +
            "Marque la casilla NS (No sabe) cuando desconozca la respuesta o no tenga conocimiento del asunto en cuestión.\" "
            + "Señale su nivel de apreciacion respecto a:",0,4);
    p3.lista=null;
    this.lista.add(p3);
    
    pregunta p4=new pregunta("Las tendencias y líneas de desarrollo profesional del Programa en los ámbitos local, regional, nacional e internacional.",3,5);
    respuesta r1=new respuesta(1,"5");
    respuesta r2=new respuesta(2,"4");
    respuesta r3=new respuesta(3,"3");
    respuesta r4=new respuesta(4,"2");
    respuesta r5=new respuesta(5,"1");
    respuesta r6=new respuesta(6,"NS");
    p4.lista.add(r1);
    p4.lista.add(r2);
    p4.lista.add(r3);
    p4.lista.add(r4);
    p4.lista.add(r5);
    p4.lista.add(r6);
    this.lista.add(p4);
    
    pregunta p5=new pregunta("Las necesidades y requerimientos del entorno laboral en términos productivos, de competitividad, tecnológicos y de talento humano, en lo local, regiona y nacional",4,6);
    p5.lista=p4.lista;
    this.lista.add(p5);
    
    pregunta p6=new pregunta("Correspondencia entre el perfil laboral y ocupacional del Sector al que usted pertenece y el perfil del egresado del Programa Ingeniería Informatica",5,7);
    p6.lista=p4.lista;
    this.lista.add(p6);
    
    pregunta p7=new pregunta("Efectividad de los aportes de los profesionales Ingenieros Informaticos a la solución de problemas del entorno.",6,8);
    p7.lista=p4.lista;
    this.lista.add(p7);
    
    pregunta p8=new pregunta("Calidad e integralidad del currículo.",7,9);
    p8.lista=p4.lista;
    this.lista.add(p8);
    
    pregunta p9=new pregunta("El nivel de competitividad en el ejercicio profesional del egresado Ingeniero Informatico",8,10);
    p9.lista=p4.lista;
    this.lista.add(p9);
    
    pregunta p10=new pregunta("Mecanismos utilizados en el programa para la actualización permanente del currículo, en consononcia con los desarrollo disciplinares, profesionales y pedagógicos, para atender las necesidades del entorno.",9,11);
    p10.lista=p4.lista;
    this.lista.add(p10);
    
    pregunta p11=new pregunta("Incorporación de los adelantos y transformaciones que se han dado en las ciencias, las técnicas y las tecnologías implicadas, de acuerdo con el tipo y modalidad del programa.",10,12);
    p11.lista=p4.lista;
    this.lista.add(p11);
    
    pregunta p12=new pregunta("Impacto a nivel regional, nacional e internacional de la investigación, la innovación y la creación artística y cultural del programa, de acuerdo con su naturaleza.",11,13);
    p12.lista=p4.lista;
    this.lista.add(p12);
    
    pregunta p13=new pregunta("El nivel de responsabilidad demostrado por el profesional Ingenieros Informatico en el desempeño de sus labores.",12,14);
    p13.lista=p4.lista;
    this.lista.add(p13);
    
    pregunta p14=new pregunta("Existencia y efectividad de la página web institucional debidamente actualizada para mantener informado al público.",13,15);
    p14.lista=p4.lista;
    this.lista.add(p14);
    
    pregunta p15=new pregunta("Acceso con calidad a los sistemas de comunicación e información mediados por las TIC.",14,16);
    p15.lista=p4.lista;
    this.lista.add(p15);
    
    pregunta p16=new pregunta("Mecanismos eficientes de participación de los empresarios y líderes en la gestión del programa.",15,17);
    p16.lista=p4.lista;
    this.lista.add(p16);
    
    pregunta p17=new pregunta("Correspondencia entre la ocupación y ubicación profesional de los egresados y el perfil de formación del programa.",16,18);
    p17.lista=p4.lista;
    this.lista.add(p17);
    
    pregunta p18=new pregunta("Calidad de la formación y del desempeño de los egresados del programa.",17,19);
    p18.lista=p4.lista;
    this.lista.add(p18);
    
    
    }else{
     titulo="Tu vida como ingeniero informatico";
    enunciado="¡Queremos conocer un poco de tu vida laboral como egresado! Para ello hemos diseñado una breve encuesta que nos permitirá dos cosas: primero, tener una radiografía muy importante de tu situación laboral y la de otros colegas tuyos, nuestros egresados; y, segundo, consolidar información que nos permita revisar nuestro programa. Queremos tu ayuda, seguro no te toma más de diez minutos diligenciarla! De antemano muchas gracias por tu participación.";					
    
    pregunta p1= new pregunta("Dirección de correo electrónico *",18,1);
    p1.lista=null;
    this.lista.add(p1);
    
    pregunta p2= new pregunta("1.Cual es tu nombre completo y tus apellidos",19,2);
    p2.lista=null;
    this.lista.add(p2);
    
    pregunta p3=new pregunta("2.Rango de edad",20,3);
    respuesta r31=new respuesta(1,"20 a 30 años");
    respuesta r32=new respuesta(2,"31 a 40 años");
    respuesta r33=new respuesta(3,"40 a 50 años");
    respuesta r34=new respuesta(4,"mas de 51 años");   
    p3.lista.add(r31);
    p3.lista.add(r32);
    p3.lista.add(r33);
    p3.lista.add(r34);
    this.lista.add(p3);
    
     pregunta p4=new pregunta("3. ¿En qué fecha egresaste del Politécnico? *",21,4);
     p4.lista=null;
     this.lista.add(p4);
     
     pregunta p5=new pregunta("4. ¿Realizaste práctica laboral dentro de tu proceso de formación? *",22,5);
     respuesta r51=new respuesta(1,"Si");
     respuesta r52=new respuesta(2,"No");
     p5.lista.add(r51);
     p5.lista.add(r52);
     this.lista.add(p5);
     
     pregunta p6=new pregunta("5. ¿Cuánto tiempo llevas trabajando, específicamente como Ingeniero Informatico (en años)? *",23,6);
     p6.lista=null;
     this.lista.add(p6);
    
     pregunta p7=new pregunta("6. ¿Tu Trabajo como Ingeniero Informático es? * *",24,7);
     respuesta r71=new respuesta(1,"Formal");
     respuesta r72=new respuesta(2,"Informal");
     respuesta r73=new respuesta(3,"No trabajo como ingeniero informatico");
     p7.lista.add(r71);
     p7.lista.add(r72);
     p7.lista.add(r73);
     this.lista.add(p7);
     
     pregunta p7=new pregunta("6. ¿Tu Trabajo como Ingeniero Informático es? * *",24,7);
     respuesta r71=new respuesta(1,"Formal");
     respuesta r72=new respuesta(2,"Informal");
     respuesta r73=new respuesta(3,"No trabajo como ingeniero informatico");
     p7.lista.add(r71);
     p7.lista.add(r72);
     p7.lista.add(r73);
     this.lista.add(p7);
     
    }
    
    }
}
