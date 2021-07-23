package cn.edu.guet.controller;


import cn.edu.guet.bean.Applicant;
import cn.edu.guet.bll.ApplicantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("applicant")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;
    //应聘者页面
    @GetMapping("/viewApplicant")
    public String view(Model model) {
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewApplicant";
    }

    @GetMapping("/deleteApplicant")
    public String delete(Model model,String applicant_id) {
        applicantService.deleteApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewApplicant";
    }
    @GetMapping("/deletesomeApplicant")
    public ModelAndView deletesomeApplicant( String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                applicantService.deleteApplicant(strs[i]);
            } catch (Exception e) {
            }
        }
        return new ModelAndView("redirect:viewApplicant");
    }

    @GetMapping("/passApplicant")
    public String pass(Model model,int applicant_id) {
        applicantService.passApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewApplicant";
    }


    @GetMapping("/searchApplicant")
    public String search(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.searchApplicant(keyValue);
        model.addAttribute("pageInfo",applicantList);
        return "viewApplicant";
    }

    @RequestMapping  ("/addApplicant")
    public String addApplicant(ModelMap map){
        map.addAttribute("applicant",new Applicant());
        return "addApplicant";
    }

    @PostMapping ("/saveApplicant")
    public String save(Model model,@ModelAttribute Applicant applicant,@ModelAttribute("applicant_info_key") Integer applicant_info_key) {
        if (applicant_info_key==0){
            applicantService.addApplicant(applicant);
            System.out.println(applicant.getApplicant_info_key());
       }else {
            applicantService.editApplicant(applicant);
            System.out.println(applicant.getApplicant_name());
        }
        List<Applicant> applicantList=applicantService.viewApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewApplicant";
    }

    @RequestMapping ("/editApplicant")
    public String editApplicnat(ModelMap map,@ModelAttribute("applicant_id") int applicant_id ){
        map.addAttribute("applicant",applicantService.findByid(applicant_id));
        return "addApplicant";
    }


    //招聘页面
    @GetMapping("/viewpassApplicant")
    public String viewpass(Model model) {
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }

    @GetMapping("/admitApplicant")
    public String admit(Model model,int applicant_id) {
        applicantService.admitApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }

    @GetMapping("/noadmitApplicant")
    public String noadmit(Model model,String applicant_id) {
        applicantService.noadmitApplicant(applicant_id);
        List<Applicant> applicantList=applicantService.viewpassApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }
    @GetMapping("/findpassApplicant")
    public String findpass(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.findpassApplicant(keyValue);
        model.addAttribute("pageInfo",applicantList);
        return "viewpassApplicant";
    }

    //查看录取人员
    @GetMapping("/viewadmitApplicant")
    public String viewadmit(Model model) {
        List<Applicant> applicantList=applicantService.viewadmitApplicant();
        model.addAttribute("pageInfo",applicantList);
        return "viewadmitApplicant";
    }

    @GetMapping("/findadmitApplicant")
    public String findadmit(Model model,@ModelAttribute(value="keyValue")String keyValue) {
        List<Applicant> applicantList=applicantService.findadmitApplicant(keyValue);
        model.addAttribute("pageInfo",applicantList);
        return "viewadmitApplicant";
    }
}
