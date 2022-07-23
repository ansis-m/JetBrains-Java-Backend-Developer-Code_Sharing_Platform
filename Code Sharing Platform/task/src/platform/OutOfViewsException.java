package platform;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Order")
public class OutOfViewsException extends RuntimeException {

    {System.out.println("Out of Views exception!!!");}
}
