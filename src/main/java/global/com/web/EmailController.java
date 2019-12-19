package global.com.web;


import global.com.dao.MailBean;
import global.com.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.TemplateEngine;

@Controller
public class EmailController {
@Autowired
    private MailUtil mailUtil;
@Autowired
    private TemplateEngine templateEngine;

@RequestMapping( value = "/mail" ,method = RequestMethod.POST)
public String mail(@RequestParam("file") MultipartFile file, @RequestParam String recipient, @RequestParam String subject, @RequestParam String content ){
    MailBean mailBean=new MailBean();
    mailBean.setContent(content);
    mailBean.setRecipient(recipient);
    mailBean.setSubject(subject);
    mailUtil.sendAttachmentMail(mailBean,file);
    return "redirect:/";
}
}
