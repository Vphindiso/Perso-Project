import { Observable } from "rxjs";
import { PersonService } from "./../person.service";
import { Person } from "./../person";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  people:Observable<Person[]>;

  constructor(private personService: PersonService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.people = this.personService.getAllPeople();
  }
}
