import { CreatePersonComponent } from './create-person/create-person.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import {FormsModule} from '@angular/forms';

const routes: Routes = [
   { path: '', redirectTo: 'person', pathMatch: 'full' },
   { path: 'people', component: PersonListComponent },
   { path: 'add', component: CreatePersonComponent },
];

@NgModule({
  imports: [
  RouterModule.forRoot(routes),
  FormsModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
