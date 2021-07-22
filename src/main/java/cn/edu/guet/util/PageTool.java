package cn.edu.guet.util;


import cn.edu.guet.bean.Applicant;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageTool {
    public PageInfo<Applicant> Paging(List<Applicant> applicantList){
        PageInfo<Applicant> pageInfo = new PageInfo<Applicant>(applicantList);
        return pageInfo;
    }
}
