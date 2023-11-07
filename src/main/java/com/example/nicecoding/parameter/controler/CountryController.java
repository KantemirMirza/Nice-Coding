package com.example.nicecoding.parameter.controler;

import com.example.nicecoding.parameter.model.Country;
import com.example.nicecoding.parameter.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/countries")
    public String listOfCountry(Model model) {
        List<Country> countries = countryService.listOfCountry();
        model.addAttribute("listOfCountry", countries);
        return "parameter/country/listOfCountry";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<Country> countries = countryService.findByKeyword(keyword);
        model.addAttribute("listOfCountry", countries);
        return "parameter/country/listOfCountry";
    }

    @GetMapping("/pages/{pageNumber}")
    public String findPage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<Country> page = countryService.findPage(currentPage);
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        List<Country> countries = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalElements", totalElements);
        model.addAttribute("listOfCountry", countries);

        return "parameter/country/listOfCountry";
    }

    @GetMapping("/pages/{pageNumber}/{field}/{sortDir}")
    public String findAllWithSort(Model model, @PathVariable("pageNumber") int currentPage,
                                  @PathVariable("field") String field,
                                  @PathVariable("sortDir") String sortDir) {
        Page<Country> page = countryService.findAllWithSort(field, sortDir, currentPage);
        List<Country> countries = page.getContent();
        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalElements", totalElements);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("ASC") ? "DESC" : "ASC");
        model.addAttribute("listOfCountry", countries);

        return "parameter/country/listOfCountry";
    }

    @GetMapping("/sorts/{field}")
    public String sortAscAndDesc(Model model, @PathVariable("field") String field,
                                 @RequestParam("sortDir") String sortDir) {
        List<Country> countries = countryService.sortAscAndDesc(field, sortDir);

        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("ASC") ? "DESC" : "ASC");
        model.addAttribute("listOfCountry", countries);

        return "parameter/country/listOfCountry";
    }

    @GetMapping("/addCountry")
    public String addCountry(){
        return"parameter/country/addCountry";
    }

    @PostMapping("/addCountry")
    public String saveCountry(@ModelAttribute Country country){
        countryService.saveCountry(country);
        return"redirect:/countries";
    }

    @GetMapping("/countries/{id}/edit")
    public String editCountry(@PathVariable Integer id, Model model){
        Country country = countryService.findCountryById(id);
        model.addAttribute("country", country);
        return"parameter/country/editCountry";
    }

    @PostMapping("/countries/{id}/edit")
    public String updateCountry(@PathVariable Integer id, @ModelAttribute("country") Country country ){
        Country count = countryService.findCountryById(id);
        count.setCode(country.getCode());
        count.setCapital(country.getCapital());
        count.setDescription(country.getDescription());
        count.setNationality(country.getNationality());
        count.setContinent(country.getContinent());
        countryService.saveCountry(count);
        return"redirect:/countries";
    }

    @GetMapping("/countries/{id}/delete")
    public String deleteCountry(@PathVariable Integer id){
        Country country = countryService.findCountryById(id);
        countryService.deleteCountry(country);
        return"redirect:/countries";
    }

    @GetMapping("/countries/{id}/info")
    public String getInfoCountry(Model model, @PathVariable Integer id){
        Country InfoCountry = countryService.findCountryById(id);
        model.addAttribute("country", InfoCountry);
        return"parameter/country/infoCountry";
    }
}
