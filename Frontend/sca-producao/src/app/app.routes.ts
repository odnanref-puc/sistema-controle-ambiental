import {Routes} from '@angular/router'

import {HomeComponent} from './home/home.component'
import {MinasComponent} from './minas/minas.component'
import {MinaDetalheComponent} from './minas/mina-detalhe/mina-detalhe.component'
import {ProducaoComponent} from './producao/producao.component'
import {DetalheProducaoComponent} from './producao/detalhe-producao/detalhe-producao.component'

export const ROUTES: Routes = [
  {path: '', component: HomeComponent},
  {path: 'minas', component: MinasComponent},
  {path: 'mina_detalhe/:id', component: MinaDetalheComponent},
  {path: 'producao/:id', component: ProducaoComponent},
  {path: 'producao_detalhe/:id', component: DetalheProducaoComponent}
]
