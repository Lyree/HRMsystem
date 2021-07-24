package cn.edu.guet.bll.impl;
import cn.edu.guet.bean.Applicant;
import cn.edu.guet.bll.ApplicantService;
import cn.edu.guet.mapper.ApplicantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 class ApplicantImpl implements ApplicantService {
    @Autowired
    private ApplicantMapper applicantMapper;
    @Override
    public List<Applicant> viewApplicant() {
        return applicantMapper.viewApplicant();
    }

    @Override
    public void deleteApplicant(String applicantId) {
        applicantMapper.deleteApplicant(applicantId);
    }
    @Override
    public void passApplicant(String applicantId) {
        applicantMapper.passApplicant(applicantId);
    }

    @Override
    public void admitApplicant(String applicantId) {
        applicantMapper.admitApplicant(applicantId);
    }

    @Override
    public void noadmitApplicant(String applinticantId) {
        applicantMapper.noadmitApplicant(applinticantId);
    }

    @Override
    public List<Applicant> findpassApplicant(String keyword) {
        return applicantMapper.findpassApplicant(keyword);
    }

    @Override
    public List<Applicant> viewadmitApplicant() {
        return applicantMapper.viewadmitApplicant();
    }

    @Override
    public List<Applicant> findadmitApplicant(String keyword) {
        return applicantMapper.findadmitApplicant(keyword);
    }

    @Override
    public void deleteadmitApplicant(String applinticantId) {
        applicantMapper.deleteadmitApplicant(applinticantId);
    }

    @Override
    public List<Applicant> searchApplicant(String keyword) {
        return applicantMapper.searchApplicant(keyword);
    }

    @Override
    public int addApplicant(Applicant applicant) {

        return applicantMapper.addApplicant(applicant);
    }

    @Override
    public int editApplicant(Applicant applicant) {
        return applicantMapper.editApplicant(applicant);
    }

    @Override
    public Applicant findByid(int id) {
        return applicantMapper.findByid(id);
    }

    @Override
    public List<Applicant> viewpassApplicant() {
        return applicantMapper.viewpassApplicant();
    }
}
