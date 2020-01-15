import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private authentication: AuthenticationService) { }

  ngOnInit() {
  }

  registerUser(form: NgForm) {
    this.authentication.register(form.value).subscribe( data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.success = data.message;
        setTimeout(() => {
          this.success = null;
        }, 5000);
        form.reset();
      } else {
        this.failure = data.message;
        setTimeout(() => {
          this.failure = null;
        }, 5000);
      }
    });
  }
}
