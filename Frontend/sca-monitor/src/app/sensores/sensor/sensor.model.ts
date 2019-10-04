export class Sensor{
  constructor(
	public id: string,
  public situacao: string,
	public unidade_exploracao_id: string,
	public temperatura: string,
	public pressao: string
  ){}
}
