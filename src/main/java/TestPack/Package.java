package TestPack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

    @WebServlet(description = "Package")
    public class Package extends HttpServlet {
        private static final long serialVersionUID = 1L;

        public String[] method(){
            String[] strings = new String[6];
            String mark = "*";
            for(int i = 0; i < strings.length; i++){
                strings[i] = mark;
                mark += mark;
            }
            return strings;
        }


//        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//            request.setAttribute("attr1", "someVar");
//            RequestDispatcher rd;
//            rd = getServletContext().getRequestDispatcher("/servletExample.jsp");
//            rd.forward(request, response);
////            request.setAttribute("display Data", "I am from the servlet");
////            getServletConfig().getServletContext().getRequestDispatcher("/servletExample.jsp")
////                    .forward(request, response);
////            processRequest(request, response);
//        }
//
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//
//        }
    }

//        public class Message {
//            String message;
//
//            public Message(String message) {
//                this.message = message;
//            }
//
//            public String getMessage() {
//                return message;
//            }
//
//            public void setMessage(String message) {
//                this.message = message;
//            }
//        }

//        public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            List<String> strings = new ArrayList<String>();
//            String smth = "*";
//            for (int i = 0; i < 4; i++) {
//                strings.add(smth);
//                smth += smth;
//                Message message = new Message(smth);
//                request.setAttribute(smth, message);
////                request.getRequestDispatcher("/home/sarunas/Codebaker/StackDocMvn/web/index.jsp").forward(request, response);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("web/index.jsp");
//                dispatcher.forward(request,response);
////                getServletContext().
//
//            }
//        }


// bazine struktura = models, services, views, controller. implement, stylas, external (kas tiesiogiai projekte nera, sql ten)
// design (cia jei kist stylus, images, css, viskas su stilizacija, galima dar vadint internal),

// model = carBL - bussiness layer(tas objektas su kuriuo jus dirbsit javos viduje, jis neturi ristis prie isores, tik prie backo),
// carDAL - data access layers (mirrors db, orm abriacija, pakelineje duomenis is duombazes, atskirimas nuo db),
// carDTO - data transfer object (boolean success, message, dataobject - struktura, checkinimas db ar viskas galutinai pavyko, ir kur crashino
// abstrakcija - kuo aukstesniu lygiu, tuo labiau specializuota, klasikinis message transferinimas
// kur antras budas naudojama - checkinimas, jeigu viskas ok tada, i carBL jei ne ok tada i logine klaida
// carExtended - tik tam tikrais atvejais naudojamas modelis (pagrinde mums nereikalingas, pvz isblackfriday)