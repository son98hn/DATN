package com.example.datn.Controller.User;

import com.example.datn.Utils.SecurityUtil;
import com.example.datn.Utils.WebUtils;
import com.example.datn.dto.UserDTO;
import com.example.datn.entity.GroupEntity;
import com.example.datn.entity.UserEntity;
import com.example.datn.repository.GroupRepository;
import com.example.datn.service.ICategoryParentService;
import com.example.datn.service.ICategoryService;
import com.example.datn.service.INewService;
import com.example.datn.service.impl.UserService;
import com.example.datn.validate.UserValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final ICategoryService categoryService;

    private final ICategoryParentService categoryParentService;

    private final INewService newService;

    private final UserService userService;

    private final ConnectionFactoryLocator connectionFactoryLocator;

    private final UsersConnectionRepository usersConnectionRepository;

    private final GroupRepository groupRepository;

    private final UserValidator userValidator;

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        Object target = webDataBinder.getTarget();
        if (target == null) {
            return;
        }
        if (target.getClass() == UserDTO.class) {
            webDataBinder.setValidator(userValidator);
        }
    }

    public HomeController(ICategoryService categoryService, ICategoryParentService categoryParentService, INewService newService, UserService userService, ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository, UserValidator userValidator, GroupRepository groupRepository) {
        this.categoryService = categoryService;
        this.categoryParentService = categoryParentService;
        this.newService = newService;
//        this.commentService = commentService;
        this.userService = userService;
        this.connectionFactoryLocator = connectionFactoryLocator;
        this.usersConnectionRepository = usersConnectionRepository;
        this.userValidator = userValidator;
        this.groupRepository = groupRepository;
    }

    @GetMapping(value = { "/trang-chu"})
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
        model.addAttribute("bv", newService.findById(id));
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
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page - 1, size, sortable);
        model.addAttribute("totalPage", (int) Math.ceil((double) newService.totalItemByCategoryParent(categoryParent) / size));
        model.addAttribute("page", page);
        model.addAttribute("listNews", newService.findNewsByCategoryParentCode(categoryParent, pageable));
        model.addAttribute("categoryParent", categoryParentService.findAll());
        model.addAttribute("nameCategory", categoryParentService.findByCode(categoryParent).getName());
        model.addAttribute("codeCategory", categoryParent);
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

    @GetMapping(value = "/register")
    public String signupPage(WebRequest webRequest, Model model) {
        ProviderSignInUtils providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, usersConnectionRepository);
        // Retrieve social networking information.
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(webRequest);
        UserDTO userDTO = null;
        if (connection != null) {
            userDTO = new UserDTO(connection);
        } else {
            userDTO = new UserDTO();
        }
        model.addAttribute("userDTO", userDTO);
        return "web/register";
    }

    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    private String signupSave(WebRequest webRequest, Model model, @RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
        return "web/register";
    }

}
