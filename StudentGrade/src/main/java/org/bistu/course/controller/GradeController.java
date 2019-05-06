package org.bistu.course.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.Resource;
import org.bistu.course.domain.Grade;
import org.bistu.course.service.GradeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;

/** 
* @author jmh
* @version 2019年4月23日 上午10:13:42 
*/
@Controller
@Slf4j
public class GradeController {

	 @Resource
	    private GradeService gradeService;
	 @RequestMapping("/2")
	    public String index(){
	        return "redirect:/index"; //重定向到 /list
	    }

//	    @RequestMapping("/index")
//	    public String lsit(Model model){
//	        List<Grade> grades = gradeService.getGradeList();
//	        model.addAttribute("grades",grades);
//	        return "grade/index"; 
//	    }
	    
	    @RequestMapping("/index")
	    public String lsit(Model model, @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
				@RequestParam(value = "size", defaultValue = "5", required = false) Integer size){
	    	Pageable pageable = PageRequest.of(page - 1, size);
			Page<Grade> pageGrades = this.gradeService.getAll(pageable);
			model.addAttribute("grades", pageGrades);
			log.info("Query total elements:{}", pageGrades.getTotalElements());
			int totalPages = pageGrades.getTotalPages();
			if (totalPages > 0) {
				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
				model.addAttribute("pageNumbers", pageNumbers);
			}
	    	//PageInfo<Users> users = userService.getApplicationList(pageNo,pageSize);
	        //List<User> users = userService.getUserList();
	        //model.addAttribute("users",users);
	        return "grade/index"; 
	    }
	    
	    @RequestMapping("/toAddGrade")
	    public String toadd(Grade grade){
	        return "grade/gradeAdd";//跳转到gradeAdd.html
	    }
	    
	    @RequestMapping("/addGrade")
	    public String add(Grade grade){
	    	gradeService.save(grade);
	        return "redirect:/index";//添加完成，请求重定向到/list
	    }
	    
	    @RequestMapping("/toEditGrade")
	    public String toEdit(Model model,Long id){
	        Grade grade = gradeService.findGradeById(id);
	        model.addAttribute("grade",grade);
	        return "grade/gradeEdit"; //跳转到userEdit.html页面
	    }
	    @RequestMapping("/editGrade")
	    public String edit(Grade grade){
	        gradeService.edit(grade);
	        return "redirect:/index";//获取列表数据并显示
	    }

	    @RequestMapping("/deleteGrade")
	    public String edit(Long id){
	    	gradeService.delete(id);
	        return "redirect:/index";
	    }
}
