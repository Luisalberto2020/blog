package blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class EliminarUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession sesion= req.getSession(false);

        if(sesion!=null){
            String username=req.getParameter("id");
            if (username!=null) {
                Usuario user=Varios.generarUsuario(sesion);
                if(user.getAdmin()==1||user.getNombre().equals(username)){

                    BasedeDatos db= new BasedeDatos();

                    try {
                       boolean exito= db.deleteUser(username);

                       if(exito){
                           if(user.getNombre().equals(username)){
                               resp.sendRedirect(req.getContextPath() + "/aciones/cerrarsesion");
                           }else{
                               resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=pefil%20eliminado");
                           }
                       }else{
                           resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=pefil%20no%20eliminado");
                       }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }else{
                    resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=pefil%20no%20eliminado");
                }
            }else {
                resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=pefil%20no%20eliminado");
            }
        }
    }

}
