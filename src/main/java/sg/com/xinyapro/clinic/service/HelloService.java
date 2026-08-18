package sg.com.xinyapro.clinic.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String hello() {
        return "Hello from Service";
    }
}
