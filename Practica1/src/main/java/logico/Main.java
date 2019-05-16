package logico;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import java.io.IOException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        int i=0;
        int j=0;
        int k1=0;
        int k2=0;
        int l=0;

        Document doc = Jsoup.connect("https://www.pucmm.edu.do/").get();

        Elements lineas = doc.select("br");
        Elements parrafos = doc.select("p");
        Elements imagenes = doc.select("img");
        Elements formularios = doc.select("form");

        for (Element linea : lineas) {
            l++;
        }
        System.out.println("lineas: "+l);

        for (Element parrafo : parrafos) {
            i++;
        }
        System.out.println("parrafos: "+i);

        for (Element imagen : imagenes) {
            j++;
        }
        System.out.println("imagenes "+j);

        ArrayList<Elements> inputs = new ArrayList<Elements>();

        for (Element form : formularios) {
            inputs.add(form.getElementsByTag("input"));
        }
        for (Elements items : inputs) {
            for (Element input : items) {
                String type = input.attr("type");
                System.out.println("Tipo: " + type + " - Campo: " + input);
            }
        }

        for (Element formulario : formularios) {
                k1++;
                if(formulario.hasAttr("GET"))
                    k2++;
        }
        System.out.println("formularios GET: "+k1+"\nformularios POST:"+k2);
    }

}
