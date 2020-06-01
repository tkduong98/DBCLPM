package com.ptit.water_bill.controller;

import com.ptit.water_bill.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendMailController {

    @Autowired
    MailService mailService;

    @PostMapping("/gui-mail-khach-hang")
    @ResponseBody
    public String sendMail(@RequestParam("mailContent") String mailContent,
                           @RequestParam("mailAddressReceive") String mailAddressReceive,
                           @RequestParam("mailSubject") String mailSubject) {
        (new Thread(() -> {
            mailService.sendMail(mailAddressReceive,mailSubject,mailContent);
        })).start();
        return "OK";
    }
}
