import {Routes} from '@angular/router'

import {HomeComponent} from './home/home.component'
import {SensoresComponent} from './sensores/sensores.component'
import {EmailComponent} from './email/email.component'

export const ROUTES: Routes = [
  {path: '', component: HomeComponent},
  {path: 'sensores', component: SensoresComponent},
  {path: 'email/:mina_id', component: EmailComponent}
]
