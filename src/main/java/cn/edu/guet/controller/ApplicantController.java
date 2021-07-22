package cn.edu.guet.controller;


import cn.edu.guet.bean.Applicant;
import cn.edu.guet.bll.ApplicantService;
import cn.edu.guet.util.PageTool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("applicant")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    //应聘者页面
    @GetMapping("/viewApplicant")
    public String view(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewApplicant();
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        model.addAttribute("pageInfo",pageInfo);
        return "viewApplicant";
    }

    @GetMapping("/deleteApplicant")
    public String delete(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,String applicant_id) {
        applicantService.deleteApplicant(applicant_id);
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewApplicant();
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        model.addAttribute("pageInfo",pageInfo);
        return "viewApplicant";
    }

    @GetMapping("/passApplicant")
    public String pass(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,int applicant_id) {
        applicantService.passApplicant(applicant_id);
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewApplicant();
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        model.addAttribute("pageInfo",pageInfo);
        return "viewApplicant";
    }


    @GetMapping("/searchApplicant")
    public String search(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.searchApplicant(keyValue);
        PageHelper.startPage(pageNum,10);
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        model.addAttribute("pageInfo",pageInfo);
        return "viewApplicant";
    }

    @RequestMapping  ("/addApplicant")
    public String addApplicant(ModelMap map){
        map.addAttribute("applicant",new Applicant());
        return "addApplicant";
    }

    @PostMapping ("/saveApplicant")
    public String save(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@ModelAttribute Applicant applicant,@ModelAttribute("applicant_info_key") Integer applicant_info_key) {
        if (applicant_info_key==0){
            applicantService.addApplicant(applicant);
            System.out.println(applicant.getApplicant_info_key());
       }else {
            applicantService.editApplicant(applicant);
            System.out.println(applicant.getApplicant_name());
        }
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewApplicant();
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        model.addAttribute("pageInfo",pageInfo);
        return "viewApplicant";
    }

    @RequestMapping ("/editApplicant")
    public String editApplicnat(ModelMap map,@ModelAttribute("applicant_id") int applicant_id ){
        map.addAttribute("applicant",applicantService.findByid(applicant_id));
        return "addApplicant";
    }


    //招聘页面
    @GetMapping("/viewpassApplicant")
    public String viewpass(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",new PageTool().Paging( applicantList));
        return "viewpassApplicant";
    }

    @GetMapping("/admitApplicant")
    public String admit(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,int applicant_id) {
        applicantService.admitApplicant(applicant_id);
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",new PageTool().Paging( applicantList));
        return "viewpassApplicant";
    }

    @GetMapping("/noadmitApplicant")
    public String noadmit(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,String applicant_id) {
        applicantService.noadmitApplicant(applicant_id);
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",new PageTool().Paging( applicantList));
        return "viewpassApplicant";
    }
    @GetMapping("/findpassApplicant")
    public String findpass(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.findpassApplicant(keyValue);
        PageHelper.startPage(pageNum,10);
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        model.addAttribute("pageInfo",pageInfo);
        return "viewpassApplicant";
    }

    //查看录取人员
    @GetMapping("/viewadmitApplicant")
    public String viewadmit(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Applicant> applicantList=applicantService.viewadmitApplicant();
        model.addAttribute("pageInfo",new PageTool().Paging( applicantList));
        return "viewadimtApplicant";
    }

    @GetMapping("/findadmitApplicant")
    public String findadmit(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.findadmitApplicant(keyValue);
        PageHelper.startPage(pageNum,10);
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        model.addAttribute("pageInfo",pageInfo);
        return "viewadmitApplicant";
    }
}
