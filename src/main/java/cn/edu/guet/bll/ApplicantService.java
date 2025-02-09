package cn.edu.guet.bll;


import cn.edu.guet.bean.Applicant;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ApplicantService {
    //查看应聘者
    List<Applicant> viewApplicant();
    //删除所选应聘者
    void deleteApplicant(String applinticantId);
    //同意面试
    void passApplicant(String applicantId);
    //关键字搜索
    List<Applicant> searchApplicant(String keyword);
    //添加
    int addApplicant(Applicant applicant);
    //修改
    int editApplicant(Applicant applicant);
    //根据id查询
    Applicant findByid(int id);


    //查看面试者
    List<Applicant> viewpassApplicant();
    //通过面试
    void admitApplicant(String applicantId);
    //面试失败
    void noadmitApplicant(String applinticantId);
    //关键字搜索
    List<Applicant> findpassApplicant(String keyword);

    //查看通过面试人员
    List<Applicant> viewadmitApplicant();
    //关键字搜索
    List<Applicant> findadmitApplicant(String keyword);

    void deleteadmitApplicant(String applinticantId);
}
