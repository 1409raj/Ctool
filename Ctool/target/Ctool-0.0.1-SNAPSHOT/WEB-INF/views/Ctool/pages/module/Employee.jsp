<style>
table, th, td {
	border: 1px solid black !important;
	padding: 0px !important;
	line-height: 2 !important;
}
</style>
<!-- Start tabs area-->
<div class="tabs-info-area" ng-init="getDataOnLoad()">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="widget-tabs-int">
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<div class="tab-hd">
									<h2>Employee Details</h2>
								</div>
							</div>
						</div>

						<div class="col-md-10">
							<div class="form-group">
								<div class="tab-hd pull-right">
									<label> Change Employee <select
										class="form-control input-sm" ng-model="details"
										ng-change="nextEmployee()">
											<option ng-repeat="employee1 in pankaj" value="{{employee1}}">{{employee1.empName}}
												| {{employee1.empCode}}</option>

									</select>
									</label>
								</div>
							</div>
						</div>
					</div>


					<div class="widget-tabs-list">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" data-target="#home"><b><i
										class="fa fa-users"></i>&nbsp;Employee Info</b></a></li>
							<li><a data-toggle="tab" data-target="#menu1"><b>PMS
										Info (Current)</b></a></li>
							<li><a data-toggle="tab" data-target="#menu2"><b>Compensation
										Info</b></a></li>

							<!--  <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Select Employees
    <span class="caret"></span></a>
    <ul class="dropdown-menu" style="height: 250px;overflow: auto;">
      <li ng-repeat="employee1 in pankaj"><a href="" ng-model="employee1.checked"ng-click="nextEmployee(employee)" >Submenu 1-1</a></li>
    </ul>
  </li> -->
						</ul>
						<div class="tab-content tab-custom-st">
							<div id="home" class="tab-pane fade in active">
								<div class="tab-ctn">

									<div class="container-fluid">

										<div class="row">
											<div class="col-md-12">

												<ul class="list-inline  customList">
													<li><b>Employee Code</b><br>
														<p>
															<i class="fa fa-id-card-o"></i>&nbsp;{{employee.empCode}}
														</p></li>

													<li><b>Assessment Year</b><br>
														<p>
															<i class="fa fa-calendar"></i>&nbsp;{{employee.assessmentYear}}
														</p></li>

													<li><b>Employee Name</b><br>
														<p>
															<i class="fa fa-user"></i>&nbsp;{{employee.empName}}
														</p></li>
													<li><b>Date Of Joining</b>
														<p>
															<i class="fa fa-calendar"></i>&nbsp;{{employee.dateOfJoining
															| date:'yyyy-MM-dd'}}
														</p></li>
													<li><b>Email Address</b>
														<p>
															<i class="fa fa-envelope"></i>&nbsp;{{employee.email}}
														</p></li>
												</ul>
											</div>


										</div>
										<hr>
										<div class="row">
											<div class="col-md-12">

												<ul class="list-inline customList">
													<li><b>Designation</b>
														<p>{{employee.designation}}</p></li>

													<li><b>Department</b>
														<p>{{employee.department}}</p></li>

													<li><b>Location</b>
														<p>
															<i class="fa fa-map-marker"></i>&nbsp;{{employee.location}}
														</p></li>

													<li><b>Contact Info</b>
														<p>
															<i class="fa fa-mobile"></i>&nbsp;{{employee.mobile}}
														</p></li>




												</ul>
											</div>
										</div>

										<hr>



									</div>




								</div>
							</div>
							<div id="menu1" class="tab-pane fade">
								<div class="tab-ctn">
									<div class="row">
										<div class="col-md-12">

											<ul class="list-inline  customList">
												<li><b>Employee Code</b><br>
													<p>
														<i class="fa fa-id-card-o"></i>&nbsp;{{employee.empCode}}
													</p></li>

												<li><b>Assessment Year</b><br>
													<p>
														<i class="fa fa-calendar"></i>&nbsp;{{employee.assessmentYear}}
													</p></li>

												<li><b>Employee Name</b><br>
													<p>
														<i class="fa fa-user"></i>&nbsp;{{employee.empName}}
													</p></li>

											</ul>
										</div>


									</div>
									<hr>

									<div class="row">
										<div class="col-md-12">

											<ul class="list-inline customList">
												<li><b>Assessment Year</b>
													<p>
														<i class="fa fa-calendar"></i>&nbsp;{{employee.assessmentYear}}
													</p></li>

												<li><b>KRA's (75%)</b>
													<p>
														<i class="fa fa-star"></i>&nbsp;{{employee.kra}}
													</p></li>


												<li><b>KRA's Rating</b>
													<p>
														<i class="fa fa-star"></i>&nbsp;{{employee.kraRating}}
													</p></li>

												<li><b>Behavioural Competence (15%)</b>
													<p>
														<i class="fa fa-star"></i>&nbsp;{{employee.behaviouralCompetence}}
													</p></li>

												<li><b>Behavioural Competence Rating</b>
													<p>
														<i class="fa fa-star"></i>&nbsp;{{employee.behaviouralCompetenceRating}}
													</p></li>


											</ul>
										</div>
									</div>

									<hr>


									<div class="row">
										<div class="col-md-12">

											<ul class="list-inline customList">
												<li><b>Extraordinary Initiatives (10%)</b>
													<p>{{employee.extraOrdinaryInitiative}}</p></li>

												<li><b>Extraordinary Initiatives Rating</b>
													<p>
														<i class="fa fa-star"></i>&nbsp;{{employee.extraOrdinaryInitiativeRating}}
													</p></li>


												<li><b>Final Rating of (YEAR)</b>
													<p>
														<i class="fa fa-star"></i>&nbsp;{{employee.finalYearRating}}
													</p></li>

												<li><b>Total Tenure (Days)</b>
													<p>
														<i class="fa fa-calendar"></i>&nbsp;{{employee.totalTenure
														| dayTomonth}}
													</p></li>
											</ul>
										</div>
									</div>

									<hr>
									<div class="row">
										<div class="col-md-12">

											<ul class="list-inline customList">


												<li><b>Fixed Salary Per Year (Current)</b>
													<p>
														<i class="fa fa-inr"></i>&nbsp;{{employee.fixedSalaryPerYear | number}}
													</p></li>

												<li><b>Variable Amount Current Year</b>
													<p>
														<i class="fa fa-inr"></i>&nbsp;{{employee.variableAmountCurrentYear | number}}
													</p></li>

												<li><b>Current CTC (Year)</b>
													<p>
														<i class="fa fa-inr"></i>&nbsp;{{employee.currentCTCPerYear | number}}
													</p></li>


												<li><b>Current CTC (Month)</b>
													<p>
														<i class="fa fa-inr"></i>&nbsp;{{employee.currentCTCPerMonth | number}}
													</p></li>

												<li><b>Months (CURRENT DATE _ DOJ)</b>
													<p>
														<i class="fa fa-calendar"></i>&nbsp;{{employee.monthCurrentDateDOJ
														}} Months
													</p></li>
											</ul>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-3 col-md-offset-2">

											<div class="form-group">
												<label>Fixed Salary Per Month (Current)</label> <input
													type="text" class="form-control input-sm"
													ng-model="employee.fixedSalaryPerMonth"
													placeholder="Fixed Salary Per Year (Current)" required
													only-digits>

											</div>
										</div>
										<div class="col-md-2 col-sm-6">
											<div class="form-group">
												<label>Current Variable (%)</label> <input type="text"
													class="form-control input-sm" ng-model="employee.variable"
													placeholder="Variable" required only-digits>

											</div>
										</div>

										<div class="col-md-2 col-sm-6">
											<div class="form-group">
												<label>No Of Month for Bonus</label> <input type="text"
													class="form-control input-sm" ng-model="employee.totalmnth" name="totalmnth"
													placeholder="No Of Month for Bonus" required only-digits>

											</div>
										</div>



										<div class="col-md-3 col-sm-12" style="margin-top: 25px;">
											<div class="form-group">
												<label>&nbsp;</label>
												<button class="btn btn-success btn-sm wave-effect"
													ng-click="calculateBasicDetails()"
													ng-disabled="employee.finalYearRating=='null' || employee.finalYearRating=='null' || employee.totalmnth=='null'">
													<i class="fa fa-inr"></i>&nbsp;Calculate
												</button>
											</div>
										</div>





									</div>
									<hr>

								</div>

							</div>
							<div id="menu2" class="tab-pane fade">
								<div class="tab-ctn">




									<div class="row">
										<form name="myForm">
											<div class="col-md-7">
												<div class="form-group">
													<!-- 		<a class="word-export" href="javascript:void(0)"> Export as .doc </a> -->
													<div class="row">
														<div class="col-md-12">

															<ul class="list-inline  customList">
																<li><b>Employee Code</b><br>
																	<p>
																		<i class="fa fa-id-card-o"></i>&nbsp;{{employee.empCode}}
																	</p></li>

																<li><b>Assessment Year</b><br>
																	<p>
																		<i class="fa fa-calendar"></i>&nbsp;{{employee.assessmentYear}}
																	</p></li>

																<li><b>Employee Name</b><br>
																	<p>
																		<i class="fa fa-user"></i>&nbsp;{{employee.empName}}
																	</p></li>

																<li><b>Employee Basic(%)</b><br> <input
																	type="text" class="form-control input-sm"
																	ng-model="basic" ng-keyup="valueChange()" only-digits></li>

																<li><b>Document No</b><br> <input type="text"
																	class="form-control input-sm"
																	ng-model="employee.documentNo" name="documentNo" required="required" ng-style="myForm.documentNo.$invalid && {'border-color':'red'}"></li>
															</ul>


															<hr>
															<ul class="list-inline  customList">

																<li><b>Select spvs Category</b><br> <!-- <select class="form-control input-sm" ng-model="spvsId">
														<option ng-repeat="spvs in spvslist" value={{spvs.id}}>{{spvs.companyName}}</option>
														</select> --> <select ng-model="spvsId" name="spvsId"
																	ng-options="dp as dp.companyName  for dp in spvslist"
																	class="form-control input-sm" required
																	ng-style="myForm.spvsId.$invalid && {'border-color':'red'}">
																		<option value="">Please select</option>
																</select></li>


																<li><b>Select Increment Letter Category</b><br>
																	<select ng-model="incrementLetterDetailsId"
																	name="incrementLetterDetailsId"
																	ng-change="changeIncrementLetter()"
																	ng-options="incLetter as incLetter.name  for incLetter in incrementLetterDetails"
																	class="form-control input-sm" required
																	ng-style="myForm.incrementLetterDetailsId.$invalid && {'border-color':'red'}">
																		<option value="">Please select</option>
																</select></li>



																<li><b>Select Variable Type</b><br> <select
																	ng-model="variableTypeId" name="variableTypeId"
																	ng-options="variabletype as variabletype.variableTitle  for variabletype in testVariableType"
																	class="form-control input-sm" required
																	ng-style="myForm.variableTypeId.$invalid && {'border-color':'red'}">
																		<option value="">Please select</option>
																</select></li>
											
																
																
																
																
																<li ng-if="incrementLetterDetailsId.id==2"  style="padding-top: 15px;"><b>New Designation</b><br> <input type="text"
																	ng-model="employee.newDesignation" name="newDesignation"
																	class="form-control input-sm" required
																	ng-style="myForm.newDesignation.$invalid && {'border-color':'red'}">
																		</li>
																		
																		
																		<li style="padding-top: 15px;width: 160px;"><b>Car Lease</b><br> <select 
																		
																	ng-model="employee.carLease" name="carLease"
																	class="form-control input-sm" required
																	ng-style="myForm.carLease.$invalid && {'border-color':'red'}" ng-keyup="valueChange()">
																	<option value="Yes">Yes</option>
																	<option  value="No">No</option>
																	</select>
																	</li>
																	
																<!-- 	<li ng-if="employee.carLease=='Yes'"  style="padding-top: 15px;"><b>Car Lease Amount</b><br> 
																	<input type="text" only-digits ng-keyup="valueChange()"
																	ng-model="employee.carLeaseAmount" name="carLeaseAmount"
																	class="form-control input-sm" required
																	ng-style="myForm.carLeaseAmount.$invalid && {'border-color':'red'}" >
																		</li> -->

															</ul>
														</div>


													</div>
													<hr>

													<div class="row">
														<div class="col-md-12">

															<ul class="list-inline customList">


																<li><b>Variable to be disbursed</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.disbursedVariable | number}}
																	</p></li>

																<li><b>Variable ({{variable1}}%)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.variable33 | number}}
																	</p></li>

																<li><b>Variable ({{variable2}}%)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.variable67 | number}}
																	</p></li>


																<li><b>Company Variable Amount
																		({{companyVariable}} % )</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{newvariable33 | number}}
																	</p></li>

																<li><b>Employee Variable Amount
																		({{employeeRatingVariable}} % )</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{newvariable67 | number}}
																	</p></li>


																<li><b>No Of Months</b>
																	<p>
																		<i class="fa fa-calendar"></i>&nbsp;{{employee.totalmnth}}
																	</p></li>



																<li><label>Variable to be disbursed Z</label> <input
																	type="text" ng-model="employee.disbursedVariableZ"
																	name="disbursedVariableZ" class="form-control input-sm"
																	required="required"
																	ng-style="myForm.disbursedVariableZ.$invalid && {'border-color':'red'}"
																	ng-keyup="valueChange()" only-digits> <!-- <b>New Variable (%)</b>
													<p>
														<i class="fa fa-inr"></i>&nbsp;
														
														
														{{employee.newVariable}}
													</p> --></li>

																<li><b>Increment w.e.f April (2019) (%)</b>
																	<p>
																		<i class="fa fa-circle"></i>&nbsp;{{employee.incrementWEFApril| number}}
																	</p></li>


															</ul>
														</div>
													</div>

													<hr>
 
													<div class="row">
														<div class="col-md-12">

															<ul class="list-inline customList">


																<li><b>Increment amount</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.incrementAmount | number}}
																	</p></li>

																<li><b>New Fixed Salary (Per Year)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.newFixedSalaryPerYear | number}}
																	</p></li>

																<li><b>New Fixed Salary (Per Month)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.newFixedSalaryPerMonth | number}}
																	</p></li>


																<li><label>New Variable (%)</label> <input
																	type="text" ng-model="employee.newVariable"
																	name="newVariable" class="form-control input-sm"
																	required="required"
																	ng-style="myForm.newVariable.$invalid && {'border-color':'red'}"
																	ng-keyup="valueChange()" only-digits> <!-- <b>New Variable (%)</b>
													<p>
														<i class="fa fa-inr"></i>&nbsp;
														
														
														{{employee.newVariable}}
													</p> --></li>

																<li><b>New Variable (Per Year)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.newVariablePerYear | number}}
																	</p></li>




															</ul>
														</div>
													</div>
													<hr>
													<div class="row">
														<div class="col-md-12">

															<ul class="list-inline customList">
																<li><b>New CTC (Year)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.newCTCYear | number}}
																	</p></li>

																<li><b>New CTC (Month)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.newCTCMonth | number}}
																	</p></li>

																<li><b>Net Increase (Yearly)</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.netIncreaseYearly | number}}
																	</p></li>
																<li><b>Basic Salary</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.basicSalary | number}}
																	</p></li>

																<li><b>HR</b>
																	<p>
																		<i class="fa fa-inr"></i>&nbsp;{{employee.hr| number}}
																	</p></li>

															</ul>
														</div>
													</div>

													<hr>




													<div class="row">

														<div class="col-md-3">
															<div class="form-group">
																<label>Increment w.r.t Rating </label> <input
																	type="text"
																	ng-style="myForm.incrementWRTRating.$invalid && {'border-color':'red'}"
																	class="form-control input-sm" name="incrementWRTRating"
																	placeholder="Increment w.r.t Rating"
																	ng-model="employee.incrementWRTRating" required
																	readonly="readonly" ng-keyup="valueChange()"
																	only-digits>

															</div>
														</div>
														<div class="col-md-3">
															<div class="form-group">
																<label>Rationalisation/HR factor</label> <input
																	type="text"
																	ng-style="myForm.rationalizationHRFactor.$invalid && {'border-color':'red'}"
																	class="form-control input-sm"
																	placeholder="Rationalisation/HR factor"
																	ng-model="employee.rationalizationHRFactor"
																	name="rationalizationHRFactor" ng-keyup="valueChange()"
																	only-digits required>

															</div>
														</div>

														<div class="col-md-2">
															<div class="form-group">
																<label>Promotion</label> <input type="text"
																	ng-style="myForm.promotion.$invalid && {'border-color':'red'}"
																	class="form-control input-sm" placeholder="Promotion"
																	ng-model="employee.promotion" name="promotion"
																	ng-keyup="valueChange()" only-digits required>

															</div>
														</div>

														<div class="col-md-2">
															<div class="form-group">
																<label>Retention case</label> <input type="text"
																	ng-style="myForm.retention.$invalid && {'border-color':'red'}"
																	class="form-control input-sm"
																	placeholder="Retention case"
																	ng-model="employee.retention" name="retention"
																	ng-keyup="valueChange()" only-digits required>

															</div>
														</div>
														<div class="col-md-2" style="margin-top: 22px;">
															<div class="form-group">
																<button class="btn btn-success btn-sm"
																	ng-disabled="myForm.$invalid"
																	ng-click="calculateWithReqApril()">
																	<i class="fa fa-save"></i>&nbsp;Calculate
																</button>
															</div>
														</div>
													</div>
										</form>
										<hr>
									</div>
								</div>


								<div class="col-md-5" style="background-color: #F6F8FA;">
									<div class="form-group">

										<div class="row" style="text-align: left;">
											<div class="col-md-12">

												<table class="table table-bordered" id="page-content">

													<tbody>

														<tr>
															<td colspan="3"><h3>CTC BREAK-UP</h3></td>
														</tr>
														<tr>
															<td rowspan="2" style="width: 20%;">SALARY
																COMPONENTS</td>
															<td style="width: 10%;">MONTHLY</td>
															<td style="width: 10%;">ANNUAL</td>
														</tr>
														<tr>
															<td>INR</td>
															<td>INR</td>
														</tr>

														<tr>
															<td colspan="3"><b>(A) BASE SALARY</b></td>
														</tr>
														<tr>
															<td>Basic</td>
															<td>{{employee.basicSalary | number}}</td>
															<td>{{employee.basicSalary * 12 | numberEx:2}}</td>
														</tr>
														<tr>
															<td>HR</td>
															<td>{{employee.hr | number}}</td>
															<td>{{employee.hr * 12 | numberEx:2}}</td>
														</tr>
														<!-- <tr>
													<td>Transport Allowance</td>
													<td><input type="text" ng-model="employee.transportAllowance"
															class="form-control input-sm"></td>
													<td>{{employee.transportAllowance * 12 | numberEx:2}}</td>
													</tr> -->
														<tr>
															<td>Special Allowance</td>
															<td><input type="text"
																ng-model="employee.specialAllowance"
																class="form-control input-sm"
																only-digits></td>
															<td>{{employee.specialAllowance * 12 | numberEx:2}}</td>
														</tr>
														<tr>
															<td>Supplementary Allowance</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Supplementary Allowance"
																ng-model="employee.supplementaryAllowance"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.supplementaryAllowance * 12 |
																numberEx:2}}</td>
														</tr>
														<tr>
															<td>Children Education Allowance</td>
															<td><input type="text" class="form-control input-sm"
																ng-model="employee.childrenEducationAllowance"
																placeholder="Children Education Allowance"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.childrenEducationAllowance * 12 |
																numberEx:2}}</td>
														</tr>
														<tr>
															<td>PF (Company's share)</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Provident Fund" ng-model="employee.pf"
																only-digits></td>
															<td>{{employee.pf *12 | numberEx:2}}</td>
														</tr>
														<tr>
															<td>TOTAL</td>
															<td>{{parseInt(employee.basicSalary) +
																parseInt(employee.hr)+
																parseInt(employee.specialAllowance)+
																parseInt(employee.supplementaryAllowance)+
																parseInt(employee.childrenEducationAllowance)+
																parseInt(employee.pf) | number}}</td>
															<td>{{parseInt(employee.basicSalary * 12) +
																parseInt(employee.hr * 12)+
																parseInt(employee.specialAllowance * 12)+
																parseInt(employee.supplementaryAllowance* 12)+
																parseInt(employee.childrenEducationAllowance* 12)+
																parseInt(employee.pf * 12) | number}}</td>
														</tr>

														<tr>
															<td colspan="3"><b>(B) REIMBURSABLE (bills to be
																	submitted as instructed)</b></td>
														</tr>

														<!-- <tr>
															<td>Medical</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Medical" ng-model="employee.medical"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.medical *12 | numberEx:2}}</td>
														</tr> -->
														<tr>
															<td>Residential Telephone</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Resident Telephone"
																ng-model="employee.residentTelephone"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.residentTelephone * 12| numberEx:2 }}</td>
														</tr>
														<tr>
															<td>Attire</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Attire" ng-model="employee.attire"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.attire * 12 | numberEx:2}}</td>
														</tr>

														<tr>
															<td>News paper, Books and periodicals</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Newspaper" ng-model="employee.newspaper"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.newspaper * 12 | numberEx:2}}</td>
														</tr>

														<tr>
															<td colspan="3"><b>(C) TAXABLE COMPONENT
																	(reimbursable as per law))</b></td>
														</tr>
														<tr>
															<td>LTA (1 basic)</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="LTA" ng-model="employee.lta"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.lta * 12 | numberEx:2}}</td>

														</tr>


														<tr>
															<td colspan="3"><b>(D) ELIGIBILITY AS PER
																	COMPANY POLICY))</b></td>
														</tr>
														<tr>
															<td>Gratuity</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Gratuity" ng-model="employee.gratuity"
																only-digits readonly="readonly"></td>
															<td>{{employee.gratuity * 12 | numberEx:2}}</td>

														</tr>
														
														
														<tr ng-if="employee.carLease=='Yes'">
															<td colspan="3"><b>(E) Car Lease with the Third Party purely for official purposes</b></td>
														</tr>
														<tr ng-if="employee.carLease=='Yes'">
															<td>Payment towards Car Lease</td>
															<td><input type="text" class="form-control input-sm"
																placeholder="Car Lease" ng-model="employee.carLeaseAmount"
																ng-keyup="valueChange()" only-digits></td>
															<td>{{employee.carLeaseAmount * 12 | numberEx:2}}</td>

														</tr>
														
														
														<tr ng-if="employee.carLease=='Yes'">
															<td>FIXED CTC (A+B+C+D+E)</td>
															<!-- <td>{{parseInt(employee.basicSalary) +
																parseInt(employee.hr)+
																parseInt(employee.specialAllowance)+
																parseInt(employee.supplementaryAllowance)+
																parseInt(employee.childrenEducationAllowance)+
																parseInt(employee.pf)+
																parseInt(employee.residentTelephone)+
																parseInt(employee.attire)+ parseInt(employee.newspaper)+
																parseInt(employee.lta)+ parseInt(employee.gratuity)+ parseInt(employee.carLeaseAmount) | number}}</td>
														 -->	
														 <td>{{parseInt(employee.newFixedSalaryPerMonth) | number}}</td>	
															<td>{{employee.newFixedSalaryPerYear | number}}</td>
														</tr>
														
														<tr ng-if="employee.carLease=='No'">
															<td>FIXED CTC (A+B+C+D)</td>
															<!-- <td>{{parseInt(employee.basicSalary) +
																parseInt(employee.hr)+
																parseInt(employee.specialAllowance)+
																parseInt(employee.supplementaryAllowance)+
																parseInt(employee.childrenEducationAllowance)+
																parseInt(employee.pf)+
																parseInt(employee.residentTelephone)+
																parseInt(employee.attire)+ parseInt(employee.newspaper)+
																parseInt(employee.lta)+ parseInt(employee.gratuity) | number}}</td>
															 -->
															<td>{{employee.newFixedSalaryPerMonth | number}}</td>	
															<td>{{employee.newFixedSalaryPerYear | number}}</td>
														</tr>
														<!-- <tr ng-if="employee.department !='Solar Rooftop'">
															<td colspan="2">Variable Pay <br>(One time
																payment to be disbursed as per Company Policy)
															</td>
															<td>{{employee.variableAmountCurrentYear}}</td>

														</tr>

														<tr ng-if="employee.department =='Solar Rooftop'">
															<td colspan="2">Sales incentive pay <br>(One
																time payment to be disbursed as per Company Policy)
															</td>
															<td>{{employee.variableAmountCurrentYear}}</td>

														</tr> -->

														<tr ng-if="variableTypeId.id !='3'">
															<td colspan="2">(
																{{variableTypeId.variableDescription}} )<br>(One
																time payment to be disbursed as per Company Policy)
															</td>
															<td>{{employee.newVariablePerYear | number}}</td>

														</tr>
														<tr  ng-if="variableTypeId.id !='3' &&  employee.carLease=='No'" >
															<td colspan="2">TOTAL CTC in INR (FIXED CTC +
																{{variableTypeId.variableDescription}})</td>
															<!-- <td>{{parseInt(employee.basicSalary) +
																parseInt(employee.hr)+
																parseInt(employee.specialAllowance)+
																parseInt(employee.supplementaryAllowance)+
																parseInt(employee.childrenEducationAllowance)+
																parseInt(employee.pf)+
																parseInt(employee.residentTelephone)+
																parseInt(employee.attire)+ parseInt(employee.newspaper)+
																parseInt(employee.lta)+ parseInt(employee.gratuity)+
																parseInt(employee.variableAmountCurrentYear) | number}}</td> -->
															<td>{{parseInt(employee.newFixedSalaryPerYear) +
																parseInt(employee.newVariablePerYear) | number}}</td>
														</tr>
														
														<tr ng-if="variableTypeId.id !='3' &&  employee.carLease=='Yes'">
															<td colspan="2">TOTAL CTC in INR (FIXED CTC +
																{{variableTypeId.variableDescription}})</td>
														<!-- 	<td>{{parseInt(employee.basicSalary) +
																parseInt(employee.hr)+
																parseInt(employee.specialAllowance)+
																parseInt(employee.supplementaryAllowance)+
																parseInt(employee.childrenEducationAllowance)+
																parseInt(employee.pf)+
																parseInt(employee.residentTelephone)+
																parseInt(employee.attire)+ parseInt(employee.newspaper)+
																parseInt(employee.lta)+ parseInt(employee.gratuity)+
																parseInt(employee.variableAmountCurrentYear)+
																parseInt(employee.carLeaseAmount) | number}}</td> -->
															<td>{{parseInt(employee.newFixedSalaryPerYear) +
																parseInt(employee.newVariablePerYear) | number}}</td>
														</tr>
														<tr ng-if="variableTypeId.id =='3' &&  employee.carLease=='Yes'">
															<td colspan="2">TOTAL CTC in INR (FIXED CTC)</td>
															<!-- <td >{{parseInt(employee.basicSalary) +
																parseInt(employee.hr)+
																parseInt(employee.specialAllowance)+
																parseInt(employee.supplementaryAllowance)+
																parseInt(employee.childrenEducationAllowance)+
																parseInt(employee.pf)+
																parseInt(employee.residentTelephone)+
																parseInt(employee.attire)+ parseInt(employee.newspaper)+
																parseInt(employee.lta)+ parseInt(employee.gratuity)+ parseInt(employee.carLeaseAmount) | number}}</td>
															 --><td>{{employee.newFixedSalaryPerYear | number}}</td>
														</tr>
                                                  <tr ng-if="variableTypeId.id =='3' &&  employee.carLease=='No'">
															<td colspan="2">TOTAL CTC in INR (FIXED CTC)</td>
															<!-- <td>{{parseInt(employee.basicSalary) +
																parseInt(employee.hr)+
																parseInt(employee.specialAllowance)+
																parseInt(employee.supplementaryAllowance)+
																parseInt(employee.childrenEducationAllowance)+
																parseInt(employee.pf)+
																parseInt(employee.residentTelephone)+
																parseInt(employee.attire)+ parseInt(employee.newspaper)+
																parseInt(employee.lta)+ parseInt(employee.gratuity) | number}}</td> -->
															<td>{{employee.newFixedSalaryPerYear | number}}</td>
														</tr>


														<tr>
															<td colspan="3">
																<ul class="list-inline" style="padding-top: 10px;">

																	<li>
																		<p>
																			<button class="btn btn-success btn-sm"
																				ng-click="save()" ng-disabled="myForm.$invalid">
																				<i class="fa fa-save"></i>&nbsp;Save
																			</button>
																		</p>
																	</li>
																</ul>
															</td>
														</tr>
													</tbody>
												</table>

























												<!-- <h5>BASE SALARY</h5>
											<ul class="list-inline customList">


												<li><b>Travel Allowance</b>
													<p>
														<input type="text" ng-model="employee.transportAllowance"
															class="form-control input-sm">
													</p></li>

												<li><b>Special Allowance</b>
													<p>
														<input type="text" ng-model="employee.specialAllowance"
															class="form-control input-sm">
													</p></li>

												<li><b>Supplementary Allowance</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Supplementary Allowance"
															ng-model="employee.supplementaryAllowance">
													</p></li>
												<li><b>Children Education</b>
													<p>
														<input type="text" class="form-control input-sm"
															ng-model="employee.childrenEducationAllowance"
															placeholder="Children Education Allowance">
													</p></li>

												<li><b>PF (Company's share)</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Provident Fund" ng-model="employee.pf">
													</p></li>




											</ul> -->
											</div>
										</div>
									</div>
								</div>


							</div>






							<hr>


							<!-- 	<div class="row">
										<div class="col-md-12">
											<h5>REIMBURSABLE</h5>
											<ul class="list-inline customList">
												<li><b>Medical</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Medical" ng-model="employee.medical">
													</p></li>

												<li><b>Residential Telephone</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Resident Telephone"
															ng-model="employee.residentTelephone">
													</p></li>

												<li><b>Attire</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Attire" ng-model="employee.attire">
													</p></li>

												<li><b>News paper,Books,periodicals</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Newspaper" ng-model="employee.newspaper">
													</p></li>

												<li><b>Books</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Supplementary Allowance"
															ng-model="employee.supplementaryAllowance">
													</p></li>
												<li><b>periodicals</b>
													<p>
														<input type="text" class="form-control input-sm"
															ng-model="employee.childrenEducationAllowance"
															placeholder="Children Education Allowance">
													</p></li>

											




											</ul>
										</div>
									</div>
									<hr> -->

							<!-- <div class="row">
										<div class="col-md-3">
											<h5>TAXABLE COMPONENT</h5>
											<ul class="list-inline customList">
												<li><b>LTA</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="LTA" ng-model="employee.lta">
													</p></li>
											</ul>
										</div>

										<div class="col-md-9">
											<h5>ELIGIBILITY AS PER COMPANY POLICY))</h5>
											<ul class="list-inline customList">
												<li><b>Gratuity</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Gratuity" ng-model="employee.gratuity">
													</p></li>


												<li><b>Variable Pay</b>
													<p>
														<input type="text" class="form-control input-sm"
															placeholder="Variable Pay"
															ng-model="employee.variablePay">
													</p></li>


												<li>
													<p>
														<button class="btn btn-success btn-sm"
															ng-click="calculateWithReqApril()">
															<i class="fa fa-save"></i>&nbsp;Calculate
														</button>
													</p>
												</li>

												<li>
													<p>
														<button class="btn btn-success btn-sm" ng-click="save()">
															<i class="fa fa-save"></i>&nbsp;Save
														</button>
													</p>
												</li>
											</ul>
										</div>
									</div>
									<hr> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- End tabs area-->