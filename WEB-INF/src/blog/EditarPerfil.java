package blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;


public class EditarPerfil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession sesion= req.getSession(false);
        String message=req.getParameter("mensage");


        Usuario u= null;
        if (sesion!=null) {

            u=Varios.generarUsuario(sesion);
            System.out.println(u);
            run(req,resp,u.getNombre(),sesion,message);
        }else{
            resp.sendRedirect(req.getContextPath() + "/login?mensage=Debes%20Estar%20Logueado");
        }



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession sesion= req.getSession(false);
        if(sesion!=null){
            Usuario  user=new Usuario();
            user=Varios.generarUsuario(sesion);
            String usuario=req.getParameter("id");
            if(user.getAdmin()==1&& usuario!=null){

                run(req,resp,usuario,sesion,"");

            }else{
                resp.sendRedirect(req.getContextPath() + "/inicio");
            }
        }else {
            resp.sendRedirect(req.getContextPath() + "/login?mensage=Debes%20Estar%20Logueado");
        }

    }


    private void run(HttpServletRequest req, HttpServletResponse resp, String userId, HttpSession sesion, String message) {
        PlantillaEditor pe= new PlantillaEditor();

        BasedeDatos db= new BasedeDatos();
        try {
            Optional<Usuario> usuarioDb=db.findUsuarioById(userId);

            if(usuarioDb.isPresent()){

                String paginaWeb=pe.colocarCabecera(" <link rel=\"stylesheet\" href=\"./css/editarperfil.css\">");
                paginaWeb=Varios.colocarNav(sesion,paginaWeb,pe);
                if(message!=null){
                    paginaWeb+=pe.enviarAlert(message);
                }
                paginaWeb+=pe.editarPerfil(usuarioDb.get());
                paginaWeb+=pe.cierreDocumento;
                PrintWriter out= resp.getWriter();
                out.println(paginaWeb);


            }else{
                System.out.println("------------usuario fuera");
                resp.sendRedirect(req.getContextPath() + "/inicio");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


