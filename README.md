# Sistema de Monitoramento e Prevenção de Alagamentos (Global Solution)

Sistema desenvolvido em Java para monitoramento ambiental e previsão de riscos de alagamento, criado como parte da avaliação da Global Solution. O projeto aplica rigorosamente os pilares da Programação Orientada a Objetos (OOP).

---

## Público Beneficiado
* **Quem sofre o problema:** Moradores de regiões urbanas vulneráveis a desastres naturais (como o Vale Central) e gestores de infraestrutura urbana que lidam com perdas humanas e materiais devido a cheias repentinas.
* **Decisão que o sistema apoia:** O sistema apoia a tomada de decisão em tempo real e a gestão preventiva de emergências. Através dos níveis de alerta automatizados (Seguro, Atenção, Alerta e Crítico) e da análise de tendências via média móvel, o sistema auxilia a Defesa Civil e os operadores a decidirem o momento exato de acionar protocolos de evacuação, emitir avisos à população ou alterar limites de segurança mediante autenticação.

---

## Decisões da Equipe (Arquitetura e OOP)
A equipe tomou decisões técnicas focadas em robustez, manutenibilidade e atendimento estrito aos critérios de OOP:
1. **Encapsulamento com Segurança (`DadosTerritorio`):** Decidiu-se centralizar os dados sensíveis e limiares de alerta numa classe dedicada, exigindo uma palavra-passe de administrador para alterações. Isso evita modificações acidentais ou não autorizadas por operadores comuns.
2. **Uso de Herança e Polimorfismo (`EstrategiaPrevisao`):** Para o cálculo de risco, adotou-se uma classe base abstrata com subclasses especializadas (`PrevisaoMediaMovel` e `PrevisaoComparacao`). Isso permite que o sistema mude ou adicione novos algoritmos de previsão no futuro sem alterar a lógica principal do programa.
3. **Interfaces para Padronização de Hardware (`Sensor`):** A criação de uma interface comum garantiu que qualquer novo dispositivo físico adicionado no futuro (como sensores de vento ou pressão) siga exatamente o mesmo contrato de funcionamento e leitura.
4. **Armazenamento em Memória (`ArrayList`):** Optou-se por coleções nativas do Java para gerir o histórico de leituras, garantindo leveza e simplicidade na execução via linha de comandos (CLI) sem a complexidade desnecessária de uma base de dados externa nesta fase do projeto.

---

## Reflexão Crítica
O desenvolvimento deste projeto permitiu compreender a importância de alinhar conceitos teóricos de OOP com problemas do mundo real. 
* **Desafios:** Um dos principais desafios foi modelar a hierarquia de classes de forma a evitar acoplamentos excessivos, garantindo que as regras de negócio fizessem sentido tanto para os sensores quanto para as estratégias de previsão.
* **Limitações:** Atualmente, a simulação depende de dados gerados aleatoriamente (`Math.random()`), o que não substitui a imprevisibilidade de um ambiente meteorológico real.
* **Evoluções Futuras:** Como próximos passos, a arquitetura modular desenvolvida permitiria facilmente substituir a simulação atual por uma API de telemetria IoT real, conectando os sensores físicos diretamente a uma base de dados persistente.

---

## Estrutura de Ficheiros (`src/`)

* **`SistemaMonitoramento.java`**: Classe principal (`main`) com menu interativo via CLI e lógica de alertas multi-nível.
* **`ComponenteTerritorial.java`**: Classe abstrata base para elementos geográficos e dispositivos.
* **`Sensor.java`**: Interface que define os contratos de leitura e status dos sensores.
* **`SensorChuva.java`**, **`SensorNivelRio.java`**, **`SensorUmidade.java`**: Implementações concretas de sensores.
* **`DadosTerritorio.java`**: Classe responsável pelo encapsulamento e segurança por palavra-passe.
* **`EstrategiaPrevisao.java`**, **`PrevisaoMediaMovel.java`**, **`PrevisaoComparacao.java`**: Hierarquia de classes para previsão de risco.

---

## Sistema de Alertas Automáticos

O sistema compara as leituras em tempo real com o limiar configurado:
* **CRÍTICO:** Acima de 100% do limite (Risco severo de alagamento).
* **ALERTA:** Entre 80% e 100% do limite (Volume alto, acionamento de protocolos).
* **ATENÇÃO:** Entre 50% e 79% do limite (Monitorização contínua).
* **SEGURO:** Abaixo de 50% (Normalidade).

---

## Como Executar o Projeto

1. Certifique-se de ter o **JDK** instalado.
2. Abra o projeto no **Visual Studio Code**.
3. Abra o ficheiro `SistemaMonitoramento.java` na pasta `src`.
4. Clique em **Run** acima do método `main`.
5. Interaja com o menu no terminal:
   * `1`: Verificar status dos sensores.
   * `2`: Simular nova leitura de chuva e verificar alerta.
   * `3`: Executar previsão matemática de tendência.
   * `4`: Configurar novo limite de alerta (senha: `admin123`).
   * `5`: Sair.