import {Routes} from '@angular/router'

import {HomeComponent} from './home/home.component'
import {AtivosComponent} from './ativos/ativos.component'
import {AtivoDetalheComponent} from './ativos/ativo-detalhe/ativo-detalhe.component'

export const ROUTES: Routes = [
  {path: '', component: HomeComponent},
  {path: 'ativos', component: AtivosComponent},
  {path: 'ativos/:id', component: AtivoDetalheComponent}
]
