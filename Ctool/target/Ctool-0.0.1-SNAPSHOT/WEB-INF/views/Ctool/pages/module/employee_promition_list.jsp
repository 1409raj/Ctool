<!-- <div class="breadcomb-area" ng-init="getDataOnLoad()">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcomb-list">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="breadcomb-wp">
									<div class="breadcomb-icon">
										<i class="fa fa-users"></i>
									</div>
									<div class="breadcomb-ctn">
										<h2>Tabs</h2>
										<p>Welcome to Notika <span class="bread-ntd">Admin Template</span></p>
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-3">
								<div class="breadcomb-report">
									<button data-toggle="tooltip" data-placement="left" title="Download Report" class="btn"><i class="notika-icon notika-sent"></i></button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	<!-- Breadcomb area End-->
    <!-- Start tabs area-->
    <div class="tabs-info-area" ng-init="getDataOnLoad()">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="widget-tabs-int">
                        <div class="tab-hd">
                            <h2>Promotion List</h2>
                          
                        </div>
                        <div class="widget-tabs-list">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" data-target="#home"><i class="fa fa-users" style="color: blue;"></i> &nbsp;Not Generated</a></li>
                                <li><a data-toggle="tab" data-target="#menu1"><i class="fa fa-users" style="color: green;"></i> &nbsp;Generated</a></li>
                              
                            </ul>
                            <div class="tab-content tab-custom-st">
                                <div id="home" class="tab-pane fade in active">
                                    <div class="tab-ctn">
                                        <div class="row">
                                       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                       <div class="form-example-int">
                            <div class="form-group">
                                
                                <div class="nk-int-st">
                                    <input type="text" class="form-control input-sm" placeholder="Type to search" ng-model="search">
                                </div>
                            </div>
                        </div>
                        </div>
                                       </div>
                             <div class="table-responsive">
                            <table id="#example"  class="table table-striped">
                             <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th>Name</th>
                 <th>Employee Code</th>
                 <th>Department</th>
                  <th>Designation</th>
                  <th>Created On</th>
                  <th>Modified On</th>
                  <!-- <th>Action</th> -->
                </tr>
                
                </thead>
                
                <tbody>
                <tr ng-if="employeePromtionListnotgenerated.length=='0'">
                <td colspan="7" style="text-align: center;">No Data Available</td>
                </tr>
                <tr ng-repeat="employee in employeePromtionListnotgenerated | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{employee.empName}}</td>
                 <td>{{employee.empCode}}</td>
                  <td>{{employee.department}}</td>
                  <td>{{employee.designation}}</td>
                 
                  <td>{{employee.createdOn | date :  "yyyy-MM-dd hh:mm:ss" }}</td>
                  <td>{{employee.modifiedOn | date :  "yyyy-MM-dd hh:mm:ss" }}</td>
                 <!--  <td><button  class="btn btn-danger notika-btn-danger waves-effect btn-xs" ng-model="employee.checked" ng-click="generatePDF1()" ><i class="fa fa-file-pdf-o"></i></button> 
                  | <button class="btn btn-primary notika-btn-danger waves-effect btn-xs" ng-model="employee.checked"  ng-click="generateWord(employee)"><i class="fa fa-file-word-o"></i></button></td>
                </tr> -->
               
                </tbody>
               
                            </table>
                         
                            </div>
                                 <div class="row" ng-if="employeePromtionListnotgenerated.length >'0'">
			<div class="col-md-2 form-group">
		<button class="btn btn-danger notika-btn-danger waves-effect" ng-click="generatePDF()"
					ng-disabled="employeePromtionListnotgenerated.length=='0'">
					<i class="fa fa-file-pdf-o"></i> &nbsp;Generate PDF
				</button>
			</div>	
				<div class="col-md-2 form-group">
				<button class="btn btn-primary notika-btn-danger waves-effect" ng-click="generateWord()"
					ng-disabled="employeePromtionListnotgenerated.length=='0'">
					<i class="fa fa-file-word-o"></i> &nbsp;Generate Word
				</button>
		</div> 
		</div>       
                                       
                                       
                                        </div>
                                </div>
                                <div id="menu1" class="tab-pane fade">
                                    <div class="tab-ctn">
                                     <div class="row">
                                       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                       <div class="form-example-int">
                            <div class="form-group">
                                
                                <div class="nk-int-st">
                                    <input type="text" class="form-control input-sm" placeholder="Type to search" ng-model="search">
                                </div>
                            </div>
                        </div>
                        </div>
                                       </div>
                                       <div class="table-responsive">
                                      
                                     <table id="example1" class="table table-striped" >
                <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th>Name</th>
                 <th>Employee Code</th>
                 <th>Department</th>
                  <th>Designation</th>
                   <th>Updated On</th>
                  <th>Created On</th>
                 
                </tr>
                
                </thead>
                
                <tbody>
                <tbody>
                <tr ng-if="employeePromtionListgenerated.length=='0'">
                <td colspan="6" style="text-align: center;">No Data Available</td>
                </tr>
                <tr ng-repeat="employeegen in employeePromtionListgenerated | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{employeegen.empName}}</td>
                 <td>{{employeegen.empCode}}</td>
                  <td>{{employeegen.department}}</td>
                  <td>{{employeegen.designation}}</td>
                  <td>{{employeegen.modifiedOn | date :  "yyyy-MM-dd hh:mm:ss" }}</td>
                   <td>{{employeegen.createdOn | date :  "yyyy-MM-dd hh:mm:ss" }}</td>
                </tr>
               
                </tbody>
               
              </table>
              </div>
                                           </div>
                                </div>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
           
        </div>
    </div>