package blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class CrearUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nombre=req.getParameter("nombre");
        String pass=req.getParameter("pass");

        if (nombre !=null && pass!=null) {
            Usuario user= new Usuario();
            PlantillaEditor pe=new PlantillaEditor();

            user.setNombre(pe.evitarXSS(nombre));
            user.meterHash(pass);
            user.setAdmin(0);
            int avatar= (int) (Math.random()*32 + 1);

            user.setAvatar(avatar);

            BasedeDatos db= new BasedeDatos();
            try {
               Optional<Usuario>usuarioOp= db.findUsuarioById(user.getNombre());
               if (usuarioOp.isEmpty()){
                   db.insertarUsuario(user);
                   resp.sendRedirect(req.getContextPath() + "/login?mensage=Usuario%20Creado");
               }else{
                   resp.sendRedirect(req.getContextPath() + "/login?mensage=Usuario%20Existente");
               }




            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
        }


    }
}