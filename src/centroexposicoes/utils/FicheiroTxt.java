///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package centroexposicoes.utils;
//
//import centroexposicoes.model.CentroExposicoes;
//import centroexposicoes.model.Exposicao;
//import centroexposicoes.model.Organizador;
//import centroexposicoes.model.Representante;
//import centroexposicoes.model.Utilizador;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Lê os dados do centro de exposições num ficheiro de texto.
// *
// * @author Daniel Gonçalves 1151452
// * @author Ivo Ferro 1151159
// */
//public class FicheiroTxt {
//
//    private static final String PASTA_FICHEIROS = "ficheiroTxt/";
//    private static final String FICHEIRO_USERS_FUNCIONARIOS = "registoUtilizadoresFuncionarios.txt";
//    private static final String FICHEIRO_REPS = "registoRepresentantes.txt";
//    private static final String PASTA_EXPOS = "exposicoes/";
//
//    private static Scanner input;
//
//    public static CentroExposicoes carregarCentroExposicoes() {
//
//        List<Representante> registoReps = carregarReps();
//        List<Utilizador> listaUsersFuncionarios = carregarUsersFuncionarios();
//
//        return null;
//    }
//
//    private static List<Representante> carregarReps() {
//
//        List<Representante> listaReps = new ArrayList<>();
//
//        try {
//            input = new Scanner(new File(PASTA_FICHEIROS.concat(FICHEIRO_REPS)));
//            input.useDelimiter(";");
//
//            while (input.hasNext()) {
//
//                String line = input.next().trim();
//                if (line.length() > 0) {
//
//                    String utilizador = line.substring(line.indexOf('-') + 1);
//                    String[] atributos = utilizador.split(",");
//                    if (atributos.length == 4) {
//
//                        listaReps.add(new Representante(new Utilizador(
//                                atributos[0].trim(),
//                                atributos[1].trim(),
//                                atributos[2].trim(),
//                                atributos[3].trim())));
//                    }
//                }
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("ficheiro não encontrado.");
//        }
//
//        return listaReps;
//    }
//
//    private static List<Utilizador> carregarUsersFuncionarios() {
//
//        List<Utilizador> listaUtilizadores = new ArrayList<>();
//
//        try {
//            input = new Scanner(new File(PASTA_FICHEIROS.concat(FICHEIRO_USERS_FUNCIONARIOS)));
//            input.useDelimiter(";");
//
//            while (input.hasNext()) {
//
//                String line = input.next();
//                if (line.length() > 0) {
//
//                    String[] atributos = line.split(",");
//                    if (atributos.length == 4) {
//
//                        listaUtilizadores.add(new Utilizador(
//                                atributos[0].trim(),
//                                atributos[1].trim(),
//                                atributos[2].trim(),
//                                atributos[3].trim()));
//                    }
//                }
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("ficheiro não encontrado.");
//        }
//
//        return listaUtilizadores;
//    }
//    
//    private static List<Organizador> carregarOrganizadores(List<Utilizador> listaFuncionarios, String ficheiroExpo) {
//
//        List<Organizador> listaOrgs = new ArrayList<>();
//
//        try {
//            input = new Scanner(new File(ficheiroExpo));
//            input.useDelimiter(";");
//
//            while (input.hasNext()) {
//
//                String line = input.next().trim();
//                if (line.length() > 0) {
//
//                    String utilizador = line.substring(line.indexOf('-') + 1);
//                    String[] atributos = utilizador.split(",");
//                    if (atributos.length == 4) {
//
//                        listaReps.add(new Representante(new Utilizador(
//                                atributos[0].trim(),
//                                atributos[1].trim(),
//                                atributos[2].trim(),
//                                atributos[3].trim())));
//                    }
//                }
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("ficheiro não encontrado.");
//        }
//
//        return listaReps;
//    }
//
//    private static Exposicao carregarExposicao(List<Utilizador> listaFuncionarios, String ficheiro) {
//        
//        Exposicao expo = new Exposicao();
//        
//        try {
//            input = new Scanner(new File(PASTA_FICHEIROS.concat(ficheiro)));
//            input.useDelimiter(";");
//
//            while (input.hasNext()) {
//
//                String line = input.next().trim();
//                if (line.length() > 0) {
//                    
//                    String[] campos = line.split(":");
//                    switch (campos[0]) {
//                        case "dados":
//                            
//                            String[] atributos = campos[1].split(",");
//                            
//                            expo.setTitulo(atributos[0]);
//                            expo.setDescricao(atributos[1]);
//                            expo.setTitulo(atributos[0]);
//                            break;
//                        default:
//                            throw new AssertionError();
//                    }
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                    String utilizador = line.substring(line.indexOf('-') + 1);
//                    String[] atributos = utilizador.split(",");
//                    if (atributos.length == 4) {
//
//                        listaReps.add(new Representante(new Utilizador(
//                                atributos[0].trim(),
//                                atributos[1].trim(),
//                                atributos[2].trim(),
//                                atributos[3].trim())));
//                    }
//                }
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("ficheiro não encontrado.");
//        }
//        
//        return null;
//    }
//    
//    public static void main(String[] args) {
//
////        FicheiroTxt.carregarUsersFuncionarios();
//        FicheiroTxt.carregarReps();
//    }
//}
