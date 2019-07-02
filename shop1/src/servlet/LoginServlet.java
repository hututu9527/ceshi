package servlet;

import dao.User;
import model.LoginModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String loginAccount = request.getParameter("loginAccount");
        String loginPassword = request.getParameter("loginPassword");
        User user = new User(loginAccount,loginPassword);
        boolean result = LoginModel.login(user);
        System.out.println("��¼�˺ţ�"+loginAccount+",��½���룺"+loginPassword+",��¼���"+result);
        response.setCharacterEncoding("UTF-8");
        //ͨ��PrintWriter���ظ��ͻ��˲������
        PrintWriter writer = response.getWriter();
        writer.print(result);
    }
}