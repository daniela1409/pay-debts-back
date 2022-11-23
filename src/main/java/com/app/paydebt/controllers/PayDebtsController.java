package com.app.paydebt.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.app.paydebt.services.IFirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.paydebt.DTO.DebtDTO;
import com.app.paydebt.model.Debt;
import com.app.paydebt.services.IBankService;
import com.app.paydebt.services.IDebtService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("pay_debts")
public class PayDebtsController {
	
	@Autowired
	private IBankService iBankService;
	
	@Autowired
	private IDebtService iDebtService;

	@Autowired
	private IFirebaseService iFirebaseService;

	@PutMapping("/")
	public @ResponseBody String payDebts(@Valid @RequestBody DebtDTO debtDTO, BindingResult result) {
		
		String response = "";
		
		try {
			if (result.hasErrors()) {
	            throw new RuntimeException("El valor minimo de cuotas es 1");
	        }
			
			boolean payDebts = iDebtService.payDebt(debtDTO);
						
			response = "Pago exitoso";
		}catch (RuntimeException e) {
            response = e.getMessage();
        }
		return response;
		
	}

	@GetMapping("/get")
	public @ResponseBody String ensayo(HttpServletRequest request) throws FirebaseAuthException {

		String response = "";

		try {
			String bearerToken = request.getHeader("Authorization");
			if(bearerToken == null){
				throw new RuntimeException("Autorización con token está activa");
			}
			String[] parts = bearerToken.split(" ");

			//String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6ImE5NmFkY2U5OTk5YmJmNWNkMzBmMjlmNDljZDM3ZjRjNWU2NDI3NDAiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vcGF5ZGVidHMtNDA2YjAiLCJhdWQiOiJwYXlkZWJ0cy00MDZiMCIsImF1dGhfdGltZSI6MTY2OTIzNzExMSwidXNlcl9pZCI6InBzWDVQYkZ5RDJlY21jaEIycGJNbkZJeWNIUDIiLCJzdWIiOiJwc1g1UGJGeUQyZWNtY2hCMnBiTW5GSXljSFAyIiwiaWF0IjoxNjY5MjM3MTExLCJleHAiOjE2NjkyNDA3MTEsImVtYWlsIjoiamVkYWdvczE0MDlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbImplZGFnb3MxNDA5QGdtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.xOKofakhzCuDXvOFYOCj0qpijW-R1A2h7UQChLnSHajBNDANNzinytASzgMR6vVThy7EoSHH35OCIqZP84bO7AL4hjKfxNbQbwybhF1iyAtfUEZoOF-W7dAiQ8IR5ZtmJK7VMOjSCsn6TgFhVvaAjuKyzoX7IzpELMsSc82XiWNOhaM-gu9lZtFv-39v1TA4ipVCSF3DdB9oBxs-0RFlM_DX_ibse43CGAPWu5ndElyxL4zvngQmBPZV3_sERZfsiZys0VAeh1C5TgK6aynEyWPCUk8eDvkYA3BoB2PzVQelo5655obrKk7bqSDB3SAMsuQYojc-ag9d3OWy3wEj4g";
			String id = iFirebaseService.isToken(parts[1]);

			if(id == null){
				throw new RuntimeException("token no valido");
			}

			response = "Hecho con exito";
		}catch (RuntimeException e) {
			response = e.getMessage();
		}
		return response;


	}

}
