let num = numAleatorio();
let intentos = 0;
console.log(num)

function asignar(para, resultado) {
    let obj = document.querySelector(para);
    obj.innerHTML = resultado;
}

function intento() {
    
    let numUsu = parseInt(document.getElementById('entrada').value);
    intentos++;

    //num == numUsu ? asignar(p, "acertaste :D") : asignar(p, "Incorrecto");
    if(num == numUsu){
        asignar('p', `Felicidades acertaste en ${intentos} ${intentos == 1 ? "intento" : "intentos"}. ¡RECLAMA TU DULCE!`);
        document.getElementById('reiniciar').removeAttribute('disabled');
        
    } else if(numUsu > num){
        asignar('p', 'Incorrecto, el numero es menor')
    } else if(numUsu < num){
        asignar('p', 'Incorrecto, el numero es mayor')
    }

    limpiar();

    return;
}

function nuevo() {
    limpiar();
    num = numAleatorio();
    intentos = 0;
    asignar('p', 'Ingresa un Numero del 1 a 10');
    //document.getElementById('reiniciar').setAttribute('disabled');
    document.querySelector('#reiniciar').setAttribute('disabled', true);
}

function limpiar() {
    document.querySelector('#entrada').value = '';
    
}

function numAleatorio() {
    return Math.floor(Math.random() * 10) + 1;
}

asignar('h1', 'Adivina el número!')
asignar('p', 'Ingresa un Numero del 1 a 10: ')