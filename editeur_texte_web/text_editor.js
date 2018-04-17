var textEditor = document.getElementById("text-editor");
var apercu = document.getElementById("apercu");
var etat = -2; // stoker etat automate pour gerer coloration code
var couleur;
var nbLigne = 0;
var inputSaisis; // creation input dynamique pour saisis
var lastBalise; // stocker le dernier balise ouvert pour l'autocompletion
var conteneurNumLigne = document.getElementById("conteneur-num-ligne");

function genererInputSaisisAttrVal() {
    var newSaisis = [];
    newSaisis.push(document.createElement("input")); // input attr
    newSaisis.push(document.createElement("span")); // =
    newSaisis.push(document.createElement("span")); // "
    newSaisis.push(document.createElement("input")); // input val
    newSaisis.push(document.createElement("span")); // "
    newSaisis[0].classList.add("saisis-attr");
    newSaisis[0].type = "text";
    newSaisis[2].classList.add("delimiteur-val");
    newSaisis[3].classList.add("saisis-val");
    newSaisis[4].classList.add("delimiteur-val");
    newSaisis[1].appendChild(document.createTextNode("="));
    newSaisis[2].appendChild(document.createTextNode("\""));
    newSaisis[4].appendChild(document.createTextNode("\""));
    return newSaisis;
}

function genererInputBalise() {
    var newInput = document.createElement("input");
    newInput.classList.add("saisis-balise");
    return newInput;
}

