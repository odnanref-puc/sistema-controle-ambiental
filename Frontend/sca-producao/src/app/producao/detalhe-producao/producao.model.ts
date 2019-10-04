
export class Producao{
  constructor(
    public id: string,
    public data: any,
    public minerio: string,
    public qde_etapa_extracao: string,
    public qde_etapa_britagem: string,
    public qde_etapa_classificacao: string,
    public qde_etapa_remocao_rejeitos: string,
    public qde_etapa_estocagem: string,
    public qde_etapa_carregamento: string,
    public qde_etapa_embarque: string,
    public unidade_exploracao_id: string
  ){}
}
