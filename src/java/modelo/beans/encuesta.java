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
    
    pregunta p19= new pregunta("Informacion General",0,1,3);
    p19.lista=null;
    this.lista.add(p19);
    
    pregunta p1=new pregunta("Nombre de la Empresa u Organización a la que pertenece:",1,2,0);
    p1.lista=null;
    this.lista.add(p1);
    
    
    pregunta p2=new pregunta("Activida principal de su empresa",2,3,0);
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
    
    pregunta p1= new pregunta("Dirección de correo electrónico *",18,1,0);
    p1.lista=null;
    this.lista.add(p1);
    
    pregunta p2= new pregunta("1.Cual es tu nombre completo y tus apellidos",19,2,0);
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
    
     pregunta p4=new pregunta("3. ¿En qué fecha egresaste del Politécnico? *",21,4,0);
     p4.lista=null;
     this.lista.add(p4);
     
     pregunta p5=new pregunta("4. ¿Realizaste práctica laboral dentro de tu proceso de formación? *",22,5);
     respuesta r51=new respuesta(1,"Si");
     respuesta r52=new respuesta(2,"No");
     p5.lista.add(r51);
     p5.lista.add(r52);
     this.lista.add(p5);
     
     pregunta p6=new pregunta("5. ¿Cuánto tiempo llevas trabajando, específicamente como Ingeniero Informatico (en años)? *",23,6,0);
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
     
     pregunta p8=new pregunta("7. ¿Cuál es el nombre de la empresa en la cual trabajas? *",25,8,0);
     p8.lista=null;
     this.lista.add(p8);
     
     pregunta p9=new pregunta("8. ¿Cuál es el carácter de la entidad donde trabajas?  *",26,9);
     respuesta r91=new respuesta(1,"privada");
     respuesta r92=new respuesta(2,"publica");
     p9.lista.add(r91);
     p9.lista.add(r92);
     this.lista.add(p9);
     
     pregunta p10=new pregunta("9. Nivel del cargo que desempeñas  *",27,10,2);
     respuesta r101=new respuesta(1,"Directivo");
     respuesta r102=new respuesta(2,"Mando medio");
     respuesta r103=new respuesta(3,"Asesor");
     respuesta r104=new respuesta(4,"otro:");
     p10.lista.add(r101);
     p10.lista.add(r102);
     p10.lista.add(r103);
     p10.lista.add(r104);
     this.lista.add(p10);
     
     pregunta p11=new pregunta("10. ¿En qué rango se encuentran actualmente tus ingresos (integral)?  *",28,11);
     respuesta r111=new respuesta(1,"$1.501.000 - $2.000.000");
     respuesta r112=new respuesta(2,"$2.001.000 - $3.000.000");
     respuesta r113=new respuesta(3,"$3.001.000 o más");
     respuesta r114=new respuesta(4,"No trabajo como Ingeniero Informático");
     p11.lista.add(r111);
     p11.lista.add(r112);
     p11.lista.add(r113);
     p11.lista.add(r114);
     this.lista.add(p11);
     
     pregunta p12=new pregunta("11. ¿Cuál de las siguientes cargos desempeñas actualmente?  *",29,12,2);
     respuesta r121=new respuesta(1,"Analista");
     respuesta r122=new respuesta(2,"Desarrollador");
     respuesta r123=new respuesta(3,"Líder de desarrollo");
     respuesta r124=new respuesta(4,"Jefe de sistemas");
     respuesta r125=new respuesta(5,"Programador");
     respuesta r126=new respuesta(6,"Jefe/Director de proyectos");
     respuesta r127=new respuesta(7,"Administrador de bases de datos");
     respuesta r128=new respuesta(8,"Arquitecto de software");
     respuesta r129=new respuesta(9,"Analista de pruebas");
     respuesta r1210=new respuesta(10,"Ingeniero de servicios");
     respuesta r1212=new respuesta(11,"Ingeniero de seguridad de la información");
     respuesta r1213=new respuesta(12,"Gerente/Director Comercial");
     respuesta r1214=new respuesta(13,"Gerente de producto");
     respuesta r1215=new respuesta(14,"Jefe/Gerente de infraestructura");
     respuesta r1216=new respuesta(15,"Científico de Datos");
     respuesta r1217=new respuesta(16,"Otro:");
     p12.lista.add(r121);
     p12.lista.add(r122);
     p12.lista.add(r123);
     p12.lista.add(r124);
     p12.lista.add(r125);
     p12.lista.add(r126);
     p12.lista.add(r127);
     p12.lista.add(r128);
     p12.lista.add(r129);
     p12.lista.add(r1210);
     p12.lista.add(r1212);
     p12.lista.add(r1213);
     p12.lista.add(r1214);
     p12.lista.add(r1215);
     p12.lista.add(r1216);
     p12.lista.add(r1217);
     this.lista.add(p12);
     
     pregunta p13=new pregunta("12. Si no trabajas como Ingeniero Informático, en qué trabajas?*",30,13,0);
     p13.lista=null;
     this.lista.add(p13);
     
     pregunta p14=new pregunta("13. Cuál es la razón por la cual no trabajas como Ingeniero Informático? *",31,14,0);
     p14.lista=null;
     this.lista.add(p14);
     
     pregunta p15=new pregunta("14. ¿Has realizado estudios después de egresar de Ingeniero Informático? *",32,15,2);
     p15.lista.add(new respuesta(1,"cursos"));
     p15.lista.add(new respuesta(2,"Diplomados"));
     p15.lista.add(new respuesta(3,"Especializaciones"));
     p15.lista.add(new respuesta(4,"Maestria"));
     p15.lista.add(new respuesta(5,"Doctorado"));
     p15.lista.add(new respuesta(6,"otro"));
     this.lista.add(p15);
     
     pregunta p16=new pregunta("15. ¿En el ámbito académico, empresarial o investigativo, tienes publicaciones? *",33,16);
     p16.lista.add(new respuesta(1,"Si"));
     p16.lista.add(new respuesta(2,"No"));
     this.lista.add(p16);
     
     pregunta p17=new pregunta("16. Número de publicaciones (título y en dónde fue publicada) (De no contar con ninguna responder 0) *",34,17,0);
     p17.lista=null;
     this.lista.add(p17);
     
     pregunta p18=new pregunta("17. Número de citaciones y co-citaciones (De no contar con ninguna responder 0) *",35,18,0);
     p18.lista=null;
     this.lista.add(p18);
    
     pregunta p19=new pregunta("18. Información de la producción científica en bases de datos internacionales de revistas indexadas (De no contar con ninguna responder 0) *",36,19,0);
     p19.lista=null;
     this.lista.add(p19);
    
     pregunta p20=new pregunta("19. ¿Ha participado en alguna red académica o profesional? ¿cuál? *",37,20,0);
     p20.lista=null;
     this.lista.add(p20);
     
     pregunta p21=new pregunta("20.¿ ha tenido alguna distinción académica o profesional? ¿cuál? *",38,21,0);
     p21.lista=null;
     this.lista.add(p21);
    }
    
    }
}