window.onload = function () {
    textEditor.contentEditable = "true";

    /*************** GERER INSERTION NUM LIGNE ET DEBUT EDITION CODE ***********/
    textEditor.addEventListener("focus", function () {
        if (nbLigne == 0) {
            nbLigne++;
            document.execCommand("insertHTML", false, '<input class="saisis-cmd" style="border-radius:0;border:solid 1px red;color:red;width:20px;" type="text"/>');
            inputSaisis = textEditor.querySelector("input.saisis-cmd");
            inputSaisis.focus();
            inputSaisis.addEventListener("keyup", function (e) {
                if (e.key == "<") {
                    var span = document.createElement("span");
                    span.classList.add("chevron");
                    span.textContent = '<';
                    e.currentTarget.parentElement.replaceChild(span, e.currentTarget);
                    var newInput = genererInputBalise();
                    var next = span.nextElementSibling;
                    if (next != null) {
                        textEditor.insertBefore(newInput, next);
                    } else {
                        textEditor.appendChild(newInput);
                    }
                    etat = 0;
                    inputSaisis = textEditor.querySelector("input.saisis-balise");
                    inputSaisis.focus();

                }
            }, false);
        }
    }, false);

    textEditor.addEventListener("keydown", function (e) { // OUVERTURE NOUVELLE BALISE APRES FOCUS
        if (e.key == "<" && etat != -2) {
            document.execCommand("insertHTML", false, '<input class="saisis-cmd" type="text"/>');
            inputSaisis = textEditor.querySelector("input.saisis-cmd");
            inputSaisis.focus();
            inputSaisis.addEventListener("keyup", function (e) {
                if (e.key == "<") {
                    /*var div = document.createElement("div");
                    div.classList.add("conteneur-saisis");*/
                    var span = document.createElement("span");
                    span.classList.add("chevron");
                    span.textContent = '<';
                    var newInput = genererInputBalise();
                   /* div.appendChild(span);
                    div.appendChild(newInput);*/
                    e.currentTarget.parentElement.insertBefore(span, e.currentTarget);
                    e.currentTarget.parentElement.insertBefore(newInput, e.currentTarget);
                    e.currentTarget.parentElement.removeChild(e.currentTarget);
                    //e.currentTarget.parentElement.replaceChild(div, e.currentTarget);
                    etat = 0;
                    inputSaisis = textEditor.querySelector("input.saisis-balise");
                    inputSaisis.focus();

                }
            }, false);
        }
    }, true);

    // ************ INSERTION NUM LIGNE ******************
    textEditor.addEventListener("keyup", function (e) {
        // *************** INSERER NUM LIGNE ****************
        var brElts = textEditor.getElementsByTagName("br");
       // var numLignes = conteneurNumLigne.childNodes;
        console.log(e.key);
        if (e.key == "Enter" || e.key == "Backspace"){
            conteneurNumLigne.innerHTML = "";
            var i; var num = 0;
            for (i = 0; i < brElts.length; i++){
                num++;
                conteneurNumLigne.innerHTML += '<div class="num-ligne">'+num+'</div>';
                //console.log(brElts[i].nodeName);
               /* if (brElts[i].nextElementSibling !== null && brElts[i].nextElementSibling.nodeName == "INPUT"){
                    brElts[i].nextElementSibling.parentElement.replaceChild(input, brElts[i].nextSibling);
                }else{
                    brElts[i].parentElement.insertBefore(input, brElts[i].nextSibling);
                }*/
            }
            num++;
            conteneurNumLigne.innerHTML += '<div class="num-ligne">'+num+'</div>';
            
        }
        //------------------------------------------------------
       
       
    }, false);

    //-------------------------------

    textEditor.addEventListener("keydown", function (e) {

        //******* APERCU TEMPS REEL CODE ************
        apercu.srcdoc = textEditor.textContent.replace(/\s*<\s*/ig, "<");
        //  console.log(textEditor.textContent.replace(/\s*<\s*/ig, "<"));
        //--------------------------------


        // *********** GERER COLORATION ET COMPLETION AUTO CODE ***************

        // code HTML5
        // console.log(e.key);
        console.log(etat);
        if (e.key == "Shift") {

        } else if (e.key == "CapsLock") {

        } else if (etat == 0) { // OUVERTURE BALLISE
            inputSaisis = textEditor.querySelector("input.saisis-balise");
            // console.log(inputSaisis);
            inputSaisis.focus();
            inputSaisis.addEventListener("keydown", function (e) {
                if (e.key == " ") {
                    var span = document.createElement("span");
                    span.classList.add("balise");
                    span.textContent = (e.currentTarget.value.length > 0) ? e.currentTarget.value : 'div';
                    lastBalise = span.textContent; // ENREGISTRER DERNIER BALISE OUVERT
                    e.currentTarget.parentElement.replaceChild(span, e.currentTarget);
                    var newSaisis = genererInputSaisisAttrVal();
                    // console.log("%%%%% " +span.parentElement.innerHTML);
                    var next = span.nextElementSibling;
                    if (next != null) {
                        for (var i = 0; i < newSaisis.length; i++) {
                            span.parentElement.insertBefore(newSaisis[i], next);
                            next = newSaisis[i].nextElementSibling;
                        }
                    } else {
                        for (var i = 0; i < newSaisis.length; i++)
                            span.parentElement.appendChild(newSaisis[i]);
                    }
                    etat = 1;
                }
            }, false);

        } else if (etat == 1) { // SAISIS ATTR
            inputSaisis = textEditor.querySelector("input.saisis-attr");
            console.log(inputSaisis);
            inputSaisis.focus();
            inputSaisis.addEventListener("keydown", function (e) {
                if (e.key == " ") {
                    var span = document.createElement("span");
                    span.style.color = "green";
                    span.textContent = (e.currentTarget.value.length > 0) ? e.currentTarget.value : 'attr';
                    e.currentTarget.parentElement.replaceChild(span, e.currentTarget);
                    etat = 2;
                }
            }, false);

        } else if (etat == 2) { // SAISIS VALEUR ATTR
            inputSaisis = textEditor.querySelector("input.saisis-val");
            //console.log(inputSaisis);
            inputSaisis.focus();
            inputSaisis.addEventListener("keydown", function (e) {
                if (e.key == " ") {
                    var span = document.createElement("span");
                    span.style.color = "orange";
                    span.textContent = (e.currentTarget.value.length > 0) ? e.currentTarget.value : 'val';
                    e.currentTarget.parentElement.replaceChild(span, e.currentTarget);
                    var newInput = document.createElement("input");
                    newInput.classList.add("saisis-cmd");
                    var next = span.nextElementSibling.nextElementSibling;
                    if (next != null)
                        span.parentElement.insertBefore(newInput, next);
                    else
                        span.parentElement.appendChild(newInput);
                    etat = 3;
                }

            }, false);

        } else if (etat == 3) { // FERMETURE BALISE OUVERTE OU AJOUT ATTR
            inputSaisis = textEditor.querySelector("input.saisis-cmd");
            //console.log(inputSaisis);
            inputSaisis.focus();
            inputSaisis.addEventListener("keydown", function (e) {
                if (e.key == "Shift") { /* absorber touche inutile*/
                    etat = 3;
                } else if (e.key == ">") { // FERMETURE BALISE
                    var span = document.createElement("span");
                    span.classList.add("chevron");
                    span.textContent = ">";
                    e.currentTarget.parentElement.replaceChild(span, e.currentTarget);

                    // FERMETURE AUTOMATIQUE DERNIER BALISE OUVERTE (AUTO COMPLETION)
                    var closeElts = [];
                    //closeElts.push(document.createElement("input")); // input cmd
                    closeElts.push(document.createElement("span")); // span <
                    closeElts.push(document.createElement("span")); // span /
                    closeElts.push(document.createElement("span")); // span balise
                    closeElts.push(document.createElement("span")); // span >
                    //closeElts[0].classList.add("saisis-cmd");
                    closeElts[0].classList.add("chevron");
                    closeElts[0].appendChild(document.createTextNode("<"));
                    closeElts[1].classList.add("mark-fin-balise");
                    closeElts[1].appendChild(document.createTextNode("/"));
                    closeElts[2].classList.add("balise");
                    closeElts[2].appendChild(document.createTextNode(lastBalise));
                    closeElts[3].classList.add("chevron");
                    closeElts[3].appendChild(document.createTextNode(">"));
                    var next = span.nextElementSibling;
                    if (next !== null) {
                        for (var i = 0; i < closeElts.length; i++) {
                            span.parentElement.insertBefore(closeElts[i], next);
                            next = closeElts[i].nextElementSibling;
                        }
                    } else {
                        for (var i = 0; i < closeElts.length; i++)
                            span.parentElement.appendChild(closeElts[i]);
                    }
                    inputSaisis = textEditor.querySelector("input.saisis-cmd");
                    console.log(inputSaisis);
                    inputSaisis.focus();
                    textEditor.removeChild(inputSaisis);
                    etat = -2;


                } else { // AJOUT ATTR (BOUCLER AUTOMATE)
                    var span = document.createElement("span");
                    e.currentTarget.parentElement.replaceChild(span, e.currentTarget);

                    var newSaisis = genererInputSaisisAttrVal();
                    var next = span.nextElementSibling;
                    if (next != null) {
                        for (var i = 0; i < newSaisis.length; i++) {
                            span.parentElement.insertBefore(newSaisis[i], next);
                            next = newSaisis[i].nextElementSibling;
                        }
                    } else {
                        for (var i = 0; i < newSaisis.length; i++)
                            span.parentElement.appendChild(newSaisis[i]);
                    }
                    etat = 1;
                }
            }, false);
        } 
        
        //if (etat == -2)
            textEditor.execCommand("foreColor", false, "black");
        // -----------------------------------------------------
    }, false);

};