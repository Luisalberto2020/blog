package blog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class ActualizarPerfilDB extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession sesion=req.getSession(false);
        if(sesion!=null){
            Usuario user=Varios.generarUsuario(sesion);
            Usuario userParam= null;
            try {
                userParam = generarUsuarioParam(req);
                System.out.println("usuario sesion"+user);

                if (userParam!=null) {
                    if(user.getAdmin()==1|| user.getNombre().equals(userParam.getNombre())){
                        BasedeDatos db =  new BasedeDatos();


                        boolean exito= db.actualizarUsuario(userParam);
                        if (exito) {
                            if (user.getNombre().equals(userParam.getNombre())) {
                                sesion.setAttribute("avatar",userParam.getAvatar());
                            }
                            resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=pefil%20actualizado");
                        }else {
                            resp.sendRedirect(req.getContextPath() + "/editaruser?mensage=Perfil%20no%20actualizado");
                        }
                    }else {
                        resp.sendRedirect(req.getContextPath() + "/inicio");
                    }
                }else {
                    resp.sendRedirect(req.getContextPath() + "/inicio");
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }





        }else{

        }

    }

    private Usuario generarUsuarioParam(HttpServletRequest req) throws SQLException {

        BasedeDatos db=new BasedeDatos();

        Usuario u= null;
        String usuraioname=req.getParameter("id");
        String avatar=req.getParameter("avatar");


        if(usuraioname!=null&&avatar!=null) {


            Optional<Usuario> userDb = db.findUsuarioById(usuraioname);
            if(userDb.isPresent()){
                u= new Usuario();
                String pass=req.getParameter("password");
                if(pass!=null&& !pass.equals("")){
                    u.meterHash(pass);
                }else{
                    u.setPass(userDb.get().getPass());
                }

                u.setAvatar(Integer.valueOf(avatar));
                u.setNombre(usuraioname);
                u.setAdmin(userDb.get().getAdmin());
                u.setEnlace(userDb.get().getEnlace());

            }



        }



        System.out.println("Usuario param: " +u);
        return  u;
    }


}
