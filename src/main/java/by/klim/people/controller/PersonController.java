package by.klim.people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.klim.people.dao.IPersonDao;
import by.klim.people.model.Person;

@Controller
public class PersonController {
	@Autowired
	private IPersonDao personDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addPerson(Model model) {
		model.addAttribute("action", "add");
		model.addAttribute("button", "Add person");
		model.addAttribute("person", new Person());
		return "personForm";
	}
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute Person person) {
		personDao.save(person);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/edit-{id}", method = RequestMethod.GET)
	public String editPerson(@PathVariable long id, Model model) {
		model.addAttribute("action", "edit");
		model.addAttribute("button", "Edit person");		
		model.addAttribute("person", personDao.findById(id).get());
		return "personForm";
	}
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editPerson(@ModelAttribute Person person) {
		personDao.update(person);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePerson(@PathVariable long id, Model model) {
		personDao.delete(id);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String peopleList(Model model) {
		model.addAttribute("people", personDao.findAll());
		return "peopleList";
	}
}
