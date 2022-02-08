

function carga(){
    var loader =document.getElementById("loader")
    loader.classList.add("invisible")

    document.getElementById("cuerpo").style.background="none"
    document.getElementById("loader2").classList.remove("invisible")
    setTimeout( function(){window.location.replace("/blog/inicio")}, 3000);
    

}
document.addEventListener('DOMContentLoaded', function(event) {

    setTimeout(carga, 3000);
     
});