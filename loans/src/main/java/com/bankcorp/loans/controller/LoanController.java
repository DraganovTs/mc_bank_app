package com.bankcorp.loans.controller;

import com.bankcorp.loans.constants.LoanConstants;
import com.bankcorp.loans.domain.dto.LoanDTO;
import com.bankcorp.loans.domain.dto.ResponseDTO;
import com.bankcorp.loans.service.impl.LoanServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class LoanController {

    private final LoanServiceImpl loanService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createLoan(@RequestParam String mobileNumber) {
        loanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
    }


    @GetMapping("/fetch")
    public ResponseEntity<LoanDTO> fetchLoanDetails(@RequestParam String mobileNumber) {
        LoanDTO loanDTO = loanService.fetchLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateLoan(@RequestBody LoanDTO loanDTO){
        boolean isUpdated = loanService.updateLoan(loanDTO);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoanConstants.STATUS_200,LoanConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoanConstants.STATUS_417,LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteLoan(@RequestParam String mobileNumber){
        boolean isDeleted = loanService.deleteLoan(mobileNumber);
        if (isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoanConstants.STATUS_200,LoanConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoanConstants.STATUS_417,LoanConstants.MESSAGE_417_DELETE));
        }
    }
}
