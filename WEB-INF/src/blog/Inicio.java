package blog;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import javax.servlet.*;



import java.sql.SQLException;

import java.util.List;



public class Inicio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession sesion = req.getSession(false);

        String paginaWeb = "";

        PlantillaEditor pe = new PlantillaEditor();

       paginaWeb=pe.colocarCabecera("");

        if (sesion != null) {

            paginaWeb = Varios.colocarNav(sesion, paginaWeb, pe);

        } else {

            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                // Se buscan las cookies que se necesitan
                paginaWeb = ComprobacionCookies(req, resp, paginaWeb, pe, cookies);

            } else {
                paginaWeb += Plantillas.nav3;
            }


        }
        paginaWeb+= Plantillas.container;
        paginaWeb+= Plantillas.row;

        BasedeDatos db=new BasedeDatos();

        try {
            List<Entrada>entradas= db.findAllEntrada();

            for (Entrada entrada : entradas){

                paginaWeb+=pe.crearEntrada(entrada);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        paginaWeb+= Plantillas.cierreDiv;
        paginaWeb+= Plantillas.cierreDiv;

        paginaWeb += Plantillas.cierreDocumento;

        out.println(paginaWeb);
    }



    private String ComprobacionCookies(HttpServletRequest req, HttpServletResponse resp, String paginaWeb, PlantillaEditor pe, Cookie[] cookies) {
        String usuario = "";
        String pass = "";
        for (Cookie cookie : cookies) {

            boolean c1 = false, c2 = false;
            if (cookie.getName().equals("usuario")) {
                usuario = cookie.getValue();
                c1 = true;
            } else if (cookie.getName().equals("pass")) {
                pass = cookie.getValue();
                c2 = true;
            }
            // Se buscan el resto de cookies

            if (c1 && c2) {
                req.setAttribute("usuario", usuario);
                req.setAttribute("pass", pass);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
                try {
                    rd.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                paginaWeb += Plantillas.nav3;
            }

        }
        return paginaWeb;
    }
}
