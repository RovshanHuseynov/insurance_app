package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Payment;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.PaymentRepository;

import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(@Autowired PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment create(Payment payment) {
        Optional<Payment> paymentOP = Optional.ofNullable(payment);
        return paymentRepository.save(paymentOP.orElseThrow(() ->
                new Exception("CREATE PAYMENT operation could not be executed. Input data is invalid")));
    }

    public Payment read(Long paymentId_) {
        return paymentRepository.findById(paymentId_).orElseThrow(() ->
                new Exception(String.format("READ PAYMENT operation could not be executed. PAYMENT with %d id could not be found", paymentId_)));
    }
}
