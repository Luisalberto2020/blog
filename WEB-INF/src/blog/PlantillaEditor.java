package blog;
import org.stringtemplate.v4.*;

import java.util.List;

public class PlantillaEditor extends Plantillas {





    public PlantillaEditor() {
    } 


    public String paginaInstalador(String titulo,String mensage){



            ST template= new ST(pageInstalador,'$', '$');
            System.err.println("--------------------"+titulo);
            System.err.println("---------------------"+mensage);
            template.add("tituloInstalador", titulo);
            template.add("mensageInstalador", mensage);
        /*String resultado=pageInstalador;
        resultado=resultado.replace("[tituloInstalador]",titulo);
        resultado=resultado.replace("[mensageInstalador]",mensage);
        resultado=resultado.replace("[css]","");*/

            return template.render();



    }
    public String LoginFormEdited(String mensage){
        String resultado="";
        resultado+=Cabeceras;
        resultado+=nav3;
        resultado+=loginForm;
        resultado+=cierreDocumento;
        ST template= new ST(resultado,'$', '$');
        template.add("mensage", mensage);
        template.add("css","<link rel=\"stylesheet\" href=\"./css/login.css\">");


        return  template.render();


    }
    public String evitarXSS(String data){
        data=data.replace("&","");
        data=data.replace("&amp","");
        data=data.replace(">","");
        data=data.replace("&gt","");
        data=data.replace("<","");
        data=data.replace("'","");
        data=data.replace("&#039","");
        data=data.replace("\"","");
        data=data.replace("&#034","");




                return data;
    }

    public String enviarToast(String titulo,String mensage){


        String resultado=toast;


        String script= """
                <script>
                        var toast = new bootstrap.Toast(liveToast,{delay:6000})
                                
                        toast.show()
                      </script>         
                """;
        resultado+=script;
        ST template= new ST(resultado,'$', '$');
        template.add("titulo", evitarXSS(titulo));
        template.add("mensage",evitarXSS(mensage));



        return template.render();
    }
public String colocarCabecera(String css){
    ST template= new ST(Cabeceras,'$', '$');
    template.add("css", css);

    return template.render();
}


public String colocarAvatarnva1(Integer avatar){

    ST template= new ST(nav1,'$', '$');
    template.add("avatar", avatar.toString());

    return template.render();

}
    public String colocarAvatarnva2(Integer avatar){

        ST template= new ST(nav2,'$', '$');
        template.add("avatar", avatar.toString());

        return template.render();

    }
    public String crearEntrada(Entrada e){


        ST template= new ST(entrada,'$', '$');
        template.add("autor",e.getAutor() );
        template.add("titulo",e.getTitulo());
        template.add("texto",e.getTexto());
        template.add("fecha",e.getFecha());

        return template.render();



    }
    public String crearEntradaEditable(Entrada e){

        ST template= new ST(entradaeditable,'$', '$');
        template.add("autor",e.getAutor() );
        template.add("titulo",e.getTitulo());
        template.add("texto",e.getTexto());
        template.add("fecha",e.getFecha());
        template.add("id",e.getId());

        return template.render();
    }
public String actualizarEntrada(Entrada e){
    ST template= new ST(UpdateEntrada,'$', '$');
    template.add("titulo",e.getTitulo());
    template.add("texto",e.getTexto());
    template.add("id",e.getId());

    return template.render();
}
    public String enviarAlert(String mensage){
        ST template= new ST(alert,'$', '$');
        template.add("message",evitarXSS(mensage));

        return template.render();
    }

    public String editarPerfil(Usuario u){
        String enlace="http://127.0.0.1/blog/aciones/enlace?id="+u.getEnlace();
        String option=" <option value=\"$value$\">$value$</option>\n";
        String optionBuena=" <option value=\"$value$\" selected >$value$</option>\n";
        String options="";

        String tmp="";

        for (int i = 1; i < 33; i++) {
            if(u.getAvatar()==i){
                tmp=optionBuena;
            }else {
                tmp=option;
            }
            ST template= new ST(tmp,'$', '$');
            template.add("value",i);
            options+=template.render();
        }




        ST template= new ST(editarPerfil,'$', '$');
       template.add("usuario",u.getNombre());
       template.add("avatar",u.getAvatar());
       template.add("enlace",enlace);
       template.add("options",options);


        return template.render();



    }

    public String  crearTablaUser(List<Usuario> usuarios){


        String columnas="";
        for (Usuario u: usuarios) {

            ST template= new ST(columna,'$', '$');
            template.add("usuario",u.getNombre());
            template.add("avatar",u.getAvatar());
            String admin="No";
            if(u.getAdmin()==1){
                admin="Si";
            }
            template.add("admin",admin);
            columnas+=template.render();


        }
        ST template= new ST(tabal,'$', '$');
        template.add("columnas",columnas);



        return template.render();
    }
  
}


   

   

   
