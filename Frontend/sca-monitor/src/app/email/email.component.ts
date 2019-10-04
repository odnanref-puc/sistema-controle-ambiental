import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import {FormGroup, FormBuilder, Validators} from '@angular/forms'
import {Email} from './email.model'
import{EmailService} from './email.service'

@Component({
  selector: 'sca-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})

export class EmailComponent implements OnInit {

  email: Email;
  emailForm: FormGroup;
  mensagem: string;
  titulo: string;

  constructor(private emailService: EmailService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.titulo = 'Email aos moradores - Área de risco Mina '+ this.route.snapshot.params['mina_id']
    this.emailForm = this.formBuilder.group({
      assunto: this.formBuilder.control('', [Validators.required, Validators.minLength(3)]),
      mensagem: this.formBuilder.control('', [Validators.required, Validators.minLength(3)])
    })
  }

  onSubmit(): void{
      this.email = this.emailForm.value
      this.email.mina_id = this.route.snapshot.params['mina_id']

      this.emailService.enviarEmail(this.email).subscribe(
        (resultado: any) => {
            this.mensagem = resultado.descricao
        }
      )

  }
}
