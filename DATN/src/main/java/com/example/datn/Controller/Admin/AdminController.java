package com.example.datn.Controller.Admin;

import com.example.datn.entity.*;
import com.example.datn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private INewService newService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IRoleDetailService roleDetailService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IGroupRoleService groupRoleService;


    @GetMapping("/admin-new")
    public String listNew(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                          @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort,
                          Model model, Principal principal, HttpServletRequest request) {
//        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        UserEntity userEntity = userService.findByUserName(userName);
        List<String> list_roleDetailCode_str = new ArrayList<>();
        List<RoleDetailEntity> roleDetailEntities = roleDetailService.findRoleByUserName(userName);
        for (RoleDetailEntity entity : roleDetailEntities) {
            String roleDetailCode_str = entity.getCode();
            list_roleDetailCode_str.add(roleDetailCode_str);
        }
        model.addAttribute("userRoleDetail", list_roleDetailCode_str);
        model.addAttribute("user", userName);
//
//        page
        model.addAttribute("totalPage", (int) Math.ceil((double) newService.totalItem() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listNew", newService.findNew(pageable));
//
//        tìm thể loại
        List<String> listcategory_str = new ArrayList<>();
        List<NewEntity> newEntities = newService.findNew(pageable);
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
        model.addAttribute("userInfo", userEntity.getUserName());
        return "admin/new/edit";
    }

    @GetMapping("/admin-user")
    public String listUser(Model model, Principal principal, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                           @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                           @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
//        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        List<String> list_roleDetailCode_str = new ArrayList<>();
        List<RoleDetailEntity> roleDetailEntities = roleDetailService.findRoleByUserName(userName);
        for (RoleDetailEntity entity : roleDetailEntities) {
            String roleDetailCode_str = entity.getCode();
            list_roleDetailCode_str.add(roleDetailCode_str);
        }
        model.addAttribute("userRoleDetail", list_roleDetailCode_str);
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
        List<List> list_groupRoleName_list = new ArrayList<>();
        List<UserEntity> userEntities = userService.findUser(pageable);
        for (UserEntity userEntity1 : userEntities) {
            List<String> list_groupRoleUser_str = new ArrayList<>();
            String userName_str = userEntity1.getUserName();
            List<GroupRoleEntity> groupRoleEntities = groupRoleService.findGroupRoleByUserName(userName_str);
            for (GroupRoleEntity groupRoleEntity : groupRoleEntities) {
                String groupRole_str = groupRoleEntity.getName();
                list_groupRoleUser_str.add(groupRole_str);
            }
            list_groupRoleName_list.add(list_groupRoleUser_str);
        }
        model.addAttribute("listGroupRoleUser", list_groupRoleName_list);
//
        return "admin/tk/list-user";
    }

    @GetMapping("/admin-addOrUpdateUser")
    public String addOrUpdateUser(@RequestParam(value = "id", required = false) Long id, Model model, Principal principal) {
        UserEntity userEntity = new UserEntity();
        if (id != null) {
            userEntity = userService.findById(id);
            List<String> list_groupRoleUserName_str = new ArrayList<>();
            List<GroupRoleEntity> groupRoleEntities = groupRoleService.findGroupRoleByUserName(userEntity.getUserName());
            for (GroupRoleEntity groupRoleEntity : groupRoleEntities) {
                String groupRoleUserName_str = groupRoleEntity.getName();
                list_groupRoleUserName_str.add(groupRoleUserName_str);
            }
            model.addAttribute("userGroupRoleNames", list_groupRoleUserName_str);
        }
        List<GroupRoleEntity> groupRoleUserEntityList = groupRoleService.findAll();
        List<String> list_groupRoleName_str = new ArrayList<>();
        for (GroupRoleEntity groupRoleEntity : groupRoleUserEntityList) {
            String groupRoleName_str = groupRoleEntity.getName();
            list_groupRoleName_str.add(groupRoleName_str);
        }
        model.addAttribute("groupRoles", list_groupRoleName_str);
        model.addAttribute("users", userEntity);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity1 = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity1.getUserName());
        return "admin/tk/edit-tk";
    }

    @GetMapping("/admin-grouprole")
    public String listGroupRole(Model model, Principal principal, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                                @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
//        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        UserEntity userEntity = userService.findByUserName(userName);
        List<String> list_roleDetailCode_str = new ArrayList<>();
        List<RoleDetailEntity> roleDetailEntities = roleDetailService.findRoleByUserName(userName);
        for (RoleDetailEntity entity : roleDetailEntities) {
            String roleDetailCode_str = entity.getCode();
            list_roleDetailCode_str.add(roleDetailCode_str);
        }
        model.addAttribute("userRoleDetail", list_roleDetailCode_str);
        model.addAttribute("user", userName);
//
        //        page
        model.addAttribute("totalPage", (int) Math.ceil((double) groupRoleService.totalItem() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listGroupRole", groupRoleService.findGroupRole(pageable));
//
//        tìm chi tiết nhóm quyền
        List<GroupRoleEntity> groupRoleEntities = groupRoleService.findGroupRole(pageable);
        List<List> list_roleDetail_list = new ArrayList<>();
        for (GroupRoleEntity entity : groupRoleEntities) {
            List<String> list_roleDetail_str = new ArrayList<>();
            Long id_long = entity.getId();
            List<RoleDetailEntity> roleDetailEntityList = roleDetailService.findRoleByGroupRoleId(id_long);
            for (RoleDetailEntity entity1 : roleDetailEntityList) {
                String roleDetail_str = entity1.getPermission();
                list_roleDetail_str.add(roleDetail_str);
            }
            list_roleDetail_list.add(list_roleDetail_str);
        }
        model.addAttribute("groupRoleRoleDetails", list_roleDetail_list);
        return "admin/grouprole/list-grouprole";
    }

    @GetMapping("/admin-addOrUpdateGroupRole")
    public String addOrUpdateGroupRole(@RequestParam(value = "id", required = false) Long id, Model model, Principal principal) {
        GroupRoleEntity groupRoleEntity = new GroupRoleEntity();
        if (id != null) {
            groupRoleEntity = groupRoleService.findById(id);
            List<String> list_roleDetail_str = new ArrayList<>();
            List<RoleDetailEntity> roleDetailEntityList = roleDetailService.findRoleByGroupRoleId(groupRoleEntity.getId());
            for (RoleDetailEntity roleDetailEntity : roleDetailEntityList) {
                String roleDetail_str = roleDetailEntity.getPermission();
                list_roleDetail_str.add(roleDetail_str);
            }
            model.addAttribute("groupRoleRoleDetails", list_roleDetail_str);
        }
        List<RoleDetailEntity> roleDetailEntityList = roleDetailService.findAll();
        List<String> roleDetail_str = new ArrayList<>();
        for (RoleDetailEntity roleDetailEntity : roleDetailEntityList) {
            String roleDetailPermission = roleDetailEntity.getPermission();
            roleDetail_str.add(roleDetailPermission);
        }
        model.addAttribute("roleDetailPermission", roleDetail_str);
        List<GroupRoleEntity> groupRoleEntities = groupRoleService.findAll();
        model.addAttribute("roleDetails", roleDetailService.findAll());
        model.addAttribute("groupRoles", groupRoleEntity);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity.getUserName());
        return "admin/grouprole/edit-grouprole";
    }

    @GetMapping("/admin-roledetail")
    public String listRoleDetail(Model model, Principal principal, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", required = false, defaultValue = "8") Integer size,
                                 @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
//        phân quyền theo tk đăng nhập
        String userName = principal.getName();
        List<String> list_roleDetailCode_str = new ArrayList<>();
        List<RoleDetailEntity> roleDetailEntities = roleDetailService.findRoleByUserName(userName);
        for (RoleDetailEntity entity : roleDetailEntities) {
            String roleDetailCode_str = entity.getCode();
            list_roleDetailCode_str.add(roleDetailCode_str);
        }
        model.addAttribute("userRoleDetail", list_roleDetailCode_str);
        model.addAttribute("user", userName);
//
//        page
        model.addAttribute("totalPage", (int) Math.ceil((double) roleDetailService.totalItem() / size));
        model.addAttribute("page", page);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page-1, size, sortable);
        model.addAttribute("listRoleDetail", roleDetailService.findRoleDetail(pageable));
//
        return "admin/roledetail/list-roledetail";
    }

    @GetMapping("/admin-addOrUpdateRoleDetail")
    public String addOrUpdateRoleDetail(@RequestParam(value = "id", required = false) Long id, Model model, Principal principal) {
        RoleDetailEntity roleDetailEntity = new RoleDetailEntity();
        if (id != null) {
            roleDetailEntity = roleDetailService.findById(id);
        }
        model.addAttribute("roleDetail", roleDetailEntity);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity.getUserName());
        return "admin/roledetail/edit-roledetail";
    }

    @GetMapping(value = "/admin-home")
    public String adminHome(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByUserName(loginedUser.getUsername());
        model.addAttribute("userInfo", userEntity.getUserName());
        return "admin/home";
    }
}
