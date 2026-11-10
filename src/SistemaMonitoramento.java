import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMonitoramento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DadosTerritorio dados = new DadosTerritorio(50000, "Vale Central", 40.0, "admin123");

        SensorChuva sensorChuva = new SensorChuva(1, "Pluviômetro Alfa", "Vale Central");
        SensorNivelRio sensorRio = new SensorNivelRio(2, "Sensor Rio Beta", "Vale Central");
        
        PrevisaoMediaMovel previsaoMedia = new PrevisaoMediaMovel(3); 

        ArrayList<Double> historicoChuva = new ArrayList<>();
        historicoChuva.add(15.0); 
        historicoChuva.add(20.5);

        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== SISTEMA DE PREVENÇÃO DE ALAGAMENTOS ===");
            System.out.println("1. Verificar Status dos Sensores");
            System.out.println("2. Simular Nova Leitura de Chuva");
            System.out.println("3. Executar Previsão de Risco");
            System.out.println("4. Configurar Limite de Alerta (Requer Senha)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("\n--- Status Atual ---");
                sensorChuva.verificarStatus();
                sensorRio.verificarStatus();
                
            } else if (opcao == 2) {
                double leituraAtual = sensorChuva.lerValor();
                historicoChuva.add(leituraAtual); 
                
                System.out.printf("\n[LEITURA] Volume de chuva captado: %.2f mm\n", leituraAtual);

                // Lógica com os 3 níveis de alerta
                double limite = dados.getLimiteChuvaMilimetros();

                if (leituraAtual > limite) {
                    System.out.println("CRÍTICO: Volume ultrapassou o limite de " + limite + " mm! Risco severo de alagamento!");
                } else if (leituraAtual >= limite * 0.8) {
                    System.out.println("ALERTA: Volume alto (acima de 80% do limite). Preparar protocolo de segurança.");
                } else if (leituraAtual >= limite * 0.5) {
                    System.out.println("ATENÇÃO: Volume moderado. Manter monitoramento contínuo.");
                } else {
                    System.out.println("SEGURO: Nível dentro da normalidade.");
                }

            } else if (opcao == 3) {
                double resultadoPrevisao = previsaoMedia.prever(historicoChuva);
                System.out.printf("\n[PREVISÃO] Tendência de chuva (média móvel): %.2f mm\n", resultadoPrevisao);

            } else if (opcao == 4) {
                System.out.print("\nDigite a senha de administrador: ");
                String senha = scanner.next();
                System.out.print("Digite o novo limite de chuva em milímetros: ");
                double novoLimite = scanner.nextDouble();
                
                dados.setLimiteChuvaMilimetros(novoLimite, senha);

            } else if (opcao == 5) {
                System.out.println("\nEncerrando o sistema. Até logo!");
                rodando = false;
                
            } else {
                System.out.println("\nOpção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}