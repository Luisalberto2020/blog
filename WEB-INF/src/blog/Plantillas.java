package blog;
public class Plantillas{

    public static final String pageInstalador="""
    <!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="shortcut icon" href="./images/titulo.png">
    
   
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link rel="stylesheet" href="./css/instalador.css">
    


    <title>Hidra</title>
</head>

<body id="cuerpo">
    <script src="https://kit.fontawesome.com/e9c7fcf4be.js" crossorigin="anonymous"></script>
    <script src="./js/header.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <div class="container animate__animated animate__backInUp  " id="loader">
        <br/><br/>
        <div class="row">

            <h3 class="h3 text-white justify-content-center text-center">Instalando</h3>
        </div>
        
        <div class="row">
            <div class="col-md-12">
                <div class="preloader2">
                    <div class="box1"></div>
                    <div class="box2"></div>
                    <div class="box3"></div>
                    <div class="box4"></div>
                </div>
            </div>
        </div>
        <br/><br/>
    </div>
    <script src="js/loader.js"></script>


    <div class="container invisible"id="loader2">
        <div class="row">

            <img src="./images/logoGrande.png" id="logoGrande" alt="logo" class="rounded mx-auto d-block" alt="">
        </div>

        <div class="row " >
            <h2 class="h2 text-center">$tituloInstalador$</h3>

        </div>
        <div class="row " >
            <h3 class="h3 text-center">$mensageInstalador$</h3>

        </div>
    </div>


    
</body>
</html>
    """;


    public static final String Cabeceras="""
            <!DOCTYPE html>
            <html lang="es">
                
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                <link rel="shortcut icon" href="./images/titulo.png">
                <link rel="stylesheet" href="./css/header.css">
                
                    <link
                            rel="stylesheet"
                            href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
                          />
                $css$
                
                
                
                <title>Hidra</title>
            </head>
                
            <body>
                <script src="https://kit.fontawesome.com/e9c7fcf4be.js" crossorigin="anonymous"></script>
                <script src="./js/header.js"></script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
               
                <header>
            """;

