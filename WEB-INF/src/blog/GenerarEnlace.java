package blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class GenerarEnlace extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        boolean exito=false;

        if (session!=null) {
            Usuario u= Varios.generarUsuario(session);
            String usuario=req.getParameter("id");
            if(usuario!=null){
                if (u.getAdmin()==1|| u.getNombre().equals(usuario)){
                    BasedeDatos db= new BasedeDatos();
                    try {
                        Optional<Usuario> usuariodb=db.findUsuarioById(usuario);
                        if(usuariodb.isPresent()){
                            usuariodb.get().meterEnlace();
                            db.actualizarUsuario(usuariodb.get());
                            exito=true;

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
        if (exito){
            resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=Enlace%20Generado");
        }else{
            resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=Enlace%20no%20Generado");
        }


    }
}
