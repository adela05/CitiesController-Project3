package com.compay.CitiesController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CitiesController {
    private List<Cities> citiesList;

    public CitiesController() {
        citiesList = new ArrayList<>();
        citiesList.add(new Cities("Tulsa", "OK", 400000, false));
        citiesList.add(new Cities("Dallas", "TX", 1340000, false));
        citiesList.add(new Cities("Miami", "FL", 463347, false));
        citiesList.add(new Cities("Los Angeles", "CA", 4000000, false));
        citiesList.add(new Cities("Oklahoma City", "OK", 643000, true));
    }
    // List all cities
    @RequestMapping(value="/cities", method = RequestMethod.GET)
    public List<Cities> getName(){
        return citiesList;
    }
    //Get by City Names
    @RequestMapping(value="/cities/{name}", method = RequestMethod.GET)
    public Cities getName(@PathVariable String name){
        for (int i = 0; i < citiesList.size(); i++){
            if(citiesList.get(i).getName() == name){
                return citiesList.get(i);
            }
        }
        return null;

    }
    // Creating a new POST to add new city
    @RequestMapping(value="/cities", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Cities createCity(@RequestBody @Valid Cities city){
        this.citiesList.add(city);
        if (!Character.isUpperCase(city.getName().charAt(0))){
            throw new IllegalArgumentException("Capitalize Name");
        }
        return city;
    }

    // Creating a DELETE route
    @RequestMapping(value = "/cities/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void deleteCities(@PathVariable String name){
        for (int count = 0; count < this.citiesList.size(); count++){
            if(this.citiesList.get(count).getName().equals(name)){
                this.citiesList.remove(count);
                break;
            }
        }
    }
    //Retrieve all the cities with a population greater than the supplied request parameter
    @RequestMapping(value = "/cities/population/{population}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Cities> getPopulation(@PathVariable int population){
        List <Cities> populationList = new ArrayList<>();
        for (int count = 0; count < citiesList.size(); count++) {
            if (citiesList.get(count).getPopulation()> population){
                populationList.add(citiesList.get(count));
            }
        }
        return populationList;
    }
    // Retrieve all cities by state
    @RequestMapping(value = "/cities/state/{state}", method = RequestMethod.GET)
    public List<Cities> getState(@PathVariable String state){
        List<Cities> stateList = new ArrayList<>();
        for (int count = 0; count < citiesList.size(); count++) {
            if (citiesList.get(count).getState().equals(state)){
                stateList.add(citiesList.get(count));
            }
        }
        return stateList;
    }

}
