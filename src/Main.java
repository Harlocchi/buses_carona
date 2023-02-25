import entities.java.HourBus;
import entities.java.bus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;








public class Main {

    public static Integer FoundBus(List<bus> buses, String Name ) {

        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getName().equals(Name)) {
                return i;
            }

        }
        return null;
    }





    public static void main(String[] args) throws ParseException {
        bus bus = new bus();
        List<bus> buses = new ArrayList<>();
        HourBus hourBus = new HourBus();
        int digit1 = 0;
        int upline = 0;

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        System.out.println();
        System.out.println("olá, seja bem vindo ao nosso sistema de consulta de Horario de onibus ");
        System.out.println();


            while (true) {
                upline = 0;
                System.out.println("oque deseja fazer, meu caro administrador? ");
                System.out.println();
                System.out.println("[1]- cadastrar onibus e seus horarios");
                System.out.println("[2]- editar onibus e seus horarios");
                System.out.println("[3]- consultar horarios");
                System.out.println("[4]- sair");
                System.out.print("sua resposta aqui: ");
                String response = sc.nextLine();

                while (!response.equals("1") && !response.equals("2") && !response.equals("3") && !response.equals("4")) {

                    System.out.println();
                    System.out.println("valor incorreto para nossas alternativas, tente mais uma vez: ");
                    System.out.print("sua resposta aqui: ");
                    response = sc.nextLine();
                }

                if (response.equals("1")) {
                    System.out.println("certo, para cadastrar vc precisa responder uma serie de perguntas, vamos lá: ");
                    System.out.print("quantos onibus você quer cadastrar?: ");
                    int quantity = sc.nextInt();


                    for (int i = 1; i <= quantity; i++) {
                        System.out.println();
                        System.out.println("onibus " + i + ": ");
                        System.out.print("nome: ");
                        while (upline == 0){//feito para consumir o espaço a cima na primeira passagem, e nao pular na segunda
                        sc.nextLine();
                        upline+=1;
                        }
                        String nameBus = sc.nextLine();
                        System.out.print("city: ");
                        String cityBus = sc.nextLine();
                        System.out.print("horário de saída: ");
                        Date depTimeBUs = sdf.parse(sc.next());
                        System.out.print("horário de chegada: ");
                        Date arrTimebus = sdf.parse(sc.next());
                        sc.nextLine();

                        bus = new bus(nameBus, cityBus, new HourBus(depTimeBUs, arrTimebus));
                        buses.add(bus);

                        digit1 = 1;

                        System.out.println();


                    }

                    System.out.println(buses.size() + " onibus  cadastrados com secesso!!");


                } else if (response.equals("2")) {
                    System.out.println("digite o nome do onibus que deseja editar: ");
                    String nameFound = sc.nextLine();
                    Integer positionName = FoundBus(buses, nameFound);
                    System.out.println(buses.get(positionName));
                    System.out.println();
                    System.out.println("oque deseja musar?: ");
                    System.out.println("[1] - name");
                    System.out.println("[2] - city");
                    System.out.println("[3] - horario de saida");
                    System.out.println("[4] - horario de chegada");
                    System.out.println();
                    System.out.println("sua resposta aqui: ");
                    String response2 = sc.nextLine();

                    if (response2.equals("1")){
                        System.out.println("voce escolheu mudar o nome");
                        System.out.println();
                        System.out.println("mudar de " + buses.get(positionName).getName() + " para: ");
                        buses.get(positionName).setName(sc.nextLine());
                        System.out.println();
                        System.out.println("Modificado com sucesso");

                    } else if (response2.equals("2")) {

                        System.out.println("voce escolheu mudar a cidade");
                        System.out.println();
                        System.out.println("mudar de " + buses.get(positionName).getCity() + " para: ");
                        buses.get(positionName).setCity(sc.nextLine());
                        System.out.println();
                        System.out.println("Modificado com sucesso!!!");

                    } else if (response2.equals("3")) {
                        System.out.println("voce escolheu mudar o horario de saida");
                        System.out.print("de " + sdf.format(buses.get(positionName).getHourBus().getDepartureTime()) + " para (dd/mm/aaaa) : ");
                        Date responseHour = sdf.parse(sc.next());
                        buses.get(positionName).getHourBus().setDepartureTime(responseHour);
                        System.out.println();
                        System.out.println("Modificado com sucesso!!!");

                    }else if (response2.equals("4")) {
                        System.out.println("voce escolheu mudar o horario de chegada");
                        System.out.print("de " + sdf.format(buses.get(positionName).getHourBus().getArrivalTime()) + " para (dd/mm/aaaa) : ");
                        Date responseHour = sdf.parse(sc.next());
                        buses.get(positionName).getHourBus().setArrivalTime(responseHour);
                        System.out.println();
                        System.out.println("Modificado com sucesso!!!");
                    }


                } else if (response.equals("3")) {
                    int i = 1;

                    if (digit1 == 1) { // feito para listar os componentes da lista, apenas se ja tiver inserido-os
                        for (bus b :
                                buses) {
                            System.out.println();
                            System.out.println("onibus Numero " + i);
                            System.out.println();
                            System.out.println(b);
                            System.out.println();
                            i++;
                        }
                    }else {
                        System.out.println();
                        System.out.println("voce ainda nao inseriu cadastros de onibus");
                        System.out.println();
                    }
                } else {
                    break;
                }
            }
        }













    }
