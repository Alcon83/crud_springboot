import { DatePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ContactService } from '../services/contact.service';
import { Contact } from '../model/contact.interface';

@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [DatePipe, RouterModule],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export default class ContactListComponent {
  private contactService = inject(ContactService)

  contacts: Contact[] = [];

  ngOnInit(): void {
    this.contactService.list()
      .subscribe(contacts => {

        this.contacts = contacts;
      })
  }
}
