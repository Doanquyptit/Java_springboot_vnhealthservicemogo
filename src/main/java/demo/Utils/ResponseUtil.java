package demo.Utils;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    private static Logger logger = LoggerFactory.getLogger(ResponseUtil.class);


    public static ResponseEntity<?> errorResponse(Exception e) {
        logger.error("Error in HttpRequest:", e);
        var error = Optional.ofNullable(e.getMessage()).orElse("Unknown error");
        var result = Map.of("success", false, "error", error);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}