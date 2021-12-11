package com.ist412.efinance.controller;

import com.ist412.efinance.model.*;
import com.ist412.efinance.repository.LoanRepository;
import com.ist412.efinance.repository.UserRepository;
import com.ist412.efinance.service.CustomUserDetailsService;
import com.ist412.efinance.service.LoanServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;
@Slf4j
@Controller
public class LoanController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    private LoanServiceImpl loanServiceImpl;

    @GetMapping("/loans")
    public String getUserLoans(Model model, Principal principal) {
        model.addAttribute("listOfLoans", loanServiceImpl.getAllUserLoans(customUserDetailsService.getUserByPrincipal(principal)));
        return "loans/loans";
    }

    @GetMapping("/adminLoans")
    public String getAllLoans(Model model, Principal principal){
        model.addAttribute("allPendingLoans", loanServiceImpl.getAllLoans());

        return "admin/client-loans";


    }

    @GetMapping("/newAutoLoan")
    public String showAutoLoanApplication(Model model){
        Loan autoLoan = new AutoLoan();
        model.addAttribute("autoLoan", autoLoan);
        return "loans/auto-loan";
    }

//    @GetMapping("/saveLoan")
//    public String saveLoan(@ModelAttribute("newLoan") Loan newLoan, Errors errors,
//                           Principal principal){
//        if(errors.hasErrors()){
//            return "loans/loans";
//        }
//        User applicant = customUserDetailsService.getUserByPrincipal(principal);
//        newLoan.setLoanStatus("UPDATED");
//        log.info(applicant.toString());
//        this.loanServiceImpl.saveLoan(newLoan, applicant);
//        return "redirect:/loans";
//
//
//    }

    @PostMapping("/saveAutoLoan")
    public String saveAutoLoan(@ModelAttribute("autoLoan") AutoLoan autoLoan, Errors errors,
                               Principal principal){
        if(errors.hasErrors()){
            return "loans/auto-loan";
        }
        User applicant = customUserDetailsService.getUserByPrincipal(principal);
        autoLoan.setLoanStatus("SUBMITTED");
        log.info(applicant.toString());
        this.loanServiceImpl.saveLoan(autoLoan, applicant);
        this.loanServiceImpl.getAllLoans();
        return "redirect:/loans";

    }

    @GetMapping("/newPersonalLoan")
    public String showPersonalLoanApplication(Model model){
        Loan personalLoan = new PersonalLoan();
        model.addAttribute("personalLoan", personalLoan);
        return "loans/personal-loan";
    }

    @PostMapping("/savePersonalLoan")
    public String savePersonalLoan(@ModelAttribute("personalLoan") PersonalLoan personalLoan, Errors errors,
                               Principal principal){
        if(errors.hasErrors()){
            return "loans/personal-loan";
        }
        User applicant = customUserDetailsService.getUserByPrincipal(principal);
        personalLoan.setLoanStatus("SUBMITTED");
        log.info(applicant.toString());
        this.loanServiceImpl.saveLoan(personalLoan, applicant);
        this.loanServiceImpl.getAllLoans();
        return "redirect:/loans";

    }

    // Update - View form for personalLoan

    @GetMapping("/showPersonalLoanFormForUpdate/{loanId}")
    public String showPersonalLoanFormForUpdate(@PathVariable(value = "loanId") long loanId, Model model){

        Loan personalLoan = loanServiceImpl.getLoanById(loanId);

        model.addAttribute("personalLoan", personalLoan);

        //PersonalLoan PL = new PersonalLoan();
//        AutoLoan AL = new AutoLoan();




        return "loans/update_personal-loan";


    }

    @PostMapping("/saveBusinessLoan")
    public String saveBusinessLoan(@ModelAttribute("businessLoan") BusinessLoan businessLoan, Errors errors,
                                   Principal principal){
        if(errors.hasErrors()){
            return "loans/business-loan";
        }
        User applicant = customUserDetailsService.getUserByPrincipal(principal);
        businessLoan.setLoanStatus("SUBMITTED");
        log.info(applicant.toString());
        this.loanServiceImpl.saveLoan(businessLoan, applicant);
        this.loanServiceImpl.getAllLoans();
        return "redirect:/loans";

    }

    @GetMapping("/newBusinessLoan")
    public String showBusinessLoanApplication(Model model){
        Loan businessLoan = new BusinessLoan();
        model.addAttribute("businessLoan", businessLoan);
        return "loans/business-loan";

    }

    @GetMapping("/showAutoLoanFormForUpdate/{loanId}")
    public String showAutoLoanFormForUpdate(@PathVariable(value = "loanId") long loanId, Model model){

        Loan autoLoan = loanServiceImpl.getLoanById(loanId);
        model.addAttribute("autoLoan", autoLoan);
        return "loans/update_auto-loan";


    }

    @GetMapping("/deleteLoan/{loanId}")
    public String deleteLoan(@PathVariable (value = "loanId") long loanId){
        this.loanServiceImpl.deleteLoanById(loanId);
        return "redirect:/loans";
    }

    @GetMapping("/approveLoan/{loanId}")
    public String approveLoan(@PathVariable (value = "loanId") long loanId){

        Loan approveLoan = loanServiceImpl.getLoanById(loanId);
        approveLoan.setLoanStatus("APPROVED");
        this.loanServiceImpl.adminSaveLoan(approveLoan);
        return "redirect:/adminLoans";
    }

    @GetMapping("/cancelLoan/{loanId}")
    public String cancelLoan(@PathVariable (value = "loanId") long loanId){

        Loan cancelLoan = loanServiceImpl.getLoanById(loanId);
        cancelLoan.setLoanStatus("DENIED");
        this.loanServiceImpl.adminSaveLoan(cancelLoan);
        return "redirect:/adminLoans";
    }





}