    public static final String nav1="""

        <!-- Sidebar -->
        <nav
             id="sidebarMenu"
             class="collapse d-lg-block sidebar collapse bg-white"
             >
          <div class="position-sticky">
            <div class="list-group list-group-flush mx-3 mt-4">
              <a
                 href="#"
                 class="list-group-item list-group-item-action py-2 ripple"
                 aria-current="true"
                 >
                <i class="fas fa-tachometer-alt fa-fw me-3"></i
                  ><span>Inicio</span>
              </a>

              <a
              href="/blog/inicio"
              class="list-group-item list-group-item-action py-2 ripple"
              aria-current="true"
              >
              <i class="fas fa-sticky-note fa-fw me-3 "></i><span>Blog</span>
           </a>
           <a
           href="/blog/crearentrada"
           class="list-group-item list-group-item-action py-2 ripple"
           aria-current="true"
           >
          <i class="fas fa-pen fa-fw me-3"></i
            ><span>Crear Entrada</span>
        </a>

        <a
        href="/blog/editormode"
        class="list-group-item list-group-item-action py-2 ripple"
        aria-current="true"
        >
       <i class="fas fa-edit fa-fw me-3"></i
         ><span>Modo edicion </span>
     </a>
     <br><br><br><br><br>
     Modo Admin
     <hr />
     <!-- Modo admin -->

     <a
     href="/blog/usuarios"
     class="list-group-item list-group-item-action py-2 ripple"
     aria-current="true"
     >
    <i class="fas fa-users fa-fw me-3"></i
      ><span>Usuarios</span>
  </a>
             
           
                
            </div>
          </div>
        </nav>
        <!-- Sidebar -->
      
        <!-- Navbar -->
        <nav
             id="main-navbar"
             class="navbar navbar-expand-lg navbar-light bg-white fixed-top"
             >
          <!-- Container wrapper -->
          <div class="container-fluid">
            <!-- Toggle button -->
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#sidebarMenu"
                    aria-controls="sidebarMenu"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
              <i class="fas fa-bars"></i>
            </button>
      
            <!-- Brand -->
            <a class="navbar-brand" href="/blog/inicio">
              <img
                   src="./images/titulo.png"
                   height="25"
                   alt=""
                   loading="lazy"
                   />  Hidra
            </a>
            <!-- Search form -->
            <form class="d-none d-md-flex input-group w-auto my-auto">
              <input
                     autocomplete="off"
                     type="search"
                     class="form-control rounded"
                     id="busqueda"
                     placeholder='Search (ctrl + "/" to focus)'
                     
                     />
              <span class="input-group-text border-0"
                    ><i class="fas fa-search"></i
                ></span>
            </form>
      
            <!-- Right links -->
            <ul class="navbar-nav ms-auto d-flex flex-row">
              
              <li class="nav-item dropdown">
                <a
                   class="nav-link me-3 me-lg-0 dropdown-toggle hidden-arrow"
                   href="#"
                   id="navbarDropdownMenuLink"
                   role="button"
                   data-mdb-toggle="dropdown"
                   aria-expanded="false"
                   >
                  <i class="fas fa-bell"></i>
                  <span class="badge rounded-pill badge-notification bg-danger"
                        >1</span
                    >
                </a>
              
              </li>
      
              <!-- Icon -->
             
      
              <!-- Icon dropdown -->
             
      
              <!-- Avatar -->
             <!--  <li class="nav-item dropdown">
                <a
                   class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center"
                   href="#"
                   id="navbarDropdownMenuLink"
                   role="button"
                   data-mdb-toggle="dropdown"
                   aria-expanded="false"
                   >
                  <img
                       src="https://mdbootstrap.com/img/Photos/Avatars/img ($avatar$).jpg"
                       class="rounded-circle"
                       height="22"
                       alt=""
                       loading="lazy"
                       />
                </a>
                <ul
                    class="dropdown-menu dropdown-menu-end"
                    
                    >
                  <li><a class="dropdown-item" href="#">Mi perfil</a></li>
                  <li><a class="dropdown-item" href="#">Opciones</a></li>
                  <li><a class="dropdown-item" href="/blog/aciones/cerrarsesion">Cerrar Sesion</a></li>
                </ul>
              </li> -->
              <div class="dropdown ">
                <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">
                 <img
                 src="https://mdbootstrap.com/img/Photos/Avatars/img ($avatar$).jpg"
                 class="rounded-circle"
                 height="22"
                 alt=""
                 loading="lazy
                  aria-expanded="false"
                  >
                   <span class="caret"></span>
                </button>
                <div class="dropdown-menu dropdown-menu-right " aria-labelledby="dropdownMenuButton">
                  <a class="dropdown-item" href="/blog/editaruser">Editar Perfil</a>
                  <a class="dropdown-item" href="/blog/aciones/cerrarsesion">Cerrar Sesion</a>
                  
                </div>
              </div>
         
              <!-- Icon -->
              <li class="nav-item me-3 me-lg-0">
                <a class="nav-link" href="https://github.com/Luisalberto2020">
                  <i class="fab fa-github"></i>
                </a>
              </li>


            </ul>
          </div>
          <!-- Container wrapper -->
        </nav>
        <!-- Navbar -->
      </header>
      <!--Main Navigation-->
      
      <!--Main layout-->
      <main style="margin-top: 58px;margin-left:200px">
        
    """;

