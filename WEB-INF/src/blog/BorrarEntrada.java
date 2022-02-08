package blog;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class BorrarEntrada extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        HttpSession sesion = req.getSession(false);
        boolean puedeBorrar=false;



        if(sesion!=null){

            
            String id=req.getParameter("idEntrada");
            if (id!=null) {
                Usuario user=recogerUsuario(sesion);

                BasedeDatos db= new BasedeDatos();
                if(user.getAdmin()==0){
                    

                    Optional<Entrada> optionalEntrada;

                    optionalEntrada=buscarEntrada(id, db);


                    if(!optionalEntrada.isEmpty()&&optionalEntrada.get().getAutor().equals(user.getNombre())){
                             puedeBorrar=true;
                    }
                }else {
                    puedeBorrar=true;

                }

                if(puedeBorrar){
                    try {
                        db.deleteEntrada(id);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            resp.sendRedirect(req.getContextPath() + "/editormode?message=Mensaje%20Borrado");

        }else{

            resp.sendRedirect(req.getContextPath() + "/login?mensage=Debes%20estarLogueado");
        }


    }

    private Optional<Entrada> buscarEntrada(String id, BasedeDatos db) {
        Optional<Entrada> optionalEntrada = Optional.empty();
        try {
             optionalEntrada= db.findEntradaById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalEntrada;
    }

    private Usuario recogerUsuario(HttpSession sesion) {
        String usuario = (String) sesion.getAttribute("usuario");
        Integer admin = (Integer) sesion.getAttribute("admin");
        Integer avatar=(Integer) sesion.getAttribute("avatar");
        Usuario user=new Usuario();
        user.setNombre(usuario);
        user.setAdmin(admin);
        user.setAvatar(avatar);
        return user;
    }
}

