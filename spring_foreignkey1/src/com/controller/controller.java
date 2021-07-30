package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.regDAO;
import com.model.LoginVo;
import com.model.RegVo;

@Controller
public class controller {

	@Autowired
	private regDAO d;
	@RequestMapping(value = "hello.html", method = RequestMethod.GET)
	public ModelAndView load(){
		return new ModelAndView("register","RegKey",new RegVo());
		
		
	}
	
	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute RegVo rv){
		
		LoginVo lv=rv.getLv();
		
		d.insertLogin(lv);
		d.insertReg(rv);
		return new ModelAndView("redirect:/search.html");
		
		
	}
	
	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute RegVo rv){
		
		
		List<RegVo> searchData=d.SearchReg();
		return new ModelAndView("search","search",searchData);
		
		
	}
	
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute RegVo rv,@RequestParam int delete_id,@RequestParam int id_login){
		
		rv.setId(delete_id);
		d.delete(rv);
		
		LoginVo lv=new LoginVo();
		lv.setId(id_login);
		
		d.deleteLogin(lv);
		System.out.println(delete_id);
		System.out.println(id_login);
		
		return new ModelAndView("redirect:/search.html");
		
		
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute RegVo rv,@RequestParam int edit_id){
		
		rv.setId(edit_id);
		List editList=d.edit(rv);
		return new ModelAndView("register","RegKey",editList.get(0));
		
		
	}
}
