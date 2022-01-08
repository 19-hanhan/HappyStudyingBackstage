package cn.edu.jxnu.HappyStudyingBackstage.servlet.login;

import cn.edu.jxnu.HappyStudyingBackstage.util.CodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "VerificationCodeServlet", value = "/VerificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map map = CodeUtil.generateCodeAndPic();
        String code = map.get("code").toString();
        BufferedImage img = (BufferedImage)map.get("codePic");

        HttpSession session = request.getSession();
        session.setAttribute("verificationCode", code);

        response.setContentType("image/jpeg"); // 设定输出类型
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(img, "jpeg", out);
    }
}
