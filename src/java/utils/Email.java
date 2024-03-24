/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.LocalDateTime;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author AD
 */
public class Email {

    private final String eFrom = "prjonlineshop@gmail.com";
    private final String ePass = "aomp fnes rkqu vsrr";
//    private final String eFrom = "lvhhoangg1@gmail.com";
//    private final String ePass = "ojlx ohfr qxwd llxx";

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        Pattern pattern = Pattern.compile(emailRegex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public void sendEmail(String subject, String message, String to) {
        try {

        } catch (Exception e) {
        }

        Properties props = new Properties();
        //su dung server nao de gui gmail mail-smtp host
        props.put("mail.smtp.host", "smtp.gmail.com");
        //tls 587 ssl 465
        props.put("mail.smtp.port", "smtp.gmail.com");
        //dang nhap
        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        Authenticator au = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(eFrom, ePass);
            }
        };
          
        Session session = Session.getInstance(props, au);
        try{
           MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML, charset=UTF-8");
            msg.setFrom(new InternetAddress(eFrom));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // tieu de
            msg.setSubject(subject, "UTF-8");
            // Noi dung
            msg.setContent(message, "text/html; charset=UTF-8");
            // Gui email
            Transport.send(msg);
            
        }catch(Exception e){
            System.out.println("Send email failed");
            e.printStackTrace();
        }
                
    }
    
    public String subjectOrder(String fullname){
        return "Xin chào, " + fullname + " cảm ơn bạn đã mua hàng ở cửa hàng của chúng tôi";
    }
    
    public String subjectForgotPass(){
        return "Đặt lại mật khẩu";
    }
    
    public String messageOrder(LocalDateTime date, double totalMoney, String address) {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "  <meta charset=\"utf-8\">\n"
                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "  <style>\n"
                + "    body {\n"
                + "      font-family: Arial, sans-serif;\n"
                + "      background-color: #f4f4f4;\n"
                + "      margin: 0;\n"
                + "      padding: 0;\n"
                + "    }\n"
                + "\n"
                + "    .email-container {\n"
                + "      max-width: 600px;\n"
                + "      margin: 20px auto;\n"
                + "      background-color: #fff;\n"
                + "      border-radius: 8px;\n"
                + "      overflow: hidden;\n"
                + "      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n"
                + "    }\n"
                + "\n"
                + "    .header {\n"
                + "      background-color: #3498db;\n"
                + "      color: #fff;\n"
                + "      padding: 20px;\n"
                + "      text-align: center;\n"
                + "    }\n"
                + "\n"
                + "    .content {\n"
                + "      padding: 20px;\n"
                + "    }\n"
                + "\n"
                + "    .discount-code {\n"
                + "      background-color: #e74c3c;\n"
                + "      color: #fff;\n"
                + "      padding: 10px;\n"
                + "      text-align: center;\n"
                + "      margin-bottom: 20px;\n"
                + "      font-size: 20px;\n"
                + "      border-radius: 4px;\n"
                + "    }\n"
                + "\n"
                + "    .footer {\n"
                + "      background-color: #3498db;\n"
                + "      color: #fff;\n"
                + "      padding: 10px;\n"
                + "      text-align: center;\n"
                + "    }\n"
                + "  </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "  <div class=\"email-container\">\n"
                + "    <div class=\"header\">\n"
                + "     <h1>Male Fashion</h1>\n "
                + "<h4>Group 9</h4>"
                + "      <h2>Đơn hàng đang trên đường đến với bạn!</h2>\n"
                + "    </div>\n"
                + "    <div class=\"content\">\n"
                + "      <h3>Thông tin:</h3>\n"
                + "      <p>Ngày mua: " + date + "</p>\n"
                + "      <p>Tổng tiền: " + totalMoney + " VND</p>\n"
                + "      <p>Địa chỉ: " + address + "</p>\n"
                + "      <p>Mọi thắc mắc xin liên hệ 0976652503.</p>\n"
                + "      <p>Chúng tôi luôn sẵn sàn!</p>\n"
                + "    </div>\n"
                + "    <div class=\"footer\">\n"
                + "      <p>Cảm ơn bạn đã ủng hộ chúng tôi!</p>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "</body>\n"
                + "</html>";
    }

    public String messageForgotPass(String name,int code) {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Password Reset Code</title>\n"
                + "</head>\n"
                + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0;\">\n"
                + "\n"
                + "    <table style=\"width: 100%; max-width: 600px; margin: 20px auto; background-color: #ffffff; border-collapse: collapse;\">\n"
                + "        <tr>\n"
                + "            <td style=\"padding: 20px; text-align: center; background-color: #4CAF50; color: #ffffff; font-size: 24px;\">\n"
                + "                Đặt lại mật khẩu\n"
                + "            </td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td style=\"padding: 20px;\">\n"
                + "                <p>Xin chào "+name+",</p>\n"
                + "                <p>Mã xác minh: </p>\n"
                + "                <p style=\"font-size: 28px; font-weight: bold; color: #4CAF50;\">" + code + "</p>\n"
                + "                <p>Nếu không cần thiết xin vui lòng bỏ qua.</p>\n"
                + "                <p>Xin trân trọng cảm ơn!</p>\n"
                + "            </td>\n"
                + "        </tr>\n"
                + "        <tr>\n"
                + "            <td style=\"padding: 20px; text-align: center; background-color: #4CAF50; color: #ffffff;\">\n"
                + "                &copy; 2024 Group 9 PRJ301\n"
                + "            </td>\n"
                + "        </tr>\n"
                + "    </table>\n"
                + "\n"
                + "</body>\n"
                + "</html>";
    }
    
    public static void main(String[] args) {
        String to = "nguyenhavietanh2503@gmail.com";
        
        Email email = new Email();
        email.sendEmail(email.subjectOrder(to), email.messageOrder(LocalDateTime.now(), 10, "Thủ Đức"), to);
    }

}
