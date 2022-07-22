package com.delonborges.dsmeta.services;

import com.delonborges.dsmeta.entities.Sale;
import com.delonborges.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class SmsService {

    private final SaleRepository saleRepository;
    @Value("${twilio.sid}")
    private String twilioSid;
    @Value("${twilio.key}")
    private String twilioKey;
    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;
    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    public SmsService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId)
                                  .orElse(null);

        String date = Objects.requireNonNull(sale)
                             .getDate()
                             .getMonthValue() + "/" + sale.getDate()
                                                          .getYear();

        String msg = "The seller "
                     + sale.getSellerName()
                     + " was a highlight on "
                     + date
                     + " with a total amount of R$"
                     + String.format("%.2f", sale.getAmount());

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg)
                                 .create();

        System.out.println(message.getSid());
    }
}