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
  msgs = [];
  constructor(private transferenciaService: TransferenciaService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.transferenciaService.listar().subscribe(dados => this.transacoes = dados);
  }

  adicionar(frm: FormControl){
    console.log(frm.value);

    if(frm.value.valorTransferencia === 0) {
      this.msgs.push({severity:'warn', summary:'O valor deve ser maior que zero.', detail:'Não foi possível agendar a transferência.'});
      return;
    }

    this.transferenciaService.adicionar(frm.value).subscribe(() => {
        frm.reset();
        this.consultar();
    },
      (mgsErro) => {
        console.log(mgsErro);
        this.msgs.push({severity:'error', summary: mgsErro.error.message, detail:'Não foi possível agendar a transferência.'});
        return;
      });
  }

}
