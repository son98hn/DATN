package com.example.datn.Controller.User;

import com.example.datn.Utils.WebUtils;
import com.example.datn.service.ICategoryParentService;
import com.example.datn.service.ICategoryService;
//import com.example.datn.service.ICommentService;
import com.example.datn.service.INewService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {
    private final ICategoryService categoryService;

    private final ICategoryParentService categoryParentService;

    private final INewService newService;

//    private final ICommentService commentService;

    public HomeController(ICategoryService categoryService, ICategoryParentService categoryParentService, INewService newService) {
        this.categoryService = categoryService;
        this.categoryParentService = categoryParentService;
        this.newService = newService;
//        this.commentService = commentService;
    }

    @GetMapping(value = {"/", "/trang-chu"})
    public String index(Model model, HttpServletRequest request, @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                        @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort) {
        model.addAttribute("categoryParent", categoryParentService.findAll());
//        page
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page - 1, size, sortable);
        model.addAttribute("totalPage", (int) Math.ceil((double) newService.totalItemActive() / size));
        model.addAttribute("page", page);
        model.addAttribute("lastNews", newService.findAllActive(pageable));
        model.addAttribute("sportNews", newService.findNewsByCategoryParentCode1("the-thao"));
        model.addAttribute("technologyNews", newService.findNewsByCategoryParentCode1("cong-nghe"));
        model.addAttribute("firstSportNew", newService.findTopByCategoryParentCode("the-thao"));
        model.addAttribute("firstSocietyNew", newService.findTopByCategoryParentCode("xa-hoi"));
        model.addAttribute("firstWorldNew", newService.findTopByCategoryParentCode("the-gioi"));
        model.addAttribute("firstTechnologyNew", newService.findTopByCategoryParentCode("cong-nghe"));
        model.addAttribute("firstEntertainmentNew", newService.findTopByCategoryParentCode("giai-tri"));
        return "web/home";
    }

    @GetMapping(value = "/bai-viet/{id}")
    public String baiViet(Model model, Principal principal,
                          @PathVariable("id") Long id) {
        model.addAttribute("bv",newService.findById(id));
        model.addAttribute("categoryParent", categoryParentService.findAll());
//        model.addAttribute("comments", commentService.findAllByNewEntityId(id));
        return "web/bai-viet";
    }

    @GetMapping(value = "/userInfo")
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "web/userInfo";
    }

    @GetMapping(value = "/nhom-bai-viet/{categoryParent}")
    public String nhomBaiViet(Model model, Principal principal,
                              @PathVariable("categoryParent") String categoryParent,
                              @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                              @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                              @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
//       page
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("new.id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("new.id").descending();
        }
        Pageable pageable = PageRequest.of(page - 1, size, sortable);
        model.addAttribute("totalPage", (int) Math.ceil((double) newService.totalItemByCategoryParent(categoryParent) / size));
        model.addAttribute("page", page);
        model.addAttribute("listNews", newService.findNewsByCategoryParentCode(categoryParent, pageable));
        model.addAttribute("categoryParent", categoryParentService.findAll());
        model.addAttribute("nameCategory", categoryParentService.findByCode(categoryParent).getName());
        return "web/nhom-bai-viet";
    }

    //    @GetMapping(value = "/403")
//    public String accessDenied(Model model, Principal principal) {
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//        String userInfo= WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//        String message = principal.getName()+"you don't have permission to access this page!";
//        model.addAttribute("message", message);
//        return "web/403";
//    }
    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        model.addAttribute("categoryParent", categoryParentService.findAll());
        return "web/login";
    }
}