    public static final String nav2="""
<nav
             id="sidebarMenu"
             class="collapse d-lg-block sidebar collapse bg-white"
             >
          <div class="position-sticky">
            <div class="list-group list-group-flush mx-3 mt-4">
              <a
                 href="#"
                 class="list-group-item list-group-item-action py-2 ripple"
                 aria-current="true"
                 >
                <i class="fas fa-tachometer-alt fa-fw me-3"></i
                  ><span>Inicio</span>
              </a>

              <a
              href="/blog/inicio"
              class="list-group-item list-group-item-action py-2 ripple"
              aria-current="true"
              >
              <i class="fas fa-sticky-note fa-fw me-3 "></i><span>Blog</span>
           </a>
           <a
           href="/blog/crearentrada"
           class="list-group-item list-group-item-action py-2 ripple"
           aria-current="true"
           >
          <i class="fas fa-pen fa-fw me-3"></i
            ><span>Crear Entrada</span>
        </a>

        <a
        href="/blog/editormode"
        class="list-group-item list-group-item-action py-2 ripple"
        aria-current="true"
        >
       <i class="fas fa-edit fa-fw me-3"></i
         ><span>Modo edicion </span>
     </a>
  
             
           
                
            </div>
          </div>
        </nav>
        <!-- Sidebar -->
      
        <!-- Navbar -->
        <nav
             id="main-navbar"
             class="navbar navbar-expand-lg navbar-light bg-white fixed-top"
             >
          <!-- Container wrapper -->
          <div class="container-fluid">
            <!-- Toggle button -->
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#sidebarMenu"
                    aria-controls="sidebarMenu"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
              <i class="fas fa-bars"></i>
            </button>
      
            <!-- Brand -->
            <a class="navbar-brand" href="/blog/inicio">
              <img
                   src="./images/titulo.png"
                   height="25"
                   alt=""
                   loading="lazy"
                   />  Hidra
            </a>
            <!-- Search form -->
            <form class="d-none d-md-flex input-group w-auto my-auto">
              <input
                     autocomplete="off"
                     type="search"
                     class="form-control rounded"
                     id="busqueda"
                     placeholder='Search (ctrl + "/" to focus)'
                     
                     />
              <span class="input-group-text border-0"
                    ><i class="fas fa-search"></i
                ></span>
            </form>
      
            <!-- Right links -->
            <ul class="navbar-nav ms-auto d-flex flex-row">
              
              <li class="nav-item dropdown">
                <a
                   class="nav-link me-3 me-lg-0 dropdown-toggle hidden-arrow"
                   href="#"
                   id="navbarDropdownMenuLink"
                   role="button"
                   data-mdb-toggle="dropdown"
                   aria-expanded="false"
                   >
                  <i class="fas fa-bell"></i>
                  <span class="badge rounded-pill badge-notification bg-danger"
                        >1</span
                    >
                </a>
              
              </li>
      
          
              <div class="dropdown ">
                <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">
                 <img
                 src="https://mdbootstrap.com/img/Photos/Avatars/img ($avatar$).jpg"
                 class="rounded-circle"
                 height="22"
                 alt=""
                 loading="lazy
                  aria-expanded="false"
                  >
                   <span class="caret"></span>
                </button>
                <div class="dropdown-menu dropdown-menu-right " aria-labelledby="dropdownMenuButton">
                  <a class="dropdown-item" href="/blog/editaruser">Editar Perfil</a>
                  <a class="dropdown-item" href="/blog/aciones/cerrarsesion">Cerrar Sesion</a>
                  
                </div>
              </div>
         
              <!-- Icon -->
              <li class="nav-item me-3 me-lg-0">
                <a class="nav-link" href="https://github.com/Luisalberto2020">
                  <i class="fab fa-github"></i>
                </a>
              </li>


            </ul>
          </div>
          <!-- Container wrapper -->
        </nav>
        <!-- Navbar -->
      </header>
      <!--Main Navigation-->
      
      <!--Main layout-->
     <main style="margin-top: 58px;margin-left:200px">
       

""";
public static final String nav3="""
   
        <!-- Sidebar -->
      
        <!-- Navbar -->
        <nav
             id="main-navbar"
             class="navbar navbar-expand-lg navbar-light bg-white fixed-top"
             >
          <!-- Container wrapper -->
          <div class="container-fluid">
            <!-- Toggle button -->
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#sidebarMenu"
                    aria-controls="sidebarMenu"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
              <i class="fas fa-bars"></i>
            </button>
      
            <!-- Brand -->
            <a class="navbar-brand" href="/blog/inicio">
              <img
                   src="./images/titulo.png"
                   height="25"
                   alt=""
                   loading="lazy"
                   />  Hidra
            </a>
            <!-- Search form -->
            <form class="d-none d-md-flex input-group w-auto my-auto">
              <input
                     autocomplete="off"
                     type="search"
                     class="form-control rounded"
                     id="busqueda"
                     placeholder='Search (ctrl + "/" to focus)'
                     
                     />
              <span class="input-group-text border-0"
                    ><i class="fas fa-search"></i
                ></span>
            </form>
      
            <!-- Right links -->
            <ul class="navbar-nav ms-auto d-flex flex-row">
              
              <li class="nav-item dropdown">
              <button type="button" id="btnh3"  class="btn btn-primary btn-lg" onclick="location.href = '/blog/login';">Iniciar sesion</button>
              
              </li>
      
          
            
         
              


            </ul>
          </div>
          <!-- Container wrapper -->
        </nav>
        <!-- Navbar -->
      </header>
      <!--Main Navigation-->
      
      <!--Main layout-->
      <main style="margin-top: 58px;margin-left:0px "  >
    """;

