package blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class UsuariosManagment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session=req.getSession();
        if (session != null) {
           Usuario user= Varios.generarUsuario(session);

           if(user.getAdmin()==1){
               BasedeDatos db= new BasedeDatos();
               try {
                   List<Usuario> usuarios=db.findAllUsuarios();
                   String pagina=inprimirPagina(session,usuarios);
                   PrintWriter out= resp.getWriter();

                   out.println(pagina);
               } catch (SQLException e) {
                   e.printStackTrace();
               }

           }
        }
    }

    private String inprimirPagina(HttpSession session, List<Usuario> usuarios) {
        String pagina="";
        PlantillaEditor pe= new PlantillaEditor();
        pagina+=pe.colocarCabecera("");
        pagina=Varios.colocarNav(session,pagina,pe);
        pagina+=pe.crearTablaUser(usuarios);
        pagina+=pe.cierreDocumento;

        return pagina;
    }


}
