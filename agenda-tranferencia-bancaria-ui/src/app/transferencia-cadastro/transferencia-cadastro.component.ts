import { Component, OnInit } from '@angular/core';
import { TransferenciaService } from './../transferencia.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-transferencia-cadastro',
  templateUrl: './transferencia-cadastro.component.html',
  styleUrls: ['./transferencia-cadastro.component.css']
})
export class TransferenciaCadastroComponent implements OnInit {

  transacoes = [];

  constructor(private transferenciaService: TransferenciaService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.transferenciaService.listar().subscribe(dados => this.transacoes = dados);
  }

  adicionar(frm: FormControl){
    console.log(frm.value);

    this.transferenciaService.adicionar(frm.value).subscribe(() => {
        frm.reset();
        this.consultar();
    });
  }

}
