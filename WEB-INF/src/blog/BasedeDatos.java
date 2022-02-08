package blog;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static blog.Plantillas.entrada;

public class BasedeDatos {

    private Connection conn;
    private static final String URL = "jdbc:sqlite:../base_datos.db";
    private static final String DB = "org.sqlite.JDBC";


    public BasedeDatos() {
    }

    public void abrirConexion() {
        try {


            // Se crea la conexión a la base de datos:
            Class.forName(DB)
                    .getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(URL);


        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection conn = null;

        File fichero = new File(DB);

        if (fichero.exists()) {
            fichero.delete();
        }
        try {


            // Se crea la conexión a la base de datos:
            Class.forName("org.sqlite.JDBC")
                    .getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(URL);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (conn != null) {
                // Se crea la tabla si no existe


                // Se cierra la conexión con la base de datos
                conn.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void executeCreate(String sql) {
        abrirConexion();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cerrarConexion();
    }

    public Usuario acedeLogin(Usuario u) throws SQLException {


        abrirConexion();


        String sqlSelect = "SELECT usuario, admin,avatar FROM usuarios WHERE usuario=? AND password=?";
        Usuario usuario2 = null;
        // Se hace una consulta

        PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
        pstmt.setString(1, u.getNombre());
        pstmt.setString(2, u.getPass());
        ResultSet cursor = pstmt.executeQuery();

        if (cursor.next()) {
            String usuariobd = cursor.getString("usuario");
            Integer admin = cursor.getInt("admin");
            Integer avatar = cursor.getInt("avatar");
            usuario2 = new Usuario();
            usuario2.setNombre(usuariobd);
            usuario2.setAdmin(admin);
            usuario2.setAvatar(avatar);

        }


        cerrarConexion();


        return usuario2;

    }

    public void insertarUsuario(Usuario usuario) throws SQLException {
        abrirConexion();


        String sqlInsert =
                "INSERT INTO usuarios(usuario, password,admin,avatar) VALUES(?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sqlInsert);


        pstmt.setString(1, usuario.getNombre());
        pstmt.setString(2, usuario.getPass());
        pstmt.setInt(3, usuario.getAdmin());
        pstmt.setInt(4, usuario.getAvatar());
        pstmt.executeUpdate();

        cerrarConexion();
    }

    public void insertarEntrada(Entrada e) throws SQLException {
        abrirConexion();
        Statement stmt = conn.createStatement();
        String sqlInsert =
                "INSERT INTO entradas(titulo, texto,fecha,autor) VALUES(?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sqlInsert);

        pstmt.setString(1, e.getTitulo());
        pstmt.setString(2, e.getTexto());
        pstmt.setDate(3, Date.valueOf(e.getFecha()));

        pstmt.setString(4, e.getAutor());
        pstmt.executeUpdate();


        cerrarConexion();
    }

    public List<Entrada> findAllEntrada() throws SQLException {
        abrirConexion();
        String sqlSelect = "SELECT * FROM entradas";
        Statement stmt = conn.createStatement();
        ResultSet cursor = stmt.executeQuery(sqlSelect);
        ArrayList<Entrada> result = new ArrayList<>();

        while (cursor.next()) {

            Entrada e = new Entrada();
            e.setId(cursor.getInt("id"));
            e.setTitulo(cursor.getString("titulo"));
            e.setTexto(cursor.getString("texto"));
            e.setFecha(LocalDate.parse(cursor.getDate("fecha").toString()));
            e.setAutor(cursor.getString("autor"));
            result.add(e);


        }

        cerrarConexion();

        return result;

    }

    public List<Entrada> findEntradaByAutor(String autor) throws SQLException {

        abrirConexion();
        List<Entrada> entradas = new ArrayList<>();
        String sqlselect = "SELECT * FROM entradas WHERE autor LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sqlselect);
        stmt.setString(1, autor);
        ResultSet cursor = stmt.executeQuery();

        while (cursor.next()) {
            Entrada e = new Entrada();
            e.setId(cursor.getInt(1));
            e.setTitulo(cursor.getString("titulo"));

            e.setTexto(cursor.getString("texto"));
            e.setFecha(LocalDate.parse(cursor.getDate("fecha").toString()));
            e.setAutor(cursor.getString("autor"));
            System.out.println("----------------------" + e);
            entradas.add(e);

        }


        cerrarConexion();

        return entradas;

    }

    public Optional<Entrada> findEntradaById(String id) throws SQLException {
        abrirConexion();
        Optional<Entrada> entrada = Optional.empty();
        Entrada e = new Entrada();
        String sqlselect = "SELECT * FROM entradas WHERE id =?";
        PreparedStatement stmt = conn.prepareStatement(sqlselect);
        stmt.setString(1, id);
        ResultSet cursor = stmt.executeQuery();

        if (cursor.next()) {
            e.setId(cursor.getInt(1));
            e.setTitulo(cursor.getString("titulo"));

            e.setTexto(cursor.getString("texto"));
            e.setFecha(LocalDate.parse(cursor.getDate("fecha").toString()));
            e.setAutor(cursor.getString("autor"));
            System.out.println("----------------------" + e);
            entrada = Optional.of(e);
        }
        cerrarConexion();
        System.out.println(entrada.get());

        return entrada;

    }

    public void deleteEntrada(String id) throws SQLException {
        abrirConexion();
        String sqlselect = "DELETE FROM entradas WHERE id =?";
        PreparedStatement stmt = conn.prepareStatement(sqlselect);
        stmt.setString(1, id);
        stmt.executeUpdate();
        cerrarConexion();
    }

    public void updateEntrada(Entrada e) throws SQLException {
        abrirConexion();

        String sqlUpdate = "UPDATE entradas SET " +
                "titulo=?," +
                "texto=?," +
                "fecha=?," +
                "autor=? " +
                " WHERE id =?";
        PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
        stmt.setString(1, e.getTitulo());
        stmt.setString(2, e.getTexto());
        stmt.setDate(3, Date.valueOf(e.getFecha().toString()));
        stmt.setString(4, e.getAutor());
        stmt.setInt(5, e.getId());
        stmt.executeUpdate();

        cerrarConexion();
    }

    public Optional<Usuario> findUsuarioById(String id) throws SQLException {

        abrirConexion();
        Optional<Usuario> usuario = Optional.empty();
        Usuario u = new Usuario();
        String sqlselect = "SELECT * FROM usuarios WHERE usuario =?";
        PreparedStatement stmt = conn.prepareStatement(sqlselect);
        stmt.setString(1, id);
        ResultSet cursor = stmt.executeQuery();

        if (cursor.next()) {
            u.setNombre(cursor.getString("usuario"));
            u.setAdmin(cursor.getInt("admin"));
            u.setAvatar(cursor.getInt("avatar"));
            u.setEnlace(cursor.getString("enlace"));
            u.setPass(cursor.getString("password"));

            usuario = Optional.of(u);
        }
        cerrarConexion();


        return usuario;

    }

    public boolean actualizarUsuario(Usuario user) throws SQLException {
        abrirConexion();

        String sqlselect = "UPDATE usuarios " +
                "SET password = ?, " +
                "avatar=?, " +
                "admin=?, " +
                "enlace=? " +

                "WHERE usuario LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sqlselect);
        stmt.setString(1, user.getPass());
        stmt.setInt(2, user.getAvatar());
        stmt.setInt(3, user.getAdmin());
        stmt.setString(4, user.getEnlace());
        stmt.setString(5, user.getNombre());
        boolean exto = false;

        if (stmt.executeUpdate() > 0) {
            exto = true;
        }

        cerrarConexion();
        return exto;

    }

    public boolean deleteUser(String id) throws SQLException {
        abrirConexion();
        boolean exito = false;
        String sqlselect = "DELETE FROM usuarios WHERE usuario =?";
        PreparedStatement stmt = conn.prepareStatement(sqlselect);
        stmt.setString(1, id);
        if (stmt.executeUpdate() > 0) {
            exito = true;
        }
        cerrarConexion();
        return exito;
    }

    public List<Usuario> findAllUsuarios() throws SQLException {
        abrirConexion();

        List<Usuario> list = new ArrayList<Usuario>();
        String sqlSelect = "SELECT * FROM usuarios";
        Statement stmt = conn.createStatement();
        ResultSet cursor = stmt.executeQuery(sqlSelect);


        while (cursor.next()) {
            Usuario u = new Usuario();
            u.setNombre(cursor.getString("usuario"));
            u.setAdmin(cursor.getInt("admin"));
            u.setAvatar(cursor.getInt("avatar"));
            u.setEnlace(cursor.getString("enlace"));
            u.setPass(cursor.getString("password"));
            list.add(u);

        }
        cerrarConexion();
        return list;
    }
}