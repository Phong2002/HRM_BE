package com.phenikaa.hrm.Business_Logic_Layer;


import com.phenikaa.hrm.Data_Access_Layer.UserRepository;
import com.phenikaa.hrm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Component
@Transactional
@Service
public class EmailService implements IEmailService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private JavaMailSender mailSender;



	@Override
	public void sendNotification(String email,String subjectx,String contents) throws MessagingException, UnsupportedEncodingException {
		User user = userRepository.findByEmail(email);
		String subject = subjectx;
		String gmail = email;
		String content = "<!DOCTYPE html>\n" +
				"\n" +
				"<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
				"<head>\n" +
				"<title></title>\n" +
				"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
				"<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\n" +
				"<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
				"<style>\n" +
				"\t\t* {\n" +
				"\t\t\tbox-sizing: border-box;\n" +
				"\t\t}\n" +
				"\n" +
				"html{\n" +
				"\t\t\twidth: 100%;\n" +
				"\t\t\theight: 100%;\n" +
				"\t\t}\n" +
				"\t\t\n" +
				"\t\tbody {\n" +
				"\t\t\twidth: 100%;\n" +
				"\t\t\theight: 100%;" +
				"\t\t\tmargin: 0;\n" +
				"\t\t\tpadding: 0;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\ta[x-apple-data-detectors] {\n" +
				"\t\t\tcolor: inherit !important;\n" +
				"\t\t\ttext-decoration: inherit !important;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t#MessageViewBody a {\n" +
				"\t\t\tcolor: inherit;\n" +
				"\t\t\ttext-decoration: none;\n" +
				"\t\t}\n" +
				"\n" +
				"\t\tp {\n" +
				"\t\t\tline-height: inherit\n" +
				"\t\t}\n" +
				"\n" +
				"\t\t@media (max-width:500px) {\n" +
				"\t\t\t.icons-inner {\n" +
				"\t\t\t\ttext-align: center;\n" +
				"\t\t\t}\n" +
				"\n" +
				"\t\t\t.icons-inner td {\n" +
				"\t\t\t\tmargin: 0 auto;\n" +
				"\t\t\t}\n" +
				"\n" +
				"\t\t\t.row-content {\n" +
				"\t\t\t\twidth: 100% !important;\n" +
				"\t\t\t}\n" +
				"\n" +
				"\t\t\t.column .border {\n" +
				"\t\t\t\tdisplay: none;\n" +
				"\t\t\t}\n" +
				"\n" +
				"\t\t\ttable {\n" +
				"\t\t\t\ttable-layout: fixed !important;\n" +
				"\t\t\t}\n" +
				"\n" +
				"\t\t\t.stack .column {\n" +
				"\t\t\t\twidth: 100%;\n" +
				"\t\t\t\tdisplay: block;\n" +
				"\t\t\t}\n" +
				"\t\t}\n" +
				"\t</style>\n" +
				"</head>\n" +
				"<body style=\"background-color: #e5e9f3; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e5e9f3;\" width=\"100%\">\n" +
				"<tbody><tr><td>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #a5dbf8;\" width=\"100%\">\n" +
				"<tbody><tr><td>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 480px;\" width=\"480\">\n" +
				"<tbody><tr>\n" +
				"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 10px; padding-right: 10px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tr>\n" +
				"<td style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:10px;padding-bottom:10px;\">\n" +
				"<div align=\"center\" style=\"line-height:10px\"><img src=\"https://cdn.discordapp.com/attachments/948104314432389150/954697000731934770/HRM_Logo.png?fbclid=IwAR0kkThW2JvCUG3OPIMOridvyAVPF6kHaSctOCqUjADR6PuSqBVaZ_nd91g\" style=\"display: block; height: auto; border: 0; width: 100px; max-width: 100%;\" width=\"100\"/></div>\n" +
				"</td></tr></table></td>\n" +
				"<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"75%\">\n" +
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tr>\n" +
				"<td style=\"width:100%;text-align:center;padding-top:45px;padding-bottom:5px;\">\n" +
				"<h1 style=\"margin: 0; color: #20693e; font-size: 24px; font-family: 'Ubuntu', Tahoma, Verdana, Segoe, sans-serif; line-height: 120%; text-align: center; direction: ltr; font-weight: 700; letter-spacing: normal; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">Human Resource <strong>Management</strong></span></h1>\n" +
				"</td></tr></table></td></tr></tbody></table></td></tr></tbody></table>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tbody>\n" +
				"<tr><td>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 480px;\" width=\"480\">\n" +
				"<tbody>\n" +
				"<tr>\n" +
				"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tr>\n" +
				"<td style=\"width:100%;text-align:center;\">\n" +
				"<h1 style=\"margin: 0; color: #555555; font-size: 23px; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; line-height: 120%; text-align: center; direction: ltr; font-weight: 700; letter-spacing: normal; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">Thông báo</span></h1>\n" +
				"</td></tr>\n" +
				"</table></td></tr></tbody></table></td></tr></tbody>\n" +
				"</table>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tbody>\n" +
				"<tr>\n" +
				"<td>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 480px;\" width=\"480\">\n" +
				"<tbody>\n" +
				"<tr>\n" +
				"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tr>\n" +
				"<td style=\"width:100%;text-align:center;\">\n" +
				"<h3 style=\"margin: 0; color: #555555; font-size: 16px; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; line-height: 120%; text-align: left; direction: ltr; font-weight: 700; letter-spacing: normal; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">Gửi đến : "+user.getFirstname()+" "+user.getLastname() +
				"</td></tr></table></td></tr></tbody></table></td></tr></tbody></table>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tbody>\n" +
				"<tr><td>\n" +
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 480px;\" width=\"480\">\n" +
				"<tbody><tr>\n" +
				"<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
				"<tr>\n" +
				"<td style=\"width:100%;text-align:center;\">\n" +
				"<h3 style=\"margin: 0; color: #555555; font-size: 16px; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; line-height: 120%; text-align: left; direction: ltr; font-weight: 700; letter-spacing: normal; margin-top: 0; margin-bottom: 0;\"><span class=\"tinyMce-placeholder\">Nội dung : "+contents+" </span></h3>\n" +
				"</td>\n" +
				"</tr>\n" +
				"</table>\n" +
				"</td>\n" +
				"</tr>\n" +
				"</tbody>\n" +
				"</table>\n" +
				"</td>\n" +
				"</tr>\n" +
				"</tbody>\n" +
				"</table>\n" +
				"</td>\n" +
				"</tr>\n" +
				"</tbody>\n" +
				"</table><!-- End -->\n" +
				"</body>\n" +
				"</html>";

		sendEmail(gmail,subject,content);
	}

	@Override
	public void sendRequestResetPasswordSuccessfully(String email,String newPassword) throws MessagingException, UnsupportedEncodingException {
		User user = userRepository.findByEmail(email);
		String gmail = email;
		String content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
				"\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
				"    <meta name=\"x-apple-disable-message-reformatting\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
				"    <meta content=\"telephone=no\" name=\"format-detection\">\n" +
				"    <title></title>\n" +
				"\n" +
				"    <style>\n" +
				"        /* CONFIG STYLES Please do not delete and edit CSS styles below */\n" +
				"\n" +
				"\n" +
				"/* IMPORTANT THIS STYLES MUST BE ON FINAL EMAIL */\n" +
				"\n" +
				"#outlook a {\n" +
				"    padding: 0;\n" +
				"}\n" +
				"\n" +
				".ExternalClass {\n" +
				"    width: 100%;\n" +
				"}\n" +
				"\n" +
				".ExternalClass,\n" +
				".ExternalClass p,\n" +
				".ExternalClass span,\n" +
				".ExternalClass font,\n" +
				".ExternalClass td,\n" +
				".ExternalClass div {\n" +
				"    line-height: 100%;\n" +
				"}\n" +
				"\n" +
				".es-button {\n" +
				"    mso-style-priority: 100 !important;\n" +
				"    text-decoration: none !important;\n" +
				"}\n" +
				"\n" +
				"a[x-apple-data-detectors] {\n" +
				"    color: inherit !important;\n" +
				"    text-decoration: none !important;\n" +
				"    font-size: inherit !important;\n" +
				"    font-family: inherit !important;\n" +
				"    font-weight: inherit !important;\n" +
				"    line-height: inherit !important;\n" +
				"}\n" +
				"\n" +
				".es-desk-hidden {\n" +
				"    display: none;\n" +
				"    float: left;\n" +
				"    overflow: hidden;\n" +
				"    width: 0;\n" +
				"    max-height: 0;\n" +
				"    line-height: 0;\n" +
				"    mso-hide: all;\n" +
				"}\n" +
				"\n" +
				".es-button-border:hover a.es-button,\n" +
				".es-button-border:hover button.es-button {\n" +
				"    background: #ffffff !important;\n" +
				"    border-color: #ffffff !important;\n" +
				"}\n" +
				"\n" +
				".es-button-border:hover {\n" +
				"    background: #ffffff !important;\n" +
				"    border-style: solid solid solid solid !important;\n" +
				"    border-color: #3d5ca3 #3d5ca3 #3d5ca3 #3d5ca3 !important;\n" +
				"}\n" +
				"\n" +
				"[data-ogsb] .es-button {\n" +
				"    border-width: 0 !important;\n" +
				"    padding: 15px 20px 15px 20px !important;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"/*\n" +
				"END OF IMPORTANT\n" +
				"*/\n" +
				"\n" +
				"s {\n" +
				"    text-decoration: line-through;\n" +
				"}\n" +
				"\n" +
				"html,\n" +
				"body {\n" +
				"    width: 100%;\n" +
				"    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
				"    -webkit-text-size-adjust: 100%;\n" +
				"    -ms-text-size-adjust: 100%;\n" +
				"}\n" +
				"\n" +
				"table {\n" +
				"    mso-table-lspace: 0pt;\n" +
				"    mso-table-rspace: 0pt;\n" +
				"    border-collapse: collapse;\n" +
				"    border-spacing: 0px;\n" +
				"}\n" +
				"\n" +
				"table td,\n" +
				"html,\n" +
				"body,\n" +
				".es-wrapper {\n" +
				"    padding: 0;\n" +
				"    Margin: 0;\n" +
				"}\n" +
				"\n" +
				".es-content,\n" +
				".es-header,\n" +
				".es-footer {\n" +
				"    table-layout: fixed !important;\n" +
				"    width: 100%;\n" +
				"}\n" +
				"\n" +
				"img {\n" +
				"    display: block;\n" +
				"    border: 0;\n" +
				"    outline: none;\n" +
				"    text-decoration: none;\n" +
				"    -ms-interpolation-mode: bicubic;\n" +
				"}\n" +
				"\n" +
				"table tr {\n" +
				"    border-collapse: collapse;\n" +
				"}\n" +
				"\n" +
				"p,\n" +
				"hr {\n" +
				"    Margin: 0;\n" +
				"}\n" +
				"\n" +
				"h1,\n" +
				"h2,\n" +
				"h3,\n" +
				"h4,\n" +
				"h5 {\n" +
				"    Margin: 0;\n" +
				"    line-height: 120%;\n" +
				"    mso-line-height-rule: exactly;\n" +
				"    font-family: arial, 'helvetica neue', helvetica, sans-serif;\n" +
				"}\n" +
				"\n" +
				"p,\n" +
				"ul li,\n" +
				"ol li,\n" +
				"a {\n" +
				"    -webkit-text-size-adjust: none;\n" +
				"    -ms-text-size-adjust: none;\n" +
				"    mso-line-height-rule: exactly;\n" +
				"}\n" +
				"\n" +
				".es-left {\n" +
				"    float: left;\n" +
				"}\n" +
				"\n" +
				".es-right {\n" +
				"    float: right;\n" +
				"}\n" +
				"\n" +
				".es-p5 {\n" +
				"    padding: 5px;\n" +
				"}\n" +
				"\n" +
				".es-p5t {\n" +
				"    padding-top: 5px;\n" +
				"}\n" +
				"\n" +
				".es-p5b {\n" +
				"    padding-bottom: 5px;\n" +
				"}\n" +
				"\n" +
				".es-p5l {\n" +
				"    padding-left: 5px;\n" +
				"}\n" +
				"\n" +
				".es-p5r {\n" +
				"    padding-right: 5px;\n" +
				"}\n" +
				"\n" +
				".es-p10 {\n" +
				"    padding: 10px;\n" +
				"}\n" +
				"\n" +
				".es-p10t {\n" +
				"    padding-top: 10px;\n" +
				"}\n" +
				"\n" +
				".es-p10b {\n" +
				"    padding-bottom: 10px;\n" +
				"}\n" +
				"\n" +
				".es-p10l {\n" +
				"    padding-left: 10px;\n" +
				"}\n" +
				"\n" +
				".es-p10r {\n" +
				"    padding-right: 10px;\n" +
				"}\n" +
				"\n" +
				".es-p15 {\n" +
				"    padding: 15px;\n" +
				"}\n" +
				"\n" +
				".es-p15t {\n" +
				"    padding-top: 15px;\n" +
				"}\n" +
				"\n" +
				".es-p15b {\n" +
				"    padding-bottom: 15px;\n" +
				"}\n" +
				"\n" +
				".es-p15l {\n" +
				"    padding-left: 15px;\n" +
				"}\n" +
				"\n" +
				".es-p15r {\n" +
				"    padding-right: 15px;\n" +
				"}\n" +
				"\n" +
				".es-p20 {\n" +
				"    padding: 20px;\n" +
				"}\n" +
				"\n" +
				".es-p20t {\n" +
				"    padding-top: 20px;\n" +
				"}\n" +
				"\n" +
				".es-p20b {\n" +
				"    padding-bottom: 20px;\n" +
				"}\n" +
				"\n" +
				".es-p20l {\n" +
				"    padding-left: 20px;\n" +
				"}\n" +
				"\n" +
				".es-p20r {\n" +
				"    padding-right: 20px;\n" +
				"}\n" +
				"\n" +
				".es-p25 {\n" +
				"    padding: 25px;\n" +
				"}\n" +
				"\n" +
				".es-p25t {\n" +
				"    padding-top: 25px;\n" +
				"}\n" +
				"\n" +
				".es-p25b {\n" +
				"    padding-bottom: 25px;\n" +
				"}\n" +
				"\n" +
				".es-p25l {\n" +
				"    padding-left: 25px;\n" +
				"}\n" +
				"\n" +
				".es-p25r {\n" +
				"    padding-right: 25px;\n" +
				"}\n" +
				"\n" +
				".es-p30 {\n" +
				"    padding: 30px;\n" +
				"}\n" +
				"\n" +
				".es-p30t {\n" +
				"    padding-top: 30px;\n" +
				"}\n" +
				"\n" +
				".es-p30b {\n" +
				"    padding-bottom: 30px;\n" +
				"}\n" +
				"\n" +
				".es-p30l {\n" +
				"    padding-left: 30px;\n" +
				"}\n" +
				"\n" +
				".es-p30r {\n" +
				"    padding-right: 30px;\n" +
				"}\n" +
				"\n" +
				".es-p35 {\n" +
				"    padding: 35px;\n" +
				"}\n" +
				"\n" +
				".es-p35t {\n" +
				"    padding-top: 35px;\n" +
				"}\n" +
				"\n" +
				".es-p35b {\n" +
				"    padding-bottom: 35px;\n" +
				"}\n" +
				"\n" +
				".es-p35l {\n" +
				"    padding-left: 35px;\n" +
				"}\n" +
				"\n" +
				".es-p35r {\n" +
				"    padding-right: 35px;\n" +
				"}\n" +
				"\n" +
				".es-p40 {\n" +
				"    padding: 40px;\n" +
				"}\n" +
				"\n" +
				".es-p40t {\n" +
				"    padding-top: 40px;\n" +
				"}\n" +
				"\n" +
				".es-p40b {\n" +
				"    padding-bottom: 40px;\n" +
				"}\n" +
				"\n" +
				".es-p40l {\n" +
				"    padding-left: 40px;\n" +
				"}\n" +
				"\n" +
				".es-p40r {\n" +
				"    padding-right: 40px;\n" +
				"}\n" +
				"\n" +
				".es-menu td {\n" +
				"    border: 0;\n" +
				"}\n" +
				"\n" +
				".es-menu td a img {\n" +
				"    display: inline-block !important;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"/* END CONFIG STYLES */\n" +
				"\n" +
				"a {\n" +
				"    text-decoration: none;\n" +
				"}\n" +
				"\n" +
				"p,\n" +
				"ul li,\n" +
				"ol li {\n" +
				"    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
				"    line-height: 150%;\n" +
				"}\n" +
				"\n" +
				"ul li,\n" +
				"ol li {\n" +
				"    Margin-bottom: 15px;\n" +
				"    margin-left: 0;\n" +
				"}\n" +
				"\n" +
				".es-menu td a {\n" +
				"    text-decoration: none;\n" +
				"    display: block;\n" +
				"    font-family: helvetica, 'helvetica neue', arial, verdana, sans-serif;\n" +
				"}\n" +
				"\n" +
				".es-wrapper {\n" +
				"    width: 100%;\n" +
				"    height: 100%;\n" +
				"    background-image: ;\n" +
				"    background-repeat: repeat;\n" +
				"    background-position: center top;\n" +
				"}\n" +
				"\n" +
				".es-wrapper-color {\n" +
				"    background-color: #fafafa;\n" +
				"}\n" +
				"\n" +
				".es-header {\n" +
				"    background-color: transparent;\n" +
				"    background-image: ;\n" +
				"    background-repeat: repeat;\n" +
				"    background-position: center top;\n" +
				"}\n" +
				"\n" +
				".es-header-body {\n" +
				"    background-color: #ffffff;\n" +
				"}\n" +
				"\n" +
				".es-header-body p,\n" +
				".es-header-body ul li,\n" +
				".es-header-body ol li {\n" +
				"    color: #333333;\n" +
				"    font-size: 14px;\n" +
				"}\n" +
				"\n" +
				".es-header-body a {\n" +
				"    color: #1376c8;\n" +
				"    font-size: 14px;\n" +
				"}\n" +
				"\n" +
				".es-content-body {\n" +
				"    background-color: #ffffff;\n" +
				"}\n" +
				"\n" +
				".es-content-body p,\n" +
				".es-content-body ul li,\n" +
				".es-content-body ol li {\n" +
				"    color: #666666;\n" +
				"    font-size: 16px;\n" +
				"}\n" +
				"\n" +
				".es-content-body a {\n" +
				"    color: #0b5394;\n" +
				"    font-size: 16px;\n" +
				"}\n" +
				"\n" +
				".es-footer {\n" +
				"    background-color: transparent;\n" +
				"    background-image: ;\n" +
				"    background-repeat: repeat;\n" +
				"    background-position: center top;\n" +
				"}\n" +
				"\n" +
				".es-footer-body {\n" +
				"    background-color: transparent;\n" +
				"}\n" +
				"\n" +
				".es-footer-body p,\n" +
				".es-footer-body ul li,\n" +
				".es-footer-body ol li {\n" +
				"    color: #333333;\n" +
				"    font-size: 14px;\n" +
				"}\n" +
				"\n" +
				".es-footer-body a {\n" +
				"    color: #333333;\n" +
				"    font-size: 14px;\n" +
				"}\n" +
				"\n" +
				".es-infoblock,\n" +
				".es-infoblock p,\n" +
				".es-infoblock ul li,\n" +
				".es-infoblock ol li {\n" +
				"    line-height: 120%;\n" +
				"    font-size: 12px;\n" +
				"    color: #cccccc;\n" +
				"}\n" +
				"\n" +
				".es-infoblock a {\n" +
				"    font-size: 12px;\n" +
				"    color: #cccccc;\n" +
				"}\n" +
				"\n" +
				"h1 {\n" +
				"    font-size: 20px;\n" +
				"    font-style: normal;\n" +
				"    font-weight: normal;\n" +
				"    color: #333333;\n" +
				"}\n" +
				"\n" +
				"h2 {\n" +
				"    font-size: 14px;\n" +
				"    font-style: normal;\n" +
				"    font-weight: normal;\n" +
				"    color: #333333;\n" +
				"}\n" +
				"\n" +
				"h3 {\n" +
				"    font-size: 20px;\n" +
				"    font-style: normal;\n" +
				"    font-weight: normal;\n" +
				"    color: #333333;\n" +
				"}\n" +
				"\n" +
				".es-header-body h1 a,\n" +
				".es-content-body h1 a,\n" +
				".es-footer-body h1 a {\n" +
				"    font-size: 20px;\n" +
				"}\n" +
				"\n" +
				".es-header-body h2 a,\n" +
				".es-content-body h2 a,\n" +
				".es-footer-body h2 a {\n" +
				"    font-size: 14px;\n" +
				"}\n" +
				"\n" +
				".es-header-body h3 a,\n" +
				".es-content-body h3 a,\n" +
				".es-footer-body h3 a {\n" +
				"    font-size: 20px;\n" +
				"}\n" +
				"\n" +
				"a.es-button,\n" +
				"button.es-button {\n" +
				"    border-style: solid;\n" +
				"    border-color: #ffffff;\n" +
				"    border-width: 15px 20px 15px 20px;\n" +
				"    display: inline-block;\n" +
				"    background: #ffffff;\n" +
				"    border-radius: 10px;\n" +
				"    font-size: 14px;\n" +
				"    font-family: arial, 'helvetica neue', helvetica, sans-serif;\n" +
				"    font-weight: bold;\n" +
				"    font-style: normal;\n" +
				"    line-height: 120%;\n" +
				"    color: #3D5CA3;\n" +
				"    text-decoration: none;\n" +
				"    width: auto;\n" +
				"    text-align: center;\n" +
				"}\n" +
				"\n" +
				".es-button-border {\n" +
				"    border-style: solid solid solid solid;\n" +
				"    border-color: #3d5ca3 #3d5ca3 #3d5ca3 #3d5ca3;\n" +
				"    background: #ffffff;\n" +
				"    border-width: 2px 2px 2px 2px;\n" +
				"    display: inline-block;\n" +
				"    border-radius: 10px;\n" +
				"    width: auto;\n" +
				"}\n" +
				"\n" +
				"\n" +
				"/* RESPONSIVE STYLES Please do not delete and edit CSS styles below. If you don't need responsive layout, please delete this section. */\n" +
				"\n" +
				"@media only screen and (max-width: 600px) {\n" +
				"    p,\n" +
				"    ul li,\n" +
				"    ol li,\n" +
				"    a {\n" +
				"        line-height: 150% !important;\n" +
				"    }\n" +
				"    h1,\n" +
				"    h2,\n" +
				"    h3,\n" +
				"    h1 a,\n" +
				"    h2 a,\n" +
				"    h3 a {\n" +
				"        line-height: 120% !important;\n" +
				"    }\n" +
				"    h1 {\n" +
				"        font-size: 20px !important;\n" +
				"        text-align: center;\n" +
				"    }\n" +
				"    h2 {\n" +
				"        font-size: 16px !important;\n" +
				"        text-align: left;\n" +
				"    }\n" +
				"    h3 {\n" +
				"        font-size: 20px !important;\n" +
				"        text-align: center;\n" +
				"    }\n" +
				"    .es-header-body h1 a,\n" +
				"    .es-content-body h1 a,\n" +
				"    .es-footer-body h1 a {\n" +
				"        font-size: 20px !important;\n" +
				"    }\n" +
				"    h2 a {\n" +
				"        text-align: left;\n" +
				"    }\n" +
				"    .es-header-body h2 a,\n" +
				"    .es-content-body h2 a,\n" +
				"    .es-footer-body h2 a {\n" +
				"        font-size: 16px !important;\n" +
				"    }\n" +
				"    .es-header-body h3 a,\n" +
				"    .es-content-body h3 a,\n" +
				"    .es-footer-body h3 a {\n" +
				"        font-size: 20px !important;\n" +
				"    }\n" +
				"    .es-menu td a {\n" +
				"        font-size: 14px !important;\n" +
				"    }\n" +
				"    .es-header-body p,\n" +
				"    .es-header-body ul li,\n" +
				"    .es-header-body ol li,\n" +
				"    .es-header-body a {\n" +
				"        font-size: 10px !important;\n" +
				"    }\n" +
				"    .es-content-body p,\n" +
				"    .es-content-body ul li,\n" +
				"    .es-content-body ol li,\n" +
				"    .es-content-body a {\n" +
				"        font-size: 16px !important;\n" +
				"    }\n" +
				"    .es-footer-body p,\n" +
				"    .es-footer-body ul li,\n" +
				"    .es-footer-body ol li,\n" +
				"    .es-footer-body a {\n" +
				"        font-size: 12px !important;\n" +
				"    }\n" +
				"    .es-infoblock p,\n" +
				"    .es-infoblock ul li,\n" +
				"    .es-infoblock ol li,\n" +
				"    .es-infoblock a {\n" +
				"        font-size: 12px !important;\n" +
				"    }\n" +
				"    *[class=\"gmail-fix\"] {\n" +
				"        display: none !important;\n" +
				"    }\n" +
				"    .es-m-txt-c,\n" +
				"    .es-m-txt-c h1,\n" +
				"    .es-m-txt-c h2,\n" +
				"    .es-m-txt-c h3 {\n" +
				"        text-align: center !important;\n" +
				"    }\n" +
				"    .es-m-txt-r,\n" +
				"    .es-m-txt-r h1,\n" +
				"    .es-m-txt-r h2,\n" +
				"    .es-m-txt-r h3 {\n" +
				"        text-align: right !important;\n" +
				"    }\n" +
				"    .es-m-txt-l,\n" +
				"    .es-m-txt-l h1,\n" +
				"    .es-m-txt-l h2,\n" +
				"    .es-m-txt-l h3 {\n" +
				"        text-align: left !important;\n" +
				"    }\n" +
				"    .es-m-txt-r img,\n" +
				"    .es-m-txt-c img,\n" +
				"    .es-m-txt-l img {\n" +
				"        display: inline !important;\n" +
				"    }\n" +
				"    .es-button-border {\n" +
				"        display: block !important;\n" +
				"    }\n" +
				"    a.es-button,\n" +
				"    button.es-button {\n" +
				"        font-size: 14px !important;\n" +
				"        display: block !important;\n" +
				"        border-left-width: 0px !important;\n" +
				"        border-right-width: 0px !important;\n" +
				"    }\n" +
				"    .es-btn-fw {\n" +
				"        border-width: 10px 0px !important;\n" +
				"        text-align: center !important;\n" +
				"    }\n" +
				"    .es-adaptive table,\n" +
				"    .es-btn-fw,\n" +
				"    .es-btn-fw-brdr,\n" +
				"    .es-left,\n" +
				"    .es-right {\n" +
				"        width: 100% !important;\n" +
				"    }\n" +
				"    .es-content table,\n" +
				"    .es-header table,\n" +
				"    .es-footer table,\n" +
				"    .es-content,\n" +
				"    .es-footer,\n" +
				"    .es-header {\n" +
				"        width: 100% !important;\n" +
				"        max-width: 600px !important;\n" +
				"    }\n" +
				"    .es-adapt-td {\n" +
				"        display: block !important;\n" +
				"        width: 100% !important;\n" +
				"    }\n" +
				"    .adapt-img {\n" +
				"        width: 100% !important;\n" +
				"        height: auto !important;\n" +
				"    }\n" +
				"    .es-m-p0 {\n" +
				"        padding: 0px !important;\n" +
				"    }\n" +
				"    .es-m-p0r {\n" +
				"        padding-right: 0px !important;\n" +
				"    }\n" +
				"    .es-m-p0l {\n" +
				"        padding-left: 0px !important;\n" +
				"    }\n" +
				"    .es-m-p0t {\n" +
				"        padding-top: 0px !important;\n" +
				"    }\n" +
				"    .es-m-p0b {\n" +
				"        padding-bottom: 0 !important;\n" +
				"    }\n" +
				"    .es-m-p20b {\n" +
				"        padding-bottom: 20px !important;\n" +
				"    }\n" +
				"    .es-mobile-hidden,\n" +
				"    .es-hidden {\n" +
				"        display: none !important;\n" +
				"    }\n" +
				"    tr.es-desk-hidden,\n" +
				"    td.es-desk-hidden,\n" +
				"    table.es-desk-hidden {\n" +
				"        width: auto!important;\n" +
				"        overflow: visible!important;\n" +
				"        float: none!important;\n" +
				"        max-height: inherit!important;\n" +
				"        line-height: inherit!important;\n" +
				"    }\n" +
				"    tr.es-desk-hidden {\n" +
				"        display: table-row !important;\n" +
				"    }\n" +
				"    table.es-desk-hidden {\n" +
				"        display: table !important;\n" +
				"    }\n" +
				"    td.es-desk-menu-hidden {\n" +
				"        display: table-cell!important;\n" +
				"    }\n" +
				"    .es-menu td {\n" +
				"        width: 1% !important;\n" +
				"    }\n" +
				"    table.es-table-not-adapt,\n" +
				"    .esd-block-html table {\n" +
				"        width: auto !important;\n" +
				"    }\n" +
				"    table.es-social {\n" +
				"        display: inline-block !important;\n" +
				"    }\n" +
				"    table.es-social td {\n" +
				"        display: inline-block !important;\n" +
				"    }\n" +
				"}\n" +
				"\n" +
				"\n" +
				"/* END RESPONSIVE STYLES */\n" +
				"\n" +
				".es-p-default {\n" +
				"    padding-top: 20px;\n" +
				"    padding-right: 20px;\n" +
				"    padding-bottom: 0px;\n" +
				"    padding-left: 20px;\n" +
				"}\n" +
				"\n" +
				".es-p-all-default {\n" +
				"    padding: 0px;\n" +
				"}\n" +
				"    </style>\n" +
				"</head>\n" +
				"\n" +
				"<body>\n" +
				"    <div class=\"es-wrapper-color\">\n" +
				"\n" +
				"        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"            <tbody>\n" +
				"                <tr>\n" +
				"                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
				"                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content esd-header-popover\" align=\"center\">\n" +
				"                            <tbody>\n" +
				"                                <tr>\n" +
				"                                    <td class=\"es-adaptive esd-stripe\" align=\"center\" esd-custom-block-id=\"88589\">\n" +
				"                                        <table class=\"es-content-body\" style=\"background-color: transparent;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
				"                                            <tbody>\n" +
				"                                                <tr>\n" +
				"                                                    <td class=\"esd-structure es-p10\" align=\"left\">\n" +
				"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                            <tbody>\n" +
				"                                                                <tr>\n" +
				"                                                                    <td class=\"esd-container-frame\" width=\"580\" valign=\"top\" align=\"center\">\n" +
				"                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                                            \n" +
				"                                                                        </table>\n" +
				"                                                                    </td>\n" +
				"                                                                </tr>\n" +
				"                                                            </tbody>\n" +
				"                                                        </table>\n" +
				"                                                    </td>\n" +
				"                                                </tr>\n" +
				"                                            </tbody>\n" +
				"                                        </table>\n" +
				"                                    </td>\n" +
				"                                </tr>\n" +
				"                            </tbody>\n" +
				"                        </table>\n" +
				"                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\">\n" +
				"                            <tbody>\n" +
				"                                <tr>\n" +
				"                                    <td class=\"es-adaptive esd-stripe\" align=\"center\" esd-custom-block-id=\"88593\">\n" +
				"                                        <table class=\"es-header-body\" style=\"background-color: #3d5ca3;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#3d5ca3\" align=\"center\">\n" +
				"                                            <tbody>\n" +
				"                                                <tr>\n" +
				"                                                    <td class=\"esd-structure es-p5\" style=\"background-color: #3d5ca3;\" bgcolor=\"#3d5ca3\" align=\"left\">\n" +
				"                                                        <!--[if mso]><table width=\"590\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"128\" valign=\"top\"><![endif]-->\n" +
				"                                                        <table cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"es-left\">\n" +
				"                                                            <tbody>\n" +
				"                                                                <tr>\n" +
				"                                                                    <td class=\"esd-container-frame es-m-p20b\" width=\"128\" align=\"left\">\n" +
				"                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                                            <tbody>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\">\n" +
				"                                                                                        <a target=\"_blank\"><img class=\"adapt-img\" src=\"https://cdn.discordapp.com/attachments/948104314432389150/954697000731934770/HRM_Logo.png\" alt style=\"display: block;\" height=\"120\"></a>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                            </tbody>\n" +
				"                                                                        </table>\n" +
				"                                                                    </td>\n" +
				"                                                                </tr>\n" +
				"                                                            </tbody>\n" +
				"                                                        </table>\n" +
				"                                                        <!--[if mso]></td><td width=\"0\"></td><td width=\"462\" valign=\"top\"><![endif]-->\n" +
				"                                                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\">\n" +
				"                                                            <tbody>\n" +
				"                                                                <tr>\n" +
				"                                                                    <td width=\"462\" align=\"left\" class=\"esd-container-frame\">\n" +
				"                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
				"                                                                            <tbody>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td align=\"center\" class=\"esd-block-text\">\n" +
				"                                                                                        <p style=\"line-height: 120%; font-size: 30px; font-family: 'comic sans ms', 'marker felt-thin', arial, sans-serif;\"><strong>Human Resource Management</strong></p>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                            </tbody>\n" +
				"                                                                        </table>\n" +
				"                                                                    </td>\n" +
				"                                                                </tr>\n" +
				"                                                            </tbody>\n" +
				"                                                        </table>\n" +
				"                                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
				"                                                    </td>\n" +
				"                                                </tr>\n" +
				"                                            </tbody>\n" +
				"                                        </table>\n" +
				"                                    </td>\n" +
				"                                </tr>\n" +
				"                            </tbody>\n" +
				"                        </table>\n" +
				"                        <table class=\"es-content esd-footer-popover\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
				"                            <tbody>\n" +
				"                                <tr>\n" +
				"                                    <td class=\"esd-stripe\" style=\"background-color: #fafafa;\" bgcolor=\"#fafafa\" align=\"center\">\n" +
				"                                        <table class=\"es-content-body\" style=\"background-color: #ffffff;\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
				"                                            <tbody>\n" +
				"                                                <tr>\n" +
				"                                                    <td class=\"esd-structure es-p40t es-p20r es-p20l\" style=\"background-color: transparent; background-position: left top;\" bgcolor=\"transparent\" align=\"left\">\n" +
				"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                            <tbody>\n" +
				"                                                                <tr>\n" +
				"                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\n" +
				"                                                                        <table style=\"background-position: left top;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                                            <tbody>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-image es-p5t es-p5b\" align=\"center\" style=\"font-size:0\">\n" +
				"                                                                                        <a target=\"_blank\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_dd354a98a803b60e2f0411e893c82f56/images/23891556799905703.png\" alt style=\"display: block;\" width=\"175\"></a>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-text es-p15t es-p15b\" align=\"center\">\n" +
				"                                                                                        <h1 style=\"color: #333333; font-size: 20px;\"><strong>FORGOT YOUR </strong></h1>\n" +
				"                                                                                        <h1 style=\"color: #333333; font-size: 20px;\"><strong>&nbsp;PASSWORD?</strong></h1>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-text es-p40r es-p40l\" align=\"center\">\n" +
				"                                                                                        <p>Xin chào "+user.getFirstname()+" "+user.getLastname()+"</p>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-text es-p35r es-p40l\" align=\"center\">\n" +
				"                                                                                        <p>Chúng tôi vừa nhận được yêu cầu cấp lại mật khẩu mới từ bạn&nbsp;<br></p>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-text es-p25t es-p40r es-p40l\" align=\"center\">\n" +
				"                                                                                        <p>Mật khẩu mới của bạn là : "+newPassword+"</p>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-button es-p40t es-p40b es-p10r es-p10l\" align=\"center\"><span class=\"es-button-border\"><a href=\"http://localhost:3000/login\" class=\"es-button\" target=\"_blank\">Đăng nhập</a></span></td>\n" +
				"                                                                                </tr>\n" +
				"                                                                            </tbody>\n" +
				"                                                                        </table>\n" +
				"                                                                    </td>\n" +
				"                                                                </tr>\n" +
				"                                                            </tbody>\n" +
				"                                                        </table>\n" +
				"                                                    </td>\n" +
				"                                                </tr>\n" +
				"                                                <tr>\n" +
				"                                                    <td class=\"esd-structure es-p20t es-p10r es-p10l\" style=\"background-position: center center;\" align=\"left\">\n" +
				"                                                        <!--[if mso]><table width=\"580\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=\"199\" valign=\"top\"><![endif]-->\n" +
				"                                                        <table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\n" +
				"                                                            <tbody>\n" +
				"                                                                <tr>\n" +
				"                                                                    <td class=\"esd-container-frame\" width=\"199\" align=\"left\">\n" +
				"                                                                        <table style=\"background-position: center center;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                                            <tbody>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-text es-p15t es-m-txt-c\" align=\"right\">\n" +
				"                                                                                        <p style=\"font-size: 16px; color: #666666;\"><strong>Follow us:</strong></p>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                            </tbody>\n" +
				"                                                                        </table>\n" +
				"                                                                    </td>\n" +
				"                                                                </tr>\n" +
				"                                                            </tbody>\n" +
				"                                                        </table>\n" +
				"                                                        <!--[if mso]></td><td width=\"20\"></td><td width=\"361\" valign=\"top\"><![endif]-->\n" +
				"                                                        <table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\">\n" +
				"                                                            <tbody>\n" +
				"                                                                <tr>\n" +
				"                                                                    <td class=\"esd-container-frame\" width=\"361\" align=\"left\">\n" +
				"                                                                        <table style=\"background-position: center center;\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                                            <tbody>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-social es-p10t es-p5b es-m-txt-c\" align=\"left\" style=\"font-size:0\">\n" +
				"                                                                                        <table class=\"es-table-not-adapt es-social\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                                                            <tbody>\n" +
				"                                                                                                <tr>\n" +
				"                                                                                                    <td class=\"es-p10r\" valign=\"top\" align=\"center\">\n" +
				"                                                                                                        <a target=\"_blank\" href><img src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/rounded-gray/facebook-rounded-gray.png\" alt=\"Fb\" title=\"Facebook\" width=\"32\"></a>\n" +
				"                                                                                                    </td>\n" +
				"                                                                                                    <td class=\"es-p10r\" valign=\"top\" align=\"center\">\n" +
				"                                                                                                        <a target=\"_blank\" href><img src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/rounded-gray/twitter-rounded-gray.png\" alt=\"Tw\" title=\"Twitter\" width=\"32\"></a>\n" +
				"                                                                                                    </td>\n" +
				"                                                                                                    <td class=\"es-p10r\" valign=\"top\" align=\"center\">\n" +
				"                                                                                                        <a target=\"_blank\" href><img src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/rounded-gray/instagram-rounded-gray.png\" alt=\"Ig\" title=\"Instagram\" width=\"32\"></a>\n" +
				"                                                                                                    </td>\n" +
				"                                                                                                    <td class=\"es-p10r\" valign=\"top\" align=\"center\">\n" +
				"                                                                                                        <a target=\"_blank\" href><img src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/rounded-gray/youtube-rounded-gray.png\" alt=\"Yt\" title=\"Youtube\" width=\"32\"></a>\n" +
				"                                                                                                    </td>\n" +
				"                                                                                                    <td class=\"es-p10r\" valign=\"top\" align=\"center\">\n" +
				"                                                                                                        <a target=\"_blank\" href><img src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/rounded-gray/linkedin-rounded-gray.png\" alt=\"In\" title=\"Linkedin\" width=\"32\"></a>\n" +
				"                                                                                                    </td>\n" +
				"                                                                                                </tr>\n" +
				"                                                                                            </tbody>\n" +
				"                                                                                        </table>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                            </tbody>\n" +
				"                                                                        </table>\n" +
				"                                                                    </td>\n" +
				"                                                                </tr>\n" +
				"                                                            </tbody>\n" +
				"                                                        </table>\n" +
				"                                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
				"                                                    </td>\n" +
				"                                                </tr>\n" +
				"                                                <tr>\n" +
				"                                                    <td class=\"esd-structure es-p5t es-p20b es-p20r es-p20l\" style=\"background-position: left top;\" align=\"left\">\n" +
				"                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                            <tbody>\n" +
				"                                                                <tr>\n" +
				"                                                                    <td class=\"esd-container-frame\" width=\"560\" valign=\"top\" align=\"center\">\n" +
				"                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
				"                                                                            <tbody>\n" +
				"                                                                                <tr>\n" +
				"                                                                                    <td class=\"esd-block-text\" esd-links-color=\"#666666\" align=\"center\">\n" +
				"                                                                                        <p style=\"font-size: 14px;\">Human Resource Management</p>\n" +
				"                                                                                    </td>\n" +
				"                                                                                </tr>\n" +
				"                                                                            </tbody>\n" +
				"                                                                        </table>\n" +
				"                                                                    </td>\n" +
				"                                                                </tr>\n" +
				"                                                            </tbody>\n" +
				"                                                        </table>\n" +
				"                                                    </td>\n" +
				"                                                </tr>\n" +
				"                                            </tbody>\n" +
				"                                        </table>\n" +
				"                                    </td>\n" +
				"                                </tr>\n" +
				"                            </tbody>\n" +
				"                        </table>\n" +
				"                    </td>\n" +
				"                </tr>\n" +
				"            </tbody>\n" +
				"        </table>\n" +
				"    </div>\n" +
				"</body>\n" +
				"\n" +
				"</html>";

		sendEmail(gmail,"Cap lai mat khau moi",content);
	}

	@Override
	public void sendEmailToNewUser(User user) throws MessagingException, UnsupportedEncodingException {
		String content="Xin chao "+user.getFirstname()+" "+user.getLastname()+"\n" +
				"welcome to HRM \n" +
				"Tai khoan truy cap noi bo cua ban la : \n" +
				"Username : "+user.getUsername()+"\n" +
				"Password : "+user.getPassword();
		sendEmail(user.getEmail(), "Welcome!",content);
	}


	private void sendEmail(String email,String subject,String content) throws MessagingException, UnsupportedEncodingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		String htmlMsg = content;
		helper.setText(htmlMsg, true);
		helper.setTo(email);
		helper.setSubject(subject);
		helper.setFrom("humanresourcemanagamentz@gmail.com","Quản Lý Nhân Sự");
		mailSender.send(mimeMessage);
	}


}
