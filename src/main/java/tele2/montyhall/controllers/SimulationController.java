package tele2.montyhall.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tele2.montyhall.services.SimulationService;

@RestController
@RequestMapping("/simul")
public class SimulationController {

    @Autowired
    private SimulationService simulationService;


    @RequestMapping("/keep/{numberOfSimulations}")
    public String simulateKeep(@PathVariable int numberOfSimulations) {
        return simulationService.simulateKeep(numberOfSimulations).toString();
    }

    @RequestMapping("/swap/{numberOfSimulations}")
    public String simulateSwap(@PathVariable int numberOfSimulations) {
        return simulationService.simulateSwap(numberOfSimulations).toString();
    }

}
