package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Payment;
import rovshan.insurance_app.service.PaymentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(@Autowired PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment create(@Valid @RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("/read/{paymentId}")
    public Payment read(@Valid @PathVariable("paymentId") Long paymentId_){
        return paymentService.read(paymentId_);
    }

    @GetMapping("/readAll")
    public List<Payment> readALl(){
        return paymentService.readAll();
    }

    @PutMapping("/update")
    public Payment update(@Valid @RequestBody Payment payment){
        return paymentService.update(payment);
    }

    @DeleteMapping("/delete/{paymentId}")
    public Payment delete(@Valid @PathVariable("paymentId") Long paymentId_){
        return paymentService.delete(paymentId_);
    }
}
