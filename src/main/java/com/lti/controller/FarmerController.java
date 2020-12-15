package com.lti.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lti.exception.IdNotFoundException;
import com.lti.message.ResponseFile;
import com.lti.message.ResponseMessage;
import com.lti.model.ApplyInsurance;
import com.lti.model.BidProduct;
import com.lti.model.Bidder;
import com.lti.model.ClaimInsurance;
import com.lti.model.ContactUs;
import com.lti.model.Crop;
import com.lti.model.FarmerRegisteration;
import com.lti.model.FileInfo;
import com.lti.model.SoldHistory;
import com.lti.service.ApplyInsuranceService;
import com.lti.service.BidProductService;
import com.lti.service.BidderService;
import com.lti.service.ClaimInsuranceService;
import com.lti.service.ContactUsService;
import com.lti.service.CropService;
import com.lti.service.FarmerServiceClass;
import com.lti.service.FileStorageService;

@RestController
@RequestMapping("/farmer")
@CrossOrigin(origins="http://localhost:4200")
public class FarmerController {
	@Autowired
	FarmerServiceClass serviceobj;
	@Autowired
	CropService serviceobjcrop;
	@Autowired
	BidderService serviceobjbidder;
	@Autowired
	ContactUsService cousservice;
	@Autowired
	 FileStorageService storageService;
	@Autowired
	BidProductService bprodservice;
	@Autowired
	ApplyInsuranceService serviceobjapplyinsurance;
	
	@Autowired
	ClaimInsuranceService serviceobjclaiminsurance;
	
