package com.ist412.efinance.controller;

import com.ist412.efinance.model.AutoLoan;
import com.ist412.efinance.model.Loan;
import com.ist412.efinance.repository.LoanRepository;
import com.ist412.efinance.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanServiceImpl loanServiceImpl;

    @GetMapping("/loans")
    public String getMyLoans() {
        return "loans/loans";
    }

    @GetMapping("/newBusinessLoan")
    public String showBusinessLoanApplication(){
        return "loans/business-loan";
    }

    @GetMapping("/newPersonalLoan")
    public String showPersonalLoanApplication(){
        return "loans/personal-loan";
    }

    @GetMapping("/newAutoLoan")
    public String showAutoLoanApplication(Model model){
        AutoLoan autoLoan = new AutoLoan();
        model.addAttribute("autoLoan", autoLoan);
        return "loans/auto-loan";
    }

    @PostMapping("/saveAutoLoan")
    public String saveAutoLoan(@ModelAttribute("autoLoan") AutoLoan autoLoan){
        // how to add User data into the applicant attribute of AutoLoan??
        this.loanServiceImpl.saveAutoLoan(autoLoan);
        return "redirect:/loans";
    }


}
