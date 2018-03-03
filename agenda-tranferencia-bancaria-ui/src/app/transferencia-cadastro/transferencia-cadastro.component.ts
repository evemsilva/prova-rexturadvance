import { Component, OnInit } from '@angular/core';
import { TransferenciaService } from './../transferencia.service';
import { FormControl } from '@angular/forms';
import { Message } from 'primeng/api';

@Component({
  selector: 'app-transferencia-cadastro',
  templateUrl: './transferencia-cadastro.component.html',
  styleUrls: ['./transferencia-cadastro.component.css']
})
export class TransferenciaCadastroComponent implements OnInit {

  transacoes = [];
  msgs: Message[] = [];
  dataMinima = new Date();

  constructor(private transferenciaService: TransferenciaService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.transferenciaService.listar().subscribe(dados => { this.transacoes = dados },
      (mgsErro) => {
        this.msgs.push({ severity: 'error', summary: 'Houve um erro durante a consulta de transferências', detail: '' });
        return;
      }
    );
  }

  adicionar(frm: FormControl) {

    this.transferenciaService.adicionar(frm.value).subscribe(() => {
      frm.reset();
      this.consultar();
      this.msgs.push({ severity: 'success', summary: 'Agendamento efetuado com sucesso.', detail: '' });
    },
      (mgsErro) => {
        this.msgs.push({ severity: 'error', summary: mgsErro.error.message, detail: 'Não foi possível agendar a transferência.' });
        return;
      });
  }

}