	// Create Applyinsurance
	@PostMapping("/applyInsurance")
	public ResponseEntity<String> ApplyInsuranceCreation(@RequestBody ApplyInsurance applyinsurance) {
		ApplyInsurance a = serviceobjapplyinsurance.ApplyInsuranceCreation(applyinsurance);
		if (a == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Insurance created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	
	
	//get  Insurance List
	@GetMapping("/getInsuranceList")
	private ResponseEntity<List<ApplyInsurance>> getInsuranceList() {
		List<ApplyInsurance> ins_list = serviceobjapplyinsurance.getInsuranceList();
		return new ResponseEntity<List<ApplyInsurance>>(ins_list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/updateInsuranceList/{policy_no}")
	public ResponseEntity<String> updateInsuranceList(@PathVariable("policy_no")int policy_no){
		//FarmerRegisteration fr=new FarmerRegisteration();
		
		String p_id=serviceobjapplyinsurance.updateInsuranceList(policy_no);
		if(p_id==null) {
			throw new IdNotFoundException("Some value wrong");
			
		}
		else {
			return new ResponseEntity<String>("Updated successfully", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewMyInsurance/{email_id}")
	private ResponseEntity<List<ApplyInsurance>> viewMyInsurance(@PathVariable("email_id")String email_id) {
		List<ApplyInsurance> ins_list = serviceobjapplyinsurance.viewMyInsurance(email_id);
		return new ResponseEntity<List<ApplyInsurance>>(ins_list, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	// Create Claiminsurance
	@PostMapping("/claiminsurance")
	public ResponseEntity<String> ClaimInsuranceCreation(@RequestBody ClaimInsurance claiminsurance) {
		ClaimInsurance c = serviceobjclaiminsurance.ClaimInsuranceCreation(claiminsurance);
		if (c == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Insurance claimed successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/checkPolicy/{policy_no}")
	public ResponseEntity<String> checkPolicy(@PathVariable("policy_no") int policy_no) {
		 String check = serviceobjclaiminsurance.checkPolicy(policy_no);
		if (check.equals("false")) {
			return new ResponseEntity<String>("You have not yet applied for insurance", new HttpHeaders(),HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Claim Successful", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	

	
	 @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(FileInfo fileinfo,@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      
	    System.out.println("entered");
	      storageService.store(fileinfo.getEmail_id(),fileinfo.getGetrole(),file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	    	System.out.println(e);
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	    	dbFile.getEmail_id(),
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length
	          );
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    FileInfo fileinfo = storageService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileinfo.getName() + "\"")
	        .body(fileinfo.getData());
	  }
	
	@PostMapping("/showfarmerregistration")
	public ResponseEntity<String> register(@RequestBody FarmerRegisteration fr) {
		 FarmerRegisteration farmer = serviceobj.register(fr);
		if (farmer == null) {
			throw new IdNotFoundException("Some values are wrong ");
		} else {
			return new ResponseEntity<String>("Registrated successfully", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/getallfarmer")
	private ResponseEntity<List<FarmerRegisteration>> getallfarmer() {
		List<FarmerRegisteration> farmerlist = serviceobj.showfarmer();
		return new ResponseEntity<List<FarmerRegisteration>>(farmerlist, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getFarmerRegisteredCount")
	private ResponseEntity<Integer> getFarmerRegisteredCount() {
		Integer farmercount = serviceobj.getFarmerRegisteredCount();
		return new ResponseEntity<Integer>(farmercount, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getFarmerApprovedCount")
	private ResponseEntity<Integer> getFarmerApprovedCount() {
		Integer f_approve_count = serviceobj.getFarmerApprovedCount();
		return new ResponseEntity<Integer>(f_approve_count, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping("/Login")
	public ResponseEntity<String> farmerlogin(@RequestBody Map<String,String> map){
		boolean fr= false;
		boolean br=serviceobjbidder.LogincredentialBidder(map.get("email_id"),map.get("password"));
		fr = serviceobj.Logincredential(map.get("email_id"),map.get("password"));
		if (fr) {
			return new ResponseEntity<String>("Farmer Loggedin successfully", new HttpHeaders(),HttpStatus.OK);
			
		} 
		else if(br) {
			return new ResponseEntity<String>("Bidder Loggedin successfully", new HttpHeaders(),HttpStatus.OK);
		}
		
		
		else {
			return new ResponseEntity<String>("/Invalid Credentails", new HttpHeaders(),HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/placesellrequest")
	public ResponseEntity<String> cropregsiter(@RequestBody Crop c) {
		 Crop crop= serviceobjcrop.placesellrequest(c);
		if (crop == null) {
			throw new IdNotFoundException("Some values are wrong ");
		} else {
			return new ResponseEntity<String>("Crop details added successfully", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/getcrop")
	private ResponseEntity<List<Crop>> getcrop() {
		List<Crop>  croplist= serviceobjcrop.getcrop();
		return new ResponseEntity<List<Crop>>(croplist, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/gethistory")
	private ResponseEntity<List<SoldHistory>> gethistory() {
		List<SoldHistory>  soldlist= serviceobjcrop.gethistory();
		return new ResponseEntity<List<SoldHistory>>(soldlist, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/showbidderregistration")
	public ResponseEntity<String> register(@RequestBody Bidder br) {
		 Bidder bidder = serviceobjbidder.register(br);
		if (bidder == null) {
			throw new IdNotFoundException("Some values are wrong ");
		} else {
			return new ResponseEntity<String>("Registrated successfully", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@PutMapping("/updateFarmer/{farmer_id}")
	public ResponseEntity<String> updateFarmer(@PathVariable("farmer_id")int farmer_id){
		//FarmerRegisteration fr=new FarmerRegisteration();
		
		FarmerRegisteration f_id=serviceobj.updateFarmer(farmer_id);
		if(f_id==null) {
			throw new IdNotFoundException("Some value wrong");
			
		}
		else {
			return new ResponseEntity<String>("Updated successfully", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/getallbidder")
	private ResponseEntity<List<Bidder>> getallbidder() {
		List<Bidder> bidderlist = serviceobjbidder.showbidder();
		return new ResponseEntity<List<Bidder>>(bidderlist, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getBidderRegisteredCount")
	private ResponseEntity<Integer> getBidderRegisteredCount() {
		Integer biddercount = serviceobjbidder.getBidderRegisteredCount();
		return new ResponseEntity<Integer>(biddercount, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getBidderApprovedCount")
	private ResponseEntity<Integer> getBidderApprovedCount() {
		Integer b_approve_count = serviceobjbidder.getBidderApprovedCount();
		return new ResponseEntity<Integer>(b_approve_count, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/updateBidder/{bidder_id}")
	public ResponseEntity<String> updateBidder(@PathVariable("bidder_id")int bidder_id){
		//FarmerRegisteration fr=new FarmerRegisteration();
		
		Bidder b_id=serviceobjbidder.updateBidder(bidder_id);
		if(b_id==null) {
			throw new IdNotFoundException("Some value wrong");
			
		}
		else {
			return new ResponseEntity<String>("Updated successfully", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@PostMapping("/sendvisitormessage")
	public ResponseEntity<String> sendmessage(@RequestBody ContactUs cu){
		ContactUs cous=cousservice.sendmessage(cu);
		if (cous == null) {
			throw new IdNotFoundException("Something went wrong try again.... ");
		} else {
			return new ResponseEntity<String>("Message Sent successfully", new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/getallvisitormessage")
	public ResponseEntity<List<ContactUs>> getallmessage(){
		List<ContactUs> cous=cousservice.getallmessage();
		return new ResponseEntity<List<ContactUs>>(cous, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/checkadminapproval/{email_id}")
	public ResponseEntity<String> checkAdminApproval(@PathVariable("email_id") String email_id) {
		 String f = serviceobj.checkAdminApproval(email_id);
		 
		if (f!=null && f.equals("false")) {
			return new ResponseEntity<String>("Admin approval is still pending" ,new HttpHeaders(),HttpStatus.OK);
		}else{ 
			String b = serviceobjbidder.checkadminapproval(email_id);
			if(b!=null && b.equals("false")){
			return new ResponseEntity<String>("Admin approval is still pending" ,new HttpHeaders(),HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Admin Approved" ,new HttpHeaders(),HttpStatus.OK);
		}
		}
	}
	
	@GetMapping("/getFarmerList")
	private ResponseEntity<List<FarmerRegisteration>> getFarmerList() {
		List<FarmerRegisteration> farmerlist = serviceobj.getFarmerList();
		return new ResponseEntity<List<FarmerRegisteration>>(farmerlist, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getBidderList")
	private ResponseEntity<List<Bidder>> getBidderList() {
		List<Bidder> bidderlist = serviceobjbidder.getBidderList();
		return new ResponseEntity<List<Bidder>>(bidderlist, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/resetpassword")
	public ResponseEntity<String> updatePassword(@RequestBody Map<String,String> map) {
		Bidder bidder = serviceobjbidder.updatePassword(map.get("email_id"),map.get("password"));
		 
		 if(bidder!=null) {
			 return new ResponseEntity<String>("Password Updated successfully", new HttpHeaders(),HttpStatus.OK);
			 
		 }
		 else 
			 
			  {	
			
			 FarmerRegisteration farmer = serviceobj.updatePassword(map.get("email_id"),map.get("password"));
		 	if(farmer!=null) {
		 		
		 		 return new ResponseEntity<String>("Password Updated successfully", new HttpHeaders(),HttpStatus.OK);
		 	}
			
			 else {
				 
				 return new ResponseEntity<String>("Email id does not exist", new HttpHeaders(),HttpStatus.OK);
			 }
			 
		 }
		
		
	}
	
	//Bid Product Detail
	@PostMapping("/bidforproduct")
	public ResponseEntity<String> bidproduct(@RequestBody BidProduct bp) {
		if(bp.getBidamount()<=bp.getBaseprice()){
			return new ResponseEntity<String>("Bid Amount cannot be less then Base Price", new HttpHeaders(),HttpStatus.OK);
		}
		else{
			BidProduct bidproduct = bprodservice.bidproduct(bp);
			if (bidproduct == null) {
				throw new IdNotFoundException("Something is wrong, Bid Again ");
			} else {
				return new ResponseEntity<String>("Bid Amount entered successfully", new HttpHeaders(),HttpStatus.OK);
			}
		}
	}
	
	@GetMapping("/getallbidproduct")
	private ResponseEntity<List<BidProduct>> getallbidproduct() {
		List<BidProduct> bidproductlist = bprodservice.getallbidproduct();
		return new ResponseEntity<List<BidProduct>>(bidproductlist, new HttpHeaders(), HttpStatus.OK);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	private ResponseEntity<String> IdNotFound(IdNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
