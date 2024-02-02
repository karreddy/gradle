package com.pll.birthdaywishesmvc.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.pll.birthdaywishesmvc.constants.BirthdayWishesMvcPortletKeys;

import java.io.StringWriter;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			
			"javax.portlet.name=" + BirthdayWishesMvcPortletKeys.BIRTHDAYWISHESMVC,
			"mvc.command.name=/hello/MailSendUrl"
		},
		service = MVCRenderCommand.class
	)
public class SendWishesTodays implements MVCRenderCommand{
	Log log=LogFactoryUtil.getLog(SendWishesTodays.class);
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
String toMail=renderRequest.getParameter("emailId");
		
		
		
		log.info("Started sendMailUsingTemplate");

		try {
			
			
			
			TemplateResource templateResource = new URLTemplateResource("0",
					this.getClass().getClassLoader().getResource("content/mail.tmpl"));
			
			
			
			
			Template template = TemplateManagerUtil.getTemplate(TemplateConstants.LANG_TYPE_FTL, templateResource,
					false);
			StringWriter out = new StringWriter();

			template.processTemplate(out);
			
			String body = out.toString();

			final String username = "surakshasuraksha95@gmail.com";

			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			props.put("mail.debug", "true");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, "juzj uzfh cylg rzph");
				}
			});

			javax.mail.Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("surakshasuraksha95@gmail.com"));
			
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(toMail));
			message.setSubject("Birthday Wishes ");
			message.setContent(body, "text/html; charset=utf-8");

			Transport.send(message);
			log.info("End sendMailUsingTemplate");
		} catch (MessagingException | TemplateException e) {
			log.error("Error in sendMailUsingTemplate",e);
			throw new RuntimeException(e);
		}
		
		
		
		return null;
	}

}
