package com.bankcorp.accounts.controller;

import com.bankcorp.accounts.constants.AccountConstants;
import com.bankcorp.accounts.domain.dto.AccountContactInfoDTO;
import com.bankcorp.accounts.domain.dto.CustomerDTO;
import com.bankcorp.accounts.domain.dto.ErrorResponseDTO;
import com.bankcorp.accounts.domain.dto.ResponseDTO;
import com.bankcorp.accounts.service.impl.AccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Account in Bank Microservice Application",
        description = "CRUD REST APIs in Bank MC Application to CREATE,UPDATE,FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {

    private final AccountServiceImpl accountService;
    @Value("${build.version}")
    private String buildVersion;

    private final Environment environment;
    private final AccountContactInfoDTO accountContactInfoDTO;

    public AccountsController(AccountServiceImpl accountService, Environment environment, AccountContactInfoDTO accountContactInfoDTO) {
        this.accountService = accountService;
        this.environment = environment;
        this.accountContactInfoDTO = accountContactInfoDTO;
    }

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer & Account inside Bank MC"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch new Customer & Account based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )

    })
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam
                                                           @Pattern(regexp = "^|[0-9]{10}"
                                                                   , message = "Mobile number must be 10 digits!")
                                                           String mobileNumber) {
        CustomerDTO customerDTO = accountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerDTO);
    }

    @Operation(
            summary = "Update Account Details REST API",
            description = "REST API to update Customer & Account based on account number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = accountService.updateAccount(customerDTO);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Account and Customer Details REST API",
            description = "REST API to update Customer & Account based on mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam
                                                            @Pattern(regexp = "^|[0-9]{10}"
                                                                    , message = "Mobile number must be 10 digits!")
                                                            String mobileNumber) {
        boolean isDeleted = accountService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_DELETE));
        }
    }
    @Operation(
            summary = "Get Build information",
            description = "Get Build information that is deployed into accounts microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )

    })
    @GetMapping("/build-info")
    public ResponseEntity<String>getBuildVersion(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @Operation(
            summary = "Get Java version",
            description = "Get Java version that is install into accounts microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )

    })
    @GetMapping("/java-version")
    public ResponseEntity<String>getJavaVersion(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }


    @Operation(
            summary = "Get Contact Info",
            description = "Contact Info details that can be reached out in case of any issues"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )

    })
    @GetMapping("/contact-info")
    public ResponseEntity<AccountContactInfoDTO>getContactInfo(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountContactInfoDTO);
    }

}
