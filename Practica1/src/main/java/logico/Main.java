package logico;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Digite una URL:");
        String URL;
        Scanner entrada = new Scanner(System.in);
        URL = entrada.nextLine();

        Document doc = Jsoup.connect(URL).get();

        int lineas = doc.html().split("\r\n|\r|\n").length;
        Elements parrafos = doc.select("p");
        Elements imagenes = doc.select("img");
        Elements formularios = doc.select("form");

        System.out.println("lineas: "+lineas);
        System.out.println("parrafos: "+parrafos.size());
        System.out.println("imagenes: "+imagenes.size());
        System.out.println("formularios: "+formularios.size());
        System.out.println("formularios POST:"+doc.select("form[method=POST]").size());
        System.out.println("formularios GET:"+doc.select("form[method=GET]").size());

        for (Element formulario : formularios) {
            System.out.println("Formulario input: "+formulario.select("input")+"\n");
            Connection.Response respuesta = Jsoup.connect(URL)
                    .method(Connection.Method.POST)
                    .data("Asignatura", "Practica1")
                    .header("Matricula","20150664")
                    .execute();
            System.out.println("Respuesta del servidor: "+respuesta.statusCode()+" OK\n");
        }
    }

}
