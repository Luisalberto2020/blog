package blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class ActualizarEntradaBD extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession(false);

        if(session!=null){
            Entrada e= crearEntrada(req);
            Usuario u=crearUsuario(session);
            BasedeDatos db= new BasedeDatos();

            try {
                Optional<Entrada> entradabd=db.findEntradaById(e.getId().toString());
                boolean puede=false;
                if (entradabd.isPresent()&&e!=null) {
                    if(u.getAdmin()==1){
                        puede=true;
                    }else{
                        if(u.getNombre().equals(entradabd.get().getAutor())){
                            puede=true;
                        }
                    }

                    e.setAutor(entradabd.get().getAutor());
                    e.setFecha(LocalDate.now());
                    if(puede){
                        db.updateEntrada(e);
                        resp.sendRedirect(req.getContextPath() + "/editormode?message=Mensage%20Actualizado");
                    }else{
                        resp.sendRedirect(req.getContextPath() + "/editormode?message=No%20se%20ha%20actualizado");
                    }


                } else {
                    resp.sendRedirect(req.getContextPath() + "/editormode?message=No%20tienes%20permisos");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }

    }

    private Entrada crearEntrada(HttpServletRequest req) {
        PlantillaEditor pe= new PlantillaEditor();
        Entrada e= null;
        String titulo=req.getParameter("titulo");
        String texto=req.getParameter("texto");
        String id=req.getParameter("idEntrada");

        if (id!=null&&texto!=null&&id!=null) {
            e= new Entrada();
            e.setTitulo(pe.evitarXSS(titulo));
            e.setTexto(pe.evitarXSS(texto ));
            e.setId(Integer.valueOf(id));
        }


        return e;

    }

    private Usuario crearUsuario(HttpSession sesion) {


        Usuario user= new Usuario();
        user.setNombre((String) sesion.getAttribute("usuario"));
        user.setAvatar((Integer) sesion.getAttribute("avatar"));
        user.setAdmin((Integer)sesion.getAttribute("admin"));
        return user;

    }

}