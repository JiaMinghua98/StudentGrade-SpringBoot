package org.bistu.course.controller;

import org.bistu.course.domain.User;
import org.bistu.course.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    
    @RequestMapping("/1")
    public String index(){
        return "redirect:/list"; //重定向到 /list
    }

    @RequestMapping("/list")
    public String lsit(Model model, @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
			@RequestParam(value = "size", defaultValue = "5", required = false) Integer size){
    	Pageable pageable = PageRequest.of(page - 1, size);
		Page<User> pageUsers = this.userService.getAll(pageable);
		model.addAttribute("users", pageUsers);
		log.info("Query total elements:{}", pageUsers.getTotalElements());
		int totalPages = pageUsers.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
    	//PageInfo<Users> users = userService.getApplicationList(pageNo,pageSize);
        //List<User> users = userService.getUserList();
        //model.addAttribute("users",users);
        return "user/list"; 
    }

    @RequestMapping("/toAdd")
    public String toadd(User user){
        return "user/userAdd";//跳转到userAdd.html
    }

    @RequestMapping("/add")
    public String add(User user){
        userService.save(user);
        return "redirect:/list";//添加完成，请求重定向到/list
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/userEdit"; //跳转到userEdit.html页面
    }
    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/list";//获取列表数据并显示
    }

    @RequestMapping("/delete")
    public String edit(Long id){
        userService.delete(id);
        return "redirect:/list";
    }
    
    @RequestMapping("/queryById")
    public String queryById(Long id){
        userService.findUserById(id);
        return "redirect:/userEdit";//添加完成，请求重定向到/list
    }
}



