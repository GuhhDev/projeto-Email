package br.com.workana.controllers;

import br.com.workana.Entities.Email;
import br.com.workana.Entities.Investimento;
import br.com.workana.dtos.EmailDto;
import br.com.workana.services.EmailService;
import br.com.workana.services.InvestimentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

    @GetMapping("/getting-email")
    public List<Email> gettingEmail() {
        return emailService.gettingEmail();
    }
}
