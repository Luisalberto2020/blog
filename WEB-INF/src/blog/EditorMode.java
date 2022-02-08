package blog;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EditorMode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession sesion = req.getSession(false);
        PrintWriter out = resp.getWriter();

        redirecionearALLogin(resp,sesion,req);

        Usuario usuario=Varios.generarUsuario(sesion);
        System.out.println(usuario);
        List<Entrada> listaEntrada=new ArrayList<>();
        BasedeDatos db= new BasedeDatos();
        if (sesion!=null) {
            if(usuario.getAdmin()==1){


                try {
                    listaEntrada=db.findAllEntrada();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                try {
                    listaEntrada=db.findEntradaByAutor(usuario.getNombre());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }


        String paginaWeb="";
        PlantillaEditor pe= new PlantillaEditor();
        paginaWeb=pe.colocarCabecera("");
        paginaWeb=Varios.colocarNav(sesion,paginaWeb,pe);
        String mensage=req.getParameter("message");
        if(mensage!=null){
            paginaWeb+=pe.enviarAlert(mensage);
        }


        paginaWeb+=pe.container;
        paginaWeb+=pe.row;
        for(Entrada entrada:listaEntrada){

            paginaWeb+=pe.crearEntradaEditable(entrada);
        }
        paginaWeb+=pe.cierreDiv;
        paginaWeb+=pe.cierreDiv;
        paginaWeb+=pe.cierreDocumento;
        out.println(paginaWeb);




    }



    private void redirecionearALLogin(HttpServletResponse resp, HttpSession sesion, HttpServletRequest req) throws IOException {

        if(sesion ==null){
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

}
