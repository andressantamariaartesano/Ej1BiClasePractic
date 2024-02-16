/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1bidimensionales;

import utilidades.Alfanumericos;
import utilidades.Numero;

/**
 *
 * @author dam
 */
public class Concesionario {

    Modelo[] modelos;
    final String[] TIPOS = {"turismo", "deportivo", "todorerreno"};
    final static String[] MESES = {"Enero", "Febrero", "Mar", "Abril", "Mayo", "Junio"};
    final float[] IMPORTES = {15000.0f, 30000.0f, 50000.0f, 100000.0f, Float.MAX_VALUE};
    final float[][] PORCENTAJES = { // guardo en un array bidimensional la tabla lo primero es el tipo, lo segundo es el importe
        {0.15f, 0.10f, 0.10f, 0.18f, 0.06f},
        {0.18f, 0.12f, 0.14f, 0.20f, 0.08f},
        {0.21f, 0.14f, 0.16f, 0.22f, 0.10f}};

    public Concesionario(int numero) {
        modelos = new Modelo[numero];
        crearModelos(numero);
    }

    public Concesionario() {
        modelos = new Modelo[15];
    }

    private void crearModelos(int numero) {
        for (int posModelo = 0; posModelo < numero; posModelo++) {
            modelos[posModelo] = new Modelo();
        }
    }

    public void introducirDatos() {
        String denominacion;
        int tipo; // aquí guardo la posición de un array tipo
        int ventas;

        for (int posModelo = 0; posModelo < modelos.length; posModelo++) {
            denominacion = pedirDenominacion();
            tipo = pedirTipo();
            modelos[posModelo].setDenominacionTipo(denominacion, tipo);
        }
    }

    private String pedirDenominacion() {
        String denominacion;

        denominacion = Alfanumericos.pedirAlfanumerico("Introduce la denominacion del modelo: ");

        return denominacion;
    }

    private int pedirTipo() {

        String tipo;
        int posTipo;

        mostrarTipos();

        do {
            tipo = Alfanumericos.pedirAlfanumerico("Tipo");
            posTipo = buscarTipo(tipo);

        } while (posTipo == -1);

        return posTipo;
    }

    private int buscarTipo(String tipo) {
        int posTipo = 0;
        boolean encontrado = false;

        while (!encontrado && posTipo < TIPOS.length) {
            if (TIPOS[posTipo].equalsIgnoreCase(tipo)) {
                encontrado = true;
            } else {
                posTipo++;
            }
        }
        if (!encontrado) {
            posTipo = -1;
        }

        return posTipo;
    }

    private void mostrarTipos() {
        String tipo;
        System.out.println("Tipos: ");

        for (int posTipo = 0; posTipo < 10; posTipo++) {
            tipo = TIPOS[posTipo];
            System.out.println(posTipo + 1 + " " + tipo);
        }
    }

    public void pedirVentas() {
        float importe;
        for (int numMes = 0; numMes < 6; numMes++) {

            System.out.println("Ventas del mes " + MESES[numMes]);

            for (int posModelo = 0; posModelo < modelos.length; posModelo++) {
                importe = Numero.pedirNumeroReal("Introduce las ventas: ", 0, Float.MAX_VALUE);
            }
        }
    }

    public void informeVentas() {
        float primerTrimestre;
        float segundoTrimestre;
        float totalTrimestres;

        Modelo modelo;

        int mesInicial;
        int mesFinal;
        int tipoModelo;
        int posColumna;
        float beneficio;
        String categoriaModelo;

        System.out.println("INFORME VENTAS");

        for (int posModelo = 0; posModelo < modelos.length; posModelo++) {
            modelo = modelos[posModelo];

            mesInicial = 0;
            mesFinal = 3;
            primerTrimestre = modelo.sumarVentas(mesInicial, mesFinal);

            mesInicial = 3;
            mesFinal = 6;
            segundoTrimestre = modelo.sumarVentas(mesInicial, mesFinal);

            totalTrimestres = primerTrimestre + segundoTrimestre;

            tipoModelo = modelo.getTipo();
            posColumna = buscarImporte(totalTrimestres);

            beneficio = totalTrimestres * PORCENTAJES[tipoModelo][posColumna];

            categoriaModelo = modelo.getDenominacion();

            mostrarDatos(categoriaModelo, primerTrimestre, segundoTrimestre, beneficio);

        }
    }

    private int buscarImporte(float importe) {
        int posImporte = 0;
        boolean encontrado = false;

        while (!encontrado && posImporte < IMPORTES.length) {
            if (IMPORTES[posImporte] < importe) {
                posImporte++;
            } else {
                encontrado = true;
            }
        }

        return posImporte;
    }
    
    private void mostrarDatos(String categoriaModelo, float primerTrimestre, float segundoTrimestre, float beneficio) {
        System.out.print(categoriaModelo);
        System.out.print("\t");
        System.out.print(primerTrimestre);
        System.out.print("\t");
        System.out.print(segundoTrimestre);
        System.out.print("\t");
        System.out.println(beneficio);
    }
}
