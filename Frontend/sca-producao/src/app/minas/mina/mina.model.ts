export class Mina{
  constructor(
    public id: string,
    public nome: string,
    public latitude: string,
    public longitude: string,
    public bairro: string,
    public cidade: string,
    public estado: string,
    public pais: string,
    public inicio_operacao: any,
    public fim_operacao: any,
    public situacao: number,
    public capacidade_prevista: string
  ){}
}
