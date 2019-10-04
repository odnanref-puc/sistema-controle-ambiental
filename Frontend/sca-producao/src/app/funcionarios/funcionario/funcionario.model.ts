export class Funcionario{
  constructor(
    public id: string,
    public nome: string,
    public endereco: string,
    public bairro: string,
    public cidade: string,
    public estado: string,
    public pais: string,
    public data_inicio: any,
    public cargo: string,
    public situacao: string
  ){}
}
