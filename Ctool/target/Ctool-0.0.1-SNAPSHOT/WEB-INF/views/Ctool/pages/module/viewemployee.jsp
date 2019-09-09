
   <div class="data-table-area data-table-list" ng-init="getDataOnLoad()">
                        <div class="basic-tb-hd">
                            <h2><i class="fa fa-users"></i>&nbsp;Employees Information</h2>
                         
                        </div>
                          <div class="table-responsive">
                            <table id="example"  class="table table-striped">
                            
                           <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th style="width: 15%;">Name</th>
                 <th style="width: 10%;">Employee Code</th>
                  <th style="width: 10%;">Assessment Year</th>
                 <th  style="width: 16%;">Department</th>
                  <th style="width: 20%;">Designation</th>
                  <th style="width: 10%;">Created On</th>
                  <th style="width: 10%;">Modified On</th>
                  <th style="width: 10%;">Action</th>
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-repeat="employee in employeeListData | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{employee.empName}}</td>
                 <td>{{employee.empCode}}</td>
                  <td>{{employee.assessmentYear}}</td>
                  <td>{{employee.department}}</td>
                  <td>{{employee.designation}}</td>
                  <td>{{employee.createdOn | date :  "yyyy-MM-dd" }}</td>
               <td>{{employee.modifiedOn | date :  "yyyy-MM-dd" }}</td>
               <td><button  class="btn btn-success btn-xs waves-effect" data-type="success" ng-disabled="employee.kra==''" ng-model="employee.checked" ng-click="modifyEmployee(employee)" ><i class="fa fa-edit"></i></button> | <button class="btn btn-danger waves-effect btn-xs" ng-model="employee.checked"  ng-click="deleteEmployee(employee)"><i class="fa fa-trash"></i></button></td>
                </tr>
               
                </tbody>
               
                            </table>
                            </div>
                        </div>







































<!-- <style>
.ui-grid {
	height: 480px;
}
</style>
<section class="content" >
	<img alt="" src="/Ctool/resources/image/loading.gif" style="z-index: 4"
		ng-show="pageloader" id="pageloader" height="100" width="100">
	<div class="box box-primary" style="min-height: 380px;">
	
			<div class="box-header with-border">
			<h3 class="box-title"><i class="fa fa-users"></i>&nbsp;&nbsp;Employee List</h3>
		</div>
		<div class="box-body">
			<div id="grid1" ui-grid="gridOptions" class="gridStyle"
				ui-grid-auto-resize style="margin-top: 5px;" ui-grid-exporter></div>
				
				 <div class="table-responsive mailbox-messages">
              <table id="example" class="table table-bordered table-striped" >
                <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th>Name</th>
                 <th>Employee Code</th>
                 <th>Department</th>
                  <th>Designation</th>
                  <th>Created On</th>
                  <th>Action</th>
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-repeat="employee in employeeListData | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{employee.empName}}</td>
                 <td>{{employee.empCode}}</td>
                  <td>{{employee.department}}</td>
                  <td>{{employee.designation}}</td>
                 
                  <td>{{employee.createdOn | date :  "yyyy-MM-dd" }}</td>
               <td><button class="btn btn-success btn-xs"  ng-disabled="employee.kra==''" ng-model="employee.checked" ng-click="modifyEmployee(employee)" ><i class="fa fa-edit"></i></button> | <button class="btn btn-danger btn-xs" ng-model="employee.checked"  ng-click="deleteEmployee(employee.id)"><i class="fa fa-trash"></i></button></td>
                </tr>
               
                </tbody>
               
              </table>
              </div>
		</div>
		</div>
</section>

 -->