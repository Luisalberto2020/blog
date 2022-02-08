package blog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;

public class ModificarEntrada extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {


        HttpSession sesion = req.getSession(false);
        String id= req.getParameter("idEntrada");




        if(sesion!=null){
            Usuario user=Varios.generarUsuario(sesion);
            PlantillaEditor pe= new PlantillaEditor();
            String mensage="faltan datos";

            if(id!=null ){


                    try {


                            BasedeDatos db= new BasedeDatos();

                            System.err.println("-----------"+id);
                            Optional<Entrada> entradaOp=db.findEntradaById(id);


                            if(entradaOp.isPresent()){
                                boolean permiso=false;

                                if(user.getAdmin()==0&&user.getNombre().equals(entradaOp.get().getAutor())){
                                    permiso=true;
                                }else{

                                    if(user.getAdmin()==1){
                                        permiso=true;
                                    }
                                }
                                System.err.println("-----------"+permiso);

                                if (permiso){


                                    String paginaWeb=pe.colocarCabecera("");


                                    paginaWeb= Varios.colocarNav(sesion,paginaWeb,pe);
                                    paginaWeb+= pe.actualizarEntrada(entradaOp.get());




                                    PrintWriter out=resp.getWriter();


                                    paginaWeb+= Plantillas.cierreDocumento;

                                    out.println(paginaWeb);
                                }else {
                                    resp.sendRedirect(req.getContextPath() + "/editormode");
                                }


                            }else{
                                resp.sendRedirect(req.getContextPath() + "/editormode");
                            }



                            mensage="Se ha creado el post";





                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());
                        mensage="Ha habido un error";
                    }
                }


        }else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }








    }


}