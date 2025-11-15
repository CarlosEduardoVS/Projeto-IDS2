window.onload = function () {
  const body = document.body;
  const icone = document.getElementById("iconeModo");
  const botao = document.getElementById("modoEscuroBtn");

  if (localStorage.getItem('modoEscuro') === 'true') {
    body.classList.add('modo-escuro');
    icone.src = "img/dia.jpg";
    botao.classList.add("escuro");
  } else {
    botao.classList.remove("escuro");
  }
};

function modoEscuro() {
  const body = document.body;
  const icone = document.getElementById("iconeModo");
  const botao = document.getElementById("modoEscuroBtn");

  const escuroAtivado = body.classList.toggle('modo-escuro');
  localStorage.setItem('modoEscuro', escuroAtivado);

  if (escuroAtivado) {
    icone.src = "img/dia.jpg";
    botao.classList.add("escuro");
  } else {
    icone.src = "img/noite.jpg";
    botao.classList.remove("escuro");
  }
}

const links = document.querySelectorAll('.container a');

  links.forEach(link => {
    link.addEventListener('click', function () {
      
      links.forEach(el => el.classList.remove('local'));
      this.classList.add('local');
    });
  });


//para buscar as obras de forma automatica

// document.getElementById('buscaObra').addEventListener('input', buscarObras);
// document.getElementById('buscaRua').addEventListener('input', buscarObras);

// function buscarObras() {
//     const obra = document.getElementById('buscaObra').value;
//     const rua = document.getElementById('buscaRua').value;

//     fetch(`/buscarObras?obra=${obra}&rua=${rua}`)
//         .then(res => res.text())
//         .then(html => {
//             document.getElementById('resultado-obras').innerHTML = html;
//         });
// }

// function listarTodasObras() {
//     document.getElementById('buscaObra').value = "";
//     document.getElementById('buscaRua').value = "";

//     fetch('/buscarObras')
//         .then(res => res.text())
//         .then(html => {
//             document.getElementById('resultado-obras').innerHTML = html;
//         });
// }

