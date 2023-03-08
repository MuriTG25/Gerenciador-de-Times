package br.com.systemfut.dominio.funcionarios.dados_extras.atributos_dados_bancarios;

import br.com.systemfut.infraestrutura.funcionarios.dados_extras.atributos_dados_bancarios.ConsultaDeBancos;
import br.com.systemfut.infraestrutura.funcionarios.dados_extras.atributos_dados_bancarios.ExtraiDadosDeBancosEmJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(OutputCaptureExtension.class)
class ConsultaDeBancosTest {
    ConsultaDeBancos consulta;
    ExtraiDadosDeBancosEmJson json;
    @BeforeEach
    public void iniciaConsulta(){
        json = new ExtraiDadosDeBancosEmJson();
        consulta = new ConsultaDeBancos(this.json);
    }
    @Test
    public void confereSeABuscaFoiBemSucedida(CapturedOutput output) {
        System.out.println(consulta.consultaMapsDeBanco());
        assertEquals("""
                {Banco do Brasil S.A.
                  =1, Banco da Amazônia S.A.
                  =3, Banco do Nordeste do Brasil S.A.
                  =4, Banco Nacional de Desenvolvimento Econômico e Social BNDES
                  =7, Credicoamo Crédito Rural Cooperativa
                  =10, Credit Suisse Hedging-Griffo Corretora de Valores S.A.
                  =11, Banco Inbursa S.A.
                  =12, Natixis Brasil S.A. Banco Múltiplo
                  =14, UBS Brasil Corretora de Câmbio=15, Coop de Créd. Mútuo dos Despachantes de Trânsito de SC e Rio Grande do Sul
                  =16, BNY Mellon Banco S.A.
                  =17, Banco Tricury S.A.
                  =18, Banestes S.A. Banco do Estado do Espírito Santo
                  =21, Banco Bandepe S.A.
                  =24, Banco Alfa S.A.
                  =25, Banco Itaú Consignado S.A.
                  =29, Banco Santander (Brasil) S. A.
                  =33, Banco Bradesco BBI S.A.
                  =36, Banco do Estado do Pará S.A.
                  =37, Banco Cargill S.A.
                  =40, Banco do Estado do Rio Grande do Sul S.A.
                  =41, Banco do Estado de Sergipe S.A.
                  =47, Confidence Corretora de Câmbio S.A.
                  =60, Hipercard Banco Múltiplo S.A.
                  =62, Banco Bradescard S.A.
                  =63, Goldman Sachs do Brasil  Banco Múltiplo S. A.
                  =64, Banco AndBank (Brasil) S.A.
                  =65, Banco Morgan Stanley S. A.
                  =66, Banco Crefisa S.A.
                  =69, Banco de Brasília S.A.
                  =70, Banco J. Safra S.A.
                  =74, Banco ABN Amro S.A.
                  =75, Banco KDB do Brasil S.A.
                  =76, Banco Inter S.A.
                  =77, Haitong Banco de Investimento do Brasil S.A.
                  =78, Banco Original do Agronegócio S.A.
                  =79, BT Corretora de Câmbio Ltda.
                  =80, BBN Banco Brasileiro de Negocios S.A.
                  =81, Banco Topazio S.A.
                  =82, Banco da China Brasil S.A.
                  =83, Uniprime Norte do Paraná - Cooperativa de Crédito Ltda.
                  =84, Cooperativa Central de Crédito Urbano - Cecred
                  =85, Cooperativa de Crédito Rural da Região da Mogiana
                  =89, Central de Cooperativas de Economia e Crédito Mútuo do Est RS - Unicred
                  =91, BRK S.A. Crédito=92, Pólocred Sociedade de Crédito ao Microempreendedor e à Empresa de Pequeno Porte
                  =93, Banco Finaxis S.A.
                  =94, Banco Confidence de Câmbio S.A.
                  =95, Banco BMFBovespa de Serviços de Liquidação e Custódia S/A
                  =96, Cooperativa Central de Crédito Noroeste Brasileiro Ltda - CentralCredi
                  =97, Credialiança Cooperativa de Crédito Rural
                  =98, Uniprime Central – Central Interestadual de Cooperativas de Crédito Ltda.
                  =99, Planner Corretora de Valores S.A.
                  =100, Renascença Distribuidora de Títulos e Valores Mobiliários Ltda.
                  =101, XP Investimentos Corretora de Câmbio Títulos e Valores Mobiliários S.A.
                  =102, Caixa Econômica Federal
                  =104, Lecca Crédito=105, Banco Bocom BBM S.A.
                  =107, PortoCred S.A. Crédito=108, Oliveira Trust Distribuidora de Títulos e Valores Mobiliários S.A.
                  =111, Magliano S.A. Corretora de Cambio e Valores Mobiliarios
                  =113, Central Cooperativa de Crédito no Estado do Espírito Santo - CECOOP
                  =114, Advanced Corretora de Câmbio Ltda.
                  =117, Standard Chartered Bank (Brasil) S.A. Banco de Investimento
                  =118, Banco Western Union do Brasil S.A.
                  =119, Banco Rodobens SA
                  =120, Banco Agibank S.A.
                  =121, Banco Bradesco BERJ S.A.
                  =122, Banco Woori Bank do Brasil S.A.
                  =124, Brasil Plural S.A. Banco Múltiplo
                  =125, BR Partners Banco de Investimento S.A.
                  =126, Codepe Corretora de Valores e Câmbio S.A.
                  =127, MS Bank S.A. Banco de Câmbio
                  =128, UBS Brasil Banco de Investimento S.A.
                  =129, Caruana S.A. Sociedade de Crédito=130, Tullett Prebon Brasil Corretora de Valores e Câmbio Ltda.
                  =131, ICBC do Brasil Banco Múltiplo S.A.
                  =132, Confederação Nacional das Cooperativas Centrais de Crédito e Economia Familiar e
                  =133, BGC Liquidez Distribuidora de Títulos e Valores Mobiliários Ltda.
                  =134, Gradual Corretora de Câmbio=135, Confederação Nacional das Cooperativas Centrais Unicred Ltda – Unicred do Brasil
                  =136, Multimoney Corretora de Câmbio Ltda
                  =137, Get Money Corretora de Câmbio S.A.
                  =138, Intesa Sanpaolo Brasil S.A. - Banco Múltiplo
                  =139, Easynvest - Título Corretora de Valores SA
                  =140, Broker Brasil Corretora de Câmbio Ltda.
                  =142, Treviso Corretora de Câmbio S.A.
                  =143, Bexs Banco de Câmbio S.A.
                  =144, Levycam - Corretora de Câmbio e Valores Ltda.
                  =145, Guitta Corretora de Câmbio Ltda.
                  =146, Facta Financeira S.A. - Crédito Financiamento e Investimento
                  =149, ICAP do Brasil Corretora de Títulos e Valores Mobiliários Ltda.
                  =157, Casa do Crédito S.A. Sociedade de Crédito ao Microempreendedor
                  =159, Commerzbank Brasil S.A. - Banco Múltiplo
                  =163, Banco Olé Bonsucesso Consignado S.A.
                  =169, Albatross Corretora de Câmbio e Valores S.A
                  =172, BRL Trust Distribuidora de Títulos e Valores Mobiliários S.A.
                  =173, Pernambucanas Financiadora S.A. Crédito=174, Guide Investimentos S.A. Corretora de Valores
                  =177, CM Capital Markets Corretora de Câmbio=180, Dacasa Financeira S/A - Sociedade de Crédito=182, Socred S.A. - Sociedade de Crédito ao Microempreendedor
                  =183, Banco Itaú BBA S.A.
                  =184, Ativa Investimentos S.A. Corretora de Títulos Câmbio e Valores
                  =188, HS Financeira S/A Crédito=189, Cooperativa de Economia e Crédito Mútuo dos Servidores Públicos Estaduais do Rio
                  =190, Nova Futura Corretora de Títulos e Valores Mobiliários Ltda.
                  =191, Parmetal Distribuidora de Títulos e Valores Mobiliários Ltda.
                  =194, Fair Corretora de Câmbio S.A.
                  =196, Stone Pagamentos S.A.
                  =197, Banco Bradesco Cartões S.A.
                  =204, Banco BTG Pactual S.A.
                  =208, Banco Original S.A.
                  =212, Banco Arbi S.A.
                  =213, Banco John Deere S.A.
                  =217, Banco BS2 S.A.
                  =218, Banco Credit Agrícole Brasil S.A.
                  =222, Banco Fibra S.A.
                  =224, Banco Cifra S.A.
                  =233, Banco Bradesco S.A.
                  =237, Banco Clássico S.A.
                  =241, Banco Máxima S.A.
                  =243, Banco ABC Brasil S.A.
                  =246, Banco Investcred Unibanco S.A.
                  =249, BCV - Banco de Crédito e Varejo S/A
                  =250, Bexs Corretora de Câmbio S/A
                  =253, Parana Banco S. A.
                  =254, Nu Pagamentos S.A.
                  =260, Banco Fator S.A.
                  =265, Banco Cédula S.A.
                  =266, Barigui Companhia Hipotecária
                  =268, HSBC Brasil S.A. Banco de Investimento
                  =269, IB Corretora de Câmbio=271, Banco de la Nacion Argentina
                  =300, Banco BMG S.A.
                  =318, China Construction Bank (Brasil) Banco Múltiplo S/A
                  =320, Itaú Unibanco  S.A.
                  =341, Banco Société Générale Brasil S.A.
                  =366, Banco Mizuho do Brasil S.A.
                  =370, Banco J. P. Morgan S. A.
                  =376, Banco Mercantil do Brasil S.A.
                  =389, Banco Bradesco Financiamentos S.A.
                  =394, Kirton Bank S.A. - Banco Múltiplo
                  =399, Banco Capital S. A.
                  =412, Banco Safra S.A.
                  =422, Banco MUFG Brasil S.A.
                  =456, Banco Sumitomo Mitsui Brasileiro S.A.
                  =464, Banco Caixa Geral - Brasil S.A.
                  =473, Citibank N.A.
                  =477, Banco ItauBank S.A.
                  =479, Deutsche Bank S.A. - Banco Alemão
                  =487, JPMorgan Chase Bank=488, ING Bank N.V.
                  =492, Banco de La Republica Oriental del Uruguay
                  =494, Banco de La Provincia de Buenos Aires
                  =495, Banco Credit Suisse (Brasil) S.A.
                  =505, Senso Corretora de Câmbio e Valores Mobiliários S.A.
                  =545, Banco Luso Brasileiro S.A.
                  =600, Banco Industrial do Brasil S.A.
                  =604, Banco VR S.A.
                  =610, Banco Paulista S.A.
                  =611, Banco Guanabara S.A.
                  =612, Omni Banco S.A.
                  =613, Banco Pan S.A.
                  =623, Banco Ficsa S. A.
                  =626, Banco Intercap S.A.
                  =630, Banco Rendimento S.A.
                  =633, Banco Triângulo S.A.
                  =634, Banco Sofisa S. A.
                  =637, Banco Alvorada S.A.
                  =641, Banco Pine S.A.
                  =643, Itaú Unibanco Holding S.A.
                  =652, Banco Indusval S. A.
                  =653, Banco A. J. Renner S.A.
                  =654, Banco Votorantim S.A.
                  =655, Banco Daycoval S.A.
                  =707, Banco Ourinvest S.A.
                  =712, Banif - Bco Internacional do Funchal (Brasil) S.A.
                  =719, Banco Neon S.A.
                  =735, Banco Cetelem S.A.
                  =739, Banco Ribeirão Preto S.A.
                  =741, Banco Semear S.A.
                  =743, Banco Citibank S.A.
                  =745, Banco Modal S.A.
                  =746, Banco Rabobank International Brasil S.A.
                  =747, Banco Cooperativo Sicredi S. A.
                  =748, Scotiabank Brasil S.A. Banco Múltiplo
                  =751, Banco BNP Paribas Brasil S.A.
                  =752, Novo Banco Continental S.A. - Banco Múltiplo
                  =753, Banco Sistema S.A.
                  =754, Bank of America Merrill Lynch Banco Múltiplo S.A.
                  =755, Banco Cooperativo do Brasil S/A - Bancoob
                  =756, Banco Keb Hana do Brasil S. A.
                 \s
                =757}""", output.getOut().trim());

    }
}