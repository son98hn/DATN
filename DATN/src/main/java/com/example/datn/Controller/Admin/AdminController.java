package com.example.datn.Controller.Admin;

import com.example.datn.entity.*;
import com.example.datn.service.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    private final INewService newService;
    private final ICategoryService categoryService;
    private final IFunctionService functionService;
    private final IUserService userService;
    private final IGroupService groupService;

    public AdminController(INewService newService, ICategoryService categoryService, IFunctionService functionService, IUserService userService, IGroupService groupService) {
        this.newService = newService;
        this.categoryService = categoryService;
        this.functionService = functionService;
        this.userService = userService;
        this.groupService = groupService;
    }


    @GetMapping("/admin-new")
    public String listNew(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(value = "size", required = false, defaultValue = "15") Integer size,
                          @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
                          Model model, Principal principal, HttpServletRequest request) {
//        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        UserEntity userEntity = userService.findByUserName(userName);
        List<String> list_functionCode_str = new ArrayList<>();
        List<FunctionEntity> functionEntities = functionService.findFunctionByUserName(userName);
        for (FunctionEntity functionEntity : functionEntities) {
            String functionCode_str = functionEntity.getCode();
            list_functionCode_str.add(functionCode_str);
        }
        model.addAttribute("userfunction", list_functionCode_str);
        model.addAttribute("user", userName);
//
//        page
        model.addAttribute("totalPage", (int) Math.ceil((double) newService.totalItemActive() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listNew", newService.findAllActive(pageable));
//
//        tìm thể loại
        List<String> listcategory_str = new ArrayList<>();
        List<NewEntity> newEntities = newService.findAllActive(pageable);
        for (NewEntity entity : newEntities) {
            Long id = entity.getCategoryEntity().getId();
            CategoryEntity categoryDTO = categoryService.findById(id);
            listcategory_str.add(categoryDTO.getName());
        }
        model.addAttribute("listCategory", listcategory_str);
//
        return "admin/new/list";
    }

    @GetMapping("/admin-addOrUpdateNew")
    public String addOrUpdateNew(@RequestParam(value = "id", required = false) Long id, Model model, HttpServletRequest request, Principal principal) {
        NewEntity newEntity = new NewEntity();
        if (id != null) {
            newEntity = newService.findById(id);
        }
        List<CategoryEntity> categoryDTOList = categoryService.findAll();
        model.addAttribute("categories", categoryDTOList);
        model.addAttribute("news", newEntity);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity.getUsername());
        return "admin/new/edit";
    }

    @GetMapping("/admin-user")
    public String listUser(Model model, Principal principal, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                           @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                           @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
        //        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        UserEntity userEntity = userService.findByUserName(userName);
        List<String> list_functionCode_str = new ArrayList<>();
        List<FunctionEntity> functionEntities = functionService.findFunctionByUserName(userName);
        for (FunctionEntity functionEntity : functionEntities) {
            String functionCode_str = functionEntity.getCode();
            list_functionCode_str.add(functionCode_str);
        }
        model.addAttribute("userFunction", list_functionCode_str);
        model.addAttribute("user", userName);
//
//        page
        model.addAttribute("totalPage", (int) Math.ceil((double) userService.totalItem() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listUser", userService.findUser(pageable));
//
        //      tìm nhóm quyền
        List<List> list_groupName_list = new ArrayList<>();
        List<UserEntity> userEntities = userService.findUser(pageable);
        for (UserEntity userEntity1 : userEntities) {
            List<String> list_userGroup_str = new ArrayList<>();
            String userName_str = userEntity1.getUsername();
            List<GroupEntity> groupEntities = groupService.findGroupByUserName(userName_str);
            for (GroupEntity groupEntity : groupEntities) {
                String group_str = groupEntity.getName();
                list_userGroup_str.add(group_str);
            }
            list_groupName_list.add(list_userGroup_str);
        }
        model.addAttribute("listUserGroup", list_groupName_list);
//
        return "admin/tk/list-user";
    }

    @GetMapping("/admin-addOrUpdateUser")
    public String addOrUpdateUser(@RequestParam(value = "id", required = false) Long id, Model model, Principal principal) {
        UserEntity userEntity = new UserEntity();
        if (id != null) {
            userEntity = userService.findById(id);
            List<String> list_groupUserName_str = new ArrayList<>();
            List<GroupEntity> groupEntities = groupService.findGroupByUserName(userEntity.getUsername());
            for (GroupEntity groupEntity : groupEntities) {
                String groupUserName_str = groupEntity.getName();
                list_groupUserName_str.add(groupUserName_str);
            }
            model.addAttribute("userGroupNames", list_groupUserName_str);
        }
        List<GroupEntity> groupEntities = groupService.findAll();
        List<String> list_groupName_str = new ArrayList<>();
        for (GroupEntity groupEntity : groupEntities) {
            String groupName_str = groupEntity.getName();
            list_groupName_str.add(groupName_str);
        }
        model.addAttribute("groups", list_groupName_str);
        model.addAttribute("users", userEntity);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity1 = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity1.getUsername());
        return "admin/tk/edit-tk";
    }

    @GetMapping("/admin-group")
    public String listGroup(Model model, Principal principal, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                                @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
//        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        UserEntity userEntity = userService.findByUserName(userName);
        List<String> list_functionCode_str = new ArrayList<>();
        List<FunctionEntity> functionEntities = functionService.findFunctionByUserName(userName);
        for (FunctionEntity entity : functionEntities) {
            String functionCode_str = entity.getCode();
            list_functionCode_str.add(functionCode_str);
        }
        model.addAttribute("userFunction", list_functionCode_str);
        model.addAttribute("user", userName);
//
        //        page
        model.addAttribute("totalPage", (int) Math.ceil((double) groupService.totalItem() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listGroup", groupService.findGroup(pageable));
//
//        tìm chi tiết nhóm quyền
        List<GroupEntity> groupEntities = groupService.findGroup(pageable);
        List<List> list_function_list = new ArrayList<>();
        for (GroupEntity entity : groupEntities) {
            List<String> list_function_str = new ArrayList<>();
            Long id_long = entity.getId();
            List<FunctionEntity> functionEntityList = functionService.findFunctionByGroupId(id_long);
            for (FunctionEntity functionEntity : functionEntityList) {
                String function_str = functionEntity.getName();
                list_function_str.add(function_str);
            }
            list_function_list.add(list_function_str);
        }
        model.addAttribute("groupFunctions", list_function_list);
        return "admin/group/list-group";
    }

    @GetMapping("/admin-addOrUpdateGroup")
    public String addOrUpdateGroup(@RequestParam(value = "id", required = false) Long id, Model model, Principal principal) {
        GroupEntity groupEntity = new GroupEntity();
        if (id != null) {
            groupEntity = groupService.findById(id);
            List<String> list_function_str = new ArrayList<>();
            List<FunctionEntity> functionEntities = functionService.findFunctionByGroupId(groupEntity.getId());
            for (FunctionEntity functionEntity : functionEntities) {
                String function_str = functionEntity.getName();
                list_function_str.add(function_str);
            }
            model.addAttribute("groupFunctions", list_function_str);
        }
        List<FunctionEntity> functionEntities = functionService.findAll();
        List<String> function_str = new ArrayList<>();
        for (FunctionEntity functionEntity : functionEntities) {
            String functionName = functionEntity.getName();
            function_str.add(functionName);
        }
        model.addAttribute("functionName", function_str);
        List<GroupEntity> groupEntities = groupService.findAll();
        model.addAttribute("functions", functionService.findAll());
        model.addAttribute("groups", groupEntity);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity.getUsername());
        return "admin/group/edit-group";
    }

    @GetMapping("/admin-function")
    public String listFunction(Model model, Principal principal, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                                 @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
//        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        List<String> list_functionCode_str = new ArrayList<>();
        List<FunctionEntity> functionEntities = functionService.findFunctionByUserName(userName);
        for (FunctionEntity functionEntity : functionEntities) {
            String functionCode_str = functionEntity.getCode();
            list_functionCode_str.add(functionCode_str);
        }
        model.addAttribute("userFunction", list_functionCode_str);
        model.addAttribute("user", userName);
//
//        page
        model.addAttribute("totalPage", (int) Math.ceil((double) functionService.totalItem() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listFunction", functionService.findFunction(pageable));
//
        return "admin/function/list-function";
    }

    @GetMapping("/admin-addOrUpdateFunction")
    public String addOrUpdateFunction(@RequestParam(value = "id", required = false) Long id, Model model, Principal principal) {
        FunctionEntity functionEntity = new FunctionEntity();
        if (id != null) {
            functionEntity = functionService.findById(id);
        }
        model.addAttribute("function", functionEntity);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity.getUsername());
        return "admin/function/edit-function";
    }

    @GetMapping(value = "/admin-home")
    public String adminHome(Model model, Principal principal, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                            @RequestParam(value = "size", required = false, defaultValue = "15") Integer size,
                            @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity.getUsername());
        model.addAttribute("totalPage", (int) Math.ceil((double) newService.totalItemDeactive() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listNew", newService.findAllDeactive(pageable));
        //        tìm thể loại
        List<String> listcategory_str = new ArrayList<>();
        List<NewEntity> newEntities = newService.findAllDeactive(pageable);
        for (NewEntity entity : newEntities) {
            Long id = entity.getCategoryEntity().getId();
            CategoryEntity categoryDTO = categoryService.findById(id);
            listcategory_str.add(categoryDTO.getName());
        }
        model.addAttribute("listCategory", listcategory_str);
//
        return "admin/home";
    }
}
