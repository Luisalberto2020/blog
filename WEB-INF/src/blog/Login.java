package blog;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String mensage = req.getParameter("mensage");

            if (mensage==null){
                mensage="";
            }



            PlantillaEditor pe= new PlantillaEditor();
            PrintWriter out = resp.getWriter();

            out.println(pe.LoginFormEdited(pe.evitarXSS(mensage)));





    }
    }