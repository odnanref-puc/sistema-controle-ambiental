export class Ativo{
  constructor(
	public id: string,
  public nome: string,
	public marca: string,
	public modelo: string,
	public descricao: string,
	public fabricante: string,
	public data_aquisicao: any,
	public valor_aquisicao: string,
	public tempo_garantia: string,
	public vida_util: string,
	public valor_residual: string,
	public situacao: string,
  public tipo: string
  ){}
}
