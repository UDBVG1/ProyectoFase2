// JavaScript code
function search_titulo() {
    var input = document.getElementById('searchbar').value;
    input=input.toLowerCase();
    let x2 = document.getElementsByTagName('p');
    for (i = 0; i < x2.length; i++) { 
        if (!x2[i].innerHTML.toLowerCase().includes(input)) {
            x2[i].style.display="none";
        }
        else {
            x2[i].style.display="list-item"; 
        }
    }
}

function search_columna() {
    var input = document.getElementById('searchbar').value;
    input=input.toLowerCase();
    let x2 = document.getElementsByTagName('tr');
    for (i = 0; i < x2.length; i++) { 
        if (!x2[i].innerHTML.toLowerCase().includes(input)) {
            x2[i].style.display="none";
        }
        else {
            x2[i].style.display="table-row"; 
        }
    }
}