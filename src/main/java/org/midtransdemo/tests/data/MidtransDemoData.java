package org.midtransdemo.tests.data;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component("org.midtransdemo.tests.data.MidtransDemoData")
@Data
public class MidtransDemoData {
    private String headerAmount;
    private String transactionAmount;
    private String creditCardNumber;
}