    public static final String cierreDocumento="""
    </main>
    </body>
    </html>
    """;
    public static  final String loginForm= """
                        
             <div class="container pt-4">
                        <div class="row">
                         \s
                          <div class="col-md-10 mx-auto p-0 col-xs-12 align-middle">
                            <div class="card animate__animated animate__zoomInLeft">
                                <div class="login-caja">
                                    <div class="login-snip"> <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Registro</label>
                                        <div class="login-espacio">
                                            <div class="login">
                                              <form action="/blog/aciones/login" method="post">
                                                <div class="group"> <label for="user" class="label">Usuario</label> <input id="user" type="text" class="input" placeholder="Introduczca tu usuario" name="usuario" required="required"> </div>
                                                <div class="group"> <label for="pass" class="label">Contraseña</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Introduzca la contraseña" name="password" required="required"> </div>
                                                <div class="group"> <input id="check" type="checkbox" class="check" checked name="recordar" value="true"> <label for="check"><span class="icon" ></span> Mantenme logeado 1 mes</label> </div>
                                                <div class="group"> <input type="submit" class="button" value="Entrar"> </div>
                                                <div class="hr"></div>
                                                <div class="foot"> 
                                                <h1 class="text-danger">$mensage$</h1>
                                                 </div>
                                              </form>
                                              \s
                                            </div>
                                            <div class="formu-regis">
                                              <form action="./aciones/registro" method="post">
                                                <div class="group"> <label for="user" class="label">Usuario</label> <input id="user" type="text" class="input" name="nombre" placeholder="NOMBRE DE USUARIO" required="required"> </div>
                                                <div class="group"> <label for="pass" class="label">Contraseña</label> <input id="pass" type="password" class="input" data-type="password" name="pass" placeholder="Crea la contrasña "required="required"> </div>
                                                <div class="group"> <label for="pass" class="label">Repite Contraseña</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Repite la contraseña" required="required"> </div>
                                                <div class="group"> <input type="submit" class="button" value="Entrar"> </div>
                                                <div class="hr"></div>
                                                <div class="foot"> <label for="tab-1">Atras</label>
                                                <h1 class="text-danger">$mensage$</h1>
                                                 </div>
                                              </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        
                        </div>
                 \s
                    </div>
                        
                        
            """;

    public static final String crearEntrada= """
            
            <div class="animate__animated animate__backInRight  container col-xs-12 col-lg-6 ">
                        <div class="row">
                          <form action="/blog/crearentrada" method="post">
                            <div class="form-group">
                              <label for="titulo"><h2>Titulo</h2> </label>
                              <input type="text" class="form-control" id="titulo"  name="titulo"  placeholder="Introduzaca el titulo">
                            \s
                            </div>
                            <div class="form-group mt-3">
                              <label for="" class="text-center"><h2 class="h2 ">Texto</h2></label>
                              <textarea name="texto" id="" cols="50" rows="20" class="form-control" placeholder="Escribe algo...."></textarea>
                            </div>
                          \s
                            <button type="submit" class="btn btn-primary mt-3 align-content-center">Crear</button>
                          </form>
                 \s
                    </div>
            """;

