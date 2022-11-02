package car.app.cap01.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import car.app.cap01.domain.Driver;
import car.app.cap01.domain.DriverREpository;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE )
public class DriverAPI {

    @Autowired
    DriverREpository driverREpository;

    @GetMapping("/drivers")
    public List<Driver> listDrivers(){
        return driverREpository.findAll();
    }

    @GetMapping("/drivers/{id}")
    public Driver findDriver(@PathVariable("id") Long id){
        return driverREpository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/drivers")
    public Driver creatDriver(@RequestBody Driver driver){
        return driverREpository.save(driver);
    }
}
