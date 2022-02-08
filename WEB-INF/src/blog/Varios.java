package blog;

import javax.servlet.http.HttpSession;

public class Varios {

    public static Usuario generarUsuario(HttpSession sesion) {
        Usuario u= new Usuario();
        u.setNombre((String) sesion.getAttribute("usuario"));
        u.setAvatar((Integer) sesion.getAttribute("avatarº"));
        u.setAdmin((Integer) sesion.getAttribute("admin"));
        return u;
    }
    public static  String colocarNav(HttpSession sesion, String paginaWeb, PlantillaEditor pe) {
        String usuario = (String) sesion.getAttribute("usuario");
        Integer admin = (Integer) sesion.getAttribute("admin");
        Integer avatar=(Integer) sesion.getAttribute("avatar");
        if (usuario != null) {

            if (admin==1) {
                paginaWeb+=pe.colocarAvatarnva1(avatar);
            } else {

                paginaWeb+=pe.colocarAvatarnva2(avatar);
            }

        } else {

            paginaWeb += Plantillas.nav3;
        }
        return paginaWeb;
    }

}
