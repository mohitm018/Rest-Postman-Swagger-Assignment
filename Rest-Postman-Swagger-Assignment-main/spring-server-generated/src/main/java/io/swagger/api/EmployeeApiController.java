package io.swagger.api;

import io.swagger.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-11T10:44:51.052867237Z[GMT]")
@RestController
public class EmployeeApiController implements EmployeeApi {

    private static final Logger log = LoggerFactory.getLogger(EmployeeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private EmployeeRepository employeeRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public EmployeeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Employee> createEmployee(@Parameter(in = ParameterIn.DEFAULT, description = "Created employee object", schema=@Schema()) @Valid @RequestBody Employee employee
) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Employee>(objectMapper.readValue("{\n  \"id\" : 10,\n  \"email\" : \"john@email.com\",\n  \"username\" : \"theEmployee\"\n}", Employee.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
    	
    	  employeeRepo.save(employee);
          return new ResponseEntity<Employee>(HttpStatus.CREATED);
    }

//    public ResponseEntity<List<Employee>> getAll() {
////        String accept = request.getHeader("Accept");
////        if (accept != null && accept.contains("application/json")) {
////            try {
////                return new ResponseEntity<Employee>(objectMapper.readValue("{\n  \"id\" : 10,\n  \"email\" : \"john@email.com\",\n  \"username\" : \"theEmployee\"\n}", Employee.class), HttpStatus.NOT_IMPLEMENTED);
////            } catch (IOException e) {
////                log.error("Couldn't serialize response for content type application/json", e);
////                return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
////            }
////        }
////
////        return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
//    	List<Employee> employee =employeeRepo.findAll();
//        return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
//    	
//    }


    public ResponseEntity<Employee> getEmployeeByName(@Parameter(in = ParameterIn.PATH, description = "The name that needs to be fetched. Use employee1 for testing. ", required=true, schema=@Schema()) @PathVariable("Employeename") String employeename
) {
//        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Employee>(objectMapper.readValue("{\n  \"id\" : 10,\n  \"email\" : \"john@email.com\",\n  \"username\" : \"theEmployee\"\n}", Employee.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
//
//        return new ResponseEntity<Employee>(HttpStatus.NOT_IMPLEMENTED);
    	Employee accept = employeeRepo.findByUsername(employeename);
//    	return new ResponseEntity<User>(HttpStatus.OK);
    	try {
			return new ResponseEntity<Employee>(objectMapper.readValue("{\n  \"id\" : "+accept.getId()+",\n  \"email\" : \""+accept.getEmail()+"\",\n  \"username\" : \""+accept.getUsername()+"\"\n}", Employee.class), HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

//	@Override
//	public ResponseEntity<Employee> getAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
}
