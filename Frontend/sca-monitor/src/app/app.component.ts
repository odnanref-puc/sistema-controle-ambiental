import { Component } from '@angular/core';
import {Usuario} from './usuario/usuario.model'

@Component({
  selector: 'sca-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  usuarios: Usuario[] = [
    new Usuario( 1, 'Joana','Av do Estado'),
    new Usuario( 2, 'Mario','Av Paulista'),
    new Usuario( 3, 'Francisco','Rua Taipas'), 
    new Usuario( 4, 'Joana','Av do Estado'),
    new Usuario( 5, 'Mario','Av Paulista'),
    new Usuario( 6, 'Francisco','Rua Taipas'),
    new Usuario( 7, 'Joana','Av do Estado'),
    new Usuario( 8, 'Mario','Av Paulista'),
    new Usuario( 9, 'Mario','Av Paulista'),
    new Usuario( 10, 'Francisco','Rua Taipas')
  ]

   public paginaAtual = 1; // Dizemos que queremos que o componente quando carregar, inicialize na página 1.

   title = 'controle-ambiental';
}
