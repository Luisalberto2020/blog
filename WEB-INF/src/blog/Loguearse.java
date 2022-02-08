package blog;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Loguearse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String usuario = req.getParameter("usuario");
        String pass = req.getParameter("password");
        String recordar;

             recordar= req.getParameter("recordar");

        if(usuario==null || pass==null){
            resp.sendRedirect(req.getContextPath() + "/login?mensage=Faltan%20Datos");
        }else{




            BasedeDatos db=new BasedeDatos();
            Usuario u= new Usuario();
            u.setNombre(usuario);
            u.meterHash(pass);
            System.err.println("----------"+u);

            Usuario usuariodb= null;
            try {
                usuariodb = db.acedeLogin(u);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            if(usuariodb!=null){
                HttpSession sesion = req.getSession(true);
                sesion.setAttribute("usuario",usuariodb.getNombre());
                sesion.setAttribute("admin",usuariodb.getAdmin());
                sesion.setAttribute("avatar",usuariodb.getAvatar());
                resp.sendRedirect(req.getContextPath() + "/inicio");
                crearCookie(resp, usuariodb.getNombre(),usuariodb.getPass());
            }else{
                System.err.println("nulllllllll");
                resp.sendRedirect(req.getContextPath() + "/login?mensage=Error%20de%20Credenciales");
            }
            }

        }





    private void crearCookie(HttpServletResponse resp, String usuario, String pass) {

        System.err.println("----------------------------------------------sdsddsd");
        Cookie cookie2 = new Cookie("usuario",usuario );
        cookie2.setMaxAge(2592000);
        cookie2.setPath("/blog");
        resp.addCookie(cookie2);

        Cookie cookie1 = new Cookie("password",pass );
        cookie1.setMaxAge(2592000);
        cookie1.setPath("/blog");
        resp.addCookie(cookie1);
    }
}