package com.uniyaz.javaee;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonIslemleri implements Servlet {

    static List<Person> personList = new ArrayList();

    public void init(ServletConfig servletConfig) throws ServletException {


    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        String tip = servletRequest.getParameter("tip");
        
        //      Person person = new Person(ad, soyad);

        if (tip.equals("kaydet")) {
            personKaydet(servletRequest, servletResponse);


        } else if (tip.equals("listele")) {
            personListele(servletResponse);


        }

    }

    public static void personKaydet(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        String ad = servletRequest.getParameter("ad");
        String soyad = servletRequest.getParameter("soyad");
        Person person = new Person(ad, soyad);
        System.out.println("kaydetti");
        personList.add(person);
        String html =
                "<html> \n" +
                        "\t<head> \n" +
                        "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                        "\t\t<title>Web Ödevi</title>\n" +
                        "\t</head>\n" +
                        "\t<body>\n" +
                        "\t\t****Adınız ve Soyadınız Kaydedildi...****\n" + "\n" +
                        "<br>" +
                        "<br>\t\tAd:" + person.getAd() +
                        "<br>\t\tSoyad:" + person.getSoyad() +
                        "\t</body>\n" +
                        "</html>\n";
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write(html);


    }

    public static void personListele(ServletResponse servletResponse) throws IOException {

        System.out.println("listeledi");
        String listele =
                "<html> \n" +
                        "\t<head> \n" +
                        "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                        "\t\t<title>Web Ödevi</title>\n" +
                        "\t</head>\n" +
                        "\t<body>\n" +
                        "\t\t******LİSTELEME*****\n" + "\n" +
                        "\t</body>\n" +
                        "</html>\n";

        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write(listele);

        for (Person personList : personList) {
            String html =

                    "<html> \n" +
                            "\t<head> \n" +
                            "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                            "\t\t<title>Web Ödevi</title>\n" +
                            "\t</head>\n" +
                            "\t<body>\n" +
                            "<ul> " +
                            "<li>" + personList.getAd() + " " + personList.getSoyad() +
                            "</li> " +
                            "</ul>" +
                            "\t</body>\n" +
                            "</html>\n";

            System.out.println("\nAd=" + personList.getAd() + "\t\t" + "Soyad=" + personList.getSoyad());
            servletResponse.getWriter().write(html);
            servletResponse.setCharacterEncoding("UTF-8");


        }
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
    }


}