    public static final String UpdateEntrada= """
            
            <div class="animate__animated animate__backInRight  container col-xs-12 col-lg-6 ">
                        <div class="row">
                          <form action="/blog/aciones/actualizarEntrada" method="post">
                            <div class="form-group">
                              <label for="titulo"><h2>Titulo</h2> </label>
                              <input type="text" class="form-control" id="titulo"  name="titulo" value="$titulo$"  placeholder="Introduzaca el titulo">
                            \s
                            </div>
                            <div class="form-group mt-3">
                              <label for="" class="text-center"><h2 class="h2 ">Texto</h2></label>
                              <textarea name="texto" id="" cols="50" rows="20" class="form-control" placeholder="Escribe algo....">$texto$</textarea>
                            </div>
                          \s
                          <input type="hidden"  name="idEntrada" value="$id$">
                            <button type="submit" class="btn btn-primary mt-3 align-content-center">Actualizar</button>
                          </form>
                 \s
                    </div>
            """;
    public static final String toast= """
            <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
                      <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header">
                          <img src="./images/titulo.png" width="20px" class="rounded me-2" alt="...">
                          <strong class="me-auto">$titulo$</strong>
                          <small>1 seg antras</small>
                          <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                        <div class="toast-body">
                         $mensage$
                        </div>
                      </div>
                    </div>
            """;
    public static final String cierreDiv="</div>";
    public static final String row="<div class=\"row justify-content-md-left\">";
    public static final String container ="<div class=\"container \">";
    public static final String entrada= """
            <div class="card text-center  col-xxl-5 col-xl-12 m-3 animate__animated animate__bounceInUp">
                           <div class="card-header">$autor$</div>
                           <div class="card-body">
                             <h4 class="card-title">$titulo$</h4>
                             <p class="card-text">$texto$</p>
                            \s
                           </div>
                           <div class="card-footer text-muted">$fecha$</div>
                         </div>
            """;
    public static  final String entradaeditable= """
                        
                        
                          <div class="card text-center col-xxl-5 col-xl-12 m-3 animate__animated animate__bounceInUp">
                                          <div class="card-header">$autor$</div>
                                          <div class="card-body">
                                            <h4 class="card-title">$titulo$</h4>
                                            <p class="card-text">$texto$</p>
                                            <div class="container">
                                              <div class="row ">
                                                <form action="/blog/editarentrada" class="col-6" method="post">
                                                  <input type="hidden"  name="idEntrada" value="$id$">
                                                  <input type="submit" class="btn btn-primary"value="Editar">
                                                </form>
                                                <form action="/blog/aciones/eliminarentrada" class="col-6" method="post">
                                                  <input type="hidden"  name="idEntrada" value="$id$">
                          
                                                  <input type="submit" class="btn btn-danger"value="Borrar">
                                                </form>
                                              </div>
                                            </div>
                                          \s
                                           \s
                                           \s
                                          </div>
                                          <div class="card-footer text-muted">$fecha$</div>
                                        </div>
            """;
    public static final String alert= """
            <div class="alert alert-success text-center" role="alert">
              $message$
            </div>""";
    public static final String editarPerfil ="""
                      <div class="container d-flex justify-content-center align-items-center animate__animated animate__fadeInUpBig">
                         <form action="/blog/aciones/actualizarperfil" method="post">
                           <input type="hidden" name="id" value="$usuario$">
                           <div class="card py-4">
                             <h5 class="font-weight-normal text-center text-white">$usuario$</h5>
                             <div class="mt-3"> <span class="accounts text-white">Imagen</span>
                               <div class="d-flex justify-content-between p-2 outline"> <img
                                   src="https://mdbootstrap.com/img/Photos/Avatars/img ($avatar$).jpg" class="rounded" width="50">
                                 <div class="d-flex flex-column mr-1">
                                   <div class="d-flex flex-row">
                                     <select name="avatar" id="" class="form-select">
                                      $options$
                     
                                     </select>
                                     <input type="submit" value="Actualizar perfil" class="btn btn-primary btn-sm buttons ml-1">
                                   </div> <span class="image-size"></span>
                                 </div>
                               </div>
                             </div>
                             <div class="mt-3">
                     
                               <div class="row">
                                 <div class="col-md-12">
                                   <div class="inputbox mt-3"> <input type="password" name="password" class="form-control">
                                     <span>Contraseña</span> </div>
                                 </div>
                               </div>
                               <div class="row">
                                 <div class="col-md-12">
                                   <div class="inputbox mt-3"> <input type="password" class="form-control"> <span>Contraseña</span> </div>
                                 </div>
                               </div>
                               <div class="row">
                                 <div class="col-md-12">
                                   <a href="$enlace$" class="link-dark">Enlace de recuperacion de password</a>
                                 </div>
                               </div>
                               <div class="row ">
                     
                     
                                 <form action="/blog/aciones/enlace col-5" method="post">
                                   <input type="hidden" name="id" value="$usuario$">
                                   <input type="submit" value="Generar Enlace" class="btn btn-success m-2 btn-sm col-5">
                     
                                 </form>
                                 <form action="/blog/aciones/eliminarusuario"  method="post">
                                   <input type="hidden" name="id" value="$usuario$">
                                   <input type="submit" value="Eliminar" class="btn btn-danger btn-sm  col-5 mt-3">
                     
                                 </form>
                               </div>
                     
                     
                               </dic>
                     
                     
                             </div>
                           </div>
                           </div>
                         </form>
                     
                     
                         </div>
            """;
    public static final String tabal= """
             <div class="container animate__animated animate__backInUp ">
                    <div class="row">
                      <table class="table table-striped table-hover col-12">
                        <thead>
                          <tr>
                            <th scope="col">Avatar</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">admin</th>
                          \s
                          </tr>
                        </thead>
                        <tbody>
                          $columnas$
                          \s
                        </tbody>
                      </table>
                    </div>
                  </div>
            """;
    public  static  final String columna= """
              <tr>
                            <th>
                                 <img src="https://mdbootstrap.com/img/Photos/Avatars/img ($avatar$).jpg" alt="" class="rounded-circle" width="50px">
                                </th>
                                <td class="align-middle">$usuario$</td>
                                <td class="align-middle">$admin$</td>
                                <td class="align-middle">
                                    <form action="/blog/editaruser" method="post">
                                        <input type="hidden" name="id" value="$usuario$">
                                        <input type="submit" value="Editar" class="btn btn-primary">
                                    </form>
                                </td>
                            </tr>
            """;
}