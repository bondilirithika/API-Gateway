package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zenv.logging.core.LogContext;
import com.zenv.logging.core.LoggingService;
import java.util.HashMap;


@RestController
//@RequestMapping()
public class TestController {
    private final LoggingService loggingService = new LoggingService(TestController.class);


    @GetMapping("/test")
    public String getTestMessage() {
        //Log a message with a custom context
        LogContext context = new LogContext(
                "4fa8f35df97f427a80516c8dc2f40376",  // App
                "user-123",                          // User ID from JWT sub claim if available
                "tenant-abc",                        // Tenant ID
                "session-" + System.currentTimeMillis() // Generate session ID
        );
        HashMap<String, Object> data = new HashMap<>();
        data.put("log", "Test log message");
        data.put("logType", "TestLog");
        data.put("logSource", "SpringBootService");

        loggingService.logInfo("Test log message", context, data);
        return "Hello from Spring Boot Service!";
    }

    @GetMapping("/second")
    public String getTestMessage1() {
        LogContext context = new LogContext(
                "8fa8f35df97f999980516c8dc2f40376",  // trace ID
                "user-345",                          // User ID from JWT sub claim if available
                "tenant-cde",                        // Tenant ID
                "session-" + System.currentTimeMillis() // Generate session ID
        );
        HashMap<String, Object> data = new HashMap<>();
        data.put("log", "Test log message22222");
        data.put("logType", "TestLog222");
        data.put("logSource", "SpringBootService222");
        loggingService.logInfo("Test log message222222", context, data);
        return "Hello from 2nd service!";
    }
}
