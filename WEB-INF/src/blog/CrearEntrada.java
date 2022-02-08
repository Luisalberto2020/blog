package blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CrearEntrada extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        HttpSession sesion = req.getSession(false);

        if(sesion!=null){


            String paginaWeb= run( req,  resp,sesion);
            PrintWriter out=resp.getWriter();
            PlantillaEditor pe= new PlantillaEditor();
            paginaWeb+= Plantillas.cierreDocumento;

            out.println(paginaWeb);

        }else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }



    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        HttpSession sesion = req.getSession(false);
        String titulo= req.getParameter("titulo");
        String contenido= req.getParameter("texto");


        if(sesion!=null){
            PlantillaEditor pe= new PlantillaEditor();
            String mensage="faltan datos";

            if(titulo!=null && contenido!=null){


                    try {


                            BasedeDatos db= new BasedeDatos();
                            Entrada e= new Entrada(1,pe.evitarXSS(titulo),pe.evitarXSS(contenido),LocalDate.now(), (String) sesion.getAttribute("usuario"));

                            db.insertarEntrada(e);


                            mensage="Se ha creado el post";





                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                        mensage="Ha habido un error";
                    }
                }
            String paginaWeb= run( req,  resp,sesion);
            PrintWriter out=resp.getWriter();

            paginaWeb+=pe.enviarToast("Crear entrada",mensage);
            paginaWeb+= Plantillas.cierreDocumento;
            paginaWeb=paginaWeb.replace("animate__animated","");
            out.println(paginaWeb);

        }else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }








    }

    private String run(HttpServletRequest req, HttpServletResponse resp, HttpSession sesion)throws ServletException, IOException {

        PlantillaEditor pe= new PlantillaEditor();

        String paginaWeb=pe.colocarCabecera("<link rel=\"stylesheet\" href=\"./css/aside.css\">");


        paginaWeb= colocarNav(sesion,paginaWeb,pe);
        paginaWeb+= Plantillas.crearEntrada;


        return paginaWeb;

    }

    private String colocarNav(HttpSession sesion, String paginaWeb, PlantillaEditor pe) {
        String usuario = (String) sesion.getAttribute("usuario");
        Integer admin = (Integer) sesion.getAttribute("admin");
        Integer avatar=(Integer) sesion.getAttribute("avatar");
        if (usuario != null) {

            if (admin==1) {
                paginaWeb+=pe.colocarAvatarnva1(avatar);
            } else {
                paginaWeb+=pe.colocarAvatarnva2(avatar);
            }

        } else {

            paginaWeb += Plantillas.nav3;
        }
        return paginaWeb;
    }

}