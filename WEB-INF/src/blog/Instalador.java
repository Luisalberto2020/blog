package blog;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.SQLException;





public class Instalador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        PlantillaEditor plantillaEditor = new PlantillaEditor();
        String titulo = "Instalacion completada";
        String message = "En unos segundos se redirecionara al blog";
        boolean bdCreado = false;

/*
        Connection conn = null;
        StringBuffer respuesta = new StringBuffer();
        File fichero = new File("../base_datos.db");

        if (fichero.exists()) {
            fichero.delete();
        }
        try {

            String url = "jdbc:sqlite:../base_datos.db";
            // Se crea la conexión a la base de datos:
            Class.forName("org.sqlite.JDBC")
                    .getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url);
            String consulta1 =
                    "CREATE TABLE IF NOT EXISTS usuarios (usuario TEXT PRIMARY KEY , password TEXT,admin INTEGER,avatar INTEGER,enlace TEXT)";
            String consulta2 =
                    "CREATE TABLE IF NOT EXISTS entradas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "titulo TEXT,texto TEXT" +
                            ",fecha DATE," +
                            "autor TEXT," +
                            "FOREIGN KEY (autor)\n" +
                            "       REFERENCES usuarios (usuario)" +
                            " ON UPDATE NO ACTION" +
                            " ON UPDATE NO ACTION " +
                            ")";
            Statement stmt = conn.createStatement();
            stmt.execute(consulta1);
            stmt.execute(consulta2);

            String pass = "admin";
            Hasher hasher = Hashing.sha256().newHasher();
            hasher.putString(pass, Charsets.UTF_8);
            HashCode sha256 = hasher.hash();
            String sqlInsert =
                    "INSERT INTO usuarios(usuario, password,admin,avatar) VALUES(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInsert);


            pstmt.setString(1, pass);
            pstmt.setString(2, sha256.toString());
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();


        } catch (Exception e) {
            titulo = e.toString();
            message = "";
        } finally {
            try {
                if (conn != null) {
                    // Se crea la tabla si no existe


                    // Se cierra la conexión con la base de datos
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }*/
        BasedeDatos db= new BasedeDatos();

        String consulta1 =
                "CREATE TABLE IF NOT EXISTS usuarios (usuario TEXT PRIMARY KEY , password TEXT,admin INTEGER,avatar INTEGER,enlace TEXT)";
        String consulta2 =
                "CREATE TABLE IF NOT EXISTS entradas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "titulo TEXT,texto TEXT" +
                        ",fecha DATE," +
                        "autor TEXT," +
                        "FOREIGN KEY (autor)\n" +
                        "       REFERENCES usuarios (usuario)" +
                        " ON UPDATE NO ACTION" +
                        " ON UPDATE NO ACTION " +
                        ")";
        db.executeCreate(consulta1);
        db.executeCreate(consulta2);
        Usuario usuario= new Usuario("admin",Usuario.generarHash("admin"),1,1,"");
        try {
            db.insertarUsuario(usuario);
            titulo="Se ha creado correctamente";
            message="Se redicrecionara";
        } catch (SQLException e) {
            e.printStackTrace();
            titulo="error";
            message=e.getMessage();
        }
        try {

            out.println(plantillaEditor.paginaInstalador(titulo, message));
        } catch (Exception e) {
            //TODO: handle exception
            out.println(e);
        }


    }
}
