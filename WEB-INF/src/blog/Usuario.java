package blog;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.util.Random;

public class Usuario {
    private String nombre;
    private String pass;
    private Integer admin;
    private Integer avatar;
    private String enlace;

    public Usuario() {
        nombre="";
        pass="";
        admin =0;
        avatar=1;
        enlace="";
    }

    public Usuario(String nombre, String pass, Integer permisoso, Integer avatar, String enlace) {
        this.nombre = nombre;
        this.pass = pass;
        this.admin = permisoso;
        this.avatar = avatar;
        this.enlace = enlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equal(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer permisoso) {
        this.admin = permisoso;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", pass='" + pass + '\'' +
                ", admin=" + admin +
                ", avatar=" + avatar +
                ", enlace='" + enlace + '\'' +
                '}';
    }
    public static final  String generarHash(String pass){
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(pass, Charsets.UTF_8);
        HashCode sha256 = hasher.hash();

        return sha256.toString();
    }
    public void meterHash(String pass){
        if(pass!=null && !pass.equals("")){
            this.pass=generarHash(pass);
        }

    }

    public static String generarEnlace(){
        float random = new Random().nextFloat();
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(String.valueOf(random), Charsets.UTF_8);
        HashCode sha256 = hasher.hash();
        return sha256.toString();


    }
    public  void meterEnlace(){
        enlace=generarEnlace();
    }

}
